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
	/**
	 * 根据phoneNumber返回一个admin
	 * 
	 * @param phoneNumber
	 * @return
	 */
	Admin getAdminByPhoneNumber(Integer phoneNumber);

	/**
	 * 根据loginnumber得到admin用户
	 * @param loginnumber
	 * @return
	 */
	Admin gerAdminByLoginNumber(String loginnumber);
	
	/**
	 * 根据eamil返回一个admin用户
	 * 
	 * @param eamil
	 * @return
	 */
	Admin getAdminByEmail(String eamil);

	/**
	 * 获取所有的admin
	 * 
	 * @return
	 */
	List<Admin> getAdmins();

	/**
	 * 实现分页
	 * 
	 * @param pages 第几页
	 * @param rows  一页多少个
	 * @return
	 */
	UIDataGridResult getAdminList(int pages, int rows);

	/**
	 * 添加一个admin用户
	 * 
	 * @param admin
	 * @return 成功true 失败false
	 */
	boolean addAdmin(Admin admin);

	/**
	 * 查询登录名是否重复
	 * 
	 * @param admin
	 * @return
	 */
	Boolean checkLoginname(Admin admin);

	/**
	 * 删除
	 * 
	 * @param admin
	 * @return
	 */
	Boolean deleteAdmin(Admin admin);

	/**
	 * 更新
	 * 
	 * @param admin
	 * @return
	 */
	Boolean updateAdmin(Admin admin);
}
