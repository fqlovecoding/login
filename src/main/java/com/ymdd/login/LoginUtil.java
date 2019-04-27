package com.ymdd.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginUtil {
	
	public static String createToken(String userId) {
		return "SH256:" + userId;
	}

	public static boolean parseToken(String token) {
		if (token == null || token.split(":")[1].length()>1) {
			return false;
		}
		return true;
	}
	
	public static boolean auth(HttpServletRequest req,HttpServletResponse resp) {
		//不需要token的接口
		if(req.getRequestURL().toString().contains("login")) {
			return true;
		}
		//鉴权通过
		if(LoginUtil.parseToken(req.getHeader("X-AUTH-TOKEN"))) {
			return true;
    	}
		return false;
	}
}
