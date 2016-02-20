package com.tjpu.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.Menu;
import com.tjpu.service.MenuService;
/**
 * @author ZhangChong
 *
 */
@Controller
public class MenuAction {
	@Autowired
	MenuService menuService;
	private Menu menu;
    private int id;
    private String ids;
	
    public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String menumanage() {
		String menulist = menuService.loadmenu();
		ActionContext.getContext().put("menulist", menulist);
		return "menulist";
	}
    public String menuupdate(){
    	menuService.menuupdate(menu,id);
    	return null;
    }
    public String menudelete(){
    	menuService.menudelete(menu.getId());
    	return null;
    }
    public String menubeginadd(){
    	List<Menu> menulist = menuService.loadfirstmenu();
		ActionContext.getContext().put("menulist", menulist);
    	return "menubeginadd";
    }
    public String menuendadd(){
    	menuService.menuadd(menu,id);
    	return null;
    }
    public String rolemenuupdate(){
    	menuService.rolemenuupdate(ids, id);
    	return null;
    }
	
}
