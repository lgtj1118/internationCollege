package com.tjpu.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.xml.crypto.Data;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.Attendence;
import com.tjpu.bean.BatchRegiste;
import com.tjpu.bean.ChosenCourse;
import com.tjpu.bean.Classes;
import com.tjpu.bean.Evalution;
import com.tjpu.bean.Leave;
import com.tjpu.bean.MD5;
import com.tjpu.bean.Performance;
import com.tjpu.bean.Student;
import com.tjpu.bean.StudentModel;
import com.tjpu.bean.Teacher;
import com.tjpu.bean.User;
import com.tjpu.dao.ManageDao;
import com.tjpu.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;
	@Autowired
	ManageDao manageDao;
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
				/*System.out.println(file);
				Workbook workbook = Workbook.getWorkbook(file);
				Sheet sheet[] = workbook.getSheets();
				for (int x = 0; x < sheet.length; x++) {
					for (int y = 0; y < sheet[x].getRows(); y++) {
						for (int z = 0; z < sheet[x].getColumns(); z++) {
							//content = content+"\t"+sheet[x].getCell(z,y).getContents();
							linelist.add(sheet[x].getCell(z,y).getContents());
						}
					}
				}*/
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return linelist;
	}
	@Override
	public Student loginService(String username,String password) {
		
		Student student1 = null;
		List<Student> list = studentDao.loginDao(username,password);
		if (list.size() > 0 && list != null) {
			student1 = list.get(0);
		}
		return student1;
	}
	
	@Override
	public String classlist() {
		
		List<Classes> classes = studentDao.loadclasses();
		String classlist = "";
		int i = 1;
		for (Classes c : classes) {
			String s = "{\"Classid\":" + c.getId() + "," + "\"Classname\":" + "\"" + c.getClassname() + "\"," + "\"Classmajor\":" + "\"" + c.getMajor() + "\"}";
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
	public Map<String, Object> studentmap(int page, int pageSize) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Student> stus = studentDao.loadstudents();
		for (int i = 0; i < stus.size() - 1; i++) {
			for (int j = 0; j < stus.size() - i - 1; j++) {
				if (Integer.valueOf(stus.get(j).getStatus()) > Integer.valueOf(stus.get(j + 1).getStatus())) {
					Student temp = null;
					temp = stus.get(j);
					stus.set(j, stus.get(j + 1));
					stus.set(j + 1, temp);
				}
			}
		}
		long total = studentDao.totalstu();
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
				model.setSource(stus.get(i).getSource());
				model.setEnddate(stus.get(i).getEnddate());
				model.setStartdate(stus.get(i).getStartdate());
				model.setStatus(stus.get(i).getStatus());
				model.setBrithdate(stus.get(i).getBrithdate());
				model.setMajor(stus.get(i).getClasses().getMajor());
				model.setValidResidencePermit(stus.get(i).getValidResidencePermit());
				model.setEnddate(stus.get(i).getEnddate());
				model.setIsDeleted(stus.get(i).getDeleted());
				model.setStudyLevel(stus.get(i).getStudyLevel());
				model.setDuration(stus.get(i).getDuration());
				if (stus.get(i).getIsPaid().equals("0")) {
					model.setIsPaid("<font style='color:red'>欠费</font>");
				} else {
					model.setIsPaid("<font style='color:green'>缴清</font>");
				}
				
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
	public void stuupdate(Student stu, int classid) {
		String stuname = null;
		String stusex = null;
		String stunum = null;
		String stupassword = null;
		String firstname = null;
		String lastname = null;
		String nation = null;
		String roomplace = null;
		String startdate = null;
		String enddate = null;
		String studenttype = null;
		String passport = null;
		String telephone = null;
		String validresidencepermit = null;
		String source = null;
		String brithdate = null;
		try {
			stunum = java.net.URLDecoder.decode(stu.getStuid(), "UTF-8");
			stuname = java.net.URLDecoder.decode(stu.getStuname(), "UTF-8");
			stusex = java.net.URLDecoder.decode(stu.getSex(), "UTF-8");
			//stupassword = java.net.URLDecoder.decode(stu.getPassword(), "UTF-8");
			firstname = java.net.URLDecoder.decode(stu.getFirstname(), "UTF-8");
			lastname = java.net.URLDecoder.decode(stu.getLastname(), "UTF-8");
			nation = java.net.URLDecoder.decode(stu.getNation(), "UTF-8");
			roomplace = java.net.URLDecoder.decode(stu.getRoomplace(), "UTF-8");
			startdate = java.net.URLDecoder.decode(stu.getStartdate(), "UTF-8");
			enddate = java.net.URLDecoder.decode(stu.getEnddate(), "UTF-8");
			studenttype = java.net.URLDecoder.decode(stu.getStudentType(), "UTF-8");
			passport = java.net.URLDecoder.decode(stu.getPassport(), "UTF-8");
			telephone = java.net.URLDecoder.decode(stu.getTelephone(), "UTF-8");
			validresidencepermit = java.net.URLDecoder.decode(stu.getValidResidencePermit(), "UTF-8");
			source = java.net.URLDecoder.decode(stu.getSource(), "UTF-8");
			brithdate = java.net.URLDecoder.decode(stu.getBrithdate(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}				
		Student students = studentDao.loadstubyid(stu.getId());
		if (students.getPassport().equals(passport)) {
			stu.setStuname(stuname);
			stu.setSex(stusex);
			stu.setStuid(stunum);
			//stu.setPassword(stupassword);
			stu.setStartdate(startdate);
			stu.setEnddate(enddate);
			stu.setSource(source);
			stu.setFirstname(firstname);
			stu.setLastname(lastname);
			stu.setNation(nation);
			stu.setPassport(passport);
			stu.setRoomplace(roomplace);
			stu.setSource(source);
			stu.setStudentType(studenttype);
			stu.setTelephone(telephone);
			stu.setBrithdate(brithdate);
			stu.setValidResidencePermit(validresidencepermit);
			studentDao.stuupdate(stu, classid);
		}else {			
			//更新考勤表  护照号
			List<Attendence> attendences = manageDao.loadallpersonattendence(students.getPassport());
			for(Attendence a: attendences){
				manageDao.updateattendence(a,passport);
			}//更新选课表  护照号
			List<ChosenCourse> chosenCourses = manageDao.loadChosenCourseByStuId(students.getPassport());
			for(ChosenCourse c: chosenCourses){
				manageDao.updateChosenCourse(c,passport);
			}//更新班级表  班长
			if (students.getClasses().getClassminitorid().equals(students.getPassport())) {
				studentDao.classminitorset(students.getClasses().getId(), passport);
			}//更新评价表  护照号
			List<Evalution> evalutions = manageDao.loadstuevalution(students.getPassport());
			for(Evalution e: evalutions){
				manageDao.updateEvalution(e,passport);
			}//更新学生情况表  护照号
			List<Performance> performances = manageDao.loadstuperformance(students.getPassport());
			for(Performance p: performances){
				manageDao.updatePerformance(p,passport);
			}//更新请假表  护照号
			List<Leave> leaves = manageDao.loadleavebystuid(students.getPassport());
			for(Leave l: leaves){
				manageDao.updateLeave(l,passport);
			}
			stu.setStuname(stuname);
			stu.setSex(stusex);
			stu.setStuid(stunum);
			//stu.setPassword(stupassword);
			stu.setStartdate(startdate);
			stu.setEnddate(enddate);
			stu.setSource(source);
			stu.setFirstname(firstname);
			stu.setLastname(lastname);
			stu.setNation(nation);
			stu.setPassport(passport);
			stu.setRoomplace(roomplace);
			stu.setSource(source);
			stu.setStudentType(studenttype);
			stu.setTelephone(telephone);
			stu.setBrithdate(brithdate);
			stu.setValidResidencePermit(validresidencepermit);
			studentDao.stuupdate(stu, classid);
		}
		
	}

	@Override
	public void studelete(String ids) {
		
		StringTokenizer fenxi = new StringTokenizer(ids, ",");
		while (fenxi.hasMoreTokens()) {
			String sid = fenxi.nextToken();
			int stuid = Integer.parseInt(sid);
			studentDao.studelete(stuid);
		}
	}

	@Override
	public List<Classes> classlist1() {
		
		List<Classes> classlist = studentDao.loadclasses();
		return classlist;
	}

	@Override
	public boolean stucheck(String stuid) {
		
		List<Student> havestu = studentDao.stucheck(stuid);
		if (havestu.size() > 0) {
			return false;
		}
		return true;
	}
	@Override
	public List<Student> stucheckagain(Integer id,String stuid) {
		
		return  studentDao.stucheckagain(id,stuid);
	}
	@Override
	public boolean stucheckstunum(String stuid) {
		
		List<Student> havestu = studentDao.stucheckstu(stuid);
		if (havestu.size() > 0) {
			return false;
		}
		return true;
	}
	@Override
	public List<Student> stucheckstuagain(Integer id,String stuid) {
		
		return studentDao.stucheckstuagain(id,stuid);
 
	}

	@Override
	public void stuadd(Student stu, int classid) {
		
		String stuname = null;
		String stusex = null;
		String stunum = null;
		String stupassword = null;
		String firstname = null;
		String lastname = null;
		String nation = null;
		String roomplace = null;
		String startdate = null;
		String enddate = null;
		String studenttype = null;
		String passport = null;
		String telephone = null;
		String brithdate = null;
		String validresidencepermit = null;
		String source = null;
		String studyLevel = null;
		String duration = null;
		try {
			stunum = java.net.URLDecoder.decode(stu.getStuid(), "UTF-8");
			stuname = java.net.URLDecoder.decode(stu.getStuname(), "UTF-8");
			stusex = java.net.URLDecoder.decode(stu.getSex(), "UTF-8");
			//stupassword = java.net.URLDecoder.decode(stu.getPassword(), "UTF-8");
			firstname = java.net.URLDecoder.decode(stu.getFirstname(), "UTF-8");
			lastname = java.net.URLDecoder.decode(stu.getLastname(), "UTF-8");
			nation = java.net.URLDecoder.decode(stu.getNation(), "UTF-8");
			roomplace = java.net.URLDecoder.decode(stu.getRoomplace(), "UTF-8");
			startdate = java.net.URLDecoder.decode(stu.getStartdate(), "UTF-8");
			enddate = java.net.URLDecoder.decode(stu.getEnddate(), "UTF-8");
			studenttype = java.net.URLDecoder.decode(stu.getStudentType(), "UTF-8");
			passport = java.net.URLDecoder.decode(stu.getPassport(), "UTF-8");
			telephone = java.net.URLDecoder.decode(stu.getTelephone(), "UTF-8");
			validresidencepermit = java.net.URLDecoder.decode(stu.getValidResidencePermit(), "UTF-8");
			source = java.net.URLDecoder.decode(stu.getSource(), "UTF-8");
			brithdate = java.net.URLDecoder.decode(stu.getBrithdate(),"UTF-8");
			studyLevel = java.net.URLDecoder.decode(stu.getStudyLevel(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		if (studyLevel.equals("四年制本科")) {
			stu.setStudyLevel("本");
			stu.setDuration("四");
		} else if (studyLevel.equals("二年制本科")) {
			stu.setStudyLevel("本");
			stu.setDuration("四");
		} else if (studyLevel.equals("长期进修")) {
			stu.setStudyLevel("长期进修");
			stu.setDuration("长期进修");
		} else if (studyLevel.equals("短期进修")){
			stu.setStudyLevel("短期进修");
			stu.setDuration("短期进修");
		} else {
			stu.setStudyLevel("硕");
			stu.setDuration("三");
		}
		
		stu.setStuname(stuname);
		stu.setSex(stusex);
		stu.setStuid(stunum);
		//stu.setPassword(stupassword);
		stu.setStartdate(startdate);
		stu.setEnddate(enddate);
		stu.setSource(source);
		stu.setFirstname(firstname);
		stu.setLastname(lastname);
		stu.setNation(nation);
		stu.setPassport(passport);
		stu.setRoomplace(roomplace);
		stu.setSource(source);
		stu.setStudentType(studenttype);
		stu.setTelephone(telephone);
		stu.setBrithdate(brithdate);
		stu.setStatus(String.valueOf(0));
		stu.setValidResidencePermit(validresidencepermit);
		Classes cls = studentDao.loadclassbyid(classid);
		stu.setClasses(cls);
		String password = MD5.generate("123456");
		stu.setPassword(password);
		stu.setDeleted(0);
		studentDao.stuadd(stu);
	}

	@Override
	public boolean pwdcheck(Integer id, String password) {
		
		List<Student> user = studentDao.pwdcheck(id,password);
		if (user.size() > 0) {
			return true;
		}
		return false;
	}
	@Override
	public void userchangpwd(Student user) {
		
	    String password = null;
	    password = user.getPassword();
	    user.setPassword(password);
	    studentDao.userchangpwd(user);
	}

	@Override
	public Student loadstubyid(Integer id) {
		
		Student student = studentDao.loadstubyid(id);
		return student;
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
						String cellcon = "";
						Cell cell = sheet.getCell(c, r);
						if (cell.getType()==CellType.DATE) {
							DateCell dc = (DateCell)cell;
							Date date = dc.getDate();
							SimpleDateFormat ds = new SimpleDateFormat("yyyy-MM-dd");
							cellcon = ds.format(date);
							items.add(cellcon);
						}
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
	//TODO
	public Map<String, Object> registerStudentByFile (String path){
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
						
		for (List<String> ttk:getItems(path)) {	
			List<String> tk = new ArrayList<String>();
			for (String s:ttk) {
				if(s != null && s != "")
					tk.add(s);
				
			}
			if (tk.size() == 0) {
				continue;
			}
			// 项数不正确
			if (tk.size() != 13) {
				BatchRegiste br = new BatchRegiste();
				StringBuffer bf = new StringBuffer();
				for(String s:tk){
					bf.append(s+" ");
				}
				br.setLine(bf.toString());
				br.setReason("项数不正确");
				fail.add(br);
				continue;
			}			
			String errMsg = itemChk(tk);
			// 通过验证则保存
			if (errMsg == null) {
				count ++;
				Student curr = formateStudent(tk);
				studentDao.stuadd(curr);
				
			} else { // 否则返回错误信息
				BatchRegiste br = new BatchRegiste();
				StringBuffer bf = new StringBuffer();
				for(String s:tk){
					bf.append(s+" ");
				}
				br.setLine(bf.toString());
				br.setReason(errMsg);
				fail.add(br);
			}	
		}
		ret.put("Count", String.valueOf(count));
		ret.put("Fail", fail);
		return ret;
	}
	
	private String itemChk (List<String> items) {
		// 1         	2       		3        		4       	5 	        	6   
		// passport		student	id 		first name		last name	Chinese name	sex
		// class     	phone  			address  		nation  	type  			start date  	
		// end date		source	 		birth date 		permission  
		
		int i = 0;

		String passport = "[0-9A-Za-z]{6,}";
		String passportNum = items.get(i++);
		if (!Pattern.matches(passport, passportNum)){
			return "护照号应不少于6位";
		}
		if (!stucheck(passportNum)){
			return "护照号重复";
		}
		//String stuid = "[0-9a-zA-Z]{6,}";
		/*String stuid = "[0-9]{10}";
		String stuNum = items.get(i++);
		if (!Pattern.matches(stuid, stuNum)){
			return "学号不能包含中文字符或特殊字符";
		}
		
		if (!stucheckstunum(stuNum)) {
			return "学号重复";
		}*/
		String firstName = "[a-zA-Z\\s]{2,79}";
		if (!Pattern.matches(firstName, items.get(i++))){
			return "名应为2个以上的英文字符";
		}
		String lastName = "[a-zA-Z\\s]{2,79}";
		if (!Pattern.matches(lastName, items.get(i++))){
			return "姓应为2个以上的英文字符";
		}
		String chineseName = "[\u4e00-\u9fa5]{1,}";
		if (!Pattern.matches(chineseName, items.get(i++))){
			return "中文名应为1个以上的中文字符";
		}
		String sex = items.get(i++);
		if (!sex.equals("男") && !sex.equals("女")) {
			return "性别只能为男和女";
		}
		String classid = "[a-zA-Z0-9\u4e00-\u9fa5]{1,}";
		String className = items.get(i++);
		if (!Pattern.matches(classid, className)){
			return "班级名不正确";
		}
		Classes c = studentDao.loadclassbyname(className);
		if (c == null){
			return "班级不存在";
		}
		String phone = "1\\d{10}";
		if (!Pattern.matches(phone, items.get(i++))){
			return "手机格式不正确";
		}
		String address = "[0-9a-zA-Z\u4e00-\u9fa5]{2,}";
		if (!Pattern.matches(address, items.get(i++))){
			return "住址格式不正确";
		}
		String nation = "[a-zA-Z\u4e00-\u9fa5]{2,}";
		if (!Pattern.matches(nation, items.get(i++))){
			return "国籍格式不正确";
		}
		String type = "[\u4e00-\u9fa5]{2,}";
		if (!Pattern.matches(type, items.get(i++))){
			return "学生类型格式不正确";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*try {
			Date admission = sdf.parse(items.get(i++));
			Date graduation = sdf.parse(items.get(i++));
			if (graduation.before(admission)) {
				return "毕业时间早于入学时间";
			}
			String source = "[\u4e00-\u9fa5]{2,}";
			if (!Pattern.matches(source, items.get(i++))){
				return "来源因为2个以上中文字符";
			}
			Date birth = sdf.parse(items.get(i++));
			Date today = new Date();
			long age = ((today.getTime() - birth.getTime()) / (24 * 60 * 60 * 1000) + 1) / 365;
			if (age < 15 || age > 45){
				return "年龄应大于15并小于45";
			}
			Date permission = sdf.parse(items.get(i++));
			if (permission.before(admission)){
				return "居留许可有效期无效";
			}
			if (admission.before(birth)) {
				return "出生日期或入学日期错误";
			}
		} catch (ParseException e) {
			return "日期格式不正确";
		}*/
		String source = "[\u4e00-\u9fa5]{2,}";
		if (!Pattern.matches(source, items.get(i++))){
			return "来源因为2个以上中文字符";
		}
		/*
		String duration = items.get(i++);
		String level = items.get(i++);
		Map<String, String> schooling = new HashMap<String, String>() {{
			put ("二", "本");
			put ("四", "本");
			put ("三", "硕士");
			put ("长期进修", "长期进修");
			put ("短期进修", "短期进修");
		}};
		if (!schooling.keySet().contains(duration)) {
			return "当前学制为二、四、三、长期进修、短期进修";
		}
		if (!level.equals(schooling.get(duration))) {
			return "当前学习层次为本、硕、短期进修、长期进修";
		}
		*/
		
		return null;
	}
	
	private Student formateStudent (List<String> line) {
		// 1         	2       		3        		4       	5 	        	6   
		// passport		student	id 		first name		last name	Chinese name	sex
		// class     	phone  			address  		nation  	type  			start date  	
		// end date		source	 		birth date 		permission
		Student stu = new Student();
		int i = 0;
		stu.setPassport(line.get(i++));
		//stu.setStuid(line.get(i++));
		stu.setStuid("");
		stu.setFirstname(line.get(i++));
		stu.setLastname(line.get(i++));
		stu.setStuname(line.get(i++));
		stu.setSex(line.get(i++));
		String className = line.get(i++);
		Classes classid = studentDao.loadclassbyname(className);					
		/*if (classid==null) {
			Classes cls = new Classes();
			cls.setClassname(className);
			cls.setMajor("汉语");
			studentDao.classadd(cls);
			Classes classes = studentDao.loadclassbyname(className);
			stu.setClasses(classes);
		}else {
			stu.setClasses(classid);
		}*/
		stu.setClasses(classid);
		//stu.setClasses(null);
		stu.setTelephone(line.get(i++));
		stu.setRoomplace(line.get(i++));
		stu.setNation(line.get(i++));
		stu.setStudentType(line.get(i++));
		//stu.setStartdate(line.get(i++));
		//stu.setEnddate(line.get(i++));
		stu.setSource(line.get(i++));
		//stu.setBrithdate(line.get(i++));
		//stu.setValidResidencePermit(line.get(i++));
		stu.setDuration(line.get(i++));
		stu.setStudyLevel(line.get(i++));
		stu.setStatus("0");
		stu.setDeleted(0);
		String password = MD5.generate("123456");
		stu.setPassword(password);
		return stu;
	}
	
	@Override
	public List<Student> stuaddbytxt(String stupath) {
		List<Student> stuList = new ArrayList<Student>();
		try {
			List<String> linelist = readTxtFile(stupath);
			
			for (String line : linelist) {
				StringTokenizer tokenizer = new StringTokenizer(line);
				if (tokenizer.hasMoreTokens()) {
					//String s = tokenizer.nextToken();
					Student stu = new Student();
					String passport = tokenizer.nextToken();
					String stuid = tokenizer.nextToken();
					List<Student> students = studentDao.loadstubystunum(stuid);					
					if (students.size()==0) {
						stu.setPassport(passport);
						stu.setStuid(stuid);
						stu.setFirstname(tokenizer.nextToken());
						stu.setLastname(tokenizer.nextToken());
						stu.setStuname(tokenizer.nextToken());
						stu.setSex(tokenizer.nextToken());						
						String classname = tokenizer.nextToken();
						Classes classid = studentDao.loadclassbyname(classname);					
						if (classid==null) {
							Classes cls = new Classes();
							cls.setClassname(classname);
							cls.setMajor("汉语");
							studentDao.classadd(cls);
							Classes classes = studentDao.loadclassbyname(classname);
							stu.setClasses(classes);
						}else {
							stu.setClasses(classid);
						}
						
						stu.setTelephone(tokenizer.nextToken());
						stu.setRoomplace(tokenizer.nextToken());
						stu.setNation(tokenizer.nextToken());
						stu.setStudentType(tokenizer.nextToken());
						stu.setStartdate(tokenizer.nextToken());
						stu.setEnddate(tokenizer.nextToken());
						stu.setSource(tokenizer.nextToken());
						stu.setBrithdate(tokenizer.nextToken());
						String password = MD5.generate("123456");
						stu.setPassword(password);
						stu.setStatus(String.valueOf(0));
						studentDao.stuadd(stu);
					}else {
						Student student = new Student();
						student.setPassport(passport);
						student.setStuid(stuid);
						student.setFirstname(tokenizer.nextToken());
						student.setLastname(tokenizer.nextToken());
						student.setStuname(tokenizer.nextToken());
						student.setSex(tokenizer.nextToken());						
						String classname = tokenizer.nextToken();
						student.setClasses(null);
						student.setTelephone(tokenizer.nextToken());
						student.setRoomplace(tokenizer.nextToken());
						student.setNation(tokenizer.nextToken());
						student.setStudentType(tokenizer.nextToken());
						student.setStartdate(tokenizer.nextToken());
						student.setEnddate(tokenizer.nextToken());
						student.setSource(tokenizer.nextToken());
						student.setBrithdate(tokenizer.nextToken());
						String password = MD5.generate("123456");
						stu.setPassword(password);
						stu.setStatus(String.valueOf(0));
						stuList.add(student);
						continue;
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		File file = new File(stupath);
		if (file.exists()) {
			file.delete();
		}
		return stuList;
	}
	@Override
	public List<Student> classstuaddbytxt(String stupath,Integer id) {
		List<Student> stuList = new ArrayList<Student>();
		try {
			List<String> linelist = readTxtFile(stupath);
			
			for (String line : linelist) {
				StringTokenizer tokenizer = new StringTokenizer(line);
				if (tokenizer.hasMoreTokens()) {
					//String s = tokenizer.nextToken();
					Student stu = new Student();
					String stuid = tokenizer.nextToken();
					List<Student> students = studentDao.loadstubyclass(stuid,id);					
					if (students.size()==0) {
						//stu.setPassport(passport);
						stu.setStuid(stuid);
						stu.setFirstname(tokenizer.nextToken());
						stu.setLastname(tokenizer.nextToken());
						stu.setStuname(tokenizer.nextToken());
						stu.setSex(tokenizer.nextToken());						
						stu.setTelephone(tokenizer.nextToken());
						stu.setRoomplace(tokenizer.nextToken());
						stu.setNation(tokenizer.nextToken());
						stu.setStudentType(tokenizer.nextToken());
						stu.setPassport(tokenizer.nextToken());
						stu.setStartdate(tokenizer.nextToken());
						stu.setEnddate(tokenizer.nextToken());
						stu.setSource(tokenizer.nextToken());
						stu.setBrithdate(tokenizer.nextToken());
						String password = MD5.generate("123456");
						stu.setPassword(password);
						stu.setStatus(String.valueOf(0));
						Classes classes = studentDao.loadclassbyid(id);
						stu.setClasses(classes);
						studentDao.stuadd(stu);												
					}else {
						Student student = new Student();						
						student.setStuid(stuid);
						student.setFirstname(tokenizer.nextToken());
						student.setLastname(tokenizer.nextToken());
						student.setStuname(tokenizer.nextToken());
						student.setSex(tokenizer.nextToken());						
						//String classname = tokenizer.nextToken();
						//student.setClasses(null);
						student.setTelephone(tokenizer.nextToken());
						student.setRoomplace(tokenizer.nextToken());
						student.setNation(tokenizer.nextToken());
						student.setStudentType(tokenizer.nextToken());
						student.setPassport(tokenizer.nextToken());
						student.setStartdate(tokenizer.nextToken());
						student.setEnddate(tokenizer.nextToken());
						student.setSource(tokenizer.nextToken());
						student.setBrithdate(tokenizer.nextToken());
						String password = MD5.generate("123456");
						stu.setPassword(password);
						stu.setStatus(String.valueOf(0));
						stuList.add(student);
						continue;
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		File file = new File(stupath);
		if (file.exists()) {
			file.delete();
		}
		return stuList;
	}
	@Override
	public String studentlist(Integer classid) {
		
		List<Student> students = studentDao.loadstubyclassid(classid);
		String studentlist = "";
		int i = 1;
		for (Student c : students) {
			String s = "{\"id\":" + c.getId() + "," + "\"stuname\":" + "\"" + c.getStuname() + "\","+ "\"firstname\":" + "\"" + c.getFirstname() + "\","+ "\"lastname\":" + "\"" + c.getLastname() + "\","+ "\"stuid\":" + "\"" + c.getStuid() + "\"," + "\"passport\":" + "\"" + c.getPassport() + "\","+ "\"telephone\":" + "\"" + c.getTelephone() + "\","+ "\"stunum\":" + "\"" + c.getStuid() + "\","+ "\"Classid\":" + "\"" + c.getClasses().getId() + "\","  + "\"passport\":" + "\"" + c.getPassport() + "\"}";
			if (i < students.size()) {
				studentlist += s + ",";
			} else {
				studentlist += s;
			}
			i++;
		}
		return studentlist;
	}
	@Override
	public void stubaseupdate(Student stu, int classid) {
		
		String stuname = null;
		String stunum = null;
		String firstname = null;
		String lastname = null;
		String nation = null;
		String roomplace = null;
		String studenttype = null;
		String passport = null;
		String telephone = null;		
		String source = null;
		try {
			stunum = java.net.URLDecoder.decode(stu.getStuid(), "UTF-8");
			stuname = java.net.URLDecoder.decode(stu.getStuname(), "UTF-8");
			firstname = java.net.URLDecoder.decode(stu.getFirstname(), "UTF-8");
			lastname = java.net.URLDecoder.decode(stu.getLastname(), "UTF-8");
			nation = java.net.URLDecoder.decode(stu.getNation(), "UTF-8");
			roomplace = java.net.URLDecoder.decode(stu.getRoomplace(), "UTF-8");
			studenttype = java.net.URLDecoder.decode(stu.getStudentType(), "UTF-8");
			passport = java.net.URLDecoder.decode(stu.getPassport(), "UTF-8");
			telephone = java.net.URLDecoder.decode(stu.getTelephone(), "UTF-8");
			source = java.net.URLDecoder.decode(stu.getSource(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}		
		stu.setStuname(stuname);
		stu.setStuid(stunum);
		stu.setSource(source);
		stu.setFirstname(firstname);
		stu.setLastname(lastname);
		stu.setNation(nation);
		stu.setPassport(passport);
		stu.setRoomplace(roomplace);
		stu.setSource(source);
		stu.setStudentType(studenttype);
		stu.setTelephone(telephone);
		//stu.setValidResidencePermit(validresidencepermit);
		studentDao.stubaseupdate(stu, classid);
	}
	@Override
	public boolean stucheckname(String stuname) {
		
		List<Student> students = studentDao.loadstubystuname(stuname);
		if (students.size()>0) {
			return true;
		}
		return false;
	}
	@Override
	public void changeimg(String imgsrc) {
		
		User stu = (User) ActionContext.getContext().getSession().get("user");
		Student student = studentDao.loadstubyid(stu.getId());
		studentDao.changeimg(imgsrc, student);
	}
	List<Student> students = new ArrayList<Student>();
	@Override
	public List<Student> stusearch(Student stu) {
		
		students.clear();
		students = studentDao.stusearch(stu);
		return students;
	}
	@Override
	public Map<String, Object> searchstudentmap(int page, int pageSize) {
		
		Map<String, Object> map = new HashMap<String, Object>();		
		long total = students.size();
		List<StudentModel> stumodels = new ArrayList<StudentModel>();
		for (Student s : students) {
			StudentModel model = new StudentModel();
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
			stumodels.add(model);
		}
		map.put("Total", total);
		map.put("Rows", stumodels);
		return map;
	}
	@Override
	public List<Student> loadallstu() {		
		List<Student> students = studentDao.loadallstu();
		/*for(int i=0;i<students.size()-1;i++){
			for(int j=0;j<students.size()-i-1;j++){
				if(Integer.valueOf(students.get(j).getStatus())>Integer.valueOf(students.get(j+1).getStatus())){
					Student temp = null;
					temp = students.get(j);
					students.set(j, students.get(j+1));
					students.set(j+1, temp);
				}
			}
		}*/
		return students;
	}
	@Override
	public void graduatestuauditagree(String ids) {
		StringTokenizer fenxi = new StringTokenizer(ids, ",");
		while (fenxi.hasMoreTokens()) {
			String sid = fenxi.nextToken();
			int stuid = Integer.parseInt(sid);
			studentDao.graduatestuauditagree(stuid);
		}
	}
	@Override
	public void graduatestuauditrefuse(String ids) {
		StringTokenizer fenxi = new StringTokenizer(ids, ",");
		while (fenxi.hasMoreTokens()) {
			String sid = fenxi.nextToken();
			int stuid = Integer.parseInt(sid);
			studentDao.graduatestuauditrefuse(stuid);
		}
	}
	/* (non-Javadoc)
	 * @see com.tjpu.service.StudentService#loadstubystuid(java.lang.String)
	 */
	@Override
	public Student loadstubystuid(String stuid) {
		// TODO Auto-generated method stub
		Student student = studentDao.loadstubystuid(stuid);
		return student;
	}
	
	private StudentModel stuToModel (Student s) {
		StudentModel model = new StudentModel();
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

		return model;
	}
	
	@Override
	public Map<String, Object> stuFuzzy(String text, int page, int pageSize) {
		List<Student> all = studentDao.stuFuzzySearch(text);
		List<StudentModel> part = new ArrayList<StudentModel>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (all == null || all.size() == 0 || all.size() < (page - 1) * pageSize) {
			map.put("Total", 0);
			map.put("Rows", part);
			return map;
		} else if (all.size() < page * pageSize) {
			for (Student s : all.subList((page - 1) * pageSize, all.size())) {
				part.add(stuToModel(s));
			}
		} else {
			for (Student s : all.subList((page - 1) * pageSize, page * pageSize)) {
				part.add(stuToModel(s));
			}
		}
		
		map.put("Total", all.size());
		map.put("Rows", part);
		return map;
	}

	@Override
	public List<Student> loadbatchstubyid(String ids) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		StringTokenizer fenxi = new StringTokenizer(ids, ",");
		while (fenxi.hasMoreTokens()) {
			String sid = fenxi.nextToken();
			int stuid = Integer.parseInt(sid);
			Student stu = studentDao.loadstubyid(stuid);
			students.add(stu);
		}
		return students;
	}

	@Override
	public void sturecovery(String ids) {
		// TODO Auto-generated method stub
		studentDao.sturecovery(ids);
	}

	@Override
	public List<Student> loadpermissionstu() throws Exception {
		// TODO Auto-generated method stub
		List<Student> students = studentDao.loadstuinschool();
		List<Student> students2 = new ArrayList<Student>();
		Calendar calendar = Calendar.getInstance();
		Date nowdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");		
		for(int i=0;i<students.size();i++){
			String permit =students.get(i).getValidResidencePermit();
			Date permitDate= null;
			try {
				permitDate = sdf.parse(permit);
				calendar.setTime(permitDate);
	            int day1 = calendar.get(Calendar.DAY_OF_YEAR);
	            calendar.setTime(nowdate);
	            int day2 = calendar.get(Calendar.DAY_OF_YEAR);
	            int day = day1-day2;
	            if (day>45) {
					continue;
				}else if(day>0&&day<=45) {
					students.get(i).setValidResidencePermit(String.valueOf(day));
					students2.add(students.get(i));
				}else {
					students.get(i).setValidResidencePermit(String.valueOf(day));
					students2.add(students.get(i));
				}
			} catch (Exception e) {
				// TODO: handle exception
			    System.out.println("学生有效期有问题！");
				continue;
			}			
		}
		return students2;
	}
	@Override
	public Map<String, Object> stupermissionmap(int page, int pageSize) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Student> stus = studentDao.loadstuinschool();
		Calendar calendar = Calendar.getInstance();
		Date nowdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");		
		for(int i=0;i<stus.size();i++){
			try {
				String permit =stus.get(i).getValidResidencePermit();
				Date permitDate = sdf.parse(permit);			
				calendar.setTime(permitDate);
	            int day1 = calendar.get(Calendar.DAY_OF_YEAR);
	            calendar.setTime(nowdate);
	            int day2 = calendar.get(Calendar.DAY_OF_YEAR);
	            int day = day1-day2;
	            if (day>45) {
	            	stus.remove(i);
					i--;
				}
			} catch (Exception e) {
				System.out.println("学生有效期有问题！");
			}
		}
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
				model.setSource(stus.get(i).getSource());
				model.setEnddate(stus.get(i).getEnddate());
				model.setStartdate(stus.get(i).getStartdate());
				model.setStatus(stus.get(i).getStatus());
				model.setBrithdate(stus.get(i).getBrithdate());
				model.setMajor(stus.get(i).getClasses().getMajor());
				model.setValidResidencePermit(stus.get(i).getValidResidencePermit());
				model.setEnddate(stus.get(i).getEnddate());
				model.setIsDeleted(stus.get(i).getDeleted());
				model.setStudyLevel(stus.get(i).getStudyLevel());
				model.setDuration(stus.get(i).getDuration());
				stumodels.add(model);
			} else {
				break;
			}
		}
		map.put("Total", total);
		map.put("Rows", stumodels);
		return map;
	}

}
