package com.tjpu.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import jxl.Cell;
import jxl.CellView;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.Assistantteacher;
import com.tjpu.bean.AssistantteacherModel;
import com.tjpu.bean.Attendence;
import com.tjpu.bean.BatchRegiste;
import com.tjpu.bean.ChosenCourse;
import com.tjpu.bean.ChosenCourseModel;
import com.tjpu.bean.ClassRecord;
import com.tjpu.bean.ClassRecordModel;
import com.tjpu.bean.ClassTeacher;
import com.tjpu.bean.Classes;
import com.tjpu.bean.ClassesModel;
import com.tjpu.bean.Classroom;
import com.tjpu.bean.ClassroomModel;
import com.tjpu.bean.Course;
import com.tjpu.bean.CourseModel;
import com.tjpu.bean.Evalution;
import com.tjpu.bean.Performance;
import com.tjpu.bean.PerformanceModel;
import com.tjpu.bean.SemesterChosenClassroom;
import com.tjpu.bean.SemesterChosenCourse;
import com.tjpu.bean.Student;
import com.tjpu.bean.StudentModel;
import com.tjpu.bean.Syllabus;
import com.tjpu.bean.Teacher;
import com.tjpu.bean.TeacherModel;
import com.tjpu.bean.User;
import com.tjpu.dao.ManageDao;
import com.tjpu.dao.StudentDao;

@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	StudentDao studentDao;
    @Autowired
    ManageDao manageDao;
    @Autowired
    ManageService manageService;
    
    
	public String classlist() {
		List<Classes> classes = studentDao.loadallclasses();
		String classlist = "";
		int i = 1;
		/*Gson gson = new Gson();
		String json = gson.toJson(map);*/
		for (Classes c : classes) {
			Student student = new Student();
			if (c.getClassminitorid()!=null) {
				student = studentDao.loadstubystuid(String.valueOf(c.getClassminitorid()));
			}else {
				student = null;
			}		
			String s = null;
			Teacher headteacher = null;
			if (c.getClassteacherid() != null) {
				headteacher = manageDao.loadteacherbyidentificationnum(String.valueOf(c.getClassteacherid()));
				// type 0 是任课教师  1 是任课教师加班主任
				/*if (headteacher != null && headteacher.getType() != 1) {
					headteacher = null;
				}*/
			}
			Assistantteacher assis = null;
			if (c.getAssisTeacherId() != null && c.getAssisTeacherId().length() > 0) {
				assis = studentDao.loadAssustByNum((c.getAssisTeacherId()));
			}
			if (student == null) {
				s = "{\"Classid\":" + c.getId() + "," 
						+ "\"Classname\":" + "\""+ c.getClassname() + "\"," 
						+ "\"Classminitor\":" + "\""+ " " + "\"," 
						+ "\"ClassTeacher\":" + "\"" + "%s" + "\","	//classteacher
						+ "\"Assistantteacher\":" + "\"" + "%s" + "\","	//Assistantteacher
						+ "\"Classmajor\":" + "\""+ c.getMajor() + "\"}";
			} else {
				s = "{\"Classid\":" + c.getId() + "," 
					+ "\"Classname\":" + "\""+ c.getClassname() + "\","
					+ "\"Classminitor\":" + "\""+ student.getStuname() + "\","
					+ "\"ClassTeacher\":"+ "\"" + "%s" + "\","
					+"\"Assistantteacher\":" + "\"" + "%s" + "\","
					+ "\"Classmajor\":"+ "\"" + c.getMajor() + "\"}";
			}
			
			String teacherStr = null;
			String assisStr = null;
			if (headteacher != null) {
				teacherStr = String.format("<a class='links' onclick='setHeadTeacher(%s)'>%s</a>", c.getId(), headteacher.getTeachername());
			} else {
				teacherStr = String.format("<a class='links' onclick='setHeadTeacher(%s)'>%s</a>", c.getId(), "点击进行设置");
			}
				
			if (assis != null) {
				assisStr = String.format("<a class='links' onclick='setAssis(%s)'>%s</a>", c.getId(), assis.getName());
			} else {
				assisStr = String.format("<a class='links' onclick='setAssis(%s)'>%s</a>",  c.getId(), "点击进行设置");
			}
			
			s = String.format(s, teacherStr, assisStr);
				
			if (i < classes.size()) {
				classlist += s + ",";
			} else {
				classlist += s;
			}
			i++;
		}
		return classlist;
	}
	
	public String classlist1() {
		List<Classes> classes = studentDao.loadallclasses1();
		String classlist = "";
		int i = 1;
		/*Gson gson = new Gson();
		String json = gson.toJson(map);*/
		for (Classes c : classes) {
			Student student = new Student();
			if (c.getClassminitorid()!=null) {
				student = studentDao.loadstubystuid(String.valueOf(c.getClassminitorid()));
			}else {
				student = null;
			}		
			String s = null;
			Teacher headteacher = null;
			if (c.getClassteacherid() != null) {
				headteacher = manageDao.loadteacherbyidentificationnum(String.valueOf(c.getClassteacherid()));
				// type 0 是任课教师  1 是任课教师加班主任
				/*if (headteacher != null && headteacher.getType() != 1) {
					headteacher = null;
				}*/
			}
			Assistantteacher assis = null;
			if (c.getAssisTeacherId() != null && c.getAssisTeacherId().length() > 0) {
				assis = studentDao.loadAssustByNum((c.getAssisTeacherId()));
			}
			if (student == null) {
				s = "{\"Classid\":" + c.getId() + "," 
						+ "\"Classname\":" + "\""+ c.getClassname() + "\"," 
						+ "\"Classminitor\":" + "\""+ " " + "\"," 
						+ "\"ClassTeacher\":" + "\"" + "%s" + "\","	//classteacher
						+ "\"Assistantteacher\":" + "\"" + "%s" + "\","	//Assistantteacher
						+ "\"Classmajor\":" + "\""+ c.getMajor() + "\"}";
			} else {
				s = "{\"Classid\":" + c.getId() + "," 
					+ "\"Classname\":" + "\""+ c.getClassname() + "\","
					+ "\"Classminitor\":" + "\""+ student.getStuname() + "\","
					+ "\"ClassTeacher\":"+ "\"" + "%s" + "\","
					+"\"Assistantteacher\":" + "\"" + "%s" + "\","
					+ "\"Classmajor\":"+ "\"" + c.getMajor() + "\"}";
			}
			
			String teacherStr = null;
			String assisStr = null;
			if (headteacher != null) {
				teacherStr = String.format("<a class='links' onclick='setHeadTeacher(%s)'>%s</a>", c.getId(), headteacher.getTeachername());
			} else {
				teacherStr = String.format("<a class='links' onclick='setHeadTeacher(%s)'>%s</a>", c.getId(), "点击进行设置");
			}
				
			if (assis != null) {
				assisStr = String.format("<a class='links' onclick='setAssis(%s)'>%s</a>", c.getId(), assis.getName());
			} else {
				assisStr = String.format("<a class='links' onclick='setAssis(%s)'>%s</a>",  c.getId(), "点击进行设置");
			}
			
			s = String.format(s, teacherStr, assisStr);
				
			if (i < classes.size()) {
				classlist += s + ",";
			} else {
				classlist += s;
			}
			i++;
		}
		return classlist;
	}
	
	public String teacherclasslist() {
		User user = (User)ActionContext.getContext().getSession().get("user");
		List<Classes> classes = studentDao.loadteacherclasses(user.getUsernum());
		String classlist = "";
		int i = 1;
		/*Gson gson = new Gson();
		String json = gson.toJson(map);*/
		for (Classes c : classes) {
			Student student = new Student();
			if (c.getClassminitorid()!=null) {
				student = studentDao.loadstubystuid(String.valueOf(c.getClassminitorid()));
			}else {
				student = null;
			}		
			String s = null;
			Teacher headteacher = null;
			if (c.getClassteacherid() != null) {
				headteacher = manageDao.loadteacherbyidentificationnum(String.valueOf(c.getClassteacherid()));
				// type 0 是任课教师  1 是任课教师加班主任
				if (headteacher != null && headteacher.getType() != 1) {
					headteacher = null;
				}
			}
			Assistantteacher assis = null;
			if (c.getAssisTeacherId() != null && c.getAssisTeacherId().length() > 0) {
				assis = studentDao.loadAssustByNum((c.getAssisTeacherId()));
			}
			if (student == null) {
				s = "{\"Classid\":" + c.getId() + "," 
						+ "\"Classname\":" + "\""+ c.getClassname() + "\"," 
						+ "\"Classminitor\":" + "\""+ " " + "\"," 
						+ "\"ClassTeacher\":" + "\"" + "%s" + "\","	//classteacher
						+ "\"Assistantteacher\":" + "\"" + "%s" + "\","	//Assistantteacher
						+ "\"Classmajor\":" + "\""+ c.getMajor() + "\"}";
			} else {
				s = "{\"Classid\":" + c.getId() + "," 
					+ "\"Classname\":" + "\""+ c.getClassname() + "\","
					+ "\"Classminitor\":" + "\""+ student.getStuname() + "\","
					+ "\"ClassTeacher\":"+ "\"" + "%s" + "\","
					+"\"Assistantteacher\":" + "\"" + "%s" + "\","
					+ "\"Classmajor\":"+ "\"" + c.getMajor() + "\"}";
			}
			
			String teacherStr = null;
			String assisStr = null;
			if (headteacher != null) {
				teacherStr = String.format("<a class='links' onclick='setHeadTeacher(%s)'>%s</a>", c.getId(), headteacher.getTeachername());
			} else {
				teacherStr = String.format("<a class='links' onclick='setHeadTeacher(%s)'>%s</a>", c.getId(), "点击进行设置");
			}
				
			if (assis != null) {
				assisStr = String.format("<a class='links' onclick='setAssis(%s)'>%s</a>", c.getId(), assis.getName());
			} else {
				assisStr = String.format("<a class='links' onclick='setAssis(%s)'>%s</a>",  c.getId(), "点击进行设置");
			}
			
			s = String.format(s, teacherStr, assisStr);
				
			if (i < classes.size()) {
				classlist += s + ",";
			} else {
				classlist += s;
			}
			i++;
		}
		return classlist;
	}
	public String courseclasslist(String num) {
		String semester = manageService.getCurrSemester();
		SemesterChosenCourse semestercourse = manageDao.loadselectcoursebycourseid(num,semester);
		StringTokenizer fenxi = new StringTokenizer(semestercourse.getClass_(), "&");
		List<Classes> classes = new ArrayList<Classes>();
		while (fenxi.hasMoreTokens()) {
			String sid = fenxi.nextToken();
			int classid = Integer.parseInt(sid);
		  Classes cls =	studentDao.loadclassbyid(classid);
		  classes.add(cls);
		}
		//List<Classes> classes = studentDao.loadclasses();
		String classlist = "";
		int i = 1;
		for (Classes c : classes) {
			Student student = new Student();
			if (c.getClassminitorid()!=null) {
				student = studentDao.loadstubystuid(String.valueOf(c.getClassminitorid()));
			}else {
				student = null;
			}	
			String s = null;
			if (student == null) {
				s = "{\"Classid\":" + c.getId() + "," 
						+ "\"Classname\":" + "\""+ c.getClassname() + "\"," 
						+ "\"Classminitor\":" + "\""+ "未设置" + "\"," 
						/*+ "\"ClassTeacher\":" + "\"" +c.getClassTeacher().getName() + "\","
						+ "\"Assistantteacher\":" + "\"" + c.getAssistantteachers().getName() + "\","
						*/+ "\"Classmajor\":" + "\""+ c.getMajor() + "\"}";
						} else {
							s = "{\"Classid\":" + c.getId() + "," 
						+ "\"Classname\":" + "\""+ c.getClassname() + "\","
						+ "\"Classminitor\":" + "\""+ student.getStuname() + "\","
						/*+ "\"ClassTeacher\":"+ "\"" +c.getClassTeacher().getName() + "\","
						+"\"Assistantteacher\":" + "\"" +c.getAssistantteachers().getName() + "\","
						*/+ "\"Classmajor\":"+ "\"" + c.getMajor() + "\"}";
						}
			if (i < classes.size()) {
				classlist += s + ",";
			} else {
				classlist += s;
			}
			i++;
		}
		return classlist;
	}
	@Override
	public boolean classcheck(String classname) {
		List<Classes> havestu = studentDao.classcheck(classname);
		if (havestu.size() > 0) {
			return false;
		}
		return true;
	}
	@Override
	public List<Classes> loadclasses(Integer id, String classname ){
		return studentDao.loadclass(id,classname);
	}
	
	@Override
	public void classadd(Classes cls) {
		String classname = null;
		String major = null;
		String classnameen = null;
		try {
			classname = java.net.URLDecoder.decode(cls.getClassname(), "UTF-8");
			major = java.net.URLDecoder.decode(cls.getMajor(), "UTF-8");
			classnameen = java.net.URLDecoder.decode(cls.getClassname_en(), "UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		cls.setClassname_en(classnameen);
		cls.setClassname(classname);
		cls.setMajor(major);
		cls.setType(0);
		studentDao.classadd(cls);
	}

	@Override
	public void classupdate(Classes cls) {

		String classname = null;
		String major = null;
		String classnameen = null;
		try {
			classname = java.net.URLDecoder.decode(cls.getClassname(), "UTF-8");
			major = java.net.URLDecoder.decode(cls.getMajor(), "UTF-8");
			classnameen = java.net.URLDecoder.decode(cls.getClassname_en(), "UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		cls.setClassname_en(classnameen);
		cls.setClassname(classname);
		cls.setMajor(major);
		studentDao.classupdate(cls);
	}

	@Override
	public void classdelete(Integer id) {

		studentDao.classdelete(id);
	}
	
	@Override
	public void classrecovery(Integer id) {

		studentDao.classrecovery(id);
	}
	
	@Override
	public void graduateclass(Integer id){
		studentDao.graduateclass(id);
	}
	
	public Map<String, Object> courselist(int page, int pageSize) {

		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * User user = (User)
		 * ActionContext.getContext().getSession().get("user");
		 */
		List<Course> courses = studentDao.loadcourse((page - 1) * pageSize,pageSize/* , user.getRoles().getRolerank() */);
		long total = studentDao.coursetotal();
		List<CourseModel> coursemodels = new ArrayList<CourseModel>();
		for (Course p : courses) {
			CourseModel model = new CourseModel();
			model.setId(p.getId());
			model.setNum(p.getNum());
			model.setCoursename(p.getCoursename());
			model.setTeacher(p.getTeacher());
			model.setCharacter(p.getCharacter());
			model.setCheckway(p.getCheckway());
			model.setCredits(p.getCredits());
			model.setCoursename_en(p.getCoursename_en());
			model.setBeginweeks(p.getBeginweeks());
			model.setEndweeks(p.getEndweeks());
			model.setAcademic(p.getAcademic());
			model.setIsDeleted(p.getDeleted());
			model.setWeeklesson(p.getWeeklesson());
			model.setLessoncount((int)(p.getCredits()*16));
			coursemodels.add(model);
		}
		map.put("Total", total);
		map.put("Rows", coursemodels);
		return map;
	}
	public Map<String, Object> loadclassmap(int page, int pageSize) {

		Map<String, Object> map = new HashMap<String, Object>();
        List<Classes> clssslist = studentDao.loadclasses();
        for(int i=0;i<clssslist.size()-1;i++){
			for(int j=0;j<clssslist.size()-i-1;j++){
				if(Integer.valueOf(clssslist.get(j).getType())>Integer.valueOf(clssslist.get(j+1).getType())){
					Classes temp = null;
					temp = clssslist.get(j);
					clssslist.set(j, clssslist.get(j+1));
					clssslist.set(j+1, temp);
				}
			}
		}
        long total =clssslist.size();
		List<ClassesModel> coursemodels = new ArrayList<ClassesModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
		   if (i < clssslist.size()) {
				ClassesModel model = new ClassesModel();
				model.setId(clssslist.get(i).getId());
				Student student = new Student();
				if (clssslist.get(i).getClassminitorid()!=null) {
					student = studentDao.loadstubystuid(String.valueOf(clssslist.get(i).getClassminitorid()));
				}else {
					student = null;
				}
				if (student == null) {
					model.setClassminitor(" ");
				}else {
					model.setClassminitor(student.getStuname());
				}
				Teacher headteacher = null;
				if (clssslist.get(i).getClassteacherid() != null) {
					headteacher = manageDao.loadteacherbyidentificationnum(String.valueOf(clssslist.get(i).getClassteacherid()));
					// type 0 是任课教师  1 是任课教师加班主任
					/*if (headteacher != null && headteacher.getType() != 1) {
						headteacher = null;
					}*/
				}
				if (headteacher != null) {
					String teacherString ="<a class='links' onclick='setHeadTeacher("+clssslist.get(i).getId()+")'>"+headteacher.getTeachername()+"</a>";
					model.setClassTeacher(teacherString);
				}else {
					String teacherString ="<a class='links' onclick='setHeadTeacher("+clssslist.get(i).getId()+")'>"+"点击进行设置"+"</a>";					
					model.setClassTeacher(teacherString);
				}
				Assistantteacher assis = null;
				if (clssslist.get(i).getAssisTeacherId() != null && clssslist.get(i).getAssisTeacherId().length() > 0) {
					assis = studentDao.loadAssustByNum((clssslist.get(i).getAssisTeacherId()));
				}
				if (assis!=null) {
					String assisString ="<a class='links' onclick='setAssis("+clssslist.get(i).getId()+")'>"+assis.getName()+"</a>";
					model.setAssistantteacher(assisString);
				}else {
					String assisString ="<a class='links' onclick='setAssis("+clssslist.get(i).getId()+")'>"+"点击进行设置"+"</a>";					
					model.setAssistantteacher(assisString);
				}
				model.setClassname(clssslist.get(i).getClassname());
				model.setClassname_en(clssslist.get(i).getClassname_en());
				model.setMajor(clssslist.get(i).getMajor());
				model.setType(clssslist.get(i).getType());
				coursemodels.add(model);
		    }else {
				break;
			}			
		}
		map.put("Total", total);
		map.put("Rows", coursemodels);
		return map;
	}
	@Override
	public void courseadd(Course course) {

		Integer num = null;
		String coursename = null;
		Integer beginweeks = null;
		Integer endweeks = null;
		String teacher = null;
		float credits = 0;
		String character = null;
		String checkway = null;
		String academic = null;
		Integer weeklesson = null;
		try {
			//num = course.getNum();
			coursename = java.net.URLDecoder.decode(course.getCoursename(),"UTF-8");
			beginweeks = course.getBeginweeks();
			endweeks = course.getEndweeks();
			teacher = java.net.URLDecoder.decode(course.getTeacher(), "UTF-8");
			character = java.net.URLDecoder.decode(course.getCharacter(),"UTF-8");
			//checkway = java.net.URLDecoder.decode(course.getCheckway(), "UTF-8");
			credits = course.getCredits();
			weeklesson = course.getWeeklesson();
			academic = java.net.URLDecoder.decode(course.getAcademic(),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer number = 1251000;
		List<Course> courses = studentDao.loadcourse();
		number = number +courses.size()+1;
		String nums ="";
		if (credits>0&&credits<1) {
			nums = String.valueOf(number)+"A";
		}else if(credits>1&&credits<2) {
			nums = String.valueOf(number)+"B";
		}else {
			nums = String.valueOf(number)+(int)credits;
		}
		while(true){
			Course cs = studentDao.loadcoursebycoursenum(nums);
			if (cs==null) {
				break;
			}else {
				number++;
				if (credits>0&&credits<1) {
					nums = String.valueOf(number)+"A";
				}else if(credits>1&&credits<2) {
					nums = String.valueOf(number)+"B";
				}else {
					nums = String.valueOf(number)+credits;
				}
			}
		}
		//num = Integer.valueOf(nums);
		course.setNum(nums);
		course.setBeginweeks(beginweeks);
		course.setCharacter(character);
		//course.setCheckway(checkway);
		course.setCoursename(coursename);
		course.setCredits(credits);
		course.setEndweeks(endweeks);
		course.setTeacher(teacher);
		course.setAcademic(academic);
		course.setWeeklesson(weeklesson);
		course.setDeleted(0);
		studentDao.courseadd(course);
	}	
	
	@Override
	public void courseupdate(Course course, User user) {
		String num = null;
		String coursename = null;
		Integer beginweeks = null;
		Integer endweeks = null;
		String teacher = null;
		float credits = 0;
		String character = null;
		//String checkway = null;
		String academic = null;
		Integer weeklesson = null;
		Course c = manageDao.getCourseByNum2(String.valueOf(course.getNum()));
		String log = String.format("W:%d-%dC:%.1fWL:%d", c.getBeginweeks(), c.getEndweeks(), c.getCredits(), c.getWeeklesson());
		ModifyLog(user, "modifyCourse", log);
		try {
			num = course.getNum();
			coursename = java.net.URLDecoder.decode(course.getCoursename(),"UTF-8");
			beginweeks = course.getBeginweeks();
			endweeks = course.getEndweeks();
			teacher = java.net.URLDecoder.decode(course.getTeacher(), "UTF-8");
			character = java.net.URLDecoder.decode(course.getCharacter(),"UTF-8");
			//checkway = java.net.URLDecoder.decode(course.getCheckway(), "UTF-8");
			credits = course.getCredits();
			weeklesson = course.getWeeklesson();
			academic = java.net.URLDecoder.decode(course.getAcademic(),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*if (String.valueOf(c.getCredits()).equals(credits)) {
			course.setNum(num);
		}else {
			if (credits>0&&credits<1) {
				num = c.getNum().substring(0, c.getNum().length()-1)+"A";
			}else if (credits>1&&credits<2) {
				num = c.getNum().substring(0, c.getNum().length()-1)+"B";
			}else {
				num = c.getNum().substring(0, c.getNum().length()-1)+(int)credits;
			}
			//List<Attendence> attendences = manageDao.loadcourseattendence();
		}*/
		course.setNum(num);
		course.setBeginweeks(beginweeks);
		course.setCharacter(character);
		//course.setCheckway(checkway);
		course.setCoursename(coursename);
		course.setCredits(credits);
		course.setEndweeks(endweeks);
		course.setTeacher(teacher);
		course.setAcademic(academic);
		course.setWeeklesson(weeklesson);
		studentDao.courseupdate(course);
	}

	@Override
	public void coursedelete(Integer id) {
		studentDao.coursedelete(id);
	}
	@Override
	public void courserecovery(Integer id) {
		studentDao.courserecovery(id);
	}

	@Override
	public boolean coursecheck(String coursename) {

		List<Course> havecourse = studentDao.coursecheck(coursename);
		if (havecourse.size() > 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean coursecheck1(String num) {

		List<Course> havecourse = studentDao.coursecheck1(num);
		if (havecourse.size() > 0) {
			return false;
		}
		return true;
	}

	@Override
	public Map<String, Object> roomlist(int page, int pageSize) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Classroom> room = studentDao.loadroom((page - 1) * pageSize,pageSize);
		// long total = room.size();
		long total = studentDao.totalroom();
		List<ClassroomModel> roommodels = new ArrayList<ClassroomModel>();
		for (Classroom s : room) {
			ClassroomModel model = new ClassroomModel();
			model.setId(s.getId());
			model.setNum(String.valueOf(s.getNum()));
			model.setRoomname(s.getRoomname());
			model.setRoomplace(s.getRoomplace());
			model.setRoomtype(s.getRoomtype());
			model.setRoomcapacity(String.valueOf(s.getRoomcapacity()));
			model.setRealcapacity(String.valueOf(s.getRealcapacity()));
			model.setNote(s.getNote());
			model.setIsavaible(s.getIsavaible());
			model.setDeleted(s.getDeleted());
			roommodels.add(model);
		}
		map.put("Total", total);
		map.put("Rows", roommodels);
		return map;
	}

	@Override
	public void roomadd(Classroom room) {

		//String num = null;
		String roomname = null;
		String roomplace = null;
		String roomtype = null;
		Integer roomcapacity = null;
		Integer realcapacity = null;
		String note = null;
		try {
			//num = java.net.URLDecoder.decode(room.getNum(), "UTF-8");
			roomname = java.net.URLDecoder.decode(room.getRoomname(), "UTF-8");
			roomplace = java.net.URLDecoder.decode(room.getRoomplace(), "UTF-8");
			roomtype = java.net.URLDecoder.decode(room.getRoomtype(), "UTF-8");
			roomcapacity = room.getRoomcapacity();
			realcapacity = room.getRealcapacity();
			note = java.net.URLDecoder.decode(room.getNote(), "UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		room.setNote(note);
		//room.setNum(num);
		room.setRoomcapacity(roomcapacity);
		room.setRealcapacity(realcapacity);
		room.setRoomname(roomname);
		room.setRoomname(roomname);
		room.setRoomplace(roomplace);
		room.setIsavaible(0);
		room.setDeleted(0);
		room.setRoomtype(roomtype);
		studentDao.roomadd(room);
	}
	@Override
	public Map<String, Object> roomaddbytxt(String path) {
		//List<String> lines = readTxtFile(path);
		Map<String, Object> ret = new HashMap<String, Object>();
		List<BatchRegiste> fail = new ArrayList<BatchRegiste>();
		Integer count = 0;
		String test[] = path.split("\\.");
		if (test.length!=0&&!test[test.length-1].equals("xls")) {
			BatchRegiste br= new BatchRegiste();
			br.setLine("");
			br.setReason("只能接受以 xls 后缀名的Excel文件");
			fail.add(br);
			ret.put("Count", count);
			ret.put("Fail", fail);
			return ret;
		}
		for (List<String> items:getItems(path)) {
			if (items.size()==0) {
				continue;
			}
			String errMsg = roomChk(items);
			if (errMsg == null) {
				studentDao.roomadd(formateRoom(items));
				++ count;
			} else {
				BatchRegiste br = new BatchRegiste();
				StringBuffer bf = new StringBuffer();
				for (String s:items) {
					bf.append(s+" ");
				}
				br.setLine(bf.toString());
				br.setReason(errMsg);
				fail.add(br);
			}
		}
		
		ret.put("Count", count);
		ret.put("Fail", fail);
		
		return ret;
	}
	private String roomChk (List<String> items) {
		if (items.size() != 5) {
			return "无法匹配正确的项";
		}
		int i = 0;
		String roomname = items.get(i++);
		if(roomname.length()==0)
		   return "教室名称不能为空!";
		List<Classroom> roomlist = studentDao.loadclassroombyname(roomname);
		if(roomlist.size()>0){
			return "该教室名称已存在！";
		}
		String roomplace = "[a-zA-Z\u4e00-\u9fa5]{2,}";
		if(!Pattern.matches(roomplace, items.get(i++))){
			return "教室位置不能全为数字";
		}
		List<String> chineseName = new ArrayList<String>(Arrays.asList("多媒体教室","计算机室","语音室","体验馆"));
		if (!chineseName.contains(items.get(i++))){
			return "教室类型只能为多媒体教室，计算机室，语音室，体验馆";
		}
		String reg = "^[0-9]*$";
		String roomcapacity = items.get(i++);
		if(!Pattern.matches(reg, roomcapacity)){
			return "教室容量应为数字";
		}
		String realcapacity = items.get(i++);
		if(!Pattern.matches(reg, realcapacity)){
			return "教室实际容量应为数字";
		}
		if(Integer.valueOf(realcapacity)>Integer.valueOf(roomcapacity))
			return "教室实际容量不能大于标准容量";
		return null;
	}
	private Classroom formateRoom (List<String> line) {
		Classroom classroom = new Classroom();
		int i = 0;
		classroom.setRoomname(line.get(i++));
		classroom.setRoomplace(line.get(i++));
		classroom.setRoomtype(line.get(i++));
		classroom.setRoomcapacity(Integer.valueOf(line.get(i++)));
		classroom.setRealcapacity(Integer.valueOf(line.get(i++)));
		classroom.setDeleted(0);
		classroom.setIsavaible(0);
		return classroom;
	}
	@Override
	public void roomupdate(Classroom room) {

		//String num = null;
		String roomname = null;
		String roomplace = null;
		String roomtype = null;
		Integer roomcapacity = null;
		Integer realcapacity = null;
		String note = null;
		Integer isavaible = null;
		try {
			//num = java.net.URLDecoder.decode(room.getNum(), "UTF-8");
			roomname = java.net.URLDecoder.decode(room.getRoomname(), "UTF-8");
			roomplace = java.net.URLDecoder.decode(room.getRoomplace(), "UTF-8");
			roomtype = java.net.URLDecoder.decode(room.getRoomtype(), "UTF-8");
			roomcapacity = room.getRoomcapacity();
			realcapacity = room.getRealcapacity();
			note = java.net.URLDecoder.decode(room.getNote(), "UTF-8");
			isavaible = room.getIsavaible();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		room.setNote(note);
		//room.setNum(num);
		room.setRoomcapacity(roomcapacity);
		room.setRealcapacity(realcapacity);
		room.setRoomname(roomname);
		room.setRoomplace(roomplace);
		room.setRoomtype(roomtype);
		room.setIsavaible(isavaible);
		studentDao.roomupdate(room);
	}

	@Override
	public void roomdelete(Integer id) {
        studentDao.roomdelete(id);
	}
	@Override
	public void roomrecovery(Integer id) {
        studentDao.roomrecovery(id);
	}
	@Override
	public boolean roomcheck(Integer roomnum) {

		List<Classroom> haveroom = studentDao.roomcheck(roomnum);
		if (haveroom.size() > 0) {
			return false;
		}
		return true;
	}
	@Override
	public boolean roomcheck1(String roomname) {

		List<Classroom> haveroom = studentDao.roomcheck1(roomname);
		if (haveroom.size() > 0) {
			return false;
		}
		return true;
	}
	@Override
	public List<Classroom> roomcheckagain(Integer id, String num) {

		return studentDao.roomcheckagain(id,num);
	}

	List<Student> stus = new ArrayList<Student>();

	@Override
	public List<Student> loadstulistbyclassid(int classid) {

		stus.clear();
		stus = studentDao.loadstubyclassid(classid);
		return null;
	}

	@Override
	public Map<String, Object> classstumap(int page, int pageSize) {

		Map<String, Object> map = new HashMap<String, Object>();
		long total = stus.size();
		List<StudentModel> stumodels = new ArrayList<StudentModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < stus.size()) {
				StudentModel model = new StudentModel();
				try {
					model.setClassid(stus.get(i).getClasses().getId());
				} catch (Exception e) {
					model.setClassid(0);
				}
				model.setId(stus.get(i).getId());
				model.setPassword(stus.get(i).getPassword());
				model.setStusex(stus.get(i).getSex());
				model.setStuid(stus.get(i).getStuid());
				model.setStuname(stus.get(i).getStuname());
				model.setFirstname(stus.get(i).getFirstname());
				model.setLastname(stus.get(i).getLastname());
				model.setNation(stus.get(i).getNation());
				model.setPassport(stus.get(i).getPassport());
				model.setRoomplace(stus.get(i).getRoomplace());
				model.setTelephone(stus.get(i).getTelephone());
				model.setStudentType(stus.get(i).getStudentType());
				model.setBrithdate(stus.get(i).getBrithdate());
				model.setEnddate(stus.get(i).getEnddate());
				model.setStartdate(stus.get(i).getStartdate());
				List<ChosenCourse> chosenCourses = manageDao.loadsinglestuscore(stus.get(i).getPassport());
				float totalcredits = 0;
				if(chosenCourses==null){
					model.setTotalcredits(String.valueOf(totalcredits));
				}else {
					for(ChosenCourse c:chosenCourses){
						if (c.getSummary()<60&&c.getIsmakeup()==0) {
							continue;
						}else {
							SemesterChosenCourse semesterChosenCourse = manageDao.loadselectcoursebycourseid(c.getCourseId(), c.getSemester());
							if(semesterChosenCourse==null){
								continue;
							}else{
								totalcredits = totalcredits+Float.valueOf(semesterChosenCourse.getCredits());						
							}
						}											
					}
					model.setTotalcredits(String.valueOf(totalcredits));
				}				
				model.setStandardcredits(String.valueOf(4.0));
				model.setStatus(stus.get(i).getStatus());
				stumodels.add(model);
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", stumodels);
		return map;
	}

	@Override
	public String classteacherlist() {
		return null;
	}

	@Override
	public String assistteacherlist() {
		return null;
	}

	@Override
	public List<Course> loadcourse() {
/*		User user = (User) ActionContext.getContext().getSession().get("user");
		List<Course> courses = studentDao.loadstucourse();
		return courses;*/
		User user = (User)ActionContext.getContext().getSession().get("user");
		String semester = manageService.getCurrSemester();
		List<ChosenCourse> chosencourses = studentDao.loadstucourse(user.getUsernum(),semester);
		List<Course> courses = new ArrayList<Course>(); 
		if (chosencourses==null) {
			courses=null;
		}else {
			for(ChosenCourse c:chosencourses){
				Course course = manageDao.loadCourseByIdent(String.valueOf(c.getCourseId()));
				courses.add(course);
			}
		}
		
		return courses;
	}

	@Override
	public Map<Integer, List<Course>> coursemap() {

		User user = (User) ActionContext.getContext().getSession().get("user");
		String semester = manageService.getCurrSemester();
		List<ChosenCourse> stuchosencourse = manageDao.loadstuscore(semester,user.getUsernum());
		List<Course> courses = new ArrayList<Course>();
		for(ChosenCourse c:stuchosencourse){
			Course course = studentDao.loadcoursebynum(String.valueOf(c.getCourseId()));
			SemesterChosenCourse semesterchosencourse = manageDao.loadselectcoursebycourseid(c.getCourseId(),semester);
			if (semesterchosencourse==null) {
				course.setTeacher(null);
				courses.add(course);
			}else {
				Teacher teacher = manageDao.loadteacherbyidentificationnum(semesterchosencourse.getTeacherid());			
				String teachername="";
				if(teacher!=null){
					teachername = teacher.getTeachername();
				}
				
					course.setTeacher(teachername);			
				courses.add(course);
			}			
		}
		Integer flag = 0;
		List<Evalution> evalutions = studentDao.loadevalutions(user.getUsernum(),semester,flag);		
		Map<Integer, List<Course>> map = new HashMap<Integer, List<Course>>();
		List<Course> course1 = new ArrayList<Course>();
		course1 = courses;
		List<Course> course2 = new ArrayList<Course>();
		for (int i = 0; i < courses.size(); i++) {			
			if(evalutions.size()==0){
				break;
			}else {
				for (int j = 0; j < evalutions.size(); j++) {
					if ((user.getUsernum().equals(evalutions.get(j).getPassport()))&& (courses.get(i).getNum().equals(evalutions.get(j).getCourseid()))) {
						if(!course2.contains(course1.get(i))){
							course2.add(courses.get(i));
							//course1.remove(i);
						}						
					}
				}	
			}					
		}
		for (int i = 0; i < course2.size(); i++) {	
			if(course1.containsAll(course2)){
				course1.removeAll(course2);
			}
		}
		map.put(1, course2);
		map.put(0, course1);
		return map;
	}
	@Override
	public Map<Integer, Teacher> teachermap() {

		User user = (User) ActionContext.getContext().getSession().get("user");
		String semester = manageService.getCurrSemester();
		Student stu = studentDao.loadstubystuid(user.getUsernum());
		Teacher teacher = manageDao.loadteacherbyidentificationnum(String.valueOf(stu.getClasses().getClassteacherid()));
		Integer flag = 1;
		List<Evalution> evalutions = studentDao.loadevalutions(user.getUsernum(),semester,flag);		
		Map<Integer, Teacher> map = new HashMap<Integer, Teacher>();
		Integer num =0;
		for(Evalution e:evalutions){
			if (e.getTeacher().equals(teacher.getIdentificationnum())) {
				num++;
			}
		}
		if (num==0) {
			map.put(1, null);
			map.put(0, teacher);
		}else {
			map.put(0, null);
			map.put(1, teacher);
		}
		
		return map;
	}
	@Override
	public Course loadcoursebyid(Integer id) {
		Course course = studentDao.loadcoursebyid(id);
		return course;
	}

	@Override
	public void assistantteacherapply(Assistantteacher assistantteacher) {

		String name = null;
		String classname = null;
		String major = null;
		String secondlanguagetype = null;
		String secondlanguagelevel = null;
		String nation = null;
		String brithdate = null;
		String politicalstatus = null;
		String forte = null;
		String telephone = null;
		String email = null;
		String assistnum = null;
		String department = null;
		String edulevel = null;
		String gender = null;
		String responsiblename = null;
		String responsibletelephone = null;
		try {
			name = java.net.URLDecoder.decode(assistantteacher.getName(),"UTF-8");
			classname = java.net.URLDecoder.decode(assistantteacher.getClassname(), "UTF-8");
			major = java.net.URLDecoder.decode(assistantteacher.getMajor(),"UTF-8");
			secondlanguagetype = java.net.URLDecoder.decode(assistantteacher.getSecondlanguagetype(), "UTF-8");
			secondlanguagelevel = java.net.URLDecoder.decode(assistantteacher.getSecondlanguagelevel(), "UTF-8");
			nation = java.net.URLDecoder.decode(assistantteacher.getNation(),"UTF-8");
			brithdate = java.net.URLDecoder.decode(assistantteacher.getBrithdate(), "UTF-8");
			politicalstatus = java.net.URLDecoder.decode(assistantteacher.getPoliticalstatus(), "UTF-8");
			forte = java.net.URLDecoder.decode(assistantteacher.getForte(),"UTF-8");
			telephone = java.net.URLDecoder.decode(assistantteacher.getTelephone(), "UTF-8");
			email = java.net.URLDecoder.decode(assistantteacher.getEmail(),"UTF-8");
			assistnum = java.net.URLDecoder.decode(assistantteacher.getAssistantnum(), "UTF-8");
			department = java.net.URLDecoder.decode(assistantteacher.getDepartment(), "UTF-8");
			edulevel = java.net.URLDecoder.decode(assistantteacher.getEdulevel(), "UTF-8");
			gender = java.net.URLDecoder.decode(assistantteacher.getGender(),"UTF-8");
			responsiblename = java.net.URLDecoder.decode(assistantteacher.getResponsiblename(),"UTF-8");
			responsibletelephone = java.net.URLDecoder.decode(assistantteacher.getResponsibletelephone(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		assistantteacher.setName(name);
		assistantteacher.setClassname(classname);
		assistantteacher.setMajor(major);
		assistantteacher.setSecondlanguagelevel(secondlanguagelevel);
		assistantteacher.setSecondlanguagetype(secondlanguagetype);
		assistantteacher.setNation(nation);
		assistantteacher.setBrithdate(brithdate);
		assistantteacher.setPoliticalstatus(politicalstatus);
		assistantteacher.setForte(forte);
		assistantteacher.setTelephone(telephone);
		assistantteacher.setEmail(email);
		assistantteacher.setEdulevel(edulevel);
		assistantteacher.setAssistantnum(assistnum);
		assistantteacher.setGender(gender);
		assistantteacher.setDepartment(department);
		assistantteacher.setAcademictype(1);
		assistantteacher.setResponsiblename(responsiblename);
		assistantteacher.setResponsibletelephone(responsibletelephone);
		studentDao.assistantteacheradd(assistantteacher);
	}
	@Override
	public void assistantteacherupdate(Assistantteacher assistantteacher) {

		String name = null;
		String classname = null;
		String major = null;
		String secondlanguagetype = null;
		String secondlanguagelevel = null;
		String nation = null;
		String brithdate = null;
		String politicalstatus = null;
		String forte = null;
		String telephone = null;
		String email = null;
		String assistnum = null;
		String department = null;
		String edulevel = null;
		String gender = null;
		try {
			name = java.net.URLDecoder.decode(assistantteacher.getName(),"UTF-8");
			classname = java.net.URLDecoder.decode(assistantteacher.getClassname(), "UTF-8");
			major = java.net.URLDecoder.decode(assistantteacher.getMajor(),"UTF-8");
			secondlanguagetype = java.net.URLDecoder.decode(assistantteacher.getSecondlanguagetype(), "UTF-8");
			secondlanguagelevel = java.net.URLDecoder.decode(assistantteacher.getSecondlanguagelevel(), "UTF-8");
			nation = java.net.URLDecoder.decode(assistantteacher.getNation(),"UTF-8");
			brithdate = java.net.URLDecoder.decode(assistantteacher.getBrithdate(), "UTF-8");
			politicalstatus = java.net.URLDecoder.decode(assistantteacher.getPoliticalstatus(), "UTF-8");
			forte = java.net.URLDecoder.decode(assistantteacher.getForte(),"UTF-8");
			telephone = java.net.URLDecoder.decode(assistantteacher.getTelephone(), "UTF-8");
			email = java.net.URLDecoder.decode(assistantteacher.getEmail(),"UTF-8");
			assistnum = java.net.URLDecoder.decode(assistantteacher.getAssistantnum(), "UTF-8");
			department = java.net.URLDecoder.decode(assistantteacher.getDepartment(), "UTF-8");
			edulevel = java.net.URLDecoder.decode(assistantteacher.getEdulevel(), "UTF-8");
			gender = java.net.URLDecoder.decode(assistantteacher.getGender(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		assistantteacher.setName(name);
		assistantteacher.setClassname(classname);
		assistantteacher.setMajor(major);
		assistantteacher.setSecondlanguagelevel(secondlanguagelevel);
		assistantteacher.setSecondlanguagetype(secondlanguagetype);
		assistantteacher.setNation(nation);
		assistantteacher.setBrithdate(brithdate);
		assistantteacher.setPoliticalstatus(politicalstatus);
		assistantteacher.setForte(forte);
		assistantteacher.setTelephone(telephone);
		assistantteacher.setEmail(email);
		assistantteacher.setEdulevel(edulevel);
		assistantteacher.setAssistantnum(assistnum);
		assistantteacher.setGender(gender);
		assistantteacher.setDepartment(department);
		assistantteacher.setAcademictype(1);
		studentDao.assistantteacherupdate(assistantteacher);
	}
	
	public List<AssistantteacherModel> loadAllAssis (){
		List<AssistantteacherModel> models = new ArrayList<AssistantteacherModel>();
		for (Assistantteacher s :studentDao.loadAllAssis()) {
			AssistantteacherModel model = new AssistantteacherModel();
			model.setId(s.getId());
			model.setAssistantnum(s.getAssistantnum());
			model.setBrithdate(s.getBrithdate());
			model.setClassname(s.getClassname());
			model.setDepartment(s.getDepartment());
			model.setEdulevel(s.getEdulevel());
			model.setEmail(s.getEmail());
			model.setForte(s.getForte());
			model.setGender(s.getGender());
			model.setMajor(s.getMajor());
			model.setName(s.getName());
			model.setNation(s.getNation());
			model.setPoliticalstatus(s.getPoliticalstatus());
			model.setSecondlanguagelevel(s.getSecondlanguagelevel());
			model.setSecondlanguagetype(s.getSecondlanguagetype());
			model.setTelephone(s.getTelephone());
			model.setAcademicadvice(s.getAcademicadvice());
			model.setAcademictype(s.getAcademictype());
			models.add(model);
		}
		return models;
	}
	
	
	
	
	@Override
	public Map<String, Object> assistmap(int page, int pageSize) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Assistantteacher> stus = studentDao.loadassist((page - 1)* pageSize, pageSize);
		long total = studentDao.totalassist();
		List<AssistantteacherModel> stumodels = new ArrayList<AssistantteacherModel>();
		for (Assistantteacher s : stus) {
			AssistantteacherModel model = new AssistantteacherModel();
			List<Classes> classlist = studentDao.loadassistbyclass(s.getAssistantnum());
			String assistclass="";
			for(Classes c:classlist){
				assistclass = assistclass+" "+c.getClassname()+"";
			}
			model.setAssistclass(assistclass);
			model.setId(s.getId());
			model.setAssistantnum(s.getAssistantnum());
			model.setBrithdate(s.getBrithdate());
			model.setClassname(s.getClassname());
			model.setDepartment(s.getDepartment());
			model.setEdulevel(s.getEdulevel());
			model.setEmail(s.getEmail());
			model.setForte(s.getForte());
			model.setGender(s.getGender());
			model.setMajor(s.getMajor());
			model.setName(s.getName());
			model.setNation(s.getNation());
			model.setPoliticalstatus(s.getPoliticalstatus());
			model.setSecondlanguagelevel(s.getSecondlanguagelevel());
			model.setSecondlanguagetype(s.getSecondlanguagetype());
			model.setTelephone(s.getTelephone());
			model.setAcademicadvice(s.getAcademicadvice());
			model.setAcademictype(s.getAcademictype());
			model.setResponsiblename(s.getResponsiblename());
			model.setResponsibletelephone(s.getResponsibletelephone());
			stumodels.add(model);
		}
		map.put("Total", total);
		map.put("Rows", stumodels);
		return map;
	}

	@Override
	public void assistagree(Integer id) {

		studentDao.assistagree(id);
	}

	private List<String> readTxtFile(String filePath) {
		List<String> linelist = new ArrayList<String>();
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					linelist.add(lineTxt);
				}
				read.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return linelist;
	}

	private String courseChk (List<String> items) {
		if (items.size() != 8) {
			return "无法正确匹配对应项";
		}
		int i = 0;
		
		String reg = "(?!0)\\d{8}";
		/*String num = items.get(i++);
		if (!Pattern.matches(reg, num)) {
			return "课程编号应由起始不为0的8位数字构成";
		}
		Course c = loadcoursebynum(Integer.parseInt(num));
		if (c != null) {
			return "课程编号重复";
		}*/
		//reg = "[0-9A-Za-z\u4e00-\u9fa5]{2,}";
		reg = "\\S{2,}";
		if (!Pattern.matches(reg, items.get(i++))) {
			return "课程名称格式由汉字英文数字构成";
		}
		reg = "[0-9A-Za-z]{2,}";
		if (!Pattern.matches(reg, items.get(i++))) {
			return "课程名英文名称格式不正确";
		}
		try {
			Integer starting = Integer.parseInt(items.get(i++));
			Integer ending = Integer.parseInt(items.get(i++));
			if (starting < 0 || ending < 0) {
				return "起始周结束周不能为负数";
			}
			if (ending < starting) {
				return "起始周不能晚于结束周";
			}
			if (ending > 21) {
				return "结束周不能晚于21周";
			}
		} catch (NumberFormatException e) {
			return "起始周、结束周、只能有正整数组成";
		}
		reg = "^10|(^([0-9]{1})(\\.[5]{0,5})?)$";
			//float credit = Float.parseFloat(items.get(i++));
		if (!Pattern.matches(reg, items.get(i++))) {
				return "学分只能为0-9之间的数字，如存在不足1学分，只能为0.5学分";
		}
		try {	
			Integer weeklesson = Integer.parseInt(items.get(i++));
			if ((weeklesson <0)||(weeklesson >10)) {
				return "周学时只能为1-10的正整数";
			}
		} catch (NumberFormatException e) {
			return "周学时只能有正整数组成";
		}
		
		String type = items.get(i++);
		if (!type.equals("必修") && !type.equals("限选") && !type.equals("任选")) {
			return "课程类型为必修、限选、任选之一";
		}
		
		String college = items.get(i++);
		List<String> colleges = new ArrayList<String>(Arrays.asList("国际教育学院","纺织学院","材料科学与工程学院","环境与化学工程学院",
				"机械工程学院","计算机科学与软件学院","电气工程与自动化学院","电子与信息工程学院","理学院",
				"艺术与服装学院","管理学院","经济学院","人文与法学院","外国语学院",
				"马克思主义学院","应用技术学院","继续教育学院"));
		
		if (!colleges.contains(college)) {
			String ret = "所在学院为以下学院之一：";
			for (String j : colleges){
				ret += j + ",";
			}
			return  ret;
		}
		/*if (items.size() > 7) {
			reg = "[a-zA-Z\u4e00-\u9fa5]{1,}";
			if (!Pattern.matches(reg, items.get(i++))){
				return "教师姓名格式不正确";
			}
		}*/
		return null;
	}
	
	private Course formateCourse(List<String> items) {
		Course c = new Course();
		int i = 0;		
		//c.setNum(Integer.parseInt(items.get(i++)));
		c.setCoursename(items.get(i++));
		c.setCoursename_en(items.get(i++));
		c.setBeginweeks(Integer.parseInt(items.get(i++)));
		c.setEndweeks(Integer.parseInt(items.get(i++)));
		String credits = items.get(i++);
		c.setCredits(Float.parseFloat(credits));
		c.setWeeklesson(Integer.parseInt(items.get(i++)));
		c.setCharacter(items.get(i++));
		c.setAcademic(items.get(i++));
		c.setDeleted(0);
		Integer number = 1251000;
		List<Course> courses = studentDao.loadcourse();
		number = number +courses.size()+1;
		String nums = "";
		if (Float.parseFloat(credits)>0&&Float.parseFloat(credits)<1) {
			nums = String.valueOf(number)+"A";
		}else if(Float.parseFloat(credits)>1&&Float.parseFloat(credits)<2) {
			nums = String.valueOf(number)+"B";
		}else {
			nums = String.valueOf(number)+credits;
		}		
		//Integer num = Integer.valueOf(nums);
		c.setNum(nums);
		/*if (items.size() == 8) {
			c.setTeacher(items.get(i++));
		}*/
		return c;
	}
	
	public Map<String, Object> batchAddCourses (String path) {
		//List<String> lines = readTxtFile(path);
		Map<String, Object> ret = new HashMap<String, Object>();
		List<BatchRegiste> fail = new ArrayList<BatchRegiste>();
		Integer count = 0;
		String test[] = path.split("\\.");
		if (test.length!=0&&!test[test.length-1].equals("xls")) {
			BatchRegiste br= new BatchRegiste();
			br.setLine("");
			br.setReason("只能接受以 xls 后缀名的Excel文件");
			fail.add(br);
			ret.put("Count", count);
			ret.put("Fail", fail);
			return ret;
		}
		for (List<String> items:getItems(path)) {
			if (items.size() == 0) {
				continue;
			}
			String errMsg = courseChk(items);
			if (errMsg == null) {
				studentDao.courseadd(formateCourse(items));
				++ count;
			} else {
				BatchRegiste br = new BatchRegiste();
				StringBuffer bf = new StringBuffer();
				for(String s:items){
					bf.append(s+" ");
				}
				br.setLine(bf.toString());
				br.setReason(errMsg);
				fail.add(br);
			}
		}
		
		ret.put("Count", count);
		ret.put("Fail", fail);
		
		return ret;
	}
	private List<List<String>> getItems(String path){
		List<List<String>> ret = new ArrayList<List<String>>();
		try {
			Workbook wb = Workbook.getWorkbook( new FileInputStream(path));
			Sheet[] sheets = wb.getSheets();
			for (Sheet sheet : sheets) {
				int ROWS = sheet.getRows();
				int COLS = sheet.getColumns();
				for (int r = 0; r < ROWS; ++r) {
					List<String> items = new ArrayList<String>();
					for (int c = 0; c < COLS; ++c) {
						Cell cell = sheet.getCell(c, r);
						items.add(cell.getContents());
					}
					ret.add(items);
				}

			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	
	public Map<String, Object> batchSetUpClass (String path){
		//List<String> lines = readTxtFile(path);
		Map<String, Object> ret = new HashMap<String, Object>();
		List<BatchRegiste> fail = new ArrayList<BatchRegiste>();
		Integer count = 0;
		String test[] = path.split("\\.");
		if (test.length!=0&&!test[test.length-1].equals("xls")) {
			BatchRegiste br= new BatchRegiste();
			br.setLine("");
			br.setReason("只能接受以 xls 后缀名的Excel文件");
			fail.add(br);
			ret.put("Count", count);
			ret.put("Fail", fail);
			return ret;
		}
						
		for (List<String> items:getItems(path)) {
			/*StringTokenizer tk = new StringTokenizer(line);
			
			List<String> items = new ArrayList<String>();
			while (tk.hasMoreElements()) {
				items.add(tk.nextToken());
			}*/
			
			if (items.size() == 0) {
				continue;
			}
			String errMsg = classChk(items);
			if (errMsg == null) {
				studentDao.classadd(formateClass(items));
				++ count;
			} else {
				BatchRegiste br = new BatchRegiste();
				StringBuffer bf = new StringBuffer();
				for(String s:items){
					bf.append(s+" ");
				}
				br.setLine(bf.toString());
				br.setReason(errMsg);
				fail.add(br);
			}
		}
		
		ret.put("Count", count);
		ret.put("Fail", fail);
		
		return ret;
	}
	
	public Classes formateClass (List<String> items) {
		int i = 0;
		Classes c = new Classes();
		c.setClassname(items.get(i++));
		c.setClassname_en(items.get(i++));
		c.setMajor(items.get(i++));
		c.setType(0);
		return c;
	}
	
	private String classChk (List<String> items) {
		if (items.size() != 3) {
			return "无法匹配正确的项";
		}
		int i = 0;
		String reg = "\\w*[a-zA-Z\u4e00-\u9fa50-9]+\\w*";
		String className = items.get(i++);
		if (!Pattern.matches(reg, className)){
			return "班级只能由中英文和数字组成，且不能全为数字";
		}
		List<Classes> cls = studentDao.loadclassbyclassname(className);
		if (cls != null && cls.size() > 0) {
			return "班级名称已存在";
		}
		reg = "[a-zA-Z0-9]{2,}";
		if (!Pattern.matches(reg, items.get(i++))){
			return "班级英文名格式错误";
		}
		reg = "[\u4e00-\u9fa5]{2,}";
		String major = items.get(i++);
		if (!Pattern.matches(reg, major)){
			return "专业名应由2个或以上的汉字组成";
		}
		return null;
	}
	
	
	public List<Classes> classaddbytxt(String path) {
        List<Classes> classlist = new ArrayList<Classes>();
		try {
			List<String> linelist = readTxtFile(path);
			for (String line : linelist) {
				StringTokenizer tokenizer = new StringTokenizer(line);
				if (tokenizer.hasMoreTokens()) {
					// String s = tokenizer.nextToken();
					Classes classes = new Classes();					
					String classname = tokenizer.nextToken();
					List<Classes> cls = studentDao.loadclassbyclassname(classname);
					if (cls.size()==0) {
						classes.setClassname(classname);
						classes.setMajor(tokenizer.nextToken());
						studentDao.classadd(classes);
					}else {
						Classes clss = new Classes();
						clss.setClassname(classname);
						clss.setMajor(tokenizer.nextToken());
						classlist.add(clss);
						continue;
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		return classlist;
	}

	@Override
	public void classminitorset(Integer classid, String stuid) {

		studentDao.classminitorset(classid, stuid);
	}

	@Override
	public Map<String, Object> workrecordmap(int page, int pageSize) {
		User user = (User) ActionContext.getContext().getSession().get("user");
		Teacher teacher = manageDao.loadteacherbyidentificationnum(user.getUsernum());
		Map<String, Object> map = new HashMap<String, Object>();
		List<ClassRecord> classrecord = studentDao.loadworkrecord((page - 1)* pageSize, pageSize,teacher.getIdentificationnum());
		long total = studentDao.totalclassrecord();
		List<ClassRecordModel> stumodels = new ArrayList<ClassRecordModel>();
		for (ClassRecord s : classrecord) {
			ClassRecordModel model = new ClassRecordModel();
			model.setId(s.getId());
			model.setAppointmentnumber(s.getAppointmentnumber());
			Classes classes = studentDao.loadclassbyid(s.getClassid());
			model.setClassname(classes.getClassname());
			model.setClassmeetingfrequency(s.getClassmeetingfrequency());
			model.setDate(s.getDate());
			model.setFeedback(s.getFeedback());
			model.setPhysicalmentalcondition(s.getPhysicalmentalcondition());
			model.setStudyingcondition(s.getStudyingcondition());
			stumodels.add(model);
		}
		map.put("Total", total);
		map.put("Rows", stumodels);
		return map;
	}

	@Override
	public void workrecordedit(ClassRecord classrecord) {

		String date = null;
		Integer classid = null;
		Integer teacherid = null;
		Integer selfevalution = null;
		String classmeetingfrequency = null;
		String appointmentnumber = null;
		String physicalmentalcondition = null;
		String studyingcondition = null;
		String feedback = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date nowdate = new Date();
		date = df.format(nowdate);
		try {
			classmeetingfrequency = java.net.URLDecoder.decode(classrecord.getClassmeetingfrequency(), "UTF-8");
			appointmentnumber = java.net.URLDecoder.decode(classrecord.getAppointmentnumber(), "UTF-8");
			physicalmentalcondition = java.net.URLDecoder.decode(classrecord.getPhysicalmentalcondition(), "UTF-8");
			studyingcondition = java.net.URLDecoder.decode(classrecord.getStudyingcondition(), "UTF-8");
			feedback = java.net.URLDecoder.decode(classrecord.getFeedback(),"UTF-8");
			classid = classrecord.getClassid();
			//teacherid = classrecord.getTeacherid();
			selfevalution = classrecord.getSelfevalution();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		classrecord.setAppointmentnumber(appointmentnumber);
		classrecord.setClassid(classid);
		classrecord.setClassmeetingfrequency(classmeetingfrequency);
		classrecord.setDate(date);
		classrecord.setFeedback(feedback);
		classrecord.setPhysicalmentalcondition(physicalmentalcondition);
		classrecord.setStudyingcondition(studyingcondition);
		//classrecord.setTeacherid(teacherid);
		classrecord.setSelfevalution(selfevalution);
		studentDao.workrecordupdate(classrecord);
	}

	@Override
	public void workrecorddelete(String ids) {

		Integer id = Integer.valueOf(ids);
		studentDao.workrecorddelete(id);
	}

	@Override
	public void workrecordadd(ClassRecord classrecord) {

		String date = null;
		Integer classid = null;
		String  teacherid = null;
		Integer selfevalution = null;
		String classmeetingfrequency = null;
		String appointmentnumber = null;
		String physicalmentalcondition = null;
		String studyingcondition = null;
		String feedback = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date nowdate = new Date();
		date = df.format(nowdate);
		try {
			classmeetingfrequency = java.net.URLDecoder.decode(classrecord.getClassmeetingfrequency(), "UTF-8");
			appointmentnumber = java.net.URLDecoder.decode(classrecord.getAppointmentnumber(), "UTF-8");
			physicalmentalcondition = java.net.URLDecoder.decode(classrecord.getPhysicalmentalcondition(), "UTF-8");
			studyingcondition = java.net.URLDecoder.decode(classrecord.getStudyingcondition(), "UTF-8");
			feedback = java.net.URLDecoder.decode(classrecord.getFeedback(),"UTF-8");
			classid = classrecord.getClassid();
			//teacherid = classrecord.getTeacherid();
			selfevalution = classrecord.getSelfevalution();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		User user = (User)ActionContext.getContext().getSession().get("user");
		Teacher teacher = manageDao.loadteacherbyidentificationnum(user.getUsernum());
		classrecord.setAppointmentnumber(appointmentnumber);
		classrecord.setClassid(classid);
		classrecord.setClassmeetingfrequency(classmeetingfrequency);
		classrecord.setDate(date);
		classrecord.setFeedback(feedback);
		classrecord.setPhysicalmentalcondition(physicalmentalcondition);
		classrecord.setStudyingcondition(studyingcondition);
		classrecord.setTeacherid(teacher.getIdentificationnum());
		classrecord.setSelfevalution(selfevalution);
		studentDao.workrecordadd(classrecord);
	}

	@Override
	public ClassRecord workrecorddetail(Integer id) {

		ClassRecord classrecords = studentDao.workrecorddetail(id);
		return classrecords;
	}

	@Override
	public List<Classes> classteacherclass(String id) {
		 List<Classes> classes = studentDao.classteacherclass(id);
		 return classes;
	}

	@Override
	public Student loadminitor(Integer classminitorid) {

		Student student = studentDao.loadstubyid(classminitorid);
		return student;
	}

	@Override
	public ClassRecord loadworkrecord(Integer id) {

		ClassRecord classrecord = studentDao.workrecorddetail(id);
		return classrecord;
	}

	@Override
	public Map<String, Object> performancemap(int page, int pageSize) {
        User user = (User)ActionContext.getContext().getSession().get("user");
        Teacher teacher = manageDao.loadteacherbyidentificationnum(user.getUsernum());
		Map<String, Object> map = new HashMap<String, Object>();
		List<Performance> performances = studentDao.loadperformance((page - 1)* pageSize, pageSize,teacher.getIdentificationnum());
		long total = studentDao.totalperformance();
		List<PerformanceModel> stumodels = new ArrayList<PerformanceModel>();
		for (Performance s : performances) {
			PerformanceModel model = new PerformanceModel();
			model.setId(s.getId());
			model.setDailylife(s.getDailylife());
			model.setDate(s.getDate());
			model.setEvent(s.getEvent());
			model.setOutstanding(s.getOutstanding());
			model.setPsychicology(s.getPsychicology());
			model.setRemark(s.getRemark());
			model.setStudy(s.getStudy());
			Student student = studentDao.loadstubystuid(s.getPassport());
			model.setStuname(student.getStuname());
			model.setSex(student.getSex());
			stumodels.add(model);
		}
		map.put("Total", total);
		map.put("Rows", stumodels);
		return map;
	}

	@Override
	public void performanceadd(Performance performance) {
		String study = null;
		String outstanding = null;
		String psychicology = null;
		String date = null;
		String dailylife = null;
		String event = null;
		String stuid = null;
		String remark = null;
		String teachernum = null;
		try {
			study = java.net.URLDecoder.decode(performance.getStudy(), "UTF-8");
			outstanding = java.net.URLDecoder.decode(performance.getOutstanding(), "UTF-8");
			psychicology = java.net.URLDecoder.decode(performance.getPsychicology(), "UTF-8");
			dailylife = java.net.URLDecoder.decode(performance.getDailylife(),"UTF-8");
			event = java.net.URLDecoder.decode(performance.getEvent(), "UTF-8");
			stuid = performance.getPassport();
			remark = java.net.URLDecoder.decode(performance.getRemark(),"UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date nowdate = new Date(System.currentTimeMillis());
		date = df.format(nowdate);
		User user = (User)ActionContext.getContext().getSession().get("user");
		Teacher teacher = manageDao.loadteacherbyidentificationnum(user.getUsernum());
		teachernum = teacher.getIdentificationnum();
		performance.setTeachernum(teachernum);
		performance.setDailylife(dailylife);
		performance.setDate(date);
		performance.setEvent(event);
		performance.setOutstanding(outstanding);
		performance.setPsychicology(psychicology);
		performance.setRemark(remark);
		performance.setStudy(study);
		//List<Student> student = studentDao.loadstubystuname(stuid);
		performance.setPassport(stuid);
		studentDao.performanceadd(performance);
	}

	@Override
	public void performanceupdate(Performance performance) {

		String study = null;
		String outstanding = null;
		String psychicology = null;
		String date = null;
		String dailylife = null;
		String event = null;
		String stuid = null;
		String remark = null;
		try {
			study = java.net.URLDecoder.decode(performance.getStudy(), "UTF-8");
			outstanding = java.net.URLDecoder.decode(performance.getOutstanding(), "UTF-8");
			psychicology = java.net.URLDecoder.decode(performance.getPsychicology(), "UTF-8");
			dailylife = java.net.URLDecoder.decode(performance.getDailylife(),"UTF-8");
			event = java.net.URLDecoder.decode(performance.getEvent(), "UTF-8");
			// stuid = performance.getStuid();
			remark = java.net.URLDecoder.decode(performance.getRemark(),"UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date nowdate = new Date(System.currentTimeMillis());
		date = df.format(nowdate);
		performance.setDailylife(dailylife);
		performance.setDate(date);
		performance.setEvent(event);
		performance.setOutstanding(outstanding);
		performance.setPsychicology(psychicology);
		performance.setRemark(remark);
		performance.setStudy(study);
		// performance.setStuid(stuid);
		studentDao.performanceupdate(performance);
	}

	@Override
	public void performancedelete(String ids) {
		Integer id = Integer.valueOf(ids);
		studentDao.performancedelete(id);
	}

	@Override
	public void assistagainst(Integer id) {
		studentDao.assistagainst(id);
	}

	@Override
	public Assistantteacher loadassistbyid(Integer id) {
		Assistantteacher assistantteacher = studentDao.loadassistbyid(id);
		return assistantteacher;
	}

	List<Classroom> classrooms = new ArrayList<Classroom>();

	@Override
	public List<Classroom> roomsearch(Classroom room) {
		classrooms.clear();
		classrooms = studentDao.roomsearch(room);
		return classrooms;
	}

	public Map<String, Object> searchroomlist(int page, int pageSize) {

		Map<String, Object> map = new HashMap<String, Object>();
		long total = classrooms.size();
		List<ClassroomModel> roommodels = new ArrayList<ClassroomModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < classrooms.size()) {
				ClassroomModel model = new ClassroomModel();
				model.setId(classrooms.get(i).getId());
				model.setId(classrooms.get(i).getId());
				model.setNum(String.valueOf(classrooms.get(i).getNum()));
				model.setRoomname(classrooms.get(i).getRoomname());
				model.setRoomplace(classrooms.get(i).getRoomplace());
				model.setRoomtype(classrooms.get(i).getRoomtype());
				model.setRoomcapacity(String.valueOf(classrooms.get(i).getRoomcapacity()));
				model.setRealcapacity(String.valueOf(classrooms.get(i).getRealcapacity()));
				model.setNote(classrooms.get(i).getNote());
				model.setIsavaible(classrooms.get(i).getIsavaible());
				roommodels.add(model);
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", roommodels);
		return map;
	}

	public List<Student> loadstubyclassid(Integer id) {
		List<Student> students = studentDao.loadstubyclassid(id);
		return students;
	}

	public List<ChosenCourseModel> getArrangedCourse(CourseArrangement ca) {
		return ca.getCourses();
	}

	public List<ChosenCourseModel> getUnarrangedCourse(CourseArrangement ca) {
		return ca.getUnable();
	}
    List<Course> courselist = new ArrayList<Course>();
	@Override
	public void coursesearch(Course course) {		 
		courselist.clear();
		courselist = studentDao.coursesearch(course);
	}
	
	public Map<String, Object> courseFuzzySearch (String text, int page, int pageSize, int type){
		List<Course> ret = manageDao.courseFuzzySearch(text);
		List<Course> all = null;
		if (type == 0) {
			all = new ArrayList<Course>();
			for (Course i : ret){
				if (i.getCharacter().equals("必修")){
					all.add(i);
				}
			}
		} else if (type == 1) {
			all = new ArrayList<Course>();
			for (Course i : ret){
				if (i.getCharacter().equals("限选")) {
					all.add(i);
				}
			}
		}else if (type == 2) {
			all = new ArrayList<Course>();
			for (Course i : ret){
				if (i.getCharacter().equals("任选")) {
					all.add(i);
				}
			}
		} else {
			all = ret;
		}
		
		List<CourseModel> dat = new ArrayList<CourseModel>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (all.size() < (page - 1) * pageSize){
			page = 1;
		}
		map.put("Total", all.size());
		if (all.size() < page * pageSize) {
			for (Course c : all.subList((page - 1) * pageSize, all.size())) {
				dat.add(courseToModel(c));
			}
		} else {
			for (Course c : all.subList((page - 1) * pageSize, page * pageSize)){
				dat.add(courseToModel(c));
			}
		}
		map.put("Rows", dat);
		return map;
		
	}
	
	private CourseModel courseToModel (Course c){
		CourseModel model = new CourseModel();
		model.setId(c.getId());
		model.setNum(c.getNum());
		model.setCoursename(c.getCoursename());
		model.setCoursename_en(c.getCoursename_en());
		model.setTeacher(c.getTeacher());
		model.setCharacter(c.getCharacter());
		model.setCheckway(c.getCheckway());
		model.setCredits(c.getCredits());
		model.setWeeklesson(c.getWeeklesson());
		model.setLessoncount((int)c.getCredits()*16);
		model.setBeginweeks(c.getBeginweeks());
		model.setEndweeks(c.getEndweeks());
		model.setAcademic(c.getAcademic());
		return model;
	}
	
	@Override
	public Map<String, Object> coursesearchlist(int page, int pageSize) {		 
		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * User user = (User)ActionContext.getContext().getSession().get("user");
		 */		
		long total = courselist.size();
		List<CourseModel> coursemodels = new ArrayList<CourseModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < courselist.size()) {
			CourseModel model = new CourseModel();
			model.setId(courselist.get(i).getId());
			model.setNum(courselist.get(i).getNum());
			model.setCoursename(courselist.get(i).getCoursename());
			model.setTeacher(courselist.get(i).getTeacher());
			model.setCharacter(courselist.get(i).getCharacter());
			model.setCheckway(courselist.get(i).getCheckway());
			model.setCredits(courselist.get(i).getCredits());
			model.setBeginweeks(courselist.get(i).getBeginweeks());
			model.setEndweeks(courselist.get(i).getEndweeks());
			coursemodels.add(model);
			}else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", coursemodels);
		return map;
	}

	@Override
	public Classroom loadclassroombyid(Integer id) {		 
		Classroom classroom = studentDao.loadclassroombyid(id);
		return classroom;
	}

	@Override
	public Classes loadclassbyid(Integer id) {		 
		Classes classes = studentDao.loadclassbyid(id);
		return classes;
	}

	private ChosenCourseModel toModel (SemesterChosenCourse course, String semester) {
		ChosenCourseModel ret = new ChosenCourseModel();
		ret.setBeginWeek(Integer.parseInt(course.getBegainweek()));
		List<ClassesModel> classes = new ArrayList<ClassesModel>();
		for (String id : course.getClass_().split("&"))
			if (id != null && !id.equals(""))
				classes.add(manageDao.loadClassByID(id));
		
		ret.setClasses(classes);
		ret.setEndWeek(Integer.parseInt(course.getEndweek()));
		Integer id = new Integer(Integer.parseInt(course.getTeacherid()));
		ret.setTeacher(new TeacherModel(manageDao.loadteacherbyid(id)));
		if(course.getWeekday() != null)
			ret.setWeekday(Integer.parseInt(course.getWeekday()));
		else 
			ret.setWeekday(6);
		if (course.getSlot() != null)
			ret.setSlot(Integer.parseInt(course.getSlot()));
		else
			ret.setSlot(6);
		ret.setCourse(new CourseModel(manageDao.loadCourseByIdent2(course.getCoursenum())));
		List<SemesterChosenClassroom> rooms = manageDao.loadsemesterroombyid(course.getRoomname(),semester);
		if (rooms.size() > 0){
			SemesterChosenClassroom room = rooms.get(0);
			ret.setRoom(new ClassroomModel(room.getId(), room.getNum(), room.getRoomtype(), 
					room.getRoomcapacity(), room.getRealcapacity(), room.getRoomplace()+room.getRoomname()));
		}
		return ret;
	}
	
	public List<ChosenCourseModel> getPerSyllabus(String teacherId,String coureNum, String classId, String semester) {
		List<ChosenCourseModel> ret = new ArrayList<ChosenCourseModel>();
		if (teacherId != null)
			for (SemesterChosenCourse s :manageDao.getChosenCourseByTeacherId (teacherId, semester))
				ret.add(toModel(s, semester));
		else if (coureNum != null)
			for (SemesterChosenCourse s :manageDao.getChosenCourseByCourseId (coureNum, semester))
				ret.add(toModel(s, semester));
		else if (classId != null)
			for (SemesterChosenCourse s :manageDao.getChosenCourseByClassNum (classId, semester))
				ret.add(toModel(s, semester));
		return ret;
	}

	@Override
	public List<Classes> loadclass() {
		// TODO Auto-generated method stub
		List<Classes> classlist = new ArrayList<Classes>();
		User user = (User)ActionContext.getContext().getSession().get("user");
		String semester = manageService.getCurrSemester();
		if(user.getRoles().getRolerank()==0||user.getRoles().getRolerank()==1){
			classlist = studentDao.loadclasses();
		}else if((user.getRoles().getRolerank()==2)||(user.getRoles().getRolerank()==4)){
		    List<Classes> classteacher = studentDao.loadclassbyteacher(user.getUsernum());
			List<SemesterChosenCourse> semo = manageDao.loadattendencecourse(user.getUsernum(), semester);
		    for(SemesterChosenCourse c:semo){
		    	StringTokenizer fenxi = new StringTokenizer(c.getClass_(), "&");
				List<Classes> classes = new ArrayList<Classes>();
				while (fenxi.hasMoreTokens()) {
					String sid = fenxi.nextToken();
					int classid = Integer.parseInt(sid);
				  Classes cls =	studentDao.loadclassbyid(classid);
				  if(classlist.contains(cls)){
					  continue;
				  }else {
					  classlist.add(cls);
				}				 
				}	
		    }
		    classlist.addAll(classteacher);
		}
		for(int i = 0;i<classlist.size();i++){
    		for (int j = classlist.size()-1; j>i; j--) {
				if(classlist.get(i).getId()==classlist.get(j).getId()){
					classlist.remove(j);
				}
			}
    	}
		return classlist;
	}

	@Override
	public boolean stucheck(String stuid,Integer classid,String stuname) {
		// TODO Auto-generated method stub
		List<Student> havestu = studentDao.stucheckstuid(stuid,classid,stuname);
		if (havestu.size() > 0) {
			return true;
		}
		return false;
	}
	@Override
	public void setNewAssisTeacher(String classid, String assid) {
		manageDao.updateAssisTeacher(classid, assid);
	}
	@Override
	public List<Teacher> loadClassTeacher(int i, int pagesize) {
		return studentDao.loadClassTeacher(i, pagesize);
		//return null;
	}
	@Override
	public int classTeacherNum() {
		return studentDao.ClassTeacherNum();
	}
	@Override
	public void setNewClassTeacher(String classid, String ident) {
		manageDao.updateClassTeacher(classid, ident);
		
	}

	@Override
	public Course loadcoursebynum(String courseId) {
		// TODO Auto-generated method stub
		Course course = studentDao.loadcoursebynum(String.valueOf(courseId));
		return course;
	}
	@Override
	public List<Classes> chargeClassList (String ident){
		return studentDao.chargeClassList(ident);
	}

	@Override
	public Map<String, Object> classteachermap(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<Teacher> classteacher = studentDao.loaclassteacher();
		long total = classteacher.size();
		List<TeacherModel> coursemodels = new ArrayList<TeacherModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < classteacher.size()) {
			TeacherModel model = new TeacherModel();
			model.setId(classteacher.get(i).getId());
			model.setEmail(classteacher.get(i).getEmail());
			model.setIdentificationnum(classteacher.get(i).getIdentificationnum());
			model.setTeachername(classteacher.get(i).getTeachername());
			model.setTelephone(classteacher.get(i).getTelephone());
			model.setPosition(classteacher.get(i).getPosition());
			List<Classes> classlist = studentDao.loadclassbyteacher(classteacher.get(i).getIdentificationnum());
			String classname = "";
			for(Classes c:classlist){
				classname = classname+c.getClassname()+" ";
			}
			model.setClasses(classname);
			coursemodels.add(model);
			}
		}
		map.put("Total", total);
		map.put("Rows", coursemodels);
		return map;
	}
	@Override
	public List<Classes> assisClassList(String id) {
		return studentDao.assisClassList(id);
	}
	@Override
	public void toExcel (OutputStream os, List<Syllabus> courses) {
		WritableWorkbook wwb;
		try {
			wwb = Workbook.createWorkbook(os);  
	        WritableSheet ws = wwb.createSheet("课程表", 0);
	        WritableFont writableFont = new WritableFont(WritableFont.createFont("宋体"),11, WritableFont.NO_BOLD, false);	
	        WritableCellFormat cellFormat = new WritableCellFormat(writableFont);
	        cellFormat.setAlignment(Alignment.CENTRE);
	        cellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
	        cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
	        cellFormat.setWrap(true);
	        CellView cv = new CellView();
	        cv.setAutosize(true);
	        
	        ws.setRowView(0, 800);
            ws.setColumnView(0, 15);
	        
	        int row = 0, col = 1;
	        
	        String weekday[] = new String[]{"星期一","星期二","星期三","星期四","星期五"};
	       
	        // 显示星期一到星期五 
	        for (int i = 0; i < weekday.length; ++i) {
	        	ws.addCell(new Label(col, row, weekday[i], cellFormat));
	        	ws.mergeCells(col, row, col + 1, row);
	        	col += 2;
	        }
	        
	        col = 0;
	        row = 1;
	        // 大节 每格4行
	        String slot[] = new String[]{"第一大节","第二大节","第三大节","第四大节","第五大节"};
	        for (int i = 0; i < slot.length; ++i) {
	        	ws.addCell(new Label(col, row, slot[i], cellFormat));
	        	ws.mergeCells(col, row, col, row + 3);
	        	row += 4;
	        }
	        
	        col = 1; row = 1;
	        
	        int s = 0;
	        ws.setRowView(row, 1100);
	        for (Syllabus c : courses) {
	        	ws.setColumnView(col, 800);
	        	String content = String.format(" %s\n %s\n %s %s\n%s", c.getCourseName(), c.getTeacherName(), c.getClassName(),c.getRoomNum(),c.getNote());
				ws.addCell(new Label(col, row, content, cellFormat));
				ws.mergeCells(col, row, col + 1, row + 3);
				
				col += 2;
				s ++;
				if (s == 5){
					row += 4;
					col = 1;
					s = 0;
					ws.setRowView(row, 1500);
				}
				
	        }
	        
	        /*for (int s = 0; s < slot.length; ++s) {
	        	for (int d = 0; d < weekday.length; ++d) {
	        		ws.setColumnView(col, 800);
	        		for (Syllabus c : courses) {
	        			if (c.getSlot() == s && c.getDay() == d) {
		        			String content = String.format(" %s\n %s\n %s %s", c.getCourseName(), c.getTeacherName(), c.getClassName(),c.getRoomNum());
							ws.addCell(new Label(col, row, content, cellFormat));
							ws.mergeCells(col, row, col, row + 3);
							ws.setRowView(row, 1500);
							System.out.println(content);
							break;
	        			}
	        		}
	        		col += 1;
	        		
	        	}
	        	row += 4;
	        	col = 1;
	        }*/
	        wwb.write();  
            wwb.close();
	        
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Classes> classminitorlist(String queryID) {
		// TODO Auto-generated method stub
		return studentDao.classminitorlist(queryID);
	}
	@Override
	public List<Classroom> loadclassroombyisavaible() {
		// TODO Auto-generated method stub
		return studentDao.loadclassroombyisavaible();
	}
	@Override
	public Map<String, Object> classroomSearch (Integer capacity, String place ,String roomtype, int page, int pageSize){
		List<Classroom> all = manageDao.roomListByCapAndPlace(String.valueOf(capacity), place, roomtype,(page - 1) * pageSize, page * pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Total", manageDao.sizeOfroomListByCapAndPlace(String.valueOf(capacity), place, roomtype));
		map.put("Rows", all);
		return map;
	}

	@Override
	public Student loadclassmonitor(Integer id) {
		// TODO Auto-generated method stub
		Classes clsClasses = studentDao.loadclassbyid(id);
		Student student = studentDao.loadstubystuid(clsClasses.getClassminitorid());
		return student;
	}

	@Override
	public Performance loadstuperformance(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.loadstuperformance(id);
	}

	@Override
	public void assistantteacherdelete(Assistantteacher assistantteacher) {
		// TODO Auto-generated method stub
		studentDao.assistanttacherdelete(assistantteacher.getId());
	}

	@Override
	public boolean assistcheck(String assistantnum) {
		// TODO Auto-generated method stub
		List<Assistantteacher> ass = studentDao.loadassistbynum(assistantnum);
		if(ass.size()>0){
			return false;
		}
		return true;
	}
	
	public void ModifyLog(User user, String objectType, String objectName) {
		manageDao.modifyLog(user, objectName, objectType);
	}
}
