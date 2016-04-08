package com.tjpu.dao;

import java.util.List;
import java.util.Set;

import com.tjpu.bean.Dept;
import com.tjpu.bean.FileRecord;
import com.tjpu.bean.Links;
import com.tjpu.bean.Menu;
import com.tjpu.bean.Role;
import com.tjpu.bean.Teacher;
import com.tjpu.bean.User;

public interface UserDao {
	
	public List<FileRecord> fuzzyRecordResult (String keyword, int page, int pageSize);
	
	public Integer fuzzyLogsCount(String keyword);
	
	public Integer recordsCount ();
	
	public List<FileRecord> loadRecords (int lower, int upper);

	public List<User> loginDao(String username, String password, Integer role);

	public List<User> usercheck(String username);

	public void useradd(User u);

	public List<Dept> loaddepts();

	public List<User> loadusers(int i, int pageSize);

	public long totalstu();

	public void userupdate(User user, int deptid);

	public void userdelete(int userid);

	public List<User> usercheck1(String usernum);

	public Dept loaddeptbyid(int deptid);

	public Role loadrolebyid(int roles);

	public List<Role> loadroles(int i, int pageSize);

	public void roleadd(Role role);

	public void roledelete(int roleid);

	public void roleupdate(Role role);

	public List<Role> rolecheck(String rolename);

	public List<Role> loadroles();

	public List<User> pwdcheck(Integer id, String password);

	public void userchangpwd(User user);

	public List<Menu> loadmenu();

	public List<Menu> loadfirstmenu();

	public List<Menu> loadsecondmenu(Integer id);

	public void menuupdate(Menu menu);

	public void menudelete(Menu menu1);

	public void menuadd(Menu menu);

	public List<Menu> loadrolemenu(Integer id);

	public Menu loadmenubyid(int id);

	public void updaterolemenu(Set<Menu> menuset, int id);

	public void deptadd(Dept dept);

	public void deptdelete(int deptid);

	public void deptupdate(Dept dept);

	public List<Dept> loaddeptbyname(String deptname);

	public List<Teacher> loaddeptmember(Integer deptid);

	public List<Links> linkslist();

	public void linksadd(Links links);

	public void linksupdate(Links links);

	public void linksdelete(Integer id);

	public List<Links> linkscheck(String title);

	public List<Role> loadrolesbymenuid(Integer id);

	public long totalrole();

	public User loaduserbyid(Integer id);

	public Teacher loadteacherbyid(String teacherid);

	public List<User> usercheck1again(Integer id, String usernum);

	public Dept loaddeptresponsible(Integer deptid);

	public void updatedept(Integer deptid, String teachername);

	public List<Dept> loaddept();

	public Dept loaddeptbyresponsible(String teachername);

	public List<Teacher> Teacherpwdcheck(Integer id, String password);

}
