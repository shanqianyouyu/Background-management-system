package com.ctgu.service;

import java.util.List;

import com.ctgu.pojo.Admin;
import com.ctgu.pojo.Customer;
import com.ctgu.pojo.UIDataGridResult;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.service
 * @author: 拉布拉多
 * @date: 2019年5月31日 下午9:44:57
 */

public interface AdminService {
	Admin login(Integer phoneNumber);

	Admin getAdminByEmail(String eamil);

	List<Admin> getAdmins();

	UIDataGridResult getAdminList(int pages, int rows);

	boolean addAdmin(Admin admin);

	// 查询登录名是否重复
	Boolean checkLoginname(Admin admin);
	
	//删除
	Boolean deleteAdmin(Admin admin);

	Boolean updateAdmin(Admin admin);
}
