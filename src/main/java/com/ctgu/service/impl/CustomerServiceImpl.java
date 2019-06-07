package com.ctgu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.dao.mappers.CustomerMapper;
import com.ctgu.pojo.Customer;
import com.ctgu.pojo.CustomerExample;
import com.ctgu.pojo.UIDataGridResult;
import com.ctgu.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.service.impl
 * @author: 拉布拉多
 * @date: 2019年6月7日 下午4:16:17
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	public CustomerMapper customerMapper;

	@Override
	public List<Customer> getCustomers() {

		return null;
	}

	@Override
	public Customer getCustomerByEmail(String Email) {
		return null;
	}

	@Override
	public UIDataGridResult getCustomerList(int pages, int rows) {
		// 分页处理
		PageHelper.startPage(pages, rows);
		// 执行查询
		CustomerExample example = new CustomerExample();
		List<Customer> list = customerMapper.selectByExample(example);
		// 取分页信息
		PageInfo<Customer> pageInfo = new PageInfo<>(list);
		// 返回处理结果
		UIDataGridResult result = new UIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setArray(list);
		return result;
	}

	@Override
	public Boolean addCustomer(Customer customer) {
		return null;
	}

	@Override
	public Boolean updateCustomer(Customer customer) {
		return null;
	}

}
