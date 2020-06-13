package com.tapd.serviceimpl;

import com.tapd.POJO.Image;
import com.tapd.mapper.ImageMapper;
import com.tapd.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-12  21:35
 * @Version 1.0
 */
@Service
public class ImageServiceImpl implements ImageService {


    @Autowired
    ImageMapper imageMapper;



    @Override
    public int update1(String path) {
        return imageMapper.update1(path);
    }

    @Override
    public int update2(String path) {
        return imageMapper.update2(path);
    }

    @Override
    public int update3(String path) {
        return imageMapper.update3(path);
    }

    @Override
    public List<Image> findAll() {
        return imageMapper.findAll();
    }
}
