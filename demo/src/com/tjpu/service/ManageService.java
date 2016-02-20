package com.tjpu.service;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.tjpu.bean.Adjustcourse;
import com.tjpu.bean.AdjustcourseModel;
import com.tjpu.bean.Announcement;
import com.tjpu.bean.Attendence;
import com.tjpu.bean.Certify1;
import com.tjpu.bean.ChosenCourse;
import com.tjpu.bean.ChosenCourseModel;
import com.tjpu.bean.ClassesModel;
import com.tjpu.bean.Classroom;
import com.tjpu.bean.ClassroomModel;
import com.tjpu.bean.Course;
import com.tjpu.bean.Evalution;
import com.tjpu.bean.InfoBean;
import com.tjpu.bean.Leave;
import com.tjpu.bean.PageBean;
import com.tjpu.bean.SemesterChosenCourse;
import com.tjpu.bean.Student;
import com.tjpu.bean.Syllabus;
import com.tjpu.bean.Teacher;
import com.tjpu.bean.User;

public interface ManageService {
	
	public Map<String, Object> batchSetSemesterCourse (String path);
	
	public void ModifyLog (User user, String objectType, String objectName);
	
	public Integer getSerial (User user, String filename, String filetype);
	
	public void printTranscript (OutputStream out, Student student, Integer serial);
	
	//public boolean sqlChk(String text);
	
	public List<Teacher> loadAllAvlTeacher ();
	
	public void recoverTeacher(String id);
	
	public Map<String, Object> semestercourselist2(int page, int pageSize, String semester);
	
	public List<Adjustcourse> approvedAdjustApplyListByWeekday (String weekday, String semester);
	
	public List<Adjustcourse> ApplyingAdjustByWeekday(String weekday, String semester);
	
	public List<SemesterChosenCourse> courseListByWeekday (String weekday, String semester);
	
	public List<Classroom> classroomList ();
	
	public Map<String, List<String>> arrangePreChk (String semester);
	
	public void sire (String semester);
	
	public List<AdjustcourseModel> loadRelateAdjustCourse (String teacehrIdent, String semester);
	
	public List<ChosenCourseModel> loadSemesterChosenCoruseByTeacher (String ident, String semester);
	
	public String getCurrSemester ();
	
	public List<ChosenCourseModel> electiveCourseForSelectCourse (String stuid, String semester);
	
	public void selectCourse (boolean isSelect, String courseNum, String stuid,String semester);
	
	public List<ChosenCourseModel> allSelectiveCourses (String stuid, String semester);
	
	public ClassesModel getClassByStuId (String stuid);
	
	public void checkAdjustApply (boolean isApprove, Integer id);
	
	public void saveAdjustRecord (Syllabus p, Syllabus q, String reason, String semester);
	
	public List<Adjustcourse> adjustRecordList (String semester);
	
	public List<AdjustcourseModel> loadAdjustReocrdsByTeacher (String ident, String semester);
	
	public List<AdjustcourseModel> loadAdjustRocords (String semester);
	
	public List<ChosenCourseModel> loadAllChosenCourse (String semester); 
	
	public List<ChosenCourseModel> loadAllChosenCourse2 (String semester);
	
	public List<ChosenCourseModel> getOtherOption (ChosenCourseModel course, String semester);
	
	public List<ChosenCourseModel> getOtherOptionByCourseNum (String semesterChosenCourseID, String semester);

	public List<ChosenCourseModel> getStuSyllabus (String stuid, String semester);
	
	public void saveArrangedCourse (List<ChosenCourseModel> arranged, String semester);
	
	public void evalutionteacheradd(Evalution evalution);
	
	public List<InfoBean> getUnarrangeCourses (int page, int pageSize, String semester);
	
	public List<ChosenCourseModel> getAllChosenCourse (String semester);
	
	public List<ClassroomModel> getAllAvlRooms(String semester);
	
	public List<ClassroomModel> getAvlRooms (int page, int pageSize,String semester);
	
	public int getTotalUnarrangedCourseNum (String semester);
	
	public int getTotalAvlRoomsNum (String semester);
	
	public String loadevalution(String id);

	public Map<String, Object> teachermap(int page, int pageSize);

	public void teacherupdate(Teacher teacher, Integer depid);

	public void teacherdelete(String ids);

	public void stuattendenceadd(Attendence attendence, String ids);

	public Map<String, Object> attendencestulistmap(int page, int pageSize);

	public void loadattendence(String id);

	public List<Course> loadstucourse();

	public List<Attendence> searchstuattendence(Attendence attendence);

	public void leaveadd(Leave leave);

	public Map<String, Object> stuleavemap(int page, int pageSize);

	public void stuleaveupdate(Leave leave);

	public void leavedelete(Leave leave);

	public String courseattendencesearch(Attendence attendence);

	public Teacher loginService(String usernum, String password);

	public void teacheradd(Teacher teacher, Integer depid);

	public boolean teachercheck(String identificationnum);
	
	public Map<String, Object> batchRegistTeacher (String path);
	
	public void teacheraddbytxt(String path);

	public Teacher loadteacherbyid(Integer id);

	public void justiceladd(Certify1 certify1);

	public void announcementadd(Announcement announcement);

	public Map<String, Object> announcementmap(int page, int pageSize);

	public Announcement loadannouncement(Integer id);

	public void announcementupdate(Announcement announcement);

	public void announcementdelete(String ids);

	public String loadjusticel();

	public void justiceldelete(String ids);

	public List<Certify1> loadjusticellist();

	public Certify1 loadjusticelbyid(Integer id);

	public void justicelupdate(Certify1 certify);

	public String loadattendencelist(String id);

	public List<Announcement> announcementlist();

	public Map<String, Object> stuattendencelistmap(int page, int pageSize);

	public Map<String, Object> personattendencelistmap(int page, int pageSize);

	public List<Attendence> loadattendencebycourseid(String id);

	public void teacherchangeimg(String imgurl);

	public Leave loadleavebyid(Integer id);

	public Map<String, Object> semestercourselist(int page, int pageSize);

	public void semestercourseadd(String ids, String semester);

	public void semestercoursedelete(String ids);

	public Map<String, Object> courselist(int page, int pageSize);

	public Map<String, Object> roomlist(int page, int pageSize);

	public Map<String, Object> semesterroomlist(int page, int pageSize);
	
	public Map<String, Object> semesterroomlist2(int page, int pageSize, String semester);

	public void semesterroomadd(String ids, String semester);

	public void semesterroomdelete(String ids);

	public void semestercourseteacheradd(List<SemesterChosenCourse> listUpdated);

	public void semesterteacherendadd(String identificationnum, Integer semestercourseid);

	public void semesterclassset(Integer id, String ids);

	public Map<String, Object> semesterselectcourselist(int page, int pageSize);

	public void semesterselectcourseupdate(List<SemesterChosenCourse> listUpdated);

	public SemesterChosenCourse loadsemesterchosencoursebycourseid(String num);

	public List<ChosenCourse> loadchosencoursebycourseid(String num);

	public Map<String, Object> attendencecourselist(int page, int pageSize);

	public Teacher loadteacherbynum(String usernum);

	public Map<String, Object> searchsemestercourselist(int page, int pageSize, String semester);

	public Map<String, Object> stuscorelist(int page, int pageSize);

	public boolean stucheck(String stuid);

	public void loadstuscore(String semester, Integer id, String passport, String coursenum);

	public Map<String, Object> searchstuscorelist(int page, int pageSize);

	public void courseclassscoreadd(ChosenCourse chosenCourse);

	public List<ChosenCourse> courseclassscoreload(String semester, String num, Integer id);

	public void courseclassmakeupscoreadd(ChosenCourse chosenCourse);

	public Map<String, Object> allstuscorelist(int page, int pageSize);

	public Map<String, Object> singlestuscorelist(int page, int pageSize);

	public void loadsinglestuscore(String semester, String coursenum);
    
	public Map<String, Object> searchsinglestuscorelist(int page, int pageSize);

	public List<ChosenCourseModel> transcriptsearch(String semester, String passport);

	public List<Evalution> loadevalutionlist(String num);

	public Map<String, Object> loadstuleavemap(int page, int pageSize);

	public boolean isclassteacher(String identificationnum);

	public Map<String, Object> selectresultlist(int page, int pageSize);

	public List<ChosenCourse> loadselectcoursestu(String num, String semester);

	public void semesterroombegainadd(Classroom c, String semester);

	public Map<String, Object> Searchcourselist(int page, int pageSize, String semester);

	public List<Evalution> loadevalution(String num, String usernum, String semester,String flag);

	public void coursesummarydone(ChosenCourse chosenCourse, String semester, String coursenum, String classid);

	public List<Course> loadcourselist();

	public List<SemesterChosenCourse> loadsemestercoursebycoursenum(String selectiveCourseNum, String semester);

	public List<SemesterChosenCourse> listsemester();

	public List<SemesterChosenCourse> loadsemestercourse(String semester);

	public Map<String, Object> semestercourselist3(int page, int pageSize, String semester);

	public Map<String, Object> attendencestatistical(int page, int pageSize);

	public List<Attendence> courseattendencelist(Integer id, String num);

	public void leaveupdate(Leave leave);

	public List<Leave> checkleave(Leave leave);

	public ChosenCourse loadchosencourse(String stuid, String semester, String num);

	public Certify1 loadcertifybyid(Integer id);

	public List<SemesterChosenCourse> loadsemestercoursebycourseid(String selectiveCourseNum, String semester);

	public List<Course> loadcoursebysemester(String usernum, String semester);

	public void loadcoursemakeup(String semester, String num);

	public Map<String, Object> makeuplist(int page, int pageSize);

	public void semestercoursescoreadd(List<ChosenCourseModel> listUpdated, User user);

	public Map<String, Object> teacherFuzzySearch(int page, int pageSize, String fuzzyText);

	public Map<String, Object> courseteachermap(int page, int pageSize);

	public Map<String, Object> justicellist(int page, int pageSize);

	public Map<String, Object> allattendencelistmap(int page, int pageSize);

	public Map<String, Object> searchattendencelistmap(int page, int pageSize, String coursenum, Integer id, String stuid, String startdate, String enddate);

	public void batchaddstuchosencourse();

	public Map<String, Object> allevalutionanalysis(int page, int pageSize);

	public Map<String, Object> singlecourseattendencestatistical(int page, int pageSize, String num, Integer id, String startdate, String enddate);

	public Map<String, Object> searchcourseattendencelist(int page, int pageSize);

	public Map<String, Object> searchcourseattendencelistmap(int page, int pageSize, String coursenum, Integer id, String stuid, String startdate, String enddate, String time, String type);

	public Map<String, Object> classteacherevalutionmap(int page, int pageSize);

	public String loadclassteacherevalution(String teacher);

	public List<Evalution> loadclassteacherevalutionlist(String num);

	public Map<String, Object> allClassteacherEvalutionResult(int page, int pageSize);

	public PageBean loadallannouncement(int page, int pageSize);



}
