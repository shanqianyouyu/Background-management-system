package com.ctgu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.dao.mappers.ProductMapper;
import com.ctgu.pojo.Product;
import com.ctgu.pojo.ProductExample;
import com.ctgu.pojo.ProductExample.Criteria;
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

	@Override
	public Boolean checkName(String pname) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andPnameEqualTo(pname);
		List<Product> products = null;
		try {
			products = productMapper.selectByExample(example);
		} catch (Exception e) {
			return false;
		}
		if (products == null || products.size() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean addProduct(Product product) {
		product.setPnumber(0);
		try {
			productMapper.insertSelective(product);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean deleteProduct(Product product) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andPnameEqualTo(product.getPname());
		try {
			productMapper.deleteByExample(example);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean updateProduct(Product product) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andPnameEqualTo(product.getPname());
		try {
			productMapper.updateByExampleSelective(product, example);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
