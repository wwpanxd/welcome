package com.bootdo.welcome.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bootdo.welcome.domain.WordsDO;
import com.bootdo.welcome.service.WordsService;
import com.bootdo.welcome.utils.RF;

import io.swagger.annotations.ApiOperation;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.FileUtil;
import com.bootdo.common.utils.ImportExcelUtils;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 英语单词记录表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-06 19:13:17
 */
 
@Controller
@RequestMapping("/learns/words")
public class WordsController extends BaseController{
	@Autowired
	private WordsService wordsService;
	
	@GetMapping()
	@RequiresPermissions("learns:words:words")
	String Words(){
	    return "learns/words/words";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("learns:words:words")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WordsDO> wordsList = wordsService.list(query);
		int total = wordsService.count(query);
		PageUtils pageUtils = new PageUtils(wordsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("learns:words:add")
	String add(){
	    return "learns/words/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("learns:words:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		WordsDO words = wordsService.get(id);
		model.addAttribute("words", words);
	    return "learns/words/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("learns:words:add")
	public R save( WordsDO words){
		if(words.getAtime()==null) words.setAtime(new Date(System.currentTimeMillis()));
		if(wordsService.save(words)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("learns:words:edit")
	public R update( WordsDO words){
		wordsService.update(words);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("learns:words:remove")
	public R remove( Integer id){
		if(wordsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("learns:words:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		wordsService.batchRemove(ids);
		return R.ok();
	}
	
	
	@Log("Excel上传,单词导入")
	@PostMapping("/uploadexcel")
	@ResponseBody
	@ApiOperation(value="Excel上传,单词导入", notes="单个文件上传,MultipartFile 的 file")
	RF upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		
		try {
			String	fileName = FileUtil.renameToUUID(file.getOriginalFilename());
			
		        List<List<Object>> listob = null;
		        if(file.isEmpty()){
		        	return  new RF(1,"请选择要导入的EXCEL",null);
		        }
		        InputStream  in = file.getInputStream();
		        //创建Excel工作薄
		        Workbook work = ImportExcelUtils.getWorkbook(in,fileName);
		        if(null == work){
		        	return  new RF(1,"导入的EXCEL是空文件",null);
		        }
		        Sheet sheet = null;
		        Row row = null;
		        Cell cell = null;
		        
		     List<WordsDO> wlist= new ArrayList<WordsDO>();
		        //遍历Excel中所有的sheet
		        int s=work.getNumberOfSheets();
		        for (int i = 0; i < work.getNumberOfSheets(); i++) {
		            sheet = work.getSheetAt(i);
		            if(sheet==null){continue;}
		            int s2=sheet.getLastRowNum();
		            //遍历当前sheet中的所有行
		            for (int j = sheet.getFirstRowNum()+1; j <= sheet.getLastRowNum(); j++) {
		            	
		                row = sheet.getRow(j);
//		                if(row==null||row.getFirstCellNum()==j){continue;}
		                //遍历所有的列
		                WordsDO li = new WordsDO();
		                int y = row.getFirstCellNum();
		                if(row.getCell(y)!=null)
		                li.setEwords(row.getCell(y).getStringCellValue());
		                if(row.getCell(y+1)!=null)
		                li.setSwords(row.getCell(y+1).getStringCellValue());
		                if(row.getCell(y+2)!=null)
		                li.setCwords(row.getCell(y+2).getStringCellValue());
		                li.setTcode("CET4");
		                li.setAtime(new Date());
		                wlist.add(li);
		            }
		        }
		        work.close();
		        in.close();
		        
		    //导入数据
		        for(WordsDO wordsdo:wlist) {
		        	wordsService.save(wordsdo);
		        }
			  
		} catch (Exception e) {
			return  new RF(1,"Excel导入失败,"+e.getMessage(),null);
		}
		
		return new RF(0,"上传成功",null);
	}
}
