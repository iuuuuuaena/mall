package com.tapd.serviceimpl;

import com.tapd.entities.Goods;
import com.tapd.mapper.UPublishGoodsMapper;
import com.tapd.service.UPublishGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-02  21:08
 * @Version 1.0
 */
@Service
public class UPublishGoodsServiceImpl implements UPublishGoodsService {


    @Autowired
    UPublishGoodsMapper uPublishGoodsMapper;



    public List<Goods> findAll() {
        return uPublishGoodsMapper.showAllGoods();
    }

    public Goods findById(Integer id) {
        return uPublishGoodsMapper.findById(id);
    }


    public List<Goods> findByAccount(String account) {
        return uPublishGoodsMapper.findByAccount(account);
    }


    public List<Goods> findLikeGoods(String name) {
        return uPublishGoodsMapper.findLikeGoods(name);
    }



    public int create(Goods goods) {
        return uPublishGoodsMapper.insert(goods);
    }


    public int deleteById(Integer id) {
        return uPublishGoodsMapper.deleteById(id);
    }

    public int update(Goods goods) {
        return uPublishGoodsMapper.update(goods);
    }
}
