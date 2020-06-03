package com.tapd.serviceimpl;

import com.tapd.entities.UPublishGoods;
import com.tapd.service.UPublishGoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-02  21:08
 * @Version 1.0
 */
@Service
public class UPublishGoodsServiceImpl implements UPublishGoodsService {

    @Override
    public List<UPublishGoods> findAll() {
        return null;
    }

    @Override
    public UPublishGoods findById(Integer id) {
        return null;
    }

    @Override
    public UPublishGoods findByAccount(String account) {
        return null;
    }

    @Override
    public int create(UPublishGoods uPublishGoods) {
        return 0;
    }

    @Override
    public int delete(String account) {
        return 0;
    }

    @Override
    public int update(UPublishGoods uPublishGoods) {
        return 0;
    }
}
