package com.ctgu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.controller
 * @author: 拉布拉多
 * @date: 2019年5月31日 下午7:47:59
 */
@Controller
@RequestMapping("/login")
public class UserController {

	@RequestMapping("/login")
	public String login() {

		return "success";
	}

	@RequestMapping("/test")
	@ResponseBody
	public String test(String username) {
		System.out.println(username);
		return username;
	}
}
