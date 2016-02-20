package com.tjpu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="student")

public class Student  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
     private Classes classes;
     private String stuid;
     private String firstname;
     private String lastname;
     private String nation;
     private String stuname;
     private String sex;
     private String password;
     private String telephone;
     private String roomplace;
     private String imgurl;
     private String passport;
     private String brithdate;
     private String studentType;
     private String startdate;
     private String enddate;
     private String source;
     private String validResidencePermit;
     private String isPaid;
     private String status;
     private Integer deleted;
     private String studyLevel;
     private String duration;

    // Constructors

    public String getStudyLevel() {
		return studyLevel;
	}

	public void setStudyLevel(String studyLevel) {
		this.studyLevel = studyLevel;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	/** default constructor */
    public Student() {
    }

	/** minimal constructor */
    public Student(String password) {
        this.password = password;
    }
    
    /** full constructor */
    public Student(Classes classes, String stuid, String firstname, String lastname, String nation, String stuname, String sex, String password, String telephone, String roomplace, String imgurl, String passport, String brithdate, String studentType, String startdate, String enddate, String source, String validResidencePermit, String isPaid, String status) {
        this.classes = classes;
        this.stuid = stuid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nation = nation;
        this.stuname = stuname;
        this.sex = sex;
        this.password = password;
        this.telephone = telephone;
        this.roomplace = roomplace;
        this.imgurl = imgurl;
        this.passport = passport;
        this.brithdate = brithdate;
        this.studentType = studentType;
        this.startdate = startdate;
        this.enddate = enddate;
        this.source = source;
        this.validResidencePermit = validResidencePermit;
        this.isPaid = isPaid;
        this.status = status;
    }

   
    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }    
    public void setId(Integer id) {
        this.id = id;
    }
    
	@ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="class_id")
    public Classes getClasses() {
        return classes;
    }    
    public void setClasses(Classes classes) {
        this.classes = classes;
    }
    
    @Column(name="stuid", length=255)
    public String getStuid() {
        return this.stuid;
    }    
    public void setStuid(String stuid) {
        this.stuid = stuid;
    }
    
    @Column(name="firstname")
    public String getFirstname() {
        return this.firstname;
    }    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    @Column(name="lastname")
    public String getLastname() {
        return this.lastname;
    }    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    @Column(name="nation")
    public String getNation() {
        return this.nation;
    }    
    public void setNation(String nation) {
        this.nation = nation;
    }
    
    @Column(name="stuname")
    public String getStuname() {
        return this.stuname;
    }    
    public void setStuname(String stuname) {
        this.stuname = stuname;
    }
    
    @Column(name="sex")
    public String getSex() {
        return this.sex;
    }    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    @Column(name="password", nullable=false)
    public String getPassword() {
        return this.password;
    }    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name="telephone")
    public String getTelephone() {
        return this.telephone;
    }    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    @Column(name="roomplace")
    public String getRoomplace() {
        return this.roomplace;
    }    
    public void setRoomplace(String roomplace) {
        this.roomplace = roomplace;
    }
    
    @Column(name="imgurl")
    public String getImgurl() {
        return this.imgurl;
    }    
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    
    @Column(name="passport")
    public String getPassport() {
        return this.passport;
    }    
    public void setPassport(String passport) {
        this.passport = passport;
    }
    
    @Column(name="brithdate")
    public String getBrithdate() {
        return this.brithdate;
    }    
    public void setBrithdate(String brithdate) {
        this.brithdate = brithdate;
    }
    
    @Column(name="student_type")
    public String getStudentType() {
        return this.studentType;
    }    
    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }
    
    @Column(name="start_date")
    public String getStartdate() {
        return this.startdate;
    }   
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
    
    @Column(name="end_date")
    public String getEnddate() {
        return this.enddate;
    }    
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
    
    @Column(name="source")
    public String getSource() {
        return this.source;
    }   
    public void setSource(String source) {
        this.source = source;
    }
    
    @Column(name="valid_residence_permit")
    public String getValidResidencePermit() {
        return this.validResidencePermit;
    }    
    public void setValidResidencePermit(String validResidencePermit) {
        this.validResidencePermit = validResidencePermit;
    }
    
    @Column(name="is_paid")
    public String getIsPaid() {
        return this.isPaid;
    }    
    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }
    
    @Column(name="status")
    public String getStatus() {
        return this.status;
    }   
    public void setStatus(String status) {
        this.status = status;
    }
    @Column(name="deleted")
	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
   








}