package com.shanhe.web.mapper;

import com.shanhe.web.pojo.PageInfo;
import com.shanhe.web.pojo.StudentInfo;

import java.util.List;

public interface StudentInfoDao {

     List<StudentInfo> selByPage(PageInfo pi);

    long selCountByPageInfo(PageInfo pi);
    
    List<StudentInfo> selByResultMap() ; 


}
