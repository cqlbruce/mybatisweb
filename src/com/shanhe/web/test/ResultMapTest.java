package com.shanhe.web.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.shanhe.web.mapper.StudentInfoDao;
import com.shanhe.web.mapper.TeacherInfoDao;
import com.shanhe.web.pojo.StudentInfo;
import com.shanhe.web.pojo.TeacherInfo;
import com.shanhe.web.util.MybatisUtil;

public class ResultMapTest {
	
	
	
	public static void main(String[] args) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
//		StudentInfoDao sDao = sqlSession.getMapper(StudentInfoDao.class);
//		List<StudentInfo> list = sDao.selByResultMap();
//		for(StudentInfo stu : list){
//			System.out.println(stu.getName());
//		}
		TeacherInfoDao tDao = sqlSession.getMapper(TeacherInfoDao.class);
		List<TeacherInfo> tInfo = tDao.selByAll();
		for(TeacherInfo info : tInfo){
			System.out.print(info.getName() + ":");
			List<StudentInfo> list1 = info.getList();
			for(StudentInfo sinfo: list1){
				System.out.print(sinfo.getName());
			}
			System.out.println();
		}
		MybatisUtil.closeSession();
	}

}
