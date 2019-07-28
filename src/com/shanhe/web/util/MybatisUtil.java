package com.shanhe.web.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

    private static SqlSessionFactory sessionFactory;
    private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();

    static{
        try {
        	System.out.println("classpath=============" + Thread.currentThread().getContextClassLoader ().getResource("") );
 
//        	Resources.
            InputStream is = org.apache.ibatis.io.Resources.getResourceAsStream("mybatis.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        SqlSession session = tl.get();
        if (null == session){
            tl.set(session = sessionFactory.openSession());
        }
        return session ;
    }

    public static void closeSession(){
        SqlSession session = tl.get();
        if(null != null){
            session.close();
        }
        tl.set(null);
    }

}
