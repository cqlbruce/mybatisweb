package com.shanhe.web.service.impl;

import java.util.List;

import com.shanhe.web.mapper.StudentInfoDao;
import com.shanhe.web.mapper.TeacherInfoDao;
import com.shanhe.web.pojo.PageInfo;
import com.shanhe.web.pojo.StudentInfo;
import com.shanhe.web.service.StudentService;
import com.shanhe.web.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


public class StudentServiceImpl implements StudentService {

	@Override
	public PageInfo showPage(String sname, String tname, String pageSizeStr, String pageNumberStr) {
		int pageSize = 2;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		SqlSession session = MybatisUtil.getSession();
		StudentInfoDao sDao = session.getMapper(StudentInfoDao.class);
		
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		pi.setPageStart((pageNumber-1)*pageSize);
		pi.setTname(tname);
		pi.setSname(sname);
		
		List<StudentInfo> list = sDao.selByPage(pi);
		//查询出每个学生对应的老师信息
		TeacherInfoDao tDao = session.getMapper(TeacherInfoDao.class);
		for (StudentInfo student : list) {
			student.setTeacher(tDao.selById(student.getTid()));
		}
		pi.setList(list);
		long count = sDao.selCountByPageInfo(pi);
		
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		
		return pi;
	}

}
