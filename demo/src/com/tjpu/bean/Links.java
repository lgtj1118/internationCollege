package com.tjpu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Links entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "links")
public class Links implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private String title;
	private String linkaddress;

	// Constructors

	/** default constructor */
	public Links() {
	}

	/** full constructor */
	public Links(String title, String linkaddress) {
		this.title = title;
		this.linkaddress = linkaddress;
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

	@Column(name = "linksaddress")
	public String getLinksaddress() {
		return this.linkaddress;
	}

	public void setLinksaddress(String linkaddress) {
		this.linkaddress = linkaddress;
	}

}