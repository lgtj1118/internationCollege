package com.tjpu.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tjpu.bean.ChosenCourseModel;
import com.tjpu.bean.ClassesModel;

class TableState {
	private int weekday = 5;
	//private int slot = 5;
	/*
	 * 需要检查的属性
	 * 1.老师在某时段有没有空
	 * 2.某班级在某天有没有上过某课
	 * 3.某班级在某时段有没有空
	 * 4.某教室在某时段有没有空
	 */
	/**
	 * teacherState 标识每个时段都有哪些老师在上课
	 */
	private List<Set<String>> teacherState = new ArrayList<Set<String>>();
	/**
	 * classesState  标识每个时段都有哪些班级在上课
	 */
	private List<Set<Integer>> classesState = new ArrayList<Set<Integer>>();
	
	public TableState (List<ChosenCourseModel> placedCourses, int weekday, int slot) {
		for (int i = 0; i < weekday * slot; ++i){
			teacherState.add(new HashSet<String>());
			classesState.add(new HashSet<Integer>());
		}
		for (ChosenCourseModel c : placedCourses) {
			int n = c.getWeekday() * weekday + c.getSlot();
			/*
			 * 把教师的identificationnum放入当天的集合之中
			 */
			if (c.getTeacher() == null)
				continue;
			teacherState.get(n).add(c.getTeacher().getIdentificationnum());
			/*
			 * 把班级的id放入当天的集合中
			 */
			if (c.getClasses() == null)
				continue;
			for (ClassesModel i:c.getClasses())
				classesState.get(n).add(i.getId());
		}
	}
	
	private boolean islegal (ChosenCourseModel currPlace, ChosenCourseModel newPlace){
		/*
		 * 先检查那个时间段中上课的老师是否在上其他课程
		 * 再检查班级是否在上其他课程
		 */
		if (newPlace.getCourse() == null || newPlace.getTeacher() == null
				|| currPlace.getCourse() == null || currPlace.getTeacher() == null)
			return true;
		String teacher = currPlace.getTeacher().getIdentificationnum();
		Set<Integer> classes = new HashSet<Integer>();
		int n = newPlace.getWeekday() * weekday + newPlace.getSlot();
		for (ClassesModel c : currPlace.getClasses())
			classes.add(c.getId());
		if (teacherState.get(n).contains(teacher))
			return false;
		for (Integer i  : classes)
			if (classesState.get(n).contains(i))
				return false;
		return true;
	}
	
	
	/**
	 * @param currPlace
	 * @param newPlace
	 * @return
	 * 检查currPlace的课程能否与newPlace位置进行调换
	 */
	public boolean chkOption (ChosenCourseModel currPlace, ChosenCourseModel newPlace){
		return islegal(currPlace, newPlace) && islegal(newPlace, currPlace);
	}
}