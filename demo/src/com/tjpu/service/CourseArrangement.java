package com.tjpu.service;

import java.io.OutputStream;
import java.util.List;
import com.tjpu.bean.ChosenCourseModel;
import com.tjpu.bean.TeacherModel;

/**
 * @author SiyuLi
 *
 */
public interface CourseArrangement {
	public List<ChosenCourseModel> getFullTable();
	public void toExcel (OutputStream out, String ident);
	public void toExcel (java.io.FileOutputStream fos);
	public List<ChosenCourseModel> getCourses ();
	public List<ChosenCourseModel> otherOption(ChosenCourseModel course);
	public List<ChosenCourseModel> otherOption(String num);
	public void applyNewArrangement (ChosenCourseModel old, ChosenCourseModel newer);
	public void applyNewArrangementByNum (String oldnum, String newnum);
	public List<ChosenCourseModel> getUnable();
	public void SetUable (List<ChosenCourseModel> elective);
	public List<ChosenCourseModel> getSpecificTeacherTable (TeacherModel teacher);
	public List<ChosenCourseModel> getCertainSlot (int weekday, int slot, List<String> roomOrder);
}
