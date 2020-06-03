package com.tapd.serviceimpl;

import com.tapd.entities.Discuss;
import com.tapd.service.DiscussService;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-02  22:15
 * @Version 1.0
 */
public class DiscussServiceImpl   implements DiscussService {
    @Override
    public List<Discuss> findAll() {
        return null;
    }

    @Override
    public Discuss findById(Integer id) {
        return null;
    }

    @Override
    public Discuss findByAccount(String account) {
        return null;
    }

    @Override
    public int create(Discuss discuss) {
        return 0;
    }

    @Override
    public int delete(String account) {
        return 0;
    }

    @Override
    public int update(Discuss discuss) {
        return 0;
    }
}
