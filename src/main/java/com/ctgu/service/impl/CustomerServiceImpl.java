package com.ctgu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.dao.mappers.CustomerMapper;
import com.ctgu.pojo.Customer;
import com.ctgu.pojo.CustomerExample;
import com.ctgu.pojo.CustomerExample.Criteria;
import com.ctgu.service.CustomerService;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：用户登录
 * 
 * @Package: com.ctgu.service.impl
 * @author: 拉布拉多
 * @date: 2019年5月31日 下午9:51:03
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	public CustomerMapper customerMapper;

	@Override
	public Customer login(Integer phoneNumber) {
		Customer customer = customerMapper.selectByPrimaryKey(phoneNumber);
		return customer;
	}

	@Override // 判断用户名是否存在
	public Customer isPresenceCustomer(String email) {
		CustomerExample customerExample = new CustomerExample();
//		customerExample.setOrderByClause(email);
		Criteria criteria = customerExample.createCriteria();
		criteria.andCemailEqualTo(email);
		List<Customer> customer = customerMapper.selectByExample(customerExample);
		if (customer.size() == 1) {// 查到一个
			return customer.get(0);
		} else {
			return null;
		}
	}

}
