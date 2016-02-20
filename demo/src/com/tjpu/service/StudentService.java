package com.tjpu.service;

import java.util.List;
import java.util.Map;

import com.tjpu.bean.ChosenCourseModel;
import com.tjpu.bean.Classes;
import com.tjpu.bean.Classroom;
import com.tjpu.bean.Student;

public interface StudentService {
	
	public Map<String, Object> stuFuzzy (String text, int page, int pageSize);

	public String classlist();

	public Map<String, Object> studentmap(int page, int pageSize);

	public void stuupdate(Student stu, int classid);

	public void studelete(String ids);

	public List<Classes> classlist1();

	public boolean stucheck(String stuid);

	public void stuadd(Student stu, int classid);

	public Student loginService(String username,String password);

	public void userchangpwd(Student stu);

	public boolean pwdcheck(Integer id, String password);

	public Student loadstubyid(Integer id);

	public List<Student> stuaddbytxt(String stupath);
	
	public Map<String, Object> registerStudentByFile (String path);

	public List<Student> stusearch(Student stu);

	public String studentlist(Integer classid);

	public void stubaseupdate(Student stu, int classid);

	public boolean stucheckname(String stuname);

	public void changeimg(String imgsrc);

	public Map<String, Object> searchstudentmap(int page, int pageSize);

	public List<Student> loadallstu();

	public void graduatestuauditagree(String ids);

	public void graduatestuauditrefuse(String ids);

	public Student loadstubystuid(String stuid);

	public boolean stucheckstunum(String stuid);

	public List<Student> loadbatchstubyid(String ids);

	public void sturecovery(String ids);

	public List<Student> stucheckstuagain(Integer id, String stuid);

	public List<Student> stucheckagain(Integer id, String passport);

	public List<Student> classstuaddbytxt(String string, Integer id);

	public List<Student> loadpermissionstu() throws Exception;

	public Map<String, Object> stupermissionmap(int page, int pageSize) throws Exception;

	

}
