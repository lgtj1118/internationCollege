package com.tjpu.test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.tjpu.service.DocUtil;

public class Leave {
	public static void main(String[] args) {
		Map<String, Object> dataMap = new HashMap<String, Object>();  
        
		dataMap.put("No", "0001");
		
		dataMap.put("Major", "计算机");
		
		dataMap.put("Class", "Computer science");
		
		dataMap.put("Name_CN", "李思宇");  
        
		dataMap.put("Nationality_CN", "中国");
		
		dataMap.put("Nationality", "China");
		
		dataMap.put("Reason", "Reason1");
		
		dataMap.put("Name", "Li Siyu");
		
		dataMap.put("Phone", "15922162256");
		
		
		dataMap.put("syear","2015");
		dataMap.put("smonth_CN","7");
		dataMap.put("sday","26");
		
		
		dataMap.put("eyear","2015");
		dataMap.put("emonth_CN","7");
		dataMap.put("eday","26");
		
		dataMap.put("total", 7);
		
		dataMap.put("sdate", "2015   July   11");
		
		dataMap.put("enddate", "2016   July   11");
		
		
		DocUtil mdoc = new DocUtil();  
        try {
			mdoc.createDoc(dataMap, "E:/outFile.doc", "longLeave.flt");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
	}
}
