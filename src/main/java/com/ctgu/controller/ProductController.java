package com.ctgu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.pojo.Product;
import com.ctgu.pojo.UIDataGridResult;
import com.ctgu.service.ProductService;
import com.ctgu.service.SupplierService;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.controller
 * @author: 拉布拉多
 * @date: 2019年6月8日 下午1:13:10
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	public ProductService productService;

	@RequestMapping("/products")
	@ResponseBody
	public UIDataGridResult getProducts() {
		UIDataGridResult result = productService.getProductList(1, 10000);
		return result;
	}

	@RequestMapping("/checkname")
	@ResponseBody
	public String checkName(@RequestBody Product product) {
		Boolean status = productService.checkName(product.getPname());
		// 找到为true 找不到为false
		return "{\"status\" :\"" + status.toString() + "\"}";
	}

	@RequestMapping("/add")
	@ResponseBody
	public String addProduct(@RequestBody Product product) {
		Boolean status = productService.addProduct(product);
		return "{\"status\" :\"" + status.toString() + "\"}";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String deleteProduct(@RequestBody Product product) {
		Boolean status = productService.deleteProduct(product);
		return "{\"status\" :\"" + status.toString() + "\"}";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateProduct(@RequestBody Product product) {
		Boolean status = productService.updateProduct(product);
		return "{\"status\" :\"" + status.toString() + "\"}";
	}
}
