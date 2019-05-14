package com.bootdo.welcome.domain;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 学生基础信息表
 * 
 * @author wwpan
 * @email wwpan.xd@163.com
 * @date 2019-05-14 13:17:59
 */
@ApiModel(value = "StuBaseinfoDO", description = "学生基础信息表") 
public class StuBaseinfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	@ApiModelProperty(value = "")
	private Long id;
	//学生ID
	@ApiModelProperty(value = "学生ID")
	private Long sId;
	//学校唯一编码
	@ApiModelProperty(value = "学校唯一编码")
	private Integer uvCode;
	//曾用名
	@ApiModelProperty(value = "曾用名")
	private String sUsedName;
	//照片路径
	@ApiModelProperty(value = "照片路径")
	private String sPhoto;
	//年龄
	@ApiModelProperty(value = "年龄")
	private Integer sAge;
	//身高
	@ApiModelProperty(value = "身高")
	private Integer sHeight;
	//体重
	@ApiModelProperty(value = "体重")
	private Integer sWeight;
	//民族
	@ApiModelProperty(value = "民族")
	private String sNation;
	//生源地
	@ApiModelProperty(value = "生源地")
	private String sSourcePlace;
	//出生日期
	@ApiModelProperty(value = "出生日期")
	private Long sBirthday;
	//电话
	@ApiModelProperty(value = "电话")
	private String sPhone;
	//固定电话
	@ApiModelProperty(value = "固定电话")
	private String sFixPhone;
	//邮箱
	@ApiModelProperty(value = "邮箱")
	private String sEmail;
	//婚姻状态
	@ApiModelProperty(value = "婚姻状态")
	private String sMarriage;
	//政治面貌
	@ApiModelProperty(value = "政治面貌")
	private String sPolitical;
	//入团入党时间
	@ApiModelProperty(value = "入团入党时间")
	private Long sPoliticalTime;
	//港澳台侨
	@ApiModelProperty(value = "港澳台侨")
	private String sNature;
	//家庭住址-省
	@ApiModelProperty(value = "家庭住址-省")
	private String sAddrProvince;
	//家庭住址-区县
	@ApiModelProperty(value = "家庭住址-区县")
	private String sAddrCounty;
	//家庭住址-街道
	@ApiModelProperty(value = "家庭住址-街道")
	private String sAddrStreet;
	//家庭住址-市
	@ApiModelProperty(value = "家庭住址-市")
	private String sAddrCity;
	//家庭详细住址
	@ApiModelProperty(value = "家庭详细住址")
	private String sAddress;
	//籍贯
	@ApiModelProperty(value = "籍贯")
	private String sNativePlace;
	//户口性质
	@ApiModelProperty(value = "户口性质")
	private String sHousehold;
	//户籍所在地
	@ApiModelProperty(value = "户籍所在地")
	private String sDomicile;
	//户口所在地行政区划
	@ApiModelProperty(value = "户口所在地行政区划")
	private String sArea;
	//所属派出所
	@ApiModelProperty(value = "所属派出所")
	private String sPoliceStation;
	//通信地址 
	@ApiModelProperty(value = "通信地址 ")
	private String sCommuAddress;
	//毕业院校
	@ApiModelProperty(value = "毕业院校")
	private String sGraduateSchool;
	//入学时间
	@ApiModelProperty(value = "入学时间")
	private Long sSchoolTime;
	//宗教信仰
	@ApiModelProperty(value = "宗教信仰")
	private String sBelief;
	//血型
	@ApiModelProperty(value = "血型")
	private String sBlood;
	//独生子女
	@ApiModelProperty(value = "独生子女")
	private String sOnlyChild;
	//录取形式
	@ApiModelProperty(value = "录取形式")
	private String sAdmission;
	//就读方式
	@ApiModelProperty(value = "就读方式")
	private String sStudyingWay;
	//住宿
	@ApiModelProperty(value = "住宿")
	private String sDormitory;
	//健康状态
	@ApiModelProperty(value = "健康状态")
	private String sHealthy;
	//新生特长
	@ApiModelProperty(value = "新生特长")
	private String sSpecialty;
	//是否受过学前教育
	@ApiModelProperty(value = "是否受过学前教育")
	private String sPreEducation;
	//是否留守儿童
	@ApiModelProperty(value = "是否留守儿童")
	private String sLeftBehind;
	//是否需要申请资助
	@ApiModelProperty(value = "是否需要申请资助")
	private String sSubsidize;
	//是否享受一补
	@ApiModelProperty(value = "是否享受一补")
	private String sSubsidies;
	//是否孤儿
	@ApiModelProperty(value = "是否孤儿")
	private String sOrphan;
	//是否烈士或优抚子女
	@ApiModelProperty(value = "是否烈士或优抚子女")
	private String sMartyr;
	//上下学距离
	@ApiModelProperty(value = "上下学距离")
	private String sShDistance;
	//上下学方式
	@ApiModelProperty(value = "上下学方式")
	private String sComeWay;
	//是否需要乘坐校车
	@ApiModelProperty(value = "是否需要乘坐校车")
	private String sShBus;
	//是否进城务工人员随迁子女
	@ApiModelProperty(value = "是否进城务工人员随迁子女")
	private String sMigrantChild;
	//是否贫困户
	@ApiModelProperty(value = "是否贫困户")
	private String sPoverty;
	//是否建档立卡
	@ApiModelProperty(value = "是否建档立卡")
	private String sRecord;
	//升学方式
	@ApiModelProperty(value = "升学方式")
	private String sEntranceWay;
	//学生来源类型
	@ApiModelProperty(value = "学生来源类型")
	private String sSourceType;
	//是否入伍
	@ApiModelProperty(value = "是否入伍")
	private String sArmy;
	//入伍证明附件地址1
	@ApiModelProperty(value = "入伍证明附件地址1")
	private String sArmyFile1;
	//入伍证明附件地址2
	@ApiModelProperty(value = "入伍证明附件地址2")
	private String sArmyFile2;
	//入伍证明附件地址3
	@ApiModelProperty(value = "入伍证明附件地址3")
	private String sArmyFile3;
	//是否接站
	@ApiModelProperty(value = "是否接站")
	private String sGreet;
	//接站人数
	@ApiModelProperty(value = "接站人数")
	private Integer sGreetNum;
	//接站地址
	@ApiModelProperty(value = "接站地址")
	private String sGreetStations;
	//到站时间
	@ApiModelProperty(value = "到站时间")
	private Long sGreetTime;
	//是否领用服装
	@ApiModelProperty(value = "是否领用服装")
	private String sClothing;
	//服装合格证明1
	@ApiModelProperty(value = "服装合格证明1")
	private String sClothingFile1;
	//服装合格证明2
	@ApiModelProperty(value = "服装合格证明2")
	private String sClothingFile2;
	//服装合格证明2
	@ApiModelProperty(value = "服装合格证明2")
	private String sClothingFile3;
	//保留字段
	@ApiModelProperty(value = "保留字段")
	private String sF1;
	//保留字段
	@ApiModelProperty(value = "保留字段")
	private String sF2;
	//保留字段
	@ApiModelProperty(value = "保留字段")
	private String sF3;
	//保留字段
	@ApiModelProperty(value = "保留字段")
	private String sF4;
	//保留字段
	@ApiModelProperty(value = "保留字段")
	private String sF5;

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
	 * 设置：学生ID
	 */
	public void setSId(Long sId) {
		this.sId = sId;
	}
	/**
	 * 获取：学生ID
	 */
	public Long getSId() {
		return sId;
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
	 * 设置：曾用名
	 */
	public void setSUsedName(String sUsedName) {
		this.sUsedName = sUsedName;
	}
	/**
	 * 获取：曾用名
	 */
	public String getSUsedName() {
		return sUsedName;
	}
	/**
	 * 设置：照片路径
	 */
	public void setSPhoto(String sPhoto) {
		this.sPhoto = sPhoto;
	}
	/**
	 * 获取：照片路径
	 */
	public String getSPhoto() {
		return sPhoto;
	}
	/**
	 * 设置：年龄
	 */
	public void setSAge(Integer sAge) {
		this.sAge = sAge;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getSAge() {
		return sAge;
	}
	/**
	 * 设置：身高
	 */
	public void setSHeight(Integer sHeight) {
		this.sHeight = sHeight;
	}
	/**
	 * 获取：身高
	 */
	public Integer getSHeight() {
		return sHeight;
	}
	/**
	 * 设置：体重
	 */
	public void setSWeight(Integer sWeight) {
		this.sWeight = sWeight;
	}
	/**
	 * 获取：体重
	 */
	public Integer getSWeight() {
		return sWeight;
	}
	/**
	 * 设置：民族
	 */
	public void setSNation(String sNation) {
		this.sNation = sNation;
	}
	/**
	 * 获取：民族
	 */
	public String getSNation() {
		return sNation;
	}
	/**
	 * 设置：生源地
	 */
	public void setSSourcePlace(String sSourcePlace) {
		this.sSourcePlace = sSourcePlace;
	}
	/**
	 * 获取：生源地
	 */
	public String getSSourcePlace() {
		return sSourcePlace;
	}
	/**
	 * 设置：出生日期
	 */
	public void setSBirthday(Long sBirthday) {
		this.sBirthday = sBirthday;
	}
	/**
	 * 获取：出生日期
	 */
	public Long getSBirthday() {
		return sBirthday;
	}
	/**
	 * 设置：电话
	 */
	public void setSPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	/**
	 * 获取：电话
	 */
	public String getSPhone() {
		return sPhone;
	}
	/**
	 * 设置：固定电话
	 */
	public void setSFixPhone(String sFixPhone) {
		this.sFixPhone = sFixPhone;
	}
	/**
	 * 获取：固定电话
	 */
	public String getSFixPhone() {
		return sFixPhone;
	}
	/**
	 * 设置：邮箱
	 */
	public void setSEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	/**
	 * 获取：邮箱
	 */
	public String getSEmail() {
		return sEmail;
	}
	/**
	 * 设置：婚姻状态
	 */
	public void setSMarriage(String sMarriage) {
		this.sMarriage = sMarriage;
	}
	/**
	 * 获取：婚姻状态
	 */
	public String getSMarriage() {
		return sMarriage;
	}
	/**
	 * 设置：政治面貌
	 */
	public void setSPolitical(String sPolitical) {
		this.sPolitical = sPolitical;
	}
	/**
	 * 获取：政治面貌
	 */
	public String getSPolitical() {
		return sPolitical;
	}
	/**
	 * 设置：入团入党时间
	 */
	public void setSPoliticalTime(Long sPoliticalTime) {
		this.sPoliticalTime = sPoliticalTime;
	}
	/**
	 * 获取：入团入党时间
	 */
	public Long getSPoliticalTime() {
		return sPoliticalTime;
	}
	/**
	 * 设置：港澳台侨
	 */
	public void setSNature(String sNature) {
		this.sNature = sNature;
	}
	/**
	 * 获取：港澳台侨
	 */
	public String getSNature() {
		return sNature;
	}
	/**
	 * 设置：家庭住址-省
	 */
	public void setSAddrProvince(String sAddrProvince) {
		this.sAddrProvince = sAddrProvince;
	}
	/**
	 * 获取：家庭住址-省
	 */
	public String getSAddrProvince() {
		return sAddrProvince;
	}
	/**
	 * 设置：家庭住址-区县
	 */
	public void setSAddrCounty(String sAddrCounty) {
		this.sAddrCounty = sAddrCounty;
	}
	/**
	 * 获取：家庭住址-区县
	 */
	public String getSAddrCounty() {
		return sAddrCounty;
	}
	/**
	 * 设置：家庭住址-街道
	 */
	public void setSAddrStreet(String sAddrStreet) {
		this.sAddrStreet = sAddrStreet;
	}
	/**
	 * 获取：家庭住址-街道
	 */
	public String getSAddrStreet() {
		return sAddrStreet;
	}
	/**
	 * 设置：家庭住址-市
	 */
	public void setSAddrCity(String sAddrCity) {
		this.sAddrCity = sAddrCity;
	}
	/**
	 * 获取：家庭住址-市
	 */
	public String getSAddrCity() {
		return sAddrCity;
	}
	/**
	 * 设置：家庭详细住址
	 */
	public void setSAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	/**
	 * 获取：家庭详细住址
	 */
	public String getSAddress() {
		return sAddress;
	}
	/**
	 * 设置：籍贯
	 */
	public void setSNativePlace(String sNativePlace) {
		this.sNativePlace = sNativePlace;
	}
	/**
	 * 获取：籍贯
	 */
	public String getSNativePlace() {
		return sNativePlace;
	}
	/**
	 * 设置：户口性质
	 */
	public void setSHousehold(String sHousehold) {
		this.sHousehold = sHousehold;
	}
	/**
	 * 获取：户口性质
	 */
	public String getSHousehold() {
		return sHousehold;
	}
	/**
	 * 设置：户籍所在地
	 */
	public void setSDomicile(String sDomicile) {
		this.sDomicile = sDomicile;
	}
	/**
	 * 获取：户籍所在地
	 */
	public String getSDomicile() {
		return sDomicile;
	}
	/**
	 * 设置：户口所在地行政区划
	 */
	public void setSArea(String sArea) {
		this.sArea = sArea;
	}
	/**
	 * 获取：户口所在地行政区划
	 */
	public String getSArea() {
		return sArea;
	}
	/**
	 * 设置：所属派出所
	 */
	public void setSPoliceStation(String sPoliceStation) {
		this.sPoliceStation = sPoliceStation;
	}
	/**
	 * 获取：所属派出所
	 */
	public String getSPoliceStation() {
		return sPoliceStation;
	}
	/**
	 * 设置：通信地址 
	 */
	public void setSCommuAddress(String sCommuAddress) {
		this.sCommuAddress = sCommuAddress;
	}
	/**
	 * 获取：通信地址 
	 */
	public String getSCommuAddress() {
		return sCommuAddress;
	}
	/**
	 * 设置：毕业院校
	 */
	public void setSGraduateSchool(String sGraduateSchool) {
		this.sGraduateSchool = sGraduateSchool;
	}
	/**
	 * 获取：毕业院校
	 */
	public String getSGraduateSchool() {
		return sGraduateSchool;
	}
	/**
	 * 设置：入学时间
	 */
	public void setSSchoolTime(Long sSchoolTime) {
		this.sSchoolTime = sSchoolTime;
	}
	/**
	 * 获取：入学时间
	 */
	public Long getSSchoolTime() {
		return sSchoolTime;
	}
	/**
	 * 设置：宗教信仰
	 */
	public void setSBelief(String sBelief) {
		this.sBelief = sBelief;
	}
	/**
	 * 获取：宗教信仰
	 */
	public String getSBelief() {
		return sBelief;
	}
	/**
	 * 设置：血型
	 */
	public void setSBlood(String sBlood) {
		this.sBlood = sBlood;
	}
	/**
	 * 获取：血型
	 */
	public String getSBlood() {
		return sBlood;
	}
	/**
	 * 设置：独生子女
	 */
	public void setSOnlyChild(String sOnlyChild) {
		this.sOnlyChild = sOnlyChild;
	}
	/**
	 * 获取：独生子女
	 */
	public String getSOnlyChild() {
		return sOnlyChild;
	}
	/**
	 * 设置：录取形式
	 */
	public void setSAdmission(String sAdmission) {
		this.sAdmission = sAdmission;
	}
	/**
	 * 获取：录取形式
	 */
	public String getSAdmission() {
		return sAdmission;
	}
	/**
	 * 设置：就读方式
	 */
	public void setSStudyingWay(String sStudyingWay) {
		this.sStudyingWay = sStudyingWay;
	}
	/**
	 * 获取：就读方式
	 */
	public String getSStudyingWay() {
		return sStudyingWay;
	}
	/**
	 * 设置：住宿
	 */
	public void setSDormitory(String sDormitory) {
		this.sDormitory = sDormitory;
	}
	/**
	 * 获取：住宿
	 */
	public String getSDormitory() {
		return sDormitory;
	}
	/**
	 * 设置：健康状态
	 */
	public void setSHealthy(String sHealthy) {
		this.sHealthy = sHealthy;
	}
	/**
	 * 获取：健康状态
	 */
	public String getSHealthy() {
		return sHealthy;
	}
	/**
	 * 设置：新生特长
	 */
	public void setSSpecialty(String sSpecialty) {
		this.sSpecialty = sSpecialty;
	}
	/**
	 * 获取：新生特长
	 */
	public String getSSpecialty() {
		return sSpecialty;
	}
	/**
	 * 设置：是否受过学前教育
	 */
	public void setSPreEducation(String sPreEducation) {
		this.sPreEducation = sPreEducation;
	}
	/**
	 * 获取：是否受过学前教育
	 */
	public String getSPreEducation() {
		return sPreEducation;
	}
	/**
	 * 设置：是否留守儿童
	 */
	public void setSLeftBehind(String sLeftBehind) {
		this.sLeftBehind = sLeftBehind;
	}
	/**
	 * 获取：是否留守儿童
	 */
	public String getSLeftBehind() {
		return sLeftBehind;
	}
	/**
	 * 设置：是否需要申请资助
	 */
	public void setSSubsidize(String sSubsidize) {
		this.sSubsidize = sSubsidize;
	}
	/**
	 * 获取：是否需要申请资助
	 */
	public String getSSubsidize() {
		return sSubsidize;
	}
	/**
	 * 设置：是否享受一补
	 */
	public void setSSubsidies(String sSubsidies) {
		this.sSubsidies = sSubsidies;
	}
	/**
	 * 获取：是否享受一补
	 */
	public String getSSubsidies() {
		return sSubsidies;
	}
	/**
	 * 设置：是否孤儿
	 */
	public void setSOrphan(String sOrphan) {
		this.sOrphan = sOrphan;
	}
	/**
	 * 获取：是否孤儿
	 */
	public String getSOrphan() {
		return sOrphan;
	}
	/**
	 * 设置：是否烈士或优抚子女
	 */
	public void setSMartyr(String sMartyr) {
		this.sMartyr = sMartyr;
	}
	/**
	 * 获取：是否烈士或优抚子女
	 */
	public String getSMartyr() {
		return sMartyr;
	}
	/**
	 * 设置：上下学距离
	 */
	public void setSShDistance(String sShDistance) {
		this.sShDistance = sShDistance;
	}
	/**
	 * 获取：上下学距离
	 */
	public String getSShDistance() {
		return sShDistance;
	}
	/**
	 * 设置：上下学方式
	 */
	public void setSComeWay(String sComeWay) {
		this.sComeWay = sComeWay;
	}
	/**
	 * 获取：上下学方式
	 */
	public String getSComeWay() {
		return sComeWay;
	}
	/**
	 * 设置：是否需要乘坐校车
	 */
	public void setSShBus(String sShBus) {
		this.sShBus = sShBus;
	}
	/**
	 * 获取：是否需要乘坐校车
	 */
	public String getSShBus() {
		return sShBus;
	}
	/**
	 * 设置：是否进城务工人员随迁子女
	 */
	public void setSMigrantChild(String sMigrantChild) {
		this.sMigrantChild = sMigrantChild;
	}
	/**
	 * 获取：是否进城务工人员随迁子女
	 */
	public String getSMigrantChild() {
		return sMigrantChild;
	}
	/**
	 * 设置：是否贫困户
	 */
	public void setSPoverty(String sPoverty) {
		this.sPoverty = sPoverty;
	}
	/**
	 * 获取：是否贫困户
	 */
	public String getSPoverty() {
		return sPoverty;
	}
	/**
	 * 设置：是否建档立卡
	 */
	public void setSRecord(String sRecord) {
		this.sRecord = sRecord;
	}
	/**
	 * 获取：是否建档立卡
	 */
	public String getSRecord() {
		return sRecord;
	}
	/**
	 * 设置：升学方式
	 */
	public void setSEntranceWay(String sEntranceWay) {
		this.sEntranceWay = sEntranceWay;
	}
	/**
	 * 获取：升学方式
	 */
	public String getSEntranceWay() {
		return sEntranceWay;
	}
	/**
	 * 设置：学生来源类型
	 */
	public void setSSourceType(String sSourceType) {
		this.sSourceType = sSourceType;
	}
	/**
	 * 获取：学生来源类型
	 */
	public String getSSourceType() {
		return sSourceType;
	}
	/**
	 * 设置：是否入伍
	 */
	public void setSArmy(String sArmy) {
		this.sArmy = sArmy;
	}
	/**
	 * 获取：是否入伍
	 */
	public String getSArmy() {
		return sArmy;
	}
	/**
	 * 设置：入伍证明附件地址1
	 */
	public void setSArmyFile1(String sArmyFile1) {
		this.sArmyFile1 = sArmyFile1;
	}
	/**
	 * 获取：入伍证明附件地址1
	 */
	public String getSArmyFile1() {
		return sArmyFile1;
	}
	/**
	 * 设置：入伍证明附件地址2
	 */
	public void setSArmyFile2(String sArmyFile2) {
		this.sArmyFile2 = sArmyFile2;
	}
	/**
	 * 获取：入伍证明附件地址2
	 */
	public String getSArmyFile2() {
		return sArmyFile2;
	}
	/**
	 * 设置：入伍证明附件地址3
	 */
	public void setSArmyFile3(String sArmyFile3) {
		this.sArmyFile3 = sArmyFile3;
	}
	/**
	 * 获取：入伍证明附件地址3
	 */
	public String getSArmyFile3() {
		return sArmyFile3;
	}
	/**
	 * 设置：是否接站
	 */
	public void setSGreet(String sGreet) {
		this.sGreet = sGreet;
	}
	/**
	 * 获取：是否接站
	 */
	public String getSGreet() {
		return sGreet;
	}
	/**
	 * 设置：接站人数
	 */
	public void setSGreetNum(Integer sGreetNum) {
		this.sGreetNum = sGreetNum;
	}
	/**
	 * 获取：接站人数
	 */
	public Integer getSGreetNum() {
		return sGreetNum;
	}
	/**
	 * 设置：接站地址
	 */
	public void setSGreetStations(String sGreetStations) {
		this.sGreetStations = sGreetStations;
	}
	/**
	 * 获取：接站地址
	 */
	public String getSGreetStations() {
		return sGreetStations;
	}
	/**
	 * 设置：到站时间
	 */
	public void setSGreetTime(Long sGreetTime) {
		this.sGreetTime = sGreetTime;
	}
	/**
	 * 获取：到站时间
	 */
	public Long getSGreetTime() {
		return sGreetTime;
	}
	/**
	 * 设置：是否领用服装
	 */
	public void setSClothing(String sClothing) {
		this.sClothing = sClothing;
	}
	/**
	 * 获取：是否领用服装
	 */
	public String getSClothing() {
		return sClothing;
	}
	/**
	 * 设置：服装合格证明1
	 */
	public void setSClothingFile1(String sClothingFile1) {
		this.sClothingFile1 = sClothingFile1;
	}
	/**
	 * 获取：服装合格证明1
	 */
	public String getSClothingFile1() {
		return sClothingFile1;
	}
	/**
	 * 设置：服装合格证明2
	 */
	public void setSClothingFile2(String sClothingFile2) {
		this.sClothingFile2 = sClothingFile2;
	}
	/**
	 * 获取：服装合格证明2
	 */
	public String getSClothingFile2() {
		return sClothingFile2;
	}
	/**
	 * 设置：服装合格证明2
	 */
	public void setSClothingFile3(String sClothingFile3) {
		this.sClothingFile3 = sClothingFile3;
	}
	/**
	 * 获取：服装合格证明2
	 */
	public String getSClothingFile3() {
		return sClothingFile3;
	}
	/**
	 * 设置：保留字段
	 */
	public void setSF1(String sF1) {
		this.sF1 = sF1;
	}
	/**
	 * 获取：保留字段
	 */
	public String getSF1() {
		return sF1;
	}
	/**
	 * 设置：保留字段
	 */
	public void setSF2(String sF2) {
		this.sF2 = sF2;
	}
	/**
	 * 获取：保留字段
	 */
	public String getSF2() {
		return sF2;
	}
	/**
	 * 设置：保留字段
	 */
	public void setSF3(String sF3) {
		this.sF3 = sF3;
	}
	/**
	 * 获取：保留字段
	 */
	public String getSF3() {
		return sF3;
	}
	/**
	 * 设置：保留字段
	 */
	public void setSF4(String sF4) {
		this.sF4 = sF4;
	}
	/**
	 * 获取：保留字段
	 */
	public String getSF4() {
		return sF4;
	}
	/**
	 * 设置：保留字段
	 */
	public void setSF5(String sF5) {
		this.sF5 = sF5;
	}
	/**
	 * 获取：保留字段
	 */
	public String getSF5() {
		return sF5;
	}
}
