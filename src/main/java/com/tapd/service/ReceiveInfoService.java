package com.tapd.service;

import com.tapd.POJO.ReceiveInfo;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-12  16:24
 * @Version 1.0
 */
public interface ReceiveInfoService {

    int insert(ReceiveInfo receiveInfo);

    List<ReceiveInfo> findAllInfo();

    int deleteById(int id);
}
