package com.ctgu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping("/add")
	@ResponseBody
	public String add(@RequestBody Customer customer) {
		customer.setCreatedate(new Date());
		Boolean status = customerService.addCustomer(customer);
		String jsonData = "{\"status\" :\"" + status.toString() + "\"}";
		return jsonData;
	}

	@RequestMapping("/checkemail")
	@ResponseBody
	public String checkEmail(@RequestBody Customer customer) {
		List<Customer> obj = customerService.getCustomerByEmail(customer.getCemail());
		String status = "true";
		System.out.println("打印email: ");
		for (Customer customer2 : obj) {
			System.out.println(customer2);
		}
		System.out.println(obj);
		System.out.println(obj.size());
		if (obj == null || obj.size() == 0) {
			// true表示重复了
			status = "false";
		}

		String jsonData = "{\"status\" :\"" + status + "\"}";
		return jsonData;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestBody Customer customer) {
		Boolean status = customerService.deleteCustomer(customer.getCemail());
		return "{\"status\" :\"" + status.toString() + "\"}";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(@RequestBody Customer customer) {
		Boolean status = customerService.updateCustomer(customer);
		return "{\"status\" :\"" + status.toString() + "\"}";
	}

}
