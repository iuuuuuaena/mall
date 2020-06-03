package com.tapd.service;

import com.tapd.entities.Discuss;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-02  22:15
 * @Version 1.0
 */
public interface DiscussService  {

    public List<Discuss> findAll();
    public Discuss findById(Integer id);
    public List<Discuss> findByAccount(String user_account);
    public List<Discuss> findByGoodsId(Integer id);
    public int create(Discuss discuss);
    public int delete(Integer id);
    public int update(Integer id);



}
