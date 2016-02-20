package com.tjpu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SemesterChosenClassroom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "semester_chosen_classroom")
public class SemesterChosenClassroom implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String num;
	private String roomname;
	private String roomplace;
	private String roomtype;
	private String note;
	private String roomcapacity;
	private String realcapacity;
	private String semester;

	// Constructors

	/** default constructor */
	public SemesterChosenClassroom() {
	}

	/** full constructor */
	public SemesterChosenClassroom(String num, String roomname, String roomplace, String roomtype, String note, String roomcapacity, String realcapacity, String semester) {
		this.num = num;
		this.roomname = roomname;
		this.roomplace = roomplace;
		this.roomtype = roomtype;
		this.note = note;
		this.roomcapacity = roomcapacity;
		this.realcapacity = realcapacity;
		this.semester = semester;
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


	@Column(name = "num")
	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Column(name = "roomname")
	public String getRoomname() {
		return this.roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	@Column(name = "roomplace")
	public String getRoomplace() {
		return this.roomplace;
	}

	public void setRoomplace(String roomplace) {
		this.roomplace = roomplace;
	}

	@Column(name = "roomtype")
	public String getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	@Column(name = "note")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "roomcapacity")
	public String getRoomcapacity() {
		return this.roomcapacity;
	}

	public void setRoomcapacity(String roomcapacity) {
		this.roomcapacity = roomcapacity;
	}

	@Column(name = "realcapacity")
	public String getRealcapacity() {
		return this.realcapacity;
	}

	public void setRealcapacity(String realcapacity) {
		this.realcapacity = realcapacity;
	}

	@Column(name = "semester")
	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

}