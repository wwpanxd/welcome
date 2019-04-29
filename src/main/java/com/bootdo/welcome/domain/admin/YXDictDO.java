package com.bootdo.welcome.domain.admin;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 字典表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-22 11:55:53
 */
@ApiModel(value = "YXDictDO", description = "字典表") 
public class YXDictDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	@ApiModelProperty(value = "编号")
	private Long id;
	//标签名
	@ApiModelProperty(value = "标签名")
	private String name;
	//数据值
	@ApiModelProperty(value = "数据值")
	private String value;
	//类型编码
	@ApiModelProperty(value = "类型编码")
	private Integer code;
	//描述
	@ApiModelProperty(value = "描述")
	private String description;
	//排序（升序）
	@ApiModelProperty(value = "排序（升序）")
	private Integer sort;
	//父级编号
	@ApiModelProperty(value = "父级编号")
	private Long parentId;
	//备注信息
	@ApiModelProperty(value = "备注信息")
	private String remarks;
	//状态  1：启用  0：禁用
	@ApiModelProperty(value = "状态  1：启用  0：禁用")
	private Integer flag;
	//学校唯一编码(100000:公共机构)
	@ApiModelProperty(value = "学校唯一编码(100000:公共机构)")
	private Integer uvCode;

	/**
	 * 设置：编号
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：编号
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：标签名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：标签名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：数据值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：数据值
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 设置：类型编码
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * 获取：类型编码
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * 设置：描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：排序（升序）
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序（升序）
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：父级编号
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父级编号
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：备注信息
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注信息
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：状态  1：启用  0：禁用
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * 获取：状态  1：启用  0：禁用
	 */
	public Integer getFlag() {
		return flag;
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
}
