package com.tjpu.dao;

import java.util.List;

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
import com.tjpu.bean.Evalution;
import com.tjpu.bean.Leave;
import com.tjpu.bean.Performance;
import com.tjpu.bean.SemesterChosenClassroom;
import com.tjpu.bean.SemesterChosenCourse;
import com.tjpu.bean.Teacher;
import com.tjpu.bean.User;

public interface ManageDao {
	
	public void modifyLog (User user, String name, String type);
	
	public Integer getSerial (User user, String filename, String filetype);
	
	public Integer StudentNumber(Integer classid);
	
	public void recoverTeacher(String id);
	
	public List<Classroom> roomListByCapAndPlace(String cap, String place, String type, int i, int pageSize);
	
	public Integer sizeOfroomListByCapAndPlace(String cap, String place, String type);
	
	public List<Course> courseFuzzySearch (String text);
	
	public List<Adjustcourse> approvedAdjustApplyListByWeekday (String weekday, String semester);
	
	public List<Adjustcourse> AppyingAdjustByWeekday(String weekday, String semester);
	
	public List<SemesterChosenCourse> courseListByWeekday(String weekday, String semester);
	
	public List<Classroom> classroomList ();
	
	public void sireSemesterChosenCourse (String semester);
	
	public void updateClassTeacher (String classid, String ident);
	
	public void updateAssisTeacher(String classid, String assisid);
	
	public List<Adjustcourse> loadAjustCourseByRelateCourseNum(String coureNum, String semester);
	
	public Course getCourseByNum2 (String num);
	
	public Course getCourseByNum (String num);
	
	public SemesterChosenCourse loadSemesterChosenCourseById (String id);
	
	public List<SemesterChosenCourse> getChosenCourseByClassNumAndCourseID (String classNum, String courseid, String semester);

	public void selectCourse (ChosenCourse course);
	
	public void diselectCourse (ChosenCourse course);
	
	public List<ChosenCourse> getChosenCourseListByStuID(String stuid, String semester);
	
	public List<SemesterChosenCourse> electiveCourseList (String semester);
	
	public Classes getClassByStuID (String stuid);
	
	public void approveAdjust (Integer id);
	
	public void disapproveAdjust (Integer id);
	
	public void saveAdjust (Adjustcourse aj);
	
	public List<Adjustcourse> adjustRecord (String semester);
	
	public List<ChosenCourse> stuSyllabusList (String id, String semester);
	
	public List<SemesterChosenClassroom> semesterRoomList (String semester);
	
	public List<SemesterChosenCourse> semesterCourseList (String semester);
	
	public ClassesModel loadClassByID (String id);
	
	public Course loadCourseByIdent (String ident);
	
	public Course loadCourseByIdent2 (String ident);
	
	public List<SemesterChosenCourse> getChosenCourseByTeacherId (String teacherId, String semester);
	
	public List<SemesterChosenCourse> getChosenCourseByClassNum (String classNum, String semester);
	
	public List<SemesterChosenCourse> getChosenCourseByCourseId (String courseId, String semester);

	public void saveSyllabus (List<ChosenCourseModel> courses, String semester);
	
	public void evalutionteacheradd(Evalution evalution);

	public List<Evalution> loadevalution(String num, String semester);

	public List<Teacher> loadteacher();

	public void teacherupdate(Teacher teacher);

	public void teacherdelete(int stuid);

	public void stuattendenceadd(Attendence attendence);

	public List<Attendence> loadattendence(Attendence attendence, String sid);

	public List<Attendence> attendencestulist(String id, String semester);

	public List<Attendence> searchstuattendence(Attendence attendence, String semester);

	public void leaveadd(Leave leave);

	public List<Leave> stuleave(int i, int pageSize);

	public void stuleaveupdate(Leave leave);

	public void leavedelete(Leave leave);

	public List<Attendence> courseattendencesearch(Integer courseid, String type);

	public List<Teacher> loginDao(String usernum, String password);

	public void teacheradd(Teacher teacher, Integer depid);

	public List<Teacher> teachercheck(String identificationnum);

	public Teacher loadteacherbyidentificationnum(String identificationnum);

	public void announcementadd(Announcement announcement);

	public List<Announcement> announcementlist(int i, int pageSize);

	public Announcement loadannouncement(Integer id);

	public void announcementupdate(Announcement announcement);

	public void announcementdelete(Integer id);

	public void justiceladd(Certify1 certify1);

	public List<Certify1> loadjusticel();

	public void justiceldelete(Integer id);

	public Certify1 loadjusticelbyid(Integer id);

	public void justicelupdate(Certify1 certify);

	public List<Announcement> loadannouncementlist();

	public List<Attendence> personattendence(String semester);

	public List<Attendence> loadattendencebycourseid(String num, String semester);

	public void changeimg(String imgurl, Teacher teacher2);

	public Leave loadleavebyid(Integer id);

	public long totalteacher();

	public long totalstuleave();

	public long totalannouncement();

	public List<SemesterChosenCourse> semestercourselist();

	public void semestercourseadd(SemesterChosenCourse semestercourse);

	public void semestercoursedelete(int courseid);

	public List<SemesterChosenCourse> loadsemestercoursebyid(String courseid, String semester);

	public List<SemesterChosenClassroom> semesterroomlist();

	public List<SemesterChosenClassroom> loadsemesterroombyid(String roomnum, String semester);

	public void semesterroomadd(SemesterChosenClassroom semesterroom);

	public void semesterroomdelete(int roomid);

	public void semestercourseteacheradd(SemesterChosenCourse semestercourse);

	public void semesterteacherendadd(String identificationnum, Integer semestercourseid);

	public Teacher loadteacherbyid(Integer id);

	public void semestercourseclassset(Integer id, String ids);

	public List<SemesterChosenCourse> semesterselectcourselist();

	public void semesterselectcourseupdate(SemesterChosenCourse semestercourse);

	public SemesterChosenCourse loadsemesterselectcoursebycourseid(Integer num);
	
	public List<ChosenCourse> loadChosenCourseByStuId(String id);

	public List<ChosenCourse> loadchosencoursebycourseid(String num);

	public List<SemesterChosenCourse> loadattendencecourse(String usernum, String semester);

	public List<ChosenCourse> loadstuscore(String semester, String stuid);

	public List<ChosenCourse> loadstuscorelist(String semester);

	public void courseclassscoreadd(ChosenCourse chosenCourse);

	public ChosenCourse loadchosencoursebycourse(String courseId, String stuid, String semester);

	public List<ChosenCourse> courseclassscoureload(String semester, String num, String stuid);

	public List<ChosenCourse> loadsinglestuscore(String usernum);

	public List<Leave> loadleavebystuid(String stuid);

	public List<ChosenCourse> loadselectcoursestu(String num, String semester);

	public List<Teacher> loadteacherbyIdent(String teachernum);

	public List<ChosenCourse> searchstuscore(String semester, String stuid, String coursenum);

	public List<SemesterChosenCourse> SemesterCourselist(String semester);

	public SemesterChosenCourse loadselectcoursebycourseid(String num, String semester);

	public List<Evalution> loadevalutionjudge(String num, String usernum, String semester,String flag);

	public List<SemesterChosenCourse> loadsemestercoursebyclass(Integer id, String semester);

	public List<SemesterChosenCourse> loadsemestercoursebycoursenum(String selectiveCourseNum, String semester);

	public List<SemesterChosenCourse> loadallsemestercourse();

	public List<SemesterChosenCourse> loadsemestercourse(String semester);

	public void leaveupdate(Leave leave);

	public ChosenCourse loadchosencourse(String stuid, String semester, String num);

	public List<SemesterChosenCourse> loadsemestercoursebyteacherid(String usernum);

	public Certify1 loadcertifybyid(Integer id);

	public SemesterChosenCourse loadsemestercoursebycourseid(Integer id);

	public List<SemesterChosenCourse> loadsemestercoursebynum(String coursenum);

	public List<SemesterChosenCourse> loadsemestercoursebycourseid(String selectiveCourseNum, String semester);

	public List<Teacher> teacherFuzzySearch(String fuzzyText);

	public List<Attendence> loadallattendence(String semester);

	public List<Attendence> searchallattendence(String coursenum, String stuid, String semester);

	public List<SemesterChosenCourse> loadsemestercourse1(String semester);

	public List<Teacher> loadteacherlikenum(String semester);

	public List<Attendence> loadallpersonattendence(String passport);

	public void updateattendence(Attendence a, String passport);

	public void updateChosenCourse(ChosenCourse c, String passport);

	public List<Evalution> loadstuevalution(String passport);

	public void updateEvalution(Evalution e, String passport);

	public List<Performance> loadstuperformance(String passport);

	public void updatePerformance(Performance p, String passport);

	public void updateLeave(Leave l, String passport);

	public List<Evalution> loadclassteacherevalution(String teacher, String semester);

	public List<Announcement> queryForPage(int offset, int length);

	

}
