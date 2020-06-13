package com.tapd.serviceimpl;

import com.tapd.POJO.Goods;
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



    UPublishGoodsMapper uPublishGoodsMapper;

    @Autowired
    void setuPublishGoodsMapper(UPublishGoodsMapper uPublishGoodsMapper){this.uPublishGoodsMapper = uPublishGoodsMapper;}

    @Override
    public List<Goods> findAll() {
        return uPublishGoodsMapper.showAllGoods();
    }

    @Override
    public Goods findById(Integer id) {
        return uPublishGoodsMapper.findById(id);
    }

    @Override
    public List<Goods> findByAccount(String account) {
        return uPublishGoodsMapper.findByAccount(account);
    }

    @Override
    public List<Goods> findLikeGoods(String name) {
        return uPublishGoodsMapper.findLikeGoods(name);
    }

    @Override
    public int create(Goods goods) {
        return uPublishGoodsMapper.insert(goods);
    }

    @Override
    public int deleteById(Integer id) {
        return uPublishGoodsMapper.deleteById(id);
    }

    @Override
    public int update(Goods goods) {
        return uPublishGoodsMapper.update(goods);
    }

    @Override
    public List<Goods> findByUserAccount(String account) {
        return uPublishGoodsMapper.findByUserAccount(account);
    }

    @Override
    public List<String> findAllTag() {
        return uPublishGoodsMapper.findAllTag();
    }

    @Override
    public List<Goods> findGoodsByTag(String tag) {
        return uPublishGoodsMapper.findGoodsByTag(tag);
    }
}
