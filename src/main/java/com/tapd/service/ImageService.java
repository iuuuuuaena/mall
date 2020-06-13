package com.tapd.service;

import com.tapd.POJO.Image;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-12  21:31
 * @Version 1.0
 */
public interface ImageService {


    int update1(String path);

    int update2(String path);

    int update3(String path);


    List<Image> findAll();
}
