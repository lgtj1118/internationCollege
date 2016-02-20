package com.tjpu.bean;

public class TeacherModel {
	private Integer id;
	private String identificationnum;
	private String teachername;
	private String sex;
	private Integer deptid;
	private Integer roleid;
	private String email;
	private String telephone;
	private Integer type;
	private Integer courseid;
	private String position;
	private String password;
	private String classes;
	private Integer deleted;
	private String deptname;
	//private Classes classes;
	
	public TeacherModel (Teacher t){
		id = t.getId();
		identificationnum = t.getIdentificationnum();
		teachername = t.getTeachername();
		sex = t.getSex();
		deptid = t.getDept().getDeptid();
		roleid = t.getRoleid();
		email = t.getEmail();
		telephone = t.getTelephone();
		type = t.getType();
		courseid = t.getCourseid();
		position = t.getPosition();
	}
	
	
	public TeacherModel (TeacherModel t){
		id = t.getId();
		identificationnum = t.getIdentificationnum();
		teachername = t.getTeachername();
		sex = t.getSex();
		deptid = t.getDeptid();
		roleid = t.getRoleid();
		email = t.getEmail();
		telephone = t.getTelphpone();
		type = t.getType();
		courseid = t.getCourseid();
		position = t.getPosition();
		password = t.getPassword();
	}
	
	public TeacherModel (int id, String identificationnum, String teacherName) {
		this.id = id;
		this.identificationnum = identificationnum;
		this.teachername = teacherName;
	}
	
	public TeacherModel() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentificationnum() {
		return this.identificationnum;
	}

	public void setIdentificationnum(String identificationnum) {
		this.identificationnum = identificationnum;
	}

	public String getTeachername() {
		return this.teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getDeptid() {
		return this.deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelphpone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCourseid() {
		return this.courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	/*@OneToOne(fetch=FetchType.LAZY,mappedBy="assistantteachers") 
	@JoinColumn(name="class_teacher_id")
	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}*/

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getClasses() {
		return classes;
	}


	public void setClasses(String classes) {
		this.classes = classes;
	}


	public Integer getDeleted() {
		return deleted;
	}


	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}


	public String getDeptname() {
		return deptname;
	}


	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
}