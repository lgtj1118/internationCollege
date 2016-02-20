package com.tjpu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Certify1 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "certify1")
public class Certify1 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private String title;
	private String createdtime;
	private String fileplace;

	// Constructors

	/** default constructor */
	public Certify1() {
	}

	/** full constructor */
	public Certify1(String title, String createdtime, String fileplace) {
		this.title = title;
		this.createdtime = createdtime;
		this.fileplace = fileplace;
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

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "createdtime")
	public String getCreatedtime() {
		return this.createdtime;
	}

	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

	@Column(name = "fileplace")
	public String getFileplace() {
		return this.fileplace;
	}

	public void setFileplace(String fileplace) {
		this.fileplace = fileplace;
	}

}