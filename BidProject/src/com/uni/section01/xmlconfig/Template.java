package com.uni.section01.xmlconfig;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	private static SqlSessionFactory sqlsessionFactory;

	public static SqlSession getSqlSession() {
		if (sqlsessionFactory == null) {

			String resource = "com/uni/section01/xmlconfig/mybatis-config.xml";
			InputStream inputStream;

			try {
				inputStream = Resources.getResourceAsStream(resource);
				sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		SqlSession sqlSession = sqlsessionFactory.openSession(false);

		System.out.println("sqlSessionFactory의 hashcode" + sqlsessionFactory.hashCode());
		System.out.println("sqlSession의 hashcode" + sqlSession.hashCode());

		return sqlSession;
	}

}
