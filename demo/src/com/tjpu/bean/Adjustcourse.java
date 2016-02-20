package com.tjpu.bean;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Adjustcourse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "adjustcourse")
public class Adjustcourse implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private String oldcoursenum;
	private String newcoursenum;
	private String reason;
	private String olddate;
	private String newdate;
	private String oldslot;
	private String newslot;
	private String applytime;
	private String status;
	private String applyteacher;
	private String semester;
	private String oldRoomNum;
	private String newRoomNum;
	private String oldRoomAddress;
	private String newRoomAddress;
	// Constructors

	/** default constructor */
	public Adjustcourse() {
	}

	/** minimal constructor */
	public Adjustcourse(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Adjustcourse(Integer id, String oldcoursenum, String newcoursenum, String reason, String olddate, String newdate, String oldslot, String newslot, String applytime, String status, String applyteacher) {
		this.id = id;
		this.oldcoursenum = oldcoursenum;
		this.newcoursenum = newcoursenum;
		this.reason = reason;
		this.olddate = olddate;
		this.newdate = newdate;
		this.oldslot = oldslot;
		this.newslot = newslot;
		this.applytime = applytime;
		this.status = status;
		this.applyteacher = applyteacher;
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

	@Column(name = "oldcoursenum")
	public String getOldcoursenum() {
		return this.oldcoursenum;
	}

	public void setOldcoursenum(String oldcoursenum) {
		this.oldcoursenum = oldcoursenum;
	}

	@Column(name = "newcoursenum")
	public String getNewcoursenum() {
		return this.newcoursenum;
	}

	public void setNewcoursenum(String newcoursenum) {
		this.newcoursenum = newcoursenum;
	}

	@Column(name = "reason", length = 65535)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "olddate")
	public String getOlddate() {
		return this.olddate;
	}

	public void setOlddate(String olddate) {
		this.olddate = olddate;
	}

	@Column(name = "newdate")
	public String getNewdate() {
		return this.newdate;
	}

	public void setNewdate(String newdate) {
		this.newdate = newdate;
	}

	@Column(name = "oldslot")
	public String getOldslot() {
		return this.oldslot;
	}

	public void setOldslot(String oldslot) {
		this.oldslot = oldslot;
	}

	@Column(name = "newslot")
	public String getNewslot() {
		return this.newslot;
	}

	public void setNewslot(String newslot) {
		this.newslot = newslot;
	}

	@Column(name = "applytime")
	public String getApplytime() {
		return this.applytime;
	}

	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "applyteacher")
	public String getApplyteacher() {
		return this.applyteacher;
	}

	public void setApplyteacher(String applyteacher) {
		this.applyteacher = applyteacher;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getOldRoomNum() {
		return oldRoomNum;
	}

	public void setOldRoomNum(String oldRoomNum) {
		this.oldRoomNum = oldRoomNum;
	}

	public String getNewRoomNum() {
		return newRoomNum;
	}

	public void setNewRoomNum(String newRoomNum) {
		this.newRoomNum = newRoomNum;
	}

	public String getOldRoomAddress() {
		return oldRoomAddress;
	}

	public void setOldRoomAddress(String oldRoomAddress) {
		this.oldRoomAddress = oldRoomAddress;
	}

	public String getNewRoomAddress() {
		return newRoomAddress;
	}

	public void setNewRoomAddress(String newRoomAddress) {
		this.newRoomAddress = newRoomAddress;
	}

}