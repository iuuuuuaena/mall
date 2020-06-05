package com.tapd.serviceimpl;

import com.tapd.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author jxd
 * @Date 2020-06-04  16:38
 * @Version 1.0
 */
public class FileServiceImpl implements FileService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String saveUploadFile(MultipartFile file, String path) {
        // 判断文件流是否为空
        if (file == null) return  null;
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 判断文件是否为空
        if (fileName==null) return null;
        logger.info("上传的文件名为：" + fileName);

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 用UUID重新命名
        fileName= UUID.randomUUID()+suffixName;
        // 用path和fileName保存图片
        File dest=new File(path+fileName);
        //dest=new File(dest.getAbsolutePath()+fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            if (!dest.getParentFile().mkdirs()){
                logger.error(dest.getParent()+"文件夹创建失败");
                return null;
            }else{
                logger.info(dest.getParent()+"文件夹创建成功");

            }
        }
        try {
            // 把文件流移动到磁盘指定位置
            file.transferTo(dest);
            // 返回UUID改变的文件名
            return fileName;
        } catch (IllegalStateException | IOException e) {
            logger.error(e.toString());
        }
        return null;
    }
}
