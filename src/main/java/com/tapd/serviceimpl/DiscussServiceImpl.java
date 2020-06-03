package com.tapd.serviceimpl;

import com.tapd.entities.Discuss;
import com.tapd.mapper.DiscussMapper;
import com.tapd.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-02  22:15
 * @Version 1.0
 */
public class DiscussServiceImpl   implements DiscussService {



    @Autowired
    DiscussMapper discussMapper;
    @Override
    public List<Discuss> findAll() {
        return discussMapper.showAllDiscuss();
    }

    @Override
    public Discuss findById(Integer id) {
        return discussMapper.findById(id);
    }

    @Override
    public List<Discuss> findByAccount(String user_account) {
        return discussMapper.findByAccount(user_account);
    }

    @Override
    public List<Discuss> findByGoodsId(Integer id) {
        return discussMapper.findByGoodsId(id);
    }

    @Override
    public int create(Discuss discuss) {
        return discussMapper.insert(discuss);
    }

    @Override
    public int delete(Integer id) {
        return discussMapper.delete(id);
    }

    @Override
    public int update(Integer id) {
        return discussMapper.update(id);
    }
}
