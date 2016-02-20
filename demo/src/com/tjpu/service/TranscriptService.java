package com.tjpu.service;

import java.io.OutputStream;
import java.util.Map;

import com.tjpu.bean.Leave;
import com.tjpu.bean.Student;

public interface TranscriptService {
	public void getPerTscript (OutputStream out,  Map<String, Object> info);
	public void getPerTscript2 (OutputStream out, Map<String, Object> info, Integer serial);
	public void getLongLeave (OutputStream out, Student student, Leave apply, Integer serial);
	public void getShortLeave (OutputStream out, Student student, Leave apply, Integer serial);
	public void getDiploma (OutputStream out, Student student, String serial);
}
