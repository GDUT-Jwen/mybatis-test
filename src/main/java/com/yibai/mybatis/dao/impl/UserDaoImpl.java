package com.yibai.mybatis.dao.impl;

import com.yibai.mybatis.dao.UserDao;
import com.yiibai.mybatis.models.MybatisUser;
import com.yiibai.mybatis.models.Post;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{


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

    @Override
    public List<Post> getPosts() {
        SqlSession s = sqlSessionFactory.openSession();
        List<Post> postList = new ArrayList<Post>();
        try {
            MybatisUser mu = s.selectOne("com.yiibai.mybatis.models.UserMapper.getUser", 1);
            postList = mu.getPosts();

        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            s.close();
        }
        return postList;

    }
}
