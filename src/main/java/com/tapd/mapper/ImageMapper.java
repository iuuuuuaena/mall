package com.tapd.mapper;

import com.tapd.POJO.Image;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-12  21:31
 * @Version 1.0
 */
@Mapper
public interface ImageMapper {


    /**
     * 插入轮播图图片
     * @param image
     * @return
     */
    @Insert("insert into image (path) values (#{path})")
    int insert(Image image);

    @Update("update image set path = #{path} where id = 1")
    int update1(String path);

    @Update("update image set path = #{path} where id = 2")
    int update2(String path);

    @Update("update image set path = #{path} where id = 3")
    int update3(String path);



    @Select("select * from image")
    List<Image> findAll();

}
