package com.yibai.mybatis.dao.impl;

import com.yibai.mybatis.dao.ProductDao;
import com.yiibai.mybatis.models.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class ProductDaoImpl implements ProductDao {

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


    public Integer save(Product p) {
        SqlSession s = sqlSessionFactory.openSession();
        int result = 0;
        try {
            result = s.insert("com.yiibai.mybatis.models.UserMapper.addProduct", p);
            s.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            s.close();
        }
        return result;
    }

    public Integer delete(Product p) {
        SqlSession s = sqlSessionFactory.openSession();
        int result = 0;
        try {
            result = s.delete("com.yiibai.mybatis.models.UserMapper.deleteProduct", p);
            s.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            s.close();
        }
        return result;
    }

    public Integer update(Product p) {
        SqlSession s = sqlSessionFactory.openSession();
        int result = 0;
        try {
            result = s.update("com.yiibai.mybatis.models.UserMapper.updateProduct", p);
            s.commit();
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            s.close();
        }
        return result;
    }
}
