package com.tjpu.test.unitTest;

import java.util.ArrayList;
import java.util.List;

import com.tjpu.bean.ChosenCourseModel;
import com.tjpu.bean.ClassesModel;
import com.tjpu.bean.ClassroomModel;
import com.tjpu.bean.CourseModel;
import com.tjpu.bean.TeacherModel;
import com.tjpu.service.CourseArrangement;
import com.tjpu.service.CourseArrangementImpl;

public class CourseArrangeTest {
	
	public static void main(String[] args) {
		//List<Integer> no = new ArrayList<Integer>();
		//no.add(0);
		//CourseArrangement ca = new CourseArrangementImpl(getTestChosenCourses(), getTestRooms(), no);
		//ca.toExcel("e:\\haha.xls");
	}
	
	public static List<ClassroomModel> getTestRooms1111111 () {
		List<ClassroomModel> rooms = new ArrayList<ClassroomModel>();
		rooms.add(new ClassroomModel(0, "room0", "roomtype0", "120", "120"));
		rooms.add(new ClassroomModel(1, "room1", "roomtype0", "120", "120"));
		rooms.add(new ClassroomModel(2, "room2", "roomtype0", "120", "120"));
		rooms.add(new ClassroomModel(3, "room3", "roomtype0", "120", "120"));
		rooms.add(new ClassroomModel(4, "room4", "roomtype1", "120", "120"));
		rooms.add(new ClassroomModel(5, "room5", "roomtype1", "120", "120"));
		rooms.add(new ClassroomModel(6, "room6", "roomtype1", "120", "120"));
		rooms.add(new ClassroomModel(7, "room7", "roomtype2", "120", "120"));
		rooms.add(new ClassroomModel(8, "room8", "roomtype3", "120", "120"));
		rooms.add(new ClassroomModel(9, "room9", "roomtype4", "120", "120"));
		return rooms;
	}
	
	public static List<ChosenCourseModel> getTestChosenCourses111111 () {
		List<ChosenCourseModel> courses = new ArrayList<ChosenCourseModel>();
		List<ClassesModel> classes0 = new ArrayList<ClassesModel>();
		classes0.add(new ClassesModel("瑞士班", 34));
		courses.add(new ChosenCourseModel(new CourseModel(65, String.valueOf(65), "中国纺织品生产与管理"),
				classes0, new TeacherModel(11, "11", "马晓红"), "roomtype0"));
		List<ClassesModel> classes1 = new ArrayList<ClassesModel>();
		classes1.add(new ClassesModel("15本", 7));
		courses.add(new ChosenCourseModel(new CourseModel(44, String.valueOf(44), "中级综合1"),
				classes1, new TeacherModel(9, "9", "张志勇"), "roomtype0"));
		List<ClassesModel> classes2 = new ArrayList<ClassesModel>();
		classes2.add(new ClassesModel("初级A2班", 13));
		courses.add(new ChosenCourseModel(new CourseModel(50, String.valueOf(50), "初级口语1"),
				classes2, new TeacherModel(28, "28", "左惠"), "roomtype0"));
		List<ClassesModel> classes3 = new ArrayList<ClassesModel>();
		classes3.add(new ClassesModel("高级A班", 20));
		classes3.add(new ClassesModel("14本", 23));
		courses.add(new ChosenCourseModel(new CourseModel(16, String.valueOf(16), "高级报刊阅读1"),
				classes3, new TeacherModel(36, "36", "任瑛"), "roomtype0"));
		List<ClassesModel> classes4 = new ArrayList<ClassesModel>();
		classes4.add(new ClassesModel("中级A1班", 8));
		courses.add(new ChosenCourseModel(new CourseModel(44, String.valueOf(44), "中级综合1"),
				classes4, new TeacherModel(13, "13", "苏文"), "roomtype0"));
		List<ClassesModel> classes5 = new ArrayList<ClassesModel>();
		classes5.add(new ClassesModel("初级B2班", 11));
		courses.add(new ChosenCourseModel(new CourseModel(35, String.valueOf(35), "初级综合2"),
				classes5, new TeacherModel(28, "28", "左惠"), "roomtype0"));
		List<ClassesModel> classes6 = new ArrayList<ClassesModel>();
		classes6.add(new ClassesModel("初级C1班", 29));
		courses.add(new ChosenCourseModel(new CourseModel(52, String.valueOf(52), "初级口语3"),
				classes6, new TeacherModel(17, "17", "徐娜"), "roomtype0"));
		List<ClassesModel> classes7 = new ArrayList<ClassesModel>();
		classes7.add(new ClassesModel("NA", 36));
		courses.add(new ChosenCourseModel(new CourseModel(46, String.valueOf(46), "教师英语课1"),
				classes7, new TeacherModel(47, "47", "Dennis"), "roomtype0"));
		List<ClassesModel> classes8 = new ArrayList<ClassesModel>();
		classes8.add(new ClassesModel("15本", 7));
		courses.add(new ChosenCourseModel(new CourseModel(36, String.valueOf(36), "现代汉语写作1"),
				classes8, new TeacherModel(25, "25", "吴静"), "roomtype0"));
		List<ClassesModel> classes9 = new ArrayList<ClassesModel>();
		classes9.add(new ClassesModel("初级B1班", 28));
		courses.add(new ChosenCourseModel(new CourseModel(35, String.valueOf(35), "初级综合2"),
				classes9, new TeacherModel(2, "2", "锡晓静"), "roomtype0"));
		List<ClassesModel> classes10 = new ArrayList<ClassesModel>();
		classes10.add(new ClassesModel("初级C1班", 29));
		courses.add(new ChosenCourseModel(new CourseModel(34, String.valueOf(34), "初级综合3"),
				classes10, new TeacherModel(21, "21", "丁明君"), "roomtype0"));
		List<ClassesModel> classes11 = new ArrayList<ClassesModel>();
		classes11.add(new ClassesModel("初级A1班", 27));
		courses.add(new ChosenCourseModel(new CourseModel(50, String.valueOf(50), "初级口语1"),
				classes11, new TeacherModel(20, "20", "齐硕樑"), "roomtype0"));
		List<ClassesModel> classes12 = new ArrayList<ClassesModel>();
		classes12.add(new ClassesModel("初级B1班", 28));
		courses.add(new ChosenCourseModel(new CourseModel(35, String.valueOf(35), "初级综合2"),
				classes12, new TeacherModel(2, "2", "锡晓静"), "roomtype0"));
		List<ClassesModel> classes13 = new ArrayList<ClassesModel>();
		classes13.add(new ClassesModel("高级A班", 20));
		classes13.add(new ClassesModel("15本", 7));
		courses.add(new ChosenCourseModel(new CourseModel(47, String.valueOf(47), "高级综合1"),
				classes13, new TeacherModel(41, "41", "张云楠"), "roomtype0"));
		List<ClassesModel> classes14 = new ArrayList<ClassesModel>();
		classes14.add(new ClassesModel("14英文班", 3));
		courses.add(new ChosenCourseModel(new CourseModel(21, String.valueOf(21), "大学汉语2"),
				classes14, new TeacherModel(2, "2", "锡晓静"), "roomtype0"));
		List<ClassesModel> classes15 = new ArrayList<ClassesModel>();
		classes15.add(new ClassesModel("11汉语入系生班", 25));
		classes15.add(new ClassesModel("12汉语入系生班", 5));
		classes15.add(new ClassesModel("13汉语入系生班", 32));
		courses.add(new ChosenCourseModel(new CourseModel(27, String.valueOf(27), "大学汉语5"),
				classes15, new TeacherModel(49, "49", "浦华"), "roomtype0"));
		List<ClassesModel> classes16 = new ArrayList<ClassesModel>();
		classes16.add(new ClassesModel("14汉语入系生班", 17));
		courses.add(new ChosenCourseModel(new CourseModel(26, String.valueOf(26), "大学汉语4"),
				classes16, new TeacherModel(1, "1", "王晏殊"), "roomtype0"));
		List<ClassesModel> classes17 = new ArrayList<ClassesModel>();
		classes17.add(new ClassesModel("高级B1班", 33));
		courses.add(new ChosenCourseModel(new CourseModel(23, String.valueOf(23), "高级口语2"),
				classes17, new TeacherModel(15, "15", "刘妍"), "roomtype0"));
		List<ClassesModel> classes18 = new ArrayList<ClassesModel>();
		classes18.add(new ClassesModel("15本", 7));
		courses.add(new ChosenCourseModel(new CourseModel(44, String.valueOf(44), "中级综合1"),
				classes18, new TeacherModel(9, "9", "张志勇"), "roomtype0"));
		List<ClassesModel> classes19 = new ArrayList<ClassesModel>();
		classes19.add(new ClassesModel("初级B1班", 28));
		courses.add(new ChosenCourseModel(new CourseModel(53, String.valueOf(53), "初级口语2"),
				classes19, new TeacherModel(39, "39", "布和"), "roomtype0"));
		List<ClassesModel> classes20 = new ArrayList<ClassesModel>();
		classes20.add(new ClassesModel("中级A1班", 8));
		courses.add(new ChosenCourseModel(new CourseModel(3, String.valueOf(3), "HSK辅导1"),
				classes20, new TeacherModel(25, "25", "吴静"), "roomtype0"));
		List<ClassesModel> classes21 = new ArrayList<ClassesModel>();
		classes21.add(new ClassesModel("初级A1班", 27));
		courses.add(new ChosenCourseModel(new CourseModel(32, String.valueOf(32), "初级综合1"),
				classes21, new TeacherModel(35, "35", "韩蔚"), "roomtype0"));
		List<ClassesModel> classes22 = new ArrayList<ClassesModel>();
		classes22.add(new ClassesModel("初级B2班", 11));
		courses.add(new ChosenCourseModel(new CourseModel(35, String.valueOf(35), "初级综合2"),
				classes22, new TeacherModel(28, "28", "左惠"), "roomtype0"));
		List<ClassesModel> classes23 = new ArrayList<ClassesModel>();
		classes23.add(new ClassesModel("中级A1班", 8));
		courses.add(new ChosenCourseModel(new CourseModel(40, String.valueOf(40), "中级报刊阅读1"),
				classes23, new TeacherModel(19, "19", "陆曦"), "roomtype0"));
		List<ClassesModel> classes24 = new ArrayList<ClassesModel>();
		classes24.add(new ClassesModel("15本", 7));
		courses.add(new ChosenCourseModel(new CourseModel(19, String.valueOf(19), "中国概况"),
				classes24, new TeacherModel(24, "24", "马建国"), "roomtype0"));
		List<ClassesModel> classes25 = new ArrayList<ClassesModel>();
		classes25.add(new ClassesModel("德国班", 12));
		courses.add(new ChosenCourseModel(new CourseModel(45, String.valueOf(45), "针织先进技术概论"),
				classes25, new TeacherModel(12, "12", "姜亚明"), "roomtype0"));
		List<ClassesModel> classes26 = new ArrayList<ClassesModel>();
		classes26.add(new ClassesModel("中级A1班", 8));
		courses.add(new ChosenCourseModel(new CourseModel(40, String.valueOf(40), "中级报刊阅读1"),
				classes26, new TeacherModel(19, "19", "陆曦"), "roomtype0"));
		List<ClassesModel> classes27 = new ArrayList<ClassesModel>();
		classes27.add(new ClassesModel("14本", 23));
		courses.add(new ChosenCourseModel(new CourseModel(12, String.valueOf(12), "中外文化对比"),
				classes27, new TeacherModel(29, "29", "杨玉洁"), "roomtype0"));
		List<ClassesModel> classes28 = new ArrayList<ClassesModel>();
		classes28.add(new ClassesModel("11汉语入系生班", 25));
		classes28.add(new ClassesModel("12汉语入系生班", 5));
		classes28.add(new ClassesModel("13汉语入系生班", 32));
		classes28.add(new ClassesModel("14汉语入系生班", 17));
		courses.add(new ChosenCourseModel(new CourseModel(64, String.valueOf(64), "高等数学"),
				classes28, new TeacherModel(37, "37", "陈汉军"), "roomtype0"));
		List<ClassesModel> classes29 = new ArrayList<ClassesModel>();
		classes29.add(new ClassesModel("德国班", 12));
		courses.add(new ChosenCourseModel(new CourseModel(37, String.valueOf(37), "纺织复合材料"),
				classes29, new TeacherModel(38, "38", "王春红"), "roomtype0"));
		List<ClassesModel> classes30 = new ArrayList<ClassesModel>();
		classes30.add(new ClassesModel("瑞士班", 34));
		courses.add(new ChosenCourseModel(new CourseModel(2, String.valueOf(2), "社会文化风俗"),
				classes30, new TeacherModel(10, "10", "何崟"), "roomtype0"));
		List<ClassesModel> classes31 = new ArrayList<ClassesModel>();
		classes31.add(new ClassesModel("初级A2班", 13));
		courses.add(new ChosenCourseModel(new CourseModel(50, String.valueOf(50), "初级口语1"),
				classes31, new TeacherModel(28, "28", "左惠"), "roomtype0"));
		List<ClassesModel> classes32 = new ArrayList<ClassesModel>();
		classes32.add(new ClassesModel("中级A1班", 8));
		courses.add(new ChosenCourseModel(new CourseModel(44, String.valueOf(44), "中级综合1"),
				classes32, new TeacherModel(13, "13", "苏文"), "roomtype0"));
		List<ClassesModel> classes33 = new ArrayList<ClassesModel>();
		classes33.add(new ClassesModel("德国班", 12));
		courses.add(new ChosenCourseModel(new CourseModel(37, String.valueOf(37), "纺织复合材料"),
				classes33, new TeacherModel(38, "38", "王春红"), "roomtype0"));
		List<ClassesModel> classes34 = new ArrayList<ClassesModel>();
		classes34.add(new ClassesModel("初级A1班", 27));
		courses.add(new ChosenCourseModel(new CourseModel(32, String.valueOf(32), "初级综合1"),
				classes34, new TeacherModel(35, "35", "韩蔚"), "roomtype0"));
		List<ClassesModel> classes35 = new ArrayList<ClassesModel>();
		classes35.add(new ClassesModel("初级B2班", 11));
		courses.add(new ChosenCourseModel(new CourseModel(35, String.valueOf(35), "初级综合2"),
				classes35, new TeacherModel(28, "28", "左惠"), "roomtype0"));
		List<ClassesModel> classes36 = new ArrayList<ClassesModel>();
		classes36.add(new ClassesModel("中级B1班", 26));
		courses.add(new ChosenCourseModel(new CourseModel(39, String.valueOf(39), "现代汉语写作2"),
				classes36, new TeacherModel(4, "4", "吴玉平"), "roomtype0"));
		List<ClassesModel> classes37 = new ArrayList<ClassesModel>();
		classes37.add(new ClassesModel("NA", 37));
		courses.add(new ChosenCourseModel(new CourseModel(49, String.valueOf(49), "教师英语课2"),
				classes37, new TeacherModel(47, "47", "Dennis"), "roomtype0"));
		List<ClassesModel> classes38 = new ArrayList<ClassesModel>();
		classes38.add(new ClassesModel("初级A1班", 27));
		courses.add(new ChosenCourseModel(new CourseModel(38, String.valueOf(38), "汉字1"), classes38,
				new TeacherModel(32, "32", "黄小清"), "roomtype0"));
		List<ClassesModel> classes39 = new ArrayList<ClassesModel>();
		classes39.add(new ClassesModel("中级A1班", 8));
		courses.add(new ChosenCourseModel(new CourseModel(36, String.valueOf(36), "现代汉语写作1"),
				classes39, new TeacherModel(4, "4", "吴玉平"), "roomtype0"));
		List<ClassesModel> classes40 = new ArrayList<ClassesModel>();
		classes40.add(new ClassesModel("初级A1班", 27));
		courses.add(new ChosenCourseModel(new CourseModel(50, String.valueOf(50), "初级口语1"),
				classes40, new TeacherModel(20, "20", "齐硕樑"), "roomtype0"));
		List<ClassesModel> classes41 = new ArrayList<ClassesModel>();
		classes41.add(new ClassesModel("高级B班", 0));
		classes41.add(new ClassesModel("高级C班", 18));
		classes41.add(new ClassesModel("14本", 23));
		courses.add(new ChosenCourseModel(new CourseModel(29, String.valueOf(29), "论文指导"),
				classes41, new TeacherModel(49, "49", "浦华"), "roomtype0"));
		List<ClassesModel> classes42 = new ArrayList<ClassesModel>();
		classes42.add(new ClassesModel("15本", 7));
		courses.add(new ChosenCourseModel(new CourseModel(63, String.valueOf(63), "实践中学汉语"),
				classes42, new TeacherModel(8, "8", "杜萌"), "roomtype0"));
		List<ClassesModel> classes43 = new ArrayList<ClassesModel>();
		classes43.add(new ClassesModel("13英文班", 31));
		courses.add(new ChosenCourseModel(new CourseModel(26, String.valueOf(26), "大学汉语4"),
				classes43, new TeacherModel(5, "5", "陈磊"), "roomtype0"));
		List<ClassesModel> classes44 = new ArrayList<ClassesModel>();
		classes44.add(new ClassesModel("11汉语入系生班", 25));
		classes44.add(new ClassesModel("12汉语入系生班", 5));
		classes44.add(new ClassesModel("13汉语入系生班", 32));
		courses.add(new ChosenCourseModel(new CourseModel(27, String.valueOf(27), "大学汉语5"),
				classes44, new TeacherModel(49, "49", "浦华"), "roomtype0"));
		List<ClassesModel> classes45 = new ArrayList<ClassesModel>();
		classes45.add(new ClassesModel("14汉语入系生班", 17));
		courses.add(new ChosenCourseModel(new CourseModel(26, String.valueOf(26), "大学汉语4"),
				classes45, new TeacherModel(1, "1", "王晏殊"), "roomtype0"));
		List<ClassesModel> classes46 = new ArrayList<ClassesModel>();
		classes46.add(new ClassesModel("15本", 7));
		courses.add(new ChosenCourseModel(new CourseModel(44, String.valueOf(44), "中级综合1"),
				classes46, new TeacherModel(9, "9", "张志勇"), "roomtype0"));
		List<ClassesModel> classes47 = new ArrayList<ClassesModel>();
		classes47.add(new ClassesModel("初级A2班", 13));
		courses.add(new ChosenCourseModel(new CourseModel(50, String.valueOf(50), "初级口语1"),
				classes47, new TeacherModel(28, "28", "左惠"), "roomtype0"));
		List<ClassesModel> classes48 = new ArrayList<ClassesModel>();
		classes48.add(new ClassesModel("中级A1班", 8));
		classes48.add(new ClassesModel("中级B1班", 26));
		courses.add(new ChosenCourseModel(new CourseModel(63, String.valueOf(63), "实践中学汉语"),
				classes48, new TeacherModel(50, "50", "田旭"), "roomtype0"));
		List<ClassesModel> classes49 = new ArrayList<ClassesModel>();
		classes49.add(new ClassesModel("初级B2班", 11));
		courses.add(new ChosenCourseModel(new CourseModel(35, String.valueOf(35), "初级综合2"),
				classes49, new TeacherModel(28, "28", "左惠"), "roomtype0"));
		List<ClassesModel> classes50 = new ArrayList<ClassesModel>();
		classes50.add(new ClassesModel("14本", 23));
		courses.add(new ChosenCourseModel(new CourseModel(63, String.valueOf(63), "实践中学汉语"),
				classes50, new TeacherModel(8, "8", "杜萌"), "roomtype0"));
		List<ClassesModel> classes51 = new ArrayList<ClassesModel>();
		classes51.add(new ClassesModel("初级B2班", 11));
		courses.add(new ChosenCourseModel(new CourseModel(7, String.valueOf(7), "汉字2"), classes51,
				new TeacherModel(42, "42", "张晓菲"), "roomtype0"));
		List<ClassesModel> classes52 = new ArrayList<ClassesModel>();
		classes52.add(new ClassesModel("高级B1班", 33));
		courses.add(new ChosenCourseModel(new CourseModel(48, String.valueOf(48), "高级综合2"),
				classes52, new TeacherModel(36, "36", "任瑛"), "roomtype0"));
		List<ClassesModel> classes53 = new ArrayList<ClassesModel>();
		classes53.add(new ClassesModel("德国班", 12));
		courses.add(new ChosenCourseModel(new CourseModel(22, String.valueOf(22), "基础汉语"),
				classes53, new TeacherModel(23, "23", "张兴国"), "roomtype0"));
		List<ClassesModel> classes54 = new ArrayList<ClassesModel>();
		classes54.add(new ClassesModel("中级A1班", 8));
		courses.add(new ChosenCourseModel(new CourseModel(44, String.valueOf(44), "中级综合1"),
				classes54, new TeacherModel(13, "13", "苏文"), "roomtype0"));
		List<ClassesModel> classes55 = new ArrayList<ClassesModel>();
		classes55.add(new ClassesModel("13英文班", 31));
		courses.add(new ChosenCourseModel(new CourseModel(26, String.valueOf(26), "大学汉语4"),
				classes55, new TeacherModel(5, "5", "陈磊"), "roomtype0"));
		List<ClassesModel> classes56 = new ArrayList<ClassesModel>();
		classes56.add(new ClassesModel("11汉语入系生班", 25));
		classes56.add(new ClassesModel("12汉语入系生班", 5));
		classes56.add(new ClassesModel("13汉语入系生班", 32));
		classes56.add(new ClassesModel("14汉语入系生班", 17));
		courses.add(new ChosenCourseModel(new CourseModel(58, String.valueOf(58), "线性代数"),
				classes56, new TeacherModel(37, "37", "陈汉军"), "roomtype0"));
		List<ClassesModel> classes57 = new ArrayList<ClassesModel>();
		classes57.add(new ClassesModel("14英文班", 3));
		courses.add(new ChosenCourseModel(new CourseModel(21, String.valueOf(21), "大学汉语2"),
				classes57, new TeacherModel(2, "2", "锡晓静"), "roomtype0"));
		List<ClassesModel> classes58 = new ArrayList<ClassesModel>();
		classes58.add(new ClassesModel("13服装", 1));
		classes58.add(new ClassesModel("14纺织", 6));
		courses.add(new ChosenCourseModel(new CourseModel(11, String.valueOf(11), "大学物理（英）"),
				classes58, new TeacherModel(43, "43", "高慧"), "roomtype0"));
		List<ClassesModel> classes59 = new ArrayList<ClassesModel>();
		classes59.add(new ClassesModel("初级A1班", 27));
		courses.add(new ChosenCourseModel(new CourseModel(32, String.valueOf(32), "初级综合1"),
				classes59, new TeacherModel(35, "35", "韩蔚"), "roomtype0"));
		List<ClassesModel> classes60 = new ArrayList<ClassesModel>();
		classes60.add(new ClassesModel("初级B1班", 28));
		courses.add(new ChosenCourseModel(new CourseModel(53, String.valueOf(53), "初级口语2"),
				classes60, new TeacherModel(39, "39", "布和"), "roomtype0"));
		List<ClassesModel> classes61 = new ArrayList<ClassesModel>();
		classes61.add(new ClassesModel("中级B1班", 26));
		courses.add(new ChosenCourseModel(new CourseModel(39, String.valueOf(39), "现代汉语写作2"),
				classes61, new TeacherModel(4, "4", "吴玉平"), "roomtype0"));
		List<ClassesModel> classes62 = new ArrayList<ClassesModel>();
		classes62.add(new ClassesModel("中级B1班", 26));
		courses.add(new ChosenCourseModel(new CourseModel(5, String.valueOf(5), "HSK辅导2"),
				classes62, new TeacherModel(25, "25", "吴静"), "roomtype0"));
		List<ClassesModel> classes63 = new ArrayList<ClassesModel>();
		classes63.add(new ClassesModel("初级A1班", 27));
		courses.add(new ChosenCourseModel(new CourseModel(32, String.valueOf(32), "初级综合1"),
				classes63, new TeacherModel(35, "35", "韩蔚"), "roomtype0"));
		List<ClassesModel> classes64 = new ArrayList<ClassesModel>();
		classes64.add(new ClassesModel("初级B1班", 28));
		courses.add(new ChosenCourseModel(new CourseModel(7, String.valueOf(7), "汉字2"), classes64,
				new TeacherModel(30, "30", "张辰"), "roomtype0"));
		List<ClassesModel> classes65 = new ArrayList<ClassesModel>();
		classes65.add(new ClassesModel("中级A1班", 8));
		courses.add(new ChosenCourseModel(new CourseModel(36, String.valueOf(36), "现代汉语写作1"),
				classes65, new TeacherModel(4, "4", "吴玉平"), "roomtype0"));
		List<ClassesModel> classes66 = new ArrayList<ClassesModel>();
		classes66.add(new ClassesModel("电信1班", 2));
		courses.add(new ChosenCourseModel(new CourseModel(66, String.valueOf(66), "None"),
				classes66, new TeacherModel(14, "14", "Kelvin"), "roomtype0"));
		List<ClassesModel> classes67 = new ArrayList<ClassesModel>();
		classes67.add(new ClassesModel("电信3班", 16));
		courses.add(new ChosenCourseModel(new CourseModel(67, String.valueOf(67), "None"),
				classes67, new TeacherModel(14, "14", "Kelvin"), "roomtype0"));
		List<ClassesModel> classes68 = new ArrayList<ClassesModel>();
		classes68.add(new ClassesModel("电气1班", 22));
		courses.add(new ChosenCourseModel(new CourseModel(68, String.valueOf(68), "None"),
				classes68, new TeacherModel(27, "27", "David"), "roomtype0"));
		List<ClassesModel> classes69 = new ArrayList<ClassesModel>();
		classes69.add(new ClassesModel("电信2班", 30));
		courses.add(new ChosenCourseModel(new CourseModel(69, String.valueOf(69), "None"),
				classes69, new TeacherModel(14, "14", "Kelvin"), "roomtype0"));
		List<ClassesModel> classes70 = new ArrayList<ClassesModel>();
		classes70.add(new ClassesModel("电气2班", 4));
		courses.add(new ChosenCourseModel(new CourseModel(70, String.valueOf(70), "None"),
				classes70, new TeacherModel(27, "27", "David"), "roomtype0"));
		List<ClassesModel> classes71 = new ArrayList<ClassesModel>();
		classes71.add(new ClassesModel("电信4班", 35));
		courses.add(new ChosenCourseModel(new CourseModel(71, String.valueOf(71), "None"),
				classes71, new TeacherModel(14, "14", "Kelvin"), "roomtype0"));
		List<ClassesModel> classes72 = new ArrayList<ClassesModel>();
		classes72.add(new ClassesModel("NA", 38));
		courses.add(new ChosenCourseModel(new CourseModel(33, String.valueOf(33), "ISE1-DE3"),
				classes72, new TeacherModel(47, "47", "Dennis"), "roomtype0"));
		List<ClassesModel> classes73 = new ArrayList<ClassesModel>();
		classes73.add(new ClassesModel("NA", 39));
		courses.add(new ChosenCourseModel(new CourseModel(0, String.valueOf(0), "ISE1-DE4"),
				classes73, new TeacherModel(47, "47", "Dennis"), "roomtype0"));
		List<ClassesModel> classes74 = new ArrayList<ClassesModel>();
		classes74.add(new ClassesModel("NA", 40));
		courses.add(new ChosenCourseModel(new CourseModel(25, String.valueOf(25), "EOC1-G16"),
				classes74, new TeacherModel(40, "40", "Grace"), "roomtype0"));
		List<ClassesModel> classes75 = new ArrayList<ClassesModel>();
		classes75.add(new ClassesModel("NA", 41));
		courses.add(new ChosenCourseModel(new CourseModel(24, String.valueOf(24), "EOC1-G17"),
				classes75, new TeacherModel(40, "40", "Grace"), "roomtype0"));
		List<ClassesModel> classes76 = new ArrayList<ClassesModel>();
		classes76.add(new ClassesModel("NA", 42));
		courses.add(new ChosenCourseModel(new CourseModel(59, String.valueOf(59), "ISE2-DE5"),
				classes76, new TeacherModel(47, "47", "Dennis"), "roomtype0"));
		List<ClassesModel> classes77 = new ArrayList<ClassesModel>();
		classes77.add(new ClassesModel("NA", 43));
		courses.add(new ChosenCourseModel(new CourseModel(56, String.valueOf(56), "EOC2-G18"),
				classes77, new TeacherModel(40, "40", "Grace"), "roomtype0"));
		List<ClassesModel> classes78 = new ArrayList<ClassesModel>();
		classes78.add(new ClassesModel("NA", 44));
		courses.add(new ChosenCourseModel(new CourseModel(60, String.valueOf(60), "ISE2-DE6"),
				classes78, new TeacherModel(47, "47", "Dennis"), "roomtype0"));
		List<ClassesModel> classes79 = new ArrayList<ClassesModel>();
		classes79.add(new ClassesModel("NA", 45));
		courses.add(new ChosenCourseModel(new CourseModel(51, String.valueOf(51), "EOC2-G19"),
				classes79, new TeacherModel(40, "40", "Grace"), "roomtype0"));
		List<ClassesModel> classes80 = new ArrayList<ClassesModel>();
		classes80.add(new ClassesModel("NA", 46));
		courses.add(new ChosenCourseModel(new CourseModel(49, String.valueOf(49), "教师英语课2"),
				classes80, new TeacherModel(47, "47", "Dennis"), "roomtype0"));
		List<ClassesModel> classes81 = new ArrayList<ClassesModel>();
		classes81.add(new ClassesModel("NA", 47));
		courses.add(new ChosenCourseModel(new CourseModel(8, String.valueOf(8), "ISE1-D11"),
				classes81, new TeacherModel(27, "27", "David"), "roomtype0"));
		List<ClassesModel> classes82 = new ArrayList<ClassesModel>();
		classes82.add(new ClassesModel("NA", 48));
		courses.add(new ChosenCourseModel(new CourseModel(10, String.valueOf(10), "ISE2-D12"),
				classes82, new TeacherModel(27, "27", "David"), "roomtype0"));
		List<ClassesModel> classes83 = new ArrayList<ClassesModel>();
		classes83.add(new ClassesModel("初级B2班", 11));
		courses.add(new ChosenCourseModel(new CourseModel(53, String.valueOf(53), "初级口语2"),
				classes83, new TeacherModel(18, "18", "徐碧涵"), "roomtype1"));
		List<ClassesModel> classes84 = new ArrayList<ClassesModel>();
		classes84.add(new ClassesModel("德国班", 12));
		courses.add(new ChosenCourseModel(new CourseModel(2, String.valueOf(2), "社会文化风俗"),
				classes84, new TeacherModel(26, "26", "倪玲"), "roomtype1"));
		List<ClassesModel> classes85 = new ArrayList<ClassesModel>();
		classes85.add(new ClassesModel("中级B1班", 26));
		courses.add(new ChosenCourseModel(new CourseModel(14, String.valueOf(14), "中级听说2"),
				classes85, new TeacherModel(49, "49", "浦华"), "roomtype1"));
		List<ClassesModel> classes86 = new ArrayList<ClassesModel>();
		classes86.add(new ClassesModel("初级A2班", 13));
		courses.add(new ChosenCourseModel(new CourseModel(32, String.valueOf(32), "初级综合1"),
				classes86, new TeacherModel(3, "3", "宋云飞"), "roomtype1"));
		List<ClassesModel> classes87 = new ArrayList<ClassesModel>();
		classes87.add(new ClassesModel("高级B1班", 33));
		courses.add(new ChosenCourseModel(new CourseModel(48, String.valueOf(48), "高级综合2"),
				classes87, new TeacherModel(36, "36", "任瑛"), "roomtype1"));
		List<ClassesModel> classes88 = new ArrayList<ClassesModel>();
		classes88.add(new ClassesModel("高级B班", 0));
		classes88.add(new ClassesModel("高级C班", 18));
		classes88.add(new ClassesModel("14本", 23));
		courses.add(new ChosenCourseModel(new CourseModel(29, String.valueOf(29), "论文指导"),
				classes88, new TeacherModel(49, "49", "浦华"), "roomtype1"));
		List<ClassesModel> classes89 = new ArrayList<ClassesModel>();
		classes89.add(new ClassesModel("初级A2班", 13));
		courses.add(new ChosenCourseModel(new CourseModel(32, String.valueOf(32), "初级综合1"),
				classes89, new TeacherModel(3, "3", "宋云飞"), "roomtype1"));
		List<ClassesModel> classes90 = new ArrayList<ClassesModel>();
		classes90.add(new ClassesModel("中级B1班", 26));
		courses.add(new ChosenCourseModel(new CourseModel(41, String.valueOf(41), "中级报刊阅读2"),
				classes90, new TeacherModel(7, "7", "羊隽芳"), "roomtype1"));
		List<ClassesModel> classes91 = new ArrayList<ClassesModel>();
		classes91.add(new ClassesModel("德国班", 12));
		courses.add(new ChosenCourseModel(new CourseModel(22, String.valueOf(22), "基础汉语"),
				classes91, new TeacherModel(23, "23", "张兴国"), "roomtype1"));
		List<ClassesModel> classes92 = new ArrayList<ClassesModel>();
		classes92.add(new ClassesModel("初级B2班", 11));
		courses.add(new ChosenCourseModel(new CourseModel(53, String.valueOf(53), "初级口语2"),
				classes92, new TeacherModel(18, "18", "徐碧涵"), "roomtype1"));
		List<ClassesModel> classes93 = new ArrayList<ClassesModel>();
		classes93.add(new ClassesModel("德国班", 12));
		courses.add(new ChosenCourseModel(new CourseModel(2, String.valueOf(2), "社会文化风俗"),
				classes93, new TeacherModel(26, "26", "倪玲"), "roomtype1"));
		List<ClassesModel> classes94 = new ArrayList<ClassesModel>();
		classes94.add(new ClassesModel("高级A班", 20));
		classes94.add(new ClassesModel("高级B班", 0));
		classes94.add(new ClassesModel("高级D班", 14));
		courses.add(new ChosenCourseModel(new CourseModel(19, String.valueOf(19), "中国概况"),
				classes94, new TeacherModel(13, "13", "苏文"), "roomtype1"));
		List<ClassesModel> classes95 = new ArrayList<ClassesModel>();
		classes95.add(new ClassesModel("中级B1班", 26));
		courses.add(new ChosenCourseModel(new CourseModel(42, String.valueOf(42), "中级综合2"),
				classes95, new TeacherModel(34, "34", "叶宁"), "roomtype1"));
		List<ClassesModel> classes96 = new ArrayList<ClassesModel>();
		classes96.add(new ClassesModel("初级A2班", 13));
		courses.add(new ChosenCourseModel(new CourseModel(32, String.valueOf(32), "初级综合1"),
				classes96, new TeacherModel(3, "3", "宋云飞"), "roomtype1"));
		List<ClassesModel> classes97 = new ArrayList<ClassesModel>();
		classes97.add(new ClassesModel("初级C1班", 29));
		courses.add(new ChosenCourseModel(new CourseModel(34, String.valueOf(34), "初级综合3"),
				classes97, new TeacherModel(21, "21", "丁明君"), "roomtype1"));
		List<ClassesModel> classes98 = new ArrayList<ClassesModel>();
		classes98.add(new ClassesModel("中级B1班", 26));
		courses.add(new ChosenCourseModel(new CourseModel(41, String.valueOf(41), "中级报刊阅读2"),
				classes98, new TeacherModel(7, "7", "羊隽芳"), "roomtype1"));
		List<ClassesModel> classes99 = new ArrayList<ClassesModel>();
		classes99.add(new ClassesModel("初级A2班", 13));
		courses.add(new ChosenCourseModel(new CourseModel(32, String.valueOf(32), "初级综合1"),
				classes99, new TeacherModel(3, "3", "宋云飞"), "roomtype1"));
		List<ClassesModel> classes100 = new ArrayList<ClassesModel>();
		classes100.add(new ClassesModel("初级C1班", 29));
		courses.add(new ChosenCourseModel(new CourseModel(34, String.valueOf(34), "初级综合3"),
				classes100, new TeacherModel(21, "21", "丁明君"), "roomtype1"));
		List<ClassesModel> classes101 = new ArrayList<ClassesModel>();
		classes101.add(new ClassesModel("高级A班", 20));
		classes101.add(new ClassesModel("15本", 7));
		courses.add(new ChosenCourseModel(new CourseModel(1, String.valueOf(1), "高级口语1"),
				classes101, new TeacherModel(15, "15", "刘妍"), "roomtype1"));
		List<ClassesModel> classes102 = new ArrayList<ClassesModel>();
		classes102.add(new ClassesModel("初级B2班", 11));
		courses.add(new ChosenCourseModel(new CourseModel(53, String.valueOf(53), "初级口语2"),
				classes102, new TeacherModel(18, "18", "徐碧涵"), "roomtype1"));
		List<ClassesModel> classes103 = new ArrayList<ClassesModel>();
		classes103.add(new ClassesModel("初级B1班", 28));
		courses.add(new ChosenCourseModel(new CourseModel(35, String.valueOf(35), "初级综合2"),
				classes103, new TeacherModel(2, "2", "锡晓静"), "roomtype1"));
		List<ClassesModel> classes104 = new ArrayList<ClassesModel>();
		classes104.add(new ClassesModel("高级C班", 18));
		classes104.add(new ClassesModel("14本", 23));
		courses.add(new ChosenCourseModel(new CourseModel(28, String.valueOf(28), "现当代文学2"),
				classes104, new TeacherModel(24, "24", "马建国"), "roomtype1"));
		List<ClassesModel> classes105 = new ArrayList<ClassesModel>();
		classes105.add(new ClassesModel("高级A班", 20));
		classes105.add(new ClassesModel("高级B班", 0));
		classes105.add(new ClassesModel("高级D班", 14));
		courses.add(new ChosenCourseModel(new CourseModel(19, String.valueOf(19), "中国概况"),
				classes105, new TeacherModel(13, "13", "苏文"), "roomtype1"));
		List<ClassesModel> classes106 = new ArrayList<ClassesModel>();
		classes106.add(new ClassesModel("初级B1班", 28));
		courses.add(new ChosenCourseModel(new CourseModel(35, String.valueOf(35), "初级综合2"),
				classes106, new TeacherModel(2, "2", "锡晓静"), "roomtype1"));
		List<ClassesModel> classes107 = new ArrayList<ClassesModel>();
		classes107.add(new ClassesModel("15本", 7));
		courses.add(new ChosenCourseModel(new CourseModel(19, String.valueOf(19), "中国概况"),
				classes107, new TeacherModel(24, "24", "马建国"), "roomtype1"));
		List<ClassesModel> classes108 = new ArrayList<ClassesModel>();
		classes108.add(new ClassesModel("初级C1班", 29));
		courses.add(new ChosenCourseModel(new CourseModel(34, String.valueOf(34), "初级综合3"),
				classes108, new TeacherModel(21, "21", "丁明君"), "roomtype1"));
		List<ClassesModel> classes109 = new ArrayList<ClassesModel>();
		classes109.add(new ClassesModel("高级A班", 20));
		classes109.add(new ClassesModel("14本", 23));
		courses.add(new ChosenCourseModel(new CourseModel(16, String.valueOf(16), "高级报刊阅读1"),
				classes109, new TeacherModel(36, "36", "任瑛"), "roomtype1"));
		List<ClassesModel> classes110 = new ArrayList<ClassesModel>();
		classes110.add(new ClassesModel("中级B1班", 26));
		courses.add(new ChosenCourseModel(new CourseModel(42, String.valueOf(42), "中级综合2"),
				classes110, new TeacherModel(34, "34", "叶宁"), "roomtype1"));
		List<ClassesModel> classes111 = new ArrayList<ClassesModel>();
		classes111.add(new ClassesModel("初级C1班", 29));
		courses.add(new ChosenCourseModel(new CourseModel(52, String.valueOf(52), "初级口语3"),
				classes111, new TeacherModel(17, "17", "徐娜"), "roomtype1"));
		List<ClassesModel> classes112 = new ArrayList<ClassesModel>();
		classes112.add(new ClassesModel("高级A班", 20));
		classes112.add(new ClassesModel("15本", 7));
		courses.add(new ChosenCourseModel(new CourseModel(47, String.valueOf(47), "高级综合1"),
				classes112, new TeacherModel(41, "41", "张云楠"), "roomtype1"));
		List<ClassesModel> classes113 = new ArrayList<ClassesModel>();
		classes113.add(new ClassesModel("初级B1班", 28));
		courses.add(new ChosenCourseModel(new CourseModel(53, String.valueOf(53), "初级口语2"),
				classes113, new TeacherModel(39, "39", "布和"), "roomtype1"));
		List<ClassesModel> classes114 = new ArrayList<ClassesModel>();
		classes114.add(new ClassesModel("初级C1班", 29));
		courses.add(new ChosenCourseModel(new CourseModel(52, String.valueOf(52), "初级口语3"),
				classes114, new TeacherModel(17, "17", "徐娜"), "roomtype1"));
		List<ClassesModel> classes115 = new ArrayList<ClassesModel>();
		classes115.add(new ClassesModel("中级B1班", 26));
		courses.add(new ChosenCourseModel(new CourseModel(42, String.valueOf(42), "中级综合2"),
				classes115, new TeacherModel(34, "34", "叶宁"), "roomtype1"));
		List<ClassesModel> classes116 = new ArrayList<ClassesModel>();
		classes116.add(new ClassesModel("高级A班", 20));
		classes116.add(new ClassesModel("14本", 23));
		courses.add(new ChosenCourseModel(new CourseModel(16, String.valueOf(16), "高级报刊阅读1"),
				classes116, new TeacherModel(36, "36", "任瑛"), "roomtype1"));
		List<ClassesModel> classes117 = new ArrayList<ClassesModel>();
		classes117.add(new ClassesModel("初级A2班", 13));
		courses.add(new ChosenCourseModel(new CourseModel(62, String.valueOf(62), "初级听力1"),
				classes117, new TeacherModel(45, "45", "郑勇"), "roomtype1"));
		List<ClassesModel> classes118 = new ArrayList<ClassesModel>();
		classes118.add(new ClassesModel("高级A班", 20));
		classes118.add(new ClassesModel("15本", 7));
		courses.add(new ChosenCourseModel(new CourseModel(47, String.valueOf(47), "高级综合1"),
				classes118, new TeacherModel(41, "41", "张云楠"), "roomtype1"));
		List<ClassesModel> classes119 = new ArrayList<ClassesModel>();
		classes119.add(new ClassesModel("高级B1班", 33));
		courses.add(new ChosenCourseModel(new CourseModel(23, String.valueOf(23), "高级口语2"),
				classes119, new TeacherModel(15, "15", "刘妍"), "roomtype1"));
		List<ClassesModel> classes120 = new ArrayList<ClassesModel>();
		classes120.add(new ClassesModel("高级A班", 20));
		classes120.add(new ClassesModel("15本", 7));
		courses.add(new ChosenCourseModel(new CourseModel(1, String.valueOf(1), "高级口语1"),
				classes120, new TeacherModel(15, "15", "刘妍"), "roomtype1"));
		List<ClassesModel> classes121 = new ArrayList<ClassesModel>();
		classes121.add(new ClassesModel("高级B1班", 33));
		courses.add(new ChosenCourseModel(new CourseModel(48, String.valueOf(48), "高级综合2"),
				classes121, new TeacherModel(36, "36", "任瑛"), "roomtype1"));
		List<ClassesModel> classes122 = new ArrayList<ClassesModel>();
		classes122.add(new ClassesModel("NA", 49));
		courses.add(new ChosenCourseModel(new CourseModel(55, String.valueOf(55), "韩语1"),
				classes122, new TeacherModel(22, "22", "韩语1"), "roomtype1"));
		List<ClassesModel> classes123 = new ArrayList<ClassesModel>();
		classes123.add(new ClassesModel("NA", 50));
		courses.add(new ChosenCourseModel(new CourseModel(18, String.valueOf(18), "韩语2"),
				classes123, new TeacherModel(44, "44", "韩语2"), "roomtype1"));
		List<ClassesModel> classes124 = new ArrayList<ClassesModel>();
		classes124.add(new ClassesModel("NA", 51));
		courses.add(new ChosenCourseModel(new CourseModel(57, String.valueOf(57), "韩语3"),
				classes124, new TeacherModel(16, "16", "韩语3"), "roomtype1"));
		List<ClassesModel> classes125 = new ArrayList<ClassesModel>();
		classes125.add(new ClassesModel("瑞士班", 34));
		courses.add(new ChosenCourseModel(new CourseModel(54, String.valueOf(54), "中国画"),
				classes125, new TeacherModel(45, "45", "郑勇"), "roomtype2"));
		List<ClassesModel> classes126 = new ArrayList<ClassesModel>();
		classes126.add(new ClassesModel("瑞士班", 34));
		courses.add(new ChosenCourseModel(new CourseModel(54, String.valueOf(54), "中国画"),
				classes126, new TeacherModel(45, "45", "郑勇"), "roomtype2"));
		List<ClassesModel> classes127 = new ArrayList<ClassesModel>();
		classes127.add(new ClassesModel("德国班", 12));
		courses.add(new ChosenCourseModel(new CourseModel(15, String.valueOf(15), "纺织品图案设计"),
				classes127, new TeacherModel(31, "31", "张毅"), "roomtype2"));
		List<ClassesModel> classes128 = new ArrayList<ClassesModel>();
		classes128.add(new ClassesModel("德国班", 12));
		courses.add(new ChosenCourseModel(new CourseModel(15, String.valueOf(15), "纺织品图案设计"),
				classes128, new TeacherModel(31, "31", "张毅"), "roomtype2"));
		List<ClassesModel> classes129 = new ArrayList<ClassesModel>();
		classes129.add(new ClassesModel("德国班", 12));
		courses.add(new ChosenCourseModel(new CourseModel(20, String.valueOf(20), "旗袍工艺和制作"),
				classes129, new TeacherModel(6, "6", "郭顺德"), "roomtype2"));
		List<ClassesModel> classes130 = new ArrayList<ClassesModel>();
		classes130.add(new ClassesModel("德国班", 12));
		courses.add(new ChosenCourseModel(new CourseModel(20, String.valueOf(20), "旗袍工艺和制作"),
				classes130, new TeacherModel(6, "6", "郭顺德"), "roomtype2"));
		List<ClassesModel> classes131 = new ArrayList<ClassesModel>();
		classes131.add(new ClassesModel("瑞士班", 34));
		courses.add(new ChosenCourseModel(new CourseModel(22, String.valueOf(22), "基础汉语"),
				classes131, new TeacherModel(29, "29", "杨玉洁"), "roomtype3"));
		List<ClassesModel> classes132 = new ArrayList<ClassesModel>();
		classes132.add(new ClassesModel("德国班", 12));
		courses.add(new ChosenCourseModel(new CourseModel(22, String.valueOf(22), "基础汉语"),
				classes132, new TeacherModel(23, "23", "张兴国"), "roomtype3"));
		List<ClassesModel> classes133 = new ArrayList<ClassesModel>();
		classes133.add(new ClassesModel("14英文班", 3));
		courses.add(new ChosenCourseModel(new CourseModel(17, String.valueOf(17), "应用数学2"),
				classes133, new TeacherModel(46, "46", "徐志霞"), "roomtype3"));
		List<ClassesModel> classes134 = new ArrayList<ClassesModel>();
		classes134.add(new ClassesModel("15本", 7));
		courses.add(new ChosenCourseModel(new CourseModel(36, String.valueOf(36), "现代汉语写作1"),
				classes134, new TeacherModel(25, "25", "吴静"), "roomtype3"));
		List<ClassesModel> classes135 = new ArrayList<ClassesModel>();
		classes135.add(new ClassesModel("高级A班", 20));
		classes135.add(new ClassesModel("高级B班", 0));
		classes135.add(new ClassesModel("高级C班", 18));
		classes135.add(new ClassesModel("14本", 23));
		courses.add(new ChosenCourseModel(new CourseModel(4, String.valueOf(4), "HSK辅导3"),
				classes135, new TeacherModel(25, "25", "吴静"), "roomtype3"));
		List<ClassesModel> classes136 = new ArrayList<ClassesModel>();
		classes136.add(new ClassesModel("高级班", 10));
		courses.add(new ChosenCourseModel(new CourseModel(63, String.valueOf(63), "实践中学汉语"),
				classes136, new TeacherModel(8, "8", "杜萌"), "roomtype3"));
		List<ClassesModel> classes137 = new ArrayList<ClassesModel>();
		classes137.add(new ClassesModel("初级C1班", 29));
		courses.add(new ChosenCourseModel(new CourseModel(61, String.valueOf(61), "汉字3"),
				classes137, new TeacherModel(48, "48", "张伟"), "roomtype3"));
		List<ClassesModel> classes138 = new ArrayList<ClassesModel>();
		classes138.add(new ClassesModel("初级A2班", 13));
		courses.add(new ChosenCourseModel(new CourseModel(38, String.valueOf(38), "汉字1"),
				classes138, new TeacherModel(32, "32", "黄小清"), "roomtype3"));
		List<ClassesModel> classes139 = new ArrayList<ClassesModel>();
		classes139.add(new ClassesModel("瑞士班", 34));
		courses.add(new ChosenCourseModel(new CourseModel(22, String.valueOf(22), "基础汉语"),
				classes139, new TeacherModel(29, "29", "杨玉洁"), "roomtype3"));
		List<ClassesModel> classes140 = new ArrayList<ClassesModel>();
		classes140.add(new ClassesModel("13英文", 15));
		classes140.add(new ClassesModel("14纺织", 6));
		courses.add(new ChosenCourseModel(new CourseModel(58, String.valueOf(58), "线性代数"),
				classes140, new TeacherModel(46, "46", "徐志霞"), "roomtype3"));
		List<ClassesModel> classes141 = new ArrayList<ClassesModel>();
		classes141.add(new ClassesModel("11入系生班", 9));
		classes141.add(new ClassesModel("12入系生班", 19));
		classes141.add(new ClassesModel("13入系生班", 24));
		classes141.add(new ClassesModel("14入系生班", 21));
		courses.add(new ChosenCourseModel(new CourseModel(43, String.valueOf(43), "计算机基础"),
				classes141, new TeacherModel(0, "0", "王信"), "roomtype3"));
		List<ClassesModel> classes142 = new ArrayList<ClassesModel>();
		classes142.add(new ClassesModel("中级A1班", 8));
		courses.add(new ChosenCourseModel(new CourseModel(9, String.valueOf(9), "中级听说1"),
				classes142, new TeacherModel(36, "36", "任瑛"), "roomtype4"));
		List<ClassesModel> classes143 = new ArrayList<ClassesModel>();
		classes143.add(new ClassesModel("高级B班", 0));
		classes143.add(new ClassesModel("高级C班", 18));
		classes143.add(new ClassesModel("高级D班", 14));
		courses.add(new ChosenCourseModel(new CourseModel(13, String.valueOf(13), "高级报刊阅读2"),
				classes143, new TeacherModel(25, "25", "吴静"), "roomtype4"));
		List<ClassesModel> classes144 = new ArrayList<ClassesModel>();
		classes144.add(new ClassesModel("初级A1班", 27));
		courses.add(new ChosenCourseModel(new CourseModel(62, String.valueOf(62), "初级听力1"),
				classes144, new TeacherModel(45, "45", "郑勇"), "roomtype4"));
		List<ClassesModel> classes145 = new ArrayList<ClassesModel>();
		classes145.add(new ClassesModel("初级B2班", 11));
		courses.add(new ChosenCourseModel(new CourseModel(30, String.valueOf(30), "初级听力2"),
				classes145, new TeacherModel(45, "45", "郑勇"), "roomtype4"));
		List<ClassesModel> classes146 = new ArrayList<ClassesModel>();
		classes146.add(new ClassesModel("初级A2班", 13));
		courses.add(new ChosenCourseModel(new CourseModel(62, String.valueOf(62), "初级听力1"),
				classes146, new TeacherModel(45, "45", "郑勇"), "roomtype4"));
		List<ClassesModel> classes147 = new ArrayList<ClassesModel>();
		classes147.add(new ClassesModel("初级C1班", 29));
		courses.add(new ChosenCourseModel(new CourseModel(6, String.valueOf(6), "初级听力3"),
				classes147, new TeacherModel(48, "48", "张伟"), "roomtype4"));
		List<ClassesModel> classes148 = new ArrayList<ClassesModel>();
		classes148.add(new ClassesModel("初级B1班", 28));
		courses.add(new ChosenCourseModel(new CourseModel(30, String.valueOf(30), "初级听力2"),
				classes148, new TeacherModel(33, "33", "从月"), "roomtype4"));
		List<ClassesModel> classes149 = new ArrayList<ClassesModel>();
		classes149.add(new ClassesModel("初级A1班", 27));
		courses.add(new ChosenCourseModel(new CourseModel(50, String.valueOf(50), "初级口语1"),
				classes149, new TeacherModel(20, "20", "齐硕樑"), "roomtype4"));
		List<ClassesModel> classes150 = new ArrayList<ClassesModel>();
		classes150.add(new ClassesModel("11入系生班", 9));
		courses.add(new ChosenCourseModel(new CourseModel(31, String.valueOf(31), "计算机应用基础"),
				classes150, new TeacherModel(0, "0", "王信"), "roomtype4"));
		List<ClassesModel> classes151 = new ArrayList<ClassesModel>();
		classes151.add(new ClassesModel("11入系生班", 9));
		courses.add(new ChosenCourseModel(new CourseModel(31, String.valueOf(31), "计算机应用基础"),
				classes151, new TeacherModel(0, "0", "王信"), "roomtype4"));
		List<ClassesModel> classes152 = new ArrayList<ClassesModel>();
		classes152.add(new ClassesModel("中级B1班", 26));
		courses.add(new ChosenCourseModel(new CourseModel(14, String.valueOf(14), "中级听说2"),
				classes152, new TeacherModel(49, "49", "浦华"), "roomtype4"));
		List<ClassesModel> classes153 = new ArrayList<ClassesModel>();
		classes153.add(new ClassesModel("初级B2班", 11));
		courses.add(new ChosenCourseModel(new CourseModel(30, String.valueOf(30), "初级听力2"),
				classes153, new TeacherModel(45, "45", "郑勇"), "roomtype4"));
		List<ClassesModel> classes154 = new ArrayList<ClassesModel>();
		classes154.add(new ClassesModel("初级A1班", 27));
		courses.add(new ChosenCourseModel(new CourseModel(62, String.valueOf(62), "初级听力1"),
				classes154, new TeacherModel(45, "45", "郑勇"), "roomtype4"));
		List<ClassesModel> classes155 = new ArrayList<ClassesModel>();
		classes155.add(new ClassesModel("初级B1班", 28));
		courses.add(new ChosenCourseModel(new CourseModel(30, String.valueOf(30), "初级听力2"),
				classes155, new TeacherModel(33, "33", "从月"), "roomtype4"));
		List<ClassesModel> classes156 = new ArrayList<ClassesModel>();
		classes156.add(new ClassesModel("初级C1班", 29));
		courses.add(new ChosenCourseModel(new CourseModel(6, String.valueOf(6), "初级听力3"),
				classes156, new TeacherModel(48, "48", "张伟"), "roomtype4"));
		List<ClassesModel> classes157 = new ArrayList<ClassesModel>();
		classes157.add(new ClassesModel("中级A1班", 8));
		courses.add(new ChosenCourseModel(new CourseModel(9, String.valueOf(9), "中级听说1"),
				classes157, new TeacherModel(36, "36", "任瑛"), "roomtype4"));
		return courses;
	}

}
