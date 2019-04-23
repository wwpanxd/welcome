package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 宿舍楼宇信息表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:54:52
 */
@ApiModel(value = "BuildDO", description = "宿舍楼宇信息表") 
public class BuildDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//父级ID
	@ApiModelProperty(value = "父级ID")
	private Integer parentId;
	//楼宇名称
	@ApiModelProperty(value = "楼宇名称")
	private String bname;
	//楼宇地址
	@ApiModelProperty(value = "楼宇地址")
	private String baddress;
	//楼宇级别
	@ApiModelProperty(value = "楼宇级别")
	private Integer bLevel;
	//建筑类型(宿舍、其他)
	@ApiModelProperty(value = "建筑类型(宿舍、其他)")
	private Integer bType;
	//楼层
	@ApiModelProperty(value = "楼层")
	private String bStorey;
	//宿舍类型(男/女/混合)
	@ApiModelProperty(value = "宿舍类型(男/女/混合)")
	private Integer bSort;
	//宿舍编号
	@ApiModelProperty(value = "宿舍编号")
	private String dCode;
	//学生ID
	@ApiModelProperty(value = "学生ID")
	private Integer sId;
	//宿舍管理人ID
	@ApiModelProperty(value = "宿舍管理人ID")
	private Integer dmId;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：学校唯一编码
	 */
	public void setUvCode(Integer uvCode) {
		this.uvCode = uvCode;
	}
	/**
	 * 获取：学校唯一编码
	 */
	public Integer getUvCode() {
		return uvCode;
	}
	/**
	 * 设置：父级ID
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父级ID
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * 设置：楼宇名称
	 */
	public void setBname(String bname) {
		this.bname = bname;
	}
	/**
	 * 获取：楼宇名称
	 */
	public String getBname() {
		return bname;
	}
	/**
	 * 设置：楼宇地址
	 */
	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}
	/**
	 * 获取：楼宇地址
	 */
	public String getBaddress() {
		return baddress;
	}
	/**
	 * 设置：楼宇级别
	 */
	public void setBLevel(Integer bLevel) {
		this.bLevel = bLevel;
	}
	/**
	 * 获取：楼宇级别
	 */
	public Integer getBLevel() {
		return bLevel;
	}
	/**
	 * 设置：建筑类型(宿舍、其他)
	 */
	public void setBType(Integer bType) {
		this.bType = bType;
	}
	/**
	 * 获取：建筑类型(宿舍、其他)
	 */
	public Integer getBType() {
		return bType;
	}
	/**
	 * 设置：楼层
	 */
	public void setBStorey(String bStorey) {
		this.bStorey = bStorey;
	}
	/**
	 * 获取：楼层
	 */
	public String getBStorey() {
		return bStorey;
	}
	/**
	 * 设置：宿舍类型(男/女/混合)
	 */
	public void setBSort(Integer bSort) {
		this.bSort = bSort;
	}
	/**
	 * 获取：宿舍类型(男/女/混合)
	 */
	public Integer getBSort() {
		return bSort;
	}
	/**
	 * 设置：宿舍编号
	 */
	public void setDCode(String dCode) {
		this.dCode = dCode;
	}
	/**
	 * 获取：宿舍编号
	 */
	public String getDCode() {
		return dCode;
	}
	/**
	 * 设置：学生ID
	 */
	public void setSId(Integer sId) {
		this.sId = sId;
	}
	/**
	 * 获取：学生ID
	 */
	public Integer getSId() {
		return sId;
	}
	/**
	 * 设置：宿舍管理人ID
	 */
	public void setDmId(Integer dmId) {
		this.dmId = dmId;
	}
	/**
	 * 获取：宿舍管理人ID
	 */
	public Integer getDmId() {
		return dmId;
	}
}
