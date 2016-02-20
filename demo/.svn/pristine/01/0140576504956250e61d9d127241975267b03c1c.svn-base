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
 * ClassTeacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "class_teacher")
public class ClassTeacher implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private String name;
	private String gender;
	private String educationBackground;
	private String brithdate;
	private String telephone;
	private String identificationNum;
  //  private Classes classes;
	// Constructors

	/** default constructor */
	public ClassTeacher() {
	}

	/** full constructor */
	public ClassTeacher(String name, String gender, String educationBackground, String brithdate, String telephone, String identificationNum/*,Classes classes*/) {
		this.name = name;
		this.gender = gender;
		this.educationBackground = educationBackground;
		this.brithdate = brithdate;
		this.telephone = telephone;
		this.identificationNum = identificationNum;
		//this.classes = classes;
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

	@Column(name = "education_background")
	public String getEducationBackground() {
		return this.educationBackground;
	}

	public void setEducationBackground(String educationBackground) {
		this.educationBackground = educationBackground;
	}

	@Column(name = "brithdate")
	public String getBrithdate() {
		return this.brithdate;
	}

	public void setBrithdate(String brithdate) {
		this.brithdate = brithdate;
	}

	@Column(name = "telephone")
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "identification_num")
	public String getIdentificationNum() {
		return this.identificationNum;
	}

	public void setIdentificationNum(String identificationNum) {
		this.identificationNum = identificationNum;
	}
	/*@OneToOne(fetch=FetchType.LAZY,mappedBy="assistantteachers") 
	@JoinColumn(name="class_teacher_id")
	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}*/

}