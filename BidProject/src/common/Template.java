package common;

import static common.Template.getSqlSession;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/*
 * <pre>
 * Class : Template
 * Comment : 여러번 작성해야하는 번거로움을 줄이기 위한 클래스로 마이바티스를 사용하기 위한 정보를 작성하는 페이지입니다.
 * author : 이현도
 */
public class Template {

	private static SqlSessionFactory sqlsessionFactory;

	public static SqlSession getSqlSession() {
		if (sqlsessionFactory == null) {

			String resource = "mybatis-config.xml";
			InputStream inputStream;

			try {
				inputStream = Resources.getResourceAsStream(resource);
				sqlsessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return sqlsessionFactory.openSession(false);
		
	}
	
	

}
