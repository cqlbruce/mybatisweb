package com.shanhe.web.mapper;

import java.util.List;

import com.shanhe.web.pojo.TeacherInfo;

public interface TeacherInfoDao {
    TeacherInfo selById(String id );
    
    List<TeacherInfo> selByAll();
}
