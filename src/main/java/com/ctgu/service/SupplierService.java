package com.ctgu.service;

import com.ctgu.pojo.Supplier;
import com.ctgu.pojo.UIDataGridResult;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.service
 * @author: 拉布拉多
 * @date: 2019年6月8日 下午12:56:00
 */

public interface SupplierService {
	/**
	 * 分页
	 * 
	 * @param pages
	 * @param rows
	 * @return
	 */
	UIDataGridResult getSupplierList(int pages, int rows);

	/**
	 * 判断手机号是否被占用
	 * 
	 * @param number
	 * @return
	 */
	Boolean checkPhoneNumber(String number);

	/**
	 * 添加
	 * 
	 * @param supplier
	 * @return
	 */
	Boolean addSupplier(Supplier supplier);

	/**
	 * 删除
	 * @param supplier
	 * @return
	 */
	Boolean deleteSupplier(Supplier supplier);

	/**
	 * 更新信息
	 * @param supplier
	 * @return
	 */
	Boolean updateSupplier(Supplier supplier);
}
