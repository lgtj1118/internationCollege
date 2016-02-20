package com.tjpu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PermissionInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		 

	}

	@Override
	public void init() {
		 

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		 
		Object user = ActionContext.getContext().getSession().get("user");
		if (user != null) {
			return invocation.invoke();
		} else {
			return "permissionfail";
		}
	}

}
