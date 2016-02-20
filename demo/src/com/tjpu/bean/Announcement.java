package com.tjpu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Announcement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "announcement")
public class Announcement implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String content;
	private String createdtime;

	// Constructors

	/** default constructor */
	public Announcement() {
	}

	/** full constructor */
	public Announcement(String title, String content, String createdtime) {
		this.title = title;
		this.content = content;
		this.createdtime = createdtime;
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

	@Column(name = "content", length = 16777215)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "createdtime")
	public String getCreatedtime() {
		return this.createdtime;
	}

	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

}