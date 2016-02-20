package com.tjpu.bean;

import java.util.List;

/**
 * @author SiyuLi
 *
 */
public class ChosenCourseModel {
	
	private String num;
	private CourseModel course;
	private List<ClassesModel> classes;
	private TeacherModel teacher;
	private ClassroomModel room;
	private Integer weekday;
	private int beginWeek = 1;
	private int endWeek = 16;
	private Integer slot;
	private String courseid;
	private String attendence ;
	private String homework ;
	private String midexam ;
	private String finalexam ;
	private String summary;
	private String stuname;
    private String coursename;
	private String passport;
	private String classname;
	private Integer ismakeup;
	private String makeup;
	private String semesterId;
	private Integer id;
	

	private boolean isElective = false;
	private boolean isSelected = false;
	private String semester ;
	/**
	 * 只与教室类型有关，与课程容量无关
	 */
	private String roomType; 
	/*studentNum 上课人数*/
	private int studentNum = 0;
	public ChosenCourseModel () {}
	
	public String toString(){
		String weekdays[] = new String[]{"Monday", "Tuesday", "Wednesday", "Thusday", "Firday", "Saturday", "Sunday"};
		return String.format("%s\t%s\t%s\t第%d大节\t %s",course.getNum(),course.getCoursename(), weekdays[weekday], slot, room.getNum());
	}
	

	
	/**
	 * @param weekday
	 * @param slot
	 * @param room
	 * 用于传递其他可能时间位置的排课算法
	 */
	public ChosenCourseModel (int weekday, int slot, ClassroomModel room){
		setRoom(room);
		setSlot(slot);
		setWeekday(weekday);
	}
	
	/**
	 * @param course
	 * @param classes
	 * @param teacher
	 * 用于排课的构造方法
	 */
	public ChosenCourseModel (CourseModel course, List<ClassesModel> classes, TeacherModel teacher, String roomtype) {
		this.course = course;
		this.classes = classes;
		this.teacher = teacher;
		this.roomType = roomtype;
		studentNum = 0;
		for (ClassesModel c : classes){
			studentNum += c.getStudents().size();
		}
	}
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	public CourseModel getCourse() {
		return course;
	}
	public void setCourse(CourseModel course) {
		this.course = course;
	}
	public List<ClassesModel> getClasses() {
		return classes;
	}
	public void setClasses(List<ClassesModel> classes) {
		this.classes = classes;
		for (ClassesModel c : classes) {
			if (c.getStudents() != null)
				studentNum += c.getStudents().size();
		}
	}
	public TeacherModel getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherModel teacher) {
		this.teacher = teacher;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public ClassroomModel getRoom() {
		return room;
	}
	public void setRoom(ClassroomModel room) {
		this.room = room;
	}
	public Integer getWeekday() {
		return weekday;
	}
	public void setWeekday(Integer weekday) {
		this.weekday = weekday;
	}
	public Integer getSlot() {
		return slot;
	}
	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	public int getBeginWeek() {
		return beginWeek;
	}

	public void setBeginWeek(int beginWeek) {
		this.beginWeek = beginWeek;
	}

	public int getEndWeek() {
		return endWeek;
	}

	public void setEndWeek(int endWeek) {
		this.endWeek = endWeek;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public boolean isElective() {
		return isElective;
	}

	public void setElective(boolean isElective) {
		this.isElective = isElective;
	}
	public String getAttendence() {
		return attendence;
	}

	public void setAttendence(String attendence) {
		this.attendence = attendence;
	}

	public String getHomework() {
		return homework;
	}

	public void setHomework(String homework) {
		this.homework = homework;
	}

	public String getMidexam() {
		return midexam;
	}

	public void setMidexam(String midexam) {
		this.midexam = midexam;
	}

	public String getFinalexam() {
		return finalexam;
	}

	public void setFinalexam(String finalexam) {
		this.finalexam = finalexam;
	}
	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}
	public Integer getIsmakeup() {
		return ismakeup;
	}

	public void setIsmakeup(Integer ismakeup) {
		this.ismakeup = ismakeup;
	}

	public String getMakeup() {
		return makeup;
	}

	public void setMakeup(String makeup) {
		this.makeup = makeup;
	}

	public String getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(String semesterId) {
		this.semesterId = semesterId;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
