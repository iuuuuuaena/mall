package com.tapd.service;


import com.tapd.POJO.Goods;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-02  21:06
 * @Version 1.0
 */
// 这个我们没有必要继承基础的service因为有的方法我们不需要实现
public interface UPublishGoodsService {

    List<Goods> findAll();

    Goods findById(Integer id);

    List<Goods> findByAccount(String account);

    List<Goods> findLikeGoods(String name);

    int create(Goods goods);

    int deleteById(Integer id);

    int update(Goods goods);

    List<Goods> findByUserAccount(String account);

    List<String> findAllTag();

    List<Goods> findGoodsByTag(String tag);
}
