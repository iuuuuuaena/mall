package com.tapd.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author jxd
 * @Date 2020-06-04  16:35
 * @Version 1.0
 */

public interface FileService {


    public  String saveUploadFile(MultipartFile file, String path);

}
