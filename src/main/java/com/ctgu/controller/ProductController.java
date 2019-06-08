package com.ctgu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
