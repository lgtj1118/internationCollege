package com.tjpu.service;

import java.util.List;
import java.util.Map;

import com.tjpu.bean.Dept;
import com.tjpu.bean.Links;
import com.tjpu.bean.Menu;
import com.tjpu.bean.Role;
import com.tjpu.bean.User;

public interface UserService {
	
	public Map<String, Object> fuzzyLogs (String keyword, int page, int PageSize);
	
	public Map<String, Object> loadSystemlogs (int page, int pageSize);

 	public User loginService(User user);

	public boolean usercheck(String username);

	public void useradd(User user, int deptid, int roles);

	public String deptlist();

	public Map<String, Object> usermap(int page, int pageSize);

	public void userupdate(User user, int deptid);

	public void userdelete(String ids);

	public List<Dept> deptlist1();

	public boolean usercheck1(String usernum);

	public void roleadd(Role role);

	public void roledelete(String ids);

	public void roleupdate(Role role);

	public Map<String, Object> rolemap(int page, int pageSize);

	public boolean rolecheck(String rolename);

	public String rolelist();

	public boolean pwdcheck(Integer id, String password);

	public void userchangpwd(User user);

	public Role loadrolebyid(Integer id);

	public Map<String, List<Menu>> menuMap(Integer id, User user);

	public void deptupdate(Dept dept);

	public void deptdelete(String ids);

	public void deptadd(Dept dept);

	public boolean deptcheck(String deptname);

	public String loaddeptmember(Integer deptid);

	public String linkslist();

	public void linksadd(Links links);

	public void linksupdate(Links links);

	public void linksdelete(Integer id);

	public boolean linkscheck(String title);

	public List<Links> loadlinks();

	public Dept loaddeptbyid(Integer deptid);

	public User loaduserbyid(Integer id);

	public List<User> loaduser(Integer id, String usernum);

	public Dept loaddeptresponsible(Integer deptid);

	public void updatedept(Integer deptid, String teachername);

	public Map<String, Object> loaddeptmap(int page, int pageSize);

	public Map<String, Object> deptmembermap(int page, int pageSize);

	public Dept deptteachercheck(Integer deptid);

	public Dept loaddeptbyresponsible(String teachername);

	

}
