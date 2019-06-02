package com.ctgu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.dao.mappers.AdminMapper;
import com.ctgu.dao.mappers.CustomerMapper;
import com.ctgu.pojo.Admin;
import com.ctgu.pojo.AdminExample;
import com.ctgu.pojo.AdminExample.Criteria;
import com.ctgu.service.AdminService;

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
public class AdminServiceImpl implements AdminService {

	@Autowired
	public AdminMapper adminMapper;

	@Override
	public Admin login(Integer phoneNumber) {
		Admin admin = adminMapper.selectByPrimaryKey(phoneNumber);
		return admin;
	}

	@Override // 判断用户名是否存在
	public Admin isPresenceAdmin(String email) {
		AdminExample adminExample = new AdminExample();
		Criteria criteria = adminExample.createCriteria();
		criteria.andPhonenumberEqualTo(email);
		List<Admin> admin = adminMapper.selectByExample(adminExample);
		if (admin.size() == 1) {// 查到一个
			return admin.get(0);
		} else {
			return null;
		}
	}

}
