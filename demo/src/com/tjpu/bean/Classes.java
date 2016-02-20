package com.tjpu.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "class")
public class Classes implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String classname;
	private String classname_en;
	private String major;
	private Integer courseId;
	private Set<Student> Students = new HashSet<Student>(0);
	private String classminitorid;
	/*private Assistantteacher assistantteachers ;
    private ClassTeacher classTeacher;*/
	// Constructors
    private Integer classteacherid;
    private String assisTeacherId;
    private Integer type;//0正常 , 1 删除, 2 毕业
	/** default constructor */
	public Classes() {
	}

	/** full constructor */
	public Classes(String classname, String major, Integer courseId, Set<Student> Students,String classminitorid,Integer classteacherid/* ,Assistantteacher assistantteachers,ClassTeacher classTeacher*/) {
		this.classname = classname;
		this.major = major;
		this.courseId = courseId;
		this.Students = Students;
		this.classminitorid = classminitorid;
		this.classteacherid = classteacherid;
		/*this.courses = courses;*/
		/*this.assistantteachers=assistantteachers;
		this.classTeacher = classTeacher;*/
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "classname", length = 45)
	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	@Column(name = "major", length = 45)
	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "course_id")
	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classes")
	public Set<Student> getStudents() {
		return this.Students;
	}

	public void setStudents(Set<Student> Students) {
		this.Students = Students;
	}
    /*@OneToOne(cascade = CascadeType.ALL)
	public Assistantteacher getAssistantteachers() {
		return assistantteachers;
	}

	public void setAssistantteachers(Assistantteacher assistantteachers) {
		this.assistantteachers = assistantteachers;
	}
	 @OneToOne(cascade = CascadeType.ALL)
	public ClassTeacher getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(ClassTeacher classTeacher) {
		this.classTeacher = classTeacher;
	}*/
    @Column(name="class_minitor_id")
	public String getClassminitorid() {
		return classminitorid;
	}
    
	public void setClassminitorid(String classminitorid) {
		this.classminitorid = classminitorid;
	}
	@Column(name="classTeacher_id")
	public Integer getClassteacherid() {
		return classteacherid;
	}

	public void setClassteacherid(Integer classteacherid) {
		this.classteacherid = classteacherid;
	}

	public String getAssisTeacherId() {
		return assisTeacherId;
	}

	public void setAssisTeacherId(String assisTeacherId) {
		this.assisTeacherId = assisTeacherId;
	}

	public String getClassname_en() {
		return classname_en;
	}

	public void setClassname_en(String classname_en) {
		this.classname_en = classname_en;
	}
	@Column(name="type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	/*@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "t_class_course", joinColumns = { @JoinColumn(name = "class_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "course_id", nullable = false, updatable = false) })
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}*/

}