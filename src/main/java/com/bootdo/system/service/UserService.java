package com.bootdo.system.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.*;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.*;
import com.bootdo.system.vo.UserVO;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootdo.common.domain.Tree;
import com.bootdo.common.exception.ExceptionHandler;
import com.bootdo.common.exception.ValidateCode;
import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.system.dao.DeptDao;
import com.bootdo.system.dao.UserDao;
import com.bootdo.system.dao.UserRoleDao;
import com.bootdo.system.domain.DeptDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.domain.UserRoleDO;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

//@CacheConfig(cacheNames = "user")
@Transactional
@Service
public class UserService  {
    @Autowired
    UserDao userMapper;
    @Autowired
    UserRoleDao userRoleMapper;
    @Autowired
    DeptDao deptMapper;
    @Autowired
    private FileService sysFileService;
    @Autowired
    private BootdoConfig bootdoConfig;
    
	@Autowired
	ValidateMessage validateMessage;
	
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    
//    @Cacheable(key = "#id")
    public UserDO get(Long id) {
        List<Long> roleIds = userRoleMapper.listRoleId(id);
        UserDO user = userMapper.findOneById(id);
        DeptDO depd=deptMapper.findOneById(user.getDeptId());
        if(depd!=null)
        user.setDeptName(depd.getName());
        user.setRoleIds(roleIds);
        return user;
    }

    
    public List<UserDO> list(Map<String, Object> map) {
        return userMapper.findPageListByMap(map);
    }
    
	
	public List<UserDO> list2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.list2(map);
	}

    
    public int count(Map<String, Object> map) {
        return userMapper.countByMap(map);
    }

    @Transactional
    public int save(UserDO user) {
        int count = userMapper.save(user);
        Long userId = user.getUserId();
        List<Long> roles = user.getRoleIds();
        userRoleMapper.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        if(roles!=null) {
        for (Long roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        }
        if (list.size() > 0) {
            userRoleMapper.batchSave(list);
        }
        return count;
    }

    
    public int update(UserDO user) {
        int r = userMapper.updateById(user);
        Long userId = user.getUserId();
        List<Long> roles = user.getRoleIds();
        userRoleMapper.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        if(roles!=null) {
        for (Long roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        }
        if (list.size() > 0) {
            userRoleMapper.batchSave(list);
        }
        return r;
    }

    
    public int remove(Long userId) {
        userRoleMapper.removeByUserId(userId);
        return userMapper.removeById(userId);
    }

    
    public boolean exit(Map<String, Object> params) {
        boolean exit;
        exit = userMapper.findPageListByMap(params).size() > 0;
        return exit;
    }

    
    public boolean exit2(Map<String, Object> params) {
        int count=0;
        count = userMapper.count2(params);
        if(count>0)
        return true;
        else return false;
    }
    
    public Set<String> listRoles(Long userId) {
        return null;
    }

    
    public int resetPwd(UserVO userVO, UserDO userDO) throws Exception {
            if (Objects.equals(MD5Utils.encrypt(userDO.getUsername(), userVO.getPwdOld()), userDO.getPassword())) {
                userDO.setPassword(MD5Utils.encrypt(userDO.getUsername(), userVO.getPwdNew()));
                return userMapper.updateById(userDO);
            } else {
            	ExceptionHandler.handle(validateMessage.getBusinessError(ValidateCode.LOGIN_ERROR));
                throw new Exception("输入的旧密码有误！");
            }
    }

    public int adminResetPwd(UserVO userVO) throws Exception {
        UserDO userDO = get(userVO.getUserid());
        if ("admin".equals(userDO.getUsername())) {
            throw new Exception("超级管理员的账号不允许直接重置！");
        }
        userDO.setPassword(MD5Utils.encrypt(userDO.getUsername(), userVO.getPwdNew()));
        return userMapper.updateById(userDO);


    }

    @Transactional
    public int batchRemove(Long[] userIds) {
        int count = userMapper.batchRemoveByIds(userIds);
        userRoleMapper.batchRemoveByUserId(userIds);
        return count;
    }

    
    public Tree<DeptDO> getTree() {
        List<Tree<DeptDO>> trees = new ArrayList<Tree<DeptDO>>();
        List<DeptDO> depts = deptMapper.findPageListByMap(new HashMap<String, Object>(16));
        Long[] pDepts = deptMapper.listParentDept();
        Long[] uDepts = userMapper.listAllDept();
        Long[] allDepts = (Long[]) ArrayUtils.addAll(pDepts, uDepts);
        for (DeptDO dept : depts) {
            if (!ArrayUtils.contains(allDepts, dept.getDeptId())) {
                continue;
            }
            Tree<DeptDO> tree = new Tree<DeptDO>();
            tree.setId(dept.getDeptId().toString());
            tree.setParentId(dept.getParentId().toString());
            tree.setText(dept.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            state.put("mType", "dept");
            tree.setState(state);
            trees.add(tree);
        }
        List<UserDO> users = userMapper.findPageListByMap(new HashMap<String, Object>(16));
        for (UserDO user : users) {
            Tree<DeptDO> tree = new Tree<DeptDO>();
            tree.setId(user.getUserId().toString());
            tree.setParentId(user.getDeptId().toString());
            tree.setText(user.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            state.put("mType", "user");
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<DeptDO> t = BuildTree.build(trees);
        return t;
    }

    
    public int updatePersonal(UserDO userDO) {
        return userMapper.updateById(userDO);
    }

    
    public Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception {
        String fileName = file.getOriginalFilename();
        fileName = FileUtil.renameToUUID(fileName);
        FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
        //获取图片后缀
        String prefix = fileName.substring((fileName.lastIndexOf(".") + 1));
        String[] str = avatar_data.split(",");
        //获取截取的x坐标
        int x = (int) Math.floor(Double.parseDouble(str[0].split(":")[1]));
        //获取截取的y坐标
        int y = (int) Math.floor(Double.parseDouble(str[1].split(":")[1]));
        //获取截取的高度
        int h = (int) Math.floor(Double.parseDouble(str[2].split(":")[1]));
        //获取截取的宽度
        int w = (int) Math.floor(Double.parseDouble(str[3].split(":")[1]));
        //获取旋转的角度
        int r = Integer.parseInt(str[4].split(":")[1].replaceAll("}", ""));
        try {
            BufferedImage cutImage = ImageUtils.cutImage(file, x, y, w, h, prefix);
            BufferedImage rotateImage = ImageUtils.rotateImage(cutImage, r);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            boolean flag = ImageIO.write(rotateImage, prefix, out);
            //转换后存入数据库
            byte[] b = out.toByteArray();
            FileUtil.uploadFile(b, bootdoConfig.getUploadPath(), fileName);
        } catch (Exception e) {
            throw new Exception("图片裁剪错误！！");
        }
        Map<String, Object> result = new HashMap<>();
        if (sysFileService.save(sysFile) > 0) {
            UserDO userDO = new UserDO();
            userDO.setUserId(userId);
            userDO.setPicId(sysFile.getId());
            if (userMapper.updateById(userDO) > 0) {
                result.put("url", sysFile.getUrl());
            }
        }
        return result;
    }



}
