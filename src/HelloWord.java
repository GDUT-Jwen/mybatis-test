import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.models.*;

public class HelloWord {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure.xml");
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
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try {
			MYBATISUSER user = (MYBATISUSER) session.selectOne("com.yiibai.mybatis.models.UserMapper.GetUserByID", 1);
			List<NwppUser> ryList = session.selectList("com.yiibai.mybatis.models.UserMapper.GetNwppUserByName", "方德琳");

			if (user != null) {
				String userInfo = "名字：" + user.getName() + ", 所属部门：" + user.getDept() + ", 主页：" + user.getWebsite();
				System.out.println(userInfo);
			}

			if (ryList != null) {
				for (NwppUser ry : ryList) {
					System.out.println("名字：" + ry.getRyxm() + ", 身份证：" + ry.getSfzjhm());
				}
			}

		} finally {
			session.close();
		}
	}
}
