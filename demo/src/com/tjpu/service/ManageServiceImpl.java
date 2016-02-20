package com.tjpu.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.struts2.ServletActionContext;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument.TotalDigits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;
import com.sun.image.codec.jpeg.TruncatedFileException;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;
import com.tjpu.bean.Adjustcourse;
import com.tjpu.bean.AdjustcourseModel;
import com.tjpu.bean.Announcement;
import com.tjpu.bean.AnnouncementModel;
import com.tjpu.bean.Attendence;
import com.tjpu.bean.AttendenceModel;
import com.tjpu.bean.BatchRegiste;
import com.tjpu.bean.Certify1;
import com.tjpu.bean.Certify1Model;
import com.tjpu.bean.ChosenCourse;
import com.tjpu.bean.ChosenCourseModel;
import com.tjpu.bean.Classes;
import com.tjpu.bean.ClassesModel;
import com.tjpu.bean.Classroom;
import com.tjpu.bean.ClassroomModel;
import com.tjpu.bean.CourseModel;
import com.tjpu.bean.EvalutionModel;
import com.tjpu.bean.InfoBean;
import com.tjpu.bean.MD5;
import com.tjpu.bean.PageBean;
import com.tjpu.bean.SemesterChosenClassroom;
import com.tjpu.bean.SemesterChosenClassroomModel;
import com.tjpu.bean.SemesterChosenCourse;
import com.tjpu.bean.SemesterChosenCourseModel;
import com.tjpu.bean.StudentModel;
import com.tjpu.bean.Syllabus;
import com.tjpu.bean.Teacher;
import com.tjpu.bean.TeacherModel;
import com.tjpu.bean.Course;
import com.tjpu.bean.Evalution;
import com.tjpu.bean.Leave;
import com.tjpu.bean.LeaveModel;
import com.tjpu.bean.Student;
import com.tjpu.bean.Transcript;
import com.tjpu.bean.User;
import com.tjpu.dao.ManageDao;
import com.tjpu.dao.StudentDao;
import com.tjpu.dao.UserDao;
import com.tjpu.bean.Dept;

@Service
public class ManageServiceImpl implements ManageService {

	@Autowired
	ManageDao manageDao;
	@Autowired
	StudentDao studentDao;
	@Autowired
	UserDao userDao;
	
	public Map<String, Object> batchSetSemesterCourse (String path){
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
			String errMsg = classChk(items);
			if (errMsg == null) {
				//置入数据库
				insertSemesterCourses(items);
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
	
	
	private void insertSemesterCourses (List<String> items){
		String semester = getCurrSemester();
		//semestercourseadd(items.get(0),semester);	//置入课程
		SemesterChosenCourse course = new SemesterChosenCourse();
		Course history = manageDao.getCourseByNum(items.get(0));
		course.setBegainweek(history.getBeginweeks().toString());
		String classList = "";
		for (int i = 3; i < items.size(); ++i) {
			classList += items.get(i) + "&";
		}
		course.setClass_(classList);
		course.setCoursenum(items.get(0));
		Integer j = new Integer((int)history.getCredits());
		course.setCredits(j.toString());
		course.setEndweek(history.getEndweeks().toString());
		course.setBegainweek(history.getBeginweeks().toString());
		course.setIsElective(0);
		course.setIsOddWeek(0);
		course.setLessonCount(j * 16);
		course.setWeeklesson(j * 16 / (history.getEndweeks() - history.getBeginweeks() + 1));
		course.setRoomtype(items.get(1));
		course.setSemester(semester);
		course.setTeacherid(items.get(2));
		manageDao.semestercourseadd(course);
	}
	
	private String classChk (List<String> items) {
		if (items.size() < 4) {
			return "无法匹配正确的项";
		}	
		if (manageDao.getCourseByNum(items.get(0)) == null) {	//检查课程编号
			return "无该课程编号或已被删除";
		}
		List<Classroom> rooms = manageDao.classroomList();
		Set<String> roomType = new HashSet<String>();
		for (Classroom i : rooms) {
			roomType.add(i.getRoomtype());
		}
		if (!roomType.contains(items.get(1))) {	//检查教室类型
			return "没有此教室类型";
		}
		
		if (manageDao.loadteacherbyidentificationnum(items.get(2)) == null) {
			return "教师编号错误";
		}
		for (int i = 3; i < items.size(); ++i) {	//检查上课班级编号
			if (studentDao.loadclassbyid(Integer.parseInt(items.get(i))) == null) {
				return "班级编号错误";
			}
		}
		return null;
	}
	
	
	
	
	public String getCurrSemester (){
		Calendar now = Calendar.getInstance();
		String year = String.valueOf(now.get(Calendar.YEAR));
		int month = now.get(Calendar.MONTH) + 1;
		if (month > 9)
			return year + "01";
		else
			return year + "02";
	}
	
	public Teacher loginService(String usernum, String password/*,Integer type*/) {
		Teacher user1 = null;
		List<Teacher> list = manageDao.loginDao(usernum,password/*,type*/);
		if (list.size() > 0 && list != null) {
			user1 = list.get(0);
		}
		return user1;
	}

	public List<Evalution> loadevalution(String num, String usernum, String semester,String flag){
		
		return manageDao.loadevalutionjudge(num,usernum,semester,flag);
	}
	
	public void evalutionteacheradd(Evalution evalution) {
		String teacher = null;
		String extrude = null;
		String advice = null;
		String semester = getCurrSemester();
		String incicators1 = null;
		String incicators2 = null;
		String incicators3 = null;
		String incicators4 = null;
		String incicators5 = null;
		String incicators6 = null;
		String incicators7 = null;
		Integer flag = null;
		
		User user = (User)ActionContext.getContext().getSession().get("user");
		try {
			teacher = java.net.URLDecoder.decode(evalution.getTeacher(),"UTF-8");
			extrude = java.net.URLDecoder.decode(evalution.getExtrude(),"UTF-8");
			advice = java.net.URLDecoder.decode(evalution.getAdvice(),"UTF-8");
			incicators1 = evalution.getIncicators1();
			incicators2 = evalution.getIncicators2();
			incicators3 = evalution.getIncicators3();
			incicators4 = evalution.getIncicators4();
			incicators5 = evalution.getIncicators5();
			incicators6 = evalution.getIncicators6();
			incicators7 = evalution.getIncicators7();
			flag = evalution.getFlag();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		evalution.setPassport(user.getUsernum());
		evalution.setTeacher(teacher);
		evalution.setExtrude(extrude);
		evalution.setAdvice(advice);
		evalution.setSemester(semester);
		evalution.setIncicators1(incicators1);
		evalution.setIncicators2(incicators2);
		evalution.setIncicators3(incicators3);
		evalution.setIncicators4(incicators4);
		evalution.setIncicators5(incicators5);
		evalution.setIncicators6(incicators6);
		evalution.setIncicators7(incicators7);
		evalution.setFlag(flag);
		
		manageDao.evalutionteacheradd(evalution);
	}

	public String loadevalution(String id) {
		String semester = getCurrSemester();
		List<Evalution> evalution = manageDao.loadevalution(id,semester);
		String evalutionlist = "";
		int i = 1;
		for (Evalution c : evalution) {
			String s = "{\"id\":" + c.getId() + "," + "\"stuid\":" + "\"" + c.getPassport() + "\"," + "\"incicators1\":" + "\"" + c.getIncicators1() + "\"," + "\"incicators2\":" + "\"" + c.getIncicators2() + "\"," + "\"incicators3\":" + "\"" + c.getIncicators3() + "\"," 
					+ "\"incicators4\":" + "\"" + c.getIncicators4() + "\","+ "\"incicators5\":" + "\"" + c.getIncicators5() + "\","+ "\"incicators6\":" + "\"" + c.getIncicators6() + "\","+ "\"incicators7\":" + "\"" + c.getIncicators7() + "\","+ "\"summary\":" + "\"" + c.getSummary() + "\","
					+ "\"extrude\":" + "\"" + c.getExtrude() + "\","+ "\"advice\":" + "\"" + c.getAdvice() + "\"}";
			if (i < evalution.size()) {
				evalutionlist += s + ",";
			} else {
				evalutionlist += s;
			}
			i++;
		}
		return evalutionlist;
	}

	public List<Evalution> loadevalutionlist(String num){
		String semester = getCurrSemester();
		List<Evalution> evalutionlist = manageDao.loadevalution(num,semester);
		return evalutionlist;
	}
	public List<Evalution> loadclassteacherevalutionlist(String num){
		String semester = getCurrSemester();
		List<Evalution> evalutionlist = manageDao.loadclassteacherevalution(num,semester);
		return evalutionlist;
	}
	public Map<String, Object> teachermap(int page, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Teacher> teachers = manageDao.loadteacher();
		for(int i=0;i<teachers.size()-1;i++){
			for(int j=0;j<teachers.size()-i-1;j++){
				if(Integer.valueOf(teachers.get(j).getIdentificationnum())>Integer.valueOf(teachers.get(j+1).getIdentificationnum())){
					Teacher temp = null;
					temp = teachers.get(j);
					teachers.set(j, teachers.get(j+1));
					teachers.set(j+1, temp);
				}
			}
		}
		long total = manageDao.totalteacher();
		List<TeacherModel> teachermodels = new ArrayList<TeacherModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
		 if (i < teachers.size()) {
			TeacherModel model = new TeacherModel();
			/*if (teachers.get(i).getDeleted()==1) {
				continue;
			}*/
			model.setId(teachers.get(i).getId());
			model.setSex(teachers.get(i).getSex());
			if (teachers.get(i).getDeleted() == null)
				model.setDeleted(0);
			else
				model.setDeleted(teachers.get(i).getDeleted());
			//model.setClassid(s.getClasses().getId());
			model.setEmail(teachers.get(i).getEmail());
			model.setIdentificationnum(teachers.get(i).getIdentificationnum());
			model.setPosition(teachers.get(i).getPosition());
			model.setTeachername(teachers.get(i).getTeachername());
			model.setTelephone(teachers.get(i).getTelephone());
			if(teachers.get(i).getDept()==null){
				model.setDeptname("");
			}else {
				model.setDeptname(teachers.get(i).getDept().getDeptname());
			}			
			teachermodels.add(model);
		}else {
			break;
		}
		}
		map.put("Total", total);
		map.put("Rows", teachermodels);
		return map;
	}

	public Map<String, Object> courseteachermap(int page, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Teacher> teachers = manageDao.loadteacher();
		for(int i=0;i<teachers.size()-1;i++){
			for(int j=0;j<teachers.size()-i-1;j++){
				if(Integer.valueOf(teachers.get(j).getIdentificationnum())>Integer.valueOf(teachers.get(j+1).getIdentificationnum())){
					Teacher temp = null;
					temp = teachers.get(j);
					teachers.set(j, teachers.get(j+1));
					teachers.set(j+1, temp);
				}
			}
		}
		long total = manageDao.totalteacher();
		List<TeacherModel> teachermodels = new ArrayList<TeacherModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
		 if (i < teachers.size()) {
			TeacherModel model = new TeacherModel();
			if (teachers.get(i).getDeleted()==1) {
				continue;
			}
			model.setId(teachers.get(i).getId());
			model.setSex(teachers.get(i).getSex());
			if (teachers.get(i).getDeleted() == null)
				model.setDeleted(0);
			else
				model.setDeleted(teachers.get(i).getDeleted());
			//model.setClassid(s.getClasses().getId());
			model.setEmail(teachers.get(i).getEmail());
			model.setIdentificationnum(teachers.get(i).getIdentificationnum());
			model.setPosition(teachers.get(i).getPosition());
			model.setTeachername(teachers.get(i).getTeachername());
			model.setTelephone(teachers.get(i).getTelephone());
			if(teachers.get(i).getDept()==null){
				model.setDeptname("");
			}else {
				model.setDeptname(teachers.get(i).getDept().getDeptname());
			}			
			teachermodels.add(model);
		}else {
			break;
		}
		}
		map.put("Total", total);
		map.put("Rows", teachermodels);
		return map;
	}

	
	public void teacherupdate(Teacher teacher,Integer depid) {
		
		String name = null;
		String identificationnum =null;
		String gender = null;
		String educationbackground = null;
		//String brithdate = null;
		String telephone = null;
		String email = null;
		try {
			name = java.net.URLDecoder.decode(teacher.getTeachername(),"UTF-8");
			identificationnum = java.net.URLDecoder.decode(teacher.getIdentificationnum(),"UTF-8");
			gender = java.net.URLDecoder.decode(teacher.getSex(),"UTF-8");
			educationbackground = java.net.URLDecoder.decode(teacher.getPosition(),"UTF-8");
			//brithdate = java.net.URLDecoder.decode(teacher.getBrithdate(),"UTF-8");
			telephone = java.net.URLDecoder.decode(teacher.getTelephone(),"UTF-8");
			email = java.net.URLDecoder.decode(teacher.getEmail(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		teacher.setTeachername(name);
		teacher.setIdentificationnum(identificationnum);
		teacher.setSex(gender);
		teacher.setPosition(educationbackground);
		teacher.setEmail(email);
		Dept dept = userDao.loaddeptbyid(depid);
		//teacher.setBrithdate(brithdate);
		teacher.setDept(dept);
		teacher.setTelephone(telephone);
		manageDao.teacherupdate(teacher);
		}

	public void teacherdelete(String ids) {
		
		StringTokenizer fenxi = new StringTokenizer(ids, ",");
		while (fenxi.hasMoreTokens()) {
			String sid = fenxi.nextToken();
			int stuid = Integer.parseInt(sid);
			manageDao.teacherdelete(stuid);
		}
	}

	@Override
	public Map<String, Object> teacherFuzzySearch(int page, int pageSize, String fuzzyText) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String text = null;
		try {
			text = java.net.URLDecoder.decode(fuzzyText,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Teacher> teachers = manageDao.teacherFuzzySearch(text);
		for(int i=0;i<teachers.size()-1;i++){
			for(int j=0;j<teachers.size()-i-1;j++){
				if(Integer.valueOf(teachers.get(j).getIdentificationnum())>Integer.valueOf(teachers.get(j+1).getIdentificationnum())){
					Teacher temp = null;
					temp = teachers.get(j);
					teachers.set(j, teachers.get(j+1));
					teachers.set(j+1, temp);
				}
			}
		}
		long total = teachers.size();
		List<TeacherModel> teachermodels = new ArrayList<TeacherModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
		 if (i < teachers.size()) {
			TeacherModel model = new TeacherModel();
			model.setId(teachers.get(i).getId());
			model.setSex(teachers.get(i).getSex());
			if (teachers.get(i).getDeleted() == null)
				model.setDeleted(0);
			else
				model.setDeleted(teachers.get(i).getDeleted());
			//model.setClassid(s.getClasses().getId());
			model.setEmail(teachers.get(i).getEmail());
			model.setIdentificationnum(teachers.get(i).getIdentificationnum());
			model.setPosition(teachers.get(i).getPosition());
			model.setTeachername(teachers.get(i).getTeachername());
			model.setTelephone(teachers.get(i).getTelephone());
			if(teachers.get(i).getDept()==null){
				model.setDeptname("");
			}else {
				model.setDeptname(teachers.get(i).getDept().getDeptname());
			}			
			teachermodels.add(model);
		}else {
			break;
		}
		}
		map.put("Total", total);
		map.put("Rows", teachermodels);
		return map;
	}

	
	public void stuattendenceadd(Attendence attendence, String ids) {
				
		String date = null;
		String time = null;
		Integer choosencourseid = null;
		String type = null;
		String semester = getCurrSemester();
		try {
			date = java.net.URLDecoder.decode(attendence.getDate(),"UTF-8");
			time = java.net.URLDecoder.decode(attendence.getTime(),"UTF-8");
			choosencourseid = attendence.getChoosencourseid();
			type = java.net.URLDecoder.decode(attendence.getType(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		StringTokenizer fenxi = new StringTokenizer(ids, ",");
		while (fenxi.hasMoreTokens()) {
			String sid = fenxi.nextToken();		
			List<Attendence> attendences = manageDao.loadattendence(attendence,sid);
			for (int i = 0; i < attendences.size(); i++) {
				if (sid.equals(attendences.get(i).getPassport())) {
					sid = null;
				}
			}
			if (sid==null) {
				continue;
			}else {
				Attendence attendence2 = new Attendence();
				attendence2.setChoosencourseid(choosencourseid);
				attendence2.setDate(date);
				attendence2.setPassport(sid);
				attendence2.setTime(time);
				attendence2.setType(type);
				attendence2.setSemester(semester);
				manageDao.stuattendenceadd(attendence2);
			}			
		}
	}
	List<Attendence> attendencelist = new ArrayList<Attendence>();

	public void loadattendence(String id) {		
		attendencelist.clear();
		String semester = getCurrSemester();
		attendencelist= manageDao.attendencestulist(id,semester);
	}
	

	public Map<String, Object> attendencestulistmap(int page, int pageSize) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		long total = attendencelist.size();
		List<AttendenceModel> attendencemodels = new ArrayList<AttendenceModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < attendencelist.size()) {
			    AttendenceModel model = new AttendenceModel();
			    model.setId(attendencelist.get(i).getId());
			    Student student = studentDao.loadstubystuid(attendencelist.get(i).getPassport());
			    model.setClassname(student.getClasses().getClassname());
			    model.setDate(attendencelist.get(i).getDate());
			    model.setFirstname(student.getFirstname());
			    model.setLastname(student.getLastname());
			    model.setStunum(student.getStuid());
			    model.setStuname(student.getStuname());
			    model.setTime(attendencelist.get(i).getTime());
			    model.setType(attendencelist.get(i).getType());
			    attendencemodels.add(model);
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", attendencemodels);
		return map;
	}
    public Map<String, Object> allattendencelistmap(int page, int pageSize) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		String semester = getCurrSemester();
		List<Attendence> attendences = manageDao.loadallattendence(semester);
		long total = attendences.size();
		List<AttendenceModel> attendencemodels = new ArrayList<AttendenceModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < attendences.size()) {
			    AttendenceModel model = new AttendenceModel();
			    model.setId(attendences.get(i).getId());
			    Student student = studentDao.loadstubystuid(attendences.get(i).getPassport());
			    model.setClassname(student.getClasses().getClassname());
			    model.setDate(attendences.get(i).getDate());
			    model.setFirstname(student.getFirstname());
			    model.setLastname(student.getLastname());
			    model.setStunum(student.getStuid());
			    model.setPassport(student.getPassport());
			    model.setStuname(student.getStuname());
			    Course course = manageDao.loadCourseByIdent(String.valueOf(attendences.get(i).getChoosencourseid()));
			    model.setCoursename(course.getCoursename());
			    model.setTime(attendences.get(i).getTime());
			    model.setType(attendences.get(i).getType());
			    attendencemodels.add(model);
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", attendencemodels);
		return map;
	}
    public Map<String, Object> searchattendencelistmap(int page, int pageSize, String coursenum, Integer id, String stuid,String startdate, String enddate) {		
		Map<String, Object> map = new HashMap<String, Object>();
		String semester = getCurrSemester();
		List<Attendence> attendences = new ArrayList<Attendence>();
		if (id==null) {
			attendences = manageDao.searchallattendence(coursenum,stuid,semester);
		}else {
			if (stuid.length()==0||stuid.equals("null")) {
				List<Student> students = studentDao.loadstubyclassid(id);
				for(Student s:students){
					List<Attendence> attendences2 = manageDao.searchallattendence(coursenum,s.getPassport(),semester);
				    attendences.addAll(attendences2);
				}
			}else {
				attendences = manageDao.searchallattendence(coursenum,stuid,semester);
			}
			
		}
		long total = 0;
		if (startdate.equals("")&&enddate.equals("")) {
			total = attendences.size();			
		}else {
			long n = 0;
			for(int i=0;i<attendences.size();i++){
				SimpleDateFormat dt = new SimpleDateFormat("yy-MM-dd");
				Date StartDate=null, EndDate=null,nowDate=null;
				try {
					StartDate= dt.parse(startdate);
					EndDate = dt.parse(enddate);
				    nowDate = dt.parse(attendences.get(i).getDate());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if ((nowDate.getTime()-StartDate.getTime())>=0&&(EndDate.getTime()-nowDate.getTime())>=0) {
					n++;
				}else {
					attendences.remove(i);
					i--;
				}
			}
			total = n;
		}
		List<AttendenceModel> attendencemodels = new ArrayList<AttendenceModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < attendences.size()) {
				AttendenceModel model = new AttendenceModel();
			    model.setId(attendences.get(i).getId());
				Student student = studentDao.loadstubystuid(attendences.get(i).getPassport());
				model.setClassname(student.getClasses().getClassname());
				model.setDate(attendences.get(i).getDate());
				model.setFirstname(student.getFirstname());
				model.setLastname(student.getLastname());
				model.setStunum(student.getStuid());
				model.setPassport(student.getPassport());
				model.setStuname(student.getStuname());
				Course course = manageDao.loadCourseByIdent(String.valueOf(attendences.get(i).getChoosencourseid()));
				model.setCoursename(course.getCoursename());
				model.setTime(attendences.get(i).getTime());
				model.setType(attendences.get(i).getType());
				attendencemodels.add(model);										    
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", attendencemodels);
		return map;
	}

	public List<Course> loadstucourse() {	
		User user = (User)ActionContext.getContext().getSession().get("user");
		String semester = getCurrSemester();
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
	

	public void leaveadd(Leave leave) {
		
		String applydate = null;
		String leavingdate = null;
		String backdate = null;
		String leavereason = null;
		String telephone = null;
		String stuid = null;
		Integer type = null;
		try {
			leavingdate = java.net.URLDecoder.decode(leave.getLeavingdate(),"UTF-8");
			backdate = java.net.URLDecoder.decode(leave.getBackdate(),"UTF-8");
			leavereason = java.net.URLDecoder.decode(leave.getLeavereason(),"UTF-8");
			telephone = java.net.URLDecoder.decode(leave.getTelephone(),"UTF-8");
			stuid = leave.getPassport();
			type = leave.getType();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-d");
		applydate = df.format(new Date());
		leave.setApplydate(applydate);
		leave.setStatus(0);
		//leave.setAcademicadvice(0);
		leave.setApplydate(applydate);
		leave.setBackdate(backdate);
		leave.setLeavereason(leavereason);
		leave.setLeavingdate(leavingdate);
		leave.setPassport(stuid);
		leave.setTelephone(telephone);
		leave.setType(type);
		manageDao.leaveadd(leave);
	}

	public Map<String, Object> stuleavemap(int page, int pageSize) {
		User user = (User)ActionContext.getContext().getSession().get("user");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Student> students = new ArrayList<Student>();		
		if (user.getRoles().getRolerank()==0||user.getRoles().getRolerank()==1) {
			List<Classes> cls = studentDao.loadallclasses();
			for(Classes c:cls){
				List<Student> stu = studentDao.loadstubyclassid(c.getId());
				students.addAll(stu);
			}
		}else if (user.getRoles().getRolerank()==2) {
			List<Classes> cls = studentDao.loadclassbyteacher(user.getUsernum());
			for(Classes c:cls){
				List<Student> stu = studentDao.loadstubyclassid(c.getId());
				students.addAll(stu);
			}
		}						
		List<Leave> stuleave = new ArrayList<Leave>();
		for(Student stu:students){
			List<Leave> leaves = manageDao.loadleavebystuid(stu.getPassport());
			stuleave.addAll(leaves);
		}
		stuleave = sortleave(stuleave);		
		long total = stuleave.size();
		List<LeaveModel> leavemodels = new ArrayList<LeaveModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < stuleave.size()) {
			LeaveModel model = new LeaveModel();
			model.setId(stuleave.get(i).getId());
			Student student = studentDao.loadstubystuid(stuleave.get(i).getPassport());
			model.setTelephone(stuleave.get(i).getTelephone());
			model.setApplydate(stuleave.get(i).getApplydate());
			model.setBackdate(stuleave.get(i).getBackdate());
			model.setLeavereason(stuleave.get(i).getLeavereason());
			model.setLeavingdate(stuleave.get(i).getLeavingdate());
			model.setClassname(student.getClasses().getClassname());
			model.setStuname(student.getStuname());
			model.setPassport(student.getPassport());
			model.setMajor(student.getClasses().getMajor());
			model.setStunum(student.getStuid());
			model.setStatus(stuleave.get(i).getStatus());
			model.setType(stuleave.get(i).getType());
			if (stuleave.get(i).getDoc() == null || stuleave.get(i).getDoc().isEmpty()) {
				model.setDoc("无附件");
			} else {
				String href = "/demo/" + stuleave.get(i).getDoc();
				model.setDoc("<a href='"+ href + "'>下载</a>");
			}
			leavemodels.add(model);
		}else {
			break;
		}
		}
		map.put("Total", total);
		map.put("Rows", leavemodels);
		return map;
	}
	private List<Leave> sortleave(List<Leave> leave ){
		for(int i=0;i<leave.size()-1;i++){
			for(int j=0;j<leave.size()-i-1;j++){
				if(leave.get(j).getStatus()>leave.get(j+1).getStatus()){
					Leave temp = null;
					temp = leave.get(j);
					leave.set(j, leave.get(j+1));
					leave.set(j+1, temp);
				}
			}
		}
		return leave;
	}
	public Map<String, Object> loadstuleavemap(int page, int pageSize) {
		User user = (User)ActionContext.getContext().getSession().get("user");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Leave> stuleave = manageDao.loadleavebystuid(user.getUsernum());
		stuleave = sortleave(stuleave);
		long total = stuleave.size();
		List<LeaveModel> leavemodels = new ArrayList<LeaveModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < stuleave.size()) {
			LeaveModel model = new LeaveModel();
			model.setId(stuleave.get(i).getId());
			Student student = studentDao.loadstubystuid(stuleave.get(i).getPassport());
			model.setTelephone(stuleave.get(i).getTelephone());
			model.setApplydate(stuleave.get(i).getApplydate());
			model.setBackdate(stuleave.get(i).getBackdate());
			model.setLeavereason(stuleave.get(i).getLeavereason());
			model.setLeavingdate(stuleave.get(i).getLeavingdate());
			model.setClassname(student.getClasses().getClassname());
			model.setStuname(student.getStuname());
			model.setPassport(student.getPassport());
			model.setMajor(student.getClasses().getMajor());
			model.setStunum(student.getStuid());
			model.setStatus(stuleave.get(i).getStatus());
			model.setType(stuleave.get(i).getType());
			leavemodels.add(model);
		}else {
			break;
		}
		}
		map.put("Total", total);
		map.put("Rows", leavemodels);
		return map;
	}
	
	public void stuleaveupdate(Leave leave) {
		manageDao.stuleaveupdate(leave);
	}

	public void leavedelete(Leave leave) {
		
		manageDao.leavedelete(leave);
	}

	public void leaveupdate(Leave leave){
		String applydate = null;
		String leavingdate = null;
		String backdate = null;
		String leavereason = null;
		String telephone = null;
		String stuid = null;
		Integer type = null;
		try {
			leavingdate = java.net.URLDecoder.decode(leave.getLeavingdate(),"UTF-8");
			backdate = java.net.URLDecoder.decode(leave.getBackdate(),"UTF-8");
			leavereason = java.net.URLDecoder.decode(leave.getLeavereason(),"UTF-8");
			telephone = java.net.URLDecoder.decode(leave.getTelephone(),"UTF-8");
			stuid = leave.getPassport();
			type = leave.getType();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-d");
		applydate = df.format(new Date());
		leave.setApplydate(applydate);
		leave.setStatus(0);
		leave.setApplydate(applydate);
		leave.setBackdate(backdate);
		leave.setLeavereason(leavereason);
		leave.setLeavingdate(leavingdate);
		leave.setPassport(stuid);
		leave.setTelephone(telephone);
		leave.setType(type);
		manageDao.leaveupdate(leave);
	}
	
	public String courseattendencesearch(Attendence attendence) {
		
		Integer courseid = null;
		String type = null;
		courseid = attendence.getChoosencourseid();
		try {
			type = java.net.URLDecoder.decode(attendence.getType(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		List<Attendence> attendences=manageDao.courseattendencesearch(courseid,type);
		String attendencelist = "";		
		int i = 1;
		for(Attendence a:attendences){
			Student student = studentDao.loadstubystuid(a.getPassport());
			String s ="{\"id\":" + a.getId() + "," + "\"stuname\":" + "\"" + student.getStuname() + "\"," + "\"firstname\":" + "\"" + student.getFirstname() + "\"," + "\"lastname\":" + "\"" + student.getLastname() + "\"," + "\"classname\":" + "\"" + student.getClasses().getClassname() + "\","+ "\"time\":" + "\"" + a.getTime() + "\","+ "\"type\":" + "\"" + a.getType() + "\","+ "\"date\":" + "\"" + a.getDate() + "\","+ "\"stunum\":" + "\"" + student.getStuid() + "\"}"; 
		    if (i<attendences.size()) {
				attendencelist+= s+",";
			}else {
				attendencelist+=s;
			}
		}
		return attendencelist;
	}

	public void teacheradd(Teacher teacher,Integer depid) {
		
		String identificationnum = null;
		String teachername = null;
		String sex = null;
		String position = null;
		String email = null;
		String telephone = null;
		try {
			identificationnum = java.net.URLDecoder.decode(teacher.getIdentificationnum(),"UTF-8");
			teachername = java.net.URLDecoder.decode(teacher.getTeachername(),"UTF-8");
			sex = java.net.URLDecoder.decode(teacher.getSex(),"UTF-8");
			position = java.net.URLDecoder.decode(teacher.getPosition(),"UTF-8");
			email = java.net.URLDecoder.decode(teacher.getEmail(),"UTF-8");
			telephone = java.net.URLDecoder.decode(teacher.getTelephone(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		if (identificationnum==null||identificationnum.equals("")) {
			String semester = getCurrSemester();
			List<Teacher> teachers = manageDao.loadteacherlikenum(semester);
			Integer number = teachers.size()+1;
			if (number<10) {
				identificationnum = semester +"0" +String.valueOf(number);
			}else {
				identificationnum = semester +String.valueOf(number);
			}
			
		}
		teacher.setEmail(email);
		teacher.setIdentificationnum(identificationnum);
		teacher.setSex(sex);
		teacher.setTeachername(teachername);
		teacher.setTelephone(telephone);
		String pass= MD5.generate("123456");
		teacher.setPassword(pass);
		teacher.setType(0);
		teacher.setPosition(position);
		teacher.setDeleted(0);
		//teacher.setDeptid(depid);
		manageDao.teacheradd(teacher,depid);
	}

	public boolean teachercheck(String identificationnum) {
		
		List<Teacher> haveteacher = manageDao.teachercheck(identificationnum);
		if (haveteacher.size() > 0) {
			return false;
		}
		return true;
	}
	private List<String> readTxtFile(String filePath) {
		List<String> linelist = new ArrayList<String>();
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// ���ǵ������ʽ
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
	
	private String teacherChk (List<String> items){
		int i = 0;
		if (items.size() != 7) {
			return "无法匹配正确项";
		}
		String reg = "(?!0)[0-9]{8}";
		String teacherNum = items.get(i++);
		if (teacherNum.equals("外聘")) {
			String semester = getCurrSemester();
			List<Teacher> teachers = manageDao.loadteacherlikenum(semester);
			Integer number = teachers.size()+1;
			if (number<10) {
				teacherNum = semester +"0" +String.valueOf(number);
			}else {
				teacherNum = semester +String.valueOf(number);
			}
		}else {
			if (!Pattern.matches(reg, teacherNum)){
				return "教师编号必须由首位不为0的8位数字构成";
			}
			List<Teacher> chk = manageDao.loadteacherbyIdent(teacherNum);
			if (chk != null && chk.size() > 0){
				return "教师编号已存在";
			}
		}		
		reg = "[a-zA-Z\u4e00-\u9fa5]{2,}";
		if(!Pattern.matches(reg, items.get(i++))){
			return "姓名必须有2位以上的中英文字符构成";
		}
		reg = "[\u4e00-\u9fa5]{1}";
		String gender = items.get(i++);
		if (!Pattern.matches(reg, gender)){
			return "性别只有男女";
		}
		if (!gender.equals("男") && !gender.equals("女")){
			return "性别只有男女";
		}
		reg = "(1(([35][0-9])|(47)|[8][0126789]))\\d{8}";
		if (!Pattern.matches(reg, items.get(i++))){
			return "手机号格式不正确";
		}
		reg = "\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+";
		if (!Pattern.matches(reg, items.get(i++))){
			return "邮箱格式不正确";
		}
		reg = "[\u4e00-\u9fa5]{2,}";
		if (!Pattern.matches(reg, items.get(i++))){
			return "职称格式由2个或以上的汉字组成";
		}
		String dept = items.get(i++);
		if (!Pattern.matches(reg, dept)){
			return "所属部门由2个以上汉字组成";
		}
		List<Dept> depts = userDao.loaddepts();
		
		for (Dept d : depts) {
			if (d.getDeptname().equals(dept)){
				return null;
			}
		}
		return "所属部门不存在";
	}
	
	private Teacher formateTeacher (List<String> items) {
		int i = 0;
		Teacher t = new Teacher();
		String teacherNum = items.get(i++);
		if (teacherNum.equals("外聘")) {
			String semester = getCurrSemester();
			List<Teacher> teachers = manageDao.loadteacherlikenum(semester);
			Integer number = teachers.size()+1;
			if (number<10) {
				teacherNum = semester +"0" +String.valueOf(number);
			}else {
				teacherNum = semester +String.valueOf(number);
			}
		}
		t.setIdentificationnum(teacherNum);
		t.setTeachername(items.get(i++));
		t.setSex(items.get(i++));
		t.setTelephone(items.get(i++));
		t.setEmail(items.get(i++));
		t.setPosition(items.get(i++));
		List<Dept> depts = userDao.loaddepts();
		String deptName = items.get(i++);
		for (Dept d : depts){
			if (d.getDeptname().equals(deptName)){
				t.setDept(d);
			}
		}
		t.setType(0);
		t.setDeleted(0);
		return t;
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
	
	public Map<String, Object> batchRegistTeacher (String path){
		//List<String> lines = readTxtFile(path);
		List<BatchRegiste> fail = new ArrayList<BatchRegiste>();
		Map<String, Object>  ret = new HashMap<String, Object>();
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
			String errMsg = teacherChk(items);
			if (errMsg == null){
				Teacher t = formateTeacher(items);
				manageDao.teacheradd(t, t.getDept().getDeptid());
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

	public void teacheraddbytxt(String path) {
		
		try {
			List<String> linelist = readTxtFile(path);
			List<Dept> depts = userDao.loaddepts();
			for (String line : linelist) {
				StringTokenizer tokenizer = new StringTokenizer(line);
				if (tokenizer.hasMoreTokens()) {
					Teacher teacher = new Teacher();
					String teachernum = tokenizer.nextToken();
					List<Teacher> teacher2 = manageDao.loadteacherbyIdent(teachernum);
					if (teacher2.size()==0) {
						teacher.setIdentificationnum(teachernum);
						teacher.setTeachername(tokenizer.nextToken());
						teacher.setSex(tokenizer.nextToken());
						teacher.setTelephone(tokenizer.nextToken());
						teacher.setEmail(tokenizer.nextToken());
						teacher.setPosition(tokenizer.nextToken());					
						Integer depid = 0;
						teacher.setType(0);
						teacher.setDeleted(0);
						String deptname = tokenizer.nextToken();
						for (int i = 0; i < depts.size(); i++) {
							if (deptname.equals(depts.get(i).getDeptname())) {
								depid = depts.get(i).getDeptid();
							}
						}
						String password = MD5.generate("123456");
						teacher.setPassword(password);
						manageDao.teacheradd(teacher, depid);
					}else {
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
	}

	public Teacher loadteacherbyid(Integer id) {		
		Teacher teacher = manageDao.loadteacherbyid(id);
		return teacher;
	}

	public void justiceladd(Certify1 certify1) {
		
		manageDao.justiceladd(certify1);
	}

	public void announcementadd(Announcement announcement) {
		
		String title = null;
		String content = null;
		String createdtime = null;
		try {
			title = java.net.URLDecoder.decode(announcement.getTitle(),"UTF-8");
			content = announcement.getContent();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(title.length()!=0){
			SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss ");
			createdtime = df.format(new Date());
			announcement.setContent(content);
			announcement.setCreatedtime(createdtime);
			announcement.setTitle(title);
			manageDao.announcementadd(announcement);
		}		
	}

	public Map<String, Object> announcementmap(int page, int pageSize) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Announcement> announcements = manageDao.announcementlist((page - 1) * pageSize, pageSize);
		long total = manageDao.totalannouncement();
		List<AnnouncementModel> announcementmodels = new ArrayList<AnnouncementModel>();
		for (Announcement s : announcements) {
			AnnouncementModel model = new AnnouncementModel();
			model.setContent(s.getContent());
			model.setCreatedtime(s.getCreatedtime());
			model.setTitle(s.getTitle());
			model.setId(s.getId());
			announcementmodels.add(model);
		}
		map.put("Total", total);
		map.put("Rows", announcementmodels);
		return map;
	}

	public Announcement loadannouncement(Integer id) {
		
		Announcement announcement = manageDao.loadannouncement(id);		
		return announcement;
	}

	public void announcementupdate(Announcement announcement) {
		
		String title = null;
		String content = null;
		String createdtime = null;
		try {
			title = java.net.URLDecoder.decode(announcement.getTitle(),"UTF-8");
			content =announcement.getContent();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss ");
		createdtime = df.format(new Date());
		announcement.setContent(content);
		announcement.setCreatedtime(createdtime);
		announcement.setTitle(title);
		manageDao.announcementupdate(announcement);
	}

	public void announcementdelete(String ids) {
		
		Integer id = Integer.valueOf(ids);
		manageDao.announcementdelete(id);
	}

	public String loadjusticel() {
		
		List<Certify1> certifys = manageDao.loadjusticel();
		String justicellist = "";
		int i = 1;
		for (Certify1 c : certifys) {
			String s = "{\"id\":" + c.getId() + "," + "\"title\":" + "\"" + c.getTitle() + "\","+ "\"filepath\":" + "\"" + c.getFileplace() + "\"," + "\"createdtime\":" + "\"" + c.getCreatedtime()  + "\"}";
			if (i < certifys.size()) {
				justicellist += s + ",";
			} else {
				justicellist += s;
			}
			i++;
		}
		return justicellist;
	}

	public void justiceldelete(String ids) {
		
		Integer id = Integer.valueOf(ids);
		manageDao.justiceldelete(id);
	}

	public List<Certify1> loadjusticellist() {
		
		List<Certify1> justicelList = manageDao.loadjusticel();
		return justicelList;
	}

	public Certify1 loadjusticelbyid(Integer id) {
		
		Certify1 certify1 = manageDao.loadjusticelbyid(id);
		return certify1;
	}

	public void justicelupdate(Certify1 certify) {
		
		manageDao.justicelupdate(certify);
	}

	public String loadattendencelist(String id) {
		attendencelist.clear();
		String semester = getCurrSemester();
		attendencelist= manageDao.attendencestulist(id,semester);
		String justicellist = "";
		for (int i=0;i<attendencelist.size();i++) {
			Student student = studentDao.loadstubystuid(attendencelist.get(i).getPassport());
			if(student==null){
				continue;
			}else {
				String s = "{\"id\":" + attendencelist.get(i).getId() + "," + "\"passport\":" + "\"" + attendencelist.get(i).getPassport() + "\","+ "\"date\":" + "\"" + attendencelist.get(i).getDate() + "\","+ "\"type\":" + "\"" + attendencelist.get(i).getType() + "\","+"\"stuname\":" + "\"" + student.getStuname() + "\","+ "\"firstname\":" + "\"" + student.getFirstname() + "\","+"\"lastname\":" + "\"" + student.getLastname() + "\","+"\"classname\":" + "\"" + student.getClasses().getClassname() + "\","+ "\"time\":" + "\"" + attendencelist.get(i).getTime()  + "\"}";
				if (i < attendencelist.size()-1) {
					justicellist += s + ",";
				} else {
					justicellist += s;
				}
			}			
		}
		return justicellist;
	}
	@Override
	public Map<String, Object> searchcourseattendencelist(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		long total = attendencelist.size();
		List<AttendenceModel> attendencemodels = new ArrayList<AttendenceModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < attendencelist.size()) {
				AttendenceModel model = new AttendenceModel();
			    model.setId(attendencelist.get(i).getId());
				Student student = studentDao.loadstubystuid(attendencelist.get(i).getPassport());
				model.setClassname(student.getClasses().getClassname());
				model.setDate(attendencelist.get(i).getDate());
				model.setFirstname(student.getFirstname());
				model.setLastname(student.getLastname());
				model.setStunum(student.getStuid());
				model.setPassport(student.getPassport());
				model.setStuname(student.getStuname());
				Course course = manageDao.loadCourseByIdent(String.valueOf(attendencelist.get(i).getChoosencourseid()));
				model.setCoursename(course.getCoursename());
				model.setTime(attendencelist.get(i).getTime());
				model.setType(attendencelist.get(i).getType());
				attendencemodels.add(model);										    
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", attendencemodels);
		return map;
	}
	public List<Announcement> announcementlist() {
		
		List<Announcement> announcementlist = manageDao.loadannouncementlist();
		return announcementlist;
	}
	List<Attendence> attendences = new ArrayList<Attendence>();

	public List<Attendence> searchstuattendence(Attendence attendence) {
		
		attendences.clear();
		String semester = getCurrSemester();
		attendences = manageDao.searchstuattendence(attendence,semester);
		return null;
	}

	public Map<String, Object> stuattendencelistmap(int page, int pageSize) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		long total = attendences.size();
		List<AttendenceModel> attendencemodels = new ArrayList<AttendenceModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < attendences.size()) {
			    AttendenceModel model = new AttendenceModel();
			    model.setId(attendences.get(i).getId());
			    Student student = studentDao.loadstubystuid(attendences.get(i).getPassport());
			    Course course = studentDao.loadcoursebycoursenum(String.valueOf(attendences.get(i).getChoosencourseid()));
			    model.setClassname(student.getClasses().getClassname());
			    model.setCoursename(course.getCoursename());
			    model.setDate(attendences.get(i).getDate());
			    model.setFirstname(student.getFirstname());
			    model.setLastname(student.getLastname());
			    model.setStunum(student.getStuid());
			    model.setStuname(student.getStuname());
			    model.setTime(attendences.get(i).getTime());
			    model.setType(attendences.get(i).getType());
			    attendencemodels.add(model);
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", attendencemodels);
		return map;
	}

	public Map<String, Object> personattendencelistmap(int page, int pageSize) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		String semester = getCurrSemester();
		List<Attendence> attendence = manageDao.personattendence(semester);
		long total = attendence.size();
		List<AttendenceModel> attendencemodels = new ArrayList<AttendenceModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < attendence.size()) {
			    AttendenceModel model = new AttendenceModel();
			    model.setId(attendence.get(i).getId());
			    Student student = studentDao.loadstubystuid(attendence.get(i).getPassport());
			    Course course = studentDao.loadcoursebycoursenum(String.valueOf(attendence.get(i).getChoosencourseid()));
			    model.setClassname(student.getClasses().getClassname());
			    model.setCoursename(course.getCoursename());
			    model.setDate(attendence.get(i).getDate());
			    model.setFirstname(student.getFirstname());
			    model.setLastname(student.getLastname());
			    model.setStunum(student.getStuid());
			    model.setStuname(student.getStuname());
			    model.setTime(attendence.get(i).getTime());
			    model.setType(attendence.get(i).getType());
			    attendencemodels.add(model);
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", attendencemodels);
		return map;
	}

	

	public void teacherchangeimg(String imgurl) {		
		User teacher = (User) ActionContext.getContext().getSession().get("user");
		Teacher teacher2 = manageDao.loadteacherbyidentificationnum(teacher.getUsernum());
		manageDao.changeimg(imgurl, teacher2);
	}

	public Leave loadleavebyid(Integer id) {
		
		Leave leave = manageDao.loadleavebyid(id);
		return leave;
	}

	public List<InfoBean> getUnarrangeCourses(int page, int pageSize, String semester) {
		int n = getTotalUnarrangedCourseNum(semester);
		List<ChosenCourseModel> unarranged = new ArrayList<ChosenCourseModel>();
		if (page * pageSize > n)
			//unarranged = manageDao.semesterCourseList(semester).subList((page -1 ) * pageSize, n - 1);
			for (SemesterChosenCourse i : manageDao.semesterCourseList(semester).subList((page -1 ) * pageSize, n - 1)){
				unarranged.add(toModel(i, semester));
			}
		else {
			//unarranged =  manageDao.semesterCourseList(semester).subList((page -1 ) * pageSize, page * pageSize);
			List<SemesterChosenCourse> t = manageDao.semesterCourseList(semester).subList((page -1 ) * pageSize, page * pageSize);
			for (SemesterChosenCourse i : t){
				ChosenCourseModel p = toModel(i, semester);
				unarranged.add(p);
			}
		}
		List<InfoBean> ret = new ArrayList<InfoBean>();
		for (ChosenCourseModel i : unarranged) {
			CourseModel c = i.getCourse();
			String names = "";
			for (ClassesModel name : i.getClasses())
				names += " " +  name.getClassname();
                InfoBean info = new InfoBean(c.getNum(), c.getCoursename(), 1, 16, 2, "必修", "集中式", i.getTeacher().getTeachername(), names);
			ret.add(info);
		}
		return ret;
	}
	
	public int getTotalUnarrangedCourseNum (String semester) {
		//return CourseArrangeTest.getTestChosenCourses().size();
		return manageDao.semesterCourseList(semester).size();
	}
	
	public int getTotalAvlRoomsNum (String semester) {
		//return CourseArrangeTest.getTestRooms().size();
		return manageDao.semesterRoomList(semester).size();
	}

	public List<ClassroomModel> getAvlRooms(int page, int pageSize, String semester) {
		List<ClassroomModel> ret = new ArrayList<ClassroomModel>();
		for (SemesterChosenClassroom i : manageDao.semesterRoomList(semester).subList((page - 1) * pageSize, page * pageSize)){
			ret.add(new ClassroomModel(i.getId(), i.getNum(),
					i.getRoomtype(), i.getRoomcapacity(), i.getRealcapacity(), i.getRoomplace() + i.getNum()));
		}
		return ret;
	}

	public List<ChosenCourseModel> getAllChosenCourse(String semester) {
		//return CourseArrangeTest.getTestChosenCourses();
		List<ChosenCourseModel> ret = new ArrayList<ChosenCourseModel>();
		for (SemesterChosenCourse i : manageDao.semesterCourseList(semester)){
			try{
				ChosenCourseModel n = toModel(i, semester);
				if (n.getCourse() != null){
					ret.add(n);
				}
			} catch (Exception e){
				e.printStackTrace();
			}
			
			
		}
		return ret;
	}
	
	private ChosenCourseModel toModel (SemesterChosenCourse course, String semester) {
		ChosenCourseModel ret = new ChosenCourseModel();
		if (course.getId() != null)
			ret.setSemesterId(String.valueOf(course.getId()));
		if (course.getBegainweek() !=null)
			ret.setBeginWeek(Integer.parseInt(course.getBegainweek()));
		ret.setNum(String.valueOf(course.getCoursenum()));
		List<ClassesModel> classes = new ArrayList<ClassesModel>();
		if (course.getClass_() != null){
			for (String id : course.getClass_().split("&"))
				if (id != null && !id.equals("")){
					classes.add(manageDao.loadClassByID(id));
				}
		}
		if (course.getIsElective() != null && course.getIsElective() == 1){
			ret.setElective(true);
		} else {
			ret.setElective(false);
		}
		ret.setRoomType(course.getRoomtype());
		ret.setClasses(classes);
		if (course.getEndweek() != null)
			ret.setEndWeek(Integer.parseInt(course.getEndweek()));
		if (course.getTeacherid() != null){
			Integer id = new Integer(Integer.parseInt(course.getTeacherid()));
			Teacher p = manageDao.loadteacherbyid(id);
			if (p != null)
				ret.setTeacher(new TeacherModel(p));
		}
		
		// 不设置为-1就默认为0了
		try{
			ret.setWeekday(Integer.parseInt(course.getWeekday()));
		} catch (NumberFormatException e){
			ret.setWeekday(-1);
		}
		
		try{
			ret.setSlot(Integer.parseInt(course.getSlot()));
		} catch (NumberFormatException e){
			ret.setSlot(-1);
		}
		Course n = manageDao.loadCourseByIdent(course.getCoursenum());
		if (n != null){
			ret.setCourse(new CourseModel(n));
			if (n.getCharacter().equals("任选")) {
				ret.getCourse().setElective(true);
			} else {
				ret.getCourse().setElective(false);
			}
		}
		List<SemesterChosenClassroom> rooms = manageDao.loadsemesterroombyid(course.getRoomname(),semester);
		if (rooms.size() > 0){
			SemesterChosenClassroom room = rooms.get(0);
			ret.setRoom(new ClassroomModel(room.getId(), room.getNum(), room.getRoomtype(), 
					room.getRoomcapacity(), room.getRealcapacity(), room.getRoomplace()+room.getRoomname()));
		}
		
		if (course.getIsElective() == 2) {
			if (course.getStuNum() != null)
				ret.setStudentNum(course.getStuNum());
		}
		return ret;
	}
	
	
	public List<ClassroomModel> getAllAvlRooms (String semester) {
		//return CourseArrangeTest.getTestRooms();
		List<ClassroomModel> ret = new ArrayList<ClassroomModel>();
		List<SemesterChosenClassroom> rooms = manageDao.semesterRoomList(semester);
		for (SemesterChosenClassroom room : rooms){
			ret.add(new ClassroomModel(room.getId(), room.getNum(), room.getRoomtype(), 
					room.getRoomcapacity(), room.getRealcapacity(), room.getRoomplace()+room.getRoomname()));
		}
		return ret;
	}
	
	
	private SemesterChosenCourseModel semesterToModel (SemesterChosenCourse i) {
		SemesterChosenCourseModel model = new SemesterChosenCourseModel();
	    model.setId(i.getId());
	    Course courses = studentDao.loadcoursebycoursenum(i.getCoursenum());
	    if (courses == null)
	    	return null;
	    model.setCoursename(courses.getCoursename());
	    model.setCheckway(courses.getCheckway());
	    model.setBegainweek(i.getBegainweek());
	    model.setEndweek(i.getEndweek());
	    if (i.getClass_()!=null) {
	    	StringTokenizer fenxi = new StringTokenizer(i.getClass_(),"&");
			String classname = "";
		    while(fenxi.hasMoreTokens()){
				String sid = fenxi.nextToken();
				int classid = Integer.valueOf(sid);
				Classes cls = studentDao.loadclassbyid(classid);
				classname = classname+cls.getClassname()+" ";
			}
		    model.setClasses(classname);
		}			    
	    model.setSemester(i.getSemester());
	    model.setCredits(i.getCredits());
	    model.setSlot(i.getSlot());	
	    model.setStuNum(i.getStuNum());
	    model.setLessonCount(i.getLessonCount());
	    model.setIsOddWeek(i.getIsOddWeek());
	    model.setIsElective(i.getIsElective());
	    Teacher teacher = userDao.loadteacherbyid(i.getTeacherid());
	    if (teacher!=null) {
	    	model.setTeacherid(i.getTeacherid());
	    	model.setTeachername(teacher.getTeachername());
		}			    
	    model.setCoursenum(i.getCoursenum());
	    model.setRoomname(i.getRoomname());
	    model.setRoomtype(i.getRoomtype());
	    model.setWeekday(i.getWeekday());
	    model.setLessonCount(i.getLessonCount());
	    model.setWeeklesson(i.getWeeklesson());
	    return model;
	}
	
	
	
	public Map<String, Object> semestercourselist2(int page, int pageSize, String semester) {
		 
		Map<String, Object> map = new HashMap<String, Object>();
		List<SemesterChosenCourse> dat = manageDao.semesterCourseList(semester);
		List<SemesterChosenCourse> unique = new ArrayList<SemesterChosenCourse>();
		Set<String> set = new HashSet<String>();
		for (SemesterChosenCourse i : dat) {
			if (set.contains(i.getCoursenum())){
				continue;
			}
			set.add(i.getCoursenum());
			unique.add(i);
		}

		List<SemesterChosenCourseModel> ret = new ArrayList<SemesterChosenCourseModel>();
		if (unique.size() < (page - 1) * pageSize)
			page = 1;
		if (unique.size() < page * pageSize) {
			for (SemesterChosenCourse i : unique.subList((page - 1) * pageSize, unique.size())){
				SemesterChosenCourseModel n = semesterToModel(i);
				if (n != null)
					ret.add(n);
			}
		} else {
			for (SemesterChosenCourse i : unique.subList((page - 1) * pageSize, page * pageSize)){
				SemesterChosenCourseModel n = semesterToModel(i);
				if (n != null)
					ret.add(n);
			}
		}
		
		map.put("Total", unique.size());
		map.put("Rows", ret);
		return map;
	}
	public Map<String, Object> semestercourselist3(int page, int pageSize, String semester) {
		/* 
		Map<String, Object> map = new HashMap<String, Object>();
		User user =(User)ActionContext.getContext().getSession().get("user");
		List<SemesterChosenCourse> dat = manageDao.loadattendencecourse(user.getUsernum(), semester);
		List<SemesterChosenCourse> unique = new ArrayList<SemesterChosenCourse>();
		Set<String> set = new HashSet<String>();
		for (SemesterChosenCourse i : dat) {
			if (set.contains(i.getCoursenum())){
				continue;
			}
			set.add(i.getCoursenum());
			unique.add(i);
		}
		List<CourseModel> ret = new ArrayList<CourseModel>();
		if (unique.size() < (page - 1) * pageSize)
			page = 1;
		if (unique.size() < page * pageSize) {
			for (SemesterChosenCourse i : unique.subList((page - 1) * pageSize, unique.size())){
				CourseModel n = toCourseModel(i);
				if (n != null)
					ret.add(n);
			}
		} else {
			for (SemesterChosenCourse i : unique.subList((page - 1) * pageSize, page * pageSize)){
				CourseModel n = toCourseModel(i);
				if (n != null)
					ret.add(n);
			}
		}		
		map.put("Total", unique.size());
		map.put("Rows", ret);
		return map;*/
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)ActionContext.getContext().getSession().get("user");
		List<SemesterChosenCourse> semestercourse = new ArrayList<SemesterChosenCourse>();
		if(user.getRoles().getRolerank()==0||user.getRoles().getRolerank()==1){
			semestercourse = manageDao.loadsemestercourse(semester);
		}else if (user.getRoles().getRolerank()==4||user.getRoles().getRolerank()==2) {
			semestercourse = manageDao.loadattendencecourse(user.getUsernum(),semester);
		}/*else {
			List<Classes> classlist = studentDao.loadclassbyteacher(user.getUsernum());
			for(Classes c:classlist){
			  List<SemesterChosenCourse>	sem = manageDao.getChosenCourseByClassNum(String.valueOf(c.getId()), semester);
			  semestercourse.addAll(sem);
			}
		}*/
		
		for (int i = 0; i < semestercourse.size(); i++)  //外循环是循环的次数
        {
            for (int j = semestercourse.size() - 1 ; j > i; j--)  //内循环是 外循环一次比较的次数
            {
                if (semestercourse.get(i).getCoursenum().equals(semestercourse.get(j).getCoursenum()))
                {
                    semestercourse.remove(j);
                }

            }
        }
		//List<Course> courses = manageDao.loadattendencecourse((page - 1) * pageSize,pageSize , user.getUsernum());
		List<Course> courses = new ArrayList<Course>();
		for(SemesterChosenCourse c :semestercourse){
			Course course = manageDao.loadCourseByIdent(c.getCoursenum());
			Teacher teacher = manageDao.loadteacherbyidentificationnum(c.getTeacherid());
			course.setTeacher(teacher.getTeachername());
			courses.add(course);
		}
		long total = courses.size();
		List<CourseModel> coursemodels = new ArrayList<CourseModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
		 if (i < courses.size()) {
			CourseModel model = new CourseModel();
			model.setId(courses.get(i).getId());
			model.setNum(courses.get(i).getNum());
			model.setCoursename(courses.get(i).getCoursename());
			model.setTeacher(courses.get(i).getTeacher());
			model.setCharacter(courses.get(i).getCharacter());
			model.setCheckway(courses.get(i).getCheckway());
			model.setCredits(courses.get(i).getCredits());
			model.setBeginweeks(courses.get(i).getBeginweeks());
			model.setEndweeks(courses.get(i).getEndweeks());
			coursemodels.add(model);
		}
		}
		map.put("Total", total);
		map.put("Rows", coursemodels);
		return map;
	}
	
	private CourseModel toCourseModel(SemesterChosenCourse i){
		CourseModel c = new CourseModel();
		c.setId(i.getId());
		c.setNum(i.getCoursenum());
		Course courses = studentDao.loadcoursebycoursenum(i.getCoursenum());
	    if (courses == null)
	    	return null;
	    c.setCoursename(courses.getCoursename());
		return c;
	}
	
	
	
	
	@Override
	public Map<String, Object> semestercourselist(int page, int pageSize) {
		 
		Map<String, Object> map = new HashMap<String, Object>();
		List<SemesterChosenCourse> semestercourselist = manageDao.semestercourselist();
		//List<SemesterChosenCourse> semestercourses = new ArrayList<SemesterChosenCourse>();
		for (int i = 0; i < semestercourselist.size(); i++) {
			for (int j = semestercourselist.size()-1; j>i; j--) {
			if (semestercourselist.get(i).getCoursenum().equals(semestercourselist.get(j).getCoursenum())) {
				//semestercourses.add(semestercourselist.get(i));
				semestercourselist.remove(semestercourselist.get(j));
			}
			}
		}
		long total = semestercourselist.size();
		List<SemesterChosenCourseModel> semestercoursemodels = new ArrayList<SemesterChosenCourseModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < semestercourselist.size()) {
				SemesterChosenCourseModel model = new SemesterChosenCourseModel();
			    model.setId(semestercourselist.get(i).getId());
			    Course courses = studentDao.loadcoursebycoursenum(semestercourselist.get(i).getCoursenum());
			    model.setCoursename(courses.getCoursename());
			    model.setCheckway(courses.getCheckway());
			    model.setBegainweek(semestercourselist.get(i).getBegainweek());
			    model.setEndweek(semestercourselist.get(i).getEndweek());
			    if (semestercourselist.get(i).getClass_()!=null) {
			    	StringTokenizer fenxi = new StringTokenizer(semestercourselist.get(i).getClass_(),"&");
					String classname = "";
				    while(fenxi.hasMoreTokens()){
						String sid = fenxi.nextToken();
						int classid = Integer.valueOf(sid);
						Classes cls = studentDao.loadclassbyid(classid);
						classname = classname+cls.getClassname()+" ";
					}
				    model.setClasses(classname);
				}			    
			    model.setSemester(semestercourselist.get(i).getSemester());
			    model.setCredits(semestercourselist.get(i).getCredits());
			    model.setSlot(semestercourselist.get(i).getSlot());	
			    model.setStuNum(semestercourselist.get(i).getStuNum());
			    model.setLessonCount(semestercourselist.get(i).getLessonCount());
			    model.setIsOddWeek(semestercourselist.get(i).getIsOddWeek());
			    model.setIsElective(semestercourselist.get(i).getIsElective());
			    Teacher teacher = userDao.loadteacherbyid(semestercourselist.get(i).getTeacherid());
			    if (teacher!=null) {
			    	model.setTeacherid(semestercourselist.get(i).getTeacherid());
			    	model.setTeachername(teacher.getTeachername());
				}			    
			    model.setCoursenum(semestercourselist.get(i).getCoursenum());
			    model.setRoomname(semestercourselist.get(i).getRoomname());
			    model.setRoomtype(semestercourselist.get(i).getRoomtype());
			    model.setWeekday(semestercourselist.get(i).getWeekday());
			    model.setLessonCount(semestercourselist.get(i).getLessonCount());
			    model.setWeeklesson(semestercourselist.get(i).getWeeklesson());
			    semestercoursemodels.add(model);
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", semestercoursemodels);
		return map;
	}

	@Override
	public void semestercourseadd(String ids,String semester) {
		semester = getCurrSemester();
		StringTokenizer fenxi = new StringTokenizer(ids, ",");
		while (fenxi.hasMoreTokens()) {
			String sid = fenxi.nextToken();
			int courseid = Integer.parseInt(sid);
			Course course = studentDao.loadcoursebyid(courseid);
			List<SemesterChosenCourse> semestercourses = manageDao.loadsemestercoursebyid(course.getNum(),semester);
			if (semestercourses.size()==0) {				
				SemesterChosenCourse semestercourse = new SemesterChosenCourse();
				semestercourse.setCoursenum(String.valueOf(course.getNum()));				
				semestercourse.setBegainweek(String.valueOf(course.getBeginweeks()));
				semestercourse.setEndweek(String.valueOf(course.getEndweeks()));
				semestercourse.setCredits(String.valueOf(course.getCredits()));
				semestercourse.setLessonCount((int)course.getCredits()*16);
				semestercourse.setWeeklesson(course.getWeeklesson());
				semestercourse.setSemester(semester);
				if(course.getCharacter().equals("必修")){
                   semestercourse.setIsElective(0);
                }else if(course.getCharacter().equals("限选")){
					semestercourse.setIsElective(1);
				}else if(course.getCharacter().equals("任选")){
					semestercourse.setIsElective(2);
				}
				manageDao.semestercourseadd(semestercourse);
			}else {
				continue;
			}			
		}
	}
	@Override
	public void semestercoursedelete(String ids){
		StringTokenizer fenxi = new StringTokenizer(ids,",");
		while(fenxi.hasMoreTokens()){
			String sid = fenxi.nextToken();
			int courseid = Integer.valueOf(sid);
			manageDao.semestercoursedelete(courseid);
		}
	}

	@Override
	public Map<String, Object> courselist(int page, int pageSize) {
		 
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> courses = studentDao.loadcourse();
		List<Course> course1 = new ArrayList<Course>();
		String semester = getCurrSemester();
		List<SemesterChosenCourse> semestercourse = manageDao.SemesterCourselist(semester);
		for (int i = 0; i < courses.size(); i++) {
			for (int j = 0; j < semestercourse.size(); j++) {
				if (courses.get(i).getNum().equals(semestercourse.get(j).getCoursenum())) {
					course1.add(courses.get(i));
				}
			}
		}
		courses.removeAll(course1);
		long total = courses.size();
		List<CourseModel> coursemodels = new ArrayList<CourseModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < courses.size()) {
			   CourseModel model = new CourseModel();
			   model.setId(courses.get(i).getId());
			   model.setNum(courses.get(i).getNum());
			   model.setCoursename(courses.get(i).getCoursename());
			   model.setTeacher(courses.get(i).getTeacher());
			   model.setCharacter(courses.get(i).getCharacter());
			   model.setCheckway(courses.get(i).getCheckway());
			   model.setCredits(courses.get(i).getCredits());
			   model.setBeginweeks(courses.get(i).getBeginweeks());
			   model.setEndweeks(courses.get(i).getEndweeks());
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
	public Map<String, Object> Searchcourselist(int page, int pageSize,String semester) {
		 
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> courses = studentDao.loadcourse();
		List<Course> course1 = new ArrayList<Course>();
		List<SemesterChosenCourse> semestercourse = manageDao.SemesterCourselist(semester);
		for (int i = 0; i < courses.size(); i++) {
			for (int j = 0; j < semestercourse.size(); j++) {
				if (courses.get(i).getNum().equals(Integer.valueOf(semestercourse.get(j).getCoursenum()))) {
					course1.add(courses.get(i));
				}
			}
		}
		courses.removeAll(course1);
		long total = courses.size();
		List<CourseModel> coursemodels = new ArrayList<CourseModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < courses.size()) {
			   CourseModel model = new CourseModel();
			   model.setId(courses.get(i).getId());
			   model.setNum(courses.get(i).getNum());
			   model.setCoursename(courses.get(i).getCoursename());
			   model.setTeacher(courses.get(i).getTeacher());
			   model.setCharacter(courses.get(i).getCharacter());
			   model.setCheckway(courses.get(i).getCheckway());
			   model.setCredits(courses.get(i).getCredits());
			   model.setBeginweeks(courses.get(i).getBeginweeks());
			   model.setEndweeks(courses.get(i).getEndweeks());
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
	public Map<String, Object> roomlist(int page, int pageSize) {
		 
		Map<String, Object> map = new HashMap<String, Object>();
		List<Classroom> room = studentDao.loadroom();
		List<Classroom> room1= new ArrayList<Classroom>();
		List<SemesterChosenClassroom> semesterroomlist = manageDao.semesterroomlist();
		for (int i = 0; i < room.size(); i++) {
			for (int j = 0; j < semesterroomlist.size(); j++) {
				if (room.get(i).getNum().equals(semesterroomlist.get(j).getNum())) {
					room1.add(room.get(i));
				}
			}
		}
		room.removeAll(room1);
		long total = room.size();
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
			roommodels.add(model);
		}
		map.put("Total", total);
		map.put("Rows", roommodels);
		return map;
	}


	@Override
	public Map<String, Object> semesterroomlist(int page, int pageSize) {
		 
		Map<String, Object> map = new HashMap<String, Object>();
		List<SemesterChosenClassroom> semesterroomlist = manageDao.semesterroomlist();
		long totals = semesterroomlist.size();
		List<SemesterChosenClassroomModel> roommodelss = new ArrayList<SemesterChosenClassroomModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < semesterroomlist.size()) {
				SemesterChosenClassroomModel model = new SemesterChosenClassroomModel();				
				model.setId(semesterroomlist.get(i).getId());
				model.setNum(String.valueOf(semesterroomlist.get(i).getNum()));
				model.setRoomname(semesterroomlist.get(i).getRoomname());
				model.setRoomplace(semesterroomlist.get(i).getRoomplace());
				model.setRoomtype(semesterroomlist.get(i).getRoomtype());
				model.setRoomcapacity(semesterroomlist.get(i).getRoomcapacity());
				model.setRealcapacity(semesterroomlist.get(i).getRealcapacity());
				model.setNote(semesterroomlist.get(i).getNote());
				roommodelss.add(model);
			} else {
				break;
			}
		}
		map.put("Total", totals);
		map.put("Rows", roommodelss);
		return map;
	}
	
	
	public Map<String, Object> semesterroomlist2(int page, int pageSize, String semester) {
		 
		Map<String, Object> map = new HashMap<String, Object>();
		List<SemesterChosenClassroom> semesterroomlist = manageDao.semesterRoomList(semester);
		long totals = semesterroomlist.size();
		List<SemesterChosenClassroomModel> roommodelss = new ArrayList<SemesterChosenClassroomModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < semesterroomlist.size()) {
				SemesterChosenClassroomModel model = new SemesterChosenClassroomModel();				
				model.setId(semesterroomlist.get(i).getId());
				model.setNum(String.valueOf(semesterroomlist.get(i).getNum()));
				model.setRoomname(semesterroomlist.get(i).getRoomname());
				model.setRoomplace(semesterroomlist.get(i).getRoomplace());
				model.setRoomtype(semesterroomlist.get(i).getRoomtype());
				model.setRoomcapacity(semesterroomlist.get(i).getRoomcapacity());
				model.setRealcapacity(semesterroomlist.get(i).getRealcapacity());
				model.setNote(semesterroomlist.get(i).getNote());
				roommodelss.add(model);
			} else {
				break;
			}
		}
		map.put("Total", totals);
		map.put("Rows", roommodelss);
		return map;
	}
	
	
	@Override
	public void semesterroomadd(String ids,String semester) {
		 
		StringTokenizer fenxi = new StringTokenizer(ids, ",");
		while (fenxi.hasMoreTokens()) {
			String sid = fenxi.nextToken();
			int roomid = Integer.parseInt(sid);
			Classroom room = studentDao.loadroombyid(roomid);
			List<SemesterChosenClassroom> semestercourses = manageDao.loadsemesterroombyid(String.valueOf(room.getNum()),semester);
			if (semestercourses.size()==0) {				
				SemesterChosenClassroom semesterroom = new SemesterChosenClassroom();
				semesterroom.setNote(room.getNote());
				semesterroom.setNum(String.valueOf(room.getNum()));
				semesterroom.setRealcapacity(String.valueOf(room.getRealcapacity()));
				semesterroom.setRoomcapacity(String.valueOf(room.getRoomcapacity()));
				semesterroom.setRoomname(room.getRoomname());
				semesterroom.setRoomplace(room.getRoomplace());
				semesterroom.setRoomtype(room.getRoomtype());
				semesterroom.setSemester(semester);
				manageDao.semesterroomadd(semesterroom);
			}else {
				continue;
			}			
		}
	}
	@Override
	public void semesterroombegainadd(Classroom c,String semester) {
		List<SemesterChosenClassroom> semestercourses = manageDao.loadsemesterroombyid(String.valueOf(c.getNum()),semester);
		if (semestercourses.size()==0) {				
			SemesterChosenClassroom semesterroom = new SemesterChosenClassroom();
			semesterroom.setNote(c.getNote());
			semesterroom.setNum(String.valueOf(c.getNum()));
			semesterroom.setRealcapacity(String.valueOf(c.getRealcapacity()));
			semesterroom.setRoomcapacity(String.valueOf(c.getRoomcapacity()));
			semesterroom.setRoomname(c.getRoomname());
			semesterroom.setRoomplace(c.getRoomplace());
			semesterroom.setRoomtype(c.getRoomtype());
			semesterroom.setSemester(semester);
			manageDao.semesterroomadd(semesterroom);
		}		
	}
	@Override
	public void semesterroomdelete(String ids) {
		 
		StringTokenizer fenxi = new StringTokenizer(ids,",");
		while(fenxi.hasMoreTokens()){
			String sid = fenxi.nextToken();
			int roomid = Integer.valueOf(sid);
			manageDao.semesterroomdelete(roomid);
		}
	}

	public void saveArrangedCourse(List<ChosenCourseModel> arranged, String semester) {
		manageDao.saveSyllabus(arranged, semester);
	}

	@Override
	public void semestercourseteacheradd(List<SemesterChosenCourse> listUpdated) {
		for (SemesterChosenCourse s :listUpdated) {
			SemesterChosenCourse semestercourse = new SemesterChosenCourse();
			List<SemesterChosenCourse> seme = manageDao.loadsemestercoursebycourseid(s.getCoursenum(), s.getSemester());
			for(SemesterChosenCourse c:seme){
			semestercourse.setId(c.getId());
			semestercourse.setBegainweek(s.getBegainweek());
			semestercourse.setEndweek(s.getEndweek());
			semestercourse.setTeacherid(s.getTeacherid());
			semestercourse.setCredits(s.getCredits());
			semestercourse.setLessonCount(s.getLessonCount());
			semestercourse.setWeeklesson(s.getWeeklesson());
			semestercourse.setRoomtype(s.getRoomtype());
			semestercourse.setIsElective(s.getIsElective());
			manageDao.semestercourseteacheradd(semestercourse);
			}
		}
	}

	public void semesterteacherendadd(String identificationnum,Integer semestercourseid) {
		Teacher teacher = manageDao.loadteacherbyidentificationnum(identificationnum);
		SemesterChosenCourse semeesterchosencourse = manageDao.loadSemesterChosenCourseById(String.valueOf(semestercourseid));
		List<SemesterChosenCourse> seme = manageDao.loadsemestercoursebycourseid(semeesterchosencourse.getCoursenum(), semeesterchosencourse.getSemester());
		for(SemesterChosenCourse c:seme){		
			manageDao.semesterteacherendadd(teacher.getIdentificationnum(),c.getId());
		}
	}

	public void semesterclassset(Integer id, String ids) {
		ids = ids.replace(",", "&");
		SemesterChosenCourse semeesterchosencourse = manageDao.loadSemesterChosenCourseById(String.valueOf(id));
		List<SemesterChosenCourse> seme = manageDao.loadsemestercoursebycourseid(semeesterchosencourse.getCoursenum(), semeesterchosencourse.getSemester());
		for(SemesterChosenCourse c:seme){		
		  manageDao.semestercourseclassset(c.getId(),ids);
		}
	}
	
	public List<ChosenCourseModel> getStuSyllabus(String stuid, String semester) {
		/*List<ChosenCourseModel> ret = new ArrayList<ChosenCourseModel>();
		List<ChosenCourse> t = manageDao.stuSyllabusList(stuid, semester);
		List<ChosenCourseModel> temp = new ArrayList<ChosenCourseModel>();
		if (t != null && t.size() > 0)
			for (ChosenCourse course : t){
				List<SemesterChosenCourse> c =  manageDao.loadsemestercoursebyid(course.getCourseId(), semester);
				if (c != null && c.size() > 0)
					ret.add(toModel(c.get(0), semester));
				for (SemesterChosenCourse p : c)
					ret.add(toModel(p, semester));
			}
		String className = getClassByStuId(stuid).getClassname();
		for (ChosenCourseModel q : ret){
			for (ClassesModel c : q.getClasses())
				if (c.getClassname().equals(className)){
					temp.add(q);
					break;
				}
		}
		return temp;*/
		
		// 最终结果
		List<ChosenCourseModel> ret = new ArrayList<ChosenCourseModel>();
		// 先从ChosenCourse 中读出已经选择的课程
		List<ChosenCourse> selected =  manageDao.getChosenCourseListByStuID(stuid, semester);
		if (selected == null || selected.size() == 0)
			return ret;
		// 获得所在班级的信息
		Classes thisClass = manageDao.getClassByStuID(stuid);
		//从本学期课程中查询选择的课程
		String classNum = String.valueOf(thisClass.getId());
		List<SemesterChosenCourse> lessons = manageDao.getChosenCourseByClassNum(classNum, semester);
		for (SemesterChosenCourse i : lessons) {
			for (ChosenCourse j : selected) {
				String num = i.getCoursenum();
				if (j.getCourseId().equals(num)) {
					ret.add(toModel(i, semester));
					break;
				}
			}
		}
		// 选修课
		List<SemesterChosenCourse> elective = manageDao.electiveCourseList(semester);
		for (SemesterChosenCourse i : elective) {
			for (ChosenCourse j : selected) {
				String num = i.getCoursenum();
				if (j.getCourseId().equals(num)) {
					ret.add(toModel(i, semester));
					break;
				}
			}
		}
		return ret;
	}

	
	
	public List<ChosenCourseModel> getOtherOption(ChosenCourseModel course, String semester) {
		List<ChosenCourseModel> fullTable = new ArrayList<ChosenCourseModel>();
		for (SemesterChosenCourse i : manageDao.semesterCourseList(semester)){
			fullTable.add(toModel(i, semester));
		}
		List<ClassroomModel> rooms = new ArrayList<ClassroomModel>();
		for (SemesterChosenClassroom i : manageDao.semesterRoomList(semester)){
			rooms.add(new ClassroomModel(i.getId(), i.getNum(),
					i.getRoomtype(), i.getRoomcapacity(), i.getRealcapacity(), i.getRoomplace() + i.getNum()));
		}
		for (ClassroomModel r : rooms){
			for (int d = 0; d < 5; ++d){
				for (int s = 0; s < 5; ++s) {
					boolean isfind = false;
					for (ChosenCourseModel c : fullTable) {
						if (c.getRoom() == null)
							continue;
						if (c.getSlot() == s && c.getWeekday() == d && c.getRoom().getNum().equals(r.getNum()))
							continue;
					}
					if (!isfind)
						fullTable.add(new ChosenCourseModel(d, s, r));
				}
			}
		}
		TableState currState = new TableState(fullTable, 5, 5);
		List<ChosenCourseModel> otherOption = new ArrayList<ChosenCourseModel>();
		for (ChosenCourseModel i : fullTable){
			if (currState.chkOption(course, i))
				otherOption.add(i);
		}
		return otherOption;
	}


	public List<ChosenCourseModel> loadAllChosenCourse(String semester) {
		List<SemesterChosenCourse> all = new ArrayList<SemesterChosenCourse>(); //manageDao.semesterCourseList(semester);
		User user = (User)ActionContext.getContext().getSession().get("user");
		if(user.getRoles().getRolerank()==0||user.getRoles().getRolerank()==1){
			all = manageDao.semesterCourseList(semester);  		
		}else if (user.getRoles().getRolerank()==2 || user.getRoles().getRolerank() == 4) {
			List<Classes> classlist = studentDao.loadclassbyteacher(user.getUsernum());	      
			for(Classes c:classlist){
				List<SemesterChosenCourse> semes = manageDao.loadsemestercoursebyclass(c.getId(),semester);
			    all.addAll(semes);
			}
		}		
		if (all == null || all.size() == 0)
			return null;
		List<ChosenCourseModel> ret = new ArrayList<ChosenCourseModel>();
		for (SemesterChosenCourse i : all) {
			ret.add(toModel(i, semester));
		}
		return ret;
	}
	
	public List<ChosenCourseModel> loadAllChosenCourse2(String semester) {
		List<SemesterChosenCourse> all = manageDao.semesterCourseList(semester);  	
		if (all == null || all.size() == 0) {
			return null;
		}
		List<ChosenCourseModel> ret = new ArrayList<ChosenCourseModel>();
		for (SemesterChosenCourse i : all) {
			ret.add(toModel(i, semester));
		}
		return ret;
	}
	
	
	
	public List<Adjustcourse> adjustRecordList(String semester) {
		return manageDao.adjustRecord(semester);
	}

	public void checkAdjustApply(boolean isApprove, Integer id) {
		if (isApprove)
			manageDao.approveAdjust(id);
		else
			manageDao.disapproveAdjust(id);
		
	}

	@Override
	public ClassesModel getClassByStuId(String stuid) {		
		return new ClassesModel(manageDao.getClassByStuID(stuid));
	}
	
	public List<ChosenCourseModel> electiveCourseForSelectCourse (String stuid, String semester){
		List<ChosenCourseModel> options = new ArrayList<ChosenCourseModel>();
		for (SemesterChosenCourse i : manageDao.electiveCourseList(semester))
			options.add(toModel(i, semester));
		
		//List<ChosenCourseModel> ret = new ArrayList<ChosenCourseModel>();
        // 已选择课程
		List<ChosenCourse> allreadyIn = manageDao.stuSyllabusList(stuid, semester);
		for (ChosenCourseModel i : options) {
			//boolean isfind = false;
			for (ChosenCourse j : allreadyIn){
				if (i.getCourse().getNum().equals(j.getCourseId())){
					/*isfind = true;
					break;*/
					i.setSelected(true);
				}
			}
			/*if (!isfind)
				ret.add(i);*/
		}
		return options;
	}
	
	
	@Override
	public List<ChosenCourseModel> allSelectiveCourses(String stuid, String semester) {
		List<ChosenCourseModel> options = new ArrayList<ChosenCourseModel>();
		// 所有该学期的课程
		List<ChosenCourseModel> all = getAllChosenCourse(semester);
		ClassesModel thisclass = getClassByStuId(stuid);
		//如果找到所在班级，则找到所在班级在该学期的课程
		if (thisclass.getId() != null){
			for (ChosenCourseModel i : all) {
				for (ClassesModel j : i.getClasses())
					if (j.getId().equals(thisclass.getId())){
						options.add(i);
						break;
					}
				}
			}
		// 该学期的选修课
		/*for (SemesterChosenCourse i : manageDao.electiveCourseList(semester))
			options.add(toModel(i, semester));*/
		
		//List<ChosenCourseModel> ret = new ArrayList<ChosenCourseModel>();
        // 已选择课程
		List<ChosenCourse> allreadyIn = manageDao.stuSyllabusList(stuid, semester);
		for (ChosenCourseModel i : options) {
			//boolean isfind = false;
			for (ChosenCourse j : allreadyIn){
				if (i.getCourse().getNum().equals(j.getCourseId())){
					/*isfind = true;
					break;*/
					i.setSelected(true);
				}
			}
			/*if (!isfind)
				ret.add(i);*/
		}
		return options;
	}

	@Override
	public Map<String, Object> semesterselectcourselist(int page, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SemesterChosenCourse> semestercourselist = manageDao.semesterselectcourselist();
		//List<SemesterChosenCourse> semestercourses = new ArrayList<SemesterChosenCourse>();
		List<SemesterChosenCourse> sem = new ArrayList<SemesterChosenCourse>();
		for (int i = 0; i < semestercourselist.size(); i++) {
			for (int j = semestercourselist.size()-1; j>i; j--) {
			if (semestercourselist.get(i).getCoursenum().equals(semestercourselist.get(j).getCoursenum())) {
				//semestercourses.add(semestercourselist.get(i));
				semestercourselist.remove(semestercourselist.get(j));
			}
			}
		}
		long total = semestercourselist.size();
		List<SemesterChosenCourseModel> semestercoursemodels = new ArrayList<SemesterChosenCourseModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < semestercourselist.size()) {
				SemesterChosenCourseModel model = new SemesterChosenCourseModel();
			    model.setId(semestercourselist.get(i).getId());
			    Course courses = studentDao.loadcoursebycoursenum(semestercourselist.get(i).getCoursenum());
			    model.setCoursename(courses.getCoursename());
			    model.setBegainweek(semestercourselist.get(i).getBegainweek());
			    model.setEndweek(semestercourselist.get(i).getEndweek());
			    if (semestercourselist.get(i).getClass_()!=null) {
			    	StringTokenizer fenxi = new StringTokenizer(semestercourselist.get(i).getClass_(),"&");
					String classname = "";
				    while(fenxi.hasMoreTokens()){
						String sid = fenxi.nextToken();
						int classid = Integer.valueOf(sid);
						Classes cls = studentDao.loadclassbyid(classid);
						classname = classname+cls.getClassname()+" ";
					}
				    model.setClasses(classname);
				}			    
			    model.setSemester(semestercourselist.get(i).getSemester());
			    model.setCredits(semestercourselist.get(i).getCredits());
			    model.setSlot(semestercourselist.get(i).getSlot());	
			    model.setStuNum(semestercourselist.get(i).getStuNum());
			    model.setLessonCount(semestercourselist.get(i).getLessonCount());
			    model.setIsOddWeek(semestercourselist.get(i).getIsOddWeek());
			    model.setIsElective(semestercourselist.get(i).getIsElective());
			    Teacher teacher = userDao.loadteacherbyid(semestercourselist.get(i).getTeacherid());
			    if (teacher!=null) {
			    	model.setTeacherid(semestercourselist.get(i).getTeacherid());
			    	model.setTeachername(teacher.getTeachername());
				}			    
			    model.setCoursenum(semestercourselist.get(i).getCoursenum());
			    model.setRoomname(semestercourselist.get(i).getRoomname());
			    model.setRoomtype(semestercourselist.get(i).getRoomtype());
			    model.setWeekday(semestercourselist.get(i).getWeekday());
			    semestercoursemodels.add(model);
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", semestercoursemodels);
		return map;
	}
	
	public void semesterselectcourseupdate(List<SemesterChosenCourse> listUpdated) {
		
		for (SemesterChosenCourse s :listUpdated) {
			SemesterChosenCourse semesterChosenCourse = manageDao.loadsemestercoursebycourseid(s.getId());
			List<SemesterChosenCourse> sem = manageDao.loadsemestercoursebycoursenum(semesterChosenCourse.getCoursenum(), semesterChosenCourse.getSemester());
			for(SemesterChosenCourse c:sem){
				//SemesterChosenCourse semestercourse = new SemesterChosenCourse();
				c.setId(c.getId());
				c.setStuNum(s.getStuNum());
				manageDao.semesterselectcourseupdate(c);
			}
			
		}
	}

	public void selectCourse(boolean isSelect, String courseNum, String stuid, String semester) {
		if (isSelect) {
			String classNum = String.valueOf(getClassByStuId(stuid).getId());
			semester = getCurrSemester();
			List<SemesterChosenCourse> course = manageDao.getChosenCourseByClassNumAndCourseID(classNum, courseNum, semester);
			
			//必修中找不到该课程 到选修中找
			if (course.size() == 0){
				course = manageDao.getChosenCourseByCourseId(courseNum, semester);
			}
			
			SemesterChosenCourse c = course.get(0);
			ChosenCourse ic = new ChosenCourse();
			ic.setPassport(stuid);
			ic.setCourseId(courseNum);
			ic.setSemester(semester);
			ic.setWeekday(c.getWeekday());
			ic.setSlot(c.getSlot());
			ic.setRoom(c.getCoursenum());
			ic.setRoomtype(c.getRoomtype());
			manageDao.selectCourse(ic);
			
		} else {
			List<ChosenCourse> isChosen = manageDao.getChosenCourseListByStuID(stuid, semester);
			ChosenCourse course = null;
			for (ChosenCourse c : isChosen)
				if (c.getCourseId().equals(courseNum)){
					course = c;
					break;
				}
			if (course == null)
				return;
			manageDao.diselectCourse(course);
		}
	}

	@Override
	public SemesterChosenCourse loadsemesterchosencoursebycourseid(String num) {
		// TODO Auto-generated method stub
		String semester = getCurrSemester();
		SemesterChosenCourse semesterChosenCourse = manageDao.loadselectcoursebycourseid(num,semester);
		return semesterChosenCourse;
	}

	@Override
	public List<ChosenCourse> loadchosencoursebycourseid(String num) {
		// TODO Auto-generated method stub
		List<ChosenCourse> chosenCourses = manageDao.loadchosencoursebycourseid(num);
		return chosenCourses;
	}

	@Override
	public Map<String, Object> attendencecourselist(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)ActionContext.getContext().getSession().get("user");
		String semester = getCurrSemester();
		List<SemesterChosenCourse> semestercourse = new ArrayList<SemesterChosenCourse>();
		if(user.getRoles().getRolerank()==0||user.getRoles().getRolerank()==1){
			semestercourse = manageDao.loadsemestercourse(semester);
		}else if (user.getRoles().getRolerank()==4||user.getRoles().getRolerank()==2) {
			semestercourse = manageDao.loadattendencecourse(user.getUsernum(),semester);
		}/*else {
			List<Classes> classlist = studentDao.loadclassbyteacher(user.getUsernum());
			for(Classes c:classlist){
			  List<SemesterChosenCourse>	sem = manageDao.getChosenCourseByClassNum(String.valueOf(c.getId()), semester);
			  semestercourse.addAll(sem);
			}
		}*/
		
		for (int i = 0; i < semestercourse.size(); i++)  //外循环是循环的次数
        {
            for (int j = semestercourse.size() - 1 ; j > i; j--)  //内循环是 外循环一次比较的次数
            {
                if (semestercourse.get(i).getCoursenum().equals(semestercourse.get(j).getCoursenum()))
                {
                    semestercourse.remove(j);
                }

            }
        }
		//List<Course> courses = manageDao.loadattendencecourse((page - 1) * pageSize,pageSize , user.getUsernum());
		List<Course> courses = new ArrayList<Course>();
		for(SemesterChosenCourse c :semestercourse){
			Course course = manageDao.loadCourseByIdent(c.getCoursenum());
			Teacher teacher = manageDao.loadteacherbyidentificationnum(c.getTeacherid());
			course.setTeacher(teacher.getTeachername());
			courses.add(course);
		}
		long total = courses.size();
		List<CourseModel> coursemodels = new ArrayList<CourseModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
		 if (i < courses.size()) {
			CourseModel model = new CourseModel();
			model.setId(courses.get(i).getId());
			model.setNum(courses.get(i).getNum());
			model.setCoursename(courses.get(i).getCoursename());
			model.setTeacher(courses.get(i).getTeacher());
			model.setCharacter(courses.get(i).getCharacter());
			model.setCheckway(courses.get(i).getCheckway());
			model.setCredits(courses.get(i).getCredits());
			model.setBeginweeks(courses.get(i).getBeginweeks());
			model.setEndweeks(courses.get(i).getEndweeks());
			coursemodels.add(model);
		}
		}
		map.put("Total", total);
		map.put("Rows", coursemodels);
		return map;
	}

	@Override
	public Teacher loadteacherbynum(String usernum) {
		// TODO Auto-generated method stub
		Teacher teacher = manageDao.loadteacherbyidentificationnum(usernum);
		return teacher;
	}
	@Override
	public Map<String, Object> searchsemestercourselist(int page, int pageSize,String semester) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User)ActionContext.getContext().getSession().get("user");
		List<SemesterChosenCourse> semestercourse = manageDao.loadattendencecourse(user.getUsernum(),semester);
		//List<Course> courses = manageDao.loadattendencecourse((page - 1) * pageSize,pageSize , user.getUsernum());
		for (int i = 0; i < semestercourse.size(); i++) {
			for (int j = semestercourse.size()-1; j>i; j--) {
			if (semestercourse.get(i).getCoursenum().equals(semestercourse.get(j).getCoursenum())) {
				semestercourse.remove(semestercourse.get(j));
			}
			}
		}
		List<Course> courses = new ArrayList<Course>();
		for(SemesterChosenCourse c :semestercourse){
			Course course = manageDao.loadCourseByIdent(c.getCoursenum());
			courses.add(course);
		}
		long total = courses.size();
		List<CourseModel> coursemodels = new ArrayList<CourseModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
		 if (i < courses.size()) {
			CourseModel model = new CourseModel();
			model.setId(courses.get(i).getId());
			model.setNum(courses.get(i).getNum());
			model.setCoursename(courses.get(i).getCoursename());
			model.setTeacher(courses.get(i).getTeacher());
			model.setCharacter(courses.get(i).getCharacter());
			model.setCheckway(courses.get(i).getCheckway());
			model.setCredits(courses.get(i).getCredits());
			model.setBeginweeks(courses.get(i).getBeginweeks());
			model.setEndweeks(courses.get(i).getEndweeks());
			model.setLessoncount(0);
			model.setWeeklesson(0);
			coursemodels.add(model);
		}
		}
		map.put("Total", total);
		map.put("Rows", coursemodels);
		return map;
	}
	List<ChosenCourse> chosenCourses = new ArrayList<ChosenCourse>();
	@Override
	public List<ChosenCourse> courseclassscoreload(String semester, String num, Integer id) {
		// TODO Auto-generated method stub
		chosenCourses.clear();
		List<Student> students = studentDao.loadstubyclassid(id);
		for (Student s:students) {
			List<ChosenCourse> chosencourses = manageDao.courseclassscoureload(semester,num,s.getPassport()); 
		    chosenCourses.addAll(chosencourses);
		}
		return chosenCourses;
	}
	@Override
	public Map<String, Object> stuscorelist(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		long total = chosenCourses.size();
		List<ChosenCourseModel> coursemodels = new ArrayList<ChosenCourseModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
		 if (i < chosenCourses.size()) {
			ChosenCourseModel model = new ChosenCourseModel();
				if (chosenCourses.get(i).getAttendence() == null||chosenCourses.get(i).getAttendence().length()==0) {// 考勤成绩
					model.setAttendence("");
				} else {
					if (Float.valueOf(chosenCourses.get(i).getAttendence()) < 60) {
						String attendence = chosenCourses.get(i).getAttendence() ;
						model.setAttendence(attendence);
					} else {
						model.setAttendence(String.valueOf(chosenCourses.get(i).getAttendence()));
					}
				}
				if (chosenCourses.get(i).getHomework() == null||chosenCourses.get(i).getHomework().length()==0) {// 平时成绩
					model.setHomework("");
				} else {
					if (Float.valueOf(chosenCourses.get(i).getHomework()) < 60) {
						String homework = chosenCourses.get(i).getHomework();
						model.setHomework(homework);
					} else {
						model.setHomework(String.valueOf(chosenCourses.get(i).getHomework()));
					}
				}
				if (chosenCourses.get(i).getFinalexam() == null||chosenCourses.get(i).getFinalexam().length()==0) {// 期末成绩
					model.setFinalexam("");
				} else {
					if (Float.valueOf(chosenCourses.get(i).getFinalexam()) < 60) {
						String attendence =chosenCourses.get(i).getFinalexam();
						model.setFinalexam(attendence);
					} else {
						model.setFinalexam(String.valueOf(chosenCourses.get(i).getFinalexam()));
					}
				}
				if (chosenCourses.get(i).getMidexam() == null||chosenCourses.get(i).getMidexam().length()==0) {
					model.setMidexam("");
				} else {
					if (Float.valueOf(chosenCourses.get(i).getMidexam()) < 60) {
						String attendence =chosenCourses.get(i).getMidexam();
						model.setMidexam(attendence);
					} else {
						model.setMidexam(String.valueOf(chosenCourses.get(i).getMidexam()));
					}
				}
		    model.setNum(String.valueOf(chosenCourses.get(i).getCourseId()));
			Student stu = studentDao.loadstubystuid(String.valueOf(chosenCourses.get(i).getPassport()));
			model.setStuname(stu.getStuname());
			model.setPassport(stu.getPassport());
			model.setIsmakeup(chosenCourses.get(i).getIsmakeup());
			if (chosenCourses.get(i).getMakeup()!=null) {
				model.setMakeup(String.valueOf(chosenCourses.get(i).getMakeup()));
			}
			Course course = manageDao.loadCourseByIdent(String.valueOf(chosenCourses.get(i).getCourseId()));
			model.setCoursename(course.getCoursename());
			if(chosenCourses.get(i).getSummary()==0){
				model.setSummary("");
			}else {
				if(chosenCourses.get(i).getSummary()<60){
					String attendence = String.valueOf(chosenCourses.get(i).getSummary());
					model.setSummary(attendence);
				}else{
					model.setSummary(String.valueOf(chosenCourses.get(i).getSummary()));
				}
				
			}
			String seme = chosenCourses.get(i).getSemester();
			String semesters = "";
			/*if(seme.substring(4,6).equals("01")){
				semesters = seme.substring(0,4)+"-"+String.valueOf(Integer.valueOf(seme.substring(0,4))+1)+"学年第一学期";
			}else {
				semesters = String.valueOf(Integer.valueOf(seme.substring(0,4))-1)+"-"+seme.substring(0,4)+"学年第二学期";
			}*/
			
			model.setSemester(seme);
			coursemodels.add(model);
		}
		}
		map.put("Total", total);
		map.put("Rows", coursemodels);
		return map;
	}
	@Override
	public Map<String, Object> allstuscorelist(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
	    String semester = getCurrSemester();
	    User user = (User)ActionContext.getContext().getSession().get("user");
	    List<ChosenCourse> chosencourse = new ArrayList<ChosenCourse>();
	    if(user.getRoles().getRolerank()==0||user.getRoles().getRolerank()==1){
	    	chosencourse = manageDao.loadstuscorelist(semester);
	    }else if((user.getRoles().getRolerank()==2)){
	    	List<Classes> classlist = studentDao.loadclassbyteacher(user.getUsernum());
	        List<Student> students = new ArrayList<Student>();
	        for(Classes c:classlist){
	        	List<Student> stu = studentDao.loadstubyclassid(c.getId());
	        	students.addAll(stu);
	        }
	        for(Student s:students){
	        	List<ChosenCourse> cho = manageDao.loadsinglestuscore(s.getPassport());
	        	if(cho==null){
	        		continue;
	        	}
	        	chosencourse.addAll(cho);
	        }
	    }else if(user.getRoles().getRolerank()==4){
	    	List<SemesterChosenCourse> sem =manageDao.loadsemestercoursebyteacherid(user.getUsernum());
	        List<Classes> classlist = new ArrayList<Classes>();
	    	for(SemesterChosenCourse s:sem){
	        	for(String classid :s.getClass_().split("&")){
	        		if(classid!=null&&!classid.equals("")){
	        			classlist.add(studentDao.loadclassbyid(Integer.valueOf(classid)));
	        		}
	        	}
	        }
	    	for(int i = 0;i<classlist.size();i++){
	    		for (int j = classlist.size()-1; j>i; j--) {
					if(classlist.get(i).getId()==classlist.get(j).getId()){
						classlist.remove(j);
					}
				}
	    	}
	    	List<Student> students = new ArrayList<Student>();
	    	for (Classes c:classlist) {
				List<Student> stu = studentDao.loadstubyclassid(c.getId());
				students.addAll(stu);
			}
	    	for(Student s:students){
	        	List<ChosenCourse> cho = manageDao.loadsinglestuscore(s.getPassport());
	        	if(cho==null){
	        		continue;
	        	}
	        	chosencourse.addAll(cho);
	        }
	    	List<ChosenCourse> chCourses = new ArrayList<ChosenCourse>();
	    	for(int i=0;i<chosencourse.size();i++){
	    		for(int j=0;j<sem.size();j++){
	    			if(sem.get(j).getCoursenum().equals(String.valueOf(chosencourse.get(i).getCourseId()))){
	    				chCourses.add(chosencourse.get(i));
	    			}else {
						continue;
					}
	    		}
	    	}
	    	for(int i = 0;i<chCourses.size();i++){
	    		for (int j = chCourses.size()-1; j>i; j--) {
					if(chCourses.get(i).getCourseId()==chCourses.get(j).getCourseId()&&chCourses.get(i).getSemester()==chCourses.get(j).getSemester()){
						chCourses.remove(j);
					}
				}
	    	}
	    	chosencourse = chCourses;
	    }
		long total = chosencourse.size();
		List<ChosenCourseModel> coursemodels = new ArrayList<ChosenCourseModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
		 if (i < chosencourse.size()) {
			ChosenCourseModel model = new ChosenCourseModel();
			if (chosencourse.get(i).getAttendence() == null||chosencourse.get(i).getAttendence().length()==0) {// 考勤成绩
				model.setAttendence("");
			} else {
				if (Float.valueOf(chosencourse.get(i).getAttendence()) < 60) {
					String attendence = "<font color='red'>" + chosencourse.get(i).getAttendence() + "</font>";
					model.setAttendence(attendence);
				} else {
					model.setAttendence(String.valueOf(chosencourse.get(i).getAttendence()));
				}
			}
			if (chosencourse.get(i).getHomework() == null||chosencourse.get(i).getHomework().length()==0) {// 平时成绩
				model.setHomework("");
			} else {
				if (Float.valueOf(chosencourse.get(i).getHomework()) < 60) {
					String homework = "<font color='red'>" + chosencourse.get(i).getHomework() + "</font>";
					model.setHomework(homework);
				} else {
					model.setHomework(String.valueOf(chosencourse.get(i).getHomework()));
				}
			}
			if (chosencourse.get(i).getFinalexam() == null||chosencourse.get(i).getFinalexam().length()==0) {// 期末成绩
				model.setFinalexam("");
			} else {
				if (Float.valueOf(chosencourse.get(i).getFinalexam()) < 60) {
					String attendence = "<font color='red'>" + chosencourse.get(i).getFinalexam() + "</font>";
					model.setFinalexam(attendence);
				} else {
					model.setFinalexam(String.valueOf(chosencourse.get(i).getFinalexam()));
				}
			}
			if (chosencourse.get(i).getMidexam() == null||chosencourse.get(i).getMidexam().length()==0) {
				model.setMidexam("");
			} else {
				if (Float.valueOf(chosencourse.get(i).getMidexam()) < 60) {
					String attendence = "<font color='red'>" + chosencourse.get(i).getMidexam() + "</font>";
					model.setMidexam(attendence);
				} else {
					model.setMidexam(String.valueOf(chosencourse.get(i).getMidexam()));
				}
			}
			model.setNum(String.valueOf(chosencourse.get(i).getCourseId()));
			Student stu = studentDao.loadstubystuid(String.valueOf(chosencourse.get(i).getPassport()));
			model.setStuname(stu.getStuname());
			model.setPassport(stu.getPassport());
			model.setClassname(stu.getClasses().getClassname());
			model.setIsmakeup(chosencourse.get(i).getIsmakeup());
			if (chosencourse.get(i).getSummary()==0) {
				model.setSummary("");
			}else {
				if(chosencourse.get(i).getSummary()<60){
					String attendence = "<font color='red'>" + chosencourse.get(i).getSummary() + "</font>";
					model.setSummary(attendence);
				}else {
					model.setSummary(String.valueOf(chosencourse.get(i).getSummary()));
				}	 
			}
					
			if (chosencourse.get(i).getMakeup()!=null) {
				model.setMakeup(String.valueOf(chosencourse.get(i).getMakeup()));
			}
			Course course = studentDao.loadcoursebynum(String.valueOf(chosencourse.get(i).getCourseId()));
			model.setCoursename(course.getCoursename());
			String seme = chosencourse.get(i).getSemester();
			String semesters = "";
			if(seme.substring(4,6).equals("01")){
				semesters = seme.substring(0,4)+"-"+String.valueOf(Integer.valueOf(seme.substring(0,4))+1)+"学年第一学期";
			}else {
				semesters = String.valueOf(Integer.valueOf(seme.substring(0,4))-1)+"-"+seme.substring(0,4)+"学年第二学期";
			}
			model.setSemester(semesters);
			coursemodels.add(model);
		}
		}
		map.put("Total", total);
		map.put("Rows", coursemodels);
		return map;
	}
	List<ChosenCourse> chosencourse = new ArrayList<ChosenCourse>();
	@Override
	public void loadstuscore(String semester, Integer id, String passport,String coursenum){
		chosencourse.clear();
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<ChosenCourse> stucourse = new ArrayList<ChosenCourse>();
		if (id == null) {// 班级id
			List<ChosenCourse> stuCourse = manageDao.searchstuscore(semester, passport, coursenum);
			stucourse.addAll(stuCourse);
		} else {
			if (passport.length() == 0 || passport.equals("null")) {
				List<Student> students = studentDao.loadstubyclassid(id);
				for (int i = 0; i < students.size(); i++) {
					List<ChosenCourse> stuCourse = manageDao.searchstuscore(semester, students.get(i).getPassport(), coursenum);
					stucourse.addAll(stuCourse);
				}
			} else {
				List<ChosenCourse> stuCourse = manageDao.searchstuscore(semester, passport, coursenum);
				stucourse.addAll(stuCourse);
			}
		}
		if (user.getRoles().getRolerank() == 0 || user.getRoles().getRolerank() == 1) {
			chosencourse.addAll(stucourse);
		} else if (user.getRoles().getRolerank() == 4) {// 任课教师
			if (semester == null || semester.length() == 0) {
				semester = getCurrSemester();
				List<SemesterChosenCourse> sem = manageDao.loadattendencecourse(user.getUsernum(), semester);
				List<ClassesModel> classes = new ArrayList<ClassesModel>();
				for (SemesterChosenCourse course : sem) {
					if (course.getClass_() != null) {
						for (String classid : course.getClass_().split("&")) {
							if (id != null && !id.equals("")) {
								classes.add(manageDao.loadClassByID(classid));
							}
						}
					}
				}
				List<Student> students = new ArrayList<Student>();
				for (ClassesModel c : classes) {
					List<Student> stu = studentDao.loadstubyclassid(c.getId());
					students.addAll(stu);
				}
				for (int i = 0; i < students.size(); i++) {
					for (int j = 0; j < stucourse.size(); j++) {
						if (students.get(i).getPassport().equals(stucourse.get(j).getPassport())) {
							chosencourse.add(stucourse.get(j));
						} else {
							continue;
						}
					}
				}
				List<ChosenCourse> chCourses = new ArrayList<ChosenCourse>();
				for (int i = 0; i < chosencourse.size(); i++) {
					for (int j = 0; j < sem.size(); j++) {
						if (sem.get(j).getCoursenum().equals(String.valueOf(chosencourse.get(i).getCourseId()))) {
							chCourses.add(chosencourse.get(i));
						} else {
							continue;
						}
					}
				}
				for (int i = 0; i < chCourses.size(); i++) {
					for (int j = chCourses.size() - 1; j > i; j--) {
						if (chCourses.get(i).getPassport().equals(chCourses.get(j).getPassport())&&chCourses.get(i).getCourseId() == chCourses.get(j).getCourseId() && chCourses.get(i).getSemester().equals(chCourses.get(j).getSemester())) {
							chCourses.remove(j);
						}
					}
				}
				chosencourse = chCourses;
			} else {
				List<SemesterChosenCourse> sem = manageDao.loadattendencecourse(user.getUsernum(), semester);
				List<ClassesModel> classes = new ArrayList<ClassesModel>();
				for (SemesterChosenCourse course : sem) {
					if (course.getClass_() != null) {
						for (String classid : course.getClass_().split("&")) {
							if (classid != null && !classid.equals("")) {
								classes.add(manageDao.loadClassByID(classid));
							}
						}
					}
				}
				for (int i = 0; i < classes.size(); i++) {
					for (int j = classes.size() - 1; j > i; j--) {
						if (classes.get(i).getId().equals(classes.get(j).getId())) {
							// semestercourses.add(semestercourselist.get(i));
							classes.remove(classes.get(j));
						}
					}
				}
				List<Student> students = new ArrayList<Student>();
				for (ClassesModel c : classes) {
					List<Student> stu = studentDao.loadstubyclassid(c.getId());
					students.addAll(stu);
				}
				for (int i = 0; i < students.size(); i++) {
					for (int j = 0; j < stucourse.size(); j++) {
						if (students.get(i).getPassport().equals(stucourse.get(j).getPassport())) {
							chosencourse.add(stucourse.get(j));
						} else {
							continue;
						}
					}
				}
				List<ChosenCourse> chCourses = new ArrayList<ChosenCourse>();
				for (int i = 0; i < chosencourse.size(); i++) {
					for (int j = 0; j < sem.size(); j++) {
						if (sem.get(j).getCoursenum().equals(String.valueOf(chosencourse.get(i).getCourseId()))) {
							chCourses.add(chosencourse.get(i));
						} else {
							continue;
						}
					}
				}
				for (int i = 0; i < chCourses.size(); i++) {
					for (int j = chCourses.size() - 1; j > i; j--) {
						if (chCourses.get(i).getPassport().equals(chCourses.get(j).getPassport())&&chCourses.get(i).getCourseId() == chCourses.get(j).getCourseId() && chCourses.get(i).getSemester().equals(chCourses.get(j).getSemester())) {
							chCourses.remove(j);
						}
					}
				}
				chosencourse = chCourses;
			}
		} else if (user.getRoles().getRolerank() == 2) {// 班主任
			List<Classes> classlist = studentDao.loadclassbyteacher(user.getUsernum());
			if (semester == null || semester.length() == 0) {
				semester = getCurrSemester();
				List<SemesterChosenCourse> sem = manageDao.loadattendencecourse(user.getUsernum(), semester);
				List<ClassesModel> classes = new ArrayList<ClassesModel>();
				for (SemesterChosenCourse course : sem) {
					if (course.getClass_() != null) {
						for (String classid : course.getClass_().split("&")) {
							if (id != null && !id.equals("")) {
								classes.add(manageDao.loadClassByID(classid));
							}
						}
					}
				}
				for (int i = 0; i < classes.size(); i++) {
					for (int j = classes.size() - 1; j > i; j--) {
						if (classes.get(i).getClassname().equals(classes.get(j).getClassname())) {
							classes.remove(j);
						}
					}
				}
				List<Student> students = new ArrayList<Student>();
				List<Student> students2 = new ArrayList<Student>();
				for (ClassesModel c : classes) {
					List<Student> stu = studentDao.loadstubyclassid(c.getId());
					students2.addAll(stu);
				}
				for (Classes c : classlist) {
					List<Student> stu = studentDao.loadstubyclassid(c.getId());
					students.addAll(stu);
				}
				for (int i = 0; i < students2.size(); i++) {
					for (int j = 0; j < stucourse.size(); j++) {
						if (students2.get(i).getPassport().equals(stucourse.get(j).getPassport())) {
							chosencourse.add(stucourse.get(j));
						} else {
							continue;
						}
					}
				}
				List<ChosenCourse> chCourses = new ArrayList<ChosenCourse>();
				for (int i = 0; i < chosencourse.size(); i++) {
					for (int j = 0; j < sem.size(); j++) {
						if (sem.get(j).getCoursenum().equals(String.valueOf(chosencourse.get(i).getCourseId()))) {
							chCourses.add(chosencourse.get(i));
						} else {
							continue;
						}
					}
				}
				for (int i = 0; i < chCourses.size(); i++) {
					for (int j = chCourses.size() - 1; j > i; j--) {
						if (chCourses.get(i).getCourseId() == chCourses.get(j).getCourseId() && chCourses.get(i).getSemester().equals(chCourses.get(j).getSemester())) {
							chCourses.remove(j);
						}
					}
				}
				chosencourse = chCourses;
				for (int i = 0; i < students.size(); i++) {
					for (int j = students.size() - 1; j > i; j--) {
						if (students.get(i).getId() == students.get(j).getId()) {
							students.remove(j);
						}
					}
				}
				for (int i = 0; i < students.size(); i++) {
					for (int j = 0; j < stucourse.size(); j++) {
						if (students.get(i).getPassport().equals(stucourse.get(j).getPassport())) {
							chosencourse.add(stucourse.get(j));
						} else {
							continue;
						}
					}
				}
				for (int i = 0; i < chosencourse.size(); i++) {
					for (int j = chosencourse.size() - 1; j > i; j--) {
						if (chosencourse.get(i).getPassport().equals(chosencourse.get(j).getPassport())&&chosencourse.get(i).getCourseId() == chosencourse.get(j).getCourseId() && chosencourse.get(i).getSemester().equals(chosencourse.get(j).getSemester())) {
							chosencourse.remove(j);
						}
					}
				}

			} else {
				List<SemesterChosenCourse> sem = manageDao.loadattendencecourse(user.getUsernum(), semester);
				List<ClassesModel> classes = new ArrayList<ClassesModel>();
				for (SemesterChosenCourse course : sem) {
					if (course.getClass_() != null) {
						for (String classid : course.getClass_().split("&")) {
							if (id != null && !id.equals("")) {
								classes.add(manageDao.loadClassByID(classid));
							}
						}
					}
				}
				for (int i = 0; i < classes.size(); i++) {
 					for (int j = classes.size() - 1; j > i; j--) {
						if (classes.get(i).getClassname().equals(classes.get(j).getClassname())) {
							classes.remove(j);
						}
					}
				}
				List<Student> students = new ArrayList<Student>();
				List<Student> students2 = new ArrayList<Student>();
				for (ClassesModel c : classes) {
					List<Student> stu = studentDao.loadstubyclassid(c.getId());
					students2.addAll(stu);
				}
				for (Classes c : classlist) {
					List<Student> stu = studentDao.loadstubyclassid(c.getId());
					students.addAll(stu);
				}
				for (int i = 0; i < students2.size(); i++) {
					for (int j = 0; j < stucourse.size(); j++) {
						if (students2.get(i).getPassport().equals(stucourse.get(j).getPassport())) {
							chosencourse.add(stucourse.get(j));
						} else {
							continue;
						}
					}
				}
				List<ChosenCourse> chCourses = new ArrayList<ChosenCourse>();
				for (int i = 0; i < chosencourse.size(); i++) {
					for (int j = 0; j < sem.size(); j++) {
						if (sem.get(j).getCoursenum().equals(String.valueOf(chosencourse.get(i).getCourseId()))) {
							chCourses.add(chosencourse.get(i));
						} else {
							continue;
						}
					}
				}
				for (int i = 0; i < chCourses.size(); i++) {
					for (int j = chCourses.size() - 1; j > i; j--) {
						if (chCourses.get(i).getCourseId() == chCourses.get(j).getCourseId() && chCourses.get(i).getSemester() == chCourses.get(j).getSemester()) {
							chCourses.remove(j);
						}
					}
				}
				chosencourse = chCourses;
				for (int i = 0; i < students.size(); i++) {
					for (int j = students.size() - 1; j > i; j--) {
						if (students.get(i).getId() == students.get(j).getId()) {
							students.remove(j);
						}
					}
				}
				for (int i = 0; i < students.size(); i++) {
					for (int j = 0; j < stucourse.size(); j++) {
						if (students.get(i).getPassport().equals(stucourse.get(j).getPassport())) {
							chosencourse.add(stucourse.get(j));
						} else {
							continue;
						}
					}
				}
				for (int i = 0; i < chosencourse.size(); i++) {
					for (int j = chosencourse.size() - 1; j > i; j--) {
						if (chosencourse.get(i).getPassport().equals(chosencourse.get(j).getPassport())&&chosencourse.get(i).getCourseId() == chosencourse.get(j).getCourseId() && chosencourse.get(i).getSemester().equals(chosencourse.get(j).getSemester())) {
							chosencourse.remove(j);
						}
					}
				}
			}
		}

	}
	@Override
	public Map<String, Object> searchstuscorelist(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();		
		long total = chosencourse.size();
		List<ChosenCourseModel> coursemodels = new ArrayList<ChosenCourseModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			 if (i < chosencourse.size()) {
				ChosenCourseModel model = new ChosenCourseModel();
				if (chosencourse.get(i).getAttendence() == null||chosencourse.get(i).getAttendence().length()==0) {// 考勤成绩
					model.setAttendence("");
				} else {
					if (Float.valueOf(chosencourse.get(i).getAttendence()) < 60) {
						String attendence = "<font color='red'>" + chosencourse.get(i).getAttendence() + "</font>";
						model.setAttendence(attendence);
					} else {
						model.setAttendence(String.valueOf(chosencourse.get(i).getAttendence()));
					}
				}
				if (chosencourse.get(i).getHomework() == null||chosencourse.get(i).getHomework().length()==0) {// 平时成绩
					model.setHomework("");
				} else {
					if (Float.valueOf(chosencourse.get(i).getHomework()) < 60) {
						String homework = "<font color='red'>" + chosencourse.get(i).getHomework() + "</font>";
						model.setHomework(homework);
					} else {
						model.setHomework(String.valueOf(chosencourse.get(i).getHomework()));
					}
				}
				if (chosencourse.get(i).getFinalexam() == null||chosencourse.get(i).getFinalexam().length()==0) {// 期末成绩
					model.setFinalexam("");
				} else {
					if (Float.valueOf(chosencourse.get(i).getFinalexam()) < 60) {
						String attendence = "<font color='red'>" + chosencourse.get(i).getFinalexam() + "</font>";
						model.setFinalexam(attendence);
					} else {
						model.setFinalexam(String.valueOf(chosencourse.get(i).getFinalexam()));
					}
				}
				if (chosencourse.get(i).getMidexam() == null||chosencourse.get(i).getMidexam().length()==0) {
					model.setMidexam("");
				} else {
					if (Float.valueOf(chosencourse.get(i).getMidexam()) < 60) {
						String attendence = "<font color='red'>" + chosencourse.get(i).getMidexam() + "</font>";
						model.setMidexam(attendence);
					} else {
						model.setMidexam(String.valueOf(chosencourse.get(i).getMidexam()));
					}
				}
				model.setIsmakeup(chosencourse.get(i).getIsmakeup());
				if (chosencourse.get(i).getMakeup()!=null) {
					model.setMakeup(String.valueOf(chosencourse.get(i).getMakeup()));
				}
				if (chosencourse.get(i).getSummary()==0) {
				   model.setSummary("");	
				}else {
					if(chosencourse.get(i).getSummary()<60){
						String summary = "<font color='red' >"+chosencourse.get(i).getSummary()+"</font>";
						model.setSummary(summary);
					}else {
						model.setSummary(String.valueOf(chosencourse.get(i).getSummary()));
					}
				}
				
				model.setNum(String.valueOf(chosencourse.get(i).getCourseId()));
				Student stu = studentDao.loadstubystuid(String.valueOf(chosencourse.get(i).getPassport()));
				model.setStuname(stu.getStuname());
				model.setPassport(stu.getPassport());
				model.setClassname(stu.getClasses().getClassname());
				Course course = manageDao.loadCourseByIdent(String.valueOf(chosencourse.get(i).getCourseId()));
				model.setCoursename(course.getCoursename());
				String seme = chosencourse.get(i).getSemester();
				String semesters = "";
				if(seme.substring(4,6).equals("01")){
					semesters = seme.substring(0,4)+"-"+String.valueOf(Integer.valueOf(seme.substring(0,4))+1)+"学年第一学期";
				}else {
					semesters = String.valueOf(Integer.valueOf(seme.substring(0,4))-1)+"-"+seme.substring(0,4)+"学年第二学期";
				}
				model.setSemester(semesters);
				coursemodels.add(model);
			}
		}
		map.put("Total", total);
		map.put("Rows", coursemodels);
		return map;
	}

	@Override
	public boolean stucheck(String stuid) {
		// TODO Auto-generated method stub
		List<Student> haveteacher = studentDao.stucheckstuid(stuid);
		if (haveteacher.size() > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void courseclassscoreadd(ChosenCourse chosenCourse) {
		// TODO Auto-generated method stub
		ChosenCourse chosenCourse2 = manageDao.loadchosencoursebycourse(chosenCourse.getCourseId(), chosenCourse.getPassport(),chosenCourse.getSemester());
		chosenCourse.setId(chosenCourse2.getId());
		//chosenCourse.setIsmakeup(0);
		/*float attendence = 0;
		float homework = 0;
		float midexam = 0;
		float finalexam = 0;
		String realpath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/ScoreSet");
		File file = new File(realpath + "/" + chosenCourse.getSemester() + chosenCourse.getCourseId() + "scoreset.dat");
		if (file.exists()) {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(realpath + "/" + chosenCourse.getSemester() + chosenCourse.getCourseId() + "scoreset.dat"));
				List<String> lists = (ArrayList<String>) in.readObject();
				attendence = Float.valueOf(lists.get(0));
				homework = Float.valueOf(lists.get(1));
				midexam = Float.valueOf(lists.get(2));
				finalexam = Float.valueOf(lists.get(3));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		float attendence = 10;
		float homework = 20;
		float midexam = 30;
		float finalexam = 40;
		float summary = Float.valueOf(chosenCourse.getAttendence()) * attendence / 100 + Float.valueOf(chosenCourse.getHomework()) * homework / 100 + midexam / 100 *Float.valueOf( chosenCourse.getMidexam()) + Float.valueOf(chosenCourse.getFinalexam()) * finalexam / 100;
		chosenCourse.setSummary(summary);
		/*if(summary>=60){
			chosenCourse.setIsmakeup(0);
		}else {
			chosenCourse.setIsmakeup(1);
		}*/
		chosenCourse.setIsmakeup(0);
		manageDao.courseclassscoreadd(chosenCourse);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void semestercoursescoreadd(List<ChosenCourseModel> listUpdated, User user) {
		for(ChosenCourseModel s:listUpdated){
			ChosenCourse chosenCourse2 = manageDao.loadchosencoursebycourse(s.getNum(), s.getPassport(),s.getSemester());
			/*float attendence = 0;//读取文件设置的分数比例
			float homework = 0;
			float midexam = 0;
			float finalexam = 0;
			String realpath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/ScoreSet");
			File file = new File(realpath + "/" + chosenCourse2.getSemester() + s.getNum() + "scoreset.dat");
			if (file.exists()) {
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(realpath + "/" + chosenCourse2.getSemester() + s.getNum() + "scoreset.dat"));
					List<String> lists = (ArrayList<String>) in.readObject();
					attendence = Float.valueOf(lists.get(0));
					homework = Float.valueOf(lists.get(1));
					midexam = Float.valueOf(lists.get(2));
					finalexam = Float.valueOf(lists.get(3));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
			float attendence = 10;
			float homework = 20;
			float midexam = 30;
			float finalexam = 40;
			if (Float.valueOf(s.getAttendence())>100||Float.valueOf(s.getAttendence())<0||Float.valueOf(s.getHomework())>100||Float.valueOf(s.getHomework())<0||Float.valueOf(s.getMidexam())>100||Float.valueOf(s.getMidexam())<0||Float.valueOf(s.getFinalexam())>100||Float.valueOf(s.getFinalexam())<0) {
				continue;
			}
			if(s.getIsmakeup()==1){
				continue;
			}
			float summary = Float.valueOf(s.getAttendence()) * attendence / 100 + Float.valueOf(s.getHomework()) * homework / 100 + midexam / 100 *Float.valueOf( s.getMidexam()) + Float.valueOf(s.getFinalexam()) * finalexam / 100;
			chosenCourse2.setAttendence(s.getAttendence());
			chosenCourse2.setFinalexam(s.getFinalexam());
			chosenCourse2.setHomework(s.getHomework());
			chosenCourse2.setMidexam(s.getMidexam());
			chosenCourse2.setSummary(summary);
			/*if(summary>=60){
				chosenCourse.setIsmakeup(0);
			}else {
				chosenCourse.setIsmakeup(1);
			}*/
			s.setIsmakeup(0);
			manageDao.courseclassscoreadd(chosenCourse2);
			String oldScore = String.format("S:%sC:%sH:%sA:%sM:%sF:%s",
					chosenCourse2.getPassport(), chosenCourse2.getCourseId(),chosenCourse2.getHomework(), 
					chosenCourse2.getAttendence(), chosenCourse2.getMidexam(), chosenCourse2.getFinalexam());
			ModifyLog (user, "modifyScore", oldScore);
			
		}
	}
	
	@Override
	public List<ChosenCourseModel> getOtherOptionByCourseNum(String semesterChosenCourseID,
			String semester) {
		SemesterChosenCourse course = manageDao.loadSemesterChosenCourseById(semesterChosenCourseID);
		return getOtherOption(toModel(course, semester), semester);
	}

	@Override
	public void saveAdjustRecord (Syllabus p, Syllabus q, String reason, String semester) {
		Adjustcourse ret = new Adjustcourse();
		ret.setApplyteacher(p.getTeacherName());
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
		ret.setApplytime(dt1.format(new Date()));
		
		// 原教室可以用课程号与上课时间 大节确定
		
		ret.setOldcoursenum(p.getNum());
		ret.setOlddate(p.getNote());
		ret.setOldslot(String.valueOf(p.getSlot()));
		ret.setOldRoomNum(p.getRoomNum());
		List<Classroom> r1 = studentDao.roomcheck(Integer.valueOf(p.getRoomNum()));
		if (r1 != null && r1.size() > 0){
			ret.setOldRoomAddress(r1.get(0).getRoomplace() + r1.get(0).getRoomname());
		}
		
		ret.setReason(reason);
		ret.setSemester(semester);
		ret.setStatus("0");
		
		ret.setNewcoursenum(q.getNum());
		ret.setNewdate(q.getNote());
		ret.setNewslot(String.valueOf(q.getSlot()));
		ret.setNewRoomNum(q.getRoomNum());
		List<Classroom> r2 = studentDao.roomcheck(Integer.valueOf(q.getRoomNum()));
		if (r2 != null && r2.size() > 0){
			ret.setNewRoomAddress(r2.get(0).getRoomplace() + r2.get(0).getRoomname());
		}
		
		manageDao.saveAdjust(ret);
		
	}

	@Override
	public List<AdjustcourseModel> loadAdjustRocords(String semester) {
		List<Adjustcourse> all = manageDao.adjustRecord(semester);
		for(int i=0;i<all.size()-1;i++){
			for(int j=0;j<all.size()-i-1;j++){
				if(Integer.valueOf(all.get(j).getStatus())>Integer.valueOf(all.get(j+1).getStatus())){
					Adjustcourse temp = null;
					temp = all.get(j);
					all.set(j, all.get(j+1));
					all.set(j+1, temp);
				}
			}
		}
		List<AdjustcourseModel> ret = new ArrayList<AdjustcourseModel>();
		for (Adjustcourse i : all) {
			AdjustcourseModel k = new AdjustcourseModel();
			
			k.setApplytime(i.getApplytime());
			k.setId(i.getId());
			Teacher t = manageDao.loadteacherbyidentificationnum(i.getApplyteacher());
			k.setApplyTeacher(t);
			Course q = new Course();
			if (i.getNewcoursenum()!= null&&i.getNewcoursenum().length()!=0){
        	   q = manageDao.getCourseByNum(i.getNewcoursenum());
        	   k.setNewCourseName(q.getCoursename());
   			   k.setNewcoursenum(i.getNewcoursenum());
   			   SemesterChosenCourse semesterChosenCourse = manageDao.loadselectcoursebycourseid(i.getNewcoursenum(), semester);
   			   Teacher newTeacher = manageDao.loadteacherbyid(Integer.valueOf(semesterChosenCourse.getTeacherid()));
   			   k.setNewTeacher(newTeacher);
           }																		
			k.setNewslot(i.getNewslot());
			k.setNewdate(i.getNewdate());
			k.setOldroomName(i.getOldRoomAddress());
			
			k.setOldcoursenum(i.getOldcoursenum());
			k.setOlddate(i.getOlddate());
			k.setOldslot(i.getOldslot());
			k.setNewroomName(i.getNewRoomAddress());
			k.setReason(i.getReason());
			k.setStatus(i.getStatus());
			Course p = manageDao.getCourseByNum(i.getOldcoursenum());
			
			if (p != null) {
				k.setOldCourseName(p.getCoursename());
			}
			ret.add(k);
		}
		
		return ret;
	}

	@Override
	public List<ChosenCourseModel> loadSemesterChosenCoruseByTeacher(
			String ident, String semester) {
		List<ChosenCourseModel> ret = new ArrayList<ChosenCourseModel>();
		for (SemesterChosenCourse i : manageDao.getChosenCourseByTeacherId(ident, semester)) {
			ret.add(toModel(i, semester));
		}
		return ret;
	}
	@Override
	public void courseclassmakeupscoreadd(ChosenCourse chosenCourse) {
		// TODO Auto-generated method stub
		ChosenCourse chosenCourse2 = manageDao.loadchosencoursebycourse(chosenCourse.getCourseId(),chosenCourse.getPassport(),chosenCourse.getSemester());
		chosenCourse.setId(chosenCourse2.getId());
		chosenCourse.setAttendence(chosenCourse2.getAttendence());
		chosenCourse.setFinalexam(chosenCourse2.getFinalexam());
		chosenCourse.setHomework(chosenCourse2.getHomework());
		chosenCourse.setMidexam(chosenCourse2.getMidexam());
		chosenCourse.setIsmakeup(1);
		manageDao.courseclassscoreadd(chosenCourse);
	}
	@Override
	public Map<String, Object> singlestuscorelist(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();		
		User user = (User)ActionContext.getContext().getSession().get("user");
		if (user.getRoles().getRolerank()==3) {
			List<ChosenCourse> stuchosencourses = manageDao.loadsinglestuscore(user.getUsernum());
			List<Evalution> evalutions = manageDao.loadstuevalution(user.getUsernum());
			List<ChosenCourse> stuchosencourse =new ArrayList<ChosenCourse>();
			for(ChosenCourse c:stuchosencourses){
				for(Evalution e:evalutions){
					if (c.getSemester().equals(e.getSemester())&&c.getPassport().equals(e.getPassport())) {
						stuchosencourse.add(c);
					}
				}
			}
			long total = stuchosencourse.size();
			List<ChosenCourseModel> coursemodels = new ArrayList<ChosenCourseModel>();
			for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			 if (i < stuchosencourse.size()) {
				ChosenCourseModel model = new ChosenCourseModel();
					if (stuchosencourse.get(i).getAttendence() == null||stuchosencourse.get(i).getAttendence().length()==0) {// 考勤成绩
						model.setAttendence("");
					} else {
						if (Float.valueOf(stuchosencourse.get(i).getAttendence()) < 60) {
							String attendence = "<font color='red'>" + stuchosencourse.get(i).getAttendence() + "</font>";
							model.setAttendence(attendence);
						} else {
							model.setAttendence(String.valueOf(stuchosencourse.get(i).getAttendence()));
						}
					}
					if (stuchosencourse.get(i).getHomework() == null||stuchosencourse.get(i).getHomework().length()==0) {// 平时成绩
						model.setHomework("");
					} else {
						if (Float.valueOf(stuchosencourse.get(i).getHomework()) < 60) {
							String homework = "<font color='red'>" + stuchosencourse.get(i).getHomework() + "</font>";
							model.setHomework(homework);
						} else {
							model.setHomework(String.valueOf(stuchosencourse.get(i).getHomework()));
						}
					}
					if (stuchosencourse.get(i).getFinalexam() == null||stuchosencourse.get(i).getFinalexam().length()==0) {// 期末成绩
						model.setFinalexam("");
					} else {
						if (Float.valueOf(stuchosencourse.get(i).getFinalexam()) < 60) {
							String attendence = "<font color='red'>" + stuchosencourse.get(i).getFinalexam() + "</font>";
							model.setFinalexam(attendence);
						} else {
							model.setFinalexam(String.valueOf(stuchosencourse.get(i).getFinalexam()));
						}
					}
				if(stuchosencourse.get(i).getMidexam()==null||stuchosencourse.get(i).getMidexam().length()==0){
					model.setMidexam("");
				}else {
					if(Float.valueOf(stuchosencourse.get(i).getMidexam())<60){
						String attendence = "<font color='red'>"+stuchosencourse.get(i).getMidexam()+"</font>";
						model.setMidexam(attendence);
					}else {
						model.setMidexam(String.valueOf(stuchosencourse.get(i).getMidexam()));
					}
				}				
				model.setIsmakeup(stuchosencourse.get(i).getIsmakeup());
				if (stuchosencourse.get(i).getMakeup()!=null) {
					model.setMakeup(String.valueOf(stuchosencourse.get(i).getMakeup()));
				}				
				model.setNum(String.valueOf(stuchosencourse.get(i).getCourseId()));
				Student stu = studentDao.loadstubystuid(String.valueOf(stuchosencourse.get(i).getPassport()));
				model.setStuname(stu.getStuname());
				model.setPassport(stu.getPassport());
				if (stuchosencourse.get(i).getSummary()==0) {
					model.setSummary("");
				}else {
					if (stuchosencourse.get(i).getSummary()<60) {
						String summary = "<font color='red' >"+stuchosencourse.get(i).getSummary()+"</font>";
					    model.setSummary(summary);
					}else {
						model.setSummary(String.valueOf(stuchosencourse.get(i).getSummary()));
					}
				}				
				Course course = manageDao.loadCourseByIdent(String.valueOf(stuchosencourse.get(i).getCourseId()));
				model.setCoursename(course.getCoursename());
				String seme = stuchosencourse.get(i).getSemester();
				String semesters = "";
				if(seme.substring(4,6).equals("01")){
					semesters = seme.substring(0,4)+"-"+String.valueOf(Integer.valueOf(seme.substring(0,4))+1)+"学年第一学期";
				}else {
					semesters = String.valueOf(Integer.valueOf(seme.substring(0,4))-1)+"-"+seme.substring(0,4)+"学年第二学期";
				}
				model.setSemester(semesters);
				coursemodels.add(model);
			}
			}
			map.put("Total", total);
			map.put("Rows", coursemodels);
		}
			return map;
		}


    List<ChosenCourse> stuchosencourse = new ArrayList<ChosenCourse>();
	@Override
	public void loadsinglestuscore(String semester,String coursenum) {
		// TODO Auto-generated method stub
		stuchosencourse.clear();
		User user = (User)ActionContext.getContext().getSession().get("user");
		stuchosencourse = manageDao.searchstuscore(semester, user.getUsernum(),coursenum);
	}

	@Override
	public Map<String, Object> searchsinglestuscorelist(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();		
		long total = stuchosencourse.size();
		List<ChosenCourseModel> coursemodels = new ArrayList<ChosenCourseModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < stuchosencourse.size()) {
				ChosenCourseModel model = new ChosenCourseModel();
				if (stuchosencourse.get(i).getAttendence() == null||stuchosencourse.get(i).getAttendence().length()==0) {// 考勤成绩
					model.setAttendence("");
				} else {
					if (Float.valueOf(stuchosencourse.get(i).getAttendence()) < 60) {
						String attendence = "<font color='red'>" + stuchosencourse.get(i).getAttendence() + "</font>";
						model.setAttendence(attendence);
					} else {
						model.setAttendence(String.valueOf(stuchosencourse.get(i).getAttendence()));
					}
				}
				if (stuchosencourse.get(i).getHomework() == null||stuchosencourse.get(i).getHomework().length()==0) {// 平时成绩
					model.setHomework("");
				} else {
					if (Float.valueOf(stuchosencourse.get(i).getHomework()) < 60) {
						String homework = "<font color='red'>" + stuchosencourse.get(i).getHomework() + "</font>";
						model.setHomework(homework);
					} else {
						model.setHomework(String.valueOf(stuchosencourse.get(i).getHomework()));
					}
				}
				if (stuchosencourse.get(i).getFinalexam() == null||stuchosencourse.get(i).getFinalexam().length()==0) {// 期末成绩
					model.setFinalexam("");
				} else {
					if (Float.valueOf(stuchosencourse.get(i).getFinalexam()) < 60) {
						String attendence = "<font color='red'>" + stuchosencourse.get(i).getFinalexam() + "</font>";
						model.setFinalexam(attendence);
					} else {
						model.setFinalexam(String.valueOf(stuchosencourse.get(i).getFinalexam()));
					}
				}
			if(stuchosencourse.get(i).getMidexam()==null||stuchosencourse.get(i).getMidexam().length()==0){
				model.setMidexam("");
			}else {
				if(Float.valueOf(stuchosencourse.get(i).getMidexam())<60){
					String attendence = "<font color='red'>"+stuchosencourse.get(i).getMidexam()+"</font>";
					model.setMidexam(attendence);
				}else {
					model.setMidexam(String.valueOf(stuchosencourse.get(i).getMidexam()));
				}
			}		
				model.setIsmakeup(stuchosencourse.get(i).getIsmakeup());
				if (stuchosencourse.get(i).getMakeup()!=null) {
					model.setMakeup(String.valueOf(stuchosencourse.get(i).getMakeup()));
				}
				model.setNum(String.valueOf(stuchosencourse.get(i).getCourseId()));
				Student stu = studentDao.loadstubystuid(String.valueOf(stuchosencourse.get(i).getPassport()));
				model.setStuname(stu.getStuname());
				model.setPassport(stu.getPassport());
				Course course = manageDao.loadCourseByIdent(String.valueOf(stuchosencourse.get(i).getCourseId()));
				model.setCoursename(course.getCoursename());
				String seme = stuchosencourse.get(i).getSemester();
				String semesters = "";
				if(seme.substring(4,6).equals("01")){
					semesters = seme.substring(0,4)+"-"+String.valueOf(Integer.valueOf(seme.substring(0,4))+1)+"学年第一学期";
				}else {
					semesters = String.valueOf(Integer.valueOf(seme.substring(0,4))-1)+"-"+seme.substring(0,4)+"学年第二学期";
				}
				model.setSemester(semesters);
				coursemodels.add(model);
			}
			}
			map.put("Total", total);
			map.put("Rows", coursemodels);
			return map;
	}

	@Override
	public List<ChosenCourseModel> transcriptsearch(String semester, String passport) {
		// TODO Auto-generated method stub
		List<ChosenCourse> chocourse = manageDao.loadstuscore(semester, passport);
		List<ChosenCourseModel> chosencourse1 = new ArrayList<ChosenCourseModel>();
		for(ChosenCourse c:chocourse){
			ChosenCourseModel model = new ChosenCourseModel();
			model.setAttendence(c.getAttendence());
			model.setHomework(c.getHomework());
			model.setMakeup(String.valueOf(c.getMakeup()));
			model.setMidexam(c.getMidexam());
			model.setFinalexam(c.getFinalexam());
			model.setIsmakeup(c.getIsmakeup());
			if (c.getSummary()==0) {
				model.setSummary("");
			}else {
				model.setSummary(String.valueOf(c.getSummary()));
			}			
			model.setPassport(c.getPassport());
			model.setCourseid(c.getCourseId());
			model.setSemester(c.getSemester());
			chosencourse1.add(model);
		}
		chosencourse1 = semesterchange(chosencourse1);
		return chosencourse1;
	}
	private List<ChosenCourseModel> semesterchange(List<ChosenCourseModel> choCourses){
		for(ChosenCourseModel c:choCourses){
			if (Integer.valueOf(c.getSemester())%2==0) {
				String semester = c.getSemester().substring(0,4)+"01";
				c.setSemester(semester);
			}else {
				String semester = c.getSemester().substring(0,4)+"02";
				c.setSemester(semester);
			}
		}
		return choCourses;
	}

	private AdjustcourseModel adjustToModel(Adjustcourse ad, String semester) {
		AdjustcourseModel ret = new AdjustcourseModel();
		ret.setId(ad.getId());
		ret.setOldcoursenum(ad.getOldcoursenum());
		//Course oc = manageDao.getCourseByNum(ad.getOldcoursenum());
		Course oc = manageDao.loadCourseByIdent2(ad.getOldcoursenum());
		if (oc != null)
			ret.setOldCourseName(oc.getCoursename());
		ret.setReason(ad.getReason());
		ret.setOlddate(ad.getOlddate());
		ret.setOldslot(ad.getOldslot());
		ret.setApplytime(ad.getApplytime());
		Integer ident = 0;
		try{
			ident = Integer.parseInt(ad.getApplyteacher());
		} catch (NumberFormatException e) {
			return null;
		}
		Teacher t = manageDao.loadteacherbyid(ident);
		if (t != null)
			ret.setApplyTeacher(t);
		ret.setNewroomName(ad.getNewRoomAddress());
		ret.setNewcoursenum(ad.getNewcoursenum());
		//Course nc = manageDao.getCourseByNum(ad.getNewcoursenum());
		Course nc = manageDao.loadCourseByIdent2(ad.getNewcoursenum());
		if (nc != null)
			ret.setNewCourseName(nc.getCoursename());
		ret.setNewdate(ad.getNewdate());
		ret.setNewslot(ad.getNewslot());
		ret.setStatus(ad.getStatus());
		return ret;
	}
	
	@Override
	public List<AdjustcourseModel> loadRelateAdjustCourse(String teacehrIdent,
			String semester) {
		// 找出该老师所有课程
		List<SemesterChosenCourse> thisSemester =  manageDao.getChosenCourseByTeacherId(teacehrIdent, semester);
		
		Set<String> unique = new HashSet<String>();
		
		// 遍历找调课课号
		List<AdjustcourseModel> ret = new ArrayList<AdjustcourseModel>();
		//Set<AdjustcourseModel> ret = new HashSet<AdjustcourseModel>();
		for (SemesterChosenCourse i : thisSemester) {
			List<Adjustcourse> t = manageDao.loadAjustCourseByRelateCourseNum(i.getCoursenum(), semester);
			if (t != null && t.size() > 0) {
				for (Adjustcourse p : t) {
					if (p.getStatus().equals("1")){
						AdjustcourseModel ad = adjustToModel(p, semester);
						if (ad != null && !unique.contains(ad.getNewCourseName() + ad.getOldCourseName())) {
							ret.add(ad);
							unique.add(ad.getNewCourseName() + ad.getOldCourseName());
						}
					}
				}
			}
		}
		
		for (AdjustcourseModel i : ret) {
			if (i.getOldCourseName() == null)
				i.setOldCourseName(" ");
			if (i.getNewCourseName() == null)
				i.setNewCourseName(" ");
		}
		
		return ret;
	}

	@Override
	public boolean isclassteacher(String identificationnum) {
		// TODO Auto-generated method stub
		List<Classes> cls = studentDao.loadclassbyteacher(identificationnum);
		if (cls.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public void sire(String semester) {
		
		manageDao.sireSemesterChosenCourse(semester);
	}

	@Override
	public Map<String, List<String>> arrangePreChk(String semester) {
		//TODO
		// 找出本学期所有课
		List<SemesterChosenCourse> all = manageDao.semesterCourseList(semester);
		//fake ret
		Map<String, List<String>> ret = new HashMap<String, List<String>>();
		String roomtype = "no roomType";
		String lesson = "no lesson";
		String teacher = "no teacher";
		String classes = "no class";
		String elective = "no stunum";
		
		ret.put(roomtype, new ArrayList<String>());
		ret.put(lesson, new ArrayList<String>());
		ret.put(teacher, new ArrayList<String>());
		ret.put(classes, new ArrayList<String>());
		ret.put(elective, new ArrayList<String>());
		
		
		// 是否检查任选课修改这里
		for (SemesterChosenCourse i : all){
			if (i.getRoomtype() == null){
				ret.get(roomtype).add(i.getCoursenum());
			}
			if (i.getWeeklesson() == null || i.getLessonCount() == null){
				ret.get(lesson).add(i.getCoursenum());
			}
			if (i.getTeacherid() == null){
				ret.get(teacher).add(i.getCoursenum());
			}
			if (i.getClass_() == null){
				ret.get(classes).add(i.getCoursenum());
			}
			if (i.getIsElective() == 2) {
				if (i.getStuNum() == null || i.getStuNum() == 0) {
					ret.get(elective).add(i.getCoursenum());
				}
			}
			
		}
		
		Map<String, List<String>> fin = new HashMap<String, List<String>>();
		fin.put(roomtype, new ArrayList<String>());
		fin.put(lesson, new ArrayList<String>());
		fin.put(teacher, new ArrayList<String>());
		fin.put(classes, new ArrayList<String>());
		fin.put(elective, new ArrayList<String>());
		
//		getCourseByNum
		
		for (String i : ret.get(roomtype)) {
			Course c = manageDao.getCourseByNum(i);
			if (c != null && c.getCoursename() != null){
				fin.get(roomtype).add(c.getCoursename());
			}
		}
		
		for (String i : ret.get(lesson)) {
			Course c = manageDao.getCourseByNum(i);
			if (c != null && c.getCoursename() != null){
				fin.get(lesson).add(c.getCoursename());
			}
		}
		
		for (String i : ret.get(teacher)) {
			Course c = manageDao.getCourseByNum(i);
			if (c != null && c.getCoursename() != null){
				fin.get(teacher).add(c.getCoursename());
			}
		}
		
		for (String i : ret.get(classes)) {
			Course c = manageDao.getCourseByNum(i);
			if (c != null && c.getCoursename() != null){
				fin.get(classes).add(c.getCoursename());
			}
		}
		
		for (String i : ret.get(elective)) {
			Course c = manageDao.getCourseByNum(i);
			if (c != null && c.getCoursename() != null){
				fin.get(elective).add(c.getCoursename());
			}
		}
		
		return fin;
	}
	List<ChosenCourse> selectchosencourse = new ArrayList<ChosenCourse>();
	@Override
	public List<ChosenCourse> loadselectcoursestu(String num, String semester) {
		// TODO Auto-generated method stub
		selectchosencourse.clear();
		selectchosencourse = manageDao.loadselectcoursestu(num,semester);
		return selectchosencourse;
	}
	@Override
	public Map<String, Object> selectresultlist(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		User user =(User)ActionContext.getContext().getSession().get("user");
		/*if(user.getRoles().getRolerank()==2){
			List<Classes> classlist = studentDao.loadclassbyteacher(user.getUsernum());
			List<Student> students = new ArrayList<Student>();
			for(Classes c:classlist){
				List<Student> stu = studentDao.loadstubyclassid(c.getId());
				students.addAll(stu);
			}
			List<ChosenCourse> cho = selectchosencourse;
			for(int i=0;i<cho.size();i++){
				for(Student s:students){
					if(s.getStuid().equals(cho.get(i).getStuId())){
						cho.remove(i);
					}
				}
			}
			selectchosencourse.removeAll(cho);
		}*/
		long total = selectchosencourse.size();
		List<StudentModel> stumodels = new ArrayList<StudentModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < selectchosencourse.size()) {
				StudentModel model = new StudentModel();
				Student s = studentDao.loadstubystuid(String.valueOf(selectchosencourse.get(i).getPassport()));
				try {
					model.setClassid(s.getClasses().getId());
				} catch (Exception e) {
					model.setClassid(0);
				}
				model.setId(s.getId());
				model.setPassword(s.getPassword());
				model.setStusex(s.getSex());
				model.setStuid(s.getStuid());
				model.setStuname(s.getStuname());
				model.setFirstname(s.getFirstname());
				model.setLastname(s.getLastname());
				model.setNation(s.getNation());
				model.setPassport(s.getPassport());
				model.setRoomplace(s.getRoomplace());
				model.setTelephone(s.getTelephone());
				model.setStudentType(s.getStudentType());
				model.setSource(s.getSource());
				model.setEnddate(s.getEnddate());
				model.setStartdate(s.getStartdate());
				model.setStatus(s.getStatus());
				stumodels.add(model);
			}
		}
		map.put("Total", total);
		map.put("Rows", stumodels);
		return map;
	}

	@Override
	public List<Classroom> classroomList() {
		return manageDao.classroomList();
	}

	@Override
	public List<SemesterChosenCourse> courseListByWeekday(String weekday,
			String semester) {
		return manageDao.courseListByWeekday(weekday, semester);
	}
	
	public List<Adjustcourse> approvedAdjustApplyListByWeekday (String weekday, String semester) {
		return manageDao.approvedAdjustApplyListByWeekday(weekday, semester);
	}
	
	public List<Adjustcourse> ApplyingAdjustByWeekday(String weekday, String semester){
		return manageDao.AppyingAdjustByWeekday(weekday, semester);
	}

	@Override
	public List<AdjustcourseModel> loadAdjustReocrdsByTeacher(String ident,
			String semester) {
		List<Adjustcourse> all = manageDao.adjustRecord(semester);
		List<AdjustcourseModel> ret = new ArrayList<AdjustcourseModel>();
		for (Adjustcourse i : all) {
			if (!i.getApplyteacher().equals(ident)){
				continue;
			}
			AdjustcourseModel k = new AdjustcourseModel();
			
			k.setApplytime(i.getApplytime());
			k.setId(i.getId());
			Teacher t = manageDao.loadteacherbyidentificationnum(i.getApplyteacher());
			k.setApplyTeacher(t);
			
			Course q = manageDao.getCourseByNum(i.getNewcoursenum());
			if (q != null)
				k.setNewCourseName(q.getCoursename());
			k.setNewcoursenum(i.getNewcoursenum());
			k.setNewslot(i.getNewslot());
			k.setNewdate(i.getNewdate());
			k.setOldroomName(i.getOldRoomAddress());
			
			k.setOldcoursenum(i.getOldcoursenum());
			k.setOlddate(i.getOlddate());
			k.setOldslot(i.getOldslot());
			k.setNewroomName(i.getNewRoomAddress());
			k.setReason(i.getReason());
			k.setStatus(i.getStatus());
			Course p = manageDao.getCourseByNum(i.getOldcoursenum());
			
			if (p != null) {
				k.setOldCourseName(p.getCoursename());
			}
			ret.add(k);
		}
		
		return ret;
	}

	@Override
	public void recoverTeacher(String id) {
		manageDao.recoverTeacher(id);
		
	}

	@Override
	public List<Teacher> loadAllAvlTeacher() {
		return studentDao.loadAllAvlTeacher();
	}


	@Override
	public void coursesummarydone(ChosenCourse chosenCourse, String semester, String coursenum, String classid) {
		// TODO Auto-generated method stub
		List<Student> studentlist = studentDao.loadstubyclassid(Integer.valueOf(classid));
		float attendence = Float.valueOf(chosenCourse.getAttendence());
		float homework = Float.valueOf(chosenCourse.getHomework());
		float midexam = Float.valueOf(chosenCourse.getMidexam());
		float finalexam = Float.valueOf(chosenCourse.getFinalexam());
		List<ChosenCourse> chosencourselist = new ArrayList<ChosenCourse>();
		for(Student s:studentlist){
			List<ChosenCourse> chosencourse = manageDao.searchstuscore(semester, s.getStuid(), coursenum);
		    chosencourselist.addAll(chosencourse);
		}
	    for(ChosenCourse c:chosencourselist){
	    	float summary = Float.valueOf(c.getAttendence())*attendence/100+
	    			Float.valueOf(c.getHomework())*homework/100+midexam/100*Float.valueOf(c.getMidexam())+
	    			Float.valueOf(c.getFinalexam())*finalexam/100;
	    	c.setSummary(summary);
	    	manageDao.courseclassscoreadd(c);
	    }
	}

	@Override
	public List<Course> loadcourselist() {
		// TODO Auto-generated method stub
		User user = (User)ActionContext.getContext().getSession().get("user");
		List<Course> courseList = new ArrayList<Course>();
		if(user.getRoles().getRolerank()==0||user.getRoles().getRolerank()==1){
			String semester = getCurrSemester();
			List<SemesterChosenCourse> sem = manageDao.semesterCourseList(semester);  
			for (int i = 0; i < sem.size(); i++) {
				for (int j = sem.size()-1; j>i; j--) {
				if (sem.get(i).getCoursenum().equals(sem.get(j).getCoursenum())) {
					//semestercourses.add(semestercourselist.get(i));
					sem.remove(sem.get(j));
				}
				}
			}
			
			for(SemesterChosenCourse s:sem){
				Course course = manageDao.loadCourseByIdent(s.getCoursenum());
				courseList.add(course);
			}
		}else if ((user.getRoles().getRolerank()==2)||(user.getRoles().getRolerank()==4)) {
			List<Classes> classlist = studentDao.loadclassbyteacher(user.getUsernum());
			String semester = getCurrSemester();
			List<SemesterChosenCourse> sem = new ArrayList<SemesterChosenCourse>();
			for(Classes c:classlist){
				List<SemesterChosenCourse> semes = manageDao.loadsemestercoursebyclass(c.getId(),semester);
			    sem.addAll(semes);
			}
			List<SemesterChosenCourse> semesterChosenCourses = manageDao.loadattendencecourse(user.getUsernum(), semester);
			sem.addAll(semesterChosenCourses);
			for (int i = 0; i < sem.size(); i++) {
				for (int j = sem.size()-1; j>i; j--) {
				if (sem.get(i).getCoursenum().equals(sem.get(j).getCoursenum())) {
					//semestercourses.add(semestercourselist.get(i));
					sem.remove(sem.get(j));
				}
				}
			}
			for(SemesterChosenCourse s:sem){
				Course course = manageDao.loadCourseByIdent(s.getCoursenum());
				courseList.add(course);
			}			
		}
		for(int i = 0;i<courseList.size();i++){
    		for (int j = courseList.size()-1; j>i; j--) {
				if(courseList.get(i).getId()==courseList.get(j).getId()){
					courseList.remove(j);
				}
			}
    	}
		return courseList;
	}

	@Override
	public List<SemesterChosenCourse> loadsemestercoursebycoursenum(String selectiveCourseNum, String semester) {
		// TODO Auto-generated method stub
		return manageDao.loadsemestercoursebycoursenum(selectiveCourseNum, semester);
	}

	@Override
	public List<SemesterChosenCourse> listsemester() {
		// TODO Auto-generated method stub
		List<SemesterChosenCourse> semestercourse = manageDao.loadallsemestercourse();
		for (int i = 0; i < semestercourse.size(); i++) {
			for (int j = semestercourse.size()-1; j>i; j--) {
			if (semestercourse.get(i).getSemester().equals(semestercourse.get(j).getSemester())) {
				semestercourse.remove(semestercourse.get(j));
			}
			}
		}
		return semestercourse;
	}

	@Override
	public List<SemesterChosenCourse> loadsemestercourse(String semester) {
		// TODO Auto-generated method stub
	    
		return manageDao.loadsemestercourse(semester);
	}
	List<Attendence> attendences2 = new ArrayList<Attendence>();
	List<Student> students = new ArrayList<Student>();
	@Override
	public List<Attendence> courseattendencelist(Integer id, String num) {
		// TODO Auto-generated method stub
		attendences2.clear();
		students.clear();
		String semester = getCurrSemester();
		attendences2 = manageDao.loadattendencebycourseid(num, semester);
		students = studentDao.loadstubyclassid(id);
		return attendences2;
	}
	@Override
	public Map<String, Object> attendencestatistical(int page, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		long total = students.size();		
		List<AttendenceModel> attendencemodels = new ArrayList<AttendenceModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < students.size()) {
				Integer normal = 0,late=0,leaveearly=0,truancy=0;	
				Integer coursenum = null;
				AttendenceModel model = new AttendenceModel();
			    for (Attendence a:attendences2) {
			    	coursenum = a.getChoosencourseid();
					if(students.get(i).getPassport().equals(a.getPassport())){
						if(a.getType().equals("0")){
							normal++;
						}else if(a.getType().equals("1")){
							late++;
						}else if(a.getType().equals("2")){
							leaveearly++;
						}else {
							truancy++;
						}
					}
				}
			    Course course = manageDao.loadCourseByIdent(String.valueOf(coursenum));
			    double probability = 0;
			    double truancys = (double)truancy;
			    double credits = course.getCredits()*16;
			    probability = Math.round(truancys/credits*1000)/100.0;
			    model.setProbability(probability*10);
			    model.setPassport(students.get(i).getPassport());
			    model.setStuname(students.get(i).getStuname());
			    model.setNormal(normal);
			    model.setLate(late);
			    model.setLeaveearly(leaveearly);
			    model.setTruancy(truancy);			   
			    attendencemodels.add(model);
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", attendencemodels);
		return map;
	}

	@Override
	public List<Attendence> loadattendencebycourseid(String id) {
		String semester = getCurrSemester();
		List<Attendence> attendences = manageDao.loadattendencebycourseid(id,semester);
		return attendences;
	}

	@Override
	public List<Leave> checkleave(Leave leave) {
		// TODO Auto-generated method stub
		List<Leave> leaves = manageDao.loadleavebystuid(leave.getPassport());
		List<Leave> leaves2 = new ArrayList<Leave>();
		for(Leave l:leaves){
			if((l.getStatus()==0)||(l.getStatus()==1)){
				leaves2.add(l);
			}
		}
		return leaves2;
	}

	@Override
	public ChosenCourse loadchosencourse(String stuid, String semester, String num) {
		// TODO Auto-generated method stub
		return manageDao.loadchosencourse(stuid,semester,num);
	}

	
	private Transcript toScript (ChosenCourse course) {
		Transcript script = new Transcript();
		script.setAttendance(course.getAttendence());
	
		script.setCourseNum(String.valueOf(course.getCourseId()));
		script.setFinalexam(String.valueOf(course.getFinalexam()));
		script.setHomework(String.valueOf(course.getHomework()));
		script.setMidexam(String.valueOf(course.getMidexam()));
		script.setOverall(String.valueOf(course.getSummary()));
		script.setSemester(course.getSemester());
		
		Course c = manageDao.getCourseByNum2(String.valueOf(course.getCourseId()));
		
		script.setCourseName(c.getCoursename());
		script.setCourseName_en(c.getCoursename_en());
		script.setCredit(String.valueOf(c.getCredits()));
		return script;
	}
	
	public void printTranscript(OutputStream out, Student student, Integer serial) {
		// 通过学生信息查到所有课程
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("Student", student);
		List<ChosenCourse> courses = manageDao.loadChosenCourseByStuId(student.getPassport());
		
		List<Transcript> scores = new ArrayList<Transcript>();
		for (ChosenCourse i : courses) {
			scores.add(toScript(i));
		}
		info.put("Courses", scores);
		
		TranscriptService script = new TranscriptServiceImpl();
		
		script.getPerTscript2(out, info, serial);
	}

	@Override
	public Certify1 loadcertifybyid(Integer id) {
		// TODO Auto-generated method stub
		return manageDao.loadcertifybyid(id);
	}


	@Override
	public Integer getSerial(User user, String filename, String filetype) {
		return manageDao.getSerial(user, filename, filetype);
	}


	@Override
	public List<SemesterChosenCourse> loadsemestercoursebycourseid(String selectiveCourseNum, String semester) {
		// TODO Auto-generated method stub
		return manageDao.loadsemestercoursebycourseid(selectiveCourseNum, semester);
	}

	@Override
	public List<Course> loadcoursebysemester(String usernum,String semester) {
		// TODO Auto-generated method stub
		List<ChosenCourse> sem = manageDao.loadstuscore(semester, usernum);
		List<Course> courses = new ArrayList<Course>();
		for(ChosenCourse s:sem){
			Course courses2 = studentDao.loadcoursebycoursenum(String.valueOf(s.getCourseId()));
			if(courses.contains(courses2)){
				continue;
			}else {
				courses.add(courses2);
			}
		}
		return courses;
	}
    List<ChosenCourse> choCourses = new ArrayList<ChosenCourse>();
	@Override
	public void loadcoursemakeup(String semester, String num) {
		// TODO Auto-generated method stub
		choCourses = manageDao.loadselectcoursestu(num, semester);
		List<ChosenCourse> cho = new ArrayList<ChosenCourse>();
		for(int i=0;i<choCourses.size();i++){
			if(choCourses.get(i).getSummary()<60){
				continue;
			}else {
				cho.add(choCourses.get(i));
			}
		}
		if (choCourses.containsAll(cho)) {
			choCourses.removeAll(cho);
		}
	}

	@Override
	public Map<String, Object> makeuplist(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		long total = choCourses.size();
		List<ChosenCourseModel> coursemodels = new ArrayList<ChosenCourseModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
		 if (i < choCourses.size()) {
			ChosenCourseModel model = new ChosenCourseModel();
				if (choCourses.get(i).getAttendence() == null||choCourses.get(i).getAttendence().length()==0) {// 考勤成绩
					model.setAttendence("");
				} else {
					if (Float.valueOf(choCourses.get(i).getAttendence()) < 60) {
						String attendence = "<font color='red'>" + choCourses.get(i).getAttendence() + "</font>";
						model.setAttendence(attendence);
					} else {
						model.setAttendence(String.valueOf(choCourses.get(i).getAttendence()));
					}
				}
				if (choCourses.get(i).getHomework() == null||choCourses.get(i).getHomework().length()==0) {// 平时成绩
					model.setHomework("");
				} else {
					if (Float.valueOf(choCourses.get(i).getHomework()) < 60) {
						String homework = "<font color='red'>" + choCourses.get(i).getHomework() + "</font>";
						model.setHomework(homework);
					} else {
						model.setHomework(String.valueOf(choCourses.get(i).getHomework()));
					}
				}
				if (choCourses.get(i).getFinalexam() == null||choCourses.get(i).getFinalexam().length()==0) {// 期末成绩
					model.setFinalexam("");
				} else {
					if (Float.valueOf(choCourses.get(i).getFinalexam()) < 60) {
						String attendence = "<font color='red'>" + choCourses.get(i).getFinalexam() + "</font>";
						model.setFinalexam(attendence);
					} else {
						model.setFinalexam(String.valueOf(choCourses.get(i).getFinalexam()));
					}
				}
				if (choCourses.get(i).getMidexam() == null||choCourses.get(i).getMidexam().length()==0) {
					model.setMidexam("");
				} else {
					if (Float.valueOf(choCourses.get(i).getMidexam()) < 60) {
						String attendence = "<font color='red'>" + choCourses.get(i).getMidexam() + "</font>";
						model.setMidexam(attendence);
					} else {
						model.setMidexam(String.valueOf(choCourses.get(i).getMidexam()));
					}
				}
		    model.setNum(String.valueOf(choCourses.get(i).getCourseId()));
			Student stu = studentDao.loadstubystuid(String.valueOf(choCourses.get(i).getPassport()));
			model.setStuname(stu.getStuname());
			model.setPassport(stu.getPassport());
			model.setIsmakeup(choCourses.get(i).getIsmakeup());
			if (choCourses.get(i).getMakeup()!=null) {
				model.setMakeup(String.valueOf(choCourses.get(i).getMakeup()));
			}
			Course course = studentDao.loadcoursebynum(String.valueOf(choCourses.get(i).getCourseId()));
			model.setCoursename(course.getCoursename());
			if(choCourses.get(i).getSummary()==0){
				model.setSummary("");
			}else {
				if(choCourses.get(i).getSummary()<60){
					String attendence = "<font color='red'>"+choCourses.get(i).getSummary()+"</font>";
					model.setSummary(attendence);
				}else {
					model.setSummary(String.valueOf(choCourses.get(i).getSummary()));
				}			
			}
			String seme = choCourses.get(i).getSemester();
			String semesters = "";
			if(seme.substring(4,6).equals("01")){
				semesters = seme.substring(0,4)+"-"+String.valueOf(Integer.valueOf(seme.substring(0,4))+1)+"学年第一学期";
			}else {
				semesters = String.valueOf(Integer.valueOf(seme.substring(0,4))-1)+"-"+seme.substring(0,4)+"学年第二学期";
			}
			
			model.setSemester(semesters);
			coursemodels.add(model);
		}
		}
		map.put("Total", total);
		map.put("Rows", coursemodels);
		return map;
	}

	@Override
	public void ModifyLog(User user, String objectType, String objectName) {
		manageDao.modifyLog(user, objectName, objectType);
	}

	@Override
	public Map<String, Object> justicellist(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<Certify1> justicellist = manageDao.loadjusticel();
		long total = justicellist.size();
		List<Certify1Model> announcementmodels = new ArrayList<Certify1Model>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			 if (i < justicellist.size()) {
			    Certify1Model model = new Certify1Model();
			    model.setId(justicellist.get(i).getId());
			    model.setTitle(justicellist.get(i).getTitle());
			    model.setFileplace(justicellist.get(i).getFileplace());
			    model.setCreatedtime(justicellist.get(i).getCreatedtime());
			    announcementmodels.add(model);
			 }else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", announcementmodels);
		return map;
	}

	@Override
	public void batchaddstuchosencourse() {
		// TODO Auto-generated method stub
		String semester = getCurrSemester();		
		List<SemesterChosenCourse> semestercourse = manageDao.loadsemestercourse(semester);
		for (int i = 0; i < semestercourse.size(); i++) { // 外循环是循环的次数
			for (int j = semestercourse.size() - 1; j > i; j--) { // 内循环是 外循环一次比较的次数
				if (semestercourse.get(i).getCoursenum().equals(semestercourse.get(j).getCoursenum())) {
					semestercourse.remove(j);
				}
			}
		}
		List<SemesterChosenCourse> sem = new ArrayList<SemesterChosenCourse>();
		for(SemesterChosenCourse s:semestercourse){
			if (s.getIsElective()==2) {
				sem.add(s);
			}
		}
		semestercourse.removeAll(sem);
		List<ChosenCourse> chosenCourses = manageDao.loadstuscorelist(semester);
		for(int i =0;i<chosenCourses.size();i++){//去掉数据表中学生已选课程
			for(SemesterChosenCourse s:sem){
				if (chosenCourses.get(i).getCourseId().equals(Integer.valueOf(s.getCoursenum()))) {
					chosenCourses.remove(i);
				}
			}			
		}
		for(ChosenCourse c:chosenCourses){
			manageDao.diselectCourse(c);
		}
		for (SemesterChosenCourse s : semestercourse) {
			List<ClassesModel> classes = new ArrayList<ClassesModel>();
			if (s.getClass_() != null) {
				for (String id : s.getClass_().split("&")) {
					if (id != null && !id.equals("")) {
						classes.add(manageDao.loadClassByID(id));
					}
				}
			}	
		    List<Student> studentlist = new ArrayList<Student>();
		    for (ClassesModel c : classes) {
		  	   List<Student> stu = studentDao.loadstubyclassid(c.getId());
			   studentlist.addAll(stu);
		    }
			for (Student stu : studentlist) {
				ChosenCourse ic = new ChosenCourse();
				ic.setPassport(stu.getPassport());
				ic.setCourseId(s.getCoursenum());
				ic.setSemester(semester);
				ic.setWeekday(s.getWeekday());
				ic.setSlot(s.getSlot());
				ic.setRoom(s.getCoursenum());
				ic.setRoomtype(s.getRoomtype());
				manageDao.selectCourse(ic);
			}
		}

	}

	@Override
	public Map<String, Object> allevalutionanalysis(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<EvalutionModel> evalutionmodels = new ArrayList<EvalutionModel>();
		List<SemesterChosenCourse> semestercourse = new ArrayList<SemesterChosenCourse>();
		String semester = getCurrSemester();
		semestercourse = manageDao.loadsemestercourse(semester);				
		for (int i = 0; i < semestercourse.size(); i++) {  //外循环是循环的次数
            for (int j = semestercourse.size() - 1 ; j > i; j--){  //内循环是 外循环一次比较的次数           
                if (semestercourse.get(i).getCoursenum().equals(semestercourse.get(j).getCoursenum())){
                    semestercourse.remove(j);
                }
            }
        }
		long total = semestercourse.size();						
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			 if (i < semestercourse.size()) {
				 EvalutionModel model = new EvalutionModel();
				 List<Evalution> evalutionlist = manageDao.loadevalution(semestercourse.get(i).getCoursenum(),semester);
				 if (evalutionlist.size()==0) {
					 List<Teacher> teachers = manageDao.loadteacherbyIdent(semestercourse.get(i).getTeacherid());
				     Course course = manageDao.loadCourseByIdent(semestercourse.get(i).getCoursenum());
				     if (teachers.size()==0) {
							model.setTeachername("");
					 }else {
							model.setTeachername(teachers.get(0).getTeachername());
					 }   
					 model.setCoursenum(String.valueOf(course.getNum()));
				     model.setCoursename(course.getCoursename());
				     model.setIncicators1("");
				     model.setIncicators2("");
				     model.setIncicators3("");
				     model.setIncicators4("");
				     model.setIncicators5("");
				     model.setIncicators6("");
				     model.setIncicators7("");
				     model.setSummary("");
				     evalutionmodels.add(model);
				}else {
				 double incicators1= 0,incicators2 = 0,incicators3=0,incicators4 =0,incicators5 =0,incicators6 =0,incicators7 =0,summary=0;
					for(Evalution e:evalutionlist){
						if (e.getIncicators1().equals("1")) {
							incicators1 = incicators1+95;
						}else if (e.getIncicators1().equals("2")) {
							incicators1 = incicators1+82.5; 
						}else if (e.getIncicators1().equals("3")) {
							incicators1 = incicators1+67.5; 
						}else {
							incicators1 = incicators1+50;
						}
						if (e.getIncicators2().equals("1")) {
							incicators2 = incicators2+95;
						}else if (e.getIncicators2().equals("2")) {
							incicators2 = incicators2+82.5; 
						}else if (e.getIncicators2().equals("3")) {
							incicators2 = incicators2+67.5; 
						}else {
							incicators2= incicators2+50;
						}
						if (e.getIncicators3().equals("1")) {
							incicators3 = incicators3+95;
						}else if (e.getIncicators3().equals("2")) {
							incicators3 = incicators3+82.5; 
						}else if (e.getIncicators3().equals("3")) {
							incicators3 = incicators3+67.5; 
						}else {
							incicators3= incicators3+50;
						}
						if (e.getIncicators4().equals("1")) {
							incicators4 = incicators4+95;
						}else if (e.getIncicators4().equals("2")) {
							incicators4 = incicators4+82.5; 
						}else if (e.getIncicators4().equals("3")) {
							incicators4 = incicators4+67.5; 
						}else {
							incicators4= incicators4+50;
						}
						if (e.getIncicators5().equals("1")) {
							incicators5 = incicators5+95;
						}else if (e.getIncicators5().equals("2")) {
							incicators5 = incicators5+82.5; 
						}else if (e.getIncicators5().equals("3")) {
							incicators5 = incicators5+67.5; 
						}else {
							incicators5= incicators5+50;
						}
						if (e.getIncicators6().equals("1")) {
							incicators6 = incicators6+95;
						}else if (e.getIncicators6().equals("2")) {
							incicators6 = incicators6+82.5; 
						}else if (e.getIncicators6().equals("3")) {
							incicators6 = incicators6+67.5; 
						}else {
							incicators6= incicators6+50;
						}
						if (e.getIncicators7().equals("1")) {
							incicators7 = incicators7+95;
						}else if (e.getIncicators7().equals("2")) {
							incicators7 = incicators7+82.5; 
						}else if (e.getIncicators7().equals("3")) {
							incicators7 = incicators7+67.5; 
						}else {
							incicators7= incicators7+50;
						}
					}
					incicators1 = Math.round(incicators1/evalutionlist.size()*100)/100.0;
					incicators2 = Math.round(incicators2/evalutionlist.size()*100)/100.0;
					incicators3 = Math.round(incicators3/evalutionlist.size()*100)/100.0;
					incicators4 = Math.round(incicators4/evalutionlist.size()*100)/100.0;
					incicators5 = Math.round(incicators5/evalutionlist.size()*100)/100.0;
					incicators6 = Math.round(incicators6/evalutionlist.size()*100)/100.0;
					incicators7 = Math.round(incicators7/evalutionlist.size()*100)/100.0;
					summary =  Math.round(((incicators1+incicators2+incicators3+incicators4+incicators5+incicators6+incicators7)/7)*100)/100.0;
			        List<Teacher> teachers = manageDao.loadteacherbyIdent(semestercourse.get(i).getTeacherid());
			        Course course = manageDao.loadCourseByIdent(semestercourse.get(i).getCoursenum());
			        if (teachers.size()==0) {
						model.setTeachername("");
					}else {
						model.setTeachername(teachers.get(0).getTeachername());
					}			        
			        model.setCoursenum(String.valueOf(course.getNum()));
			        model.setCoursename(course.getCoursename());
			        model.setIncicators1(String.valueOf(incicators1));
			        model.setIncicators2(String.valueOf(incicators2));
			        model.setIncicators3(String.valueOf(incicators3));
			        model.setIncicators4(String.valueOf(incicators4));
			        model.setIncicators5(String.valueOf(incicators5));
			        model.setIncicators6(String.valueOf(incicators6));
			        model.setIncicators7(String.valueOf(incicators7));
			        model.setSummary(String.valueOf(summary));
			        evalutionmodels.add(model);
			   }
			 }else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", evalutionmodels);
		return map;
	}

	@Override
	public Map<String, Object> allClassteacherEvalutionResult(int page, int pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<EvalutionModel> evalutionmodels = new ArrayList<EvalutionModel>();
		String semester = getCurrSemester();
		List<Classes> classList = studentDao.loadallclasses1();
		List<Teacher> teacherlist = new ArrayList<Teacher>();
		for(Classes c:classList){
			if (c.getClassteacherid()!=null) {
				Teacher teacher = manageDao.loadteacherbyidentificationnum(String.valueOf(c.getClassteacherid()));
				teacherlist.add(teacher);
			}
		}
		for (int i = 0; i < teacherlist.size(); i++){
            for (int j = teacherlist.size() - 1 ; j > i; j--){
               if (teacherlist.get(i).getIdentificationnum().equals(teacherlist.get(j).getIdentificationnum())){
                    teacherlist.remove(j);
                }
            }
        }
		long total = teacherlist.size();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			 if (i < teacherlist.size()) {			    
				 EvalutionModel model = new EvalutionModel();
				 List<Evalution> evalutionlist = manageDao.loadclassteacherevalution(teacherlist.get(i).getIdentificationnum(),semester);
				 if (evalutionlist.size()==0) {					 
					 model.setTeachername(teacherlist.get(i).getTeachername());  
					 model.setTeacher(teacherlist.get(i).getIdentificationnum());
					 model.setIncicators1("");
				     model.setIncicators2("");
				     model.setIncicators3("");
				     model.setIncicators4("");
				     model.setIncicators5("");
				     model.setIncicators6("");
				     model.setIncicators7("");
				     model.setSummary("");
				     evalutionmodels.add(model);
				}else {
				 double incicators1= 0,incicators2 = 0,incicators3=0,incicators4 =0,incicators5 =0,incicators6 =0,incicators7 =0,summary=0;
					for(Evalution e:evalutionlist){
						if (e.getIncicators1().equals("1")) {
							incicators1 = incicators1+95;
						}else if (e.getIncicators1().equals("2")) {
							incicators1 = incicators1+82.5; 
						}else if (e.getIncicators1().equals("3")) {
							incicators1 = incicators1+67.5; 
						}else {
							incicators1 = incicators1+50;
						}
						if (e.getIncicators2().equals("1")) {
							incicators2 = incicators2+95;
						}else if (e.getIncicators2().equals("2")) {
							incicators2 = incicators2+82.5; 
						}else if (e.getIncicators2().equals("3")) {
							incicators2 = incicators2+67.5; 
						}else {
							incicators2= incicators2+50;
						}
						if (e.getIncicators3().equals("1")) {
							incicators3 = incicators3+95;
						}else if (e.getIncicators3().equals("2")) {
							incicators3 = incicators3+82.5; 
						}else if (e.getIncicators3().equals("3")) {
							incicators3 = incicators3+67.5; 
						}else {
							incicators3= incicators3+50;
						}
						if (e.getIncicators4().equals("1")) {
							incicators4 = incicators4+95;
						}else if (e.getIncicators4().equals("2")) {
							incicators4 = incicators4+82.5; 
						}else if (e.getIncicators4().equals("3")) {
							incicators4 = incicators4+67.5; 
						}else {
							incicators4= incicators4+50;
						}
						if (e.getIncicators5().equals("1")) {
							incicators5 = incicators5+95;
						}else if (e.getIncicators5().equals("2")) {
							incicators5 = incicators5+82.5; 
						}else if (e.getIncicators5().equals("3")) {
							incicators5 = incicators5+67.5; 
						}else {
							incicators5= incicators5+50;
						}
						if (e.getIncicators6().equals("1")) {
							incicators6 = incicators6+95;
						}else if (e.getIncicators6().equals("2")) {
							incicators6 = incicators6+82.5; 
						}else if (e.getIncicators6().equals("3")) {
							incicators6 = incicators6+67.5; 
						}else {
							incicators6= incicators6+50;
						}
						if (e.getIncicators7().equals("1")) {
							incicators7 = incicators7+95;
						}else if (e.getIncicators7().equals("2")) {
							incicators7 = incicators7+82.5; 
						}else if (e.getIncicators7().equals("3")) {
							incicators7 = incicators7+67.5; 
						}else {
							incicators7= incicators7+50;
						}
					}
					incicators1 = Math.round(incicators1/evalutionlist.size()*100)/100.0;
					incicators2 = Math.round(incicators2/evalutionlist.size()*100)/100.0;
					incicators3 = Math.round(incicators3/evalutionlist.size()*100)/100.0;
					incicators4 = Math.round(incicators4/evalutionlist.size()*100)/100.0;
					incicators5 = Math.round(incicators5/evalutionlist.size()*100)/100.0;
					incicators6 = Math.round(incicators6/evalutionlist.size()*100)/100.0;
					incicators7 = Math.round(incicators7/evalutionlist.size()*100)/100.0;
					summary =  Math.round(((incicators1+incicators2+incicators3+incicators4+incicators5+incicators6+incicators7)/7)*100)/100.0;
			        model.setTeachername(teacherlist.get(i).getTeachername());			        
			        model.setTeacher(teacherlist.get(i).getIdentificationnum());
			        model.setIncicators1(String.valueOf(incicators1));
			        model.setIncicators2(String.valueOf(incicators2));
			        model.setIncicators3(String.valueOf(incicators3));
			        model.setIncicators4(String.valueOf(incicators4));
			        model.setIncicators5(String.valueOf(incicators5));
			        model.setIncicators6(String.valueOf(incicators6));
			        model.setIncicators7(String.valueOf(incicators7));
			        model.setSummary(String.valueOf(summary));
			        evalutionmodels.add(model);
			   }
			 }else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", evalutionmodels);
		return map;
	}
	@Override
	public Map<String, Object> classteacherevalutionmap(int page, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Classes> classList = studentDao.loadallclasses1();
		List<Teacher> teacherlist = new ArrayList<Teacher>();
		for(Classes c:classList){
			if (c.getClassteacherid()!=null) {
				Teacher teacher = manageDao.loadteacherbyidentificationnum(String.valueOf(c.getClassteacherid()));
				teacherlist.add(teacher);
			}
		}
		for (int i = 0; i < teacherlist.size(); i++){
            for (int j = teacherlist.size() - 1 ; j > i; j--){
               if (teacherlist.get(i).getIdentificationnum().equals(teacherlist.get(j).getIdentificationnum())){
                    teacherlist.remove(j);
                }
            }
        }
		long total = teacherlist.size();
		List<TeacherModel> teachermodels = new ArrayList<TeacherModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			 if (i < teacherlist.size()) {
			    TeacherModel model = new TeacherModel();
			    List<Classes> classes = studentDao.loadclassbyteacher(teacherlist.get(i).getIdentificationnum());
			    String classlist = "";
			    for(Classes c:classes){
			    	classlist +=c.getClassname()+"、";
			    }
			    model.setIdentificationnum(teacherlist.get(i).getIdentificationnum());
			    model.setTeachername(teacherlist.get(i).getTeachername());
			    model.setTelephone(classlist);
			    teachermodels.add(model);
			 }else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", teachermodels);
		return map;
	}
	@Override
	public Map<String, Object> singlecourseattendencestatistical(int page, int pageSize, String num, Integer id, String startdate, String enddate) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String semester = getCurrSemester();
		List<Attendence> attendencelist = manageDao.loadattendencebycourseid(num, semester);
		if (startdate.length()!=0&&enddate.length()!=0) {
			for(int i=0;i<attendencelist.size();i++){
				SimpleDateFormat dt = new SimpleDateFormat("yy-MM-dd");
				Date StartDate=null, EndDate=null,nowDate=null;
				try {
					StartDate= dt.parse(startdate);
					EndDate = dt.parse(enddate);
				    nowDate = dt.parse(attendencelist.get(i).getDate());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if ((nowDate.getTime()-StartDate.getTime())>=0&&(EndDate.getTime()-nowDate.getTime())>=0) {
					continue;
				}else {
					attendencelist.remove(i);
					i--;
				}
			}
		}		
		List<Student> studentlist = studentDao.loadstubyclassid(id);
		long total = studentlist.size();		
		List<AttendenceModel> attendencemodels = new ArrayList<AttendenceModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < students.size()) {
				Integer normal = 0,late=0,leaveearly=0,truancy=0;	
				Integer coursenum = null;
				AttendenceModel model = new AttendenceModel();
			    for (Attendence a:attendencelist) {
			    	coursenum = a.getChoosencourseid();
					if(students.get(i).getPassport().equals(a.getPassport())){
						if(a.getType().equals("0")){
							normal++;
						}else if(a.getType().equals("1")){
							late++;
						}else if(a.getType().equals("2")){
							leaveearly++;
						}else {
							truancy++;
						}
					}
				}
			    Course course = manageDao.loadCourseByIdent(String.valueOf(num));
			    double probability = 0;
			    double truancys = (double)truancy;
			    double credits = 0;
			    if (course==null) {
					credits=0;
				}else {
					credits = course.getCredits()*16;
				}
			    if (truancys==0) {
					probability=0;
				}else {
					probability = Math.round(truancys/credits*1000)/100.0;
				}			    
			    model.setProbability(probability*10);
			    model.setPassport(students.get(i).getPassport());
			    model.setStuname(students.get(i).getStuname());
			    model.setNormal(normal);
			    model.setLate(late);
			    model.setLeaveearly(leaveearly);
			    model.setTruancy(truancy);			   
			    attendencemodels.add(model);
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", attendencemodels);
		return map;
	}

	@Override
	public Map<String, Object> searchcourseattendencelistmap(int page, int pageSize, String coursenum, Integer id, String stuid, String startdate, String enddate, String time, String type) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String semester = getCurrSemester();
		List<Attendence> attendences = new ArrayList<Attendence>();
		if (id==null) {
			attendences = manageDao.searchallattendence(coursenum,stuid,semester);
		}else {
			if (stuid.length()==0||stuid.equals("null")) {
				List<Student> students = studentDao.loadstubyclassid(id);
				for(Student s:students){
					List<Attendence> attendences2 = manageDao.searchallattendence(coursenum,s.getPassport(),semester);
				    attendences.addAll(attendences2);
				}
			}else {
				attendences = manageDao.searchallattendence(coursenum,stuid,semester);
			}
			
		}
		if (!startdate.equals("")&&!enddate.equals("")) {
			for(int i=0;i<attendences.size();i++){
				SimpleDateFormat dt = new SimpleDateFormat("yy-MM-dd");
				Date StartDate=null, EndDate=null,nowDate=null;
				try {
					StartDate= dt.parse(startdate);
					EndDate = dt.parse(enddate);
				    nowDate = dt.parse(attendences.get(i).getDate());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if ((nowDate.getTime()-StartDate.getTime())>=0&&(EndDate.getTime()-nowDate.getTime())>=0) {
					continue;
				}else {
					attendences.remove(i);
					i--;
				}
			}
		}
		if (time.length()!=0) {
			for(int i=0;i<attendences.size();i++){				
				if (attendences.get(i).getTime().equals(time)) {
					continue;
				}else {
					attendences.remove(i);
					i--;
				}
			}
		}
		if (type.length()!=0) {
			for(int i=0;i<attendences.size();i++){				
				if (attendences.get(i).getType().equals(type)) {
					continue;
				}else {
					attendences.remove(i);
					i--;
				}
			}
		}
		long total = attendences.size();
		List<AttendenceModel> attendencemodels = new ArrayList<AttendenceModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i < attendences.size()) {
				AttendenceModel model = new AttendenceModel();
			    model.setId(attendences.get(i).getId());
				Student student = studentDao.loadstubystuid(attendences.get(i).getPassport());
				model.setClassname(student.getClasses().getClassname());
				model.setDate(attendences.get(i).getDate());
				model.setFirstname(student.getFirstname());
				model.setLastname(student.getLastname());
				model.setStunum(student.getStuid());
				model.setPassport(student.getPassport());
				model.setStuname(student.getStuname());
				Course course = manageDao.loadCourseByIdent(String.valueOf(attendences.get(i).getChoosencourseid()));
				model.setCoursename(course.getCoursename());
				model.setTime(attendences.get(i).getTime());
				model.setType(attendences.get(i).getType());
				attendencemodels.add(model);										    
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", attendencemodels);
		return map;
	}

	@Override
	public String loadclassteacherevalution(String teacher) {
		// TODO Auto-generated method stub
		String semester = getCurrSemester();
		List<Evalution> evalution = manageDao.loadclassteacherevalution(teacher,semester);
		String evalutionlist = "";
		int i = 1;
		for (Evalution c : evalution) {
			String s = "{\"id\":" + c.getId() + "," + "\"stuid\":" + "\"" + c.getPassport() + "\"," + "\"incicators1\":" + "\"" + c.getIncicators1() + "\"," + "\"incicators2\":" + "\"" + c.getIncicators2() + "\"," + "\"incicators3\":" + "\"" + c.getIncicators3() + "\"," 
					+ "\"incicators4\":" + "\"" + c.getIncicators4() + "\","+ "\"incicators5\":" + "\"" + c.getIncicators5() + "\","+ "\"incicators6\":" + "\"" + c.getIncicators6() + "\","+ "\"incicators7\":" + "\"" + c.getIncicators7() + "\","+ "\"summary\":" + "\"" + c.getSummary() + "\","
					+ "\"extrude\":" + "\"" + c.getExtrude() + "\","+ "\"advice\":" + "\"" + c.getAdvice() + "\"}";
			if (i < evalution.size()) {
				evalutionlist += s + ",";
			} else {
				evalutionlist += s;
			}
			i++;
		}
		return evalutionlist;
	}

	@Override
	public PageBean loadallannouncement(int page, int pageSize) {
		// TODO Auto-generated method stub
		List<Announcement> announcementlist = manageDao.loadannouncementlist();
		int allRow;
		if (announcementlist==null) {
			allRow =0; //总记录数
		}else{
			allRow =announcementlist.size(); //总记录数
		}		
		int totalPage = PageBean.countTotalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, page);//当前页开始记录
		final int length = pageSize;//每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List<Announcement> list = manageDao.queryForPage(offset, length);//"一页"的记录
		//把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setRecordSUM(allRow);
		pageBean.setPageSUM(totalPage);
		pageBean.setResultList(list);
		pageBean.init();
		return pageBean;
	}

}

	
