import com.yibai.mybatis.dao.ProductDao;
import com.yibai.mybatis.dao.impl.ProductDaoImpl;
import com.yiibai.mybatis.models.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

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
		Product pd = new Product();
		pd.setId("001");
		pd.setName("apple");
//		pd.setPrice(15.5f);
		ProductDao pdDao = new ProductDaoImpl();
		System.out.println("受影响结果数:" + pdDao.update(pd));
	}
}
