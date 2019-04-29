package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 迎新阶段文件表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-04-29 11:42:24
 */
@ApiModel(value = "StageFileDO", description = "迎新阶段文件表") 
public class StageFileDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//归属一级阶段的id
	@ApiModelProperty(value = "归属一级阶段的id")
	private Integer sIdLevel1;
	//归属二级阶段的id
	@ApiModelProperty(value = "归属二级阶段的id")
	private Integer sIdLevel2;
	//归属二级阶段的id
	@ApiModelProperty(value = "归属二级阶段的id")
	private Integer sIdLevel3;
	//阶段文件名称
	@ApiModelProperty(value = "阶段文件名称")
	private String sfName;
	//阶段文件的地址
	@ApiModelProperty(value = "阶段文件的地址")
	private String sfUrl;
	//文件大小
	@ApiModelProperty(value = "文件大小")
	private Integer sfSize;
	//文件后缀l类型
	@ApiModelProperty(value = "文件后缀l类型")
	private String sfType;

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
	 * 设置：归属一级阶段的id
	 */
	public void setSIdLevel1(Integer sIdLevel1) {
		this.sIdLevel1 = sIdLevel1;
	}
	/**
	 * 获取：归属一级阶段的id
	 */
	public Integer getSIdLevel1() {
		return sIdLevel1;
	}
	/**
	 * 设置：归属二级阶段的id
	 */
	public void setSIdLevel2(Integer sIdLevel2) {
		this.sIdLevel2 = sIdLevel2;
	}
	/**
	 * 获取：归属二级阶段的id
	 */
	public Integer getSIdLevel2() {
		return sIdLevel2;
	}
	/**
	 * 设置：归属二级阶段的id
	 */
	public void setSIdLevel3(Integer sIdLevel3) {
		this.sIdLevel3 = sIdLevel3;
	}
	/**
	 * 获取：归属二级阶段的id
	 */
	public Integer getSIdLevel3() {
		return sIdLevel3;
	}
	/**
	 * 设置：阶段文件名称
	 */
	public void setSfName(String sfName) {
		this.sfName = sfName;
	}
	/**
	 * 获取：阶段文件名称
	 */
	public String getSfName() {
		return sfName;
	}
	/**
	 * 设置：阶段文件的地址
	 */
	public void setSfUrl(String sfUrl) {
		this.sfUrl = sfUrl;
	}
	/**
	 * 获取：阶段文件的地址
	 */
	public String getSfUrl() {
		return sfUrl;
	}
	/**
	 * 设置：文件大小
	 */
	public void setSfSize(Integer sfSize) {
		this.sfSize = sfSize;
	}
	/**
	 * 获取：文件大小
	 */
	public Integer getSfSize() {
		return sfSize;
	}
	/**
	 * 设置：文件后缀l类型
	 */
	public void setSfType(String sfType) {
		this.sfType = sfType;
	}
	/**
	 * 获取：文件后缀l类型
	 */
	public String getSfType() {
		return sfType;
	}
}
