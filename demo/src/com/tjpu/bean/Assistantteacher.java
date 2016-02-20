package com.tjpu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Assistantteacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "assistantteacher")
public class Assistantteacher implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private String secondlanguagetype;
	private String secondlanguagelevel;
	private String telephone;
	private String email;
	private String edulevel;
	private String politicalstatus;
	private String classname;
	private String major;
	private String department;
	private String assistantnum;
	private String name;
	private String gender;
	private String brithdate;
	private String nation;
	private String forte;
	private String applicationform;
	//private Classes classes;
	private String  academicadvice;
    private Integer academictype;
    private String responsiblename;
    private String responsibletelephone;
	// Constructors
	/** default constructor */
	public Assistantteacher() {
	}

	/** full constructor */
	public Assistantteacher(String secondlanguagetype, String secondlanguagelevel, String telephone, String email, String politicalstatus, String classname, String major, String department, String assistantnum, String name,
			String gender, String brithdate, String nation, String forte, String applicationform/*,Classes classes*/,String edulevel) {
		this.secondlanguagetype = secondlanguagetype;
		this.secondlanguagelevel = secondlanguagelevel;
		this.telephone = telephone;
		this.email = email;
		this.politicalstatus = politicalstatus;
		this.classname= classname;
		this.major = major;
		this.department = department;
		this.assistantnum = assistantnum;
		this.name = name;
		this.gender = gender;
		this.brithdate = brithdate;
		this.nation = nation;
		this.forte = forte;
		this.applicationform = applicationform;
		//this.setClasses(classes);
		this.edulevel = edulevel;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "second_language_type")
	public String getSecondlanguagetype() {
		return this.secondlanguagetype;
	}

	public void setSecondlanguagetype(String secondlanguagetype) {
		this.secondlanguagetype = secondlanguagetype;
	}

	@Column(name = "second_language_level")
	public String getSecondlanguagelevel() {
		return this.secondlanguagelevel;
	}

	public void setSecondlanguagelevel(String secondlanguagelevel) {
		this.secondlanguagelevel = secondlanguagelevel;
	}

	@Column(name = "telephone")
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "political_status")
	public String getPoliticalstatus() {
		return this.politicalstatus;
	}

	public void setPoliticalstatus(String politicalstatus) {
		this.politicalstatus = politicalstatus;
	}

	@Column(name = "classname")
	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	@Column(name = "major")
	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "department")
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "assistantnum")
	public String getAssistantnum() {
		return this.assistantnum;
	}

	public void setAssistantnum(String assistantnum) {
		this.assistantnum = assistantnum;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "gender")
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "brithdate")
	public String getBrithdate() {
		return this.brithdate;
	}

	public void setBrithdate(String brithdate) {
		this.brithdate = brithdate;
	}

	@Column(name = "nation")
	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name = "forte")
	public String getForte() {
		return this.forte;
	}

	public void setForte(String forte) {
		this.forte = forte;
	}

	@Column(name = "application_form")
	public String getApplicationform() {
		return this.applicationform;
	}

	public void setApplicationform(String applicationform) {
		this.applicationform = applicationform;
	}
	/*@OneToOne(fetch=FetchType.LAZY,mappedBy="assistantteachers") 
	@JoinColumn(name="assis_teacher_id")
	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}*/
    @Column(name="edulevel")
	public String getEdulevel() {
		return edulevel;
	}

	public void setEdulevel(String edulevel) {
		this.edulevel = edulevel;
	}
	public String getAcademicadvice() {
		return academicadvice;
	}
    @Column(name="academicadvice")
	public void setAcademicadvice(String academicadvice) {
		this.academicadvice = academicadvice;
	}

	public Integer getAcademictype() {
		return academictype;
	}
    @Column(name="academictype")
	public void setAcademictype(Integer academictype) {
		this.academictype = academictype;
	}
    @Column(name="responsiblename")
    public String getResponsiblename() {
		return responsiblename;
	}

	public void setResponsiblename(String responsiblename) {
		this.responsiblename = responsiblename;
	}
	 @Column(name="responsibletelephone")
	public String getResponsibletelephone() {
		return responsibletelephone;
	}

	public void setResponsibletelephone(String responsibletelephone) {
		this.responsibletelephone = responsibletelephone;
	}

}