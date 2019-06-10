package com.ctgu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.pojo.Activity;
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

	@RequestMapping("/checkaitem")
	@ResponseBody
	public String checkAitem(@RequestBody Activity activity) {
		Boolean status = activityService.checkAitem(activity.getAitem());
		return "{\"status\" :\"" + status.toString() + "\"}";
	}

	@RequestMapping("/add")
	@ResponseBody
	public String addActivity(@RequestBody Activity activity) {
		Boolean status = activityService.addActivity(activity);
		return "{\"status\" :\"" + status.toString() + "\"}";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String deleteActivity(@RequestBody Activity activity) {
		Boolean status = activityService.deleteActivity(activity);
		return "{\"status\" :\"" + status.toString() + "\"}";
	}

	@RequestMapping("/update")
	@ResponseBody
	public String updateActivity(@RequestBody Activity activity) {
		System.out.println("打印活动修改信息: " + activity);
		System.out.println("打印活动修改信息: " + activity.getAitem());
		Boolean status = activityService.updateActivity(activity);
		return "{\"status\" :\"" + status.toString() + "\"}";
	}

}
