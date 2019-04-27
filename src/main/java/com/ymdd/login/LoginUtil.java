package com.ymdd.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ymdd.user.UserService;

public class LoginUtil {
	/**
	 * @MethodName createToken
	 * @Description 用户登录后生成token
	 * @param userId
	 * @return
	 */
	public static String createToken(String userId) {
		return JWT.create().withAudience(userId).sign(Algorithm.HMAC256(userId));
	}

	/**
	 * @MethodName parseToken
	 * @Description 根据用户id解析token
	 * @param req
	 * @return
	 */
	public static String parseToken(HttpServletRequest req) {
		String token = req.getHeader("X-AUTH-TOKEN");
		if (token == null) {
			return null;
		}
		String userId = JWT.decode(token).getAudience().get(0);
		if (userId == null) {
			return null;
		}
		return userId;
	}
	
	/***
	 * @MethodName auth
	 * @Description 鉴权过程
	 * @param req
	 * @param resp
	 * @return
	 */
	public static boolean auth(HttpServletRequest req,HttpServletResponse resp) {
		//排除不需要token的接口
		String url = req.getRequestURI();
		if(url.contains("login")) {
			return true;
		}
		//解析token是否存在
		String userId = LoginUtil.parseToken(req);
		if(userId == null) {
			return false;
    	}
		//根据解析结果判定接口权限
		if(UserService.pass(userId, url)) {
			return true;
		}
		return false;
	}
}
