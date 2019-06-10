package com.ctgu.service;

import com.ctgu.pojo.Activity;
import com.ctgu.pojo.UIDataGridResult;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.service
 * @author: 拉布拉多
 * @date: 2019年6月8日 下午2:26:40
 */

public interface ActivityService {
	/**
	 * 分页
	 * 
	 * @param pages
	 * @param rows
	 * @return
	 */
	UIDataGridResult getActivityList(int pages, int rows);

	/**
	 * 核对活动名
	 * 
	 * @param aitem
	 * @return
	 */
	Boolean checkAitem(String aitem);

	/**
	 * 添加活动
	 * 
	 * @param activity
	 * @return
	 */
	Boolean addActivity(Activity activity);

	/**
	 * 删除
	 * 
	 * @param activity
	 * @return
	 */
	Boolean deleteActivity(Activity activity);

	/**
	 * 更新
	 * 
	 * @param activity
	 * @return
	 */
	Boolean updateActivity(Activity activity);
}
