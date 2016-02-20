package com.tjpu.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.tjpu.service.DocUtil;


public class OtherTest {
	public static void main(String[] args) {
		Map<String, Object> dataMap = new HashMap<String, Object>();  
        
		dataMap.put("Name_CN", "李思宇");  
        
		dataMap.put("Nationality_CN", "中国");
		
		dataMap.put("Nationality", "China");
		
		dataMap.put("Passport", "C1431136013");
		
		dataMap.put("Name", "Li Siyu");
		
		dataMap.put("Major_CN", "计算机");
		
		dataMap.put("Major", "Computer science");
		
		dataMap.put("Credit_CN", "360");
		
		dataMap.put("Credit", "360");
		
		dataMap.put("Level_CN", "硕士研究生");
		
		dataMap.put("Level", "Master");
		
		dataMap.put("Admission_CN","2015年9月");
		
		dataMap.put("Graduate_CN", "2017年4月");
		
		dataMap.put("Admission", "September 2015");
		
		dataMap.put("Graduate", "April 2017");
		
		List<Map<String, Object>> dat = new ArrayList<Map<String,Object>>();
		
		for (int j = 0; j < 2; ++j) {
			Map<String, Object> row = new HashMap<String, Object>();
			row.put("semester", "semester" + j);
			
			boolean empty = true;
			List<Map<String, Object>> sub = new ArrayList<Map<String,Object>>();
			for (int i = 1; i < 5; ++i){
				if (empty) {
					row.put("course1", "course1");
					row.put("score1", "99");
					row.put("credit1", "4");
					empty = false;
				} else {
					Map<String, Object> ssub = new HashMap<String, Object>();
					ssub.put("course", "course" + i);
					ssub.put("score", "98");	
					ssub.put("credit", "4");
					sub.add(ssub);
				}
			}
			row.put("sst", sub);
			dat.add(row);
		}
		
		dataMap.put("st", dat);
		dataMap.put("year", "2015");
		
		dataMap.put("month", "7");
		
		dataMap.put("day", "26");
		
		
		DocUtil mdoc = new DocUtil();  
        try {
			mdoc.createDoc(dataMap, "E:/outFile.doc", "transcript.flt");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  

	}

}
