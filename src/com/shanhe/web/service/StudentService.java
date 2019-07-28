package com.shanhe.web.service;

import com.shanhe.web.pojo.PageInfo;

public interface StudentService {
	PageInfo showPage(String sname, String tname, String pageSize, String pageNumber);
}
