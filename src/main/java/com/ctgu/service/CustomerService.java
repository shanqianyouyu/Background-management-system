package com.ctgu.service;

import java.util.List;

import com.ctgu.pojo.Customer;
import com.ctgu.pojo.UIDataGridResult;

/**   
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.ctgu.service 
 * @author: 拉布拉多   
 * @date: 2019年6月7日 下午4:05:56 
 */

public interface CustomerService {

	/**
	 * 获取所有的customer
	 * @return
	 */
	List<Customer> getCustomers();
	
	/**
	 * 根据email获取一个客户
	 * @param Email
	 * @return
	 */
	List<Customer> getCustomerByEmail(String Email);
	
	/**
	 * 分页
	 * @param pages
	 * @param rows
	 * @return
	 */
	UIDataGridResult getCustomerList(int pages, int rows);
	
	/**
	 * 添加一个客户
	 * @param customer
	 * @return
	 */
	Boolean addCustomer(Customer customer);
	
	/**
	 * 更新一个客户的信息
	 * @param customer
	 * @return
	 */
	Boolean updateCustomer(Customer customer);
	
	/**
	 * 根据email删除客户
	 * @param eamil
	 * @return
	 */
	Boolean deleteCustomer(String eamil);
}

