package com.bootdo.welcome.domain;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 答题结果记录表
 * 
 */

@ApiModel(value="ScoreDO",description="考核成绩记录")
public class ScoreDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	@ApiModelProperty(value="用户id")
	private Integer uid;
//	@ApiModelProperty(value="答题耗时，字符串")
//	private String utimes;
	@ApiModelProperty(value="答题时间,秒")
	private Long utime;
	@ApiModelProperty(value="成绩")
	private Integer score;
	@ApiModelProperty(value="答题日期")
	private Long ptime;
	@ApiModelProperty(value="答题次数")
	private Long cnum;
	
	

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户id
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUid() {
		return uid;
	}
	
	/**
	 * 设置：成绩
	 */
	public void setScore(Integer score) {
		this.score = score;
	}
	/**
	 * 获取：成绩
	 */
	public Integer getScore() {
		return score;
	}
	/**
	 * 设置：答题时间
	 */
	public void setPtime(Long ptime) {
		this.ptime = ptime;
	}
	/**
	 * 获取：答题时间
	 */
	public Long getPtime() {
		return ptime;
	}
//	public String getUtimes() {
//		return utimes;
//	}
//	public void setUtimes(String utimes) {
//		this.utimes = utimes;
//	}
	public Long getCnum() {
		return cnum;
	}
	public void setCnum(Long cnum) {
		this.cnum = cnum;
	}
	public void setUtime(Long utime) {
		this.utime = utime;
	}
	public Long getUtime() {
		return utime;
	}
}
