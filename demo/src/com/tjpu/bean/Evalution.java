package com.tjpu.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Evalution entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "evalution")
public class Evalution implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String courseid;
	private String teacher;
	private String passport;
	private String incicators1;
	private String incicators2;
	private String incicators3;
	private String incicators4;
	private String incicators5;
	private String incicators6;
	private String incicators7;
	private String summary;
	private String extrude;
	private String advice;
	private String semester;
    private Integer flag;//0代表课程，1代表班主任
	// Constructors

	/** default constructor */
	public Evalution() {
	}

	/** full constructor */
	public Evalution(String courseid, String teacher, String passport, String incicators1, String incicators2, String incicators3, String incicators4, String incicators5, String incicators6, String incicators7, String summary, String extrude,
			String advice) {
		this.courseid = courseid;
		this.teacher = teacher;
		this.passport = passport;
		this.incicators1 = incicators1;
		this.incicators2 = incicators2;
		this.incicators3 = incicators3;
		this.incicators4 = incicators4;
		this.incicators5 = incicators5;
		this.incicators6 = incicators6;
		this.incicators7 = incicators7;
		this.summary = summary;
		this.extrude = extrude;
		this.advice = advice;
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

	@Column(name = "course_id")
	public String getCourseid() {
		return this.courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	@Column(name = "teacher")
	public String getTeacher() {
		return this.teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	@Column(name = "stu_id")
	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	@Column(name = "incicators1")
	public String getIncicators1() {
		return this.incicators1;
	}

	public void setIncicators1(String incicators1) {
		this.incicators1 = incicators1;
	}

	@Column(name = "incicators2", length = 0)
	public String getIncicators2() {
		return this.incicators2;
	}

	public void setIncicators2(String incicators2) {
		this.incicators2 = incicators2;
	}

	@Column(name = "incicators3", length = 0)
	public String getIncicators3() {
		return this.incicators3;
	}

	public void setIncicators3(String incicators3) {
		this.incicators3 = incicators3;
	}

	@Column(name = "incicators4", length = 0)
	public String getIncicators4() {
		return this.incicators4;
	}

	public void setIncicators4(String incicators4) {
		this.incicators4 = incicators4;
	}

	@Column(name = "incicators5", length = 0)
	public String getIncicators5() {
		return this.incicators5;
	}

	public void setIncicators5(String incicators5) {
		this.incicators5 = incicators5;
	}

	@Column(name = "incicators6", length = 0)
	public String getIncicators6() {
		return this.incicators6;
	}

	public void setIncicators6(String incicators6) {
		this.incicators6 = incicators6;
	}

	@Column(name = "incicators7", length = 0)
	public String getIncicators7() {
		return this.incicators7;
	}

	public void setIncicators7(String incicators7) {
		this.incicators7 = incicators7;
	}

	@Column(name = "summary")
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "extrude")
	public String getExtrude() {
		return this.extrude;
	}

	public void setExtrude(String extrude) {
		this.extrude = extrude;
	}

	@Column(name = "advice")
	public String getAdvice() {
		return this.advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}
	@Column(name = "semester")
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	@Column(name = "flag")
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}