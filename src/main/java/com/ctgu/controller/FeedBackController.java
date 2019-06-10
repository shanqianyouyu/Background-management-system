package com.ctgu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctgu.pojo.Feedback;
import com.ctgu.pojo.UIDataGridResult;
import com.ctgu.service.FeedBackService;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.controller
 * @author: 拉布拉多
 * @date: 2019年6月8日 下午2:35:12
 */
@Controller
@RequestMapping("/feedback")
public class FeedBackController {

	@Autowired
	public FeedBackService feedBackService;

	@RequestMapping("/feedbacks")
	@ResponseBody
	public UIDataGridResult getFeedBack() {
		UIDataGridResult result = feedBackService.getFeedBackList(1, 1000);
		return result;
	}

	@RequestMapping("/add")
	@ResponseBody
	public String addFeedback(@RequestBody Feedback feedback) {
		Boolean status = feedBackService.addFeedback(feedback);
		return "{\"status\" :\"" + status.toString() + "\"}";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String deleteFeedback(@RequestBody Feedback feedback) {
		Boolean status = feedBackService.deleteFeedback(feedback);
		return "{\"status\" :\"" + status.toString() + "\"}";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateFeedback(@RequestBody Feedback feedback) {
		Boolean status = feedBackService.updateFeedback(feedback);
		return "{\"status\" :\"" + status.toString() + "\"}";
	}
}
