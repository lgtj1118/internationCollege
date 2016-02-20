package com.tjpu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "file_record")
public class FileRecord implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer serial;
	private String fileName;
	private String fileType;
	private String operaterName;
	private String operaterNum;
	private String year;
	private String operaterType;
	private String date;

	// Constructors

	/** default constructor */
	public FileRecord() {
	}

	/** full constructor */
	public FileRecord(String fileName, String fileType, String operaterName, String operaterNum, String year, String operaterType, String date) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.operaterName = operaterName;
		this.operaterNum = operaterNum;
		this.year = year;
		this.operaterType = operaterType;
		this.date = date;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "serial", unique = true, nullable = false)
	public Integer getSerial() {
		return this.serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	@Column(name = "fileName")
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "fileType", length = 50)
	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Column(name = "operaterName")
	public String getOperaterName() {
		return this.operaterName;
	}

	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}

	@Column(name = "operaterNum", length = 50)
	public String getOperaterNum() {
		return this.operaterNum;
	}

	public void setOperaterNum(String operaterNum) {
		this.operaterNum = operaterNum;
	}

	@Column(name = "year", length = 50)
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(name = "operaterType", length = 50)
	public String getOperaterType() {
		return this.operaterType;
	}

	public void setOperaterType(String operaterType) {
		this.operaterType = operaterType;
	}

	@Column(name = "date", length = 50)
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}