package com.ctgu.service;

import com.ctgu.pojo.UIDataGridResult;

/**   
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.ctgu.service 
 * @author: 拉布拉多   
 * @date: 2019年6月8日 下午2:39:06 
 */

public interface FeedBackService {
	UIDataGridResult getFeedBackList(int pages, int rows);
}

