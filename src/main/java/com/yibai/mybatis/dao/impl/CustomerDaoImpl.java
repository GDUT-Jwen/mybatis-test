package com.yibai.mybatis.dao.impl;

import com.yibai.mybatis.dao.CustomerDao;
import com.yiibai.mybatis.models.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class CustomerDaoImpl implements CustomerDao{


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
    public Customer getCustomerById(Integer id) {
        SqlSession s = sqlSessionFactory.openSession();
        Customer customer = null;
        try {
            customer = s.selectOne("com.yiibai.mybatis.models.UserMapper.getCustomer", 1);
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            s.close();
        }
        return customer;
    }
}
