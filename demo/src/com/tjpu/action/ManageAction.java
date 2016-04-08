package com.tjpu.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.Adjustcourse;
import com.tjpu.bean.AdjustcourseModel;
import com.tjpu.bean.Announcement;
import com.tjpu.bean.Attendence;
import com.tjpu.bean.BatchRegiste;
import com.tjpu.bean.Cascade;
import com.tjpu.bean.Certify1;
import com.tjpu.bean.ChosenCourse;
import com.tjpu.bean.ChosenCourseModel;
import com.tjpu.bean.Classes;
import com.tjpu.bean.ClassesModel;
import com.tjpu.bean.Classroom;
import com.tjpu.bean.ClassroomModel;
import com.tjpu.bean.Course;
import com.tjpu.bean.CourseModel;
import com.tjpu.bean.Dept;
import com.tjpu.bean.Evalution;
import com.tjpu.bean.InfoBean;
import com.tjpu.bean.Leave;
import com.tjpu.bean.SemesterChosenCourse;
import com.tjpu.bean.Student;
import com.tjpu.bean.Syllabus;
import com.tjpu.bean.Teacher;
import com.tjpu.bean.User;
import com.tjpu.service.ClassService;
import com.tjpu.service.CourseArrangement;
import com.tjpu.service.CourseArrangementImpl;
import com.tjpu.service.ManageService;
import com.tjpu.service.StudentService;
import com.tjpu.service.TranscriptService;
import com.tjpu.service.TranscriptServiceImpl;
import com.tjpu.service.UserService;

/**
 * @author ZhangChong
 * 
 */
@Controller
public class ManageAction {
	@Autowired
	StudentService studentService;
	@Autowired
	ClassService classService;
	@Autowired
	ManageService manageService;
	@Autowired
	UserService userService;
	private Course course;
	private Evalution evalution;
	private Attendence attendence;
	private Announcement announcement;
	private SemesterChosenCourse semChosenCourse;
	private Student stu;
	private ChosenCourse chosenCourse;
	private String docName;
	private Integer LeaveType = 1;
	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	private Adjustcourse adjustcourse;
	private CourseArrangement ca = null;
	private Teacher teacher;
	private Leave leave;
	private String ids;
	private Integer depid;
	private String date;
	private String time;
	private Classes cls;
	private File file;
	public File getLeaveDoc() {
		return leaveDoc;
	}

	public void setLeaveDoc(File leaveDoc) {
		this.leaveDoc = leaveDoc;
	}

	private File leaveDoc;
	private File image;
	private String imageFileName;
	private String fileFileName;
	private String fileContentType;
	private String title;
	private Certify1 certify;
	private String newnum;
	private String oldnum;
	private String oldAdjustApplyID;
	private String newAdjustApplyID;
	private String isApprove;
	private String adjustcourseID;
	private String selectiveCourseNum;

	private String semester;
	private String origndate;
	private String plandate;
	private String oldSlot;
	private String newSlot;
	private String queryType;
	private String newRoomNum;
	private String oldRoomNum;
	private String insertID;
	
	public String getOrigndate() {
		return origndate;
	}

	public void setOrigndate(String origndate) {
		this.origndate = origndate;
	}

	public String getPlandate() {
		return plandate;
	}

	public void setPlandate(String plandate) {
		this.plandate = plandate;
	}

	public ChosenCourse getChosenCourse() {
		return chosenCourse;
	}

	public void setChosenCourse(ChosenCourse chosenCourse) {
		this.chosenCourse = chosenCourse;
	}

	private String adjustReason;

	public String getAdjustReason() {
		return adjustReason;
	}

	public void setAdjustReason(String adjustReason) {
		this.adjustReason = adjustReason;
	}

	public String getSelectiveCourseNum() {
		return selectiveCourseNum;
	}

	public void setSelectiveCourseNum(String selectiveCourseNum) {
		this.selectiveCourseNum = selectiveCourseNum;
	}

	public String getNewnum() {
		return newnum;
	}

	public void setNewnum(String newnum) {
		this.newnum = newnum;
	}

	public SemesterChosenCourse getSemChosenCourse() {
		return semChosenCourse;
	}

	public void setSemChosenCourse(SemesterChosenCourse semChosenCourse) {
		this.semChosenCourse = semChosenCourse;
	}

	public Adjustcourse getAdjustcourse() {
		return adjustcourse;
	}

	public void setAdjustcourse(Adjustcourse adjustcourse) {
		this.adjustcourse = adjustcourse;
	}

	public String getIsApprove() {
		return isApprove;
	}

	public void setIsApprove(String isApprove) {
		this.isApprove = isApprove;
	}

	public String getAdjustcourseID() {
		return adjustcourseID;
	}

	public void setAdjustcourseID(String adjustcourseID) {
		this.adjustcourseID = adjustcourseID;
	}

	public String getNewAdjustApplyID() {
		return newAdjustApplyID;
	}

	public void setNewAdjustApplyID(String newAdjustApplyID) {
		this.newAdjustApplyID = newAdjustApplyID;
	}

	public String getOldAdjustApplyID() {
		return oldAdjustApplyID;
	}

	public void setOldAdjustApplyID(String oldAdjustApplyID) {
		this.oldAdjustApplyID = oldAdjustApplyID;
	}

	public String getOldnum() {
		return oldnum;
	}

	public void setOldnum(String oldnum) {
		this.oldnum = oldnum;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Certify1 getCertify() {
		return certify;
	}

	public void setCertify(Certify1 certify) {
		this.certify = certify;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public Leave getLeave() {
		return leave;
	}

	public void setLeave(Leave leave) {
		this.leave = leave;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Attendence getAttendence() {
		return attendence;
	}

	public void setAttendence(Attendence attendence) {
		this.attendence = attendence;
	}

	public Classes getCls() {
		return cls;
	}

	public void setCls(Classes cls) {
		this.cls = cls;
	}

	public Integer getDepid() {
		return depid;
	}

	public void setDepid(Integer depid) {
		this.depid = depid;
	}

	public Evalution getEvalution() {
		return evalution;
	}

	public void setEvalution(Evalution evalution) {
		this.evalution = evalution;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	private void datatojson(Map<String, Object> map) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		Gson gson = new Gson();
		String json = gson.toJson(map);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/* 请假 */
	public String leaveapply() {
		return "leaveapply";
	}

	public String leavemanage() {
		return "leavemanagelist";
	}

	public String shortleave() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user.getRoles().getRolerank()==3) {
		  Student student = studentService.loadstubystuid(user.getUsernum());
		  ActionContext.getContext().put("student", student);
		  return "shortleave";
		}else {
			ActionContext.getContext().put("message", "您不是学生，不能请假！");
			return "showmessage";
		}
	}

	public String longleave() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user.getRoles().getRolerank()==3) {
			Student student = studentService.loadstubystuid(user.getUsernum());
			ActionContext.getContext().put("student", student);
			return "longleave";
		}else {
			ActionContext.getContext().put("message", "您不是学生，不能请假！");
			return "showmessage";
		}
		
	}

	public String loadstuleave() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.stuleavemap(page, pageSize);
		datatojson(map);
		return null;
	}
	public String stuloadleave() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.loadstuleavemap(page, pageSize);
		datatojson(map);
		return null;
	}
	
	public String leaveDoc() {
		String realpath = ServletActionContext.getServletContext().getRealPath("/filepath");
		// String saveUrl = ServletActionContext.getRequest().getContextPath() +
		// "/filepath/";
		Date dt = new Date();
		SimpleDateFormat mt2 = new SimpleDateFormat("yyMMddHHmmss");
		String filename = mt2.format(dt);
		for (int i = 0; i < 3; i++) {
			Random r = new Random();
			int ran = r.nextInt(10);
			filename += ran;
		}
		if (leaveDoc != null) {
			File savedir = new File(realpath);
			//String name = fileFileName.substring(fileFileName.indexOf('.'));
			//String filename = s.concat(name);
			String prefix = "";
			if (docName != null) {
				prefix = docName.substring(docName.lastIndexOf(".")+1);
				docName = null;
			}
			filename += "." + prefix;
			if (!savedir.exists())
				savedir.mkdirs();
			try {
				File savefile = new File(savedir, filename);
				FileUtils.copyFile(leaveDoc, savefile);
			} catch (IOException e) {

				e.printStackTrace();
			}
			String fileplace = "filepath/" + filename;
			leaveDoc = null;
			return fileplace;
			//ActionContext.getContext().put("msg", "添加成功！");
		} else {
			//ActionContext.getContext().put("msg", "文件内容为空，添加失败！<br>退出请重新添加！");
		}
		return "";
	}
	
	//TODO
	public String leaveadd() {
		leave.setDoc(leaveDoc());
		//leave.setType(LeaveType);
		manageService.leaveadd(leave);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			OutputStream out = response.getOutputStream();
			out.write("<script type='text/javascript'>parent.reloadthistab()</script>".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}

	public String stuleaveupdate() {
		manageService.stuleaveupdate(leave);
		return null;
	}

	public String leaveupdate(){
		manageService.leaveupdate(leave);
		return null;
	}
	
	public String leavedelete() {
		manageService.leavedelete(leave);
		return null;
	}
	
	public String leaveedit(){
		Leave leaves = manageService.loadleavebyid(leave.getId());
		User user = (User) ActionContext.getContext().getSession().get("user");
		Student student = studentService.loadstubystuid(user.getUsernum());
		ActionContext.getContext().put("student", student);
		ActionContext.getContext().put("leaves", leaves);
		if(leaves.getType()==1){
			return "shortleaveedit";
		}else {
			return "longleaveedit";
		}
		
	}
	public String checkleave(){
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Leave> flg = manageService.checkleave(leave);
		if(flg.size()>0){
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("fail");
				out.flush();
				out.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}		
		return null;
	}
	
	
	public String leaveprint() {
		/*Leave leaves = manageService.loadleavebyid(leave.getId());
		ActionContext.getContext().put("leaves", leaves);
		Student student = studentService.loadstubystuid(leaves.getStuid());
		ActionContext.getContext().put("student", student);*/
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-word");
		String fileName = "LeaveApply.doc";
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("GB2312"), "8859_1"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		OutputStream out;
		
		if (leave == null || leave.getId() == null) {
			return null;
		}
		
		Leave leaves = manageService.loadleavebyid(leave.getId());
		
		Student student = studentService.loadstubystuid(leaves.getPassport());
		if (student == null || leaves == null) {
			return null;
		}
		User user = (User)ActionContext.getContext().getSession().get("user");
		Integer serial = manageService.getSerial(user, fileName, "PrintLeaveApply");
		try {
			out = response.getOutputStream();
			if (leaves.getType() == 1) { 
				TranscriptService t = new TranscriptServiceImpl();
				t.getShortLeave(out, student, leaves, serial);
			} else {
				TranscriptService t = new TranscriptServiceImpl();
				t.getLongLeave(out, student, leaves, serial);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String teachingevalution() {
		return "teachingevalution";
	}
	/* 评价 */
	public String evalutionteacher() {
		User user = (User)ActionContext.getContext().getSession().get("user");
		if (user.getRoles().getRolerank()==3) {
			List<Course> courses = classService.loadcourse();
			ActionContext.getContext().put("courselist", courses);
			Map<Integer , List<Course>> map = classService.coursemap();
			Map<Integer , Teacher> classmap = classService.teachermap();
			Student student = studentService.loadstubystuid(user.getUsernum());
			Classes cls = classService.loadclassbyid(student.getClasses().getId());
			ActionContext.getContext().put("classes", cls);
			ActionContext.getContext().put("map", map);
			ActionContext.getContext().put("classmap", classmap);
			return "evalutionteacher"; 
		}else{
			ActionContext.getContext().put("message", "您不能评价老师！");
			return "showmessage";
		}
	}

	public String evalutionlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String flag = request.getParameter("flag");
		Course courses = classService.loadcoursebynum(course.getNum());
		String semester = manageService.getCurrSemester();
		User user = (User)ActionContext.getContext().getSession().get("user");
		if(flag.equals("0")){
			List<Evalution> evalutions = manageService.loadevalution(courses.getNum(),user.getUsernum(),semester,flag);
			if (evalutions.size()>0) {
				ActionContext.getContext().put("message", "该课程您已评价，不能重复评价！");
				return "showmessage";
			}else {
				SemesterChosenCourse semesterChosenCourse = manageService.loadsemesterchosencoursebycourseid(courses.getNum());
				if(semesterChosenCourse==null){
					ActionContext.getContext().put("message", "该课程在本学期不存在，不能评价！");
					return "showmessage";
				}else{
					if(semesterChosenCourse.getTeacherid()==null){
						ActionContext.getContext().put("message", "该课程未安排教师，不能评价！");
						return "showmessage";
					}else{
						Teacher teacher = manageService.loadteacherbynum(semesterChosenCourse.getTeacherid());				
						ActionContext.getContext().put("te", teacher);
						ActionContext.getContext().put("courses", courses);
						ActionContext.getContext().put("flag", flag);
						return "evalutionlist";	
					}							
				}			
			}
		}else {
			List<Evalution> evalutions = manageService.loadevalution(course.getNum(),user.getUsernum(),semester,flag);
			if (evalutions.size()>0) {
				ActionContext.getContext().put("message", "您已评价过班主任，无需再次评价！");
				return "showmessage";
			}else {
				Teacher teacher = manageService.loadteacherbynum(course.getNum());
				if(teacher==null){
					ActionContext.getContext().put("message", "该老师不存在，不能评价！");
					return "showmessage";
				}else{								
					ActionContext.getContext().put("te", teacher);
					ActionContext.getContext().put("flag", flag);
					return "evalutionlist";	
												
				}			
			}
		}				
	}

	public String evalutionteacheradd() {
		manageService.evalutionteacheradd(evalution);
		return null;
	}

	public String loadevalution() {
		String evalutionlist = manageService.loadevalution(evalution.getCourseid());
		ActionContext.getContext().put("evalutionlist", evalutionlist);
		ActionContext.getContext().put("courseid", evalution.getCourseid());
		ActionContext.getContext().put("flag", 0);
		return "loadevalution";
	}
	
	public String evalutionanalysis(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String flag = request.getParameter("flag");
		List<Evalution> evalutionlist = new ArrayList<Evalution>();
		if (flag.equals("0")) {
			evalutionlist = manageService.loadevalutionlist(course.getNum());		    
		}else {
			evalutionlist = manageService.loadclassteacherevalutionlist(course.getNum());
		}
		if(evalutionlist.size()==0){
	    	ActionContext.getContext().put("message", "没有学生提交评价！");
	    	return "showmessage";
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
			ActionContext.getContext().put("incicators1", incicators1);
			ActionContext.getContext().put("incicators2", incicators2);
			ActionContext.getContext().put("incicators3", incicators3);
			ActionContext.getContext().put("incicators4", incicators4);
			ActionContext.getContext().put("incicators5", incicators5);
			ActionContext.getContext().put("incicators6", incicators6);
			ActionContext.getContext().put("incicators7", incicators7);
			ActionContext.getContext().put("summary", summary);
		    return "evalutionanalysis";
		}
		
	}
	
	public String allevalutionanalysis(){		
		return "allevalutionanalysis";
	}
	
	public String allEvalutionResult(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.allevalutionanalysis(page, pageSize);
		datatojson(map);
		return null;
	}
	public String classteacherevalution(){
		return "classteacherevalution";
	}
	public String classteacherevalutionmap(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.classteacherevalutionmap(page, pageSize);
		datatojson(map);
		return "classteacherevalution";
	}
	public String loadclassteacherevalution(){
		String evalutionlist = manageService.loadclassteacherevalution(evalution.getTeacher());
		ActionContext.getContext().put("evalutionlist", evalutionlist);
		ActionContext.getContext().put("courseid", evalution.getTeacher());
		ActionContext.getContext().put("flag", 1);
		return "loadevalution";
	}
	public String classteacherevalutionanalysis(){
		return "classteacherevalutionanalysis";
	}
	public String allClassteacherEvalutionResult(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.allClassteacherEvalutionResult(page, pageSize);
		datatojson(map);
		return null;
	}
   /*教师*/
	public String teacherbaseinfo(){
    	User user = (User)ActionContext.getContext().getSession().get("user"); 
    	if (user.getRoles().getRolerank()==0||user.getRoles().getRolerank()==1) {
			ActionContext.getContext().put("message", "您不能查看个人信息");
			return "showmessage";
		}else {
			Teacher teachers=manageService.loadteacherbynum(user.getUsernum()); 
	    	Dept dept = teachers.getDept(); //userService.loaddeptbyid(teachers.getDeptid());
	    	ActionContext.getContext().put("teachers", teachers);
	    	ActionContext.getContext().put("dept", dept);
	    	return "teacherbaseinfo";
		}
    	
    }

	public String teacherbegainchangeimg() {
		ActionContext.getContext().put("teacherid",teacher.getIdentificationnum());
		return "teacherchangeimg";
	}

	public String teacherchangeimg() {
		String realpath = ServletActionContext.getServletContext().getRealPath("/image/teacherimages");
		File savedir = new File(realpath);
		if (!savedir.exists())
			savedir.mkdirs();
		if (image != null) {
			String name = imageFileName.substring(imageFileName.indexOf('.'));
			if (name.toLowerCase().equals(".jpg")
					|| name.toLowerCase().equals(".gif")
					|| name.toLowerCase().equals(".bmp")
					|| name.toLowerCase().equals(".png")
					|| name.toLowerCase().equals(".jpeg")) {
				User user = (User) ActionContext.getContext().getSession()
						.get("user");
				/*
				 * if (stu.getStuimg() != null) { File file = new File(realpath+
				 * stu.getStuimg().substring(stu.getStuimg().indexOf("\\"))); if
				 * (file.exists()) { file.delete(); } }
				 */
				Teacher teacher = manageService.loadteacherbynum(user
						.getUsernum());
				String imgname = teacher.getIdentificationnum().concat(name);
				File savefile = new File(savedir, imgname);
				try {
					FileUtils.copyFile(image, savefile);
				} catch (IOException e) {

					e.printStackTrace();
				}
				manageService.teacherchangeimg("image/teacherimages" + "/"
						+ imgname);
				ActionContext.getContext().put("message", "修改成功");
			} else {
				ActionContext.getContext().put("message", "修改失败！请选择正确的图片格式");
			}
		}else {
			ActionContext.getContext().put("message", "图片不能为空，请重新上传！");
		}
		return "showmessage";
	}

	public String teacherbaseupdate() {
		Teacher teachers = manageService.loadteacherbynum(teacher
				.getIdentificationnum());
		ActionContext.getContext().put("teachers", teachers);
		List<Dept> deptlist = userService.deptlist1();
		ActionContext.getContext().put("deptlist", deptlist);
		return "teacherbaseedit";
	}
	public String teachermanage() {
		return "teachermanage";
	}
	public String teacherlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.teachermap(page, pageSize);
		datatojson(map);
		return null;
	}
	public String courseteacherlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.courseteachermap(page, pageSize);
		datatojson(map);
		return null;
	}

	public String teacheredit() {
		Teacher teachers = manageService.loadteacherbynum(teacher.getIdentificationnum());
		ActionContext.getContext().put("teachers", teachers);
		List<Dept> deptlist = userService.deptlist1();
		ActionContext.getContext().put("deptlist", deptlist);
		return "teacheredit";
	}

	public String teacherupdate() {
		manageService.teacherupdate(teacher,depid);
		return null;
	}

	public String teacherdelete() {
		manageService.teacherdelete(ids);
		User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "DeleteTeacher", ids);
		return null;
	}
	
	public String teacherRecover(){
		manageService.recoverTeacher(ids);
		return null;
	}

	public String teacherFuzzy(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
        String fuzzyText = request.getParameter("fuzzyText");
		Map<String, Object> map = manageService.teacherFuzzySearch(page,pageSize,fuzzyText);
		datatojson(map);
		return null;
	}
	
	public String teacherbatchadd() {
		return "teacherbatchadd";
	}

	public String teacherbegainadd() {
		return "teacheradd";
	}

	public String teacherendadd() {
		manageService.teacheradd(teacher, depid);
		return null;
	}

	public String teachercheck() {
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = manageService
				.teachercheck(teacher.getIdentificationnum());
		if (!flg) {
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("fail");
				out.flush();
				out.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return null;
	}

	public String teacherbeginadd() {		
		List<Dept> deptlist = userService.deptlist1();
		if(depid==null){
			ActionContext.getContext().put("deptlist", deptlist);
		}else {
			ActionContext.getContext().put("deptid", depid);
			ActionContext.getContext().put("deptlist", deptlist);
		}
		
		return "teacheradd";
	}
	
	
	public String teacherBatchRegist(){
		if (teacherBatchRegist == null){
			return null;
		}	
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));	
		@SuppressWarnings("unchecked")
		List<BatchRegiste> fail = (List<BatchRegiste>)teacherBatchRegist.get("Fail");
		Map<String, Object> toPage = new HashMap<String, Object>();
		if ((page - 1) * pageSize > fail.size())
			page = 0;
		List<BatchRegiste> toPageDat = new ArrayList<BatchRegiste>();
		if (page * pageSize > fail.size()) {
			for (BatchRegiste br : fail.subList((page - 1) * pageSize, fail.size())) {
				toPageDat.add(br);
			}
		} else {
			for (BatchRegiste br : fail.subList((page - 1) * pageSize, page * pageSize)) {
				toPageDat.add(br);
			}
		}
		
		toPage.put("Total", fail.size());
		toPage.put("Rows", toPageDat);
		datatojson(toPage);
		return null;
	}
	
	public String jmpBatchResult (){
		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
		Date dt = new Date();
		SimpleDateFormat mt2 = new SimpleDateFormat("yyMMddHHmmss");
		String s = mt2.format(dt);
		for (int i = 0; i < 3; i++) {
			Random r = new Random();
			int ran = r.nextInt(10);
			s += ran;
		}
		if (file != null) {
			File savedir = new File(realpath);
			String name = fileFileName.substring(fileFileName.indexOf('.'));
			String filename = s.concat(name);
			if (!savedir.exists())
				savedir.mkdirs();
			try {
				File savefile = new File(savedir, filename);
				FileUtils.copyFile(file, savefile);
			} catch (IOException e) {

				e.printStackTrace();
			}
			ActionContext.getContext().put("msg", " ");
			teacherBatchRegist = manageService.batchRegistTeacher(realpath + "\\" + filename);
			@SuppressWarnings("unchecked")
			List<BatchRegiste> fail = (List<BatchRegiste>)teacherBatchRegist.get("Fail");
			if (fail.size() == 0) {
				return "batchSuccess";
			}
			ActionContext.getContext().put("succeed", String.valueOf(teacherBatchRegist.get("Count")));
		} else {
			ActionContext.getContext().put("msg", "文件内容为空，添加失败！<br>退出请重新添加！");
		}
		return "batchTeacher";
	}
	
	private Map<String, Object> teacherBatchRegist = null;
	
	
	public String teacheraddbytxt() {
		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
		Date dt = new Date();
		SimpleDateFormat mt2 = new SimpleDateFormat("yyMMddHHmmss");
		String s = mt2.format(dt);
		for (int i = 0; i < 3; i++) {
			Random r = new Random();
			int ran = r.nextInt(10);
			s += ran;
		}
		if (file != null) {
			File savedir = new File(realpath);
			String name = fileFileName.substring(fileFileName.indexOf('.'));
			String filename = s.concat(name);
			if (!savedir.exists())
				savedir.mkdirs();
			try {
				File savefile = new File(savedir, filename);
				FileUtils.copyFile(file, savefile);
			} catch (IOException e) {

				e.printStackTrace();
			}
			ActionContext.getContext().put("msg", "添加成功");
			manageService.teacheraddbytxt(realpath + "\\" + filename);
		} else {
			ActionContext.getContext().put("msg", "文件内容为空，添加失败！<br>退出请重新添加！");
		}
		return "uploadmsg";
	}
	 /*考勤*/
	public String courseattendence() {
			String coursecredit = "{\"Coursecredit\":" + "\"" + 1 + "\"}" + ","
					+ "{\"Coursecredit\":" + "\"" + 2 + "\"}" + ","
					+ "{\"Coursecredit\":" + "\"" + 3 + "\"}" + ","
					+ "{\"Coursecredit\":" + "\"" + 4 + "\"}" + ","
					+ "{\"Coursecredit\":" + "\"" + 5 + "\"}" + ","
					+ "{\"Coursecredit\":" + "\"" + 6 + "\"}" + ","
					+ "{\"Coursecredit\":" + "\"" + 7 + "\"}";
			String char1 = "必修", char2 = "限选", char3 = "任选";
			String character = "{\"Coursecharacter\":" + "\"" + char1 + "\"}" + ","
					+ "{\"Coursecharacter\":" + "\"" + char2 + "\"}" + ","
					+ "{\"Coursecharacter\":" + "\"" + char3 + "\"}";
			String s1 = "集中式ʽ", s2 = "非集中式";
			String checkway = "{\"Coursecheckway\":" + "\"" + s1 + "\"}" + ","
					+ "{\"Coursecheckway\":" + "\"" + s2 + "\"}";
			ActionContext.getContext().put("coursecredit", coursecredit);
			ActionContext.getContext().put("character", character);
			ActionContext.getContext().put("checkway", checkway);
			return "courseattendence";
		}
	public String courseclasslist() {
		String classlist = classService.courseclasslist(course.getNum());
		ActionContext.getContext().put("classlist", classlist);
		ActionContext.getContext().put("course", course);
		return "courseclasslist";
	}

	public String courseclassstulist() {
		//String classlist = classService.classlist();
		String studentlist = studentService.studentlist(cls.getId());
		//ActionContext.getContext().put("classlist", classlist);
		ActionContext.getContext().put("course", course);
		ActionContext.getContext().put("classid", cls.getId());
		ActionContext.getContext().put("studentlist", studentlist);
		return "courseclassstulist";

	}

	public String stuattendenceadd() {
		manageService.stuattendenceadd(attendence, ids);
		return null;
	}

	public String tabcourseattendenceload() {
		ActionContext.getContext().put("courseid", course.getNum());
		return "tabcourseattendenceload";
	}

	public String courseattendenceload() {
		List<Classes> classlist = classService.loadclass();
		ActionContext.getContext().put("classlist", classlist);
		manageService.loadattendence(course.getNum());
		ActionContext.getContext().put("coursenum", course.getNum());
		//String attendencelist = manageService.loadattendencelist(course.getNum());
		//ActionContext.getContext().put("attendencelist", attendencelist);
		return "courseattendenceload";
	}
	public String searchcourseattendencelist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.searchcourseattendencelist(page,pageSize);
		datatojson(map);
		return null;
	}
    
	public String searchattendencelistmap() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String time = request.getParameter("time");
		String type = request.getParameter("type");
		Map<String, Object> map = manageService.searchcourseattendencelistmap(page,pageSize,semChosenCourse.getCoursenum(),cls.getId(),stu.getStuid(),startdate,enddate,time,type);
		datatojson(map);
		return null;
	}
	public String courseattendencesearch() {
		String attendencelist = manageService.courseattendencesearch(attendence);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.write(attendencelist);
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	public String courseattendencestatistical() {
		List<Attendence> attendences = manageService.loadattendencebycourseid(course.getNum());		
		return "courseattendencestatistical";
	}

	public String courseattendenceclass(){
		String classlist = classService.courseclasslist(course.getNum());
		ActionContext.getContext().put("classlist", classlist);
		ActionContext.getContext().put("course", course);
		return "courseattendenceclass";
	}
	
	public String courseclassstustatistical(){
		List<Attendence> attendences = manageService.courseattendencelist(cls.getId(),course.getNum());
		ActionContext.getContext().put("classid", cls.getId());
		ActionContext.getContext().put("coursenum", course.getNum());
		return "courseattendencestatistical";
	}
	
	public String attendencestatistical(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.attendencestatistical(page,pageSize);
		datatojson(map);
		return null;
	}
	public String singlecourseattendencestatistical(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		Map<String, Object> map = manageService.singlecourseattendencestatistical(page,pageSize,course.getNum(),cls.getId(),startdate,enddate);
		datatojson(map);
		return null;
	}
	
	public String personattendence() {
		List<Course> courses = manageService.loadstucourse();
		ActionContext.getContext().put("courselist", courses);
		return "personattendence";
	}

	public String personattendencelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.personattendencelistmap(page,pageSize);
		datatojson(map);
		return null;
	}

	public String stuattendenceresearch() {
		manageService.searchstuattendence(attendence);
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.stuattendencelistmap(page,
				pageSize);
		datatojson(map);
		return null;
	}

	public String stuattendenceresearch1() {
		List<Attendence> attendences = manageService
				.searchstuattendence(attendence);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		StringBuffer strb = new StringBuffer();
		strb.append("<table id='data-table' class='data-table' >");
		strb.append("<thead>");
		strb.append("<tr>");
		strb.append("<td>" + "日期" + "</td>");
		strb.append("<td>" + "姓名" + "</td>");
		strb.append("<td>" + "班级" + "</td>");
		strb.append("<td>" + "考勤状态" + "</td>");
		strb.append("<td widt='50'>" + "备注" + "</td>");
		strb.append("</tr>");
		strb.append("</thead>");
		strb.append("<tbody id='table2'>");
		for (int i = 0; i < attendences.size(); i++) {
			Student student = studentService.loadstubystuid(attendences.get(i).getPassport());
			if (attendences.get(i).getType().equals(String.valueOf(0))) {
				strb.append("<tr>");
				strb.append("<td>" + attendences.get(i).getDate() + "</td>");
				strb.append("<td>" + student.getStuname() + "</td>");
				strb.append("<td>" + student.getClasses().getClassname()
						+ "</td>");
				strb.append("<td>" + "正常" + "</td>");
				strb.append("<td>" + "</td>");
				strb.append("</tr>");
			} else if (attendences.get(i).getType().equals(String.valueOf(1))) {
				strb.append("<tr style='color:orange;'>");
				strb.append("<td>" + attendences.get(i).getDate() + "</td>");
				strb.append("<td>" + student.getStuname() + "</td>");
				strb.append("<td>" + student.getClasses().getClassname()
						+ "</td>");
				strb.append("<td>" + "迟到" + "</td>");
				strb.append("<td>" + "</td>");
				strb.append("</tr>");
			} else if (attendences.get(i).getType().equals(String.valueOf(2))) {
				strb.append("<tr style='color:blue;'>");
				strb.append("<td>" + attendences.get(i).getDate() + "</td>");
				strb.append("<td>" + student.getStuname() + "</td>");
				strb.append("<td>" + student.getClasses().getClassname()
						+ "</td>");
				strb.append("<td>" + "早退" + "</td>");
				strb.append("<td>" + "</td>");
				strb.append("</tr>");
			} else if (attendences.get(i).getType().equals(String.valueOf(3))) {
				strb.append("<tr style='color:red;'>");
				strb.append("<td>" + attendences.get(i).getDate() + "</td>");
				strb.append("<td>" + student.getStuname() + "</td>");
				strb.append("<td>" + student.getClasses().getClassname()
						+ "</td>");
				strb.append("<td>" + "旷课" + "</td>");
				strb.append("<td>" + "</td>");
				strb.append("</tr>");
			}

		}
		strb.append("</tbody>");
		strb.append("</table>");
		try {
			PrintWriter out = response.getWriter();
			out.write(strb.toString());
			out.flush(); 
			out.close(); 
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}

	

	public String attendencestulist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.attendencestulistmap(page,pageSize);
		datatojson(map);
		return null;
	}
	public String allattendencelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.allattendencelistmap(page,pageSize);
		datatojson(map);
		return null;
	}

	public String searchattendencelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		Map<String, Object> map = manageService.searchattendencelistmap(page,pageSize,semChosenCourse.getCoursenum(),cls.getId(),stu.getStuid(),startdate,enddate);
		datatojson(map);
		return null;
	}
	
	public String scoremanagement() {
		return "scorecourselist";
	}

	public String graduatemanagement() {
		String classlist = classService.classlist();
		ActionContext.getContext().put("classlist", classlist);
		return "graduatemanagement";
	}

	public String scholarmanagement() {
		return "scholarmanagement";
	}

	public String announcement() {
		return "announcement";
	}

	public String announcementbegainadd() {
		return "announcementbegainadd";
	}

	public String announcementendadd() {
		manageService.announcementadd(announcement);
		return null;
	}

	public String announcementedit() {
		Announcement announcements = manageService.loadannouncement(announcement.getId());
		ActionContext.getContext().put("announcements", announcements);
		return "announcementedit";
	}

	public String announcementupdate() {
		manageService.announcementupdate(announcement);
		return null;
	}

	public String announcementdelete() {
		manageService.announcementdelete(ids);
		return null;
	}

	public String announcementlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.announcementmap(page, pageSize);
		datatojson(map);
		return null;
	}

	public String paymanagement() {
		return "paymanagement";
	}

	public String justicelist() {
		// List<Certify1> justicelList = manageService.loadjusticellist();
		// ActionContext.getContext().put("justicellist", justicelList);
		String justicellist = manageService.loadjusticel();
		ActionContext.getContext().put("justicellist", justicellist);
		return "justicelist";
	}

	public String justicelmanage() {
		String justicellist = manageService.loadjusticel();
		ActionContext.getContext().put("justicellist", justicellist);
		return "justicelmanages";
	}

	public String justicellist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.justicellist(page, pageSize);
		datatojson(map);
		return null;
	}
	
	public String justicelbegainadd() {
		return "justicelbegainadd";
	}

	public String justicelendadd() {
		String realpath = ServletActionContext.getServletContext().getRealPath("/filepath");
		// String saveUrl = ServletActionContext.getRequest().getContextPath() +
		// "/filepath/";
		Date dt = new Date();
		SimpleDateFormat mt1 = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		SimpleDateFormat mt2 = new SimpleDateFormat("yyMMddHHmmss");
		certify.setCreatedtime(mt1.format(dt));
		String s = mt2.format(dt);
		for (int i = 0; i < 3; i++) {
			Random r = new Random();
			int ran = r.nextInt(10);
			s += ran;
		}
		if (file != null) {
			File savedir = new File(realpath);
			String name = fileFileName.substring(fileFileName.indexOf('.'));
			String filename = s.concat(name);
			if (!savedir.exists())
				savedir.mkdirs();
			try {
				File savefile = new File(savedir, filename);
				FileUtils.copyFile(file, savefile);
			} catch (IOException e) {

				e.printStackTrace();
			}
			String fileplace = "filepath/" + filename;
			certify.setFileplace(fileplace);
			manageService.justiceladd(certify);
			ActionContext.getContext().put("msg", "添加成功！");
		} else {
			ActionContext.getContext().put("msg", "文件内容为空，添加失败！<br>退出请重新添加！");
		}
		return "uploadmsg";
	}

	public String justiceledit() {
		Certify1 certify1 = manageService.loadjusticelbyid(certify.getId());
		ActionContext.getContext().put("certify1", certify1);
		return "justicelupdate";
	}

	public String justicelupdate() {
		String realpath = ServletActionContext.getServletContext().getRealPath("/filepath");
		Date dt = new Date();
		SimpleDateFormat mt1 = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		SimpleDateFormat mt2 = new SimpleDateFormat("yyMMddHHmmss");
		certify.setCreatedtime(mt1.format(dt));
		String s = mt2.format(dt);
		for (int i = 0; i < 3; i++) {
			Random r = new Random();
			int ran = r.nextInt(10);
			s += ran;
		}
		Certify1 certify1 = manageService.loadcertifybyid(certify.getId());
		if (file != null) {
			String oldfile = ServletActionContext.getServletContext().getRealPath("/")+certify1.getFileplace();
			oldfile = oldfile.replace("/", "\\");
			File oldfiles = new File(oldfile);
			if(oldfiles.exists()){
				boolean b = oldfiles.delete();
			}
			File savedir = new File(realpath);
			String name = fileFileName.substring(fileFileName.indexOf('.'));
			String filename = s.concat(name);
			if (!savedir.exists())
				savedir.mkdirs();
			try {
				File savefile = new File(savedir, filename);
				FileUtils.copyFile(file, savefile);
			} catch (IOException e) {

				e.printStackTrace();
			}
			String fileplace = "filepath/" + filename;
			certify.setFileplace(fileplace);
			manageService.justicelupdate(certify);
			ActionContext.getContext().put("msg", "添加成功！");
		} else {
			ActionContext.getContext().put("msg", "文件内容为空，添加失败！<br>退出请重新添加！");
		}
		return "uploadmsg";
	}

	public String justiceldelete() {
		manageService.justiceldelete(ids);
		return null;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public String choosecourse() {
		return "choosecourse";
	}

	public String scoreentry() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String flag = request.getParameter("flag");
		String classlist = classService.courseclasslist(course.getNum());
		ActionContext.getContext().put("semester",semChosenCourse.getSemester());
		ActionContext.getContext().put("coursenum", course.getNum());
		ActionContext.getContext().put("classlist", classlist);
		ActionContext.getContext().put("flag", flag);
		return "scoreentry";
	}

	public String makeupscoreentry() {
		ActionContext.getContext().put("semester",semChosenCourse.getSemester());
		ActionContext.getContext().put("coursenum", course.getNum());
		manageService.loadcoursemakeup(semChosenCourse.getSemester(),course.getNum());
		return "makescoreentry";
	}
	public String makeupstulist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.makeuplist(page, pageSize);
		datatojson(map);
		return null;
	}
	
	public String loadcoursescore() {
		String classlist = classService.courseclasslist(course.getNum());
		ActionContext.getContext().put("classlist", classlist);
		ActionContext.getContext().put("seme",semChosenCourse.getSemester());
		ActionContext.getContext().put("coursenum", course.getNum());
		return "loadcoursescore";
	}

	public String courseclassscoreadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String flag = request.getParameter("flag");
		ActionContext.getContext().put("semester",semChosenCourse.getSemester());
		ActionContext.getContext().put("coursenum", course.getNum());
		ActionContext.getContext().put("classid", cls.getId());
		ActionContext.getContext().put("flag", flag);
		List<ChosenCourse> chosenCourses = manageService.courseclassscoreload(semChosenCourse.getSemester(),course.getNum(), cls.getId());
		return "courseclassscore";
	}

	public String stuscorelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.stuscorelist(page, pageSize);
		datatojson(map);
		return null;
	}

	public String allstuscorelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.allstuscorelist(page, pageSize);
		datatojson(map);
		return null;
	}

	public String courseclassscorebegainadd() {
		ActionContext.getContext().put("semester",semChosenCourse.getSemester());
		ActionContext.getContext().put("coursenum", course.getNum());
		ActionContext.getContext().put("classid", cls.getId());
		Student student = studentService.loadstubystuid(stu.getPassport());
		ChosenCourse cho = manageService.loadchosencourse(stu.getPassport(),semChosenCourse.getSemester(),course.getNum());
		ActionContext.getContext().put("student", student);
		ActionContext.getContext().put("cho", cho);
		return "courseclassscorebegainadd";
	}

	public String courseclassmakeupscorebegainadd() {
		ActionContext.getContext().put("semester",semChosenCourse.getSemester());
		ActionContext.getContext().put("coursenum", course.getNum());
		//ActionContext.getContext().put("classid", cls.getId());
		Student student = studentService.loadstubystuid(stu.getPassport());
		ActionContext.getContext().put("student", student);
		return "courseclassmakeupscorebegainadd";
	}

	public String courseclassscoreendadd() {
		manageService.courseclassscoreadd(chosenCourse);
		return null;
	}

	public String courseclassmakeupscoreendadd() {
		manageService.courseclassmakeupscoreadd(chosenCourse);
		return null;
	}

	public String courseclassscoreload() {
		ActionContext.getContext().put("semester",semChosenCourse.getSemester());
		ActionContext.getContext().put("coursenum", course.getNum());
		ActionContext.getContext().put("clsid", cls.getId());
		manageService.courseclassscoreload(semChosenCourse.getSemester(),course.getNum(), cls.getId());
		return "courseclassscoreload";
	}

	public String stuscoreload() {
		List<Classes> classlist = classService.loadclass();
		List<Course> courselist = manageService.loadcourselist();
		ActionContext.getContext().put("classlist", classlist);
		ActionContext.getContext().put("courselist", courselist);
		return "stuscoreload";
	}
	
	private void toJson2(List<InfoBean> dat) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		Gson gson = new Gson();		
		String json = "{}";
		try {
			json = gson.toJson(dat);
		} catch (IllegalStateException e){
			e.printStackTrace();
		}
		//System.out.println(json);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String courseNameList() {
		if (semester == null)
			semester = manageService.getCurrSemester();
		List<ChosenCourseModel> lessons = manageService.loadAllChosenCourse2(semester);		
		Set<String> flag = new HashSet<String>();
		
		List<InfoBean> toPage = new ArrayList<InfoBean>();
		if (lessons==null) {
			return null;
		}
		for (ChosenCourseModel i : lessons){
			if (i.getCourse() != null) {
				String tnum = String.valueOf(i.getCourse().getNum());
				if (flag.contains(tnum))
					continue;
				InfoBean t = new InfoBean();
				t.setCourseName(i.getCourse().getCoursename());
				t.setNum(i.getCourse().getNum());
				toPage.add(t);
				flag.add(tnum);
			}
		}
		toJson2 (toPage);
		return null;
	}

	public String courseclassscoredownload() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String semester = request.getParameter("semester");
		String coursenum = request.getParameter("coursenum");
		String classid = request.getParameter("classid");
		List<ChosenCourse> chosencourse = manageService.courseclassscoreload(semester, coursenum, Integer.valueOf(classid));
		response.reset();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel");
		Course courses = classService.loadcoursebynum(coursenum);
		String fileName = courses.getCoursename()+"学生成绩.xls";
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GB2312"), "8859_1"));
		OutputStream out = response.getOutputStream();
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(out);
			WritableSheet ws = workbook.createSheet(courses.getCoursename()+"学生成绩", 0);
			WritableFont wf = new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);// 设置字体格式
			WritableCellFormat wef = new WritableCellFormat(wf);// 创建格式化对象实例
			wef.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);// 垂直居中
			wef.setAlignment(Alignment.CENTRE);// 水平居中
			// 工作表标题行（new Label（列，行，内容，格式））
			ws.addCell(new Label(0, 0, "学期", wef));
			ws.addCell(new Label(1, 0, "课程名", wef));
			ws.addCell(new Label(2, 0, "护照号", wef));
			ws.addCell(new Label(3, 0, "姓名", wef));
			ws.addCell(new Label(4, 0, "平时成绩", wef));
			ws.addCell(new Label(5, 0, "考勤成绩", wef));
			ws.addCell(new Label(6, 0, "期中成绩", wef));
			ws.addCell(new Label(7, 0, "期末成绩", wef));
			ws.addCell(new Label(8, 0, "总成绩", wef));
			ws.addCell(new Label(9, 0, "补考成绩", wef));
			List<Object[]> dataList = new ArrayList<Object[]>();
			
			for (ChosenCourse temp : chosencourse) {
				Student student = studentService.loadstubystuid(String.valueOf(temp.getPassport()));
				Course course = classService.loadcoursebynum(temp.getCourseId());
				String seme = temp.getSemester();
				String semesters = "";
				if(seme.substring(4,6).equals("01")){
					semesters = seme.substring(0,4)+"-"+String.valueOf(Integer.valueOf(seme.substring(0,4))+1)+"学年第一学期";
				}else {
					semesters = String.valueOf(Integer.valueOf(seme.substring(0,4))-1)+"-"+seme.substring(0,4)+"学年第二学期";
				}
				Object[] stu = {semesters,course.getCoursename(),student.getPassport(),student.getStuname(),temp.getHomework(),temp.getAttendence(),temp.getMidexam(),temp.getFinalexam(),temp.getSummary(),temp.getMakeup() };
				dataList.add(stu);
			}
			// //向工作表添加数据
			for (int i = 0; i < dataList.size(); i++) {
				for (int j = 0; j < dataList.get(i).length; j++) {
					Object o = dataList.get(i)[j];
					if (o != null) {
						Label label = new jxl.write.Label(j, i + 1, o.toString(), wef);
						ws.addCell(label);
					}
				}
			}
			workbook.write();
			workbook.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String classattendencedownload() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");		
		List<Attendence> attendences = manageService.courseattendencelist(cls.getId(),course.getNum());
		if (startdate.length()!=0&&enddate.length()!=0) {
			for(int i=0;i<attendences.size();i++){
				SimpleDateFormat dt = new SimpleDateFormat("yy-MM-dd");
				Date StartDate=null, EndDate=null,nowDate=null;
				try {
					StartDate= dt.parse(startdate);
					EndDate = dt.parse(enddate);
				    nowDate = dt.parse(attendences.get(i).getDate());
				} catch (ParseException e) {
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
		response.reset();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel");
		Course courses = classService.loadcoursebynum(course.getNum());
		String fileName = courses.getCoursename()+"学生考勤记录.xls";
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GB2312"), "8859_1"));
		OutputStream out = response.getOutputStream();
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(out);
			WritableSheet ws = workbook.createSheet(courses.getCoursename()+"学生考勤记录", 0);
			WritableFont wf = new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);// 设置字体格式
			WritableCellFormat wef = new WritableCellFormat(wf);// 创建格式化对象实例
			wef.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);// 垂直居中
			wef.setAlignment(Alignment.CENTRE);// 水平居中
			// 工作表标题行（new Label（列，行，内容，格式））			
			ws.addCell(new Label(0, 0, "护照号", wef));
			ws.addCell(new Label(1, 0, "中文名", wef));
			ws.addCell(new Label(2, 0, "正常", wef));
			ws.addCell(new Label(3, 0, "迟到", wef));
			ws.addCell(new Label(4, 0, "早退", wef));
			ws.addCell(new Label(5, 0, "旷课", wef));	
			ws.addCell(new Label(6, 0, "缺勤率（%）", wef));
			ws.addCell(new Label(7, 0, "班级", wef));
			List<Object[]> dataList = new ArrayList<Object[]>();
			List<Student> students = classService.loadstubyclassid(cls.getId());
				
			for (Student temp : students) {
				Integer normal = 0,late=0,leaveearly=0,truancy=0;	
				for (Attendence a:attendences) {
					if(temp.getPassport().equals(a.getPassport())){
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
				double probability = 0;
			    double truancys = (double)truancy;
			    double credits = courses.getCredits()*16;
			    if (truancys==0) {
					probability=0;
				}else {
					probability = Math.round(truancys/credits*1000)/100.0;
				}
			    Object[] stu = {temp.getPassport(),temp.getStuname(),normal,late,leaveearly,truancy,probability*10,temp.getClasses().getClassname()};
				dataList.add(stu);
			}
			// //向工作表添加数据
			for (int i = 0; i < dataList.size(); i++) {
				for (int j = 0; j < dataList.get(i).length; j++) {
					Object o = dataList.get(i)[j];
					if (o != null) {
						Label label = new jxl.write.Label(j, i + 1, o.toString(), wef);
						ws.addCell(label);
					}
				}
			}
			workbook.write();
			workbook.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String courseclassscoreprint(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String semester = request.getParameter("semester");
		String coursenum = request.getParameter("coursenum");
		String classid = request.getParameter("classid");
		List<ChosenCourse> chosencourse = manageService.courseclassscoreload(semester, coursenum, Integer.valueOf(classid));
		List<ChosenCourseModel> models = new ArrayList<ChosenCourseModel>();
		for(ChosenCourse c:chosencourse){
			Student student = studentService.loadstubystuid(c.getPassport());
			Course course = classService.loadcoursebynum(c.getCourseId());
			ChosenCourseModel m = new ChosenCourseModel();
			m.setSemester(c.getSemester());
			m.setCourse(new CourseModel(course));
			m.setPassport(c.getPassport());
			m.setStuname(student.getStuname());
			m.setHomework(c.getHomework());
			m.setAttendence(c.getAttendence());
			if(c.getMidexam()==null){
				m.setMidexam("");
			}else{
				m.setMidexam(String.valueOf(c.getMidexam()));
			}
			if(c.getFinalexam()==null){
				m.setFinalexam("");
			}else{
				m.setFinalexam(String.valueOf(c.getFinalexam()));
			}
			//m.setFinalexam(String.valueOf(c.getFinalexam()));
			m.setSummary(String.valueOf(c.getSummary()));
			m.setMakeup(String.valueOf(c.getMakeup()));
			models.add(m);
		}
		ActionContext.getContext().put("scoremodel", models);
		return "courseclassscoreprint";
	}
	public String makeupexamination() {
		return "makeupexamination";
	}

	public String setsummary(){
		ActionContext.getContext().put("semester",semChosenCourse.getSemester());
		ActionContext.getContext().put("coursenum", course.getNum());
		ActionContext.getContext().put("clsid", cls.getId());
		return "setsummary";
	}
	public String coursesummarydone(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String semester = request.getParameter("semester");
		String coursenum = request.getParameter("coursenum");
		String classid  = request.getParameter("classid");
		//manageService.coursesummarydone(chosenCourse , semester,coursenum,classid);
		//chosenCourse.setSemester(semester);
		//chosenCourse.setCourseId(Integer.valueOf(coursenum));
		//List<ChosenCourse> list = new ArrayList<ChosenCourse>();
		//list.add(chosenCourse);
		List<String> arrayList = new ArrayList<String>();
		//arrayList.add(semester);
		//arrayList.add(coursenum);
		arrayList.add(chosenCourse.getAttendence());
		arrayList.add(chosenCourse.getHomework());
		arrayList.add(String.valueOf(chosenCourse.getMidexam()));
		arrayList.add(String.valueOf(chosenCourse.getFinalexam()));
		String realpath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/ScoreSet");		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(realpath+"/"+semester+coursenum+"scoreset.dat"));
			out.writeObject(arrayList);
			out.flush();
			out.close();
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			}		
		return null;
	}
	/*
	 * public String stuclassscorelist(){ HttpServletRequest request =
	 * ServletActionContext.getRequest(); int page =
	 * Integer.parseInt(request.getParameter("page")); int pageSize =
	 * Integer.parseInt(request.getParameter("pagesize")); Map<String, Object>
	 * map = manageService.stuclassscorelist(page, pageSize); datatojson(map);
	 * return null; }
	 */
	public String singlestuscorelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.singlestuscorelist(page,pageSize);
		datatojson(map);
		return null;
	}

	public String searchsinglestuscorelist() {		
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		String coursenum = request.getParameter("coursenum");
		manageService.loadsinglestuscore(semChosenCourse.getSemester(),coursenum);
		Map<String, Object> map = manageService.searchsinglestuscorelist(page,pageSize);
		datatojson(map);
		return null;
	}

	public String searchstuscorelist() {
		manageService.loadstuscore(semChosenCourse.getSemester(), cls.getId(),stu.getPassport(),semChosenCourse.getCoursenum());
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.searchstuscorelist(page,pageSize);
		datatojson(map);
		return null;
	}

	public String scoreload() {
		User user = (User)ActionContext.getContext().getSession().get("user");
		String semester =manageService.getCurrSemester();
		List<Course> courses = manageService.loadcoursebysemester(user.getUsernum(),semester);
		ActionContext.getContext().put("courselist", courses);
		return "scoreload";
	}

	public String stucourseNameList() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		if (semester == null)
			semester = manageService.getCurrSemester();
		User user = (User)ActionContext.getContext().getSession().get("user");
		List<Course> courses = manageService.loadcoursebysemester(user.getUsernum(), semester);
		Gson gson = new Gson();
		String json = gson.toJson(courses);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	private String success (){
		String coursecredit = "{\"Coursecredit\":" + "\"" + 1 + "\"}" + ","+ "{\"Coursecredit\":" + "\"" + 2 + "\"}" + ","
				+ "{\"Coursecredit\":" + "\"" + 3 + "\"}" + ","+ "{\"Coursecredit\":" + "\"" + 4 + "\"}" + ","+ "{\"Coursecredit\":" + "\"" + 5 + "\"}" + ","
				+ "{\"Coursecredit\":" + "\"" + 6 + "\"}" + ","+ "{\"Coursecredit\":" + "\"" + 7 + "\"}";
		String char1 = "必修", char2 = "限选", char3 = "任选";
		String character = "{\"Coursecharacter\":" + "\"" + char1 + "\"}" + ","+ "{\"Coursecharacter\":" + "\"" + char2 + "\"}" + ","+ "{\"Coursecharacter\":" + "\"" + char3 + "\"}";
		String s1 = "集中式", s2 = "非集中式";
		String checkway = "{\"Coursecheckway\":" + "\"" + s1 + "\"}" + ","+ "{\"Coursecheckway\":" + "\"" + s2 + "\"}";
		ActionContext.getContext().put("coursecredit", coursecredit);
		ActionContext.getContext().put("character", character);
		ActionContext.getContext().put("checkway", checkway);
		return "arrangecourse";
	}
	
	public String arrangecourse() {
		ca = null;
		manualCoruses = null;
		manualRooms = null;
		return success();
	}
	
	// 用于为选修课腾出时间
	private List<Integer> electiveSlot = null;
	public String chkRooms() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String emptyslot = request.getParameter("setemptyslot");
		if (emptyslot != "") {
			electiveSlot = new ArrayList<Integer>();
			for (String s : emptyslot.split(",")){
				electiveSlot.add(Integer.parseInt(s));
			}
		}
		//System.out.println(emptyslot);
		ActionContext.getContext().put("semester",semChosenCourse.getSemester());
		List<Classroom> classrooms = classService.loadclassroombyisavaible();
		for(Classroom c:classrooms){
			manageService.semesterroombegainadd(c, semChosenCourse.getSemester());
		}
		return "chkRooms";
	}

	public String arrange() {
		return "arranged";
	}
	public String jmpManualInsert (){
		String coursecredit = "{\"Coursecredit\":" + "\"" + 1 + "\"}" + "," + "{\"Coursecredit\":" + "\"" + 2 + "\"}" + "," + "{\"Coursecredit\":" + "\"" + 3 + "\"}" + "," + "{\"Coursecredit\":" + "\"" + 4 + "\"}" + "," + "{\"Coursecredit\":" + "\""
				+ 5 + "\"}" + "," + "{\"Coursecredit\":" + "\"" + 6 + "\"}" + "," + "{\"Coursecredit\":" + "\"" + 7 + "\"}";
		String char1 = "必修", char2 = "限选", char3 = "任选";
		String character = "{\"Coursecharacter\":" + "\"" + char1 + "\"}" + ","
				+ "{\"Coursecharacter\":" + "\"" + char2 + "\"}" + ","
				+ "{\"Coursecharacter\":" + "\"" + char3 + "\"}";
		String s1 = "集中式", s2 = "非集中式";
		String checkway = "{\"Coursecheckway\":" + "\"" + s1 + "\"}" + "," + "{\"Coursecheckway\":" + "\"" + s2 + "\"}";
		ActionContext.getContext().put("coursecredit", coursecredit);
		ActionContext.getContext().put("character", character);
		ActionContext.getContext().put("checkway", checkway);
		return "JmpManualAdjust";
	}
	
	
	private List<ChosenCourseModel> manualCoruses = null;
	private List<ClassroomModel> manualRooms = null;
	
	public String insertIntoSyllabus() {
		//insertID
		ChosenCourseModel change = null;
		for (ChosenCourseModel c : manualCoruses) {
			if (c.getSemesterId().equals(insertID)){
				change = c;
				break;
			}
		}
		if (oldSlot == null || oldRoomNum == null || origndate == null || change == null)
			return null;
		
		change.setSlot(Integer.parseInt(oldSlot));
		change.setWeekday(Integer.parseInt(origndate));
		change.setRoom(manualRooms.get(Integer.parseInt(oldRoomNum)));
		
		return null;
	}
	
	public String removeSyllabus() {
		//insertID
		ChosenCourseModel change = null;
		for (ChosenCourseModel c : manualCoruses) {
			if (c.getNum().equals(insertID)){
				change = c;
				break;
			}
		}
		if (change == null)
			return null;
		
		change.setSlot(null);
		change.setWeekday(null);
		change.setRoom(null);
		
		return null;
	}
	
	
	public String semesterFuzzy(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		try {
			newnum = java.net.URLDecoder.decode(newnum, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<Syllabus> toPage = new ArrayList<Syllabus>();
		List<ChosenCourseModel> ret = new ArrayList<ChosenCourseModel>();
		for (ChosenCourseModel c : manualCoruses){
			if (c.getCourse().getCoursename() != null && c.getCourse().getCoursename().indexOf(newnum) != -1) {
				ret.add(c);
			} else if (c.getCourse().getNum() != null && String.valueOf(c.getCourse().getNum()).indexOf(newnum) != -1) {
				ret.add(c);
			} else if (c.getTeacher().getTeachername() != null && c.getTeacher().getTeachername().indexOf(newnum) != -1) {
				ret.add(c);
			} else if (c.getClasses() != null){
				for (ClassesModel p : c.getClasses()){
					if (p.getClassname().indexOf(newnum) != -1){
						ret.add(c);
						break;
					}
						
				}
			}
		}
		
		if ((page - 1) * pageSize > ret.size())
			page = 1;
		if (page * pageSize > ret.size()) {
			for (ChosenCourseModel c : ret.subList((page - 1) * pageSize, ret.size())){
				Syllabus s = new Syllabus(c);
				s.setNum(String.valueOf(c.getCourse().getNum()));
				String name = "";
				for (ClassesModel i : c.getClasses()) {
					name += i.getClassname() + "\n";
				}
				if (c.getSlot() == null || c.getSlot() < 0) {
					s.setSlot(null);
					s.setDay(null);
				} else {
					s.setSlot(c.getSlot() + 1);
					s.setDay(c.getWeekday() + 1);
					if (c.getRoom() != null)
						s.setRoomNum(c.getRoom().getAddress());
				}
				s.setClassName(name);
				s.setNote(c.getNum());
				s.setId(c.getSemesterId());
				toPage.add(s);
			}
		} else {
			for (ChosenCourseModel c : ret.subList((page - 1) * pageSize, page * pageSize)){
				Syllabus s = new Syllabus(c);
				s.setNum(String.valueOf(c.getCourse().getNum()));
				String name = "";
				for (ClassesModel i : c.getClasses()) {
					name += i.getClassname() + "\n";
				}
				if (c.getSlot() == null || c.getSlot() < 0) {
					s.setSlot(null);
					s.setDay(null);
				} else {
					s.setSlot(c.getSlot() + 1);
					s.setDay(c.getWeekday() + 1);
					if (c.getRoom() != null)
						s.setRoomNum(c.getRoom().getAddress());
				}
				s.setClassName(name);
				s.setNote(c.getNum());
				s.setId(c.getSemesterId());
				toPage.add(s);
			}
		}
		map.put("Total", ret.size());
		map.put("Rows", toPage);
		
		datatojson(map);
		return null;
	}
	
	public String semesterChosenDat (){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<ChosenCourseModel> part = new ArrayList<ChosenCourseModel>();
		
		for (ChosenCourseModel i : manualCoruses){
			if (i.getSlot() == null || i.getSlot() == -1){
				part.add(i);
			}
		}
		
		map.put("Total", part.size());
		
		List<Syllabus> toPage = new ArrayList<Syllabus>();
		if ((page - 1) * pageSize > part.size())
			page = 1;
		if (page * pageSize > part.size()) {
			for (ChosenCourseModel c : part.subList((page - 1) * pageSize, part.size())){
				Syllabus s = new Syllabus(c);
				s.setNum(String.valueOf(c.getCourse().getNum()));
				String name = "";
				for (ClassesModel i : c.getClasses()) {
					name += i.getClassname() + "\n";
				}
				if (c.getSlot() == null || c.getSlot() < 0) {
					s.setSlot(null);
					s.setDay(null);
				} else {
					s.setSlot(c.getSlot() + 1);
					s.setDay(c.getWeekday() + 1);
					if (c.getRoom() != null)
						s.setRoomNum(c.getRoom().getAddress());
				}
				s.setClassName(name);
				s.setNote(c.getNum());
				s.setId(c.getSemesterId());
				toPage.add(s);
			}
		} else {
			for (ChosenCourseModel c : part.subList((page - 1) * pageSize, page * pageSize)){
				try{
					Syllabus s = new Syllabus(c);
					s.setNum(String.valueOf(c.getCourse().getNum()));
					String name = "";
					for (ClassesModel i : c.getClasses()) {
						name += i.getClassname() + "\n";
					}
					if (c.getSlot() == null || c.getSlot() < 0) {
						s.setSlot(null);
						s.setDay(null);
					} else {
						s.setSlot(c.getSlot() + 1);
						s.setDay(c.getWeekday() + 1);
						if (c.getRoom() != null)
							s.setRoomNum(c.getRoom().getAddress());
					}
					s.setClassName(name);
					s.setNote(c.getNum());
					s.setId(c.getSemesterId());
					toPage.add(s);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		map.put("Rows", toPage);
		
		datatojson(map);
		return null;
	}
	
	private String perSyllabus2 (){
		String semester = manageService.getCurrSemester();
		List<ClassroomModel> rooms = manageService.getAllAvlRooms(semester);
		List<String> roomOrder = new ArrayList<String>();
		for (ClassroomModel r : rooms)
			roomOrder.add(String.valueOf(r.getNum()));
		List<Syllabus> arranged = new ArrayList<Syllabus>();
		List<ChosenCourseModel> all = manageService.getAllChosenCourse(semester);
		boolean isFind = false;
		for (int day = 0; day < 5; ++day)
			for (int slot = 0; slot < 5; ++slot)
				for (String r : roomOrder) {
					isFind = false;
					for (ChosenCourseModel p : all){
						if (p.getRoom() == null)
							continue;
						if (p.getWeekday() == day && p.getSlot() == slot && p.getRoom().getNum().equals(r)){
							arranged.add(new Syllabus(p));
							isFind = true;
							break;
						}
					}
					if (!isFind)
						arranged.add(new Syllabus(" "," "," "," "));
				}
		List<String> names = new ArrayList<String>();
		for (ClassroomModel r :rooms)
			names.add(r.getAddress());
		ActionContext.getContext().put("rooms", names);
		ActionContext.getContext().put("roomCount", roomOrder.size());
		ActionContext.getContext().put("arrangedCourses", arranged);
		ActionContext.getContext().put("semester", semester);
		return "adminCurriculum";
	}
	
	
	public String saveManualSyllabus() {
		String semester = manageService.getCurrSemester();
		manageService.saveArrangedCourse(manualCoruses, semester);
		try {
			//System.out.println(ServletActionContext.getServletContext().getRealPath("/"));
			FileOutputStream fos = new FileOutputStream(ServletActionContext.getServletContext().getRealPath("/")+ "\\download\\"+ semester + ".xls");
			ca = new CourseArrangementImpl(manualCoruses, manualRooms);
			ca.toExcel(fos);
			fos.close();
			ca = null;
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return perSyllabus2();
	}
	
	
	public String manualArrange(){
		String semester = semChosenCourse.getSemester();
		
		String chk = preChk(semester);
		if (chk != null)
			return chk;
		
		//ActionContext.getContext().put("semester",semChosenCourse.getSemester());
		
		// 把可用教室存入学期教室表中
		List<Classroom> classrooms = classService.loadclassroombyisavaible();
		for(Classroom c:classrooms){
			manageService.semesterroombegainadd(c, semChosenCourse.getSemester());
		}
		List<Syllabus> arranged = new ArrayList<Syllabus>();
		
		// 按课时增加记录
		manageService.sire(semester);
		
		if (manualCoruses == null)
			manualCoruses = manageService.getAllChosenCourse(semester);
		if (manualRooms == null){
			List<ClassroomModel> rooms = manageService.getAllAvlRooms(semester);
			manualRooms = rooms;
		}

		String init = "<a style='color:red;' onclick='insert(%d,%d,%d)'>点此插入课程</a>";
		//String remove = "<a onclick='remove(%d)'>%s\n%s%s</a>";
		
		for (int day = 0; day < 5; ++day){
			for (int slot = 0; slot < 5; ++slot){
				for (int i = 0; i < manualRooms.size(); ++i){
					boolean find = false;
					for (ChosenCourseModel c : manualCoruses) {
						if (c.getRoom() == null)
							continue;
						if (c.getSlot() == slot 
								&& c.getWeekday() == day 
								&& c.getRoom().getNum().equals(manualRooms.get(i).getNum())){
							Syllabus s = new Syllabus(c);
							arranged.add(s);
							find = true;
							break;
						}
					}
					if (!find){
						Syllabus s = new Syllabus();
						s.setCourseName(String.format(init, day, slot, i));
						arranged.add(s);
					}
				}
			}
		}
		
		List<String> names = new ArrayList<String>();
		for (ClassroomModel r : manualRooms)
			names.add(r.getAddress() + r.getRoomtype());
		
		ActionContext.getContext().put("roomCount", names.size());
		ActionContext.getContext().put("rooms", names);
		ActionContext.getContext().put("arrangedCourses", arranged);
		return "manualArrange";
	}

	private String preChk (String semester){
		Map<String, List<String>> errorMsg = manageService.arrangePreChk(semester);
		boolean isEmpty = true;
		for (String key : errorMsg.keySet()) {
			if (errorMsg.get(key).size() > 0){
				isEmpty = false;
				break;
			}
		}
		// pass
		if (!isEmpty){
			ActionContext.getContext().put("errorMsg", errorMsg);
			return "missingItem";
		}
		return null;
	}
	
	public String getSyllabus() {
		String semester = semChosenCourse.getSemester();
		List<ClassroomModel> rooms = manageService.getAllAvlRooms(semester);
		currRooms = rooms;
		List<String> roomOrder = new ArrayList<String>();
		for (ClassroomModel r : rooms)
			roomOrder.add(String.valueOf(r.getNum()));
		// 按课时增长
		manageService.sire(semester);
		List<ChosenCourseModel> courses = manageService.getAllChosenCourse(semester);
		if (ca == null){	
			// 不排任选课
			/*List<ChosenCourseModel> nonElective = new ArrayList<ChosenCourseModel>();
			List<ChosenCourseModel> elective = new ArrayList<ChosenCourseModel>();
			for (ChosenCourseModel c : courses) {
				if (!c.getCourse().isElective()) {
					nonElective.add(c);
				} else {
					elective.add(c);
				}
			}*/
			String chk = preChk(semester);
			if (chk != null)
				return chk;
			
			//ca = new CourseArrangementImpl(courses, rooms, no);
			//ca = new CourseArrangementImpl(nonElective, rooms, electiveSlot);
			ca = new CourseArrangementImpl(courses, rooms, electiveSlot);
			//ca.SetUable(elective);
		}
		
		currCourses.clear(); 
		currCourses.addAll(ca.getFullTable());
		currCourses.addAll(ca.getUnable());
		
		List<Syllabus> arranged = new ArrayList<Syllabus>();
		List<Syllabus> unable = new ArrayList<Syllabus>();
		for (ChosenCourseModel p : ca.getUnable())
			unable.add(new Syllabus(p));

		for (int day = 0; day < 5; ++day)
			for (int slot = 0; slot < 5; ++slot)
				for (ChosenCourseModel p : ca.getCertainSlot(day, slot,roomOrder))
					arranged.add(new Syllabus(p));
		ActionContext.getContext().put("unable", unable);
		List<String> names = new ArrayList<String>();
		for (ClassroomModel r : rooms)
			names.add(r.getAddress() + r.getRoomtype());
		ActionContext.getContext().put("rooms", names);
		ActionContext.getContext().put("roomCount", roomOrder.size());
		ActionContext.getContext().put("arrangedCourses", arranged);
		return "arranged";
	}
	
	
	private List<ChosenCourseModel> currCourses = new ArrayList<ChosenCourseModel>();
	private List<ClassroomModel> currRooms = null;
	
	public String saveSyllabus() {
		String semester = manageService.getCurrSemester();
		manageService.saveArrangedCourse(ca.getCourses(), semester);
		try {
			//System.out.println(ServletActionContext.getServletContext().getRealPath("/"));
			FileOutputStream fos = new FileOutputStream(ServletActionContext.getServletContext().getRealPath("/")+ "\\download\\"+ semester + ".xls");
			ca.toExcel(fos);
			fos.close();
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return perSyllabus();
	}

	public String downloadSyllabus() {
		HttpServletResponse response = ServletActionContext.getResponse();		
		response.reset();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel");
		String fileName = "课程总表.xls";
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("GB2312"), "8859_1"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		OutputStream out;
		try {
			out = response.getOutputStream();			
			ca.toExcel(out, null);			
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String perSyllabus() {
		String semester = manageService.getCurrSemester();
		List<ClassroomModel> rooms = manageService.getAllAvlRooms(semester);
		List<String> roomOrder = new ArrayList<String>();
		for (ClassroomModel r : rooms)
			roomOrder.add(String.valueOf(r.getNum()));
		List<Syllabus> arranged = new ArrayList<Syllabus>();
		for (int day = 0; day < 5; ++day)
			for (int slot = 0; slot < 5; ++slot)
				for (ChosenCourseModel p : ca.getCertainSlot(day, slot,roomOrder))
					arranged.add(new Syllabus(p));
		List<String> names = new ArrayList<String>();
		for (ClassroomModel r : rooms)
			names.add(r.getAddress());
		ActionContext.getContext().put("rooms", names);
		ActionContext.getContext().put("roomCount", roomOrder.size());
		ActionContext.getContext().put("arrangedCourses", arranged);
		return "curriculum";
	}

	public String SemesterCourse() {
		String semester = manageService.getCurrSemester();
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Rows",manageService.getUnarrangeCourses(page, pageSize, semester));
		map.put("Total", manageService.getTotalUnarrangedCourseNum(semester));
		datatojson(map);
		return null;
	}
	
	public String adjustingCurriculums() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String chosenCourseNum = request.getParameter("num");
		List<Syllabus> options = new ArrayList<Syllabus>();
		for (ChosenCourseModel c : ca.otherOption(chosenCourseNum)) {
			options.add(new Syllabus(c));
		}
		ChosenCourseModel old = null;
		for (ChosenCourseModel i : currCourses) {
			if (i.getNum().equals(chosenCourseNum)){
				old = i;
				break;
			}
		}
		ActionContext.getContext().put("old", old);
		ActionContext.getContext().put("rooms", currRooms);
		ActionContext.getContext().put("options", options);
		return "syllabusOption";
	}
	
	public String adjustTips(){

		int slot = Integer.parseInt(newSlot);
		int day = Integer.parseInt(plandate);
		for (ChosenCourseModel i : ca.otherOption(oldnum)){
			if (i.getSlot() == slot && i.getWeekday() == day && i.getRoom().getNum().equals(newRoomNum)){
				Syllabus s = new Syllabus();
				s.setNum(i.getNum());
				if (i.getCourse() != null)
					s.setCourseName(i.getCourse().getCoursename());
				else
					s.setCourseName("没有课程");
				List<Syllabus> k = new ArrayList<Syllabus>();
				k.add(s);
				toJson(k);
				break;
			}
		}
		List<Syllabus> k = new ArrayList<Syllabus>();
		toJson(k);
		return null;
	}
	

	public String applyNewSyllabus() {
		ca.applyNewArrangementByNum(oldnum, newnum);
		// ca.toExcel(null, null);
		return null;
	}

	public String graduateaudit() {
		String classlist = classService.classlist();
		ActionContext.getContext().put("classlist", classlist);
		return "graduateaudit";
	}

	public String graduatestuauditagree() {
		studentService.graduatestuauditagree(ids);
		return null;
	}

	
	public String batchSemesterCourse () {
		return "semesterCourseBatchAdd";
	}
	
	Map<String, Object> batchResult = new HashMap<String, Object>();
	
	public String batchInsertSemesterCourse (){
		if (batchResult == null){
			return null;
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		
		
		@SuppressWarnings("unchecked")
		List<BatchRegiste> fail = (List<BatchRegiste>)batchResult.get("Fail");
		
		
		Map<String, Object> toPage = new HashMap<String, Object>();
		
		if ((page - 1) * pageSize > fail.size())
			page = 0;
		
		List<BatchRegiste> toPageDat = new ArrayList<BatchRegiste>();
		if (page * pageSize > fail.size()) {
			for (BatchRegiste br : fail.subList((page - 1) * pageSize, fail.size())) {
				toPageDat.add(br);
			}
		} else {
			for (BatchRegiste br : fail.subList((page - 1) * pageSize, page * pageSize)) {
				toPageDat.add(br);
			}
		}
		
		toPage.put("Total", fail.size());
		toPage.put("Rows", toPageDat);
		datatojson(toPage);
		
		return null;
	} 
	
	
	
	public String batchSetSemesterCourse (){
		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
		Date dt = new Date();
		SimpleDateFormat mt2 = new SimpleDateFormat("yyMMddHHmmss");
		String s = mt2.format(dt);
		for (int i = 0; i < 3; i++) {
			Random r = new Random();
			int ran = r.nextInt(10);
			s += ran;
		}
		if (file != null) {
			File savedir = new File(realpath);
			String name = fileFileName.substring(fileFileName.indexOf('.'));
			String filename = s.concat(name);
			if (!savedir.exists())
				savedir.mkdirs();
			  try {
				File savefile = new File(savedir, filename);
				FileUtils.copyFile(file, savefile);
			  } catch (IOException e) {
				
				e.printStackTrace();
			  }
			batchResult = manageService.batchSetSemesterCourse(realpath + "\\" + filename);
			List<BatchRegiste> fail = (List<BatchRegiste>)batchResult.get("Fail");
			if (fail.size() == 0) {
				return "batchSuccess";
			}
			ActionContext.getContext().put("succeed", String.valueOf(batchResult.get("Count")));
			ActionContext.getContext().put("msg", " ");
		} else {
			ActionContext.getContext().put("msg", "添加失败,请重新添加！");
		}
		return "semesterCourseBatchResult";
	}
	
	
	public String graduatestuauditrefuse() {
		studentService.graduatestuauditrefuse(ids);
		return null;
	}

	public String semestercourse() {
		return "semestercourse";
	}

	public String courselist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));		
		Map<String, Object> map = manageService.courselist(page, pageSize);
		datatojson(map);
		return null;
	}
	public String Searchcourselist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize =Integer.parseInt(request.getParameter("pagesize"));
		String semester = request.getParameter("semester");
		Map<String, Object> map = manageService.Searchcourselist(page, pageSize,semester);
		datatojson(map);
		return null;
	}
	
	public String semestercourselist() { 
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		//int page = 1;
		//int pageSize = 100;
		//Map<String, Object> map = manageService.semestercourselist(page,pageSize);
		//Map<String, Object> map = null;
		//int page = 1;
		//int pageSize = 10;
		//Map<String, Object> map = manageService.semestercourselist(page,pageSize);
		Map<String, Object> map = null;
		semester = manageService.getCurrSemester();
		if (semester != null)
			map = manageService.semestercourselist2(page,pageSize, semester);
		else
			map = manageService.semestercourselist(page, pageSize);
		datatojson(map);
		return null;
	}
	public String Searchsemestercourselist() { 
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		String semester = request.getParameter("semester");
		Map<String, Object> map = manageService.semestercourselist2(page,pageSize,semester);
		datatojson(map);
		return null;
	}

	public String semesterselectcourselist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.semesterselectcourselist(page,pageSize);
		datatojson(map);
		return null;
	}

	public String selectCourse() {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();		
		String semester = request.getParameter("semester");
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<SemesterChosenCourse> sem = manageService.loadsemestercoursebycourseid(selectiveCourseNum,semester);		
		//manageService.selectCourse(true, selectiveCourseNum, user.getUsernum(),semester);
		if (sem==null) {
			return null ;
		}else {
			if(sem.get(0).getIsElective()==2){
				List<ChosenCourse> cho = manageService.loadselectcoursestu(selectiveCourseNum, semester);
				try {
				    response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					String info = "";
					if (sem.get(0).getStuNum()==null) {
						info="管理员还未设置可选课人数，现在还不能选课！";
					}else {
						if(cho.size()<=sem.get(0).getStuNum()){
							manageService.selectCourse(true, selectiveCourseNum, user.getUsernum(),semester);
						}else {
							info ="选课人数已达上限，您暂时不能选！";							
						}
					}
					
					out.print(info);
					out.flush();
					out.close();
				} catch (IOException e) {
					 
					e.printStackTrace();
				}
			}else {
				manageService.selectCourse(true, selectiveCourseNum, user.getUsernum(),semester);
			}
		}
		
		return null;
	}

	public String diselectCoruse() {
		String semester = manageService.getCurrSemester();
		User user = (User) ActionContext.getContext().getSession().get("user");
		manageService.selectCourse(false, selectiveCourseNum,user.getUsernum(), semester);
		return null;
	}

	public String courseListForCourseSelection() {
		String semester = manageService.getCurrSemester();
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));

		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user.getRoles().getRolerank() != 3)
			return null;
		List<ChosenCourseModel> options = manageService.allSelectiveCourses(user.getUsernum(), semester);
		/*List<ChosenCourseModel> elect = manageService.electiveCourseForSelectCourse(user.getUsernum(), semester);
		for (ChosenCourseModel i : elect) {
			i.setElective(true);
		}

		options.addAll(elect);*/

		List<ChosenCourseModel> part = null;
		if (options.size() < pageSize)
			part = options;
		else
			part = options.subList((page - 1) * pageSize, page * pageSize);

		
		List<InfoBean> inHtml = new ArrayList<InfoBean>();

		Set<String> name = new HashSet<String>();
		for (ChosenCourseModel i : part) {
			if (name.contains(i.getCourse().getCoursename()))
				continue;
			name.add(i.getCourse().getCoursename());
			InfoBean p = new InfoBean();
			SemesterChosenCourse semesterChosenCourse = manageService.loadsemesterchosencoursebycourseid(i.getCourse().getNum());
			List<ChosenCourse> chosenCourses = manageService.loadchosencoursebycourseid(i.getCourse().getNum());
			if (semesterChosenCourse.getIsElective() == 1) {
				p.setStuNum(semesterChosenCourse.getStuNum());
				p.setHavestuNum(chosenCourses.size());
			}
			p.setStuNum(semesterChosenCourse.getStuNum());
			p.setBeginWeek(i.getBeginWeek());
			p.setNum(i.getCourse().getNum());
			p.setEndWeek(i.getEndWeek());
			p.setCredits(i.getCourse().getCredits());
			p.setCourseName(i.getCourse().getCoursename());
			p.setTeacher(i.getTeacher().getTeachername());
			p.setTeacherid(i.getTeacher().getIdentificationnum());
			if (i.isSelected())
				p.setClasses("<font color='red' >已选</font>");
			else
				p.setClasses("未选");
			/*if (i.isElective())
				p.setCourseType("选修");
			else
				p.setCourseType("必修");*/
			p.setCourseType(i.getCourse().getCharacter());
			inHtml.add(p);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Total", inHtml.size());
		map.put("Rows", inHtml);
		datatojson(map);
		return null;
	}
	public String SearchcourseListForCourseSelection() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String semester = request.getParameter("semester");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));

		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user.getRoles().getRolerank() != 3)
			return null;
		List<ChosenCourseModel> options = manageService.allSelectiveCourses(user.getUsernum(), semester);
		List<ChosenCourseModel> elect = manageService.electiveCourseForSelectCourse(user.getUsernum(), semester);
		for (ChosenCourseModel i : elect) {
			i.setElective(true);
		}

		options.addAll(elect);

		List<ChosenCourseModel> part = null;
		if (options.size() < pageSize)
			part = options;
		else
			part = options.subList((page - 1) * pageSize, page * pageSize);

		List<InfoBean> inHtml = new ArrayList<InfoBean>();

		Set<String> name = new HashSet<String>();
		for (ChosenCourseModel i : part) {
			if (name.contains(i.getCourse().getCoursename()))
				continue;
			name.add(i.getCourse().getCoursename());
			InfoBean p = new InfoBean();
			SemesterChosenCourse semesterChosenCourse = manageService.loadsemesterchosencoursebycourseid(i.getCourse().getNum());
			List<ChosenCourse> chosenCourses = manageService.loadchosencoursebycourseid(i.getCourse().getNum());
			if (semesterChosenCourse.getIsElective() == 1) {
				p.setStuNum(semesterChosenCourse.getStuNum());
				p.setHavestuNum(chosenCourses.size());
			}
			// p.setStuNum(semesterChosenCourse.getStuNum());
			p.setBeginWeek(i.getBeginWeek());
			p.setNum(i.getCourse().getNum());
			p.setEndWeek(i.getEndWeek());
			p.setCourseName(i.getCourse().getCoursename());
			p.setTeacher(i.getTeacher().getTeachername());
			p.setTeacherid(i.getTeacher().getIdentificationnum());
			if (i.isSelected())
				p.setClasses("<font color='red' >已选</font>");
			else
				p.setClasses("未选");
			if (i.isElective())
				p.setCourseType("选修");
			else
				p.setCourseType("必修");
			inHtml.add(p);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Total", inHtml.size());
		map.put("Rows", inHtml);
		datatojson(map);
		return null;
	}
	public String semestercourseadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String semester = request.getParameter("semester");
		manageService.semestercourseadd(ids,semester);
		return null;
	}

	public String semestercoursedelete() {
		manageService.semestercoursedelete(ids);
		return null;
	}
	public String semesteroldcourse(){
		List<SemesterChosenCourse> semesterChosenCourses = manageService.listsemester();
		Gson json = new Gson();
		String  semsterString = json.toJson(semesterChosenCourses);
		ActionContext.getContext().put("semesterlist", semsterString);
		String coursecredit = "{\"Coursecredit\":" + "\"" + 1 + "\"}" + ","+ "{\"Coursecredit\":" + "\"" + 2 + "\"}" + ","
				+ "{\"Coursecredit\":" + "\"" + 3 + "\"}" + ","+ "{\"Coursecredit\":" + "\"" + 4 + "\"}" + ","+ "{\"Coursecredit\":" + "\"" + 5 + "\"}" + ","
				+ "{\"Coursecredit\":" + "\"" + 6 + "\"}" + ","+ "{\"Coursecredit\":" + "\"" + 7 + "\"}";
		String char1 = "必修", char2 = "限选", char3 = "任选";
		String character = "{\"Coursecharacter\":" + "\"" + char1 + "\"}" + ","+ "{\"Coursecharacter\":" + "\"" + char2 + "\"}" + ","+ "{\"Coursecharacter\":" + "\"" + char3 + "\"}";
		String s1 = "集中式", s2 = "非集中式";
		String checkway = "{\"Coursecheckway\":" + "\"" + s1 + "\"}" + ","+ "{\"Coursecheckway\":" + "\"" + s2 + "\"}";
		ActionContext.getContext().put("coursecredit", coursecredit);
		ActionContext.getContext().put("character", character);
		ActionContext.getContext().put("checkway", checkway);
		return "semesteroldcourse";
	}

	public String semestercoursesetteacher() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String semestertext = "";
		try {
			request.setCharacterEncoding("UTF-8");
			semestertext = java.net.URLDecoder.decode(request.getParameter("semestertext"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String coursecredit = "{\"Coursecredit\":" + "\"" + 1 + "\"}" + ","+ "{\"Coursecredit\":" + "\"" + 2 + "\"}" + ","+ "{\"Coursecredit\":" + "\"" + 3 + "\"}" + ","
				+ "{\"Coursecredit\":" + "\"" + 4 + "\"}" + ","+ "{\"Coursecredit\":" + "\"" + 5 + "\"}" + ","+ "{\"Coursecredit\":" + "\"" + 6 + "\"}" + ","
				+ "{\"Coursecredit\":" + "\"" + 7 + "\"}";
		String char1 = "必修", char2 = "限选", char3 = "任选";
		String character = "{\"Coursecharacter\":" + "\"" + char1 + "\"}" + ","+ "{\"Coursecharacter\":" + "\"" + char2 + "\"}" + ","+ "{\"Coursecharacter\":" + "\"" + char3 + "\"}";
		String s1 = "集中式", s2 = "非集中式";
		String checkway = "{\"Coursecheckway\":" + "\"" + s1 + "\"}" + ","+ "{\"Coursecheckway\":" + "\"" + s2 + "\"}";
		ActionContext.getContext().put("coursecredit", coursecredit);
		ActionContext.getContext().put("character", character);
		ActionContext.getContext().put("checkway", checkway);
		ActionContext.getContext().put("semestertext", semestertext);
		return "semestercoursesetteacher";
	}

	public String courseteacherselect() {
		ActionContext.getContext().put("semestercourseid",semChosenCourse.getId());
		return "courseteacherselect";
	}
	
	
	public String semesterteacherendadd() {
		manageService.semesterteacherendadd(teacher.getIdentificationnum(),semChosenCourse.getId());
		return null;
	}

	public String semesterclassselect() {
		String classlist = classService.classlist1();
		ActionContext.getContext().put("classlist", classlist);
		ActionContext.getContext().put("semestercourseid",semChosenCourse.getId());
		return "semesterclassselect";
	}

	public String semestercourseclassset() {
		manageService.semesterclassset(semChosenCourse.getId(), ids);
		return null;
	}

	public String semestercourseteacheradd()throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<SemesterChosenCourse> listUpdated = new ArrayList<SemesterChosenCourse>();
		request.setCharacterEncoding("UTF-8");
		//String updated = request.getParameter("ff");
		String updated = request.getParameter("updated");
		updated = java.net.URLDecoder.decode(updated,"UTF-8");
		//System.out.println(updated);
		JSONArray array = JSONArray.fromObject(updated);
		for (int i = 0; i < array.size(); i++) {
			listUpdated.add((SemesterChosenCourse) JSONObject.toBean(array.getJSONObject(i), SemesterChosenCourse.class));
		}
		manageService.semestercourseteacheradd(listUpdated);
		return null;
	}

	public String semestercoursescoreadd()throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<ChosenCourseModel> listUpdated = new ArrayList<ChosenCourseModel>();
		request.setCharacterEncoding("UTF-8");
		//String updated = request.getParameter("ff");
		String updated = request.getParameter("updated");
		updated = java.net.URLDecoder.decode(updated,"UTF-8");
		System.out.println(updated);
		JSONArray array = JSONArray.fromObject(updated);
		for (int i = 0; i < array.size(); i++) {
			listUpdated.add((ChosenCourseModel) JSONObject.toBean(array.getJSONObject(i), ChosenCourseModel.class));
		}
		User user = (User) ActionContext.getContext().getSession().get("user");
		manageService.semestercoursescoreadd(listUpdated, user);
		return null;
	}
	
	public String semesterselectcourseupdate()throws UnsupportedEncodingException {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<SemesterChosenCourse> listUpdated = new ArrayList<SemesterChosenCourse>();
		request.setCharacterEncoding("UTF-8");
		String updated = request.getParameter("updateds");
		updated = java.net.URLDecoder.decode(updated,"UTF-8");
		System.out.println(updated);
		JSONArray arrays = JSONArray.fromObject(updated);
		for (int i = 0; i < arrays.size(); i++) {
			listUpdated.add((SemesterChosenCourse) JSONObject.toBean(arrays.getJSONObject(i), SemesterChosenCourse.class));
		}
		manageService.semesterselectcourseupdate(listUpdated);
		return null;
	}

	public String semesterclassroom() {
		return "semesterclassroom";
	}

	public String roomlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.roomlist(page, pageSize);
		datatojson(map);
		return null;
	}

	public String semesterroomlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.semesterroomlist2(page, pageSize, semester);
		datatojson(map);
		return null;
	}

	public String semesterroomadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String semester = request.getParameter("semester");
		manageService.semesterroomadd(ids,semester);
		return null;
	}

	public String semesterroomdelete() {
		manageService.semesterroomdelete(ids);
		return null;
	}

	public String semesterselectcourseset() {
		String coursecredit = "{\"Coursecredit\":" + "\"" + 1 + "\"}" + ","
				+ "{\"Coursecredit\":" + "\"" + 2 + "\"}" + ","
				+ "{\"Coursecredit\":" + "\"" + 3 + "\"}" + ","
				+ "{\"Coursecredit\":" + "\"" + 4 + "\"}" + ","
				+ "{\"Coursecredit\":" + "\"" + 5 + "\"}" + ","
				+ "{\"Coursecredit\":" + "\"" + 6 + "\"}" + ","
				+ "{\"Coursecredit\":" + "\"" + 7 + "\"}";
		String char1 = "必修", char2 = "限选", char3 = "任选";
		String character = "{\"Coursecharacter\":" + "\"" + char1 + "\"}" + ","+ "{\"Coursecharacter\":" + "\"" + char2 + "\"}" + ","+ "{\"Coursecharacter\":" + "\"" + char3 + "\"}";
		String s1 = "集中式", s2 = "非集中式";
		String checkway = "{\"Coursecheckway\":" + "\"" + s1 + "\"}" + ","+ "{\"Coursecheckway\":" + "\"" + s2 + "\"}";
		ActionContext.getContext().put("coursecredit", coursecredit);
		ActionContext.getContext().put("character", character);
		ActionContext.getContext().put("checkway", checkway);
		return "selectcourseset";
	}

	/* ���ι��� */
	public String changecoursemanage() {
		return "changecoursemanage";
	}

	public String changecourselist() {
		
		String semester = manageService.getCurrSemester();
		//List<Adjustcourse> all = manageService.adjustRecordList(semester);
		List<AdjustcourseModel> all = manageService.loadAdjustRocords(semester);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Rows", all);
		map.put("Total", all.size());
		datatojson(map);
		return null;
	}

	public String prvChangeCourseList(){
		String semester = manageService.getCurrSemester();
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<AdjustcourseModel> all = manageService.loadAdjustReocrdsByTeacher(user.getUsernum(),semester);
		List<AdjustcourseModel> order = new ArrayList<AdjustcourseModel>();
		for (int i = 0; i < 3; ++i) {
			for (AdjustcourseModel ad : all) {
				if (ad.getStatus().equals(String.valueOf(i))) {
					order.add(ad);
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Rows", order);
		map.put("Total", all.size());
		datatojson(map);
		return null;
	}
	
	public String changecourse() {
		return "changecourses";
	}

	public String getDat() {
		Cascade test = new Cascade();
		/*
		 * int i = 0; List<Cascade> alphabet = new ArrayList<Cascade>(); for
		 * (char a = 'A'; a <= 'Z'; a++) { Cascade t = new Cascade(); t.setN(a +
		 * ""); t.setV(String.valueOf(i++)); alphabet.add(t); }
		 * test.setN("Upper Letter"); test.setV("1");
		 */
		test.setV("this is v");
		List<Cascade> test2 = new ArrayList<Cascade>();
		Cascade p = new Cascade();
		p.setV("this is v too");
		test2.add(test);
		test2.add(p);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		Gson gson = new Gson();
		String json = gson.toJson(test2);
		PrintWriter out;
		// System.out.println(json);
		try {
			out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void toJson(List<Syllabus> dat) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		Gson gson = new Gson();
		String json = gson.toJson(dat);
		PrintWriter out;
		// System.out.println(json);
		try {
			out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCourseSlot() {
		if (courseRet == null)
			return null;
		// System.out.println(oldnum);
		List<Syllabus> slot = new ArrayList<Syllabus>();
		for (ChosenCourseModel i : courseRet) {
			if (i.getCourse().getNum().equals(Integer.parseInt(oldnum)))
				slot.add(new Syllabus(i));
		}
		toJson(slot);
		return null;
	}

	public String getNewCourseSlot() {
		if (pallCourses == null)
			return null;
		List<Syllabus> slot = new ArrayList<Syllabus>();
		Set<Integer> sameSlt = new HashSet<Integer>();
		for (ChosenCourseModel i : pallCourses) {
			if (i.getCourse().getNum().equals(Integer.parseInt(oldnum))) {
				if (sameSlt.contains(i.getSlot()))
					continue;
				slot.add(new Syllabus(i));
				sameSlt.add(i.getSlot());
			}
		}
		toJson(slot);
		return null;
	}

	public int getDayofweek(String date) {
		Calendar cal = Calendar.getInstance();
		if (date.equals("")) {
			cal.setTime(new Date(System.currentTimeMillis()));
		} else {
			cal.setTime(new Date(getDateByStr2(date).getTime()));
		}
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	public Date getDateByStr2(String dd) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sd.parse(dd);
		} catch (ParseException e) {
			date = null;
			e.printStackTrace();
		}
		return date;
	}

	public String chkOldDate() {
		//System.out.println(getDayofweek(origndate));
		int day = getDayofweek(origndate) - 2;
		if (courseRet == null)
			return null;
		// System.out.println(oldnum);
		List<Syllabus> slot = new ArrayList<Syllabus>();
		boolean illege = false;
		
		for (ChosenCourseModel i : courseRet) {
			if (i.getCourse().getNum().equals(oldnum))
				if (day == i.getWeekday()){
					illege= true;
					slot.add(new Syllabus(i));
				}
		}
		/*if (!illege)
			slot.add(new Syllabus());*/
		toJson(slot);
		return null;
	}
	
	public String chkNewDate() {
		if (pallCourses == null)
			return null;
		// System.out.println(oldnum);
		List<Syllabus> slot = new ArrayList<Syllabus>();
		int day = getDayofweek(plandate) - 2;
		
		Set<Integer> sameSlt = new HashSet<Integer>();
		for (ChosenCourseModel i : pallCourses) {
			if (i.getCourse() == null)
				continue;
			if (i.getCourse().getNum().equals(newnum)) {
				if (day == i.getWeekday()){
					if (sameSlt.contains(i.getSlot()))
						continue;
					slot.add(new Syllabus(i));
					sameSlt.add(i.getSlot());
				}
			}
		}
		Set<String> slot2 = new HashSet<String>();
		
    	List<Adjustcourse> ad = manageService.approvedAdjustApplyListByWeekday(String.valueOf(day), semester);
    	
    	for (Adjustcourse i : ad) {
    		if (i.getNewslot() == null || i.getNewcoursenum() != null)
    			continue;
    		if (i.getNewcoursenum().equals(newnum))
    			slot2.add(i.getNewslot());
    	}
    	
    	List<Adjustcourse> ad2 = manageService.ApplyingAdjustByWeekday(String.valueOf(day), semester);
    	
    	for (Adjustcourse i : ad2) {
    		if (i.getNewslot() == null || i.getNewcoursenum() != null)
    			continue;
    		if (i.getNewcoursenum().equals(newnum))
    			slot2.add(i.getNewslot());
    	}
    	
    	List<Syllabus> ret = new ArrayList<Syllabus>();
    	boolean isFind = false;
    	for (Syllabus i : slot) {
    		isFind = false;
    		for (String j : slot2) {
    			if (i.getSlot().toString().equals(j)){
    				isFind = true;
    				break;
    			}
    		}
    		if (!isFind) {
    			ret.add(i);
    		}
    	}
		toJson(ret);
		return null;
	}
	
	public String getOldroom (){
		int day = getDayofweek(origndate) - 2;
		List<Syllabus> slots = new ArrayList<Syllabus>();
		for (ChosenCourseModel i : courseRet) {
			if (i.getCourse().getNum().equals(oldnum)
					&& i.getSlot() == (Integer.parseInt(oldSlot) - 1)
					&& i.getWeekday() == day){
				Syllabus s = new Syllabus();
				s.setRoomNum(String.valueOf(i.getRoom().getNum()));
				s.setNote(i.getRoom().getAddress());
				slots.add(s);
			}
				
		}
		toJson(slots);
		return null;
	}
	
	public String getNewroom () {
		int day = getDayofweek(plandate) - 2;
		List<Syllabus> slots = new ArrayList<Syllabus>();
		for (ChosenCourseModel i : pallCourses) {
			if (i.getCourse() == null)
				continue;
			if (i.getCourse().getNum().equals(newnum)
					&& i.getSlot() == (Integer.parseInt(newSlot) - 1)
					&& i.getWeekday() == day){
				Syllabus s = new Syllabus();
				s.setRoomNum(String.valueOf(i.getRoom().getNum()));
				s.setNote(i.getRoom().getAddress());
				slots.add(s);
			}
				
		}
		toJson(slots);
		return null;
	}
	
	private List<ChosenCourseModel> courseRet = null;
	//private List<Syllabus> courses = null;
	private List<ChosenCourseModel> pallCourses = null;

	public String changecourseapply() {

		String semester = manageService.getCurrSemester();
		User user = (User) ActionContext.getContext().getSession().get("user");
		if ((user.getRoles().getRolerank()!=4)&&(user.getRoles().getRolerank()!=2)) {
			ActionContext.getContext().put("message", "您不是任课教师，不能申请调课！");
			return "showmessage";
		}else {
			courseRet = manageService.loadSemesterChosenCoruseByTeacher(user.getUsernum(), semester);
			List<Syllabus> courses = new ArrayList<Syllabus>();

			Syllabus pleaseChoice = new Syllabus();
			pleaseChoice.setCourseName("请选择");
			pleaseChoice.setId(String.valueOf(-1));
			courses.add(pleaseChoice);

			Set<String> hasName = new HashSet<String>();
			for (ChosenCourseModel c : courseRet) {
				if (hasName.contains(c.getCourse().getCoursename())) {
					continue;
				} else {
					Syllabus s = new Syllabus(c);
					s.setId(c.getCourse().getNum());
					courses.add(s);
					hasName.add(c.getCourse().getCoursename());
				}
			}

			List<Syllabus> allCourseName = new ArrayList<Syllabus>();
			allCourseName.add(pleaseChoice);
			List<ChosenCourseModel> allCourses = manageService.loadAllChosenCourse2(semester);
			pallCourses = allCourses;
			hasName.clear();
			for (ChosenCourseModel c : allCourses) {
				if(c.getCourse() == null){
					continue;
				}
				if (hasName.contains(c.getCourse().getCoursename())) {
					continue;
				} else {
					Syllabus s = new Syllabus(c);
					s.setId(c.getCourse().getNum());
					allCourseName.add(s);
					hasName.add(c.getCourse().getCoursename());
				}
			}

			ActionContext.getContext().put("allCourses", allCourseName);
			ActionContext.getContext().put("oldCourses", courses);
			return "changecourseapply";
		}
		
		/*
		 * String semester = manageService.getCurrSemester(); // 先得到当前老师在本学期上的课程
		 * User user =
		 * (User)ActionContext.getContext().getSession().get("user");
		 * List<ChosenCourseModel> ret =
		 * manageService.loadSemesterChosenCoruseByTeacher
		 * (user.getUsernum(),semester); courses = new ArrayList<Syllabus>();
		 * Set<String> hasName = new HashSet<String>(); int id = 0; for
		 * (ChosenCourseModel c : ret) { if
		 * (hasName.contains(c.getCoursename())) { continue; } else { Syllabus s
		 * = new Syllabus(c); s.setId(id); id ++; courses.add(s);
		 * hasName.add(c.getCoursename()); } }
		 */

		// 得到当前学期所有课程
		/*
		 * ret = manageService.loadAllChosenCourse(semester); all = new
		 * ArrayList<Syllabus>(); hasName.clear(); for (ChosenCourseModel c :
		 * ret) { if (hasName.contains(c.getCoursename())) { continue; } else {
		 * all.add(new Syllabus(c)); hasName.add(c.getCoursename()); } }
		 */

		/*
		 * String semester = manageService.getCurrSemester(); User user =
		 * (User)ActionContext.getContext().getSession().get("user");
		 * List<ChosenCourseModel> all =
		 * manageService.loadAllChosenCourse(semester); List<ChosenCourseModel>
		 * candCourse = new ArrayList<ChosenCourseModel>(); for
		 * (ChosenCourseModel i : all) { if
		 * (user.getUsernum().equals(i.getTeacher().getIdentificationnum()))
		 * candCourse.add(i); }
		 * 
		 * Map<ChosenCourseModel, List<ChosenCourseModel>> map = new
		 * HashMap<ChosenCourseModel, List<ChosenCourseModel>>(); for
		 * (ChosenCourseModel i : candCourse) { List<ChosenCourseModel> t =
		 * manageService.getOtherOption(i, semester); map.put(i, t); }
		 * 
		 * //ActionContext.getContext().put("map", map);
		 * ActionContext.getContext().put("candCourses", candCourse);
		 * 
		 * return "changecourseapply";
		 */

	}

	public String adjustList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String chosenCourseNum = request.getParameter("num");
		String semester = manageService.getCurrSemester();
		List<ChosenCourseModel> optionCourses = manageService.getOtherOptionByCourseNum(chosenCourseNum, semester);

		List<Syllabus> options = new ArrayList<Syllabus>();
		for (ChosenCourseModel c : optionCourses) {
			options.add(new Syllabus(c));
		}
		ActionContext.getContext().put("old", chosenCourseNum);
		ActionContext.getContext().put("options", options);
		return "adjustCurrOptions";
	}

	public String applyCurrAdjustment() {
		String semester = manageService.getCurrSemester();
		// adjustReason = "no reason";
		try {
			adjustReason = java.net.URLDecoder.decode(adjustReason, "UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		Syllabus p = new Syllabus();
		User user = (User) ActionContext.getContext().getSession().get("user");
		p.setNum(oldnum); // 课程num
		p.setSlot(Integer.parseInt(oldSlot));
		p.setNote(origndate);
		p.setTeacherName(user.getUsernum()); // 教师num
		if (oldRoomNum.equals("aa")) {
			int day = getDayofweek(origndate) - 2;
			for (ChosenCourseModel i : courseRet) {
				if (i.getCourse() == null)
					continue;
				if (i.getCourse().getNum().equals(oldnum)
						&& i.getSlot() == (Integer.parseInt(oldSlot) - 1)
						&& i.getWeekday() == day){
					oldRoomNum = String.valueOf(i.getRoom().getNum());
				}
					
			}
		}
		p.setRoomNum(oldRoomNum);
		
		Syllabus q = new Syllabus();
		q.setNum(newnum);
		q.setRoomNum(newRoomNum);
		q.setSlot(Integer.parseInt(newSlot));
		q.setNote(plandate);

		manageService.saveAdjustRecord(p, q, adjustReason, semester);
		return "changecourses";
	}

	public String checkAdjustApply() {
		if (isApprove.equals("true"))
			manageService.checkAdjustApply(true,Integer.parseInt(adjustcourseID));
		else
			manageService.checkAdjustApply(false,Integer.parseInt(adjustcourseID));
		return null;
	}

	public String sendBackTranscript(){
		if (stu == null || stu.getPassport() == null) {
			return null;
		}
		Student student = studentService.loadstubystuid(stu.getPassport());
		if (student == null) {
			return null;
		}
		if (student.getEnddate()==null||student.getStartdate()==null) {
			ActionContext.getContext().put("msg","该学生学习期限有问题，请查证后再打印！");
			return "uploadmsg";//
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-word");
		String fileName = "Transcript.doc";
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("GB2312"), "8859_1"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		OutputStream out;
		User user = (User)ActionContext.getContext().getSession().get("user");
		Integer serial = manageService.getSerial(user, fileName, "PrintTranscript");
		try {
			out = response.getOutputStream();
			manageService.printTranscript(out, student, serial);			
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String transcriptprint() {
		List<Classes> classlist = classService.loadclass();
		ActionContext.getContext().put("classlist", classlist);
		return "transcriptprint";
	}

	public String attendencecourselist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.attendencecourselist(page,pageSize);
		datatojson(map);
		return null;
	}

	public String searchsemestercourselist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.semestercourselist3(page,pageSize, semChosenCourse.getSemester());
		datatojson(map);
		return null;
	}

	public String semestercoursedownload() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
	 	   response.reset();
	 	   response.setCharacterEncoding("UTF-8");
	 	   response.setContentType("application/vnd.ms-excel");
	 	   String semesters ="";
	 	  if(semester.substring(4,6).equals("01")){
				semesters = semester.substring(0,4)+"-"+String.valueOf(Integer.valueOf(semester.substring(0,4))+1)+"学年第一学期";
			}else {
				semesters = String.valueOf(Integer.valueOf(semester.substring(0,4))-1)+"-"+semester.substring(0,4)+"学年第二学期";
			}
	 	   String fileName=semesters+"学期课程.xls";
	 	   response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("GB2312"), "8859_1"));
	 	   OutputStream out = response.getOutputStream();    	 	   
	 	   try {
			WritableWorkbook workbook = Workbook.createWorkbook(out);
			WritableSheet ws = workbook.createSheet(semesters+"学期课程", 0);
			WritableFont wf = new WritableFont(WritableFont.TIMES,10,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);//设置字体格式
			WritableCellFormat wef = new WritableCellFormat(wf);//创建格式化对象实例
			wef.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//垂直居中
			wef.setAlignment(Alignment.CENTRE);//水平居中
			//工作表标题行（new Label（列，行，内容，格式））
			ws.addCell(new Label(0,0,"课程编号",wef));
			ws.addCell(new Label(1,0,"课程名称",wef));
			ws.addCell(new Label(2,0,"起始周",wef));
			ws.addCell(new Label(3,0,"结束周",wef));
			ws.addCell(new Label(4,0,"学分",wef));
			ws.addCell(new Label(5,0,"课时",wef));
			ws.addCell(new Label(6,0,"课程性质",wef));
			ws.addCell(new Label(7,0,"任课教师",wef));
			List<SemesterChosenCourse> sem = manageService.loadsemestercourse(semester);
			for(int i=0;i<sem.size();i++){
				for (int j = sem.size()-1; j>i; j--) {
					if (sem.get(i).getCoursenum().equals(sem.get(j).getCoursenum())) {
						sem.remove(i);
					}
				}
			}
			List<Course> courses = new ArrayList<Course>();
			for(SemesterChosenCourse c :sem){
				Course course = classService.loadcoursebynum(c.getCoursenum());
				Teacher teacher = manageService.loadteacherbynum(c.getTeacherid());
				if(teacher==null){
					course.setTeacher("");
				}else {
					course.setTeacher(teacher.getTeachername());
				}				
				courses.add(course);
			}
			List<Object[]> dataList = new ArrayList<Object[]>(); 
			for(Course temp:courses){
				Object[] stu = {temp.getNum(),temp.getCoursename(),temp.getBeginweeks(),temp.getEndweeks(),temp.getCredits(),temp.getCredits()*16,temp.getCharacter(),temp.getTeacher()};
				dataList.add(stu);
			}
			//向工作表添加数据
			for (int i = 0; i < dataList.size(); i++) {
				for (int j = 0; j < dataList.get(i).length; j++) {
					Object o = dataList.get(i)[j];
					if (o!=null) {
						Label label = new jxl.write.Label(j, i+1,o.toString(),wef);
						ws.addCell(label);
					}
				}
			}
			workbook.write();
			workbook.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 	   return null;
	}
	
	public String stucheck() {
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = manageService.stucheck(stu.getStuid());
		if (!flg) {
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("fail");
				out.flush();
				out.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return null;
	}

	public String getOldSlot() {
		return oldSlot;
	}

	public void setOldSlot(String oldSlot) {
		this.oldSlot = oldSlot;
	}

	public String getNewSlot() {
		return newSlot;
	}

	public void setNewSlot(String newSlot) {
		this.newSlot = newSlot;
	}

	public String transcriptsearch() {
		List<ChosenCourseModel> attendencelist = manageService.transcriptsearch(semChosenCourse.getSemester(), stu.getPassport());
		Student student = studentService.loadstubystuid(stu.getPassport());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		String json = "";
		for (ChosenCourseModel i : attendencelist) {
			if (i.getAttendence() == null) {
				i.setAttendence("");
			} 
			if (i.getHomework() == null) {
				i.setHomework("");
			}
			if (i.getFinalexam() == null) {
				i.setFinalexam("");
			}
			if (i.getMidexam() == null) {
				i.setMidexam("");
			}
		}
		if (attendencelist.size()==1) {
			SemesterChosenCourse semesterChosenCourse = manageService.loadsemesterchosencoursebycourseid(attendencelist.get(0).getCourseid());
			Course course = classService.loadcoursebynum(attendencelist.get(0).getCourseid());							  
			String semester = attendencelist.get(0).getSemester();
			String semesters = "";
			if(semester.substring(4,6).equals("02")){
				semesters = semester.substring(0,4)+"-"+String.valueOf(Integer.valueOf(semester.substring(0,4))+1)+"学年第一学期";
			}else {
				semesters = String.valueOf(Integer.valueOf(semester.substring(0,4))-1)+"-"+semester.substring(0,4)+"学年第二学期";
			}
			json = "[{\"semester\":\"" + semesters + "\"," + "\"coursename\":" + "\"" + course.getCoursename() + "\","+ "\"credits\":" + "\"" + course.getCredits() + "\","+ "\"lessoncount\":" + "\"" + course.getCredits()*16 + "\","+ "\"attendence\":" + "\"" + attendencelist.get(0).getAttendence()+ "\","+ "\"homework\":" + "\"" + attendencelist.get(0).getHomework() + "\","+ "\"midexam\":" + "\"" + attendencelist.get(0).getMidexam() + "\"," + "\"finalexam\":" + "\"" + attendencelist.get(0).getFinalexam() + "\"," + "\"summary\":" + "\"" + attendencelist.get(0).getSummary() + "\"}]";				  
		}else {
			for(int i=0;i<attendencelist.size();i++){
				//SemesterChosenCourse semesterChosenCourse = manageService.loadsemesterchosencoursebycourseid(attendencelist.get(i).getCourseId());
				Course course = classService.loadcoursebynum(attendencelist.get(i).getCourseid());							  
				String semester = attendencelist.get(i).getSemester();
				String semesters = "";
				if(semester.substring(4,6).equals("02")){
					semesters = semester.substring(0,4)+"-"+String.valueOf(Integer.valueOf(semester.substring(0,4))+1)+"学年第一学期";
				}else {
					semesters = String.valueOf(Integer.valueOf(semester.substring(0,4))-1)+"-"+semester.substring(0,4)+"学年第二学期";
				}
				if(i<attendencelist.size()-1){
				  if(i==0){
					  json = json+"[{\"semester\":\"" + semesters + "\"," + "\"coursename\":" + "\"" + course.getCoursename() + "\","+ "\"credits\":" + "\"" + course.getCredits() + "\","+ "\"lessoncount\":" + "\"" + course.getCredits()*16 + "\","+ "\"attendence\":" + "\"" + attendencelist.get(i).getAttendence()+ "\","+ "\"homework\":" + "\"" + attendencelist.get(i).getHomework() + "\","+ "\"midexam\":" + "\"" + attendencelist.get(i).getMidexam() + "\"," + "\"finalexam\":" + "\"" + attendencelist.get(i).getFinalexam()+ "\"," + "\"summary\":" + "\"" + attendencelist.get(i).getSummary()   + "\"},";
				  }else{
					  json = json+ "{\"semester\":\"" + semesters + "\"," + "\"coursename\":" + "\"" + course.getCoursename() + "\","+ "\"credits\":" + "\"" + course.getCredits() + "\","+ "\"lessoncount\":" + "\"" + course.getCredits()*16 + "\","+ "\"attendence\":" + "\"" + attendencelist.get(i).getAttendence()+ "\","+ "\"homework\":" + "\"" + attendencelist.get(i).getHomework() + "\","+ "\"midexam\":" + "\"" + attendencelist.get(i).getMidexam() + "\"," + "\"finalexam\":" + "\"" + attendencelist.get(i).getFinalexam() + "\"," + "\"summary\":" + "\"" + attendencelist.get(i).getSummary() + "\"},";				  
				  }
			   }else {
				   json = json+"{\"semester\":\"" + semesters + "\"," + "\"coursename\":" + "\"" + course.getCoursename() + "\","+ "\"credits\":" + "\"" + course.getCredits() + "\","+ "\"lessoncount\":" + "\"" + course.getCredits()*16 + "\","+ "\"attendence\":" + "\"" + attendencelist.get(i).getAttendence()+ "\","+ "\"homework\":" + "\"" + attendencelist.get(i).getHomework() + "\","+ "\"midexam\":" + "\"" + attendencelist.get(i).getMidexam() + "\"," + "\"finalexam\":" + "\"" + attendencelist.get(i).getFinalexam() + "\"," + "\"summary\":" + "\"" + attendencelist.get(i).getSummary() + "\"}]";				  
			   }
		   }
		}
		String data ="";
		if (student==null) {
			data = json+ "#";
		}else {
			String stu =  "[{\"id\":" + student.getId() + "," + "\"stuid\":" + "\"" + student.getStuid() + "\","+ "\"startdate\":" + "\"" + student.getStartdate() + "\","+ "\"stuname\":" + "\"" + student.getStuname() + "\","+ "\"engname\":" + "\"" + student.getFirstname()+" "+student.getLastname() + "\","+ "\"enddate\":" + "\"" + student.getEnddate() + "\","+ "\"nation\":" + "\"" + student.getNation() + "\"," + "\"classname\":" + "\"" + student.getClasses().getClassname()  + "\"}]";
			data = json + "#" +stu;
		}
		try {
			PrintWriter out = response.getWriter();
			out.write(data);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
    public String setemptyslot(){//设置选修上课时间
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String semester = request.getParameter("semester");
    	ActionContext.getContext().put("semester", semester);
    	return "setemptyslot";
    }
    public String selectresult(){//任课教师查看选修结果
    	//String classlist = studentService.classlist();
		//ActionContext.getContext().put("classlist", classlist);
    	return "selectresultcourselist";
    }
    public String loadselectcoursestu(){
    	String classlist = studentService.classlist();
    	ActionContext.getContext().put("classlist", classlist);
    	List<ChosenCourse> chosenCourses= manageService.loadselectcoursestu(course.getNum(),semChosenCourse.getSemester());
    	ActionContext.getContext().put("coursenum", course.getNum());
    	ActionContext.getContext().put("semester", semChosenCourse.getSemester());
    	return "selectresultlist";
    }
    public String selectresultlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = manageService.selectresultlist(page,pageSize);
		datatojson(map);
		return null;
	}
    
    public String emptyroomApply (){
    	String semester = manageService.getCurrSemester();
		User user = (User) ActionContext.getContext().getSession().get("user");
		if ((user.getRoles().getRolerank()!=2)&&(user.getRoles().getRolerank()!=4)) {
			ActionContext.getContext().put("message", "您不是任课教师，不能申请调课！");
			return "showmessage";
		}else {
			courseRet = manageService.loadSemesterChosenCoruseByTeacher(user.getUsernum(), semester);
			List<Syllabus> courses = new ArrayList<Syllabus>();

			Syllabus pleaseChoice = new Syllabus();
			pleaseChoice.setCourseName("请选择");
			pleaseChoice.setId(String.valueOf(-1));
			courses.add(pleaseChoice);

			Set<String> hasName = new HashSet<String>();
			for (ChosenCourseModel c : courseRet) {
				if (hasName.contains(c.getCourse().getCoursename())) {
					continue;
				} else {
					Syllabus s = new Syllabus(c);
					s.setId(c.getCourse().getNum());
					courses.add(s);
					hasName.add(c.getCourse().getCoursename());
				}
			}
			
			List<Classroom> rooms = manageService.classroomList();
			
			ActionContext.getContext().put("rooms", rooms);
			ActionContext.getContext().put("oldCourses", courses);

	    	return "emptyroomApply";
		}
		
    }
    
    public String chkNewEmptyRoomSlot () {
    	
    	int day = getDayofweek(plandate) - 2;
    	String semester = manageService.getCurrSemester();
    	
   	
    	// 找出该教室当天所有课程
    	List<SemesterChosenCourse> thatDay = manageService.courseListByWeekday(String.valueOf(day), semester);
    	
    	Set<String> slot = new HashSet<String>();
    	
    	
    	for (SemesterChosenCourse c: thatDay) {
    
    		if (c.getSlot() == null || c.getRoomname() == null)
    			continue;
    		if (c.getRoomname().equals(newnum))
    			slot.add(c.getSlot());
    	}
    	
    	// 使用该教室的已批准申请
    	List<Adjustcourse> ad = manageService.approvedAdjustApplyListByWeekday(String.valueOf(day), semester);
    	
    	for (Adjustcourse i : ad) {
    		if (i.getNewslot() == null || i.getNewRoomNum() == null)
    			continue;
    		if (i.getNewRoomNum().equals(newnum))
    			slot.add(i.getNewslot());
    	}
    	
    	//使用该教室的未批准申请
    	List<Adjustcourse> ad2 = manageService.ApplyingAdjustByWeekday(String.valueOf(day), semester);
    	
    	for (Adjustcourse i : ad2) {
    		if (i.getNewslot() == null || i.getNewRoomNum() == null)
    			continue;
    		if (i.getNewRoomNum().equals(newnum))
    			slot.add(i.getNewslot());
    	}
    	
    	// 去除上述课程所使用的时间
    	List<Syllabus> avlSlot = new ArrayList<Syllabus>();
    	for (int i = 0; i < 5; ++i) {
    		if (slot.contains(String.valueOf(i)))
    			continue;
    		Syllabus t = new Syllabus();
    		t.setSlot(i);
    		avlSlot.add(t);
    	}
    	
    	toJson(avlSlot);
		return null;
    }

    public String searchattendence(){
    	List<Classes> classlist = classService.loadclass();
    	List<Course> courseList = manageService.loadcourselist();
    	ActionContext.getContext().put("courselist", courseList);
    	ActionContext.getContext().put("classlist", classlist);
    	return "searchattendence";
    }
    
    public String statisticalcourse(){
    	
    	return "statisticalcourse";
    }
    
    public String batchaddstuchosencourse(){
    	manageService.batchaddstuchosencourse();
    	return null;
    }
    
	public String getNewRoomNum() {
		return newRoomNum;
	}

	public void setNewRoomNum(String newRoomNum) {
		this.newRoomNum = newRoomNum;
	}

	public String getOldRoomNum() {
		return oldRoomNum;
	}

	public void setOldRoomNum(String oldRoomNum) {
		this.oldRoomNum = oldRoomNum;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getInsertID() {
		return insertID;
	}

	public void setInsertID(String insertID) {
		this.insertID = insertID;
	}
    
    
}
