package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 考场表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-03 16:17:01
 */
@ApiModel(value = "ExaminationRoomDO", description = "考场表") 
public class ExaminationRoomDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增主键
	@ApiModelProperty(value = "自增主键")
	private Long id;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//归属校区
	@ApiModelProperty(value = "归属校区")
	private String rCampus;
	//归属楼
	@ApiModelProperty(value = "归属楼")
	private String rBuild;
	//归属层
	@ApiModelProperty(value = "归属层")
	private String rFloor;
	//归属房间
	@ApiModelProperty(value = "归属房间")
	private String rRoom;
	//考场名称
	@ApiModelProperty(value = "考场名称")
	private String rName;
	//考场编号
	@ApiModelProperty(value = "考场编号")
	private String rCode;
	//座位个数,最大考生数
	@ApiModelProperty(value = "座位个数,最大考生数")
	private Integer rSize;
	//考场地址详细描述
	@ApiModelProperty(value = "考场地址详细描述")
	private String rAddress;

	/**
	 * 设置：自增主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：自增主键
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
	 * 设置：归属校区
	 */
	public void setRCampus(String rCampus) {
		this.rCampus = rCampus;
	}
	/**
	 * 获取：归属校区
	 */
	public String getRCampus() {
		return rCampus;
	}
	/**
	 * 设置：归属楼
	 */
	public void setRBuild(String rBuild) {
		this.rBuild = rBuild;
	}
	/**
	 * 获取：归属楼
	 */
	public String getRBuild() {
		return rBuild;
	}
	/**
	 * 设置：归属层
	 */
	public void setRFloor(String rFloor) {
		this.rFloor = rFloor;
	}
	/**
	 * 获取：归属层
	 */
	public String getRFloor() {
		return rFloor;
	}
	/**
	 * 设置：归属房间
	 */
	public void setRRoom(String rRoom) {
		this.rRoom = rRoom;
	}
	/**
	 * 获取：归属房间
	 */
	public String getRRoom() {
		return rRoom;
	}
	/**
	 * 设置：考场名称
	 */
	public void setRName(String rName) {
		this.rName = rName;
	}
	/**
	 * 获取：考场名称
	 */
	public String getRName() {
		return rName;
	}
	/**
	 * 设置：考场编号
	 */
	public void setRCode(String rCode) {
		this.rCode = rCode;
	}
	/**
	 * 获取：考场编号
	 */
	public String getRCode() {
		return rCode;
	}
	/**
	 * 设置：座位个数,最大考生数
	 */
	public void setRSize(Integer rSize) {
		this.rSize = rSize;
	}
	/**
	 * 获取：座位个数,最大考生数
	 */
	public Integer getRSize() {
		return rSize;
	}
	/**
	 * 设置：考场地址详细描述
	 */
	public void setRAddress(String rAddress) {
		this.rAddress = rAddress;
	}
	/**
	 * 获取：考场地址详细描述
	 */
	public String getRAddress() {
		return rAddress;
	}
}
