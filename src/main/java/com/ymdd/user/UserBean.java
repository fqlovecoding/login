package com.ymdd.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserBean {
	private String userId;
	/**
	 * 模块
	 */
	private String model;
	/**
	 * CRUD
	 */
	private String tag;
	/**
	 * 接口url
	 */
	private String url;
}
