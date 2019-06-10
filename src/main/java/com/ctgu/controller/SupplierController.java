package com.ctgu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.pojo.Supplier;
import com.ctgu.pojo.UIDataGridResult;
import com.ctgu.service.SupplierService;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.controller
 * @author: 拉布拉多
 * @date: 2019年6月8日 下午12:54:10
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	public SupplierService supplierService;

	@RequestMapping("/suppliers")
	@ResponseBody
	public UIDataGridResult getSuppliers() {
		UIDataGridResult result = supplierService.getSupplierList(1, 10000);
		return result;
	}

	@RequestMapping("/checkphonenumber")
	@ResponseBody
	public String checkphonenumber(@RequestBody Supplier supplier) {
		Boolean status = supplierService.checkPhoneNumber(supplier.getSnumber());
		// 找到为true 找不到为false
		return "{\"status\" :\"" + status.toString() + "\"}";
	}

	@RequestMapping("/add")
	@ResponseBody
	public String add(@RequestBody Supplier supplier) {
		Boolean status = supplierService.addSupplier(supplier);
		return "{\"status\" :\"" + status.toString() + "\"}";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestBody Supplier supplier) {
		Boolean status = supplierService.deleteSupplier(supplier);
		return "{\"status\" :\"" + status.toString() + "\"}";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(@RequestBody Supplier supplier) {
		Boolean status = supplierService.updateSupplier(supplier);
		return "{\"status\" :\"" + status.toString() + "\"}";
	}
}
