package com.tjpu.dao;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tjpu.bean.Assistantteacher;
import com.tjpu.bean.ChosenCourse;
import com.tjpu.bean.ClassRecord;
import com.tjpu.bean.ClassTeacher;
import com.tjpu.bean.Classes;
import com.tjpu.bean.Classroom;
import com.tjpu.bean.Course;
import com.tjpu.bean.Evalution;
import com.tjpu.bean.MD5;
import com.tjpu.bean.Performance;
import com.tjpu.bean.SemesterChosenCourse;
import com.tjpu.bean.Student;
import com.tjpu.bean.Teacher;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> loginDao(String stuname, String password) {
		 
		String pass = MD5.generate(password);
		String queryString = "from Student u  where  u.passport=:uname and u.password=:pwd  ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("uname", stuname);
		query.setString("pwd",pass);
		//MD5.generate(password);
		List<Student> loginuser = (List<Student>) query.list();
		return loginuser;
	}
		
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Classes> loadclasses() {
		 
		String queryString = "from Classes c  ";//where type=0
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<Classes> classes = (List<Classes>) query.list();
		return classes;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Classes> loadallclasses() {
		 
		String queryString = "from Classes c where c.type!=1";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<Classes> classes = (List<Classes>) query.list();
		return classes;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Classes> loadallclasses1() {
		 
		String queryString = "from Classes c where c.type=0";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<Classes> classes = (List<Classes>) query.list();
		return classes;
	}
	
	/*ѧ���б�*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> loadstudents() {
		 
		String queryString = "from Student s left join fetch s.classes c  order by c.id  ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		//query.setFirstResult(pageNumber);//where s.deleted!=1  
		//query.setMaxResults(pageSize);
		List<Student> stu = (List<Student>) query.list();
		return stu;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> loadstuinschool() {
		 
		String queryString = "from Student s left join fetch s.classes c where s.status=0 and s.deleted=0 order by c.id  ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<Student> stu = (List<Student>) query.list();
		return stu;
	}
	/*ѧ������*/
	@Override
	public long totalstu() {
		 
		String hql = "select count(*) from Student";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		long total = ((Number) query.uniqueResult()).intValue();
		return total;
	}
	
	/*ѧ�����*/
	@Override
	public void stuupdate(Student stu, int classid) {
		 
		Classes cls = (Classes) sessionFactory.getCurrentSession().load(Classes.class, classid);
		Student stu1 = (Student) sessionFactory.getCurrentSession().load(Student.class, stu.getId());
		stu1.setClasses(cls);
		stu1.setStuname(stu.getStuname());
		stu1.setStuid(stu.getStuid());
		//String pass = MD5.generate(stu.getPassword());
		//stu1.setPassword(pass);
		stu1.setSex(stu.getSex());
		stu1.setEnddate(stu.getEnddate());
		stu1.setStartdate(stu.getStartdate());
		stu1.setFirstname(stu.getFirstname());
		stu1.setLastname(stu.getLastname());
		stu1.setNation(stu.getNation());
		stu1.setPassport(stu.getPassport());
		stu1.setValidResidencePermit(stu.getValidResidencePermit());
		stu1.setTelephone(stu.getTelephone());
		stu1.setRoomplace(stu.getRoomplace());
		stu1.setSource(stu.getSource());
		stu1.setBrithdate(stu.getBrithdate());
		stu1.setStudentType(stu.getStudentType());
		sessionFactory.getCurrentSession().update(stu1);
	}
	@Override
	public void stubaseupdate(Student stu, int classid) {
		 
		Student stu1 = (Student) sessionFactory.getCurrentSession().load(Student.class, stu.getId());
		stu1.setStuname(stu.getStuname());
		stu1.setStuid(stu.getStuid());
		stu1.setFirstname(stu.getFirstname());
		stu1.setLastname(stu.getLastname());
		stu1.setNation(stu.getNation());
		stu1.setPassport(stu.getPassport());
		stu1.setTelephone(stu.getTelephone());
		stu1.setRoomplace(stu.getRoomplace());
		stu1.setSource(stu.getSource());
		stu1.setStudentType(stu.getStudentType());
		sessionFactory.getCurrentSession().update(stu1);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void studelete(int stuid) {
		 	
		Student stu = (Student) sessionFactory.getCurrentSession().load(Student.class, stuid);		
		if(stu==null){
			return;
		}
		if(stu.getDeleted()!=1){
			stu.setDeleted(1);
			stu.setPassword("idonotknow");
			sessionFactory.getCurrentSession().update(stu);
		}else {
			String query1 = "from ChosenCourse c where c.passport=:stuid";
			Query query = sessionFactory.getCurrentSession().createQuery(query1);
			query.setString("stuid", stu.getPassport());
			List<ChosenCourse> cho = (List<ChosenCourse>)query.list();
            if (cho.size()>0) {
				return;
			}else {
				sessionFactory.getCurrentSession().delete(stu);
			}			
		}		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> stucheck(String stuid) {
		 
		String queryString = "from Student s  where s.passport=:num";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("num", stuid);
		List<Student> stu = (List<Student>) query.list();
		return stu;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> stucheckagain(Integer id,String stuid) {
		 
		String queryString = "from Student s  where s.passport=:num and s.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("num", stuid);
		query.setInteger("id", id);
		List<Student> stu = (List<Student>) query.list();
		return stu;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> stucheckstu(String stuid) {
		 
		String queryString = "from Student s  where s.stuid=:num";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("num", stuid);
		List<Student> stu = (List<Student>) query.list();
		return stu;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> stucheckstuagain(Integer id,String stuid) {
		 
		String queryString = "from Student s  where s.stuid=:num and s.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("num", stuid);
		query.setInteger("id", id);
		List<Student> stu = (List<Student>) query.list();
		return stu;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> stucheckstuid(String stuid) {
		 
		String queryString = "from Student s  where s.stuid=:num";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("num", stuid);
		List<Student> stu = (List<Student>) query.list();
		return stu;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> stucheckstuid(String stuid,Integer classid,String stuname) {
		if (stuname.length()==0) {
			String queryString = "from Student s left join fetch s.classes c where s.stuid=:num and c.id=:classid";
			Query query = sessionFactory.getCurrentSession().createQuery(queryString);
			query.setString("num", stuid);
			query.setInteger("classid", classid);
			List<Student> stu = (List<Student>) query.list();
			return stu;
		}else {
			String queryString = "from Student s left join fetch s.classes c where s.stuid=:num and c.id=:classid and s.stuname=:stuname";
			Query query = sessionFactory.getCurrentSession().createQuery(queryString);
			query.setString("num", stuid);
			query.setInteger("classid", classid);
			query.setString("stuname", stuname);
			List<Student> stu = (List<Student>) query.list();
			return stu;
		}
		
	}
	@Override
	public Classes loadclassbyid(int classid) {
		 
		Classes cls = (Classes) sessionFactory.getCurrentSession().load(Classes.class, classid);
		return cls;
	}
	@Override
	public void stuadd(Student stu) {
		stu.setDeleted(0);
		stu.setIsPaid("0");
		sessionFactory.getCurrentSession().save(stu);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> classcheck(String classname) {
		 
		String queryString = "from Classes c where c.classname=:num ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("num", classname);
		List<Classes> stuclass = (List<Classes>) query.list();
		return stuclass;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> loadclass(Integer id,String classname) {
		 
		String queryString = "from Classes c where c.classname=:classname and c.id=:id ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("classname", classname);
		query.setInteger("id", id);
		List<Classes> stuclass = (List<Classes>) query.list();
		return stuclass;
	}
	@Override
	public void classadd(Classes cls) {
		 
		sessionFactory.getCurrentSession().save(cls);
	}
	@Override
	public void classupdate(Classes cls) {
		 
		Classes cls1 = (Classes) sessionFactory.getCurrentSession().load(Classes.class, cls.getId());
		cls1.setClassname(cls.getClassname());
		cls1.setMajor(cls.getMajor());
		cls1.setClassname_en(cls.getClassname_en());
		sessionFactory.getCurrentSession().update(cls1);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void classdelete(Integer id) {
		
		Classes cls = (Classes)sessionFactory.getCurrentSession().load(Classes.class,id);
		
		String querystring = "from Student s left join fetch s.classes c where c.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setInteger("id", id);
		List<Student> students =(List<Student>)query.list();
		if(students.size()>0){
			return;
		}else{
			if (cls.getType()==0) {
				cls.setType(1);
				sessionFactory.getCurrentSession().update(cls);
			}else if(cls.getType()==1) {
				sessionFactory.getCurrentSession().delete(cls);	
			}			
		}
		
	}
	
	@Override
	public void classrecovery(Integer id) {
		
		Classes cls = (Classes)sessionFactory.getCurrentSession().load(Classes.class,id);
        if(cls.getType()==1){
        	cls.setType(0);
        	sessionFactory.getCurrentSession().update(cls);
        }else {
			return ;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> loadcourse(int i, int pageSize/*, Integer role*/) {
		 
		String queryString = "from Course s order by s.num ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setFirstResult(i);
		query.setMaxResults(pageSize);
		List<Course> course = (List<Course>) query.list();
		return course;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> coursecheck(String coursename) {
		 
		String queryString = "from Course c where c.coursename=:coursename";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("coursename", coursename);
		List<Course> course = (List<Course>) query.list();
		return course;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> coursecheck1(String num) {
		 
		String queryString = "from Course c where c.num=:num";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("num", num);
		List<Course> course = (List<Course>) query.list();
		return course;
	}
	@Override
	public void courseadd(Course course) {
		 
		sessionFactory.getCurrentSession().save(course);
	}
	@Override
	public void courseupdate(Course course) {
		 
		Course course1 = (Course)sessionFactory.getCurrentSession().load(Course.class, course.getId());
		course1.setBeginweeks(course.getBeginweeks());
		course1.setCharacter(course.getCharacter());
		course1.setCheckway(course.getCheckway());
		course1.setCoursename(course.getCoursename());
		course1.setCredits(course.getCredits());
		course1.setWeeklesson(course.getWeeklesson());
		course1.setEndweeks(course.getEndweeks());
		course1.setNum(course.getNum());
		course1.setTeacher(course.getTeacher());
		course1.setAcademic(course.getAcademic());
		sessionFactory.getCurrentSession().update(course1);
	}
	@Override
	public void coursedelete(Integer id) {
		 // 设为1即是删除
		Course course = (Course)sessionFactory.getCurrentSession().load(Course.class, id);
		
		if (course == null)
			return;
		
		if (course.getDeleted() != 1) {
			course.setDeleted(1);
			sessionFactory.getCurrentSession().update(course);
			return;
		}
		
		String queryString ="from ChosenCourse c where c.courseId=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("id", String.valueOf(course.getNum()));
		@SuppressWarnings("unchecked")
		List<ChosenCourse>  ret1 = (List<ChosenCourse>)query.list();
		
		String queryString2 ="from SemesterChosenCourse c where c.coursenum=:id";
		Query query2 = sessionFactory.getCurrentSession().createQuery(queryString2);
		query2.setString("id", String.valueOf(course.getNum()));
		@SuppressWarnings("unchecked")
		List<SemesterChosenCourse>  ret2 = (List<SemesterChosenCourse>)query2.list();
		
		if (ret2.size() > 0 || ret1.size() > 0) {
			return;
		}
		
		sessionFactory.getCurrentSession().delete(course);
	}
	@Override
	public void courserecovery(Integer id){
	  Course course = (Course)sessionFactory.getCurrentSession().load(Course.class, id);
	  course.setDeleted(0);
	  sessionFactory.getCurrentSession().update(course);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> loadroom(int i, int pageSize) {
		 
		String queryString = "from Classroom c  ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setFirstResult(i);
		query.setMaxResults(pageSize);
		List<Classroom> room = (List<Classroom>) query.list();
		return room;
	}
	@Override
	public void roomadd(Classroom room) {
	  sessionFactory.getCurrentSession().save(room);
	}
	@Override
	public void roomupdate(Classroom room) {
		 
		Classroom room1 = (Classroom)sessionFactory.getCurrentSession().load(Classroom.class, room.getNum());
		room1.setNote(room.getNote());
		//room1.setNum(room.getNum());
		room1.setRoomcapacity(room.getRoomcapacity());
		room1.setRealcapacity(room.getRealcapacity());
		room1.setRoomname(room.getRoomname());
		room1.setRoomplace(room.getRoomplace());
		room1.setRoomtype(room.getRoomtype());
		room1.setIsavaible(room.getIsavaible());
		sessionFactory.getCurrentSession().update(room1);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void roomdelete(Integer id) {		 
		Classroom room1 = (Classroom)sessionFactory.getCurrentSession().load(Classroom.class, id);
	    if(room1==null){
	    	return ;
	    }
		if(room1.getDeleted()!=1){
	    	room1.setDeleted(1);
			sessionFactory.getCurrentSession().update(room1);
	    }else {
	    	String querString ="from SemesterChosenCourse s where s.roomname=:num";
	    	Query query = sessionFactory.getCurrentSession().createQuery(querString);
	    	query.setInteger("num", room1.getNum());
	    	List<SemesterChosenCourse> sem = (List<SemesterChosenCourse>)query.list();
	    	if (sem.size()>0) {
				return;
			}else {
				sessionFactory.getCurrentSession().delete(room1);
			}			
		}		
	}
	@Override
	public void roomrecovery(Integer id){
		Classroom classroom = (Classroom)sessionFactory.getCurrentSession().load(Classroom.class, id);
		classroom.setDeleted(0);
		sessionFactory.getCurrentSession().update(classroom);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> roomcheck(Integer num) {
		 
		String queryString="from Classroom c where c.num =:num";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("num", num);
		List<Classroom> room = (List<Classroom>)query.list();
		return room;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> roomcheck1(String roomname) {
		 
		String queryString="from Classroom c where c.roomname =:num";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("num", roomname);
		List<Classroom> room = (List<Classroom>)query.list();
		return room;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> roomcheckagain(Integer id,String num) {
		 
		String queryString="from Classroom c where c.roomname =:num and c.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("num", num);
		query.setInteger("id", id);
		List<Classroom> room = (List<Classroom>)query.list();
		return room;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> loadstubyclassid(int classid) {
		 
		String queryString = "from Student s left join fetch s.classes c where c.id=:ids and s.deleted!=1 order by s.id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("ids", classid);//
		List<Student> stus = (List<Student>) query.list();
		return stus;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> roomsearch(Classroom room) {
		 
		List<Classroom> classrooms = new ArrayList<Classroom>();
		String roomname = null;
		Integer roomcapacity = null;
		try {
			roomcapacity = room.getRoomcapacity();
			roomname = java.net.URLDecoder.decode(room.getRoomname(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		if (roomname.length()!=0) {
			if (roomcapacity!=null) {
				String querystrinString ="from Classroom c where c.roomname=:roomname and c.roomcapacity =:roomplace";
				Query query = sessionFactory.getCurrentSession().createQuery(querystrinString);
				query.setString("roomname", roomname);
				query.setInteger("roomplace", roomcapacity);
				classrooms = (List<Classroom>)query.list();				
			}else {
				String querystrinString ="from Classroom c where c.roomname=:roomname ";
				Query query = sessionFactory.getCurrentSession().createQuery(querystrinString);
				query.setString("roomname", roomname);
				classrooms = (List<Classroom>)query.list();
			}
		}else {
			String querystrinString ="from Classroom c where  c.roomcapacity>=roomplace";
			Query query = sessionFactory.getCurrentSession().createQuery(querystrinString);
			query.setInteger("roomplace", roomcapacity);
			//Restrictions.ge("roomplace", roomcapacity);
			classrooms = (List<Classroom>)query.list();		
		}
		return classrooms;
	}
	@Override
	public void userchangpwd(Student user) {
		 
		Student user1 = (Student) sessionFactory.getCurrentSession().load(Student.class, user.getId());
		String pass = MD5.generate(user.getPassword());
		user1.setPassword(pass);		
		sessionFactory.getCurrentSession().update(user1);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> pwdcheck(Integer id, String password) {
		 
		String pass = MD5.generate(password);
		String queryString = "from Student u  where u.id=:id and u.password=:password ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("password", pass);
		query.setInteger("id", id);
		List<Student> user = (List<Student>) query.list();
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Student loadstubyid(Integer id) {		 
		Student student2 = null;
		if (id==null) {
			return student2;
		}else {
			String querString = "from Student s where s.id=:id";
			Query query = sessionFactory.getCurrentSession().createQuery(querString);
			query.setInteger("id", id);
			List<Student> student = (List<Student>)query.list();				
			return student.get(0);
		}
				
	}
	@SuppressWarnings("unchecked")
	@Override
	public Student loadstubystuid(String  id) {
		 
		Student student2 = null;
		if (id==null||id.equals(null)) {
			return student2;
		}else {
			String querString = "from Student s where s.passport=:id";
			Query query = sessionFactory.getCurrentSession().createQuery(querString);
			query.setString("id", id);
			List<Student> student = (List<Student>)query.list();
			if (student == null || student.size() > 0)
				return student.get(0);
			return null;
		}
				
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> stusearch(Student stu) {
		 
		List<Student> students = new ArrayList<Student>();
		String stuname = null;
		String passport = null;
		try {
			stuname = java.net.URLDecoder.decode(stu.getStuname(),"UTF-8");
			passport =java.net.URLDecoder.decode(stu.getPassport(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		 
		if (stuname.length()!=0) {
			if (passport.length()!=0) {
				String querystrinString ="from Student s where s.stuname=:stuname and s.passport =:passport";
				Query query = sessionFactory.getCurrentSession().createQuery(querystrinString);
				query.setString("stuname", stuname);
				query.setString("passport", passport);
				students = (List<Student>)query.list();				
			}else {
				String querystrinString ="from Student s where s.stuname=:stuname ";
				Query query = sessionFactory.getCurrentSession().createQuery(querystrinString);
				query.setString("stuname", stuname);
				students = (List<Student>)query.list();
			}
		}else {
			String querystrinString ="from Student s where  s.passport =:passport";
			Query query = sessionFactory.getCurrentSession().createQuery(querystrinString);
			query.setString("passport", passport);
			students = (List<Student>)query.list();		
		}
		return students;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> studentlist() {
		 
		String querString = "from Student s order by s.id";
		Query query = sessionFactory.getCurrentSession().createQuery(querString);
		List<Student> students = (List<Student>)query.list();
		return students;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChosenCourse> loadstucourse(String usernum ,String semester ) {
		 
		String quString ="from ChosenCourse c where c.passport=:usernum and c.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(quString);
		query.setString("usernum", usernum);
		query.setString("semester", semester);
		List<ChosenCourse> courses = (List<ChosenCourse>)query.list();
		return courses;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evalution> loadevalutions(String userid,String semester,Integer flag) {
		 
		String quString ="from Evalution e where e.passport=:userid and e.semester=:semester and e.flag=:flag";
		Query query = sessionFactory.getCurrentSession().createQuery(quString);
		query.setString("userid", userid);
		query.setString("semester", semester);
		query.setInteger("flag", flag);
		List<Evalution>  evalutions = (List<Evalution>)query.list();
		return evalutions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Course loadcoursebyid(Integer id) {
		 
		String queryString = "from Course c where c.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("id", id);
		List<Course> courses = (List<Course>)query.list();
		return courses.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Course loadcoursebycoursenum(String  num) {
		 
		String queryString = "from Course c where c.num=:num and c.deleted!=1 ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("num", num);
		List<Course> courses = (List<Course>)query.list();
		if (courses == null || courses.size() == 0)
			return null;
		return courses.get(0);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Course loadcoursebynum(String  coursenum) {
		 
		String queryString = "from Course c where c.num=:num  ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("num", coursenum);
		List<Course> courses = (List<Course>)query.list();
		if (courses == null || courses.size() == 0)
			return null;
		return courses.get(0);
	}
	@Override
	public void assistantteacheradd(Assistantteacher assistantteacher) {
		 
		sessionFactory.getCurrentSession().save(assistantteacher);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Assistantteacher> loadassist(int i, int pageSize) {
		 
		String queryString ="from Assistantteacher a ";//where a.academictype=1
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setFirstResult(i);
		query.setMaxResults(pageSize);
		List<Assistantteacher> assistantteachers = (List<Assistantteacher>)query.list();
		return assistantteachers;
	}
	
	public List<Assistantteacher> loadAllAssis() {
		String queryString ="from Assistantteacher a ";//where a.academictype=1
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<Assistantteacher> assistantteachers = (List<Assistantteacher>)query.list();
		return assistantteachers;
	}

	@Override
	public void assistagree(Integer id) {
		 
		Assistantteacher assistantteacher = (Assistantteacher)sessionFactory.getCurrentSession().load(Assistantteacher.class, id);
		assistantteacher.setAcademictype(1);
		sessionFactory.getCurrentSession().update(assistantteacher);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Classes loadclassbyname(String classname) {
		 
		String queryString ="from Classes c where c.classname=:classname";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("classname", classname);
		List<Classes> classes = (List<Classes>)query.list();
		if (classes == null || classes.size() == 0) {
			return null;
		}else {
			return classes.get(0);
		}
		
	}

	@Override
	public void classminitorset(Integer classid, String stuid) {
		 
		Classes cls = (Classes)sessionFactory.getCurrentSession().load(Classes.class, classid);
		cls.setClassminitorid(stuid);
		sessionFactory.getCurrentSession().update(cls);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClassRecord> loadworkrecord(int i, int pageSize,String  userid) {
		 
		String queryString ="from ClassRecord c where c.teacherid=:userid ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("userid", userid);
		query.setFirstResult(i);
		query.setMaxResults(pageSize);
		List<ClassRecord> classrecord = (List<ClassRecord>)query.list();
		return classrecord;
	}

	@Override
	public void workrecordupdate(ClassRecord classrecord) {
		 
		ClassRecord classrecord2 = (ClassRecord)sessionFactory.getCurrentSession().load(ClassRecord.class, classrecord.getId());
		classrecord2.setAppointmentnumber(classrecord.getAppointmentnumber());
		classrecord2.setClassid(classrecord.getClassid());
		classrecord2.setClassmeetingfrequency(classrecord.getClassmeetingfrequency());
		classrecord2.setDate(classrecord.getDate());
		classrecord2.setFeedback(classrecord.getFeedback());
		classrecord2.setPhysicalmentalcondition(classrecord.getPhysicalmentalcondition());
		classrecord2.setStudyingcondition(classrecord.getStudyingcondition());
		classrecord2.setSelfevalution(classrecord.getSelfevalution());
		classrecord2.setTeacherid(classrecord.getTeacherid());
		sessionFactory.getCurrentSession().update(classrecord2);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClassRecord workrecorddetail(Integer id) {
		 
		String queryString = "from ClassRecord c where c.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("id", id);
		List<ClassRecord> classRecords = (List<ClassRecord>)query.list();
		return classRecords.get(0);
	}

	@Override
	public void workrecordadd(ClassRecord classrecord) {
		 
		sessionFactory.getCurrentSession().save(classrecord);
	}

	@Override
	public void workrecorddelete(Integer id) {
		 
		ClassRecord classrecord = (ClassRecord)sessionFactory.getCurrentSession().load(ClassRecord.class, id);
		sessionFactory.getCurrentSession().delete(classrecord);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> classteacherclass(String id) {
		 
		String querystring = "from Classes c where c.classteacherid=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("id", id);
		List<Classes> classes = (List<Classes>)query.list();
		return classes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Performance> loadperformance(int i, int pageSize,String  userid) {		 
		String queryString = "from Performance p where p.teachernum=:userid";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("userid", userid);
		query.setFirstResult(i);
		query.setMaxResults(pageSize);
		List<Performance> performances = (List<Performance>) query.list();
		return performances;
	}

	@Override
	public void performancedelete(Integer id) {
		 
		Performance performance = (Performance)sessionFactory.getCurrentSession().load(Performance.class, id);
		sessionFactory.getCurrentSession().delete(performance);
	}

	@Override
	public void performanceupdate(Performance performance) {
		 
		Performance performance2 = (Performance)sessionFactory.getCurrentSession().load(Performance.class, performance.getId());
		performance2.setDailylife(performance.getDailylife());
		performance2.setDate(performance.getDate());
		performance2.setEvent(performance.getEvent());
		performance2.setOutstanding(performance.getOutstanding());
		performance2.setPsychicology(performance.getPsychicology());
		performance2.setRemark(performance.getRemark());
		performance2.setStudy(performance.getStudy());
		//performance2.setStuid(performance.getStuid());
		sessionFactory.getCurrentSession().update(performance2);
	}

	@Override
	public void performanceadd(Performance performance) {
		 
		sessionFactory.getCurrentSession().save(performance);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> loadstubystuname(String stuname) {
		 
		String stunames = null;
		try {
			stunames = java.net.URLDecoder.decode(stuname,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		String querystrString = "from Student s where s.stuname=:stuname";
		Query query = sessionFactory.getCurrentSession().createQuery(querystrString);
		query.setString("stuname", stunames);
		List<Student> students =(List<Student>)query.list();
		return students;
	}

	@Override
	public void changeimg(String imgsrc, Student student) {
		 
		Student student2 = (Student)sessionFactory.getCurrentSession().load(Student.class, student.getId());
		student2.setImgurl(imgsrc);
		sessionFactory.getCurrentSession().update(student2);
	}

	@Override
	public void assistagainst(Integer id) {
		 
		Assistantteacher assistantteacher = (Assistantteacher)sessionFactory.getCurrentSession().load(Assistantteacher.class, id);
		assistantteacher.setAcademictype(2);
		sessionFactory.getCurrentSession().update(assistantteacher);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Assistantteacher loadassistbyid(Integer id) {
		 
		String querysString = "from Assistantteacher a where a.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setInteger("id", id);
		List<Assistantteacher> assistantteachers = (List<Assistantteacher>)query.list();
		return assistantteachers.get(0);
	}

	@Override
	public long totalroom() {
		 
		String hql = "select count(*) from Classroom c where c.deleted!=1 ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		long total = ((Number) query.uniqueResult()).intValue();
		return total;
	}
	@Override
	public long coursetotal() {
		 
		String hql = "select count(*) from Course ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		long total = ((Number) query.uniqueResult()).intValue();
		return total;
	}
	@Override
	public long totalclassrecord() {
		 
		String hql = "select count(*) from ClassRecord";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		long total = ((Number) query.uniqueResult()).intValue();
		return total;
	}
	@Override
	public long totalperformance() {
		 
		String hql = "select count(*) from Performance";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		long total = ((Number) query.uniqueResult()).intValue();
		return total;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> loadallstu() {
		 
		String querysString ="from Student s left join fetch s.classes c order by c.id asc";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		List<Student> students = (List<Student>)query.list();
		return students;
	}

	@Override
	public void graduatestuauditagree(Integer id) {
		 
		Student student = (Student)sessionFactory.getCurrentSession().load(Student.class, id);
		student.setStatus(String.valueOf(1));
		sessionFactory.getCurrentSession().update(student);
	}
	@Override
	public void graduatestuauditrefuse(Integer id) {
		 
		Student student = (Student)sessionFactory.getCurrentSession().load(Student.class, id);
		student.setStatus(String.valueOf(2));
		sessionFactory.getCurrentSession().update(student);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> coursesearch(Course course) {
		 
		String coursename = null;
		String character = null;
		String num = null;
		List<Course> courses = new ArrayList<Course>();
		try {
			coursename = java.net.URLDecoder.decode(course.getCoursename(),"UTF-8");
			character = java.net.URLDecoder.decode(course.getCharacter(),"UTF-8");
			num = course.getNum();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		if (coursename.length()==0) {
			if (character.length()==0) {
				String queryString = "from Course c where c.num=:num and c.deleted!=1";
				Query query = sessionFactory.getCurrentSession().createQuery(queryString);
				query.setString("num", num);
				courses = (List<Course>)query.list();
				return courses;
			}else {
				if (num==null) {
					String queryString = "from Course c where c.character=:character and c.deleted!=1";
					Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					query.setString("character", character);
					courses = (List<Course>)query.list();
					return courses;
				}else {
					String queryString = "from Course c where c.character=:character and c.num=:num and c.deleted!=1";
					Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					query.setString("character", character);
					query.setString("num", num);
					courses = (List<Course>)query.list();
					return courses;
				}
			}
		}else {
			if (character.length()==0) {
				if (num==null) {
					String queryString = "from Course c where  c.coursename=:coursename and c.deleted!=1";
					Query query = sessionFactory.getCurrentSession().createQuery(queryString);					
					query.setString("coursename", coursename);
					courses = (List<Course>)query.list();
					return courses;
				}else {
					String queryString = "from Course c where c.num=:num and c.coursename=:coursename and c.deleted!=1";
					Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					query.setString("num", num);
					query.setString("coursename", coursename);
					courses = (List<Course>)query.list();
					return courses;
				}				
			}else {
				if (num==null) {
					String queryString = "from Course c where  c.coursename=:coursename and c.character=:character and c.deleted!=1";
					Query query = sessionFactory.getCurrentSession().createQuery(queryString);					
					query.setString("coursename", coursename);
					query.setString("character", character);
					courses = (List<Course>)query.list();
					return courses;
				}else {
					String queryString = "from Course c where c.num=:num and c.coursename=:coursename and c.character=:character and c.deleted!=1 ";
					Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					query.setString("num", num);
					query.setString("coursename", coursename);
					query.setString("character", character);
					courses = (List<Course>)query.list();
					return courses;
				}	
			}
			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Classroom loadclassroombyid(Integer id) {
		 
		String querystring = "from Classroom c where c.num=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setInteger("id", id);
		List<Classroom> classrooms = (List<Classroom>)query.list();
		return classrooms.get(0);
	}

	/* (non-Javadoc)
	 * @see com.tjpu.dao.StudentDao#loadcourse()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> loadcourse() {
		 
		String queryString = "from Course s where s.deleted!=1 order by s.num ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<Course> course = (List<Course>) query.list();
		return course;
	}

	/* (non-Javadoc)
	 * @see com.tjpu.dao.StudentDao#loadroom()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> loadroom() {
		 
		String queryString = "from Classroom c ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);		
		List<Classroom> room = (List<Classroom>) query.list();
		return room;
	}

	/* (non-Javadoc)
	 * @see com.tjpu.dao.StudentDao#loadroombyid(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Classroom loadroombyid(int roomid) {
		 
		String queryString = "from Classroom c where c.id=:id ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);	
		query.setInteger("id", roomid);
		List<Classroom> room = (List<Classroom>) query.list();
		return room.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Classes loadclassbyteacherid(String usernum) {
		// TODO Auto-generated method stub
	    String queryString ="from Classes c where c.classteacherid=:usernum ";
	    Query query = sessionFactory.getCurrentSession().createQuery(queryString);
	    query.setInteger("usernum", Integer.valueOf(usernum));
	    List<Classes> cls = (List<Classes>)query.list();
		return cls.get(0);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> loadclassbyteacher(String identificationnum) {
		// TODO Auto-generated method stub
	    String queryString ="from Classes c where c.classteacherid=:identificationnum ";
	    Query query = sessionFactory.getCurrentSession().createQuery(queryString);
	    query.setString("identificationnum", identificationnum);
	    List<Classes> cls = (List<Classes>)query.list();
		return cls;
	}

	@Override
	public Teacher loadClassTeacherByIdent(String ident) {
		String queryString = "from Teacher c where c.identificationnum=:id and c.type=1 ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);	
		query.setString("id", ident);
		@SuppressWarnings("unchecked")
		List<Teacher> ret = (List<Teacher>) query.list();
		if (ret.size() > 0)
			return ret.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> loadClassTeacher(int i, int pagesize) {
		String queryString ="from Teacher a where a.deleted != 1 ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		List<Teacher> ret = (List<Teacher>)query.list();
		return ret;
	}
	
	public List<Teacher> loadAllAvlTeacher(){
		String queryString ="from Teacher a where a.deleted!=1 ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);

		List<Teacher> ret = (List<Teacher>)query.list();
		if (ret == null)
			return new ArrayList<Teacher>();
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int ClassTeacherNum() {
		String queryString ="from Teacher a where a.deleted!=1 ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);

		List<Teacher> ret = (List<Teacher>)query.list();
		if (ret == null)
			return 0;
		return ret.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> chargeClassList (String ident){
		String queryString = "from Classes c where c.classteacherid=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);	
		query.setString("id", ident);
		List<Classes> ret = (List<Classes>) query.list();
		if (ret == null)
			return new ArrayList<Classes>();
		return ret;
	}


	/* (non-Javadoc)
	 * @see com.tjpu.dao.StudentDao#loaclassteacher()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> loaclassteacher() {
		// TODO Auto-generated method stub
		//String queryString ="from Teacher a  where a.type=1";
		String queryString ="from Teacher a where a.deleted!=1 ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<Teacher> ret = (List<Teacher>)query.list();
		return ret;
	}

	/* (non-Javadoc)
	 * @see com.tjpu.dao.StudentDao#totalassist()
	 */
	@Override
	public long totalassist() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Assistantteacher ";//a where a.academictype=1
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		long total = ((Number) query.uniqueResult()).intValue();
		return total;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> assisClassList(String id) {
		String queryString = "from Classes c where c.assisTeacherId=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);	
		query.setString("id", id);
		List<Classes> ret = (List<Classes>) query.list();
		if (ret == null)
			return new ArrayList<Classes>();
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Assistantteacher loadAssustByNum(String num) {
		String querysString = "from Assistantteacher a where a.assistantnum=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setString("id", num);
		List<Assistantteacher> assistantteachers = (List<Assistantteacher>)query.list();
		if (assistantteachers == null ||assistantteachers.size() == 0)
			return null;
		return assistantteachers.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> classminitorlist(String queryID) {
		// TODO Auto-generated method stub
		String queryString = "from Classes c where c.id=:queryID";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);	
		query.setString("queryID", queryID);
		List<Classes> ret = (List<Classes>) query.list();		
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> stuFuzzySearch(String text) {
		String queryString = "from Student c left join fetch c.classes s where c.firstname like :t1 or c.lastname like :t2 or c.stuname like :t3 or c.stuid like :t4 or c.passport like :t5"
				+ " or c.nation like :t6 or s.classname like :t7  "  ;
		
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		
		query.setString("t1", "%" + text + "%");
		query.setString("t2", "%" + text + "%");
		query.setString("t3", "%" + text + "%");
		query.setString("t4", "%" + text + "%");
		query.setString("t5", "%" + text + "%");
		query.setString("t6", "%" + text + "%");
		query.setString("t7", "%" + text + "%");
		List<Student> ret = (List<Student>) query.list();		
		return ret;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> loadclassroombyisavaible() {
		// TODO Auto-generated method stub
		String queryString = "from Classroom c where c.isavaible=0 and c.deleted!=1 ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);	
		List<Classroom> ret = (List<Classroom>) query.list();		
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> loadclassroombynum(String num) {
		// TODO Auto-generated method stub
		String queryString = "from Classroom c where c.num=:num";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);	
		query.setString("num", num);
		List<Classroom> ret = (List<Classroom>) query.list();		
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> loadclassbyclassname(String classname) {
		// TODO Auto-generated method stub
		String queryString = "from Classes c where c.classname=:num";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);	
		query.setString("num", classname);
		List<Classes> ret = (List<Classes>) query.list();		
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> loadstubystunum(String stuid) {
		// TODO Auto-generated method stub
		String querString = "from Student s where s.stuid=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querString);
		query.setString("id", stuid);
		List<Student> student = (List<Student>)query.list();				
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> loadteacherclasses(String usernum) {
		// TODO Auto-generated method stub
		String querString = "from Classes s where s.classteacherid=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querString);
		query.setString("id", usernum);
		List<Classes> classlist = (List<Classes>)query.list();				
		return classlist;
	}

	@Override
	public void sturecovery(String ids) {
		// TODO Auto-generated method stub
	  Student student = (Student)sessionFactory.getCurrentSession().load(Student.class, Integer.valueOf(ids));
	  if(student.getDeleted()==0){
		  String password = "123456";
		  password = MD5.generate(password);
		  student.setPassword(password);
		  sessionFactory.getCurrentSession().update(student);
	  }else {
		  student.setDeleted(0);
		  String password = "123456";
		  password = MD5.generate(password);
		  student.setPassword(password);
		  sessionFactory.getCurrentSession().update(student);
	}	  
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> loadstubyclass(String stuid, Integer id) {
		// TODO Auto-generated method stub
		String querystring = "from Student s left join fetch s.classes c where s.stuid=:stuid and c.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("stuid", stuid);
		query.setInteger("id", id);
		List<Student> students = (List<Student>)query.list();
		return students;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> loadassistbyclass(String assistantnum) {
		// TODO Auto-generated method stub
		String querystring ="from Classes c where c.assisTeacherId=:assistantnum";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("assistantnum", assistantnum);
		List<Classes> classlist = (List<Classes>)query.list();
		return classlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> loadclassroombyname(String roomname) {
		// TODO Auto-generated method stub
		String queryString = "from Classroom c where c.roomname=:roomname";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("roomname", roomname);
		List<Classroom> roomlist = (List<Classroom>)query.list();
		return roomlist;
	}

	@Override
	public Performance loadstuperformance(Integer id) {
		// TODO Auto-generated method stub
		String queryString = "from Performance c where c.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("id", id);
		List<Performance> performances = (List<Performance>)query.list();
		if (performances.size()==0) {
			return null;
		}
		return performances.get(0);
	}

	@Override
	public void assistantteacherupdate(Assistantteacher assistantteacher) {
		// TODO Auto-generated method stub
		Assistantteacher ass = (Assistantteacher)sessionFactory.getCurrentSession().load(Assistantteacher.class, assistantteacher.getId());
		ass.setAssistantnum(assistantteacher.getAssistantnum());
		ass.setBrithdate(assistantteacher.getBrithdate());
		ass.setClassname(assistantteacher.getClassname());
		ass.setDepartment(assistantteacher.getDepartment());
		ass.setEdulevel(assistantteacher.getEdulevel());
		ass.setEmail(assistantteacher.getEmail());
		ass.setForte(assistantteacher.getForte());
        ass.setTelephone(assistantteacher.getTelephone());
        ass.setSecondlanguagetype(assistantteacher.getSecondlanguagetype());
        ass.setSecondlanguagelevel(assistantteacher.getSecondlanguagelevel());
        ass.setPoliticalstatus(assistantteacher.getPoliticalstatus());
        ass.setNation(assistantteacher.getNation());
        ass.setName(assistantteacher.getName());
        ass.setMajor(assistantteacher.getMajor());
        ass.setGender(assistantteacher.getGender());
        sessionFactory.getCurrentSession().update(ass);
	}

	@Override
	public void assistanttacherdelete(Integer id) {
		// TODO Auto-generated method stub
		Assistantteacher ass = (Assistantteacher)sessionFactory.getCurrentSession().load(Assistantteacher.class, id);
		sessionFactory.getCurrentSession().delete(ass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Assistantteacher> loadassistbynum(String assistantnum) {
		// TODO Auto-generated method stub
		String querystring = "from Assistantteacher a where a.assistantnum=:assistantnum";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("assistantnum", assistantnum);
		List<Assistantteacher> ass =(List<Assistantteacher>)query.list();
		return ass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void graduateclass(Integer id) {
		// TODO Auto-generated method stub
		Classes classes = (Classes)sessionFactory.getCurrentSession().load(Classes.class, id);
		
		String querystring = "from Student s left join fetch s.classes c where c.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setInteger("id", classes.getId());
		List<Student> student = (List<Student>)query.list();
		List<Student> stu = new ArrayList<Student>();
		for(Student s:student){
			if(s.getStatus().equals("0")||s.getStatus().equals("2")){
				stu.add(s);
			}
		}
		if(stu.size()>0){
			return ;
		}else {
			classes.setType(2);
			sessionFactory.getCurrentSession().update(classes);
		}
	}

}
