package com.ymdd.user;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Maps;

public class UserService {
	/**
	 * @MethodName getCodeByUserId
	 * @Description 封装前端数据结构
	 * @param userId
	 * @return
	 */
	public static Map<String,Set<String>> getCodeByUserId(String userId){
		Map<String,Set<String>> authCode = Maps.newHashMap();
		List<UserBean> daoData = UserDao.listByUserId(userId);
		Map<String,List<UserBean>> map = daoData.stream().collect(Collectors.groupingBy(UserBean::getModel));
		for (Entry<String, List<UserBean>> en : map.entrySet()) {
			authCode.put(en.getKey(), en.getValue().stream().map(UserBean::getTag).collect(Collectors.toSet()));
		}
		return authCode;
	}
	
	/**
	 * @MethodName pass
	 * @Description 接口URL鉴权
	 * @param userId
	 * @param url
	 * @return
	 */
	public static boolean pass(String userId,String url) {
		return UserDao.boolByUserIdAndUrl(userId, url);
	}
}
