package com.ctgu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctgu.dao.mappers.AdminMapper;
import com.ctgu.dao.mappers.CustomerMapper;
import com.ctgu.pojo.Admin;
import com.ctgu.pojo.AdminExample;
import com.ctgu.pojo.AdminExample.Criteria;
import com.ctgu.pojo.UIDataGridResult;
import com.ctgu.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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

	@Override // 根据邮箱取用户
	public Admin getAdminByEmail(String email) {
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

	@Override
	public List<Admin> getAdmins() {
		AdminExample adminExample = new AdminExample();
		Criteria criteria = adminExample.createCriteria();
		List<Admin> admin = adminMapper.selectByExample(adminExample);
		return admin;
	}

	@Override
	public UIDataGridResult getAdminList(int pages, int rows) {
		// 分页处理
		PageHelper.startPage(pages, rows);
		// 执行查询
		AdminExample example = new AdminExample();
		List<Admin> list = adminMapper.selectByExample(example);
		// 取分页信息
		PageInfo<Admin> pageInfo = new PageInfo<>(list);
		// 返回处理结果
		UIDataGridResult result = new UIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

}
