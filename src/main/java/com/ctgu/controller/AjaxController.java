package com.ctgu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.pojo.Customer;
import com.ctgu.service.AdminService;

import net.sf.json.JSONObject;

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
	public AdminService customerService;

	@RequestMapping("/email")
	@ResponseBody
	public String username(@RequestBody String email) {
		JSONObject json = JSONObject.fromObject(email);

		email = json.getString("email");
		System.out.println("email: " + email);
//		Customer customer = customerService.isPresenceCustomer(email);
//		return customer == null ? "false" : "true";// 为空返回false 否则返回true
//		return email;
		return null;
	}

	@RequestMapping("/password")
	@ResponseBody
	public String password(@RequestBody String password) {
		System.out.println(password);
		return password;
	}
}
