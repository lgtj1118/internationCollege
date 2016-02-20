package com.tjpu.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nav entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "nav")
public class Menu implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String namenav;
	private String enname;
	private Menu menu;
	private String menuurl;
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Menu> menus = new HashSet<Menu>(0);
	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** full constructor */
	public Menu(String namenav, String enname, Menu menu ,Set<Role> roles, String menuurl, Set<Menu> menus) {
		this.namenav = namenav;
		this.enname = enname;
		this.menu = menu;
		this.roles = roles;
		this.menuurl = menuurl;
		this.menus = menus;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_nav", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name_nav")
	public String getNamenav() {
		return this.namenav;
	}

	public void setNamenav(String namenav) {
		this.namenav = namenav;
	}

	@Column(name = "enname_nav")
	public String getEnname() {
		return this.enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_nav")
	public Menu getMenu() {
		return this.menu;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menu")
	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menus")
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Column(name = "menuurl")
	public String getMenuurl() {
		return this.menuurl;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}

}