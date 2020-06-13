package com.tapd.serviceimpl;

import com.tapd.POJO.ReceiveInfo;
import com.tapd.mapper.ReceiveInfoMapper;
import com.tapd.service.ReceiveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-12  16:26
 * @Version 1.0
 */
@Service
public class ReceiveInfoServiceImpl implements ReceiveInfoService {


    @Autowired
    ReceiveInfoMapper receiveInfoMapper;
    @Override
    public int insert(ReceiveInfo receiveInfo) {
        return receiveInfoMapper.createReceive(receiveInfo);
    }

    @Override
    public List<ReceiveInfo> findAllInfo() {
        return receiveInfoMapper.findAllReceive();
    }

    @Override
    public int deleteById(int id) {
        return receiveInfoMapper.deleteInfo(id);
    }
}
