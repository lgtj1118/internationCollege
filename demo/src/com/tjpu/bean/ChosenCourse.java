package com.tjpu.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * ChoosenCourse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "choosen_course", catalog = "arranging")
public class ChosenCourse implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String passport;
	private String courseId;
	private String attendence ;
	private String homework ;
	private String midexam ;
	private String finalexam ;
	private float summary ;
	private String weekday = "";
	private String slot = "";
	private String semester = "";
	private String room = "";
	private String roomtype = "";
	private Integer ismakeup=0;//0 未补考，1 补考
	private Integer makeup;
	private Set<Teacher> teachers = new HashSet<Teacher>(0);
	// Constructors

	/** default constructor */
	public ChosenCourse() {
	}

	/** minimal constructor */
	public ChosenCourse(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ChosenCourse(Integer id, String passport, String courseId, String attendence, String homework, String midexam, String finalexam, String weekday, String semester, String room, String roomtype,Set<Teacher> teachers) {
		this.id = id;
		this.passport = passport;
		this.courseId = courseId;
		this.attendence = attendence;
		this.homework = homework;
		this.midexam = midexam;
		this.finalexam = finalexam;
		this.weekday = weekday;
		this.semester = semester;
		this.room = room;
		this.roomtype = roomtype;
		this.teachers = teachers; 
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

	@Column(name = "stu_id")
	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	@Column(name = "course_id")
	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Column(name = "attendence")
	public String getAttendence() {
		return this.attendence;
	}

	public void setAttendence(String attendence) {
		this.attendence = attendence;
	}

	@Column(name = "homework")
	public String getHomework() {
		return this.homework;
	}

	public void setHomework(String homework) {
		this.homework = homework;
	}

	@Column(name = "midexam")
	public String getMidexam() {
		return this.midexam;
	}

	public void setMidexam(String midexam) {
		this.midexam = midexam;
	}

	@Column(name = "finalexam")
	public String getFinalexam() {
		return this.finalexam;
	}

	public void setFinalexam(String finalexam) {
		this.finalexam = finalexam;
	}

	@Column(name = "weekday")
	public String getWeekday() {
		return this.weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	@Column(name = "semester")
	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Column(name = "room")
	public String getRoom() {
		return this.room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	@Column(name = "roomtype")
	public String getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "chosencourses")
	public Set<Teacher> getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}
	@Column(name = "ismakeup")
	public Integer getIsmakeup() {
		return ismakeup;
	}
	
	public void setIsmakeup(Integer ismakeup) {
		this.ismakeup = ismakeup;
	}
	@Column(name = "makeup")
	public Integer getMakeup() {
		return makeup;
	}

	public void setMakeup(Integer makeup) {
		this.makeup = makeup;
	}
	@Column(name = "summary")
	public float getSummary() {
		return summary;
	}

	public void setSummary(float summary) {
		this.summary = summary;
	}
}