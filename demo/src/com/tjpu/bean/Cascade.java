package com.tjpu.bean;

import java.util.List;

public class Cascade {
	private String v;
	private String n;
	private List<Cascade> s;
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public List<Cascade> getS() {
		return s;
	}
	public void setS(List<Cascade> s) {
		this.s = s;
	}		
}
