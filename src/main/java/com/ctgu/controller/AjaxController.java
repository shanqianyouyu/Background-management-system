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
 * @date: 2019年6月1日 下午2:34:34
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@RequestMapping("/username")
	@ResponseBody
	public String username(String name) {
		System.out.println(name);
		return name;
	}
}
