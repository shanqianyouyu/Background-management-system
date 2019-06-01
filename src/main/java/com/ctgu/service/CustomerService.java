package com.ctgu.service;

import org.springframework.stereotype.Service;

import com.ctgu.pojo.Customer;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.service
 * @author: 拉布拉多
 * @date: 2019年5月31日 下午9:44:57
 */

@Service
public interface CustomerService {
	Customer login(Integer phoneNumber);
}
