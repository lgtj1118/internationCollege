package com.tjpu.action;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.BatchRegiste;
import com.tjpu.bean.ChosenCourse;
import com.tjpu.bean.Classes;
import com.tjpu.bean.Classroom;
import com.tjpu.bean.Course;
import com.tjpu.bean.Student;
import com.tjpu.bean.User;
import com.tjpu.service.ClassService;
import com.tjpu.service.ManageService;
import com.tjpu.service.StudentService;
import com.tjpu.service.TranscriptService;
import com.tjpu.service.TranscriptServiceImpl;

@Controller
public class StudentAction {
	
	@Autowired
	StudentService studentService;
	@Autowired
	ManageService manageService;
	@Autowired
	ClassService classService;
	private File file;
	private File image;
	private String imageFileName;
	private String fileFileName;
    private Student stu;
    private Classes cls;
    private Course course;
    private String query;
    private String serial;
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
    public Course getCourse() {
		return course;
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

	public void setCourse(Course course) {
		this.course = course;
	}
	private String ids;
    public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	private int classid;
    public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}
	
	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Classes getCls() {
		return cls;
	}

	public void setCls(Classes cls) {
		this.cls = cls;
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

	public String stumanage() {
		String classlist = studentService.classlist();
		ActionContext.getContext().put("classlist", classlist);
		return "stulist";
	}

	public String stulist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = studentService.studentmap(page, pageSize);
		datatojson(map);
		return null;
	}
    public String stuedit(){
    	Student student = studentService.loadstubyid(stu.getId());
    	ActionContext.getContext().put("student", student);
    	List<Classes> classlist = studentService.classlist1();
		ActionContext.getContext().put("classlist", classlist);
    	return "studentedit";
    }
	public String stuupdate(){
		studentService.stuupdate(stu, classid/* ,major */);
		return null;
	}
	public String stubaseupdate(){
		Student student = studentService.loadstubyid(stu.getId());
		List<Classes> classlist = studentService.classlist1();
		ActionContext.getContext().put("classlist", classlist);
		ActionContext.getContext().put("student", student);
		return "stubaseupdate";
	}
	
	public String stuendupdate(){
		studentService.stubaseupdate(stu,classid);
		return null;
	}
	
	public String studelete(){
		studentService.studelete(ids);
		User user = (User) ActionContext.getContext().getSession().get("user");
    	manageService.ModifyLog(user, "DeleteStudent", ids);
		return null;
	}
	public String stubeginadd(){
		List<Classes> classlist = studentService.classlist1();
		ActionContext.getContext().put("classlist", classlist);
		return "stuadd";
	}
	public String classstubeginadd(){
		List<Classes> classlist = studentService.classlist1();
		ActionContext.getContext().put("clsid", cls.getId());
		ActionContext.getContext().put("classlist", classlist);
		return "classstuadd";
	}
	public String stucheck(){
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = studentService.stucheck(stu.getPassport());
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
	public String stucheckagain(){
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = studentService.stucheck(stu.getPassport());
		if (!flg) {
			List<Student> students = studentService.stucheckagain(stu.getId(),stu.getPassport());
			if (students.size()>0) {
				return null;
			}else{
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
	public String stuendadd(){
		studentService.stuadd(stu,classid);
		return null;
	}
	public String stubaseinfo(){	
		User user = (User) ActionContext.getContext().getSession().get("user");
        if (user.getRoles().getId()==4) {
        	Student student = studentService.loadstubyid(user.getId());
    		ActionContext.getContext().put("student", student);
		}else {
			ActionContext.getContext().put("message", "该基本信息只显示学生！！");
		}		
		return "stubaseinfo";
	}
	
	public String stubatchadd(){
		return "stubatchadd";
	}
	public String stubatchaddimage(){
		return "stubatchaddimage";
	}
	public String classstubatchadd(){
		ActionContext.getContext().put("classids", cls.getId());
		System.out.println(cls.getId());
		return "classstubatchadd";
	}
	
	private Map<String, Object> batchStuMsg = null;
	public String batchRegisterStudents (){
		if (batchStuMsg == null){
			return null;
		}

		
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		
		
		@SuppressWarnings("unchecked")
		List<BatchRegiste> fail = (List<BatchRegiste>)batchStuMsg.get("Fail");
		
		
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
	
	private String batchStuFileName = null;
	
	@SuppressWarnings("unchecked")
	public String jmpStuBatch(){
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
			batchStuFileName = s.concat(name);
			if (!savedir.exists())
				savedir.mkdirs();
			try {
				File savefile = new File(savedir, batchStuFileName);
				FileUtils.copyFile(file, savefile);
			} catch (IOException e) {
				
				e.printStackTrace();
			}	
			if (batchStuFileName == null){
				ActionContext.getContext().put("msg", "添加失败,请重新添加！");
				return null;
			}
			batchStuMsg = studentService.registerStudentByFile(realpath + "\\" + batchStuFileName);
			List<BatchRegiste> fail = (List<BatchRegiste>)batchStuMsg.get("Fail");
			if (fail.size() == 0) {
				return "batchSuccess";
			}
			ActionContext.getContext().put("succeed", String.valueOf(batchStuMsg.get("Count")));
			ActionContext.getContext().put("msg", " ");
		} else {
			
		}
		return "batchRegisteResult";
	}
	
	public String stuaddbytxt(){
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
			List<Student> students = studentService.stuaddbytxt(realpath + "\\" + filename);
			ActionContext.getContext().put("students", students);
		} else {
			ActionContext.getContext().put("msg", "添加失败,退出请重新添加！");
		}
		return "uploadmsg";
	}
	public String classstuaddbytxt(){
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
			List<Student> students = studentService.classstuaddbytxt(realpath + "\\" + filename,cls.getId());
			ActionContext.getContext().put("students", students);
		} else {
			ActionContext.getContext().put("msg", "添加失败,退出请重新添加！");
		}
		return "uploadmsg";
	}
	public String studownload() throws Exception{
	 	   HttpServletResponse response = ServletActionContext.getResponse();
	 	   response.reset();
	 	   response.setCharacterEncoding("UTF-8");
	 	   response.setContentType("application/vnd.ms-excel");
	 	  String fileName="学生名单.xls";
	 	   response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("GB2312"), "8859_1"));
	 	   OutputStream out = response.getOutputStream();    	 	   
	 	   try {
			WritableWorkbook workbook = Workbook.createWorkbook(out);
			WritableSheet ws = workbook.createSheet("学生名单", 0);
			WritableFont wf = new WritableFont(WritableFont.TIMES,10,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);//设置字体格式
			WritableCellFormat wef = new WritableCellFormat(wf);//创建格式化对象实例
			wef.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//垂直居中
			wef.setAlignment(Alignment.CENTRE);//水平居中
			//工作表标题行（new Label（列，行，内容，格式））
			ws.addCell(new Label(0,0,"学号",wef));
			ws.addCell(new Label(1,0,"护照号",wef));
			ws.addCell(new Label(2,0,"中文名",wef));
			ws.addCell(new Label(3,0,"英文名",wef));
			ws.addCell(new Label(4,0,"英文姓",wef));
			ws.addCell(new Label(5,0,"性别",wef));
			ws.addCell(new Label(6,0,"国籍",wef));
			ws.addCell(new Label(7,0,"出生年月",wef));
			ws.addCell(new Label(8,0,"住址",wef));
			ws.addCell(new Label(9,0,"电话",wef));
			ws.addCell(new Label(10,0,"班级",wef));
			ws.addCell(new Label(11,0,"专业",wef));
			ws.addCell(new Label(12,0,"学生类别",wef));
			ws.addCell(new Label(13,0,"入学时间",wef));
			ws.addCell(new Label(14,0,"离校时间",wef));
			ws.addCell(new Label(15,0,"居留许可有效期",wef));
			ws.addCell(new Label(16,0,"来源",wef));
			ws.addCell(new Label(17,0,"学制",wef));
			ws.addCell(new Label(18,0,"教育层次",wef));
			List<Student> students = studentService.loadallstu();
			List<Object[]> dataList = new ArrayList<Object[]>(); 
			for(Student temp:students){
				Object[] stu = {temp.getStuid(),temp.getPassport(),temp.getStuname(),temp.getFirstname(),temp.getLastname(),temp.getSex(),temp.getNation(),temp.getBrithdate(),temp.getRoomplace(),temp.getTelephone(),temp.getClasses().getClassname(),temp.getClasses().getMajor()
						,temp.getStudentType(),temp.getStartdate(),temp.getEnddate(),temp.getValidResidencePermit(),temp.getSource(),temp.getDuration(),temp.getStudyLevel()};
				dataList.add(stu);
			}
			////向工作表添加数据
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
	public String coursestudownload() throws Exception{
	 	   HttpServletResponse response = ServletActionContext.getResponse();
	 	   HttpServletRequest request = ServletActionContext.getRequest();
	 	   String coursenum = request.getParameter("coursenum");
	 	   String semester = request.getParameter("semester");
	 	   Course course = classService.loadcoursebynum(coursenum);
	 	   response.reset();
	 	   response.setCharacterEncoding("UTF-8");
	 	   response.setContentType("application/vnd.ms-excel");
	 	   String fileName=course.getCoursename()+"课程学生名单.xls";
	 	   response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("GB2312"), "8859_1"));
	 	   OutputStream out = response.getOutputStream();    	 	   
	 	   try {
			WritableWorkbook workbook = Workbook.createWorkbook(out);
			WritableSheet ws = workbook.createSheet(course.getCoursename()+"学生名单", 0);
			WritableFont wf = new WritableFont(WritableFont.TIMES,10,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK);//设置字体格式
			WritableCellFormat wef = new WritableCellFormat(wf);//创建格式化对象实例
			wef.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//垂直居中
			wef.setAlignment(Alignment.CENTRE);//水平居中
			//工作表标题行（new Label（列，行，内容，格式））
			ws.addCell(new Label(0,0,"学号",wef));
			ws.addCell(new Label(1,0,"护照号",wef));
			ws.addCell(new Label(2,0,"中文名",wef));
			ws.addCell(new Label(3,0,"英文名",wef));
			ws.addCell(new Label(4,0,"英文姓",wef));
			ws.addCell(new Label(5,0,"性别",wef));
			ws.addCell(new Label(6,0,"电话",wef));
			ws.addCell(new Label(7,0,"班级",wef));
			List<ChosenCourse> chosenCourses = manageService.loadselectcoursestu(coursenum, semester);
			List<Object[]> dataList = new ArrayList<Object[]>(); 
			for(ChosenCourse c:chosenCourses){
				Student temp = studentService.loadstubystuid(String.valueOf(c.getPassport()));			
				Object[] stu = {temp.getStuid(),temp.getPassport(),temp.getStuname(),temp.getFirstname(),temp.getLastname(),temp.getSex(),temp.getTelephone(),temp.getClasses().getClassname()};
				dataList.add(stu);
			}
			////向工作表添加数据
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
    public String changepwd(){
    	ActionContext.getContext().put("userid", stu.getId());
		return "changepwd";
    }
    public String pwdcheck(){
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = studentService.pwdcheck(stu.getId(),stu.getPassword());
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
	public String stuchangepwd(){
		studentService.userchangpwd(stu);
		return null;
	}
    public String studentsearch(){
    	String classlist = studentService.classlist();
		ActionContext.getContext().put("classlist", classlist);
    	return "studentsearch";
    }
    public String stusearch(){
		List<Student> student = studentService.stusearch(stu);
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = studentService.searchstudentmap(page, pageSize);
		datatojson(map);
		return null;
    }
    
    public String stuFuzzySearch (){
    	if (query == null)
    		return null;
		try {
			query = java.net.URLDecoder.decode(query, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = studentService.stuFuzzy(query, page, pageSize);
		datatojson(map);
    	return null;
    }
    
    public String leavemanage(){
    	
    	return "leavemanage";
    }
    
    
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
			if (serial == null){
				serial = "001";
			}
			Integer serialNum = Integer.parseInt(serial) + 1;
			String currNum = serialNum.toString();
			if (serialNum < 10)
				currNum = "0" + currNum;
			if (serialNum < 100)
				currNum = "0" + currNum;
			ActionContext.getContext().put("serial", currNum);
			t.getDiploma(out, student, serial);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return null;
		return "graduatestulist";
	}
    
    
    public String graduateprint(){
    	Student student = studentService.loadstubyid(stu.getId());
    	String brithyear = student.getBrithdate().substring(0,4);
    	String brithmonth = student.getBrithdate().substring(5,7);
    	String day = student.getBrithdate().substring(8,10);
    	String startyear = student.getStartdate().substring(0,4);
    	String startmonth = student.getStartdate().substring(5,7);
    	String endyear = student.getEnddate().substring(0,4);
    	String endmonth = student.getEnddate().substring(5,7);
    	Integer summaryyear = Integer.valueOf(endyear)-Integer.valueOf(startyear);
    	ActionContext.getContext().put("summaryyear", summaryyear);
    	ActionContext.getContext().put("year", brithyear);
    	ActionContext.getContext().put("month", brithmonth);
    	ActionContext.getContext().put("day", day);
    	ActionContext.getContext().put("student", student);
    	ActionContext.getContext().put("startyear",startyear);
    	ActionContext.getContext().put("startmonth",startmonth);
    	ActionContext.getContext().put("endyear",endyear);
    	ActionContext.getContext().put("endmonth",endmonth);
    	return "graduateprint";
    }
    public String graduatebatchprint(){
    	List<Student> student = studentService.loadbatchstubyid(ids);
    	ActionContext.getContext().put("studentlist", student);
    	return "graduatebatchprint";
    }
    public String stucheckname(){
    	HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = studentService.stucheckname(stu.getStuname());
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
    public String stucheckstunum(){
    	HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = studentService.stucheckstunum(stu.getStuid());
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
    public String stucheckstunumagain(){
    	HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = studentService.stucheckstunum(stu.getStuid());
		if (!flg) {
			List<Student> students = studentService.stucheckstuagain(stu.getId(),stu.getStuid());
			if (students.size()>0) {
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
    public String begainchangeimg(){
        ActionContext.getContext().put("stuid", stu.getId());    	
    	return "changeimg";
    }
    public String changeimg() throws UnsupportedEncodingException{
    	String realpath = ServletActionContext.getServletContext().getRealPath("/image/stuimages");
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
    	File savedir = new File(realpath);
		if (!savedir.exists())
			savedir.mkdirs();
		if (image != null) {
			//imageFileName=new String(imageFileName.getBytes("iso8859-1"),"UTF-8");
			String name = imageFileName.substring(imageFileName.indexOf('.'));
			if (name.toLowerCase().equals(".jpg") || name.toLowerCase().equals(".gif") || name.toLowerCase().equals(".bmp") || name.toLowerCase().equals(".png") || name.toLowerCase().equals(".jpeg")) {
				User user = (User) ActionContext.getContext().getSession().get("user");
				/*
				 * if (stu.getStuimg() != null) { File file = new File(realpath+
				 * stu.getStuimg().substring(stu.getStuimg().indexOf("\\"))); if
				 * (file.exists()) { file.delete(); } }
				 */
				Student stu = studentService.loadstubyid(user.getId()); 
				String imgname = stu.getStuid().concat(name);
				File savefile = new File(savedir, imgname);
				try {
					FileUtils.copyFile(image, savefile);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				studentService.changeimg("image/stuimages" + "/" + imgname);
				ActionContext.getContext().put("message", "修改成功");
			} else {
				ActionContext.getContext().put("message", "修改失败！请选择正确的图片格式");
			}
		}else {
			ActionContext.getContext().put("message", "图片不能为空，请重新上传！");
		}
		return "showmessage";
	}
    public String sturecovery(){
    	studentService.sturecovery(ids);
    	return null;
    }
    public String stupermission() throws Exception{
    	User user = (User) ActionContext.getContext().getSession().get("user");
    	if (user.getRoles().getRolerank().equals(3)) {
    		ActionContext.getContext().put("students", new ArrayList<Student>());
    		return "stupermission";
    	}
    	List<Student> students = studentService.loadpermissionstu();
    	ActionContext.getContext().put("students", students);
    	return "stupermission";
    }
    public String stupermissionlist(){
    	String classlist = studentService.classlist();
		ActionContext.getContext().put("classlist", classlist);
    	return "stupermissionlist";
    }
    public String stupermissionlistmap() throws Exception{
    	HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = studentService.stupermissionmap(page, pageSize);
		datatojson(map);
		return null;
    }
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
   
}