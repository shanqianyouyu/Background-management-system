package com.ctgu.service;

import com.ctgu.pojo.Feedback;
import com.ctgu.pojo.UIDataGridResult;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.service
 * @author: 拉布拉多
 * @date: 2019年6月8日 下午2:39:06
 */

public interface FeedBackService {
	UIDataGridResult getFeedBackList(int pages, int rows);

	/**
	 * 添加
	 * 
	 * @param feedback
	 * @return
	 */
	Boolean addFeedback(Feedback feedback);

	/**
	 * 删除
	 * 
	 * @param feedback
	 * @return
	 */
	Boolean deleteFeedback(Feedback feedback);

	/**
	 * 更新
	 * 
	 * @param feedback
	 * @return
	 */
	Boolean updateFeedback(Feedback feedback);
}
