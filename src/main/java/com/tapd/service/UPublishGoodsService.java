package com.tapd.service;


import com.tapd.entities.Goods;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-02  21:06
 * @Version 1.0
 */
// 这个我们没有必要继承基础的service因为有的方法我们不需要实现
public interface UPublishGoodsService  {

    public List<Goods> findAll();
    public Goods findById(Integer id);
    public List<Goods> findByAccount(String account);
    public List<Goods> findLikeGoods(String name);
    public int create(Goods goods);

    public int deleteById(Integer id);

    public int update(Goods goods);
}
