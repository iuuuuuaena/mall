package com.tapd.service;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-01  10:26
 * @Version 1.0
 */


public interface BaseService<T> {

    // 查询所有
    List<T> findAll();

    //根据ID查询
    T findById(Integer id);

    //根据account查询
    T findByAccount(String account);

    //添加
    int  create(T t);

    //根据account删除
    int  delete(String account);

    //修改
    int  update(T t);
}

