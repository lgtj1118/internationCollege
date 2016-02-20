package com.tjpu.test.unitTest;

import java.util.Calendar;
import java.util.Date;

public class SemesterGeneraterTest {
	public String getCurrSemester (){
		Calendar now = Calendar.getInstance();
		String year = String.valueOf(now.get(Calendar.YEAR));
		int month = now.get(Calendar.MONTH) + 1;
		if (month > 9)
			return year + "01";
		else
			return year + "02";
	}
	
	public static void main(String[] args) {
		System.out.println(new Date().toString());
	}
}
