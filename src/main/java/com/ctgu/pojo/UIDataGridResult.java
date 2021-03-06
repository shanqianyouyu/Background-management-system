package com.ctgu.pojo;

import java.util.List;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * 
 * @Package: com.ctgu.pojo
 * @author: 拉布拉多
 * @date: 2019年6月3日 下午3:29:07
 */

public class UIDataGridResult {
	private long total;
	private int code = 0;
	private String message = "success";
	private List<?> array;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getArray() {
		return array;
	}

	public void setArray(List<?> array) {
		this.array = array;
	}

}
