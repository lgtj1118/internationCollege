package com.tjpu.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tjpu.service.DocUtil;

public class Transcript2Test {
	public static void main(String[] args) {
		Map<String, Object> dataMap = new HashMap<String, Object>();  
        
		dataMap.put("No", "1431136013");
		
		dataMap.put("Class_CN", "计算机");
		
		dataMap.put("Class", "Computer science");
		
		dataMap.put("Name_CN", "李思宇");  
        
		dataMap.put("Nationality_CN", "中国");
		
		dataMap.put("Nationality", "China");
		
		dataMap.put("Name", "Li Siyu");
		
		dataMap.put("Admission_CN","2015年9月");
		
		dataMap.put("Graduation_CN", "2017年4月");
		
		dataMap.put("Admission", "September 2015");
		
		dataMap.put("Graduation", "April 2017");
		
		List<Map<String, Object>> dat = new ArrayList<Map<String,Object>>();
		Integer t = 19;
		for (int j = 0; j < 2; ++j) {
			Map<String, Object> row = new HashMap<String, Object>();
			row.put("Semester", "semester" + j);
			
			boolean empty = true;
			List<Map<String, Object>> sub = new ArrayList<Map<String,Object>>();
			for (int i = 1; i < 5; ++i){
				if (empty) {
					row.put("course1", "Lesson");
					row.put("course1_CN", "课程");
					row.put("credit1", "4");
					row.put("attendence1", "10");
					row.put("homework1", "10");
					row.put("midexam1", "10");
					row.put("finalexam1", "10");
					row.put("summary1", "10");
					row.put("credit1", "4");
					row.put("hours1", t);
					empty = false;
				} else {
					Map<String, Object> ssub = new HashMap<String, Object>();
					ssub.put("course", "Lesson");
					ssub.put("course_CN", "课程");
					ssub.put("credit", "4");
					ssub.put("attendence1", "10");
					ssub.put("homework", "10");
					ssub.put("credit1", "4");
					ssub.put("midexam", "10");
					ssub.put("finalexam", "10");
					ssub.put("summary", "10");
					ssub.put("hours", "60");
					sub.add(ssub);
				}
			}
			row.put("sst", sub);
			dat.add(row);
		}
		dataMap.put("st", dat);
		
		dataMap.put("Date_CN", "2015年7月26日");
		
		dataMap.put("Date", "July 26 2015");
		
		
		DocUtil mdoc = new DocUtil();  
        try {
			mdoc.createDoc(dataMap, "E:/outFile.doc", "transcript2.flt");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  

	}
}
