package com.ctgu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.pojo.Customer;
import com.ctgu.pojo.UIDataGridResult;
import com.ctgu.service.CustomerService;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.controller
 * @author: 拉布拉多
 * @date: 2019年6月7日 下午4:02:17
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	public CustomerService customerService;

	/**
	 * 获取所有的客户，以json格式返回
	 * 
	 * @return
	 */
	@RequestMapping("/customers")
	@ResponseBody
	public UIDataGridResult getCustomers() {
		UIDataGridResult result = customerService.getCustomerList(1, 10000);
		return result;
	}
}
