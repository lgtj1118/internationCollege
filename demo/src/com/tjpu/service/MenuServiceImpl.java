package com.tjpu.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tjpu.bean.Menu;
import com.tjpu.bean.Role;
import com.tjpu.dao.UserDao;
@Service
public class MenuServiceImpl implements MenuService {
@Autowired
UserDao userDao;
	@Override
	public String loadmenu() {
		 
		//List<Menu> menu = userDao.loadmenu();
		List<Menu> firstmenu = userDao.loadfirstmenu();
		String menulist = "";
		int p= 1;
		for (int i = 0; i < firstmenu.size(); i++) {
			String str =  "{\"id\": "+firstmenu.get(i).getId()+","+"\"name\":"+"\""+firstmenu.get(i).getNamenav()+"\","+"\"enname\":"+"\""+firstmenu.get(i).getEnname()+"\","+"\"parentnav\":"+"\""+firstmenu.get(i).getMenu().getId()+"\","+"\"menuurl\":"+"\""+" "+"\"";//firstmenu.get(i).getMenuurl()
			List<Menu> secondmenu = userDao.loadsecondmenu(firstmenu.get(i).getId());
			if (secondmenu.size()!=0) {
				int q = 1;
				str += ", children:[";
				for (int j = 0; j < secondmenu.size(); j++) {
					String str1= "{\"id\": "+ secondmenu.get(j).getId()+","+"\"name\":"+"\""+secondmenu.get(j).getNamenav()+"\","+"\"enname\":"+"\""+secondmenu.get(j).getEnname()+"\","+"\"parentnav\":"+"\""+secondmenu.get(j).getMenu().getId()+"\","+"\"menuurl\":"+"\""+secondmenu.get(j).getMenuurl()+"\"}";										
				    if (q<secondmenu.size()) {
						str += str1+",";
					}else {
						str += str1+"]}";
					}
				    q++;
				}
			}else {
				str = str + "}";
			}
			if (p< firstmenu.size()) {
				menulist = menulist + str +",";
			}else {
				menulist = menulist+str;
			}
			p++;
		}
		return menulist;
	}
	@Override
	public void menuupdate(Menu menu,int id) {
		 
		String name = null;
		String enname = null;
		String menuurl = null;
		try {
			name = java.net.URLDecoder.decode(menu.getNamenav(),"UTF-8");
			enname = java.net.URLDecoder.decode(menu.getEnname(),"UTF-8");
			menuurl = java.net.URLDecoder.decode(menu.getMenuurl(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			 
			e.printStackTrace();
		}
		
		Menu menu1 = userDao.loadmenubyid(id);
		menu.setEnname(enname);
        if (id==1) {
        	menu.setMenuurl(null);
		}else {
			menu.setMenuurl(menuurl);
		}		
		menu.setNamenav(name);
        menu.setMenu(menu1);
		userDao.menuupdate(menu);
	}
	@Override
	public void menudelete(Integer id) {
		 
		Menu menu1 = userDao.loadmenubyid(id);
		List<Role> roles = userDao.loadrolesbymenuid(id);				
		// System.out.println("父节点："+menu1.getMenu().getId());
		Integer parentnav = menu1.getMenu().getId();
		if (parentnav == 1) { // 一级菜单，先删除下属二级菜单,删除角色二级和一级菜单
			List<Menu> secondmenu = userDao.loadsecondmenu(id);
			// System.out.println("二级菜单："+secondmenu.size());
			for (Role r : roles) {
				List<Menu> menulist = userDao.loadrolemenu(r.getId());
				Set<Menu> menuset = new HashSet<Menu>();
				for (Menu i : menulist) {
					menuset.add(i);
				}
				// System.out.println(menuset.size());
				menuset.remove(menu1);
				for (Menu m : secondmenu) {
					menuset.remove(m);
				}
				// System.out.println(menuset.size());
				userDao.updaterolemenu(menuset, r.getId());
			}
			for (Menu m : secondmenu) {
				m.getRoles().clear();
				m.setMenu(null);
				m.getMenus().clear();
				userDao.menudelete(m);
			}// 删除一级菜单
			menu1.getRoles().clear();
			menu1.setMenu(null);
			menu1.getMenus().clear();		
			userDao.menudelete(menu1);
		}else {//如果是二级菜单，直接删除菜单
			//System.out.println("二级菜单情况：");
			for(Role r:roles){
				List<Menu> menulist = userDao.loadrolemenu(r.getId());
				Set<Menu> menuset = new HashSet<Menu>();
				for (Menu i : menulist) {
					menuset.add(i);
				}
				//System.out.println(menuset.size());
				menuset.remove(menu1);				
				//System.out.println(menuset.size());			
		        userDao.updaterolemenu(menuset, r.getId());
			}
			menu1.getRoles().clear();
			menu1.setMenu(null);
			menu1.getMenus().clear();		
			userDao.menudelete(menu1);
		}
		
	
	}
	@Override
	public List<Menu> loadfirstmenu() {
		 
      List<Menu> menus = userDao.loadfirstmenu();
      return menus;
	}
	@Override
	public void menuadd(Menu menu,int id) {
		 
		String name = null;
		String enname = null;
		String menuurl = null;
		try {
			name = java.net.URLDecoder.decode(menu.getNamenav(),"UTF-8");
			enname = java.net.URLDecoder.decode(menu.getEnname(),"UTF-8");
			menuurl = java.net.URLDecoder.decode(menu.getMenuurl(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			 
			e.printStackTrace();
		}
		Menu menu1 = userDao.loadmenubyid(id);
		Menu menu2 = new Menu();
		menu2.setEnname(enname);
		if (id==1) {
        	menu2.setMenuurl(null);
		}else {
			menu2.setMenuurl(menuurl);
		}
		menu2.setNamenav(name);
		menu2.setMenu(menu1);
		userDao.menuadd(menu2);
	}
	@Override
	public List<Menu> rolemenu(Integer id) {
		 
		//Role role = userDao.loadrolebyid(id);
		List<Menu> rolemenulist = userDao.loadrolemenu(id);
		return rolemenulist;
	}
	List<Menu> menulist = new ArrayList<Menu>();
	@Override
	public List<Menu> loadmenulist() {
		 
		int menuid = 1;
		Menu menu = userDao.loadmenubyid(menuid);
		menulist.clear();
		loadmenu(menu);
		return menulist;
	}

	public void loadmenu(Menu menu) {
		menulist.add(menu);
		for (Menu m : menu.getMenus()) {
			loadmenu(m);
		}
	}
	@Override
	public void rolemenuupdate(String ids, int id) {
		 
		StringTokenizer menuids = new StringTokenizer(ids, ";");
		List<Integer> idsint = new ArrayList<Integer>();
		while (menuids.hasMoreTokens()) {
			String p = menuids.nextToken();
			if (!p.equals("1")) {
				idsint.add(Integer.parseInt(p));
			}
		}
		Set<Menu> menuset = new HashSet<Menu>();
		for (Integer i : idsint) {
			menuset.add(userDao.loadmenubyid(i));
		}
		userDao.updaterolemenu(menuset, id);
	}
}
