package com.tjpu.service;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.tjpu.bean.Leave;
import com.tjpu.bean.Student;
import com.tjpu.bean.Transcript;

public class TranscriptServiceImpl implements TranscriptService{
	
	Map<String, String> nationality = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
	{
		put("中国", "China");
		put("蒙古", "Mongolian");
		put("韩国", "Republic of Korea");
		put("日本", "Janpan");
		put("瑞士", "Switzerland");
		put("德国", "Germany");
	}};
	
	List<String> months = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
	{
		add("January");
		add("February");
		add("March");
		add("April");
		add("May");
		add("June");
		add("July");
		add("August");
		add("September");
		add("October");
		add("November");
		add("December");
	}};
		
	
	public void getPerTscript (OutputStream out,  Map<String, Object> info){
		if (info.isEmpty()) {
			return;
		}
		
		Student student = (Student)info.get("Student");
		@SuppressWarnings("unchecked")
		List<Transcript> courses = (List<Transcript>) info.get("Courses");
		
		Map<String, Object> dataMap = new HashMap<String, Object>();  
		dataMap.put("Name_CN", student.getStuname());  
		dataMap.put("Nationality_CN",  student.getNation());
		if (nationality.containsKey(student.getNation())) {
			dataMap.put("Nationality", nationality.get(student.getNation()));
		} else {
			dataMap.put("Nationality", " ");
		}
		dataMap.put("Passport", student.getPassport());
		dataMap.put("Name", student.getFirstname() + student.getLastname());
		dataMap.put("Major_CN", "汉语言");
		dataMap.put("Major", "Chinese");
		
		Integer credit = 0;
		for (Transcript t : courses) {
			String overall = t.getOverall();
			if (Integer.parseInt(overall) >= 60) {
				credit += Integer.parseInt(t.getCredit());
			}
		}
		dataMap.put("Credit_CN", String.valueOf(credit));
		dataMap.put("Credit", String.valueOf(credit));
		
		dataMap.put("Level_CN", "本科");
		dataMap.put("Level", " Bachelor");
		
		String date[] = student.getStartdate().split("-");
		dataMap.put("Admission_CN",  String.format("%s年%s月", date[0], date[1]));
		dataMap.put("Admission", String.format("%s %s", months.get(Integer.parseInt(date[1]) - 1) ,date[0]));
		
		date = student.getEnddate().split("-");
		dataMap.put("Graduate_CN",  String.format("%s年%s月", date[0], date[1]));
		dataMap.put("Graduate", String.format("%s %s", months.get(Integer.parseInt(date[1]) - 1) ,date[0]));
		
		Set<String> semesterSet = new TreeSet<String>();
		
		for (Transcript t : courses) {
			semesterSet.add(t.getSemester());
		}
		String semesters[] = new String[semesterSet.size()];
		semesterSet.toArray(semesters);
		String semesterOrder[] = new String[semesters.length];
		semesterOrder[0] = semesters[0];
		int size = semesters.length;
		if (semesters.length % 2 == 0) {
			size--;
			semesterOrder[size] = semesters[size];
		}
	
		int offset = 1;
		for (int i = 1; i < size; ++i) {
			semesterOrder[i] = semesters[i + offset];
			if (offset > 0) {
				offset -= 2;
			} else {
				offset += 2;
			}
		}
		List<Map<String, Object>> dat = new ArrayList<Map<String,Object>>();	
		for (String semester : semesterOrder) {		
			Map<String, Object> row = new HashMap<String, Object>();
			row.put("semester", realSemester(semester));
			List<Transcript> script = new ArrayList<Transcript>();
			for (Transcript t : courses) {
				if (t.getSemester().equals(semester))
					script.add(t);
			}
			
			boolean empty = true;
			List<Map<String, Object>> sub = new ArrayList<Map<String,Object>>();
			for (Transcript t : script) {
				
				if (empty) {
					row.put("course1", t.getCourseName());
					row.put("score1", t.getOverall());
					row.put("credit1", t.getCredit());
					empty = false;
				} else {
					Map<String, Object> ssub = new HashMap<String, Object>();
					ssub.put("course", t.getCourseName());
					ssub.put("score", t.getOverall());
					ssub.put("credit", t.getCredit());
					sub.add(ssub);
				}
			}
			
		}
		
		dataMap.put("st", dat);
		
		Calendar cal = Calendar.getInstance();
		dataMap.put("year", cal.get(Calendar.YEAR));
		dataMap.put("month", cal.get(Calendar.MONTH) + 1);
		dataMap.put("day", cal.get(Calendar.DAY_OF_MONTH));
		
		DocUtil mdoc = new DocUtil();  
        try {
			mdoc.createDoc(dataMap, out, "transcript.flt");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
	}
	
	private String swap(String semester) {
		String ret = "";
		if (Integer.parseInt(semester) % 2 == 0) {
			ret = semester.substring(0, 4);
			ret += "01";
		} else {
			ret = semester.substring(0, 4);
			ret += "02";
		}
		return ret;
	}
	
	private String[] rightOrder (String semesters[]) {
		Set<String> order = new TreeSet<String>();
		for (String s : semesters) {
			order.add(swap(s));
		}
		String ret[] = new String [semesters.length];
		order.toArray(ret);
		return ret;
	}
	
	private String realSemester (String semester) {
		Integer s = Integer.parseInt(semester);
		int year = s / 100;
		int term = s - year * 100;
		if (term > 1) {
			return String.format("%d-%d-%d", year - 1, year, term);
		} else {
			return String.format("%d-%d-%d", year, year + 1, term);
		}
	}
	
	public void getPerTscript2(OutputStream out, Map<String, Object> info, Integer serial) {
		if (info.isEmpty()) {
			return;
		}
		Student student = (Student)info.get("Student");
		@SuppressWarnings("unchecked")
		List<Transcript> courses = (List<Transcript>) info.get("Courses");
		if (courses == null || courses.size() == 0){
			return;
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("Class_CN", student.getClasses().getClassname());
		dataMap.put("Class", student.getClasses().getClassname_en());
		dataMap.put("Name_CN", student.getStuname());  
		dataMap.put("Nationality_CN", student.getNation());
		if (nationality.containsKey(student.getNation())) {
			dataMap.put("Nationality", nationality.get(student.getNation()));
		} else {
			dataMap.put("Nationality", " ");
		}
		dataMap.put("Name", student.getFirstname() + " " + student.getLastname());
		
		String date[] = student.getStartdate().split("-");
		dataMap.put("Admission_CN",  String.format("%s年%s月", date[0], date[1]));
		dataMap.put("Admission", String.format("%s %s", months.get(Integer.parseInt(date[1]) - 1) ,date[0]));
		
		date = student.getEnddate().split("-");
		dataMap.put("Graduation_CN",  String.format("%s年%s月", date[0], date[1]));
		dataMap.put("Graduation", String.format("%s %s", months.get(Integer.parseInt(date[1]) - 1) ,date[0]));
		
		Set<String> semesterSet = new TreeSet<String>();
		
		for (Transcript t : courses) {
			semesterSet.add(t.getSemester());
		}

		String semesters[] = new String[semesterSet.size()];
		semesterSet.toArray(semesters);
		String semesterOrder[] = new String[semesters.length];
		if (semesterSet.size() == 2) {
			if (Integer.parseInt(semesters[0]) < Integer.parseInt(semesters[1])) {
				semesterOrder[0] = semesters[1];
				semesterOrder[1] = semesters[0];
			}
		} else {
			semesterOrder[0] = semesters[0];
			int size = semesters.length;
			if (semesters.length % 2 == 0) {
				size--;
				semesterOrder[size] = semesters[size];
			}
		
			int offset = 1;
			for (int i = 1; i < size; ++i) {
				semesterOrder[i] = semesters[i + offset];
				if (offset > 0) {
					offset -= 2;
				} else {
					offset += 2;
				}
			}
		}
		
		for (Transcript t : courses) {
			if (t.getAttendance() == null) {
				t.setAttendance(" ");
			} 
			if (t.getFinalexam() == null || t.getFinalexam().equals("null")) {
				t.setFinalexam(" ");
			} 
			if (t.getMidexam() == null || t.getMidexam().equals("null")) {
				t.setMidexam(" ");
			} 
			if (t.getOverall() == null || t.getOverall().equals("null") || t.getOverall().equals("0.0")) {
				t.setOverall(" ");
			}
			if (t.getHomework() == null || t.getHomework().equals("null")) {
				t.setHomework(" ");
			}
		}
		
		List<Map<String, Object>> dat = new ArrayList<Map<String,Object>>();	
		for (String semester : semesterOrder) {		
			Map<String, Object> row = new HashMap<String, Object>();
			row.put("Semester", realSemester(semester));
			List<Transcript> script = new ArrayList<Transcript>();
			for (Transcript t : courses) {
				if (t.getSemester().equals(semester))
					script.add(t);
			}
			boolean empty = true;
			List<Map<String, Object>> sub = new ArrayList<Map<String,Object>>();
			for (Transcript t : script) {
				
				if (empty) {
					row.put("course1", t.getCourseName_en());
					row.put("course1_CN", t.getCourseName());
					row.put("credit1", t.getCredit());
					row.put("attendence1", t.getAttendance());
					row.put("homework1", t.getHomework());
					row.put("midexam1", t.getMidexam());
					row.put("finalexam1", t.getFinalexam());
					row.put("summary1", t.getOverall());
					String credits = String.valueOf(Float.parseFloat(t.getCredit())*16);
					row.put("hours1", t.getCredit());
					empty = false;
				} else {
					Map<String, Object> ssub = new HashMap<String, Object>();
					ssub.put("course", t.getCourseName_en());
					ssub.put("course_CN", t.getCourseName());
					ssub.put("credit1", t.getCredit());
					ssub.put("attendence1", t.getAttendance());
					ssub.put("homework", t.getHomework());
					ssub.put("midexam", t.getMidexam());
					ssub.put("finalexam", t.getFinalexam());
					ssub.put("summary", t.getOverall());
					String credits = String.valueOf(Float.parseFloat(t.getCredit())*16);
					ssub.put("hours", credits);
					sub.add(ssub);
				}
				
			}
			row.put("sst", sub);
			dat.add(row);
		}
		
		dataMap.put("st", dat);
		
		Calendar cal = Calendar.getInstance();
		
		dataMap.put("Date_CN", String.format("%d年%d月%d日", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, 
				cal.get(Calendar.DAY_OF_MONTH)));
		
		dataMap.put("Date", String.format("%s %d %d", months.get(cal.get(Calendar.MONTH)), 
				cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.YEAR)));

		String semester = "";
		if (cal.get(Calendar.MONTH) < 9) {
			semester = "02";
		} else {
			semester = "01";
		}
		
		String n = "";
		if (serial < 10)
			n = "00" + String.valueOf(serial);
		else if (serial < 100)
			n = "0" + String.valueOf(serial);
		else
			n = String.valueOf(serial);
		
		dataMap.put("No", String.format("%d%s%s", cal.get(Calendar.YEAR), semester, n));
		DocUtil mdoc = new DocUtil();  
        try {
			mdoc.createDoc(dataMap, out, "transcript2.flt");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
	}
	
	
	@Override
	public void getLongLeave(OutputStream out, Student student, Leave apply, Integer serial) {
		Map<String, Object> data = leaveMap(student, apply, serial);
		DocUtil mdoc = new DocUtil();  
        try {
			mdoc.createDoc(data, out, "longLeave.flt");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void getShortLeave(OutputStream out, Student student, Leave apply, Integer serial) {
		Map<String, Object> data = leaveMap(student, apply, serial);
		DocUtil mdoc = new DocUtil();  
        try {
			mdoc.createDoc(data, out, "shortLeave.flt");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		
	}
	
	
	private Map<String, Object> leaveMap (Student student, Leave apply, Integer serial) {		
		Map<String, Object> dataMap = new HashMap<String, Object>();  
		String n = "";
		if (serial < 10)
			n = "00" + String.valueOf(serial);
		else if (serial < 100)
			n = "0" + String.valueOf(serial);
		else
			n = String.valueOf(serial);
		dataMap.put("No", n);
		dataMap.put("Major", student.getClasses().getMajor());
		dataMap.put("Class", student.getClasses().getClassname());
		dataMap.put("Name_CN", student.getStuname());  
		dataMap.put("Nationality", student.getNation());
		
		dataMap.put("Reason", apply.getLeavereason());
		dataMap.put("Name", student.getFirstname() + student.getLastname());
		dataMap.put("Phone", student.getTelephone());
		
		try {
			String d1[] = apply.getLeavingdate().split("-");
			String d2[] = apply.getBackdate().split("-");
			
			dataMap.put("syear", d1[0]);
			dataMap.put("smonth_CN", d1[1]);
			dataMap.put("sday", d1[2]);
			dataMap.put("eyear",d2[0]);
			dataMap.put("emonth_CN", d2[1]);
			dataMap.put("eday", d2[2]);
			
			Integer month = Integer.parseInt(d1[1]);
			Integer month2 = Integer.parseInt(d2[1]);
			
			dataMap.put("sdate", String.format("%s  %s  %s", d1[0], months.get(month - 1), d1[2]));
			dataMap.put("enddate", String.format("%s  %s  %s", d2[0], months.get(month2 - 1), d2[2]));
			
			DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			Date leaving = fmt.parse(apply.getLeavingdate());
			Date back = fmt.parse(apply.getBackdate());
			long diff = back.getTime() - leaving.getTime();
			dataMap.put("total", diff / 86400000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dataMap;
	}

	@Override
	public void getDiploma(OutputStream out, Student student, String serial) {
		Calendar cal = Calendar.getInstance();
		Map<String, Object> dataMap = new HashMap<String, Object>();  
		dataMap.put("major", student.getClasses().getMajor());
		dataMap.put("firstname", student.getFirstname().toUpperCase());
		dataMap.put("lastname", student.getLastname().toUpperCase());
		dataMap.put("schooltime", student.getDuration());
		dataMap.put("nation", student.getNation());
		String d1[] = student.getStartdate().split("-");
		String d2[] = student.getEnddate().split("-");
		String birth[] = student.getBrithdate().split("-");
		dataMap.put("birth_year", birth[0]);
		dataMap.put("serial", "100589" + String.valueOf(cal.get(Calendar.YEAR)) + "05000" + serial);
		dataMap.put("birth_month", birth[1]);
		dataMap.put("birth_day", birth[2]);
		dataMap.put("admission_year", d1[0]);
		dataMap.put("admission_month", d1[1]);
		dataMap.put("graduation_year", d2[0]);
		dataMap.put("graduation_month", d2[1]);
		dataMap.put("level", student.getStudyLevel());
		dataMap.put("this_year", String.valueOf(cal.get(Calendar.YEAR)));
		dataMap.put("this_month", cal.get(Calendar.MONTH) + 1);
		dataMap.put("this_day", cal.get(Calendar.DAY_OF_MONTH));
		DocUtil mdoc = new DocUtil();  
        try {
			mdoc.createDoc(dataMap, out, "diploma.flt");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 

	}

}
