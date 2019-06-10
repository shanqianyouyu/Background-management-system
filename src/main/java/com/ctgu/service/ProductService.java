package com.ctgu.service;

import com.ctgu.pojo.Product;
import com.ctgu.pojo.UIDataGridResult;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.service
 * @author: 拉布拉多
 * @date: 2019年6月8日 下午1:14:30
 */

public interface ProductService {
	UIDataGridResult getProductList(int pages, int rows);

	/**
	 * 判断名字是否重复
	 * 
	 * @param pname
	 * @return
	 */
	Boolean checkName(String pname);

	/**
	 * 添加产品
	 * 
	 * @param product
	 * @return
	 */
	Boolean addProduct(Product product);

	/**
	 * 根据名字删除
	 * 
	 * @param product
	 * @return
	 */
	Boolean deleteProduct(Product product);

	/**
	 * 更新
	 * 
	 * @param product
	 * @return
	 */
	Boolean updateProduct(Product product);
}
