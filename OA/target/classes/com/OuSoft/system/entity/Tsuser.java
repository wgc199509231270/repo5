package com.OuSoft.system.entity;

   /**
    * Tsuser 实体类
    * 2018-08-23 17:02:38 Lw
    */ 

public class Tsuser{
	

	
	private String statuss;//开始时间
	private String starttime;//开始时间
	private String endtime;//结束时间
	
	private String zdeparid;//小组id
	private String bdeparid;//部门id
	private String grbdeparname;//部门id
	private String grzdeparname;//部门id
	private String dvalue;//部门id
	private String start;// 
	
	
	private String deparepid;//小组epid
	private String deinfoid;//小组id
	private String deparname;//小组名称
	private String roinfoid;//角色id
	private String rolename;//角色名称
	private String poinfoid;//职位id
	private String posiname;//职位名称
	private String jobinfoid;//岗位id
	private String jobname;//岗位名称
	
	
	private String userpid;
	private String tpositioninfoid;//职位id
	private String tdepartmentinfoid;//部门id：
	private String tjobinfoid;//岗位id
	private String troleinfoid;//角色id

   	private String qq;//qq账号
    private String wechat;//微信账号
    private String email;//邮箱
	//用户信息
	private String tposipid;//职位顶级id
	
	
	private String jobid;//请假使用，岗位id

	private  String  meritpay;//建议薪资

	   public String getMeritpay() {
		   return meritpay;
	   }

	   public void setMeritpay(String meritpay) {
		   this.meritpay = meritpay;
	   }

	   public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getStatuss() {
		return statuss;
	}
	public void setStatuss(String statuss) {
		this.statuss = statuss;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDvalue() {
		return dvalue;
	}
	public void setDvalue(String dvalue) {
		this.dvalue = dvalue;
	}
	public String getGrbdeparname() {
		return grbdeparname;
	}
	public void setGrbdeparname(String grbdeparname) {
		this.grbdeparname = grbdeparname;
	}
	public String getGrzdeparname() {
		return grzdeparname;
	}
	public void setGrzdeparname(String grzdeparname) {
		this.grzdeparname = grzdeparname;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getZdeparid() {
		return zdeparid;
	}
	public void setZdeparid(String zdeparid) {
		this.zdeparid = zdeparid;
	}
	public String getBdeparid() {
		return bdeparid;
	}
	public void setBdeparid(String bdeparid) {
		this.bdeparid = bdeparid;
	}
	public String getDeinfoid() {
		return deinfoid;
	}
	public void setDeinfoid(String deinfoid) {
		this.deinfoid = deinfoid;
	}
	public String getRoinfoid() {
		return roinfoid;
	}
	public void setRoinfoid(String roinfoid) {
		this.roinfoid = roinfoid;
	}
	public String getPoinfoid() {
		return poinfoid;
	}
	public void setPoinfoid(String poinfoid) {
		this.poinfoid = poinfoid;
	}
	public String getJobinfoid() {
		return jobinfoid;
	}
	public void setJobinfoid(String jobinfoid) {
		this.jobinfoid = jobinfoid;
	}
	public String getDeparepid() {
		return deparepid;
	}
	public void setDeparepid(String deparepid) {
		this.deparepid = deparepid;
	}
	public String getUserpid() {
		return userpid;
	}
	public void setUserpid(String userpid) {
		this.userpid = userpid;
	}
	public String getTpositioninfoid() {
		return tpositioninfoid;
	}
	public void setTpositioninfoid(String tpositioninfoid) {
		this.tpositioninfoid = tpositioninfoid;
	}
	public String getTdepartmentinfoid() {
		return tdepartmentinfoid;
	}
	public void setTdepartmentinfoid(String tdepartmentinfoid) {
		this.tdepartmentinfoid = tdepartmentinfoid;
	}
	public String getTjobinfoid() {
		return tjobinfoid;
	}
	public void setTjobinfoid(String tjobinfoid) {
		this.tjobinfoid = tjobinfoid;
	}
	public String getTroleinfoid() {
		return troleinfoid;
	}
	public void setTroleinfoid(String troleinfoid) {
		this.troleinfoid = troleinfoid;
	}
	public String getPosiname() {
		return posiname;
	}
	public void setPosiname(String posiname) {
		this.posiname = posiname;
	}
	public String getDeparname() {
		return deparname;
	}
	public void setDeparname(String deparname) {
		this.deparname = deparname;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getTposipid() {
		return tposipid;
	}
	public void setTposipid(String tposipid) {
		this.tposipid = tposipid;
	}
	private String token;
	private int pageNum;
	private int pageSize;
	private int page;
	private int pages;
	private String ip;
	private String usedpass;

	public String getUsedpass() {
		return usedpass;
	}
	public void setUsedpass(String usedpass) {
		this.usedpass = usedpass;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	private String	tprausername;
	
	private String txfilename;
	
	public String getTxfilename() {
		return txfilename;
	}
	public void setTxfilename(String txfilename) {
		this.txfilename = txfilename;
	}
	public String getTprausername() {
		return tprausername;
	}
	public void setTprausername(String tprausername) {
		this.tprausername = tprausername;
	}
	/**
	*用户ID
	*/
	private String	id;
	/**
	*用户姓名
	*/
	private String	username;
	/**
	*用户登录用户名
	*/
	private String	loginname;
	/**
	*用户密码
	*/
	private String	userpass;
	/**
	*用户性别
	*/
	private String	sex;
	/**
	*年龄
	*/
	private String	age;
	/**
	*电话1
	*/
	private String	phone1;
	/**
	*电话2
	*/
	private String	phone2;
	/**
	*电话3
	*/
	private String	phone3;
	/**
	*身份证号码
	*/
	private String	idcard;
	/**
	*户口所在地
	*/
	private String	residence;
	/**
	*民族
	*/
	private String	nations;
	/**
	*籍贯
	*/
	private String	nativeplace;
	/**
	*户口性质
	*/
	private String	residencetype;
	/**
	*婚姻状况
	*/
	private String	maritalstatus;
	/**
	*最高学历
	*/
	private String	schooling;
	/**
	*专业
	*/
	private String	professional;
	/**
	*政治面貌
	*/
	private String	political;
	/**
	*毕业院校
	*/
	private String	school;
	/**
	*毕业时间
	*/
	private String	graduationtime;
	/**
	*职称(资质)
	*/
	private String	qualification;
	/**
	*计算机等级
	*/
	private String	computer;
	/**
	*现住址
	*/
	private String	address;
	/**
	*其他联系人
	*/
	private String	linkman;
	/**
	*与己关系
	*/
	private String	relationship;
	/**
	*联系人电话
	*/
	private String	linkmanphone;
	/**
	*是否参保
	*/
	private String	isinsurance;
	/**
	*参保时间
	*/
	private String	insurancetime;
	/**
	*社保号
	*/
	private String	insurancenum;
	/**
	*薪酬等级
	*/
	private String	compensation;
	/**
	*补贴
	*/
	private String	subsidies;
	/**
	*在职状态
	*/
	private String	status="01";
	/**
	*入职时间
	*/
	private String	inductiontime;
	/**
	*试用期限
	*/
	private String	trialperiod;
	//topcorpid
	private String	topcorpid;
	/**
	*入职时间
	*/
	private String	area;
	/**
	*离职时间
	*/
	private String	levaetime;
	/**
	*意外险开始时间
	*/
	private String	accidentstart;
	/**
	*意外险结束时间
	*/
	private String	accidentend;
	
	private String	usernumber;//成员编码

   private  String remuneration;//薪酬

	private  String dateofbirth;//出生日期

	 private String certificate;// 技能证书
	   
	private String specialityinarts;//艺术特长

	   public String getCertificate() {
		   return certificate;
	   }

	   public void setCertificate(String certificate) {
		   this.certificate = certificate;
	   }

	   public String getRemuneration() {
	   return remuneration;
   }
   public void setRemuneration(String remuneration) {
	   this.remuneration = remuneration;
   }

	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}

	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return username;
	}

	public void setLoginname(String loginname){
		this.loginname=loginname;
	}
	public String getLoginname(){
		return loginname;
	}

	public void setUserpass(String userpass){
		this.userpass=userpass;
	}
	public String getUserpass(){
		return userpass;
	}

	public void setSex(String sex){
		this.sex=sex;
	}
	public String getSex(){
		return sex;
	}

	public void setAge(String age){
		this.age=age;
	}
	public String getAge(){
		return age;
	}

	public void setPhone1(String phone1){
		this.phone1=phone1;
	}
	public String getPhone1(){
		return phone1;
	}

	public void setPhone2(String phone2){
		this.phone2=phone2;
	}
	public String getPhone2(){
		return phone2;
	}

	public void setPhone3(String phone3){
		this.phone3=phone3;
	}
	public String getPhone3(){
		return phone3;
	}

	public void setIdcard(String idcard){
		this.idcard=idcard;
	}
	public String getIdcard(){
		return idcard;
	}

	public void setResidence(String residence){
		this.residence=residence;
	}
	public String getResidence(){
		return residence;
	}

	public void setNations(String nations){
		this.nations=nations;
	}
	public String getNations(){
		return nations;
	}

	public void setNativeplace(String nativeplace){
		this.nativeplace=nativeplace;
	}
	public String getNativeplace(){
		return nativeplace;
	}

	public void setResidencetype(String residencetype){
		this.residencetype=residencetype;
	}
	public String getResidencetype(){
		return residencetype;
	}

	public void setMaritalstatus(String maritalstatus){
		this.maritalstatus=maritalstatus;
	}
	public String getMaritalstatus(){
		return maritalstatus;
	}

	public void setSchooling(String schooling){
		this.schooling=schooling;
	}
	public String getSchooling(){
		return schooling;
	}

	public void setProfessional(String professional){
		this.professional=professional;
	}
	public String getProfessional(){
		return professional;
	}

	public void setPolitical(String political){
		this.political=political;
	}
	public String getPolitical(){
		return political;
	}

	public void setSchool(String school){
		this.school=school;
	}
	public String getSchool(){
		return school;
	}

	public void setGraduationtime(String graduationtime){
		this.graduationtime=graduationtime;
	}
	public String getGraduationtime(){
		return graduationtime;
	}

	public void setQualification(String qualification){
		this.qualification=qualification;
	}
	public String getQualification(){
		return qualification;
	}

	public void setComputer(String computer){
		this.computer=computer;
	}
	public String getComputer(){
		return computer;
	}

	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}

	public void setLinkman(String linkman){
		this.linkman=linkman;
	}
	public String getLinkman(){
		return linkman;
	}

	public void setRelationship(String relationship){
		this.relationship=relationship;
	}
	public String getRelationship(){
		return relationship;
	}

	public void setLinkmanphone(String linkmanphone){
		this.linkmanphone=linkmanphone;
	}
	public String getLinkmanphone(){
		return linkmanphone;
	}

	public void setIsinsurance(String isinsurance){
		this.isinsurance=isinsurance;
	}
	public String getIsinsurance(){
		return isinsurance;
	}

	public void setInsurancetime(String insurancetime){
		this.insurancetime=insurancetime;
	}
	public String getInsurancetime(){
		return insurancetime;
	}

	public void setInsurancenum(String insurancenum){
		this.insurancenum=insurancenum;
	}
	public String getInsurancenum(){
		return insurancenum;
	}

	public void setCompensation(String compensation){
		this.compensation=compensation;
	}
	public String getCompensation(){
		return compensation;
	}

	public void setSubsidies(String subsidies){
		this.subsidies=subsidies;
	}
	public String getSubsidies(){
		return subsidies;
	}

	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}

	public void setInductiontime(String inductiontime){
		this.inductiontime=inductiontime;
	}
	public String getInductiontime(){
		return inductiontime;
	}

	public void setTrialperiod(String trialperiod){
		this.trialperiod=trialperiod;
	}
	public String getTrialperiod(){
		return trialperiod;
	}

	public void setTopcorpid(String topcorpid){
		this.topcorpid=topcorpid;
	}
	public String getTopcorpid(){
		return topcorpid;
	}

	public void setArea(String area){
		this.area=area;
	}
	public String getArea(){
		return area;
	}

	public void setLevaetime(String levaetime){
		this.levaetime=levaetime;
	}
	public String getLevaetime(){
		return levaetime;
	}

	public void setAccidentstart(String accidentstart){
		this.accidentstart=accidentstart;
	}
	public String getAccidentstart(){
		return accidentstart;
	}

	public void setAccidentend(String accidentend){
		this.accidentend=accidentend;
	}
	public String getAccidentend(){
		return accidentend;
	}

	   public String getDateofbirth() {
		   return dateofbirth;
	   }

	   public void setDateofbirth(String dateofbirth) {
		   this.dateofbirth = dateofbirth;
	   }

	   public String getSpecialityinarts() {
		   return specialityinarts;
	   }

	   public void setSpecialityinarts(String specialityinarts) {
		   this.specialityinarts = specialityinarts;
	   }

	   public String getQq() {
		   return qq;
	   }

	   public void setQq(String qq) {
		   this.qq = qq;
	   }

	   public String getWechat() {
		   return wechat;
	   }

	   public void setWechat(String wechat) {
		   this.wechat = wechat;
	   }

	   public String getEmail() {
		   return email;
	   }

	   public void setEmail(String email) {
		   this.email = email;
	   }
   }
