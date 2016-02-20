package com.tjpu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Attendence entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "attendence")
public class Attendence implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String passport;
	private Integer choosencourseid;
	private String date;
	private String time;
	private String type;
	private String semester;

	// Constructors

	/** default constructor */
	public Attendence() {
	}

	/** full constructor */
	public Attendence(String passport, Integer choosencourseid, String date, String time, String type) {
		this.passport = passport;
		this.choosencourseid = choosencourseid;
		this.date = date;
		this.time = time;
		this.type = type;
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

	@Column(name = "stuid")
	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	@Column(name = "choosen_course_id")
	public Integer getChoosencourseid() {
		return this.choosencourseid;
	}

	public void setChoosencourseid(Integer choosencourseid) {
		this.choosencourseid = choosencourseid;
	}

	@Column(name = "date")
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "time")
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Column(name = "semester")
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

}