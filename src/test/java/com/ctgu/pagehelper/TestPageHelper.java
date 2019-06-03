package com.ctgu.pagehelper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ctgu.dao.mappers.AdminMapper;
import com.ctgu.pojo.Admin;
import com.ctgu.pojo.AdminExample;
import com.ctgu.pojo.AdminExample.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：测试pagehelper
 * 
 * @Package: com.ctgu.pagehelper
 * @author: 拉布拉多
 * @date: 2019年6月3日 下午3:10:32
 */

public class TestPageHelper {
	@Test
	public void testPageHelper() throws Exception {
		// 1.获得mapper对象
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:*.xml");
		AdminMapper adminMapper = applicationContext.getBean(AdminMapper.class);
		// 2.设置分页
		PageHelper.startPage(1, 6);
		// 3.执行设置
		AdminExample example = new AdminExample();
		List<Admin> list = adminMapper.selectByExample(example);
		// 4.取分页后的结果
		PageInfo<Admin> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("total: " + total);
		int pages = pageInfo.getPages();
		System.out.println("pages: " + pages);
		System.out.println("pagesize: " + pageInfo.getPageSize());
	}
}
