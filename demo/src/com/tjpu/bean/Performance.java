package com.tjpu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Performance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "performance")
public class Performance implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private String date;
	private String study;
	private String dailylife;
	private String event;
	private String outstanding;
	private String psychicology;
	private String remark;
	private String  passport;
	private String teachernum;

	// Constructors

	/** default constructor */
	public Performance() {
	}

	/** full constructor */
	public Performance(String date, String study, String dailylife, String event, String outstanding, String psychicology, String remark, String  passport,String teachernum) {
		this.date = date;
		this.study = study;
		this.dailylife = dailylife;
		this.event = event;
		this.outstanding = outstanding;
		this.psychicology = psychicology;
		this.remark = remark;
		this.passport = passport;
		this.teachernum = teachernum;
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

	@Column(name = "date")
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "study", length = 65535)
	public String getStudy() {
		return this.study;
	}

	public void setStudy(String study) {
		this.study = study;
	}

	@Column(name = "dailylife", length = 65535)
	public String getDailylife() {
		return this.dailylife;
	}

	public void setDailylife(String dailylife) {
		this.dailylife = dailylife;
	}

	@Column(name = "event", length = 65535)
	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Column(name = "outstanding", length = 65535)
	public String getOutstanding() {
		return this.outstanding;
	}

	public void setOutstanding(String outstanding) {
		this.outstanding = outstanding;
	}

	@Column(name = "psychicology", length = 65535)
	public String getPsychicology() {
		return this.psychicology;
	}

	public void setPsychicology(String psychicology) {
		this.psychicology = psychicology;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "stu_id")
	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}
	@Column(name = "teacher_num")
	public String getTeachernum() {
		return teachernum;
	}

	public void setTeachernum(String teachernum) {
		this.teachernum = teachernum;
	}

}