package carl.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
	
	private static SqlSessionFactory sqlSessionFactory; 
	
	private MySqlSessionFactory() {
		
	}

	private static void getSqlSessionFactory(){
		String resource = "configuration.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getInstance(){
		if(null == sqlSessionFactory){
			getSqlSessionFactory();
		}
		return sqlSessionFactory;
	}
}
