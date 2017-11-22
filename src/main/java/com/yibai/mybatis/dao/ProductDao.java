package com.yibai.mybatis.dao;

import com.yiibai.mybatis.models.Product;

public interface ProductDao {

    //增加商品
    public Integer save(Product p);

    //删除商品
    public Integer delete(Product p);

    //更新商品
    public Integer update(Product p);
}
