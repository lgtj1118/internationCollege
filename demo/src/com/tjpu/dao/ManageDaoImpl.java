package com.tjpu.dao;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.From;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.Adjustcourse;
import com.tjpu.bean.Announcement;
import com.tjpu.bean.Attendence;
import com.tjpu.bean.Certify1;
import com.tjpu.bean.ChosenCourse;
import com.tjpu.bean.ChosenCourseModel;
import com.tjpu.bean.Classes;
import com.tjpu.bean.ClassesModel;
import com.tjpu.bean.Classroom;
import com.tjpu.bean.Course;
import com.tjpu.bean.Dept;
import com.tjpu.bean.Evalution;
import com.tjpu.bean.FileRecord;
import com.tjpu.bean.Leave;
import com.tjpu.bean.MD5;
import com.tjpu.bean.Performance;
import com.tjpu.bean.SemesterChosenClassroom;
import com.tjpu.bean.SemesterChosenCourse;
import com.tjpu.bean.SemesterChosenCourseModel;
import com.tjpu.bean.Student;
import com.tjpu.bean.Teacher;
import com.tjpu.bean.User;

@Repository
@Transactional
public class ManageDaoImpl implements ManageDao {
	@Autowired
	SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")

	public List<Teacher> loginDao(String usernum, String password/*,Integer type*/) {
		
		String pass = MD5.generate(password);//and u.type=:type
		String queryString = "from Teacher u where  u.identificationnum=:usernum and u.password=:pwd  ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("usernum", usernum);
		query.setString("pwd",pass );
		//query.setInteger("type", type);
		List<Teacher> loginuser = (List<Teacher>) query.list();
		return loginuser;
	}

	public void evalutionteacheradd(Evalution evalution) {
		
		sessionFactory.getCurrentSession().save(evalution);
	}
	@SuppressWarnings("unchecked")

	public List<Evalution> loadevalution(String id,String semester) {
		
		String queryString ="from Evalution e where e.courseid=:id and e.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("id", id);
		query.setString("semester", semester);
		List<Evalution> evalutionlist = (List<Evalution>)query.list();
		return evalutionlist;
	}
	@SuppressWarnings("unchecked")

	public List<Teacher> loadteacher() {
		
		String queryString = "from Teacher s order by s.identificationnum asc ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<Teacher> teacher = (List<Teacher>) query.list();
		return teacher;
	}

	public void teacherupdate(Teacher teacher) {
		
		Teacher teachers = (Teacher)sessionFactory.getCurrentSession().load(Teacher.class, teacher.getId());
		//teachers.setBrithdate(teacher.getBrithdate());
		teachers.setPosition(teacher.getPosition());
		teachers.setSex(teacher.getSex());
		teachers.setEmail(teacher.getEmail());
		teachers.setIdentificationnum(teacher.getIdentificationnum());
		teachers.setTeachername(teacher.getTeachername());
		teachers.setTelephone(teacher.getTelephone());
		teachers.setDept(teacher.getDept());
		sessionFactory.getCurrentSession().update(teachers);
	}

	public void recoverTeacher(String id){
		try{
			Integer tid = Integer.parseInt(id);
			Teacher teacher = (Teacher)sessionFactory.getCurrentSession().load(Teacher.class, tid);
			//teacher.setClasses(null);
			teacher.setDeleted(0);
			teacher.setPassword("4QrcOUm6Wau+VuBX8g+IPg==");
			sessionFactory.getCurrentSession().update(teacher);
		} catch (Exception e){
			
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void teacherdelete(int stuid) {
		
		Teacher teacher = (Teacher)sessionFactory.getCurrentSession().load(Teacher.class, stuid);
		/*String qString = "from Teacher t where t.id=:stuid";
		Query query = sessionFactory.getCurrentSession().createQuery(qString);
		query.setInteger("stuid", stuid);
		List<Teacher> teachers = (List<Teacher>)query.list();
		if (teachers.size()==0) {
			return ;
		}
		Teacher teacher = teachers.get(0);*/
		if (teacher == null)
			return;	
		String queryString = "from Dept d where d.deptid=:id";
		Query querys = sessionFactory.getCurrentSession().createQuery(queryString);
		querys.setInteger("id", teacher.getDept().getDeptid());
		List<Dept> depts = (List<Dept>)querys.list();
		if (depts==null) {
			if (teacher.getDeleted().equals(0)){
				teacher.setDeleted(1);
				teacher.setPassword("idonotkonw");
				sessionFactory.getCurrentSession().update(teacher);
			}else{
				String querystring = "from SemesterChosenCourse s where s.teacherid=:teacherid";
				Query query1 = sessionFactory.getCurrentSession().createQuery(querystring);
				query1.setString("teacherid", teacher.getIdentificationnum());

				List<SemesterChosenCourse> ret = (List<SemesterChosenCourse>)query1.list();
				
				if(ret == null || ret.isEmpty()){
					sessionFactory.getCurrentSession().delete(teacher);
				}			
			}	
		}else {
			if (depts.get(0).getDeptresponsible().equals(teacher.getTeachername())) {
				return ;
			}else {
				if (teacher.getDeleted().equals(0)){
					teacher.setDeleted(1);
					teacher.setPassword("idonotkonw");
					sessionFactory.getCurrentSession().update(teacher);
				}else{
					String querystring = "from SemesterChosenCourse s where s.teacherid=:teacherid";
					Query query2 = sessionFactory.getCurrentSession().createQuery(querystring);
					query2.setString("teacherid", teacher.getIdentificationnum());
				
					List<SemesterChosenCourse> ret = (List<SemesterChosenCourse>)query2.list();
					
					if(ret == null || ret.isEmpty()){
						sessionFactory.getCurrentSession().delete(teacher);
					}			
				}		
			}
		}		
	}

	public void stuattendenceadd(Attendence attendence) {
		
		sessionFactory.getCurrentSession().save(attendence);
	}
	@SuppressWarnings("unchecked")

	public List<Attendence> loadattendence(Attendence attendence ,String sid) {
		
		String date = attendence.getDate();
		String time = attendence.getTime();
		String queryString ="from Attendence a where a.passport=:stuid and a.date=:date and a.time=:time";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("stuid", sid);
		query.setString("date", date);
		query.setString("time", time);
		List<Attendence> attendences = (List<Attendence>)query.list();
		return attendences;
	}
	@SuppressWarnings("unchecked")

	public List<Attendence> attendencestulist(String i,String semester) {
		
		String queryString = "from Attendence a where a.choosencourseid=:i and a.semester=:semester order by a.id desc ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("i", i);
		query.setString("semester", semester);
		List<Attendence> attendences = (List<Attendence>) query.list();
		return attendences;
	}
	@SuppressWarnings("unchecked")

	public List<Attendence> searchstuattendence(Attendence attendence,String semester) {
		
		Integer courseid = null;
		String date = null;
		String type = null;
		String stuid = null;
		User user = (User) ActionContext.getContext().getSession().get("user");
		stuid = user.getUsernum();
		List<Attendence> attendences = new ArrayList<Attendence>();
		try {
			date = java.net.URLDecoder.decode(attendence.getDate(),"UTF-8");
			type = java.net.URLDecoder.decode(attendence.getType(),"UTF-8");
			courseid = attendence.getChoosencourseid();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		if (date.length()==0) {//日期为空
			if (type.length()==0) {//考勤状态为空
			  String queryString = "from Attendence a where a.passport=:stuid and a.choosencourseid=:courseid and a.semester=:semester ";
			  Query query = sessionFactory.getCurrentSession().createQuery(queryString);
			  query.setInteger("courseid", courseid);
			  query.setString("stuid", stuid);
			  query.setString("semester", semester);
			  attendences = (List<Attendence>)query.list();
			}else {//考勤状态不为空
				if (courseid==null) {
					String queryString = "from Attendence a where a.passport=:stuid  and a.type=:type and a.semester=:semester ";
					Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					//query.setInteger("courseid", courseid);
					query.setString("stuid", stuid);
					query.setString("type", type);
					query.setString("semester", semester);
					attendences = (List<Attendence>)query.list();
				}else {
					String queryString = "from Attendence a where a.passport=:stuid and a.choosencourseid=:courseid and a.type=:type and a.semester=:semester ";
					Query query = sessionFactory.getCurrentSession().createQuery(queryString);
				    query.setInteger("courseid", courseid);
					query.setString("stuid", stuid);
					query.setString("type", type);
					query.setString("semester", semester);
					attendences = (List<Attendence>)query.list();
				}				  
			}
		}else {//日期不为空
			if (type.length()==0) {//考勤状态为空
				if (courseid==null) {
					String queryString = "from Attendence a where a.passport=:stuid and a.date=:date and a.semester=:semester ";
					  Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					  //query.setInteger("courseid", courseid);
					  query.setString("stuid", stuid);
					  query.setString("date", date);
					  query.setString("semester", semester);
					  attendences = (List<Attendence>)query.list();
				}else {
					String queryString = "from Attendence a where a.passport=:stuid and a.choosencourseid=:courseid and a.date=:date and a.semester=:semester ";
					  Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					  query.setInteger("courseid", courseid);
					  query.setString("stuid", stuid);
					  query.setString("date", date);
					  query.setString("semester", semester);
					  attendences = (List<Attendence>)query.list();
				}
				  
			}else {
				if (courseid==null) {
					String queryString = "from Attendence a where a.passport=:stuid  and a.date=:date and a.type=:type and a.semester=:semester ";
					  Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					  //query.setInteger("courseid", courseid);
					  query.setString("stuid", stuid);
					  query.setString("date", date);
					  query.setString("type", type);
					  query.setString("semester", semester);
					  attendences = (List<Attendence>)query.list();
				}else {
					 String queryString = "from Attendence a where a.passport=:stuid and a.choosencourseid=:courseid and a.date=:date and a.type=:type and a.semester=:semester ";
					  Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					  query.setInteger("courseid", courseid);
					  query.setString("stuid", stuid);
					  query.setString("date", date);
					  query.setString("semester", semester);
					  query.setString("type", type);
					  attendences = (List<Attendence>)query.list();
				}				 
			}
		}
		return attendences;
	}

	public void leaveadd(Leave leave) {
		
		sessionFactory.getCurrentSession().save(leave);
	}
	@SuppressWarnings("unchecked")

	public List<Leave> stuleave(int i, int pageSize) {
		
		String queryString = "from Leave l ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setFirstResult(i);
		query.setMaxResults(pageSize);
		List<Leave> stuleave = (List<Leave>) query.list();
		return stuleave;
	}

	public void stuleaveupdate(Leave leave) {
		
		Leave leave1 = (Leave)sessionFactory.getCurrentSession().load(Leave.class, leave.getId());
		leave1.setStatus(leave.getStatus());
		sessionFactory.getCurrentSession().update(leave1);
	}

	public void leaveupdate(Leave leave){
		Leave leave1 = (Leave)sessionFactory.getCurrentSession().load(Leave.class, leave.getId());
		leave1.setApplydate(leave.getApplydate());
		leave1.setBackdate(leave.getBackdate());
		leave1.setLeavereason(leave.getLeavereason());
		leave1.setLeavingdate(leave.getLeavingdate());
		leave1.setStatus(leave.getStatus());
		leave1.setPassport(leave.getPassport());
		leave1.setTelephone(leave.getTelephone());
		leave1.setType(leave.getType());
		sessionFactory.getCurrentSession().update(leave1);
	}
	
	public void leavedelete(Leave leave) {
		
		Leave leave2 = (Leave)sessionFactory.getCurrentSession().load(Leave.class, leave.getId());
		sessionFactory.getCurrentSession().delete(leave2);
	}
	@SuppressWarnings("unchecked")

	public List<Attendence> courseattendencesearch(Integer courseid, String type) {
		
		String querysString ="from Attendence a where a.choosencourseid=:courseid and a.type=:type";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setInteger("courseid", courseid);
		query.setString("type", type);
		List<Attendence> attendences = (List<Attendence>)query.list();
		return attendences;
	}

	public void teacheradd(Teacher teacher, Integer depid) {
		
		Dept dept = (Dept)sessionFactory.getCurrentSession().load(Dept.class, depid);
		teacher.setDept(dept);
		sessionFactory.getCurrentSession().save(teacher);
	}
	@SuppressWarnings("unchecked")

	public List<Teacher> teachercheck(String identificationnum) {
		
		String queryString ="from Teacher t where t.identificationnum=:identificationnum";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("identificationnum", identificationnum);
		List<Teacher> teachers = (List<Teacher>)query.list();
		return teachers;
	}
	@SuppressWarnings("unchecked")

	public Teacher loadteacherbyidentificationnum(String identificationnum) {
		
		String querysString ="from Teacher t where t.identificationnum=:identificationnum";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setString("identificationnum", identificationnum);
		List<Teacher> teachers = (List<Teacher>)query.list();
		if (teachers != null && teachers.size() > 0)
			return teachers.get(0);
		else
			return null;
	}
	@SuppressWarnings("unchecked")

	public List<Teacher> loadteacherbyIdent(String teachernum) {
		
		String querysString ="from Teacher t where t.identificationnum=:identificationnum";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setString("identificationnum", teachernum);
		List<Teacher> teachers = (List<Teacher>)query.list();
		return teachers;
	}

	public void announcementadd(Announcement announcement) {
		
		sessionFactory .getCurrentSession().save(announcement);
	}
	@SuppressWarnings("unchecked")

	public List<Announcement> announcementlist(int i, int pageSize) {
		
		String queryString = "from Announcement a order by a.id desc";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setFirstResult(i);
		query.setMaxResults(pageSize);
		List<Announcement> announcements = (List<Announcement>) query.list();
		return announcements;
	}
	@SuppressWarnings("unchecked")

	public Announcement loadannouncement(Integer id) {
		
		String queryString ="from Announcement a where a.id=:id order by a.id desc";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("id", id);
		List<Announcement> announcements = (List<Announcement>)query.list();
		return announcements.get(0);
	}

	public void announcementupdate(Announcement announcement) {
		
		Announcement announcement2 = (Announcement)sessionFactory.getCurrentSession().load(Announcement.class, announcement.getId());
		announcement2.setTitle(announcement.getTitle());
		announcement2.setContent(announcement.getContent());
		announcement2.setCreatedtime(announcement.getCreatedtime());
		sessionFactory.getCurrentSession().update(announcement2);
	}

	public void announcementdelete(Integer id) {
		
		Announcement announcement = (Announcement)sessionFactory.getCurrentSession().load(Announcement.class, id);
		sessionFactory.getCurrentSession().delete(announcement);
	}

	public void justiceladd(Certify1 certify1) {
		
		sessionFactory.getCurrentSession().save(certify1);
	}
	@SuppressWarnings("unchecked")

	public List<Certify1> loadjusticel() {
		
		String querysString = "from Certify1 c ";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		List<Certify1> justicellist = (List<Certify1>)query.list();
		return justicellist;
	}

	public void justiceldelete(Integer id) {
		
		Certify1 certify1 = (Certify1)sessionFactory.getCurrentSession().load(Certify1.class, id);
		sessionFactory.getCurrentSession().delete(certify1);
	}
	@SuppressWarnings("unchecked")

	public Certify1 loadjusticelbyid(Integer id) {
		
		String queryString ="from Certify1 c where c.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("id", id);
		List<Certify1> certify1s = (List<Certify1>)query.list();
		return certify1s.get(0);
	}

	public void justicelupdate(Certify1 certify) {
		
		Certify1 certify1 = (Certify1)sessionFactory.getCurrentSession().load(Certify1.class, certify.getId());
		certify1.setCreatedtime(certify.getCreatedtime());
		certify1.setFileplace(certify.getFileplace());
		certify1.setTitle(certify.getTitle());
		sessionFactory.getCurrentSession().update(certify1);		
	}
	@SuppressWarnings("unchecked")

	public List<Announcement> loadannouncementlist() {
		
		String querystrString = "from Announcement a order by a.id desc  ";
		Query query = sessionFactory.getCurrentSession().createQuery(querystrString);
		query.setFirstResult(0); 
		query.setMaxResults(10);
		List<Announcement> announcementlist = (List<Announcement>)query.list();
		return announcementlist;
	}
	@SuppressWarnings("unchecked")

	public List<Attendence> personattendence(String semester) {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		String stuid = user.getUsernum();
		String querString = "from Attendence a where a.passport=:stuid and a.semester=:semester ";
		Query query = sessionFactory.getCurrentSession().createQuery(querString);
		query.setString("stuid", stuid);
		query.setString("semester", semester);
		List<Attendence> attendences = (List<Attendence>)query.list();
		return attendences;
	}
	@SuppressWarnings("unchecked")
	public List<Attendence> loadallpersonattendence(String passport){
		String querString = "from Attendence a where a.passport=:passport ";
		Query query = sessionFactory.getCurrentSession().createQuery(querString);
		query.setString("passport", passport);
		List<Attendence> attendences = (List<Attendence>)query.list();
		return attendences;
	}
	public void updateattendence(Attendence a, String passport){
		Attendence attendence = (Attendence)sessionFactory.getCurrentSession().load(Attendence.class, a.getId());
	    attendence.setPassport(passport);
	    sessionFactory.getCurrentSession().update(attendence);
	}
	@SuppressWarnings("unchecked")

	public List<Attendence> loadattendencebycourseid(String id,String semester) {
		
		String querString = "from Attendence a where a.choosencourseid=:id and a.semester=:semester ";
		Query query = sessionFactory.getCurrentSession().createQuery(querString);
		query.setString("id", id);
		query.setString("semester", semester);
		List<Attendence> attendences = (List<Attendence>)query.list();
		return attendences;
	}

	public void changeimg(String imgurl, Teacher teacher2) {
		
		Teacher teacher = (Teacher)sessionFactory.getCurrentSession().load(Teacher.class, teacher2.getId());
		teacher.setImgurl(imgurl);
		sessionFactory.getCurrentSession().update(teacher);
	}
	@SuppressWarnings("unchecked")

	public Leave loadleavebyid(Integer id) {
		
		String querysString = "from Leave l where l.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setInteger("id", id);
		List<Leave> leaves = (List<Leave>)query.list();
		return leaves.get(0);
	}

	public long totalteacher() {
		
		String hql = "select count(*) from Teacher";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		long total = ((Number) query.uniqueResult()).intValue();
		return total;
	}

	public long totalstuleave() {
		
		String hql = "select count(*) from Leave";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		long total = ((Number) query.uniqueResult()).intValue();
		return total;
	}

	public long totalannouncement() {
		
		String hql = "select count(*) from Announcement";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		long total = ((Number) query.uniqueResult()).intValue();
		return total;
	}

	@SuppressWarnings("unchecked")

	public List<SemesterChosenCourse> semestercourselist() {
		String querystring = "from SemesterChosenCourse s  order by s.coursenum asc ";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		//query.setString("semester", semester);
		List<SemesterChosenCourse> semestercourselist = (List<SemesterChosenCourse>)query.list();
		return semestercourselist;
	}
	@SuppressWarnings("unchecked")

	public List<SemesterChosenCourse> SemesterCourselist(String semester) {
		String querystring = "from SemesterChosenCourse s where s.semester=:semester  order by s.coursenum asc ";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semester);
		List<SemesterChosenCourse> semestercourselist = (List<SemesterChosenCourse>)query.list();
		return semestercourselist;
	}


	public void semestercourseadd(SemesterChosenCourse semestercourse) {
		
		sessionFactory.getCurrentSession().save(semestercourse);
	}


	@SuppressWarnings("unchecked")
	public void semestercoursedelete(int courseid) {
		
		SemesterChosenCourse semestercourse = (SemesterChosenCourse)sessionFactory.getCurrentSession().load(SemesterChosenCourse.class, courseid);
		String querystring = "from SemesterChosenCourse s where s.semester=:semester and s.coursenum=:coursenum";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semestercourse.getSemester());
		query.setString("coursenum", semestercourse.getCoursenum());
		List<SemesterChosenCourse> sem = (List<SemesterChosenCourse>)query.list();
		for(SemesterChosenCourse s:sem){
			sessionFactory.getCurrentSession().delete(s);
		}		
	}

	@SuppressWarnings("unchecked")

	public List<SemesterChosenCourse> loadsemestercoursebyid(String courseid,String semester) {
		
		String querystring = "from SemesterChosenCourse s where s.coursenum=:courseid and s.semester=:semester ";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("courseid", String.valueOf(courseid));
		query.setString("semester", semester);
		List<SemesterChosenCourse> semestercourselist = (List<SemesterChosenCourse>)query.list();
		return semestercourselist;
	}

	@SuppressWarnings("unchecked")

	public List<SemesterChosenClassroom> semesterroomlist() {
		
		String querystring = "from SemesterChosenClassroom s ";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		List<SemesterChosenClassroom> semestercourselist = (List<SemesterChosenClassroom>)query.list();
		return semestercourselist;
	}

	@SuppressWarnings("unchecked")

	public List<SemesterChosenClassroom> loadsemesterroombyid(String roomnum, String semester) {
		
		String querystring = "from SemesterChosenClassroom s where s.num=:roomnum and s.semester=:semester ";// 
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("roomnum", roomnum);
		query.setString("semester", semester);
		List<SemesterChosenClassroom> semesterroomlist = (List<SemesterChosenClassroom>)query.list();
		return semesterroomlist;
	}


	public void semesterroomadd(SemesterChosenClassroom semesterroom) {
		
		sessionFactory.getCurrentSession().save(semesterroom);
	}


	public void semesterroomdelete(int roomid) {
		
		SemesterChosenClassroom semestercourse = (SemesterChosenClassroom)sessionFactory.getCurrentSession().load(SemesterChosenClassroom.class, roomid);
		sessionFactory.getCurrentSession().delete(semestercourse);
	}
	
	private void emptyUnarranged (String semester) {
		String querystring = "from SemesterChosenCourse s where s.semester=:semester ";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semester);
		List<SemesterChosenCourse> ret = (List<SemesterChosenCourse>)query.list();
		if (ret == null)
			return;
		for (SemesterChosenCourse i : ret) {
			if (i.getWeekday() == null || i.getSlot() == null || i.getRoomname() == null){
				sessionFactory.getCurrentSession().delete(i);
			}
		}
	}

	public void saveSyllabus(List<ChosenCourseModel> courses, String semester) {
		/*Query q = sessionFactory.getCurrentSession().createQuery("delete SemesterChosenCourse where semester=" + semester);
		q.executeUpdate();*/
		
		for (ChosenCourseModel course : courses){
			if (course.getSemesterId() == null){
				System.out.println("Can not get semesterChosenCoruse ID in ManageDao saveSyllabus()");
				continue;
			}
			SemesterChosenCourse p = loadSemesterChosenCourseById(course.getSemesterId());
			if (p == null)
				continue;
			
			/*SemesterChosenCourse p = new SemesterChosenCourse();*/
			p.setBegainweek(String.valueOf(course.getBeginWeek()));
			String classes = "";
			for (ClassesModel c : course.getClasses())
				classes += String.valueOf(c.getId()) + "&";
			p.setClass_(classes);
			p.setCoursenum(String.valueOf(course.getCourse().getNum()));
			p.setEndweek(String.valueOf(course.getEndWeek()));
			//p.setId(id);
			if(course.getRoom() != null)
				p.setRoomname(String.valueOf(course.getRoom().getNum()));
			p.setRoomtype(course.getRoomType());
			p.setSemester(semester);
			p.setSlot(String.valueOf(course.getSlot()));
			p.setTeacherid(course.getTeacher().getIdentificationnum());
			p.setWeekday(String.valueOf(course.getWeekday()));
			sessionFactory.getCurrentSession().update(p);
		}
		//emptyUnarranged (semester);
	}

	public List<SemesterChosenCourse> getChosenCourseByTeacherId(
			String teacherId, String semester) {
		String querystring = "from SemesterChosenCourse s where s.teacherid=:teacherid and s.semester=:semester ";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("teacherid", teacherId);
		query.setString("semester", semester);
		@SuppressWarnings("unchecked")
		List<SemesterChosenCourse> ret = (List<SemesterChosenCourse>)query.list();
		return ret;
	}

	public List<SemesterChosenCourse> getChosenCourseByClassNum(String classNum, String semester) {
		List<SemesterChosenCourse> ret = new ArrayList<SemesterChosenCourse>();
		for (SemesterChosenCourse course : SemesterCourselist(semester)){
			//String names[] = course.getClass_().split("&").clone();
			if (course.getClass_() == null){
				ret.add(course);
				continue;
			}
			for (String name : course.getClass_().split("&"))
				if (name.equals(classNum)){
					ret.add(course);
					break;
				}
		}
		return ret;
	}

	@Override
	public List<SemesterChosenCourse> getChosenCourseByCourseId(String courseId, String semester) {
		String querystring = "from SemesterChosenCourse s where s.coursenum=:coursenum and s.semester=:semester ";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("coursenum", String.valueOf(courseId));
		query.setString("semester", semester);
		@SuppressWarnings("unchecked")
		List<SemesterChosenCourse> ret = (List<SemesterChosenCourse>)query.list();
		return ret;
	}

	public ClassesModel loadClassByID(String id) {
		String querystring = "from Classes s where s.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("id", id);
		@SuppressWarnings("unchecked")
		List<Classes> ret = (List<Classes>)query.list();
		if (ret.size() == 0)
			return null;
		if (ret.get(0).getStudents() != null) {
			ClassesModel n =  new ClassesModel(ret.get(0).getClassname(),
					ret.get(0).getMajor(), 
					null,
					ret.get(0).getStudents(),
					ret.get(0).getClassminitorid(),
					ret.get(0).getClassteacherid());
			n.setId(Integer.parseInt(id));
			return n;
		} else {
			ClassesModel n =  new ClassesModel(ret.get(0).getClassname(),
					ret.get(0).getMajor(), 
					null,
					new HashSet<Student>(),
					ret.get(0).getClassminitorid(),
					ret.get(0).getClassteacherid());
			n.setId(Integer.parseInt(id));
			return n;
		}
	}

	public Course loadCourseByIdent(String ident) {
		String querystring = "from Course s where s.num=:id and s.deleted!=1 ";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("id", ident);
		@SuppressWarnings("unchecked")
		List<Course> ret = (List<Course>)query.list();
		if (ret != null && ret.size() > 0)
			return ret.get(0);
		return null;
	}
	
	public Course loadCourseByIdent2(String ident) {
		String querystring = "from Course s where s.num=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("id", ident);
		@SuppressWarnings("unchecked")
		List<Course> ret = (List<Course>)query.list();
		if (ret != null && ret.size() > 0)
			return ret.get(0);
		return null;
	}

	@Override
	public void semestercourseteacheradd(SemesterChosenCourse semestercourse) {
		SemesterChosenCourse semesterChosenCourse = (SemesterChosenCourse)sessionFactory.getCurrentSession().load(SemesterChosenCourse.class, semestercourse.getId());
		semesterChosenCourse.setBegainweek(semestercourse.getBegainweek());
		semesterChosenCourse.setEndweek(semestercourse.getEndweek());
		semesterChosenCourse.setTeacherid(semestercourse.getTeacherid());
		semesterChosenCourse.setCredits(semestercourse.getCredits());
		semesterChosenCourse.setLessonCount(semestercourse.getLessonCount());
		semesterChosenCourse.setWeeklesson(semestercourse.getWeeklesson());
		semesterChosenCourse.setRoomtype(semestercourse.getRoomtype());
		semesterChosenCourse.setIsElective(semestercourse.getIsElective());
		sessionFactory.getCurrentSession().update(semesterChosenCourse);
	}

	@Override
	public void semesterteacherendadd(String identificationnum, Integer semestercourseid) {
		SemesterChosenCourse semesterChosenCourse = (SemesterChosenCourse)sessionFactory.getCurrentSession().load(SemesterChosenCourse.class, semestercourseid);
		//semesterChosenCourse.setTeacherid(identificationnum);
		//sessionFactory.getCurrentSession().update(semesterChosenCourse);
		String querystring = "from SemesterChosenCourse s where s.coursenum=:num and s.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("num", semesterChosenCourse.getCoursenum());
		query.setString("semester", semesterChosenCourse.getSemester());
		@SuppressWarnings("unchecked")
		List<SemesterChosenCourse> ret = (List<SemesterChosenCourse>)query.list();
		for (SemesterChosenCourse i : ret) {
			i.setTeacherid(identificationnum);
			sessionFactory.getCurrentSession().update(i);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public Teacher loadteacherbyid(Integer id) {
		String querysString ="from Teacher t where t.identificationnum=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setInteger("id", id);
		List<Teacher> teachers = (List<Teacher>)query.list();
		if (teachers.size() > 0)
			return teachers.get(0);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.tjpu.dao.ManageDao#semestercourseclassset(java.lang.Integer, java.lang.String)
	 */
	@Override
	public void semestercourseclassset(Integer id, String ids) {
		SemesterChosenCourse semesterChosenCourse = (SemesterChosenCourse)sessionFactory.getCurrentSession().load(SemesterChosenCourse.class, id);
		semesterChosenCourse.setClass_(ids);
		sessionFactory.getCurrentSession().update(semesterChosenCourse);
	}

	@Override
	public List<SemesterChosenClassroom> semesterRoomList(String semester) {
		String querystring = "from SemesterChosenClassroom s where s.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semester);
		@SuppressWarnings("unchecked")
		List<SemesterChosenClassroom> semestercourselist = (List<SemesterChosenClassroom>)query.list();
		return semestercourselist;
	}

	@Override
	public List<SemesterChosenCourse> semesterCourseList(String semester) {
		String querystring = "from SemesterChosenCourse s where s.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semester);
		@SuppressWarnings("unchecked")
		List<SemesterChosenCourse> semestercourselist = (List<SemesterChosenCourse>)query.list();
		return semestercourselist;
	}

	public List<ChosenCourse> stuSyllabusList(String id, String semester) {
		String querystring = "from ChosenCourse s where s.passport=:id and s.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semester);
		query.setString("id", id);
		@SuppressWarnings("unchecked")
		List<ChosenCourse> ret = (List<ChosenCourse>)query.list();
		if (ret == null || ret.size() == 0)
			return new ArrayList<ChosenCourse>();
		return ret;
	}

	public List<Adjustcourse> adjustRecord(String semester) {
		String querystring = "from Adjustcourse s where s.semester=:semester";
		//String querystring = "from Adjustcourse s";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semester);
		@SuppressWarnings("unchecked")
		List<Adjustcourse> ret = (List<Adjustcourse>)query.list();
		return ret;
	}

	public void approveAdjust(Integer id) {
		Adjustcourse apply = (Adjustcourse)sessionFactory.getCurrentSession().load(Adjustcourse.class, id);
		apply.setStatus("1");
		sessionFactory.getCurrentSession().update(apply);	
	}

	public void disapproveAdjust(Integer id) {
		Adjustcourse apply = (Adjustcourse)sessionFactory.getCurrentSession().load(Adjustcourse.class, id);
		apply.setStatus("2");
		sessionFactory.getCurrentSession().update(apply);	
	}

	public Classes getClassByStuID(String stuid) {
		String querystring = "from Student s left join fetch s.classes c where s.passport=:stuid";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("stuid", stuid);
		@SuppressWarnings("unchecked")
		List<Student> ret = (List<Student>)query.list();
		if (ret.size() > 0) {
			return ret.get(0).getClasses();
		}	
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterChosenCourse> electiveCourseList(String semester) {
		String querystring = "from SemesterChosenCourse s where s.semester=:semester and s.isElective=2";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semester);
		return (List<SemesterChosenCourse>)query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChosenCourse> getChosenCourseListByStuID(String stuid, String semester) {
		String querystring = "from ChosenCourse s where s.passport=:id and s.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semester);
		query.setString("id", stuid);
		List<ChosenCourse> ret = (List<ChosenCourse>)query.list();
		if (ret == null || ret.size() == 0)
			return new ArrayList<ChosenCourse>();
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterChosenCourse> semesterselectcourselist() {
		int iselective = 2;//任选课
		String querystring = "from SemesterChosenCourse s where s.isElective=:iselective";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setInteger("iselective", iselective);
		List<SemesterChosenCourse> semestercourselist = (List<SemesterChosenCourse>)query.list();
		return semestercourselist;
	}
	@Override
	public void semesterselectcourseupdate(SemesterChosenCourse semestercourse) {
		SemesterChosenCourse semesterChosenCourse = (SemesterChosenCourse)sessionFactory.getCurrentSession().load(SemesterChosenCourse.class, semestercourse.getId());
	    semesterChosenCourse.setStuNum(semestercourse.getStuNum());
	    sessionFactory.getCurrentSession().update(semesterChosenCourse);
	}

	public void selectCourse(ChosenCourse course) {
		sessionFactory.getCurrentSession().save(course);
	}
		
	public void diselectCourse(ChosenCourse course) {
		sessionFactory.getCurrentSession().delete(course);
	}


	@SuppressWarnings("unchecked")
	@Override
	public SemesterChosenCourse loadsemesterselectcoursebycourseid(Integer num) {
		// TODO Auto-generated method stub
		String querysString = "from SemesterChosenCourse s where s.coursenum=:num ";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setInteger("num", num);
		//query.setString("semester", semester);//and s.semester=:semester 
		List<SemesterChosenCourse> semesterChosenCourses = (List<SemesterChosenCourse>)query.list();
		if (semesterChosenCourses.size()==0) {
			return null;
		}else {
			return semesterChosenCourses.get(0);
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public SemesterChosenCourse loadselectcoursebycourseid(String num,String semester) {
		// TODO Auto-generated method stub
		String querysString = "from SemesterChosenCourse s where s.coursenum=:num and s.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setString("num", num);
		query.setString("semester", semester);//and s.semester=:semester 
		List<SemesterChosenCourse> semesterChosenCourses = (List<SemesterChosenCourse>)query.list();
		if (semesterChosenCourses.size()==0) {
			return null;
		}else {
			return semesterChosenCourses.get(0);
		}
		
	}


	@Override
	public List<SemesterChosenCourse> getChosenCourseByClassNumAndCourseID(String classNum, String courseid, String semester) {
		List<SemesterChosenCourse> ret = new ArrayList<SemesterChosenCourse>();
		List<SemesterChosenCourse> all = getChosenCourseByClassNum(classNum, semester);
		for (SemesterChosenCourse c : all)
			if (c.getCoursenum().equals(courseid))
				ret.add(c); 
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public List<ChosenCourse> loadChosenCourseByStuId(String id) {
		String querysString = "from ChosenCourse s where s.passport=:id ";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setString("id", id);
		List<ChosenCourse> chosenCourses = (List<ChosenCourse>)query.list();
		return chosenCourses;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChosenCourse> loadchosencoursebycourseid(String num) {
		// TODO Auto-generated method stub
		String querysString = "from ChosenCourse s where s.courseId=:num ";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setString("num", num);
		List<ChosenCourse> chosenCourses = (List<ChosenCourse>)query.list();
		return chosenCourses;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterChosenCourse> loadattendencecourse(String usernum,String semester) {
		// TODO Auto-generated method stub
		String querystring = "from SemesterChosenCourse s where s.teacherid=:usernum and s.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("usernum", usernum);
		query.setString("semester", semester);
		List<SemesterChosenCourse> semestercourse = (List<SemesterChosenCourse>)query.list();
		return semestercourse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChosenCourse> loadstuscore(String semester, String stuid) {
		// TODO Auto-generated method stub
		List<ChosenCourse> chosenCourses = new ArrayList<ChosenCourse>();
		if (semester.length()==0) {
			String queryString = "from ChosenCourse c where c.passport=:stuid";
		    Query query = sessionFactory.getCurrentSession().createQuery(queryString);
			query.setString("stuid", stuid);
			chosenCourses = (List<ChosenCourse>)query.list();
		}else {
			if (stuid.length()==0) {
				String queryString = "from ChosenCourse c where c.semester=:semester";
			    Query query = sessionFactory.getCurrentSession().createQuery(queryString);
				query.setString("semester", semester);
				chosenCourses = (List<ChosenCourse>)query.list();
			}else {
				String queryString = "from ChosenCourse c where c.semester=:semester and c.passport=:stuid ";
			    Query query = sessionFactory.getCurrentSession().createQuery(queryString);
				query.setString("semester", semester);
				query.setString("stuid", stuid);
				chosenCourses = (List<ChosenCourse>)query.list();
			}
		}
		return chosenCourses;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChosenCourse> loadstuscorelist(String semester) {
		// TODO Auto-generated method stub
		
		String querystring = "from ChosenCourse c where c.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semester);
		List<ChosenCourse> chosenCourses = (List<ChosenCourse>)query.list();
		return chosenCourses;
	}

	@Override
	public void courseclassscoreadd(ChosenCourse chosenCourse) {
		// TODO Auto-generated method stub
		ChosenCourse chosenCourse2 = (ChosenCourse)sessionFactory.getCurrentSession().load(ChosenCourse.class, chosenCourse.getId());
	    chosenCourse2.setAttendence(chosenCourse.getAttendence());
	    chosenCourse2.setHomework(chosenCourse.getHomework());
	    chosenCourse2.setMidexam(chosenCourse.getMidexam());
	    chosenCourse2.setFinalexam(chosenCourse.getFinalexam());
	    if(chosenCourse.getIsmakeup()==1){
	    	chosenCourse2.setMakeup(chosenCourse.getMakeup());	
	    	//chosenCourse2.setSummary(Float.parseFloat("60"));
	    }	    
	    chosenCourse2.setIsmakeup(chosenCourse.getIsmakeup());
	    chosenCourse2.setSummary(chosenCourse.getSummary());
	    sessionFactory.getCurrentSession().update(chosenCourse2);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ChosenCourse loadchosencoursebycourse(String courseId, String stuid,String semester) {
		// TODO Auto-generated method stub
		String querysString = "from ChosenCourse c where c.courseId=:courseId and c.passport=:stuId and c.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setString("courseId", courseId);
		query.setString("stuId", stuid);
		query.setString("semester", semester);
		List<ChosenCourse> chosenCourses = (List<ChosenCourse>)query.list();
		return chosenCourses.get(0);
	}

	@Override
	public SemesterChosenCourse loadSemesterChosenCourseById(String id) {
		String querystring = "from SemesterChosenCourse s where s.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("id", id);
		@SuppressWarnings("unchecked")
		List<SemesterChosenCourse> chosenCourses = (List<SemesterChosenCourse>)query.list();
		if (chosenCourses.size() > 0)
			return chosenCourses.get(0);
		return null;
	}

	@Override
	public void saveAdjust(Adjustcourse aj) {
		sessionFactory.getCurrentSession().save(aj);
	}

	public Course getCourseByNum2(String num) {
		String querystring = "from Course s where s.num=:num";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("num", num);
		@SuppressWarnings("unchecked")
		List<Course> chosenCourses = (List<Course>)query.list();
		if (chosenCourses.size() > 0)
			return chosenCourses.get(0);
		return null;
	}
	
	
	public Course getCourseByNum(String num) {
		String querystring = "from Course s where s.num=:num and s.deleted!=1 ";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("num", num);
		@SuppressWarnings("unchecked")
		List<Course> chosenCourses = (List<Course>)query.list();
		if (chosenCourses.size() > 0)
			return chosenCourses.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChosenCourse> courseclassscoureload(String semester, String num, String stuid) {
		// TODO Auto-generated method stub
		String queryString = "from ChosenCourse c where c.semester=:semester and c.courseId=:num and c.passport=:stuid";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("semester", semester);
		query.setString("num", num);
		query.setString("stuid", stuid);
		List<ChosenCourse> chosenCourses = (List<ChosenCourse>)query.list();
		return chosenCourses;
	}

	/* (non-Javadoc)
	 * @see com.tjpu.dao.ManageDao#loadsinglestuscore(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ChosenCourse> loadsinglestuscore(String usernum) {
		// TODO Auto-generated method stub
		String queryString = "from ChosenCourse c where  c.passport=:usernum  ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("usernum", usernum);
		//query.setString("semester", semester);
		List<ChosenCourse> chosenCourses = (List<ChosenCourse>)query.list();
		if (chosenCourses.size()==0) {
			return null;
		}
		return chosenCourses;
	}

	@Override
	public List<Adjustcourse> loadAjustCourseByRelateCourseNum(String coureNum,
			String semester) {
		String queryString = "from Adjustcourse c where  c.oldcoursenum=:num or c.newcoursenum=:num and c.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("num", coureNum);
		query.setString("num", coureNum);
		query.setString("semester", semester);
		@SuppressWarnings("unchecked")
		List<Adjustcourse> ret = (List<Adjustcourse>)query.list();
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Leave> loadleavebystuid(String stuid) {
		// TODO Auto-generated method stub
		String queryString ="from Leave l where l.passport=:stuid order by l.type asc ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("stuid", stuid);
		List<Leave> leaves = (List<Leave>)query.list();
		return leaves;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateAssisTeacher(String classid, String assisid) {
		//Classes c = (Classes)sessionFactory.getCurrentSession().load(Classes.class, classid);
		String queryString = "from Classes c where c.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("id", classid);
		List<Classes> ret = (List<Classes>)query.list();
		if (ret == null || ret.size() == 0)
			return;
		Classes c = ret.get(0);
		c.setAssisTeacherId(assisid);
		
		sessionFactory.getCurrentSession().update(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateClassTeacher(String classid, String ident) {
		String queryString = "from Classes c where c.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("id", classid);
		List<Classes> ret = (List<Classes>)query.list();
		if (ret == null || ret.size() == 0)
			return;
		Classes c = ret.get(0);
		c.setClassteacherid(Integer.parseInt(ident));
		sessionFactory.getCurrentSession().update(c);
	}

	@Override
	public void sireSemesterChosenCourse(String semester) {
		//找到当前学期所有课
		List<SemesterChosenCourse> all = semesterCourseList(semester);
		Set<String> names = new HashSet<String>();
		boolean sired = false;
		// 检查是否增长过
		for (SemesterChosenCourse i : all){
			if (names.contains(i.getCoursenum() +  i.getTeacherid())){
				sired = true;
				break;
			}
			names.add(i.getCoursenum() + i.getTeacherid());
		}
		//  增长过则退出
		if (sired)
			return;
		
		// 按周课时增长
		for (SemesterChosenCourse i : all){
			if(i.getWeeklesson() != null) {
				for (int j = 0; j < i.getWeeklesson() - 1; ++j){
					SemesterChosenCourse n = new SemesterChosenCourse();
					if (i.getBegainweek() != null)
						n.setBegainweek(i.getBegainweek());
					
					if (i.getClass_() != null)
						n.setClass_(i.getClass_());
					
					if (i.getCoursenum() != null)
						n.setCoursenum(i.getCoursenum());
					
					if (i.getCredits() != null)
						n.setCredits(i.getCredits());
					
					if (i.getEndweek() != null)
						n.setEndweek(i.getEndweek());
					
					if (i.getIsElective() != null)
						n.setIsElective(i.getIsElective());
					
					if (i.getIsOddWeek() != null)
						n.setIsOddWeek(i.getIsOddWeek());
					
					if (i.getLessonCount() != null)
						n.setLessonCount(i.getLessonCount());
					
					if (i.getRoomname() != null)
						n.setRoomname(i.getRoomname());
					
					if (i.getRoomtype() != null)
						n.setRoomtype(i.getRoomtype());
					
					if (i.getSemester() != null)
						n.setSemester(i.getSemester());
					
					if (i.getSlot() != null)
						n.setSlot(i.getSlot());
					
					if (i.getStuNum() != null)
						n.setStuNum(i.getStuNum());
					
					if (i.getTeacherid() != null)
						n.setTeacherid(i.getTeacherid());
					
					if (i.getWeekday() != null)
						n.setWeekday(i.getWeekday());
					
					if (i.getWeeklesson() != null)
						n.setWeeklesson(i.getWeeklesson());
					
					sessionFactory.getCurrentSession().save(n);
					
				}
			}
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChosenCourse> loadselectcoursestu(String num, String semester) {
		// TODO Auto-generated method stub
		String queryString = "from ChosenCourse c where c.courseId=:num and c.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("num", num);
		query.setString("semester", semester);
		List<ChosenCourse> chosenCourses = (List<ChosenCourse>)query.list();
		return chosenCourses;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> classroomList() {
		String queryString = "from Classroom c";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<Classroom> ret = (List<Classroom>)query.list();
		if (ret != null)
			return ret;
		return new ArrayList<Classroom>();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<SemesterChosenCourse> courseListByWeekday(String weekday, String semester) {
		String querystring = "from SemesterChosenCourse s where s.weekday=:day and s.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("day", weekday);
		query.setString("semester", semester);
		List<SemesterChosenCourse> semestercourselist = (List<SemesterChosenCourse>)query.list();
		if (semestercourselist != null)
			return semestercourselist;
		return new ArrayList<SemesterChosenCourse>();
	}
	
	
	public List<Adjustcourse> AppyingAdjustByWeekday(String weekday, String semester) {
		String querystring = "from Adjustcourse s where s.semester=:semester and status=0";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semester);
		List<Adjustcourse> ret1 = (List<Adjustcourse>)query.list();
		if (ret1 == null)
			return new ArrayList<Adjustcourse>();
		List<Adjustcourse> ret2 = new ArrayList<Adjustcourse>();
		for (Adjustcourse i : ret1) {
			if (weekday.equals(String.valueOf(getDayofweek(i.getNewdate())))) {
				ret2.add(i);
			}
		}
		return ret2;
	}
	
	@SuppressWarnings("unchecked")
	public List<Adjustcourse> approvedAdjustApplyListByWeekday (String weekday, String semester) {
		String querystring = "from Adjustcourse s where s.semester=:semester and status=1";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semester);
		List<Adjustcourse> ret1 = (List<Adjustcourse>)query.list();
		if (ret1 == null)
			return new ArrayList<Adjustcourse>();
		List<Adjustcourse> ret2 = new ArrayList<Adjustcourse>();
		for (Adjustcourse i : ret1) {
			if (weekday.equals(String.valueOf(getDayofweek(i.getNewdate())))) {
				ret2.add(i);
			}
		}
		return ret2;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> courseFuzzySearch(String text) {
		String querystring = "from Course s where s.deleted!=1 and  s.num like :t1 or s.coursename like :t2 or s.academic like :t3 or s.teacher like :t4 order by s.num";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("t1", "%" + text + "%");
		query.setString("t2", "%" + text + "%");
		query.setString("t3", "%" + text + "%");
		query.setString("t4", "%" + text + "%");
		List<Course> ret = (List<Course>)query.list();
		if (ret != null)
			return ret;
		return new ArrayList<Course>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classroom> roomListByCapAndPlace(String cap, String place, String type, int i, int pageSize) {
		String querystring = "from Classroom s where s.roomcapacity=:cap and s.roomplace=:place and s.roomtype=:type";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("cap", cap);
		query.setString("place", place);
		query.setString("type", type);
		query.setFirstResult(i);
		query.setMaxResults(pageSize);
		List<Classroom> ret = (List<Classroom>)query.list();
		if (ret != null)
			return ret;
		return new ArrayList<Classroom>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer sizeOfroomListByCapAndPlace(String cap, String place, String type) {
		String querystring = "from Classroom s where s.roomcapacity=:cap and s.roomplace=:place and s.roomtype=:type";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("cap", cap);
		query.setString("place", place);
		query.setString("type", type);
		List<Classroom> ret = (List<Classroom>)query.list();
		if (ret != null)
			return 0;
		return ret.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ChosenCourse> searchstuscore(String semester, String stuid, String coursenum) {
		// TODO Auto-generated method stub
		List<ChosenCourse> chosenCourses = new ArrayList<ChosenCourse>();
		if (semester.length()==0) {
			if (coursenum.length()==0||coursenum.equals("null")) {
				String queryString = "from ChosenCourse c where c.passport=:stuid";
			    Query query = sessionFactory.getCurrentSession().createQuery(queryString);
				query.setString("stuid", stuid);
				chosenCourses = (List<ChosenCourse>)query.list();
			}else {
				if (stuid.length()==0) {
					String queryString = "from ChosenCourse c where  c.courseId=:coursenum";
				    Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					//query.setString("stuid", stuid);
					query.setString("coursenum", coursenum);
					chosenCourses = (List<ChosenCourse>)query.list();
				}else {
					String queryString = "from ChosenCourse c where c.passport=:stuid and c.courseId=:coursenum";
				    Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					query.setString("stuid", stuid);
					query.setString("coursenum", coursenum);
					chosenCourses = (List<ChosenCourse>)query.list();
				}
				
			}
			
		}else {
			if (stuid.length()==0||stuid.equals("null")) {
				if (coursenum.equals("null")||coursenum.length()==0) {
					String queryString = "from ChosenCourse c where c.semester=:semester";
				    Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					query.setString("semester", semester);
					chosenCourses = (List<ChosenCourse>)query.list();
				}else {
					String queryString = "from ChosenCourse c where c.semester=:semester and c.courseId=:coursenum ";
				    Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					query.setString("semester", semester);
					query.setString("coursenum", coursenum);
					chosenCourses = (List<ChosenCourse>)query.list();
				}
				
			}else {
				if (coursenum.length()==0) {
					String queryString = "from ChosenCourse c where c.semester=:semester and c.passport=:stuid ";
				    Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					query.setString("semester", semester);
					query.setString("stuid", stuid);
					chosenCourses = (List<ChosenCourse>)query.list();
				}else {
					String queryString = "from ChosenCourse c where c.semester=:semester and c.passport=:stuid and courseId=:coursenum";
				    Query query = sessionFactory.getCurrentSession().createQuery(queryString);
					query.setString("semester", semester);
					query.setString("stuid", stuid);
					query.setString("coursenum", coursenum);
					chosenCourses = (List<ChosenCourse>)query.list();
				}
				
			}
		}
		return chosenCourses;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evalution> loadevalutionjudge(String num, String usernum, String semester,String flag) {
		// TODO Auto-generated method stub
		if (flag.equals("0")) {
			String querysString = "from Evalution e where e.courseid=:num and e.passport=:usernum and e.semester=:semester and e.flag=:flag";
			Query query = sessionFactory.getCurrentSession().createQuery(querysString);
			query.setString("num", num);
			query.setString("usernum", usernum);
			query.setString("semester", semester);
			query.setString("flag", flag);
			List<Evalution> evalutions = (List<Evalution>)query.list();
			return evalutions;
		}else {
			String querysString = "from Evalution e where e.teacher=:num and e.passport=:usernum and e.semester=:semester and e.flag=:flag";
			Query query = sessionFactory.getCurrentSession().createQuery(querysString);
			query.setString("num", num);
			query.setString("usernum", usernum);
			query.setString("semester", semester);
			query.setString("flag", flag);
			List<Evalution> evalutions = (List<Evalution>)query.list();
			return evalutions;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterChosenCourse> loadsemestercoursebyclass(Integer id,String semester) {
		// TODO Auto-generated method stub
		String queryString = "from SemesterChosenCourse s where s.class_ like:id and s.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("id", "%" + id + "%");
		query.setString("semester", semester);
		List<SemesterChosenCourse> sem = (List<SemesterChosenCourse>)query.list();
		return sem;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterChosenCourse> loadsemestercoursebycoursenum(String selectiveCourseNum, String semester) {
		// TODO Auto-generated method stub
		String querystring = "from SemesterChosenCourse s where s.semester=:semester and s.coursenum=:coursenum ";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semester);
		query.setString("coursenum", selectiveCourseNum);
		List<SemesterChosenCourse> sem = (List<SemesterChosenCourse>)query.list();
		return sem;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterChosenCourse> loadsemestercoursebycourseid(String selectiveCourseNum, String semester) {
		// TODO Auto-generated method stub
		String querystring = "from SemesterChosenCourse s where s.semester=:semester and s.coursenum=:coursenum ";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("semester", semester);
		query.setString("coursenum", selectiveCourseNum);
		List<SemesterChosenCourse> sem = (List<SemesterChosenCourse>)query.list();
		return sem;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterChosenCourse> loadallsemestercourse() {
		// TODO Auto-generated method stub
		String querysString ="from SemesterChosenCourse s";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		List<SemesterChosenCourse> semestercourse = (List<SemesterChosenCourse>)query.list();
		return semestercourse;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterChosenCourse> loadsemestercourse(String semester) {
		// TODO Auto-generated method stub
		String querysString = "from SemesterChosenCourse s where s.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setString("semester", semester);
		List<SemesterChosenCourse> sem = (List<SemesterChosenCourse>)query.list();
		return sem;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterChosenCourse> loadsemestercourse1(String semester) {
		// TODO Auto-generated method stub
		String querysString = "from SemesterChosenCourse s where s.semester=:semester and s.isElective!=2";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setString("semester", semester);
		List<SemesterChosenCourse> sem = (List<SemesterChosenCourse>)query.list();
		return sem;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ChosenCourse loadchosencourse(String stuid, String semester, String num) {
		// TODO Auto-generated method stub
		String querysString = "from ChosenCourse s where s.semester=:semester and s.passport=:stuid and s.courseId=:coursenum ";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setString("semester", semester);
		query.setString("stuid", stuid);
		query.setString("coursenum", num);
		List<ChosenCourse> sem = (List<ChosenCourse>)query.list();
		if (sem.size()==0) {
			return null;
		}else{
			return sem.get(0);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterChosenCourse> loadsemestercoursebyteacherid(String usernum) {
		// TODO Auto-generated method stub
		String querystring = "from SemesterChosenCourse s where s.teacherid=:usernum";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("usernum", usernum);
		List<SemesterChosenCourse> sem = (List<SemesterChosenCourse>)query.list();
		return sem;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Certify1 loadcertifybyid(Integer id) {
		// TODO Auto-generated method stub
		String querystring = "from Certify1 s where s.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setInteger("id", id);
		List<Certify1> sem = (List<Certify1>)query.list();
		if (sem ==null) {
			return null;
		}
		return sem.get(0);
	}

	@Override
	public Integer StudentNumber(Integer classid) {
		String hql = "select count(*) from Student s where s.class_id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		long total = ((Number) query.uniqueResult()).intValue();
		return new Long(total).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public SemesterChosenCourse loadsemestercoursebycourseid(Integer id) {
		// TODO Auto-generated method stub
		String queryString ="from SemesterChosenCourse s where s.id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setInteger("id", id);
		List<SemesterChosenCourse> sem = (List<SemesterChosenCourse>)query.list();
		if (sem.size()==0) {
			return null;
		}
		return sem.get(0);
	}

	/* (non-Javadoc)
	 * @see com.tjpu.dao.ManageDao#loadsemestercoursebynum(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterChosenCourse> loadsemestercoursebynum(String coursenum) {
		// TODO Auto-generated method stub
		String queryString = "from SemesterChosenCourse s where s.coursenum=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("id", coursenum);
		List<SemesterChosenCourse> seme = (List<SemesterChosenCourse>)query.list();
		return seme;
	}

	@Override
	public Integer getSerial(User user, String filename, String filetype) {
		FileRecord fr = new FileRecord();
		Calendar cal = Calendar.getInstance();
		/*fr.setDate(String.format("%d-%d-%d", cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH)));*/
		SimpleDateFormat fmt=new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		fr.setDate(fmt.format(new Date()));
		fr.setFileName(filename);
		fr.setFileType(filetype);
		fr.setOperaterName(user.getRealname());
		fr.setOperaterNum(user.getUsernum());
		Integer rank = user.getRoles().getRolerank();
		fr.setOperaterType(new String[] {"超级管理员", "管理员", "班主任", "学生", "任课教师"}[rank]);
		fr.setYear(String.valueOf(cal.get(Calendar.YEAR)));
		sessionFactory.getCurrentSession().save(fr);
		
		String hql = "select count(*) from FileRecord s where s.year=:year and s.fileType=:filetype";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger("year", cal.get(Calendar.YEAR));
		query.setString("filetype", filetype);
		return ((Number) query.uniqueResult()).intValue();
	}

	@Override
	public void modifyLog(User user, String name, String type) {
		FileRecord fr = new FileRecord();
		Calendar cal = Calendar.getInstance();
		/*fr.setDate(String.format("%d-%d-%d", cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH)));*/
		SimpleDateFormat fmt=new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		fr.setDate(fmt.format(new Date()));
		fr.setFileName(name);
		fr.setFileType(type);
		fr.setOperaterName(user.getRealname());
		fr.setOperaterNum(user.getUsernum());
		Integer rank = user.getRoles().getRolerank();
		fr.setOperaterType(new String[] {"超级管理员", "管理员", "班主任", "学生", "任课教师"}[rank]);
		fr.setYear(String.valueOf(cal.get(Calendar.YEAR)));
		sessionFactory.getCurrentSession().save(fr);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> teacherFuzzySearch(String fuzzyText) {
		// TODO Auto-generated method stub
		String queryString = "from Teacher t left join fetch t.dept d where t.identificationnum like:id or t.sex like:sex or t.teachername like:teachername or t.position like:position or d.deptname like:deptname  ";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("id", "%" + fuzzyText + "%");//  
		query.setString("teachername", "%" + fuzzyText + "%");//
		query.setString("sex", "%" + fuzzyText + "%");
		query.setString("position", "%" + fuzzyText + "%");
		query.setString("deptname", "%" + fuzzyText + "%");
		List<Teacher> sem = (List<Teacher>)query.list();
		return sem;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attendence> loadallattendence(String semester) {
		// TODO Auto-generated method stub
		String queryString ="from Attendence a where a.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setString("semester", semester);
		List<Attendence> attendences = (List<Attendence>)query.list();
		if (attendences==null) {
			return null;
		}
		return attendences;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attendence> searchallattendence(String coursenum, String stuid, String semester) {
		// TODO Auto-generated method stub
		List<Attendence> attendences = new ArrayList<Attendence>();
		if (coursenum ==null||coursenum.equals("")) {
			if (stuid==null||stuid.equals("")||stuid.equals("null")) {
				String querystring = "from Attendence a where a.semester=:semester";
				Query query = sessionFactory.getCurrentSession().createQuery(querystring);
				query.setString("semester", semester);
				attendences = (List<Attendence>)query.list();
			}else {
				String querystring = "from Attendence a where a.semester=:semester and a.passport=:stuid";
				Query query = sessionFactory.getCurrentSession().createQuery(querystring);
				query.setString("semester", semester);
				query.setString("stuid", stuid);
				attendences = (List<Attendence>)query.list();
			}
			
	    }else {
			if (stuid==null||stuid.equals("")||stuid.equals("null")) {
				String querystring = "from Attendence a where a.semester=:semester and a.choosencourseid=:coursenum";
				Query query = sessionFactory.getCurrentSession().createQuery(querystring);
				query.setString("semester", semester);
				query.setString("coursenum", coursenum);
				attendences = (List<Attendence>)query.list();
			}else {
				String querystring = "from Attendence a where a.semester=:semester and a.choosencourseid=:coursenum and a.passport=:stuid";
				Query query = sessionFactory.getCurrentSession().createQuery(querystring);
				query.setString("semester", semester);
				query.setString("coursenum", coursenum);
				query.setString("stuid", stuid);
				attendences = (List<Attendence>)query.list();
			}
		}
		return attendences;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> loadteacherlikenum(String semester) {
		// TODO Auto-generated method stub
		String querystring = "from Teacher s where s.identificationnum like :t1 ";
		Query query = sessionFactory.getCurrentSession().createQuery(querystring);
		query.setString("t1", semester + "%");		
		List<Teacher> ret = (List<Teacher>)query.list();
		return ret;
	}

	@Override
	public void updateChosenCourse(ChosenCourse c, String passport) {
		// TODO Auto-generated method stub
		ChosenCourse chosenCourse = (ChosenCourse)sessionFactory.getCurrentSession().load(ChosenCourse.class, c.getId());
	    chosenCourse.setPassport(passport);
	    sessionFactory.getCurrentSession().update(chosenCourse);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evalution> loadstuevalution(String passport) {
		// TODO Auto-generated method stub
		String querysString = "from Evalution e where e.passport=:passport";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setString("passport", passport);
		List<Evalution> evalutions = (List<Evalution>)query.list();
		return evalutions;
	}

	@Override
	public void updateEvalution(Evalution e, String passport) {
		// TODO Auto-generated method stub
		Evalution evalution = (Evalution)sessionFactory.getCurrentSession().load(Evalution.class, e.getId());
		evalution.setPassport(passport);
	    sessionFactory.getCurrentSession().update(evalution);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Performance> loadstuperformance(String passport) {
		// TODO Auto-generated method stub
		String querysString = "from Performance e where e.passport=:passport";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setString("passport", passport);
		List<Performance> performances = (List<Performance>)query.list();
		return performances;
	}

	@Override
	public void updatePerformance(Performance p, String passport) {
		// TODO Auto-generated method stub
		Performance performance = (Performance)sessionFactory.getCurrentSession().load(Performance.class, p.getId());
		performance.setPassport(passport);
	    sessionFactory.getCurrentSession().update(performance);
	}

	@Override
	public void updateLeave(Leave l, String passport) {
		// TODO Auto-generated method stub
		Leave leave = (Leave)sessionFactory.getCurrentSession().load(Leave.class, l.getId());
		leave.setPassport(passport);
	    sessionFactory.getCurrentSession().update(leave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evalution> loadclassteacherevalution(String teacher,String semester) {
		// TODO Auto-generated method stub
		String querysString = "from Evalution e where e.teacher=:teacher and e.flag=1 and e.semester=:semester";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setString("teacher", teacher);
		query.setString("semester", semester);
		List<Evalution> evalutions = (List<Evalution>)query.list();
		return evalutions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Announcement> queryForPage(int offset, int length) {
		// TODO Auto-generated method stub
		String querysString = "from Announcement a order by a.id desc ";
		Query query = sessionFactory.getCurrentSession().createQuery(querysString);
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List<Announcement> list = (List<Announcement>)query.list();
		return list;
	}
}
