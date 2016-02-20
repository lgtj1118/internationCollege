package com.tjpu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.base.Function;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.Announcement;
import com.tjpu.bean.Dept;
import com.tjpu.bean.Links;
import com.tjpu.bean.Menu;
import com.tjpu.bean.PageBean;
import com.tjpu.bean.Role;
import com.tjpu.bean.Teacher;
import com.tjpu.bean.User;
import com.tjpu.service.ManageService;
import com.tjpu.service.MenuService;
import com.tjpu.service.UserService;

@Controller
public class UserAction {
	@Autowired
	UserService userService;
	@Autowired
	MenuService menuService;
	@Autowired
	ManageService manageService;
	private int deid;
	private String ids;
	private int roles;
	private Role role;
	private Dept dept;
    private Links links;
    private PageBean pageBean;
	private int page=1;
	private int pageSize = 20;
    private String fuzzyText;
    private Announcement announcement;
	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public int getRoles() {
		return roles;
	}

	public void setRoles(int roles) {
		this.roles = roles;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getDeid() {
		return deid;
	}

	public void setDeid(int deid) {
		this.deid = deid;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	private void datatojson(Map<String, Object> map) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		Gson gson = new Gson();
		String json = gson.toJson(map);
		// System.out.print(json);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
	}

	public String usercheck() {
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = userService.usercheck(user.getUsername());
		if (!flg) {
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("fail");
				out.flush();
				out.close();
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
		}
		return null;
	}
 
	public String deptcheckteacher(){
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String identificationnum = request.getParameter("identificationnum");
		String newdeptid = request.getParameter("newdeptid");
		String teachername = dept.getDeptresponsible();
		Teacher teacher = manageService.loadteacherbynum(identificationnum);
		Dept flg = userService.deptteachercheck(dept.getDeptid());
		String deptid = String.valueOf(dept.getDeptid());
		if(newdeptid.equals(deptid)){
			return null;
		}else {
			if (teacher.getTeachername().equals(flg.getDeptresponsible())) {
				try {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("fail");
					out.flush();
					out.close();
				} catch (IOException e) {
					 
					e.printStackTrace();
				}
			}				
			return null;
		}
		
	}
	
	public String useradd() {
		userService.useradd(user, deid, roles);
		return null;
	}

	public String loginOut() {
		ActionContext.getContext().getSession().put("user", null);
		return "success";
	}

	public String changepwd() {
		ActionContext.getContext().put("userid", user.getId());
		return "changepwd";
	}

	public String pwdcheck() {
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = userService.pwdcheck(user.getId(), user.getPassword());
		if (!flg) {
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("fail");
				out.flush();
				out.close();
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
		}
		return null;
	}

	public String userchangepwd() {
		userService.userchangpwd(user);
		return null;
	}

	public String usermanage() {
		String deptlist = userService.deptlist();
		ActionContext.getContext().put("deptlist", deptlist);
		String rolelist = userService.rolelist();
		ActionContext.getContext().put("rolelist", rolelist);
		return "userlist";
	}

	public String userlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = userService.usermap(page, pageSize);
		datatojson(map);
		return null;
	}
    
	public String useredit(){
		User users = userService.loaduserbyid(user.getId());
		ActionContext.getContext().put("users", users);
		ActionContext.getContext().put("deptid", deid);
		List<Dept> deptlist = userService.deptlist1();
		ActionContext.getContext().put("deptlist", deptlist);
		return "useredit";
	}
	public String userupdate() {
		userService.userupdate(user, deid);
		return null;
	}

	public String userdelete() {
		userService.userdelete(ids);
		return null;
	}

	public String userbeginadd() {
		List<Dept> deptlist = userService.deptlist1();
		ActionContext.getContext().put("deptlist", deptlist);
		return "useradd";
	}

	public String userendadd() {
		userService.useradd(user, deid, roles);
		return null;
	}

	public String usercheck1() {
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = userService.usercheck1(user.getUsernum());
		if (!flg) {
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("fail");
				out.flush();
				out.close();
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
		}
		return null;
	}
	public String usercheck1again() {
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = userService.usercheck1(user.getUsernum());
		if (!flg) {
			List<User> users = userService.loaduser(user.getId(),user.getUsernum());
			if (users.size()>0) {
				return null;
			}else {
				try {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("fail");
					out.flush();
					out.close();
				} catch (IOException e) {
					 
					e.printStackTrace();
				}
			}
			
		}
		return null;
	}

	public String userpermissions() {
		return "rolelist";
	}

	public String rolelist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));
		Map<String, Object> map = userService.rolemap(page, pageSize);
		datatojson(map);
		return null;
	}

	public String roleupdate() {
		userService.roleupdate(role);
		return null;
	}

	public String roledelete() {
		userService.roledelete(ids);
		return null;
	}

	public String rolebeginadd() {
		return "roleadd";
	}

	public String rolecheck() {
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = userService.rolecheck(role.getRolename());
		if (!flg) {
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("fail");
				out.flush();
				out.close();
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
		}
		return null;
	}

	public String roleendadd() {
		userService.roleadd(role);
		return null;
	}

	public String rolemenu() {
		List<Menu> rolemenulist = menuService.rolemenu(role.getRolerank());
		ActionContext.getContext().put("roleid", role.getId());
		ActionContext.getContext().put("rolemenu", rolemenulist);
		List<Menu> menulist = menuService.loadmenulist();
		ActionContext.getContext().put("menulist", menulist);
		return "rolemenu";
	}
   public String systemlog(){
	   return "systemlog";
   }
   
   public String fuzzyLog () {
	   if (fuzzyText == null)
		   return null;
	   try {
		   fuzzyText = java.net.URLDecoder.decode(fuzzyText, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	   HttpServletRequest request = ServletActionContext.getRequest();
	   int page = Integer.parseInt(request.getParameter("page"));
	   int pageSize = Integer.parseInt(request.getParameter("pagesize"));
	   datatojson(userService.fuzzyLogs(fuzzyText, page, pageSize));
	   return null;
   }
   
   public String printSystemLog () {
	   HttpServletRequest request = ServletActionContext.getRequest();
	   int page = Integer.parseInt(request.getParameter("page"));
	   int pageSize = Integer.parseInt(request.getParameter("pagesize"));	
	   datatojson(userService.loadSystemlogs(page, pageSize));
	   return null;
   }
   
   public String announcement(){
	   return "announcement";
   }
   public String departmentmanagement(){
	String deptlist = userService.deptlist();
	ActionContext.getContext().put("deptlist", deptlist);
	return "departmanage";
	}
   public String deptlist(){
	   HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));		
		Map<String, Object> map =userService.loaddeptmap(page, pageSize);		
		datatojson(map);
		return null;
   }
   public String deptupdate(){
	   userService.deptupdate(dept);
	   return null;
   }
   public String deptdelete(){
	   userService.deptdelete(ids);
	   return null;
   }
   public String deptbegainadd(){
	   return "deptadd";
   }
   public String deptendadd(){
	   userService.deptadd(dept);
	   return null;
   }
   public String deptcheck(){
	   HttpServletResponse response = ServletActionContext.getResponse();
		String deptname = null;
		try {
			deptname = java.net.URLDecoder.decode(dept.getDeptname(),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   boolean flg = userService.deptcheck(deptname);
		if (!flg) {
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("fail");
				out.flush();
				out.close();
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
		}
		return null;
   }
   
   public String deptcheckagain(){
	   HttpServletResponse response = ServletActionContext.getResponse();
		String deptname = null;
		try {
			deptname = java.net.URLDecoder.decode(dept.getDeptname(),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   Dept depts = userService.loaddeptbyid(dept.getDeptid());
	   if (depts.getDeptname().equals(deptname)) {
		return null ;
	   }else {
		   boolean flg = userService.deptcheck(deptname);
			if (!flg) {
				try {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("fail");
					out.flush();
					out.close();
				} catch (IOException e) {
					 
					e.printStackTrace();
				}
			}
			
	   }
	   return null;
   }
   public String deptmember(){
	   String  teacherlist = userService.loaddeptmember(dept.getDeptid());
	   ActionContext.getContext().put("teacherlist", teacherlist);
	   ActionContext.getContext().put("deptid", dept.getDeptid());
	   return "departmembers";
   }
   public String deptmemberlist(){
	    HttpServletRequest request = ServletActionContext.getRequest();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pagesize"));		
		Map<String, Object> map =userService.deptmembermap(page, pageSize);		
		datatojson(map);
		return null;
   }
   public String commonlinks(){
	   String linkslist = userService.linkslist();
	   ActionContext.getContext().put("linkslist", linkslist);
	   return "commonlinks";
   }
   public String linksbegainadd(){
	   return "linksadd";
   }
   public String linksendadd(){
	   userService.linksadd(links);
	   return null;
   }
   public String linksupdate(){
	   userService.linksupdate(links);
	   return null;
   }
   public String linksdelete(){
	   userService.linksdelete(links.getId());
	   return null;
   }
   public String linkscheck(){
	   HttpServletResponse response = ServletActionContext.getResponse();
		boolean flg = userService.linkscheck(links.getTitle());
		if (!flg) {
			try {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("fail");
				out.flush();
				out.close();
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
		}
		return null;
   }
   public String hellolinks(){
	   List<Links> linklist = userService.loadlinks();
	   ActionContext.getContext().put("link", linklist);
	   return "hellolinks";
   }
   public String announcementlist(){
	   List<Announcement> announcementlists = manageService.announcementlist();
	   ActionContext.getContext().put("announcementlist", announcementlists);
	   return "helloannouncement";
   }
   public String moreannouncementlist(){
	   //List<Announcement> announcementlists = manageService.announcementlist();
	   //ActionContext.getContext().put("announcementlist", announcementlists);
	   this.pageBean = manageService.loadallannouncement(page,pageSize);
	   return "moreannouncement";	   
   }
   public String announcementdetail(){
	   Announcement announce = manageService.loadannouncement(announcement.getId());
	   ActionContext.getContext().put("announcements", announce);
	   return "announcementdetail";
   }
   public String searchResponsible(){
	   HttpServletResponse response = ServletActionContext.getResponse();
	   HttpServletRequest request = ServletActionContext.getRequest();
	   String teacherid = request.getParameter("teacherid");
	   Dept depts = userService.loaddeptresponsible(dept.getDeptid());
	   
	   Teacher teacher = manageService.loadteacherbynum(teacherid);
	   try {
		    response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
		    String info ="";
			if(depts.getDeptresponsible()==teacher.getTeachername()){
			   info = "该教师已经是   "+depts.getDeptname()+" 负责人";
		    }else {
			   info = "该部门已设置  "+depts.getDeptresponsible()+"为负责人，是否重新设置？";
		    }			
			out.print(info);
			out.flush();
			out.close();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
	   
	   return null;
   }
   public String setResponsible(){
	   HttpServletRequest request = ServletActionContext.getRequest();
	   String teacherid = request.getParameter("teacherid");
	   Teacher teacher = manageService.loadteacherbynum(teacherid);
	   userService.updatedept(dept.getDeptid(),teacher.getTeachername());
	   return null;
   }

public String getFuzzyText() {
	return fuzzyText;
}

public void setFuzzyText(String fuzzyText) {
	this.fuzzyText = fuzzyText;
}

public PageBean getPageBean() {
	return pageBean;
}

public void setPageBean(PageBean pageBean) {
	this.pageBean = pageBean;
}

public int getPageSize() {
	return pageSize;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public int getPage() {
	return page;
}

public void setPage(int page) {
	this.page = page;
}
}
