package com.tjpu.action;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import jxl.write.*;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.AdjustcourseModel;
import com.tjpu.bean.Assistantteacher;
import com.tjpu.bean.AssistantteacherModel;
import com.tjpu.bean.BatchRegiste;
import com.tjpu.bean.ChosenCourseModel;
import com.tjpu.bean.ClassRecord;
import com.tjpu.bean.Classes;
import com.tjpu.bean.Classroom;
import com.tjpu.bean.ClassroomModel;
import com.tjpu.bean.Course;
import com.tjpu.bean.Performance;
import com.tjpu.bean.Student;
import com.tjpu.bean.StudentModel;
import com.tjpu.bean.Syllabus;
import com.tjpu.bean.Teacher;
import com.tjpu.bean.User;
import com.tjpu.service.ClassService;
import com.tjpu.service.ManageService;
import com.tjpu.service.StudentService;
import com.tjpu.service.TranscriptService;
import com.tjpu.service.TranscriptServiceImpl;
/**
 * @author ZhangChong
 *
 */

@Controller
public class ClassAction {
	@Autowired
	ClassService classService;
	@Autowired
	StudentService studentService;
	@Autowired
	ManageService manageService;
	private Classes cls;
	private Student stu;
	
	private Classroom room;
	private Course course;
	private ClassRecord classrecord;
	private Performance performance;	
	private Assistantteacher assistantteacher;
    
	private File file;
    private String fileFileName;
    private int classid;
    private String queryType;
    private String queryID;
	private String semester;
    private String ids;
    private String fuzzyText;
    private String serial = "001";
    private Integer num;
    public String getFuzzyText() {
		return fuzzyText;
	}
	public void setFuzzyText(String fuzzyText) {
		this.fuzzyText = fuzzyText;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
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
	public String getQueryID() {
		return queryID;
	}
	public void setQueryID(String queryID) {
		this.queryID = queryID;
	}
	public Performance getPerformance() {
		return performance;
	}
	public void setPerformance(Performance performance) {
		this.performance = performance;
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
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}	
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public Classes getCls() {
		return cls;
	}
	public void setCls(Classes cls) {
		this.cls = cls;
	}
	public Classroom getRoom() {
		return room;
	}
	public void setRoom(Classroom room) {
		this.room = room;
	}
	public Assistantteacher getAssistantteacher() {
		return assistantteacher;
	}
	public void setAssistantteacher(Assistantteacher assistantteacher) {
		this.assistantteacher = assistantteacher;
	}
	
	private void datatojson(Map<String, Object> map) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		Gson gson = new Gson();
		String json = gson.toJson(map);
		// System.out.print(json);
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
	
	public String jmpHeadTeacher(){
		// 显示所有班主任的页面
		// 选择班主任
		// 更新
		return "setHeadTeacher";
	}
	
	public String classTeacherList(){
    	HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		List<Teacher> part = classService.loadClassTeacher(page - 1, pageSize);
		int total = classService.classTeacherNum();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Total", total);
		map.put("Rows", part);
		datatojson(map);
		teacherForFuzzy = manageService.loadAllAvlTeacher();
		return null;
    }
	
	private List<Teacher> teacherForFuzzy = null;
	
	public String classTeacherFuzzy(){
		if (fuzzyText == null)
			return null;
		
		try {
			fuzzyText = java.net.URLDecoder.decode(fuzzyText, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		if (teacherForFuzzy == null) {
			teacherForFuzzy = manageService.loadAllAvlTeacher();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		
		List<Teacher> ret = new ArrayList<Teacher>();
		for (Teacher t : teacherForFuzzy) {
			if (t.getTeachername() != null && t.getTeachername().indexOf(fuzzyText) != -1){
				t.setChosencourses(null);
				ret.add(t);
				continue;
			}
			if (t.getIdentificationnum() != null && t.getIdentificationnum().indexOf(fuzzyText) != -1){
				t.setChosencourses(null);
				ret.add(t);
				continue;
			}
			if (t.getPosition() != null && t.getPosition().indexOf(fuzzyText) != -1){
				t.setChosencourses(null);
				ret.add(t);
				continue;
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Total", ret.size());
		if (ret.size() < (page - 1) * pageSize)
			page = 0;
		if (page * pageSize > ret.size()) {
			map.put("Rows", ret);
			datatojson(map);
			return null;
		} 
		
		map.put("Rows", ret.subList((page - 1) * pageSize, page * pageSize));
		datatojson(map);
		
		return null;
	}
	
	public String setHeadTeacher () {

		classService.setNewClassTeacher(ids, queryID);
		return null;
	}

	public String setAssisTeacher(){
		// 把 assistantteacher的id更新到ids班级
		Integer id = assistantteacher.getId();
		classService.setNewAssisTeacher(ids, String.valueOf(id));
		return null;
	}
	
	public String jmpAssisList(){
		return "setAssisTeacher";
	}
	
	private void toJson(List<Classes> dat) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		
		for (Classes c : dat) {
			c.setStudents(null);
		}
		
		Gson gson = new Gson();
		//Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		/*GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.registerTypeAdapter(Classes.class, gsonBuilder);
	    Gson gson = gsonBuilder.create();*/
		String json = "{}";
		
		try {
			json = gson.toJson(dat);
		} catch (IllegalStateException e){
			e.printStackTrace();
		}
		
		/*json = gson.toJson(dat);*/
		
		//System.out.println(json);
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
	
	public String howManyClass (){
		
		if (queryID == null)
			return null;		
		List<Classes> onCharge = classService.chargeClassList(queryID);
		toJson(onCharge);
		return null;
	}
	
	public String AssishowMany (){
		if (queryID == null)
			return null;
		toJson(classService.assisClassList(queryID));
		return null;
	}
	public String issetminitor (){
		if (queryID == null)
			return null;
		List<Classes> cls= classService.classminitorlist(queryID);
		if (cls!=null) {
			Student student = new Student();
			String stunum = "";
			if (cls.get(0).getClassminitorid()!=null) {
				student = studentService.loadstubystuid(String.valueOf(cls.get(0).getClassminitorid()));
			    if(student==null){
			    	return null;
			    }else{
			    	stunum = student.getPassport()+" "+student.getStuname();
			    }				
			}			
		    HttpServletResponse response = ServletActionContext.getResponse();
		    response.setContentType("application/json;charset=utf-8");
		    PrintWriter out;			
			try {
				out = response.getWriter();
				out.write(stunum);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public String classmanage() {
		User user = (User)ActionContext.getContext().getSession().get("user");
		if (user.getRoles().getRolerank()==0||user.getRoles().getRolerank()==1) {
			String classlist = classService.classlist();
			ActionContext.getContext().put("classlist", classlist);
			return "classlist";
		}else if ((user.getRoles().getRolerank()==2)||(user.getRoles().getRolerank()==4)) {
			String classlist = classService.teacherclasslist();
			if (classlist.equals("")) {
				ActionContext.getContext().put("message", "您还不是班主任，没有管理的班级！");
				return "showmessage";
			}else{
				ActionContext.getContext().put("classlist", classlist);
				return "teacherclasslist";
			}			
		}else {
			ActionContext.getContext().put("message", "您没有权限查看！");
			return "showmessage";
		}
	}
	
	public String classList () {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));		
		Map<String, Object> map = classService.loadclassmap(page, pageSize);
		/*List<Classes> all = classService.loadclass();
		Map<String, Object> map = new HashMap<String, Object>();
		if (all.size() < pageSize * page){
			map.put("Rows", all.subList((page - 1) * pageSize, all.size()));
			map.put("Total", all.size() - (page - 1) * pageSize);
		} else {
			map.put("Rows", all.subList((page - 1) * pageSize, page * pageSize));
			map.put("Total", pageSize);
		}*/
		datatojson(map);
		return null;
	}

	public String classstulist() {
		classService.loadstulistbyclassid(cls.getId());
		//System.out.println(cls.getId());
		ActionContext.getContext().put("classesid", cls.getId());
		return "classstulist";
	}
	
	public String graduateclass(){
		classService.graduateclass(cls.getId());
		User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "ClassGraduate", "班级审核");
		return null;
	}
	
	public String graduateclassstulist(){
		classService.loadstulistbyclassid(cls.getId());
		ActionContext.getContext().put("classesid", cls.getId());
		return "graduateclassstulist";
	}
	public String graduatestulist(){
		classService.loadstulistbyclassid(cls.getId());
		if (serial == null) {
			serial = "001";
		}
		ActionContext.getContext().put("serial", serial);
		return "graduatestulist";
	}
	
	boolean isFlush = true;
	
	public String printDiploma (){
		if (stu == null ||stu.getId() == null)
			return null;
		Student student = studentService.loadstubyid(stu.getId());
		if (student == null)
			return null;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-word");
		String fileName = "Diploma.doc";
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("GB2312"), "8859_1"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		OutputStream out;
		try {
			out = response.getOutputStream();
			TranscriptService t = new TranscriptServiceImpl();
			t.getDiploma(out, student, serial);
			incSerial();
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void incSerial (){
		if (serial == null) {
			serial = "001";
		}
		Integer curr = Integer.parseInt(serial) + 1;
		serial = curr.toString();
		if (curr < 10) {
			serial = "0" + serial;
		}
		if (curr < 100) {
			serial = "0" + serial;
		}
	}
	
	public String classminitorset(){
		classService.classminitorset(cls.getId(),ids);
		return null;
	}
	
	public String loadclassstu(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = classService.classstumap(page, pageSize);
		datatojson(map);
		return null;
	}
	public String classbatchadd(){
		return "classbatchadd";
	}
	
	public String batchSetUpClass (){
		if (batchSetUp == null){
			return null;
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		
		
		@SuppressWarnings("unchecked")
		List<BatchRegiste> fail = (List<BatchRegiste>)batchSetUp.get("Fail");
		
		
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
	
	@SuppressWarnings("unchecked")
	public String jmpBatchSetUp (){
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
			batchSetUp = classService.batchSetUpClass(realpath + "\\" + filename);
			List<BatchRegiste> fail = (List<BatchRegiste>)batchSetUp.get("Fail");
			if (fail.size() == 0) {
				return "batchSuccess";
			}
			ActionContext.getContext().put("succeed", String.valueOf(batchSetUp.get("Count")));
			ActionContext.getContext().put("msg", " ");
		} else {
			ActionContext.getContext().put("msg", "添加失败,请重新添加！");
		}
		return "batchSetUpClass";
	}
	
	private Map<String, Object> batchSetUp = null;
	
	public String classaddbytxt(){
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
			List<Classes> classlist = classService.classaddbytxt(realpath + "\\" + filename);
		    ActionContext.getContext().put("classlist", classlist);		    
		} else {
			ActionContext.getContext().put("msg", "添加失败,退出请重新添加！");
		}
		return "uploadmsg";
	}
	public String classbeginadd() {
		return "classadd";
	}

	public String classcheck() {
		HttpServletResponse response = ServletActionContext.getResponse();
		String classname = null;
		try {
			classname = java.net.URLDecoder.decode(cls.getClassname(),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		boolean flg = classService.classcheck(classname);
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
	public String classcheckagain() {
		HttpServletResponse response = ServletActionContext.getResponse();
		String classname = null;
		 try {
		    classname = java.net.URLDecoder.decode(cls.getClassname(),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
		   e1.printStackTrace();
		 }
		boolean flg = classService.classcheck(classname);
		if (!flg) {
			List<Classes> classes = classService.loadclasses(cls.getId(),classname);
 			if (classes.size()>0) {
				return null;
			}else {
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
		}
		return null;
	}
	

	public String classendadd() {
		classService.classadd(cls);
		User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "AddClass", "添加班级");
		return null;
	}
    public String classedit(){
    	Classes classes = classService.loadclassbyid(cls.getId());
    	ActionContext.getContext().put("classes", classes);
    	return "classedit";
    }
	public String classupdate() {
		classService.classupdate(cls);
		User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "UpdateClass", String.valueOf(cls.getId()));
		return null;
	}

	public String classdelete() {
		classService.classdelete(cls.getId());
		User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "DeleteClass", String.valueOf(cls.getId()));
		return null;
	}
	
	public String classrecovery(){
		classService.classrecovery(cls.getId());
		User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "RecoveryClass", String.valueOf(cls.getId()));
		return null;
	}
	
	public String assistantteachermanage(){
		return "assistantteachermanage";
	}
	
	
	public String coursemanage() {
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
		return "courselist";
	}

	public String courselist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = classService.courselist(page, pageSize);
		datatojson(map);
		return null;
	}

	public String courseFuzzy (){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		try {
			fuzzyText = java.net.URLDecoder.decode(fuzzyText, "UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		datatojson(classService.courseFuzzySearch(fuzzyText, page, pageSize, Integer.parseInt(queryType)));
		return null;
	}
	
	public String coursesearch() {
		classService.coursesearch(course);
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = classService.coursesearchlist(page, pageSize);
		datatojson(map);
		return null;
	}

	public String courselistmanage(){
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
		return "coursestulist";
	}
	
	public String coursestulist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = classService.courselist(page, pageSize);
		datatojson(map);
		return null;
	}
	public String coursebeginadd() {
		return "courseadd";
	}

	public String coursecheck() {
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = classService.coursecheck(course.getCoursename());
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

	public String coursecheck1() {
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = classService.coursecheck1(course.getNum());
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
	
	public String courseUniqueChk (){
		try {
			course.setCoursename(java.net.URLDecoder.decode(course.getCoursename(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Course c = classService.loadcoursebynum(course.getNum());
		List<Classes> flag = new ArrayList<Classes>();
		if (c != null){
			flag.add(new Classes());
			toJson(flag);
			return null;
		}		
		//允许重名
		/*boolean ret = classService.coursecheck(String.valueOf(course.getCoursename()));
		if (!ret){
			flag.add(new Classes());
			toJson(flag);
			return null;
		}*/
		
		toJson(flag);
		
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public String jmpBatchAddCourses () {
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
			batchCourse = classService.batchAddCourses(realpath + "\\" + filename);
			List<BatchRegiste> fail = (List<BatchRegiste>)batchCourse.get("Fail");
			if (fail.size() == 0) {
				return "batchSuccess";
			}
			ActionContext.getContext().put("succeed", String.valueOf(batchCourse.get("Count")));
			ActionContext.getContext().put("msg", " ");
		} else {
			ActionContext.getContext().put("msg", "添加失败,请重新添加！");
		}
		return "batchCourseAddResult";
	}
	
	public String batchAddCourses (){
		if (batchCourse == null){
			return null;
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		
		
		@SuppressWarnings("unchecked")
		List<BatchRegiste> fail = (List<BatchRegiste>)batchCourse.get("Fail");
		
		
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
	
	private Map<String, Object> batchCourse = null;
	
	public String jmpLoadTxt (){
		return "batchCourseAdd";
	}
	
	public String courseendadd() {
		if (course.getAcademic() != null) {
			try {
				course.setAcademic(java.net.URLDecoder.decode(course.getAcademic(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		classService.courseadd(course);
		return null;
	}
    public String courseedit(){
    	Course courses = classService.loadcoursebyid(course.getId());
    	ActionContext.getContext().put("courses", courses);
    	return "courseedit";
    }
	
	public String courseupdate() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		classService.courseupdate(course, user);
		return null;
	}

	public String coursedelete() {
		//classService.coursedelete(course.getId());
		classService.coursedelete(Integer.parseInt(ids));
		User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "DeleteCourse", ids);
		return null;
	}
	public String courserecovery(){
		classService.courserecovery(course.getId());
		return null;
	}
	public String clsroommanage(){
		 //StringBuilder columns = new StringBuilder("["); 
		// columns.append("{display:'id',name:'id',align:'center',width:60}");
		// columns.append("]"); 
		 //ActionContext.getContext().put("column", columns.toString());
		return "classroomlist";
	}
	public String roomlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = classService.roomlist(page, pageSize);
		datatojson(map);	
		return null;
	}
	
	public String roomSearch (){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		try {
			room.setRoomplace(java.net.URLDecoder.decode(room.getRoomplace(), "UTF-8"));
			room.setRoomtype(java.net.URLDecoder.decode(room.getRoomtype(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		datatojson(classService.classroomSearch(room.getRoomcapacity(), room.getRoomplace(), room.getRoomtype(), page, pageSize));
		return null;
	}
	
	private List<Classroom> allRooms = null;

	
	public String getCapList (){
		if (allRooms == null || allRooms.size() == 0 || room.getRoomplace() == null)
			return null;
		//System.out.println(room.getRoomplace());
		try {
			room.setRoomplace(java.net.URLDecoder.decode(room.getRoomplace(), "UTF-8"));
			room.setRoomtype(java.net.URLDecoder.decode(room.getRoomtype(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//System.out.println(room.getRoomplace());
		List<Classroom> cap = new ArrayList<Classroom>();
		Set<Integer> set = new HashSet<Integer>();
		for (Classroom r : allRooms) {
			if (room.getRoomplace().equals(r.getRoomplace())
					&& room.getRoomtype().equals(r.getRoomtype())
					&& !set.contains(r.getRoomcapacity())){
				cap.add(r);
				set.add(r.getRoomcapacity());
			}
		}
		toJson2(cap);
		return null;
	}
	
	private void toJson2(List<Classroom> dat) {
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

	public String roombeginadd() {
		return "roomadd";
	}
    public String roombatchadd(){
    	return "roombatchadd";
    }
    @SuppressWarnings("unchecked")
	public String roomaddbytxt(){
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
			if (filename == null){
				ActionContext.getContext().put("msg", "添加失败,请重新添加！");
				return null;
			}
			batchSetUp = classService.roomaddbytxt(realpath + "\\" + filename);
			List<BatchRegiste> fail = (List<BatchRegiste>)batchSetUp.get("Fail");
			if (fail.size() == 0) {
				return "batchSuccess";
			}
			ActionContext.getContext().put("succeed", String.valueOf(batchSetUp.get("Count")));
			ActionContext.getContext().put("msg", " ");
		} else {
			ActionContext.getContext().put("msg", "添加失败,退出请重新添加！");
		}
		return "roomuploadmsg";
	}
	public String roomcheck() {
		HttpServletResponse response = ServletActionContext.getResponse();
		String roomname = null;
		try {
			roomname = java.net.URLDecoder.decode(room.getRoomname(),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		boolean flg = classService.roomcheck1(roomname);
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
	public String roomcheckagain() {
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = classService.roomcheck1(room.getRoomname());
		if (!flg) {
			List<Classroom> classrooms = classService.roomcheckagain(room.getId(),String.valueOf(room.getRoomname()));
			if (classrooms.size()>0) {
				return null;
			}else {
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
			
		}
		return null;
	}
	public String  roomsearch(){
		classService.roomsearch(room);
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = classService.searchroomlist(page, pageSize);
		datatojson(map);
		return null;
	}
    public String assistteacherlist(){
    	return "assistantteacherlist";
    }
   
    
    public String assistprint(){
    	Assistantteacher assist = classService.loadassistbyid(assistantteacher.getId());
    	ActionContext.getContext().put("assistteacher", assist);
    	return "assistprint";
    }
    public String assistapply(){
    	return "assistapply";
    }
    public String assistedit(){
    	Assistantteacher assit = classService.loadassistbyid(assistantteacher.getId());
    	ActionContext.getContext().put("assist", assit);
    	return "assistedit";
    }
    public String assistagree(){
    	classService.assistagree(assistantteacher.getId());
    	return null;
    }
    public String assistagainst(){
    	classService.assistagainst(assistantteacher.getId());
    	return null;
    }
    
    public String assistlist(){
    	HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = classService.assistmap(page, pageSize);
		datatojson(map);
		assisForFuzzy = classService.loadAllAssis();
		return null;
    }
    public String assistcheckstunum(){
    	HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = classService.assistcheck(assistantteacher.getAssistantnum());
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
    private List<AssistantteacherModel> assisForFuzzy = null;
    public String assisTeacherFuzzy(){
		if (fuzzyText == null)
			return null;
		
		try {
			fuzzyText = java.net.URLDecoder.decode(fuzzyText, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		if (assisForFuzzy == null) {
			assisForFuzzy = classService.loadAllAssis();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		
		List<AssistantteacherModel> ret = new ArrayList<AssistantteacherModel>();
		for (AssistantteacherModel t : assisForFuzzy) {
			if (t.getName() != null && t.getName().indexOf(fuzzyText) != -1){
				ret.add(t);
				continue;
			}
			if (t.getPoliticalstatus() != null && t.getPoliticalstatus().indexOf(fuzzyText) != -1){
				ret.add(t);
				continue;
			}
			if (t.getSecondlanguagetype() != null && t.getSecondlanguagetype().indexOf(fuzzyText) != -1){
				ret.add(t);
				continue;
			}
			if (t.getMajor() != null && t.getMajor().indexOf(fuzzyText) != -1){
				ret.add(t);
				continue;
			}
			if (t.getAssistantnum() != null && t.getAssistantnum().indexOf(fuzzyText) != -1){
				ret.add(t);
				continue;
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Total", ret.size());
		if (ret.size() < (page - 1) * pageSize)
			page = 0;
		if (page * pageSize > ret.size()) {
			map.put("Rows", ret);
			datatojson(map);
			return null;
		} 
		
		map.put("Rows", ret.subList((page - 1) * pageSize, page * pageSize));
		datatojson(map);
		
		return null;
	}
    
    
    public String assistantteacheradd(){
    	classService.assistantteacherapply(assistantteacher);
    	return null;
    }
    public String assistantteacherupdate(){
    	classService.assistantteacherupdate(assistantteacher);
    	return null;
    }
    public String assistdelete(){
    	classService.assistantteacherdelete(assistantteacher);
    	User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "DeleteAssistance", String.valueOf(assistantteacher.getId()));
    	return null;
    }
	public String clsroomload(){
		allRooms = manageService.classroomList();
		ActionContext.getContext().put("allRooms", allRooms);
		return "clsroomload";
	}
	
	public String roomendadd() {
		classService.roomadd(room);
		return null;
	}
    public String roomedit(){
    	Classroom classroom = classService.loadclassroombyid(room.getNum());
    	List<Classroom> roomtype = classService.loadclassroombyisavaible();
    	for (int i = 0; i < roomtype.size(); i++) {
			for (int j = roomtype.size()-1; j>i; j--) {
			if (roomtype.get(i).getRoomtype().equals(roomtype.get(j).getRoomtype())) {
				//semestercourses.add(semestercourselist.get(i));
				roomtype.remove(roomtype.get(i));
			}
			}
		}
    	ActionContext.getContext().put("classroom", classroom);
    	ActionContext.getContext().put("roomtypes", roomtype);
    	return "classroomedit";
    }
	public String roomupdate() {
		classService.roomupdate(room);
		User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "UpdateRoom", String.valueOf(room.getNum()));		
		return null;
	}

	public String roomdelete() {
		classService.roomdelete(room.getNum());
		User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "DeleteRoom", String.valueOf(room.getNum()));
		return null;
	}
	public String roomrecovery(){
		classService.roomrecovery(room.getNum());
		User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "RecoveryRoom", String.valueOf(room.getNum()));		
		return null;
	}
	public String downloadSyllabus() {
		if (currCulum == null)
			return null;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel");
		String fileName = "课程表.xls";
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("GB2312"), "8859_1"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		OutputStream out;
		try {
			out = response.getOutputStream();
			classService.toExcel(out, currCulum);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String downloadOnChargedSyllabus() {
		if (currCulum == null)
			return null;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel");
		String fileName = "课程表.xls";
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("GB2312"), "8859_1"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		OutputStream out;
		try {
			out = response.getOutputStream();
			if (num == null) {
				num = 0;
			}
			classService.toExcel(out, arranged2.get(num));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private List<Syllabus> currCulum = null;
	private List<List<Syllabus>> arranged2 = null;
	public String curriculum(){
		List<ChosenCourseModel> courses = null;
		User user = (User) ActionContext.getContext().getSession().get("user");
		if ((user.getRoles().getRolerank()==2)||(user.getRoles().getRolerank()==4)) {
			queryID = String.valueOf(user.getUsernum());
			semester = manageService.getCurrSemester();
			courses = classService.getPerSyllabus(queryID, null, null, semester);
			/*queryType = "teacherID";
			//queryID = user.getUsernum();
			if (queryType.equals("teacherID"))
				courses = classService.getPerSyllabus(queryID, null, null, semester);
			else if (queryType.equals("classID"))
				courses = classService.getPerSyllabus(null, null, queryID, semester);
			else if (queryType.equals("courseID"))
				courses = classService.getPerSyllabus(null, queryID, null, semester);
			else 
				courses = classService.getPerSyllabus(null, null, null, semester);*/
			// 放到页面上
			boolean isfind = false;
			List<Syllabus> arranged = new ArrayList<Syllabus>();
			for (int slot = 0; slot < 5; ++slot) {
				for (int day = 0; day < 5; ++day) {
					isfind = false;
					for (ChosenCourseModel p : courses){
						if (p.getSlot() == slot && p.getWeekday() == day) {
							Syllabus t = new Syllabus(p);
							t.setNote(String.format("%d-%d周", p.getBeginWeek(), p.getEndWeek()));
							arranged.add(t);
							isfind = true;
							break;
						}
					} 
					if (!isfind)
						arranged.add(new Syllabus());
				}
			}
			currCulum = arranged;
			List<AdjustcourseModel> relateAdjust = manageService.loadRelateAdjustCourse(user.getUsernum(), semester);
			ActionContext.getContext().put("courses", arranged);
			ActionContext.getContext().put("relateAdjust", relateAdjust);
			
			// 班主任管理的班级的课表
			
			// 找出所有管理的班级
			List<Classes> charged = classService.chargeClassList(user.getUsernum());
			//分别查询课表
			List<List<ChosenCourseModel>> onChargeClasses = new ArrayList<List<ChosenCourseModel>>();
			for (Classes i : charged) {
				onChargeClasses.add(classService.getPerSyllabus(null, null, i.getId().toString(), semester));
			}
			boolean isfind2 = false;
			//List<Syllabus> arranged2 = new ArrayList<Syllabus>();
			arranged2 = new ArrayList<List<Syllabus>>();
			for (List<ChosenCourseModel> i : onChargeClasses) {
				List<Syllabus> ta = new ArrayList<Syllabus>();
				for (int slot = 0; slot < 5; ++slot) {
					for (int day = 0; day < 5; ++day) {
						isfind2 = false;
						for (ChosenCourseModel p : i){
							if (p.getSlot() == slot && p.getWeekday() == day) {
								Syllabus t = new Syllabus(p);
								t.setNote(String.format("%d-%d周", p.getBeginWeek(), p.getEndWeek()));
								ta.add(t);
								isfind2 = true;
								break;
							}
						}
						if (!isfind2)
							ta.add(new Syllabus());
					}
				}
				arranged2.add(ta);
			}
			List<String> chargedClassNames = new ArrayList<String>();
			for (Classes s : charged) {
				chargedClassNames.add(s.getClassname());
			}
			ActionContext.getContext().put("className", chargedClassNames);
			ActionContext.getContext().put("courses", arranged);
			ActionContext.getContext().put("courses2", arranged2);
			//ActionContext.getContext().put("relateAdjust", new ArrayList<AdjustcourseModel>());
			return "classTeacherCurriculum";
		} else if(user.getRoles().getRolerank()==0 || user.getRoles().getRolerank() == 1) {
			//显示管理员课表
			return perSyllabus();
		} else if(user.getRoles().getRolerank()==3) {
			// 学生课表
			return stuSyllabus();
		}
		return null;
	}
	
	private String stuSyllabus(){
		semester = manageService.getCurrSemester();
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<ChosenCourseModel> courses = manageService.getStuSyllabus(user.getUsernum(), semester);
		boolean isfind = false;
		List<Syllabus> arranged = new ArrayList<Syllabus>();
		for (int slot = 0; slot < 5; ++slot) {
			for (int day = 0; day < 5; ++day) {
				isfind = false;
				for (ChosenCourseModel p : courses){
					if (p.getSlot() == slot && p.getWeekday() == day) {
						Syllabus t = new Syllabus(p);
						t.setNote(String.format("%d-%d周", p.getBeginWeek(), p.getEndWeek()));
						arranged.add(t);
						isfind = true;
						break;
					}
				}
				if (!isfind)
					arranged.add(new Syllabus());
			}
		}
		currCulum = arranged;
		ActionContext.getContext().put("courses", arranged);
		ActionContext.getContext().put("relateAdjust", new ArrayList<AdjustcourseModel>());
		return "curriculum";
	}
	
	private String perSyllabus (){
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
							Syllabus t = new Syllabus(p);
							t.setNote(String.format("%d-%d周", p.getBeginWeek(), p.getEndWeek()));
							arranged.add(t);
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
	
    public String classteacherworkrecord(){
    	return "classteacherworkrecord";
    }
    
    public String workrecordlist(){
    	HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = classService.workrecordmap(page, pageSize);
		datatojson(map);
		return null;
    }
    public String workrecordedit(){
    	User user = (User) ActionContext.getContext().getSession().get("user");
    	List<Classes> teacherclass = classService.classteacherclass(user.getUsernum());    	
    	ActionContext.getContext().put("teacherclass", teacherclass);
    	ClassRecord classrecords = classService.loadworkrecord(classrecord.getId());
    	Student student = classService.loadclassmonitor(classrecords.getClassid());
    	ActionContext.getContext().put("stu", student);
    	ActionContext.getContext().put("work", classrecords);
    	return "workrecordedit";
    }
    public String workrecordupdate(){
    	//System.out.println(classrecord.getAppointmentnumber());
    	classService.workrecordedit(classrecord);
    	User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "UpdateWorkRecord", String.valueOf(classrecord.getId()));		
    	return null;
    }
    public String workrecorddelete(){
    	classService.workrecorddelete(ids);
    	User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "DeleteWorkRecord", String.valueOf(classrecord.getId()));		    	
    	return null;
    }
    public String workrecordbegainadd(){
    	User user = (User) ActionContext.getContext().getSession().get("user");
    	List<Classes> teacherclass = classService.classteacherclass(user.getUsernum());
    	if (teacherclass==null) {
			ActionContext.getContext().put("message", "您不是班主任或您未和班级关联！");
			return "showmessage";
		}else {
			//Student student = classService.loadminitor(teacherclass.getClassminitorid());
	    	//ActionContext.getContext().put("student", student);
	    	ActionContext.getContext().put("teacherclass", teacherclass);
	    	return "workrecordadd";
		}   	
    	
    }
    public String workrecordendadd(){
    	classService.workrecordadd(classrecord);
    	return null;
    }
    public String workrecorddetail(){
    	User user = (User) ActionContext.getContext().getSession().get("user");
    	List<Classes> teacherclass = classService.classteacherclass(user.getUsernum());
    	//Student student = classService.loadminitor(teacherclass.getClassminitorid());
    	//ActionContext.getContext().put("student", student);
    	ActionContext.getContext().put("teacherc", teacherclass);
    	ClassRecord classrecords = classService.workrecorddetail(classrecord.getId());
    	Student student = classService.loadclassmonitor(classrecords.getClassid());
    	ActionContext.getContext().put("student", student);
    	ActionContext.getContext().put("workrecord", classrecords);
    	return "workrecorddetail";
    }
    public String studentsituation(){
    	return "studentsituation";
    }
    public String checkmonitor(){
		HttpServletResponse response = ServletActionContext.getResponse();
		Student student = classService.loadclassmonitor(cls.getId());
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print(student.getStuname());
				out.flush();
				out.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		return null;
	}
    public String performancelist(){
    	HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = classService.performancemap(page, pageSize);
		datatojson(map);
		return null;
    }
    public String performancebegainadd(){
    	User user = (User) ActionContext.getContext().getSession().get("user");
    	List<Classes> teacherclass = classService.classteacherclass(user.getUsernum());
    	List<Classes> classlist = classService.classteacherclass(user.getUsernum());
    	ActionContext.getContext().put("classlist", classlist);
    	
    	if (teacherclass.size()==0) {
			ActionContext.getContext().put("message", "您不是班主任或您未和班级关联！");
			return "showmessage";
		}else {
    	return "performanceadd";
		}
    }
    public String performanceendadd(){
    	classService.performanceadd(performance);
    	return null;
    }
    public String performanceedit(){
    	User user = (User) ActionContext.getContext().getSession().get("user");
    	List<Classes> teacherclass = classService.classteacherclass(user.getUsernum());
    	if (teacherclass.size()==0) {
			ActionContext.getContext().put("message", "您不是班主任或您未和班级关联！");
			return "showmessage";
		}else {
		Performance performances = classService.loadstuperformance(performance.getId());
		Student student = studentService.loadstubystuid(performances.getPassport());
		ActionContext.getContext().put("stu", student);
    	ActionContext.getContext().put("per", performances);
    	return "performanceedit";
		}
    }
    public String performanceupdate(){
    	classService.performanceupdate(performance);
    	User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "PerformanceUpdate", String.valueOf(performance.getId()));		   	
    	return null;
    }
    public String performancedelete(){
    	classService.performancedelete(ids);
    	User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "DeletePerformance", String.valueOf(ids));		    	
    	return null;
    }
    public String classstudownload() throws Exception{
 	   HttpServletResponse response = ServletActionContext.getResponse();
 	   response.reset();
 	   response.setCharacterEncoding("UTF-8");
 	   response.setContentType("application/vnd.ms-excel");
 	   Classes classes = classService.loadclassbyid(cls.getId());
 	   String fileName=classes.getClassname()+" 班级学生名单.xls";
 	   response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("GB2312"), "8859_1"));
 	   OutputStream out = response.getOutputStream();    	 	   
 	   try {
		WritableWorkbook workbook = Workbook.createWorkbook(out);
		WritableSheet ws = workbook.createSheet(classes.getClassname()+" 学生名单", 0);
		WritableFont wf = new WritableFont(WritableFont.TIMES,10,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);//设置字体格式
		WritableCellFormat wef = new WritableCellFormat(wf);//创建格式化对象实例
		wef.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//垂直居中
		wef.setAlignment(Alignment.CENTRE);//水平居中
		//工作表标题行（new Label（列，行，内容，格式））
		ws.addCell(new Label(0,0,"护照号",wef));
		ws.addCell(new Label(1,0,"学号",wef));
		ws.addCell(new Label(2,0,"中文名",wef));
		ws.addCell(new Label(3,0,"英文名",wef));
		ws.addCell(new Label(4,0,"英文姓",wef));
		ws.addCell(new Label(5,0,"性别",wef));
		ws.addCell(new Label(6,0,"国籍",wef));
		ws.addCell(new Label(7,0,"住址",wef));
		ws.addCell(new Label(8,0,"电话",wef));
		ws.addCell(new Label(9,0,"班级",wef));
		List<Student> students = classService.loadstubyclassid(cls.getId());
		List<Object[]> dataList = new ArrayList<Object[]>(); 
		for(Student temp:students){
			Object[] stu = {temp.getPassport(),temp.getStuid(),temp.getStuname(),temp.getFirstname(),temp.getLastname(),temp.getSex(),temp.getNation(),temp.getRoomplace(),temp.getTelephone(),temp.getClasses().getClassname()};
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
	public ClassRecord getClassrecord() {
		return classrecord;
	}
	public void setClassrecord(ClassRecord classrecord) {
		this.classrecord = classrecord;
	}
	public String stucheck(){
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = classService.stucheck(stu.getStuid(),cls.getId(),stu.getStuname());
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
	public String classteacherlist(){
		return "classteacherlist";
	}
	public String classteacherList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = classService.classteachermap(page, pageSize);
		datatojson(map);
		return null;
	}
	public String classStuList(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");		
		List<Student> students = classService.loadstubyclassid(cls.getId());
		List<StudentModel> studentModels = new ArrayList<StudentModel>();
		for(Student s:students){
			StudentModel  stu = new StudentModel();
			stu.setId(s.getId());
			stu.setBrithdate(s.getBrithdate());
			stu.setStuid(s.getStuid());
			stu.setStuname(s.getStuname());
			stu.setFirstname(s.getFirstname());
			stu.setLastname(s.getLastname());
			stu.setPassport(s.getPassport());
			studentModels.add(stu);
		}
		Gson gson = new Gson(); 		
		String json = "{}";
		try {
			json = gson.toJson(studentModels);
			PrintWriter out;
			out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
}
