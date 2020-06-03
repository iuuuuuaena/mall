package com.tapd.serviceimpl;

import com.tapd.entities.MPublishGoods;
import com.tapd.service.MPublishGoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-02  21:09
 * @Version 1.0
 */
@Service
public class MPublishGoodsServiceImpl implements MPublishGoodsService {

    @Override
    public List<MPublishGoods> findAll() {
        return null;
    }

    @Override
    public MPublishGoods findById(Integer id) {
        return null;
    }

    @Override
    public MPublishGoods findByAccount(String account) {
        return null;
    }

    @Override
    public int create(MPublishGoods mPublishGoods) {
        return 0;
    }

    @Override
    public int delete(String account) {
        return 0;
    }

    @Override
    public int update(MPublishGoods mPublishGoods) {
        return 0;
    }
}
