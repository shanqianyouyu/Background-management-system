package com.ctgu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.service.CustomerService;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：ajax异步验证
 * 
 * @Package: com.ctgu.controller
 * @author: 拉布拉多
 * @date: 2019年6月1日 下午2:34:34
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/email")
	@ResponseBody
	public Boolean username(@RequestBody String email) {

		System.out.println("email: " + email);
		Boolean result = customerService.isPresenceCustomer(email);
		return result;
	}

	@RequestMapping("/password")
	@ResponseBody
	public String password(@RequestBody String password) {
		System.out.println(password);
		return password;
	}
}
