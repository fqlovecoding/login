package com.ymdd.login;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.ymdd.user.UserService;

@RestController
public class LoginController {

	/**
	 * @MethodName login
	 * @Description 登录后返回接口凭据token和前端菜单显示码code
	 * @param userId
	 * @return
	 */
	@RequestMapping("/{userId}/login")
	public Map<String,Object> login(@PathVariable("userId") String userId) {
		Map<String,Object> map = Maps.newHashMap();
		map.put("token", LoginUtil.createToken(userId));
		map.put("code", UserService.getCodeByUserId(userId));
		return map;
	}
}
