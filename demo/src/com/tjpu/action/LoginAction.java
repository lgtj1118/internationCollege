package com.tjpu.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.Menu;
import com.tjpu.bean.Role;
import com.tjpu.bean.Student;
import com.tjpu.bean.Teacher;
import com.tjpu.bean.User;
import com.tjpu.service.ManageService;
import com.tjpu.service.StudentService;
import com.tjpu.service.UserService;
/**
 * @author ZhangChong
 *
 */
@Controller
public class LoginAction {
	@Autowired
	UserService userService;
	@Autowired
	StudentService studentService;
	@Autowired
	ManageService manageService;
	private User user;
	private Role role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String execute() throws Exception {
		 
		if (user == null) {
			ActionContext.getContext().put("message", "您输入的用户名或密码错误！");
			return "loginfail";
		} else {
			if (user.getRoles().getRolerank()==3) {//学生登录
				Student student = studentService.loginService(user.getUsernum(), user.getPassword());
				Role roles = userService.loadrolebyid(user.getRoles().getRolerank());
				user = null;
				if (student != null) {
					User users = new User();
					users.setRealname(student.getStuname());
					users.setRoles(roles);
					users.setUsernum(student.getPassport());
					users.setId(student.getId());
					Calendar calendar = Calendar.getInstance();
					String permit =student.getValidResidencePermit();
					SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
					Date permitDate = sdf.parse(permit);
					Date nowdate = new Date();
					calendar.setTime(permitDate);
                    int day1 = calendar.get(Calendar.DAY_OF_YEAR);
                    calendar.setTime(nowdate);
                    int day2 = calendar.get(Calendar.DAY_OF_YEAR);
                    int day = day2-day1;
                    Map<String, List<Menu>> map = userService.menuMap(roles.getRolerank(),users);					
					ActionContext.getContext().put("map", map);
					ActionContext.getContext().put("perday", day);
					ActionContext.getContext().getSession().put("user", users);	
					
					return "loginsuc";
				} else {
					ActionContext.getContext().put("message", "您输入的用户名或密码错误！");
					return "loginfail";
				}
			}else if ((user.getRoles().getRolerank()==2)) {//教师登录
				//Integer type = 1;
				Teacher teacher = manageService.loginService(user.getUsernum(), user.getPassword()/*,type*/);				
				user = null;
				if (teacher != null) {
					User users = new User();
					boolean flag = manageService.isclassteacher(teacher.getIdentificationnum());					
					Role roles = new Role();
					if (flag) {
						roles = userService.loadrolebyid(2);//班主任
					}else {
						roles = userService.loadrolebyid(4);//任课教师
					}
					users.setRealname(teacher.getTeachername());
					users.setRoles(roles);
					users.setUsernum(teacher.getIdentificationnum());
					users.setId(teacher.getId());	
					int day = -999;
					Map<String, List<Menu>> map = userService.menuMap(roles.getRolerank(),users);					
					ActionContext.getContext().put("map", map);
					ActionContext.getContext().put("perday", day);
					ActionContext.getContext().getSession().put("user", users);					
					return "loginsuc";
				} else {
					ActionContext.getContext().put("message", "您输入的用户名或密码错误！");
					return "loginfail";
				}
			}/*else if ((user.getRoles().getId()==4)) {//班主任登录
				Integer type = 0;
				Teacher teacher = manageService.loginService(user.getUsernum(), user.getPassword(),type);				
				Role roles = userService.loadrolebyid(user.getRoles().getId());
				user = null;
				if (teacher != null) {
					User users = new User();
					boolean flag = manageService.isclassteacher(teacher.getIdentificationnum());					
					if (flag) {
						roles.setRoledescribe("班主任");
					}else {
						roles.setRoledescribe("任课教师");
					}
					users.setRealname(teacher.getTeachername());
					users.setRoles(roles);
					users.setUsernum(teacher.getIdentificationnum());
					users.setId(teacher.getId());			
					Map<String, List<Menu>> map = userService.menuMap(roles.getId());					
					ActionContext.getContext().put("map", map);
					ActionContext.getContext().getSession().put("user", users);					
					return "loginsuc";
				} else {
					ActionContext.getContext().put("message", "您输入的用户名或密码错误！");
					return "loginfail";
				}
			}*/
			else{
				User u = userService.loginService(user);				
				user = null;
				if (u != null) {
					int day = -999;
                    Map<String, List<Menu>> map = userService.menuMap(u.getRoles().getRolerank(),u);					
					ActionContext.getContext().put("map", map);
					ActionContext.getContext().put("perday", day);
					ActionContext.getContext().getSession().put("user", u);
					return "loginsuc";
				} else {
					ActionContext.getContext().put("message", "您输入的用户名或密码错误！");
					return "loginfail";
				}
			}
							
		}
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
