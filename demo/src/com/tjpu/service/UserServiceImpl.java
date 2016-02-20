package com.tjpu.service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.print.resources.serviceui;

import com.opensymphony.xwork2.ActionContext;
import com.tjpu.bean.Dept;
import com.tjpu.bean.DeptModel;
import com.tjpu.bean.FileRecord;
import com.tjpu.bean.Links;
import com.tjpu.bean.MD5;
import com.tjpu.bean.Menu;
import com.tjpu.bean.Role;
import com.tjpu.bean.RoleModel;
import com.tjpu.bean.Teacher;
import com.tjpu.bean.TeacherModel;
import com.tjpu.bean.User;
import com.tjpu.bean.UserModel;
import com.tjpu.dao.ManageDao;
import com.tjpu.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	@Autowired
	ManageDao manageDao;
	@Override
	public User loginService(User user) {
		
		User user1 = null;
		List<User> list = userDao.loginDao(user.getUsernum(), user.getPassword(),user.getRoles().getRolerank());
		if (list.size() > 0 && list != null) {
			user1 = list.get(0);
		}
		return user1;
	}

	@Override
	public boolean usercheck(String username) {
		
		List<User> user = userDao.usercheck(username);
		if (user.size() > 0) {
			return false;
		}
		return true;
	}
	@Override
	public boolean usercheck1(String usernum) {
		
		List<User> user = userDao.usercheck1(usernum);
		if (user.size() > 0) {
			return false;
		}
		return true;
	}
	@Override
	public List<User> loaduser(Integer id,String usernum) {		
		return  userDao.usercheck1again(id,usernum);				
	}

	@Override
	public boolean pwdcheck(Integer id, String password) {
		
		List<User> user = userDao.pwdcheck(id,password);
		if (user.size() > 0) {
			return true;
		}
		return false;
	}
	@Override
	public void userchangpwd(User user) {
		
	    String password = null;
	    password = user.getPassword();
	    user.setPassword(password);
	    userDao.userchangpwd(user);
	}
	@Override
	public void useradd(User user,int deptid,int roles) {
		
		String username= null;
		String usernum = null;
		String realname = null;
		String password = MD5.generate(String.valueOf(123456));
		String sex = null;
		String telephone = null;
		String email = null; 
		try {
			username = java.net.URLDecoder.decode(user.getUsername(),"UTF-8");
			usernum = java.net.URLDecoder.decode(user.getUsernum(),"UTF-8");
			realname = java.net.URLDecoder.decode(user.getRealname(),"UTF-8");
			/*password = java.net.URLDecoder.decode(user.getPassword(),"UTF-8");*/
			sex = java.net.URLDecoder.decode(user.getSex(),"UTF-8");
			telephone = user.getTelephone();
			email = java.net.URLDecoder.decode(user.getEmail(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		User u = new User();
		u.setUsernum(usernum);
		u.setPassword(password);
		u.setRealname(realname);
		u.setEmail(email);
		u.setUsername(username);
		u.setTelephone(telephone);
		u.setSex(sex);
		Role role = userDao.loadrolebyid(roles);
		u.setRoles(role);
		Dept dept = userDao.loaddeptbyid(deptid);
		u.setDepts(dept);
		userDao.useradd(u);
	}

	@Override
	public String deptlist() {
		
		List<Dept> depts = userDao.loaddepts();
		String deptlist = "";
		int i = 1;
		for (Dept c : depts) {
			String s = "{\"Deptid\":" + c.getDeptid() + "," + "\"Deptname\":" + "\"" + c.getDeptname() + "\"," + "\"Responsible\":" + "\"" + c.getDeptresponsible() + "\"}";
			if (i < depts.size()) {
				deptlist += s + ",";
			} else {
				deptlist += s;
			}
			i++;
		}
		return deptlist;
	}

	@Override
	public Map<String, Object> usermap(int page, int pageSize) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> user = userDao.loadusers((page - 1) * pageSize, pageSize);
		long total = userDao.totalstu();
		List<UserModel> stumodels = new ArrayList<UserModel>();
		for (User s : user) {
			UserModel model = new UserModel();
			model.setUsernum(s.getUsernum());
			model.setDeptid(s.getDepts().getDeptid());
			model.setId(s.getId());
			model.setRoleid(s.getRoles().getId());			
			model.setPassword(s.getPassword());
			model.setSex(s.getSex());
			model.setUsername(s.getUsername());
			model.setRealname(s.getRealname());
			model.setEmail(s.getEmail());
			model.setTelephone(s.getTelephone());
			stumodels.add(model);
		}
		map.put("Total", total);
		map.put("Rows", stumodels);
		return map;
	}

	@Override
	public void userupdate(User user, int deptid) {
		
		String username = null;
		String usernum = null;
		String realname = null;
		String telephone = null;
		String email = null;
		String sex = null;
		String password = null;
		try {
			username = java.net.URLDecoder.decode(user.getUsername(),"UTF-8");
			usernum = java.net.URLDecoder.decode(user.getUsernum(),"UTF-8");
			realname = java.net.URLDecoder.decode(user.getRealname(),"UTF-8");
			telephone = java.net.URLDecoder.decode(user.getTelephone(),"UTF-8");
			email = java.net.URLDecoder.decode(user.getEmail(),"UTF-8");
			sex = java.net.URLDecoder.decode(user.getSex(),"UTF-8");
			//password = java.net.URLDecoder.decode(user.getPassword(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		user.setUsernum(usernum);
		user.setTelephone(telephone);
		user.setUsername(username);
		user.setEmail(email);
		//user.setPassword(password);
		user.setRealname(realname);
		user.setSex(sex);
		userDao.userupdate(user,deptid);
	}

	@Override
	public void userdelete(String ids) {
		
		StringTokenizer fenxi = new StringTokenizer(ids, ",");
		while (fenxi.hasMoreTokens()) {
			String sid = fenxi.nextToken();
			int userid = Integer.parseInt(sid);
			userDao.userdelete(userid);
		}
	}

	@Override
	public List<Dept> deptlist1() {
		
		List<Dept> deptlist = userDao.loaddepts();
		return deptlist;
	}

	@Override
	public void roleadd(Role role) {
		
		String rolename = null;
		String roledescribe = null;
		Integer rolerank  = null;
		try {
			rolename = java.net.URLDecoder.decode(role.getRolename(),"UTF-8");
			roledescribe = java.net.URLDecoder.decode(role.getRoledescribe(),"UTF-8");
			rolerank = role.getRolerank();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		Date dt = new Date();
		SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
		String createdate = matter1.format(dt);
		role.setCreatedate(createdate);
		role.setRoledescribe(roledescribe);
		role.setRolename(rolename);
		role.setRolerank(rolerank);
		userDao.roleadd(role);		
	}

	@Override
	public void roledelete(String ids) {
		
		StringTokenizer fenxi = new StringTokenizer(ids,",");
		while (fenxi.hasMoreTokens()) {
			String sid = fenxi.nextToken();
			int roleid = Integer.parseInt(sid);
			userDao.roledelete(roleid);
		}
	}

	@Override
	public void roleupdate(Role role) {
		
		String rolename = null;
		String roledescribe = null;
		Integer rolerank  = null;
		String createdate = null;
		try {
			rolename = java.net.URLDecoder.decode(role.getRolename(),"UTF-8");
			roledescribe = java.net.URLDecoder.decode(role.getRoledescribe(),"UTF-8");
			rolerank = role.getRolerank();
			createdate = java.net.URLDecoder.decode(role.getCreatedate(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		role.setCreatedate(createdate);
		role.setRoledescribe(roledescribe);
		role.setRolename(rolename);
		role.setRolerank(rolerank);
		userDao.roleupdate(role);		
	}

	@Override
	public Map<String, Object> rolemap(int page, int pageSize) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Role> role = userDao.loadroles((page - 1) * pageSize, pageSize);		
		long total = userDao.totalrole();
		List<RoleModel> stumodels = new ArrayList<RoleModel>();
		for (Role s : role) {
			RoleModel model = new RoleModel();
			model.setId(s.getId());
			model.setCreatedate(s.getCreatedate());
			model.setRoledescribe(s.getRoledescribe());
			model.setRolename(s.getRolename());
			model.setRolerank(s.getRolerank());
			stumodels.add(model);
		}
		map.put("Total", total);
		map.put("Rows", stumodels);
		return map;
	}

	@Override
	public boolean rolecheck(String rolename) {
		
		List<Role> haverole = userDao.rolecheck(rolename);
		if (haverole.size() > 0) {
			return false;
		}
		return true;
	}

	@Override
	public String rolelist() {
		
		List<Role> roles = userDao.loadroles();
		String rolelist = "";
		int i = 1;
		for (Role role : roles) {
			String s = "{\"Roleid\":" + role.getId() + "," + "\"Rolename\":" + "\"" + role.getRolename() + "\"," + "\"Rolerank\":" + role.getRolerank() + "," + "\"Createdate\":" + "\""
					+ role.getCreatedate() + "\"," + "\"Roledescribe\":" + "\"" + role.getRoledescribe() + "\"}";
			if (i < roles.size()) {
				rolelist += s + ",";
			} else {
				rolelist += s;
			}
			i++;
		}
		return rolelist;
	}

	@Override
	public Role loadrolebyid(Integer id) {
		
		Role role = userDao.loadrolebyid(id);
		return role;
	}

	@Override
	public Map<String, List<Menu>> menuMap(Integer id,User user) {
		
		List<Menu> list = userDao.loadrolemenu(id);
		List<Menu> homeMenu = new ArrayList<Menu>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMenu().getId() == 1)
				homeMenu.add(list.get(i));
		}
		Map<String, List<Menu>> map = new HashMap<String, List<Menu>>();
		for (Menu m : homeMenu) {
			List<Menu> childMenu = new ArrayList<Menu>();
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getMenu().getId() == m.getId()) {
					childMenu.add(list.get(j));
				}
			}
			if (childMenu.size() == 0) {
				continue;
			}
			if (user.getRoles().getRolerank()==3) {
				map.put(m.getNamenav()+"( <font style='font-weight:normal;'>"+m.getEnname()+"</font> )", childMenu);
			}else {
				map.put(m.getNamenav(), childMenu);
			}			
		}
		return map;
	}

	@Override
	public void deptupdate(Dept dept) {
		
		String deptname = null;
		String deptresponsible = null;
		try {
			deptname = java.net.URLDecoder.decode(dept.getDeptname(),"UTF-8");
			deptresponsible = java.net.URLDecoder.decode(dept.getDeptresponsible(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		dept.setDeptname(deptname);
		dept.setDeptresponsible(deptresponsible);
		userDao.deptupdate(dept);
	}
	@Override
	public void updatedept(Integer deptid, String teachername) {
		userDao.updatedept(deptid,teachername);
	}

	@Override
	public void deptdelete(String ids) {
		
		StringTokenizer fenxi = new StringTokenizer(ids,",");
		while (fenxi.hasMoreTokens()) {
			String sid = fenxi.nextToken();
			int deptid = Integer.parseInt(sid);
			userDao.deptdelete(deptid);
		}
	}

	@Override
	public void deptadd(Dept dept) {
		
		String deptname = null;
		String deptresponsible = null;
		try {
			deptname = java.net.URLDecoder.decode(dept.getDeptname(),"UTF-8");
			//deptresponsible = java.net.URLDecoder.decode(dept.getDeptresponsible(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		dept.setDeptname(deptname);
		dept.setDeptresponsible("");
		userDao.deptadd(dept);
	}

	@Override
	public boolean deptcheck(String deptname) {
		
		List<Dept> depts = userDao.loaddeptbyname(deptname);
		if (depts.size()>0) {
			return false;
		}
		return true;
	}

	

	@Override
	public String linkslist() {
		
		List<Links> links = userDao.linkslist();
		String linkslist = "";
		int i = 1;
		for (Links t : links) {
			String s = "{\"id\":" + t.getId() + "," + "\"title\":" + "\"" + t.getTitle() + "\"," + "\"linksaddress\":" + "\"" + t.getLinksaddress() +  "\"}";
			if (i < links.size()) {
				linkslist += s + ",";
			} else {
				linkslist += s;
			}
			i++;
		}
		return linkslist;
	}

	@Override
	public void linksadd(Links links) {
		
		String title = null;
		String linksaddress = null;
		try {
			title = java.net.URLDecoder.decode(links.getTitle(),"UTF-8");
			linksaddress = java.net.URLDecoder.decode(links.getLinksaddress(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		links.setTitle(title);
		links.setLinksaddress(linksaddress);
		userDao.linksadd(links);
	}

	@Override
	public void linksupdate(Links links) {
		
		String title = null;
		String linksaddress = null;
		try {
			title = java.net.URLDecoder.decode(links.getTitle(),"UTF-8");
			linksaddress = java.net.URLDecoder.decode(links.getLinksaddress(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		links.setTitle(title);
		links.setLinksaddress(linksaddress);
		userDao.linksupdate(links);
	}

	@Override
	public void linksdelete(Integer id) {
		
		userDao.linksdelete(id);
	}

	@Override
	public boolean linkscheck(String title) {
		
		List<Links> links = userDao.linkscheck(title);
		if (links.size()>0) {
			return false;
		}
		return true;
	}

	@Override
	public List<Links> loadlinks() {
		
		List<Links> linkslist = userDao.linkslist();
		return linkslist;
	}

	@Override
	public Dept loaddeptbyid(Integer deptid) {
		
		Dept dept = userDao.loaddeptbyid(deptid);
		return dept;
	}

	@Override
	public User loaduserbyid(Integer id) {
		
		User user = userDao.loaduserbyid(id);
		return user;
	}

	@Override
	public Dept loaddeptresponsible(Integer deptid) {
		Dept dept =userDao.loaddeptresponsible(deptid);
		return dept;
	}
	@Override
	public Map<String, Object> loaddeptmap(int page, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Dept> depts = userDao.loaddept();
		long total = depts.size();
		List<DeptModel> stumodels = new ArrayList<DeptModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i<depts.size()) {
				DeptModel model = new DeptModel();
				model.setDeptid(depts.get(i).getDeptid());
				model.setDeptname(depts.get(i).getDeptname());
				model.setDeptresponsible(depts.get(i).getDeptresponsible());
				stumodels.add(model);
			}
			
		}
		map.put("Total", total);
		map.put("Rows", stumodels);
		return map;
	}
	List<Teacher> teachers = new ArrayList<Teacher>();
	@Override
	public String loaddeptmember(Integer deptid) {
		teachers.clear();
		teachers = userDao.loaddeptmember(deptid);
		for(int i=0;i<teachers.size()-1;i++){
			for(int j=0;j<teachers.size()-i-1;j++){
				if(Integer.valueOf(teachers.get(j).getIdentificationnum())>Integer.valueOf(teachers.get(j+1).getIdentificationnum())){
					Teacher temp = null;
					temp = teachers.get(j);
					teachers.set(j, teachers.get(j+1));
					teachers.set(j+1, temp);
				}
			}
		}
		String teacherlist = "";
		int i = 1;
		for (Teacher t : teachers) {
			String s = "{\"id\":" + t.getId() + "," + "\"identificationnum\":" + "\"" + t.getIdentificationnum() + "\"," + "\"telephone\":" + "\"" + t.getTelephone() + "\"," + "\"email\":" + "\"" + t.getEmail() + "\"," + "\"position\":" + "\"" + t.getPosition() + "\"," + "\"sex\":" + "\"" + t.getSex() + "\"," + "\"deleted\":" + "\"" + t.getDeleted() + "\"," + "\"teachername\":" + "\"" + t.getTeachername() + "\"}";
			if (i < teachers.size()) {
				teacherlist += s + ",";
			} else {
				teacherlist += s;
			}
			i++;
		}
		return teacherlist;
	}
	

	@Override
	public Map<String, Object> deptmembermap(int page, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		long total =teachers.size();
		List<TeacherModel> stumodels = new ArrayList<TeacherModel>();
		for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
			if (i<teachers.size()) {
				TeacherModel model = new TeacherModel();
				model.setId(teachers.get(i).getId());
				model.setIdentificationnum(teachers.get(i).getIdentificationnum());
				model.setDeleted(teachers.get(i).getDeleted());
				model.setEmail(teachers.get(i).getEmail());
				model.setPosition(teachers.get(i).getPosition());
				model.setTelephone(teachers.get(i).getTelephone());
				model.setTeachername(teachers.get(i).getTeachername());
				model.setSex(teachers.get(i).getSex());
				stumodels.add(model);
			}
			
		}
		map.put("Total", total);
		map.put("Rows", stumodels);
		return map;
	}

	@Override
	public Dept deptteachercheck(Integer deptid) {
		
		return userDao.loaddeptbyid(deptid);
	}

	@Override
	public Dept loaddeptbyresponsible(String teachername) {
		
		return userDao.loaddeptbyresponsible(teachername);
	}

	
	@Override
	public Map<String, Object> loadSystemlogs(int page, int pageSize) {
		Integer count = userDao.recordsCount();
		if ((page - 1) * pageSize > count) {
			page = 1;
		}
		List<FileRecord> fr = userDao.loadRecords((page - 1) * pageSize, page * pageSize);
		
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("Total", count);
		ret.put("Rows", fr);
		return ret;
	}

	@Override
	public Map<String, Object> fuzzyLogs(String keyword, int page, int PageSize) {
		Integer count = userDao.fuzzyLogsCount(keyword);
		if ((page - 1) * PageSize < count) {
			page = 1;
		}
		List<FileRecord> fr = userDao.fuzzyRecordResult(keyword, (page - 1) * PageSize, page * PageSize);
		Map <String, Object> ret = new HashMap<String, Object>();
		ret.put("Total", count);
		ret.put("Rows", fr);
		return ret;
	}
}
