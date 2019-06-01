package com.ctgu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ctgu.dao.mapper.CustomerMapper;
import com.ctgu.pojo.Customer;
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

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public Customer login(Integer phoneNumber) {
		Customer customer = customerMapper.selectByPrimaryKey(phoneNumber);
		return customer;
	}

}
