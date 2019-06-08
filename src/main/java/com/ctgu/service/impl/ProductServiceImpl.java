package com.ctgu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.dao.mappers.ProductMapper;
import com.ctgu.pojo.Product;
import com.ctgu.pojo.ProductExample;
import com.ctgu.pojo.UIDataGridResult;
import com.ctgu.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.service.impl
 * @author: 拉布拉多
 * @date: 2019年6月8日 下午1:15:20
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductMapper productMapper;

	@Override
	public UIDataGridResult getProductList(int pages, int rows) {
		// 分页处理
		PageHelper.startPage(pages, rows);
		// 执行查询
		ProductExample example = new ProductExample();
		List<Product> list = productMapper.selectByExample(example);
		// 取分页信息
		PageInfo<Product> pageInfo = new PageInfo<>(list);
		// 返回处理结果
		UIDataGridResult result = new UIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setArray(list);
		return result;
	}

}
