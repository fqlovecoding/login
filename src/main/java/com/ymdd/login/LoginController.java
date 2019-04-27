package com.ymdd.login;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping("/{userId}/login")
	public String login(@PathVariable("userId") String userId) {
		return LoginUtil.createToken(userId);
	}
}
