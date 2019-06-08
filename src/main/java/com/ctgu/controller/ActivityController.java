package com.ctgu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.pojo.UIDataGridResult;
import com.ctgu.service.ActivityService;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.controller
 * @author: 拉布拉多
 * @date: 2019年6月8日 下午2:25:34
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	public ActivityService activityService;

	@RequestMapping("/activitys")
	@ResponseBody
	public UIDataGridResult getActivitys() {
		UIDataGridResult result = activityService.getActivityList(1, 1000);
		return result;
	}
}
