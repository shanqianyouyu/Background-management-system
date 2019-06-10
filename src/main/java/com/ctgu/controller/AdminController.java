package com.ctgu.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.pojo.Admin;
import com.ctgu.pojo.UIDataGridResult;
import com.ctgu.service.AdminService;
import com.ctgu.util.Email;

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

	private String code = null;
	private String password = null;
	@Autowired
	public AdminService adminService;

	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestBody Admin admin, HttpServletRequest request) {
		String status = null;
		Admin ans = adminService.gerAdminByLoginNumber(admin.getLoginname());
		if (ans != null && ans.getPassword().equals(admin.getPassword())) {
			status = "1";
			// 登录成功
			HttpSession session = request.getSession(true);
			session.setAttribute("user", ans.getName());
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

	/**
	 * 一页10个@RequestBody String pages
	 */
	@RequestMapping("/admins")
	@ResponseBody
	public UIDataGridResult admins() {
//		System.out.println(pages);
		int rows = 10000;
		UIDataGridResult result = adminService.getAdminList(1, rows);
		System.out.println(result);
		return result;
	}

	@RequestMapping("/add")
	@ResponseBody
	public String add(@RequestBody Admin admin) {
		admin.setCreatedate(new Date());
		String status = null;
		String jsonData = null;
		try {
			adminService.addAdmin(admin);
			status = "true";
		} catch (Exception e) {
			status = "false";
			jsonData = "{\"status\" :\"" + status + "\"}";
			return jsonData;
		}
		jsonData = "{\"status\" :\"" + status + "\"}";
		return jsonData;
	}

	/**
	 * 判断查重
	 */
	@RequestMapping("/checkLoginName")
	@ResponseBody
	public String checkLoginName(@RequestBody Admin admin) {
		Boolean status = adminService.checkLoginname(admin);
		System.out.println("check: " + status);
		String jsonData = "{\"status\" :\"" + status + "\"}";
		return jsonData;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestBody Admin admin) {
		Boolean status = adminService.deleteAdmin(admin);
		String jsonData = "{\"status\" :\"" + status + "\"}";
		return jsonData;
	}

	@RequestMapping("/update")
	@ResponseBody
	public String update(@RequestBody Admin admin) {
		Boolean status = adminService.updateAdmin(admin);
		String jsonData = "{\"status\" :\"" + status + "\"}";
		return jsonData;
	}

	/*
	 * loginname phonenumber
	 */
	@RequestMapping("/getcode")
	@ResponseBody
	public String getCode(@RequestBody String s) {
		/*
		 * 先验证邮箱与用户名对应关系
		 */
		JSONObject jsonObject = new JSONObject(s);
		Admin admin = adminService.gerAdminByLoginNumber(jsonObject.getString("loginname"));
		if (admin == null || !admin.getPhonenumber().equals(jsonObject.getString("phonenumber"))) {
			return "{\"status\" :\"false\"}";
		}
//		System.out.println(jsonObject.getString("loginname"));
		try {
			code = Email.getCode();
			System.out.println(code);
			Email.sendQQEmail(jsonObject.getString("phonenumber"), "1131497375@qq.com", "jqvaexsqxcrfiijf", code);
			return "{\"status\" :\"true\"}";
		} catch (Exception e) {
			return "{\"status\" :\"false\"}";
		}
	}

	/*
	 * loginname phonenumber
	 */
	@RequestMapping("/verificationCode")
	@ResponseBody
	public String verificationCode(@RequestBody String s) {
		JSONObject jsonObject = new JSONObject(s);
		Admin admin = null;
		String msg = null;
		Boolean status = false;
		/*
		 * 先验证邮箱与用户名对应关系
		 */
		admin = adminService.gerAdminByLoginNumber(jsonObject.getString("loginname"));
		if (!admin.getPhonenumber().equals(jsonObject.getString("phonenumber"))) {
			msg = "用户名或者邮箱错误";
			return "{\"status\" :\"" + status + "\",\"msg\":\"" + msg + "\"}";
		}

		// 验证验证码是否正确
		String front = jsonObject.getString("code");
		if (code == null || !front.equals(code)) {
			msg = "验证码错误";
			return "{\"status\" :\"" + status + "\",\"msg\":\"" + msg + "\"}";
		}
		// 随机生成密码
		password = Email.genRandomPassword();
		admin.setPassword(password);
		adminService.updateAdmin(admin);
		status = true;
		msg = "密码修改成功，新密码为" + password;
		return "{\"status\" :\"" + status.toString() + "\",\"msg\":\"" + msg + "\"}";
	}
}
