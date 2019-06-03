package com.ctgu.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.pojo.Admin;
import com.ctgu.pojo.Customer;
import com.ctgu.pojo.UIDataGridResult;
import com.ctgu.service.AdminService;

import net.sf.json.JSONObject;

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
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public AdminService adminService;

	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestBody String data) {
		System.out.println(data);
		JSONObject json = JSONObject.fromObject(data);
		String email = json.getString("Cemail");
		String password = json.getString("Cnumber");
		Admin admin = adminService.getAdminByEmail(email);
		String status = null;
		if (admin != null && admin.getPassword().equals(password)) {
			status = "1";
		} else {
			status = "0";
		}
		String jsonData = "{\"status\" :\"" + status + "\"}";
		return jsonData;
	}

	@RequestMapping("/success")
	public String success() {
		System.out.println("跳转...");
		return "master";
	}

	@RequestMapping("/error")
	public String error() {
		System.out.println("滚啊...");
		return "error";
	}

	/*
	 * 一页10个
	 */
	@RequestMapping("/admins")
	@ResponseBody
	public UIDataGridResult admins(@RequestBody String pages) {
		System.out.println(pages);
		int rows = 30;
		UIDataGridResult result = adminService.getAdminList(1, rows);
		return result;
	}
}
