package com.tjpu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ClassRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "class_record")
public class ClassRecord implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer classid;
	private String teacherid;
	private String date;
	private String classmeetingfrequency;
	private String appointmentnumber;
	private String physicalmentalcondition;
	private String studyingcondition;
	private String feedback;
	private Integer selfevalution;

	// Constructors

	/** default constructor */
	public ClassRecord() {
	}

	/** full constructor */
	public ClassRecord(Integer classid, String date, String classmeetingfrequency, String appointmentnumber, String physicalmentalcondition, String studyingcondition, String feedback,String  teacherid,Integer selfevalution) {
		this.classid = classid;
		this.date = date;
		this.classmeetingfrequency = classmeetingfrequency;
		this.appointmentnumber = appointmentnumber;
		this.physicalmentalcondition = physicalmentalcondition;
		this.studyingcondition = studyingcondition;
		this.feedback = feedback;
		this.teacherid = teacherid;
		this.selfevalution = selfevalution;
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

	@Column(name = "class_id")
	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	@Column(name = "date")
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "class_meeting_frequency")
	public String getClassmeetingfrequency() {
		return this.classmeetingfrequency;
	}

	public void setClassmeetingfrequency(String classmeetingfrequency) {
		this.classmeetingfrequency = classmeetingfrequency;
	}

	@Column(name = "appointment_number")
	public String getAppointmentnumber() {
		return this.appointmentnumber;
	}

	public void setAppointmentnumber(String appointmentnumber) {
		this.appointmentnumber = appointmentnumber;
	}

	@Column(name = "physical_mental_condition", length = 65535)
	public String getPhysicalmentalcondition() {
		return this.physicalmentalcondition;
	}

	public void setPhysicalmentalcondition(String physicalmentalcondition) {
		this.physicalmentalcondition = physicalmentalcondition;
	}

	@Column(name = "studying_condition", length = 65535)
	public String getStudyingcondition() {
		return this.studyingcondition;
	}

	public void setStudyingcondition(String studyingcondition) {
		this.studyingcondition = studyingcondition;
	}

	@Column(name = "feedback", length = 65535)
	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Column(name = "teacherid")
	public String  getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	@Column(name = "selfevalution")
	public Integer getSelfevalution() {
		return selfevalution;
	}

	public void setSelfevalution(Integer selfevalution) {
		this.selfevalution = selfevalution;
	}

}