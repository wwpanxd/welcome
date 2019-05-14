package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 宿舍表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-14 13:43:11
 */
@ApiModel(value = "DormitoryDO", description = "宿舍表") 
public class DormitoryDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校唯一编码(100000:公共机构)
	@ApiModelProperty(value = "学校唯一编码(100000:公共机构)")
	private Integer uvCode;
	//父级ID
	@ApiModelProperty(value = "父级ID")
	private Integer parentId;
	//宿舍名称
	@ApiModelProperty(value = "宿舍名称")
	private String dName;
	//宿舍编号
	@ApiModelProperty(value = "宿舍编号")
	private String dCode;
	//级别(宿舍、床位)
	@ApiModelProperty(value = "级别(宿舍、床位)")
	private Integer dLevel;
	//排序
	@ApiModelProperty(value = "排序")
	private Integer dSort;
	//学生ID
	@ApiModelProperty(value = "学生ID")
	private Integer sId;
	//宿舍管理人ID
	@ApiModelProperty(value = "宿舍管理人ID")
	private Integer dmId;
	//归属楼宇
	@ApiModelProperty(value = "归属楼宇")
	private Integer bId;
	//归属楼层id
	@ApiModelProperty(value = "归属楼层id")
	private Integer bFlId;
	//归属校区ID
	@ApiModelProperty(value = "归属校区ID")
	private Integer bXqId;
	//对应楼宇宿舍ID
	@ApiModelProperty(value = "对应楼宇宿舍ID")
	private Integer bDId;

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
	 * 设置：学校唯一编码(100000:公共机构)
	 */
	public void setUvCode(Integer uvCode) {
		this.uvCode = uvCode;
	}
	/**
	 * 获取：学校唯一编码(100000:公共机构)
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
	 * 设置：宿舍名称
	 */
	public void setDName(String dName) {
		this.dName = dName;
	}
	/**
	 * 获取：宿舍名称
	 */
	public String getDName() {
		return dName;
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
	 * 设置：级别(宿舍、床位)
	 */
	public void setDLevel(Integer dLevel) {
		this.dLevel = dLevel;
	}
	/**
	 * 获取：级别(宿舍、床位)
	 */
	public Integer getDLevel() {
		return dLevel;
	}
	/**
	 * 设置：排序
	 */
	public void setDSort(Integer dSort) {
		this.dSort = dSort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getDSort() {
		return dSort;
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
	/**
	 * 设置：归属楼宇
	 */
	public void setBId(Integer bId) {
		this.bId = bId;
	}
	/**
	 * 获取：归属楼宇
	 */
	public Integer getBId() {
		return bId;
	}
	/**
	 * 设置：归属楼层id
	 */
	public void setBFlId(Integer bFlId) {
		this.bFlId = bFlId;
	}
	/**
	 * 获取：归属楼层id
	 */
	public Integer getBFlId() {
		return bFlId;
	}
	/**
	 * 设置：归属校区ID
	 */
	public void setBXqId(Integer bXqId) {
		this.bXqId = bXqId;
	}
	/**
	 * 获取：归属校区ID
	 */
	public Integer getBXqId() {
		return bXqId;
	}
	/**
	 * 设置：对应楼宇宿舍ID
	 */
	public void setBDId(Integer bDId) {
		this.bDId = bDId;
	}
	/**
	 * 获取：对应楼宇宿舍ID
	 */
	public Integer getBDId() {
		return bDId;
	}
}
