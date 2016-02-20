package com.tjpu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classroom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "classroom")
public class Classroom implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer num;
	private String roomname;
	private String roomplace;
	private Integer  roomcapacity ;
	private Integer realcapacity;
	private String roomtype;
	private String note;
	private Integer isavaible;
	private Integer deleted;

	// Constructors

	

	/** default constructor */
	public Classroom() {
	}

	/** full constructor */
	public Classroom( String roomname, String roomplace, Integer  roomcapacity,String roomtype,String note,Integer realcapacity) {
		//this.num = num;
		this.roomname = roomname;
		this.roomplace = roomplace;
		this.roomcapacity = roomcapacity;
		this.roomtype = roomtype;
		this.note = note;
		this.realcapacity = realcapacity;
	}

	// Property accessors
	@Column(name = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "num", unique = true, nullable = false)
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
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
	@Column(name = "roomcapacity")
	public Integer  getRoomcapacity() {
		return roomcapacity;
	}

	public void setRoomcapacity(Integer roomcapacity) {
		this.roomcapacity = roomcapacity;
	}
	@Column(name = "note")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
    @Column(name="realcapacity")
	public Integer getRealcapacity() {
		return realcapacity;
	}

	public void setRealcapacity(Integer realcapacity) {
		this.realcapacity = realcapacity;
	}
	@Column(name="isavaible")
	public Integer getIsavaible() {
		return isavaible;
	}

	public void setIsavaible(Integer isavaible) {
		this.isavaible = isavaible;
	}
	@Column(name="deleted")
	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	
}