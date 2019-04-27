package com.bootdo.welcome.vo.admin;

import java.util.List;

import com.bootdo.welcome.domain.admin.YXMenuDO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="EnterpriseMenuVO",description="学校菜单权限列表")
public class EnterpriseMenuVO {

	@ApiModelProperty(value="企业学校ID")
	Long id;
	
	@ApiModelProperty(value="企业学校菜单权限列表")
	List<YXMenuDO> menus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<YXMenuDO> getMenus() {
		return menus;
	}

	public void setMenus(List<YXMenuDO> menus) {
		this.menus = menus;
	}
	
	

}
