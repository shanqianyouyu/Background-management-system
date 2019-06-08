package com.ctgu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.dao.mappers.FeedbackMapper;
import com.ctgu.pojo.Feedback;
import com.ctgu.pojo.FeedbackExample;
import com.ctgu.pojo.Supplier;
import com.ctgu.pojo.SupplierExample;
import com.ctgu.pojo.UIDataGridResult;
import com.ctgu.service.FeedBackService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.service.impl
 * @author: 拉布拉多
 * @date: 2019年6月8日 下午2:39:42
 */

@Service
public class FeedBackServiceImpl implements FeedBackService {

	@Autowired
	public FeedbackMapper feedbackMapper;

	@Override
	public UIDataGridResult getFeedBackList(int pages, int rows) {
		// 分页处理
		PageHelper.startPage(pages, rows);
		// 执行查询
		FeedbackExample example = new FeedbackExample();
		List<Feedback> list = feedbackMapper.selectByExample(example);
		// 取分页信息
		PageInfo<Feedback> pageInfo = new PageInfo<>(list);
		// 返回处理结果
		UIDataGridResult result = new UIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setArray(list);
		return result;
	}

}
