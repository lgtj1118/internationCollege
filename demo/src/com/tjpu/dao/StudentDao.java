package com.tjpu.dao;

import java.util.List;

import com.tjpu.bean.Assistantteacher;
import com.tjpu.bean.ChosenCourse;
import com.tjpu.bean.ClassRecord;
import com.tjpu.bean.Classes;
import com.tjpu.bean.Classroom;
import com.tjpu.bean.Course;
import com.tjpu.bean.Evalution;
import com.tjpu.bean.Performance;
import com.tjpu.bean.Student;
import com.tjpu.bean.Teacher;

public interface StudentDao {
	
	public List<Assistantteacher> loadAllAssis();
	
	public List<Teacher> loadAllAvlTeacher();
	
	public List<Student> stuFuzzySearch (String text);
	
	public List<Classes> assisClassList (String id);
	
	public List<Classes> chargeClassList (String ident);
	
	public int ClassTeacherNum ();
	
	public List<Teacher> loadClassTeacher (int i, int pagesize);
	
	public Teacher loadClassTeacherByIdent (String ident);
	
	public List<Classes> loadclasses();

	public List<Student> loadstudents();

	public long totalstu();

	public void stuupdate(Student stu, int classid);

	public void studelete(int stuid);

	public List<Student> stucheck(String stuid);

	public Classes loadclassbyid(int classid);

	public void stuadd(Student stu);

	public List<Classes> classcheck(String classname);

	public void classadd(Classes cls);

	public void classupdate(Classes cls);

	public void classdelete(Integer id);

	public List<Course> loadcourse(int i, int pageSize/*, Integer role*/);

	public List<Course> coursecheck(String coursename);

	public List<Course> coursecheck1(String num);

	public void courseadd(Course course);

	public void courseupdate(Course course);

	public void coursedelete(Integer id);

	public List<Classroom> loadroom(int i, int pageSize);

	public void roomadd(Classroom room);

	public void roomupdate(Classroom room);

	public void roomdelete(Integer id);

	public List<Classroom> roomcheck(Integer roomnum);

	public List<Student> loadstubyclassid(int classid);

	public List<Classroom> roomsearch(Classroom room);

	public List<Student> loginDao(String stuname, String password);

	public List<Student> pwdcheck(Integer id, String password);

	public void userchangpwd(Student user);

	public Student loadstubyid(Integer id);

	public List<Student> stusearch(Student stu);

	public List<Student> studentlist();

	public List<ChosenCourse> loadstucourse(String usernum, String semester);

	public List<Evalution> loadevalutions(String userid, String semester, Integer flag);

	public Course loadcoursebyid(Integer id);

	public void assistantteacheradd(Assistantteacher assistantteacher);

	public List<Assistantteacher> loadassist(int i, int pageSize);

	public void assistagree(Integer id);

	public void stubaseupdate(Student stu, int classid);

	public Classes loadclassbyname(String classname);

	public void classminitorset(Integer classid, String stuid);

	public List<ClassRecord> loadworkrecord(int i, int pageSize, String userid);

	public void workrecordupdate(ClassRecord classrecord);

	public ClassRecord workrecorddetail(Integer id);

	public void workrecordadd(ClassRecord classrecord);

	public void workrecorddelete(Integer id);

	public List<Classes> classteacherclass(String id);

	public List<Performance> loadperformance(int i, int pageSize, String userid);

	public void performancedelete(Integer id);

	public void performanceupdate(Performance performance);

	public void performanceadd(Performance performance);

	public List<Student> loadstubystuname(String stuname);

    public Student loadstubystuid(String id);

	public void changeimg(String imgsrc, Student student);

	public void assistagainst(Integer id);

	public Assistantteacher loadAssustByNum(String num);
	
	public Assistantteacher loadassistbyid(Integer id);

	public long totalroom();

	public long coursetotal();

	public long totalclassrecord();

	public long totalperformance();

	public List<Student> loadallstu();

	public void graduatestuauditagree(Integer id);

    public void graduatestuauditrefuse(Integer id);

	public List<Course> coursesearch(Course course);

	public Classroom loadclassroombyid(Integer id);

	public Course loadcoursebycoursenum(String coursenum);

	public List<Course> loadcourse();

	public List<Classroom> loadroom();

	public Classroom loadroombyid(int roomid);

	public List<Student> stucheckstuid(String stuid);

	public List<Student> stucheckstuid(String stuid, Integer classid,String stuname );

	public Classes loadclassbyteacherid(String usernum);

	public List<Teacher> loaclassteacher();

	public List<Classes> loadclassbyteacher(String identificationnum);

	public long totalassist();

	public List<Classes> classminitorlist(String queryID);

	public List<Student> stucheckstu(String stuid);

	public List<Classroom> loadclassroombyisavaible();

	public List<Classroom> loadclassroombynum(String num);

	public List<Classes> loadclassbyclassname(String classname);

	public List<Student> loadstubystunum(String stuid);

	public List<Classes> loadteacherclasses(String usernum);

	public void sturecovery(String ids);

	public List<Classes> loadclass(Integer id, String classname);

	public List<Classroom> roomcheckagain(Integer id, String num);

	public List<Student> stucheckstuagain(Integer id, String stuid);

	public List<Student> stucheckagain(Integer id, String stuid);

	public List<Student> loadstubyclass(String stuid, Integer id);

	public Course loadcoursebynum(String coursenum);

	public void courserecovery(Integer id);

	public void roomrecovery(Integer id);

	public List<Classes> loadassistbyclass(String assistantnum);

	public List<Classroom> loadclassroombyname(String roomname);

	public Performance loadstuperformance(Integer id);

	public List<Classroom> roomcheck1(String roomname);

	public void assistantteacherupdate(Assistantteacher assistantteacher);

	public void assistanttacherdelete(Integer id);

	public List<Assistantteacher> loadassistbynum(String assistantnum);

	public void graduateclass(Integer id);

	public void classrecovery(Integer id);

	public List<Classes> loadallclasses();

	public List<Classes> loadallclasses1();

	public List<Student> loadstuinschool();

}
