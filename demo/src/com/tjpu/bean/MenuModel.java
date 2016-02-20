package com.tjpu.bean;

public class MenuModel  {

	private Integer idNav;
	private String nameNav;
	private String ennameNav;
	private Integer parentNav;
	private String menuurl;

	
	public Integer getIdNav() {
		return this.idNav;
	}

	public void setIdNav(Integer idNav) {
		this.idNav = idNav;
	}

	
	public String getNameNav() {
		return this.nameNav;
	}

	public void setNameNav(String nameNav) {
		this.nameNav = nameNav;
	}

	
	public String getEnnameNav() {
		return this.ennameNav;
	}

	public void setEnnameNav(String ennameNav) {
		this.ennameNav = ennameNav;
	}

	
	public Integer getParentNav() {
		return this.parentNav;
	}

	public void setParentNav(Integer parentNav) {
		this.parentNav = parentNav;
	}

	
	public String getMenuurl() {
		return this.menuurl;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}

}