package com.ctgu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.dao.mappers.SupplierMapper;
import com.ctgu.pojo.CustomerExample;
import com.ctgu.pojo.Supplier;
import com.ctgu.pojo.SupplierExample;
import com.ctgu.pojo.UIDataGridResult;
import com.ctgu.service.SupplierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.service.impl
 * @author: 拉布拉多
 * @date: 2019年6月8日 下午12:57:49
 */
@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	public SupplierMapper supplierMapper;

	@Override
	public UIDataGridResult getSupplierList(int pages, int rows) {
		// 分页处理
		PageHelper.startPage(pages, rows);
		// 执行查询
		SupplierExample example = new SupplierExample();
		List<Supplier> list = supplierMapper.selectByExample(example);
		// 取分页信息
		PageInfo<Supplier> pageInfo = new PageInfo<>(list);
		// 返回处理结果
		UIDataGridResult result = new UIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setArray(list);
		return result;
	}

}
