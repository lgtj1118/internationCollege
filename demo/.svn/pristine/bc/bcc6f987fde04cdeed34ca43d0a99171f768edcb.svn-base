package com.tjpu.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tjpu.service.DocUtil;

public class Diploma {
	public static void main(String[] args) {
		Map<String, Object> dataMap = new HashMap<String, Object>();  
        
		dataMap.put("firstname", "SIYU");
		
		dataMap.put("lastname", "LI");
		
		dataMap.put("nation", "中国");
		
		dataMap.put("birth_year", "1992");
		
		dataMap.put("birth_month", 7);
		
		dataMap.put("birth_day", 7);
		
		dataMap.put("admission_year", "2014");
		
		dataMap.put("admission_month", 9);
		
		dataMap.put("graduation_year", "2017");
		
		dataMap.put("graduation_month", 6);
		
		dataMap.put("major", "汉语言");
		
		dataMap.put("schooltime", "四");
		
		dataMap.put("level", "本");
		
		dataMap.put("this_year", "2015");
		
		dataMap.put("this_month", 7);
		
		dataMap.put("this_day", 28);
		
		
		
		
		DocUtil mdoc = new DocUtil();  
        try {
			mdoc.createDoc(dataMap, "E:/outFile.doc", "diploma.flt");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
	}
}
