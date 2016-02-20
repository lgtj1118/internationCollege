package com.tjpu.service;

import java.util.List;

import com.tjpu.bean.Menu;

public interface MenuService {

	public String loadmenu();

	public void menuupdate(Menu menu, int id);

	public void menudelete(Integer id);

	public List<Menu> loadfirstmenu();

	public void menuadd(Menu menu, int id);

	public List<Menu> rolemenu(Integer id);

	public List<Menu> loadmenulist();

	public void rolemenuupdate(String ids, int id);

}
