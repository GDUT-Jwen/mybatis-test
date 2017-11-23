import com.yibai.mybatis.dao.CustomerDao;
import com.yibai.mybatis.dao.UserDao;
import com.yibai.mybatis.dao.impl.CustomerDaoImpl;
import com.yibai.mybatis.dao.impl.UserDaoImpl;
import com.yiibai.mybatis.models.Customer;
import com.yiibai.mybatis.models.Post;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class HelloWord {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("Configure.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		CustomerDao cd = new CustomerDaoImpl();
//		Customer c = cd.getCustomerById(1);
//		if(null != c) {
//			System.out.println(c.getName());
//		}

		List<Post> posts = new ArrayList<Post>();
		UserDao ud = new UserDaoImpl();
		posts = ud.getPosts();
		for(Post p : posts) {
			System.out.println(p.getTitle());
			System.out.println(p.getContent());
		}



	}
}
