package com.ctgu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.dao.mappers.ActivityMapper;
import com.ctgu.pojo.Activity;
import com.ctgu.pojo.ActivityExample;
import com.ctgu.pojo.Supplier;
import com.ctgu.pojo.SupplierExample;
import com.ctgu.pojo.UIDataGridResult;
import com.ctgu.service.ActivityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.service.impl
 * @author: 拉布拉多
 * @date: 2019年6月8日 下午2:27:31
 */

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	public ActivityMapper activityMapper;

	@Override
	public UIDataGridResult getActivityList(int pages, int rows) {

		// 分页处理
		PageHelper.startPage(pages, rows);
		// 执行查询
		ActivityExample example = new ActivityExample();
		List<Activity> list = activityMapper.selectByExample(example);
		// 取分页信息
		PageInfo<Activity> pageInfo = new PageInfo<>(list);
		// 返回处理结果
		UIDataGridResult result = new UIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setArray(list);
		return result;
	}

}
