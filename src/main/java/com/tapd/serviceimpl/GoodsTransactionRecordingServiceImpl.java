package com.tapd.serviceimpl;

import com.tapd.entities.GoodsTransactionRecording;
import com.tapd.service.GoodsTransactionRecordingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-02  21:10
 * @Version 1.0
 */
@Service
public class GoodsTransactionRecordingServiceImpl  implements GoodsTransactionRecordingService {

    @Override
    public List<GoodsTransactionRecording> findAll() {
        return null;
    }

    @Override
    public GoodsTransactionRecording findById(Integer id) {
        return null;
    }

    @Override
    public GoodsTransactionRecording findByAccount(String account) {
        return null;
    }

    @Override
    public int create(GoodsTransactionRecording goodsTransactionRecording) {
        return 0;
    }

    @Override
    public int delete(String account) {
        return 0;
    }

    @Override
    public int update(GoodsTransactionRecording goodsTransactionRecording) {
        return 0;
    }
}
