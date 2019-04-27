package com.ymdd.user;

import java.util.List;

import com.google.common.collect.Lists;

public class UserDao {
	/**
	 * @MethodName listByUserId
	 * @Description 根据用户id查询其对应权限数据
	 * @param userId
	 * @return
	 */
	public static List<UserBean> listByUserId(String userId) {
		List<UserBean> lbList = Lists.newArrayList();
		lbList.add(new UserBean("1", "user", "add", "/user/add"));
		lbList.add(new UserBean("1", "user", "delete", "/user/delete"));
		lbList.add(new UserBean("1", "home", "list", "/home/list"));
		lbList.add(new UserBean("1", "home", "add", "/home/delete"));
		return lbList;
	}
	
	/**
	 * @MethodName boolByUserIdAndUrl
	 * @Description 根据用户id和所请求的url判断用户是否有访问资源的权限
	 * @param userId
	 * @param url
	 * @return
	 */
	public static boolean boolByUserIdAndUrl(String userId,String url) {
		return Integer.parseInt(userId) == 1 ? false : true;
	}
}
