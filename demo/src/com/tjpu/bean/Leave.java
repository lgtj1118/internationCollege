package com.tjpu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Leave entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "stuleave")
public class Leave implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String passport;
	private String leavereason;
	private String telephone;
	private String leavingdate;
	private String backdate;
	private String applydate;
	private Integer type;
	private Integer status;
	private String doc;
	//private Integer academicadvice;
	// Constructors

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	/** default constructor */
	public Leave() {
	}

	/** full constructor */
	public Leave(String passport, String leavereason, String telephone, String leavingdate, String backdate, String applydate, Integer type,Integer status/*,Integer academicadvice*/) {
		this.passport = passport;
		this.leavereason = leavereason;
		this.telephone = telephone;
		this.leavingdate = leavingdate;
		this.backdate = backdate;
		this.applydate = applydate;
		this.type = type;
		this.status = status;
		//this.setAcademicadvice(academicadvice);
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

	@Column(name = "stuid")
	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	@Column(name = "leavereason")
	public String getLeavereason() {
		return this.leavereason;
	}

	public void setLeavereason(String leavereason) {
		this.leavereason = leavereason;
	}

	@Column(name = "telephone")
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "leavingdate")
	public String getLeavingdate() {
		return this.leavingdate;
	}

	public void setLeavingdate(String leavingdate) {
		this.leavingdate = leavingdate;
	}

	@Column(name = "backdate")
	public String getBackdate() {
		return this.backdate;
	}

	public void setBackdate(String backdate) {
		this.backdate = backdate;
	}

	@Column(name = "applydate")
	public String getApplydate() {
		return this.applydate;
	}

	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
    @Column(name="status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	/*@Column(name="academicadvice")
	public Integer getAcademicadvice() {
		return academicadvice;
	}

	public void setAcademicadvice(Integer academicadvice) {
		this.academicadvice = academicadvice;
	}*/

}