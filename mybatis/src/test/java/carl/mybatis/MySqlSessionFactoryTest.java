package carl.mybatis;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import carl.mybatis.dao.BlogMapper;
import carl.mybatis.model.Blog;

public class MySqlSessionFactoryTest extends TestCase{

	
	public void testSessionFactory(){
		SqlSessionFactory sqlSessionFactory = MySqlSessionFactory.getInstance();
		SqlSession session = sqlSessionFactory.openSession();
		BlogMapper mapper = session.getMapper(BlogMapper.class);
		Blog blog = mapper.selectBlog(101);
		System.out.println(blog.getName());
		session.close();
	}
}
