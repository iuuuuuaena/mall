package com.tapd.mapper;

import com.tapd.POJO.ReceiveInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-12  16:16
 * @Version 1.0
 */
@Mapper
public interface ReceiveInfoMapper {


    /**
     *  新建收获信息
     * @return
     */
    @Insert("insert into shopping_address (user_account,user_nickname,user_phone,city,area,street,specific_address,is_default)" +
            "values (#{user_account},#{user_nickname},#{user_phone},#{city},#{area},#{street},#{specific_address},#{is_default})")
    int createReceive(ReceiveInfo receiveInfo);

    /**
     * 找到所有的收获信息
     * @return
     */
    @Select("select * from shopping_address ")
    List<ReceiveInfo> findAllReceive();


    /**
     * 通过id删除这个
     * @param id
     * @return
     */
    @Delete("delete from shopping_address where id = #{id} ")
    int deleteInfo(int id);





}
