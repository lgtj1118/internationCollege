package com.tjpu.bean;

import java.util.List;

/**
 * @author SiyuLi
 *
 */
public class ChosenCourse1 {
	private CourseModel course;
	private List<ClassesModel> classes;
	private TeacherModel teacher;
	private ClassroomModel room;
	private int weekday;
	private int slot;
	/**
	 * 只与教室类型有关，与课程容量无关
	 */
	private String roomType; 
	/*studentNum 上课人数*/
	private int studentNum;
	public ChosenCourse1 () {studentNum = 0;}
	
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
	public ChosenCourse1 (int weekday, int slot, ClassroomModel room){
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
	public ChosenCourse1 (CourseModel course, List<ClassesModel> classes, TeacherModel teacher, String roomtype) {
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
	public int getWeekday() {
		return weekday;
	}
	public void setWeekday(int weekday) {
		this.weekday = weekday;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	
}
