package com.tjpu.test.unitTest;

import java.util.ArrayList;
import java.util.List;

import com.tjpu.bean.ChosenCourse;
import com.tjpu.bean.ChosenCourseModel;
import com.tjpu.bean.ClassesModel;
import com.tjpu.bean.ClassroomModel;
import com.tjpu.bean.CourseModel;
import com.tjpu.bean.SemesterChosenClassroom;
import com.tjpu.bean.SemesterChosenCourse;
import com.tjpu.bean.TeacherModel;
import com.tjpu.dao.ManageDao;
import com.tjpu.dao.ManageDaoImpl;
import com.tjpu.service.ManageService;
import com.tjpu.service.ManageServiceImpl;

public class SyllabusTest {
	static ManageDao manageDao = new ManageDaoImpl();
	private static ChosenCourseModel toModel (SemesterChosenCourse course, String semester) {
		ChosenCourseModel ret = new ChosenCourseModel();
		ret.setBeginWeek(Integer.parseInt(course.getBegainweek()));
		List<ClassesModel> classes = new ArrayList<ClassesModel>();
		for (String id : course.getClass_().split("&"))
			if (id != null)
				classes.add(manageDao.loadClassByID(id));
		ret.setRoomType(course.getRoomtype());
		ret.setClasses(classes);
		ret.setEndWeek(Integer.parseInt(course.getEndweek()));
		Integer id = new Integer(Integer.parseInt(course.getTeacherid()));
		ret.setTeacher(new TeacherModel(manageDao.loadteacherbyid(id)));
		ret.setWeekday(Integer.parseInt(course.getWeekday()));
		ret.setSlot(Integer.parseInt(course.getSlot()));
		ret.setCourse(new CourseModel(manageDao.loadCourseByIdent(course.getCoursenum())));
		List<SemesterChosenClassroom> rooms = manageDao.loadsemesterroombyid(course.getRoomname(),semester);
		if (rooms.size() > 0){
			SemesterChosenClassroom room = rooms.get(0);
			ret.setRoom(new ClassroomModel(room.getId(), room.getNum(), room.getRoomtype(), 
					room.getRoomcapacity(), room.getRealcapacity(), room.getRoomplace()+room.getRoomname()));
		}
		return ret;
	}
	public static void main(String[] args) {
		List<ChosenCourseModel> ret = new ArrayList<ChosenCourseModel>();
		List<ChosenCourse> t = manageDao.stuSyllabusList("1331137141", "201501");
		if (t != null && t.size() > 0)
			for (ChosenCourse course : t){
				List<SemesterChosenCourse> c =  manageDao.loadsemestercoursebyid(course.getCourseId(), "201501");
				if (c != null && c.size() > 0)
					ret.add(toModel(c.get(0), "201501"));
			}
		for (ChosenCourseModel c : ret)
			System.out.println(c);
	}
}
