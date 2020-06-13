package com.tapd.mapper;

import com.tapd.POJO.Discuss;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-02  22:04
 * @Version 1.0
 */
@Mapper
public interface DiscussMapper {

    @Select("select * from user_discuss_table")
    List<Discuss> showAllDiscuss();

    @Select("select * from user_discuss_table where user_account = #{account}")
    List<Discuss> findByAccount(String account);


    @Select("select * from user_discuss_table where goods_id = #{id}")
    List<Discuss> findByGoodsId(Integer id);


    @Delete("select * from  user_discuss_table where discuss_id = #{discuss_id}")
    Discuss findById(Integer discuss_id);


    @Insert("insert into user_discuss_table (user_account,user_nickname,goods_id,discuss_content) values(#{user_account},#{user_nickname},#{goods_id},#{discuss_content})")
    int insert(Discuss discuss);

    @Delete("delete from  user_discuss_table where discuss_id = #{discuss_id}")
    int delete(Integer discuss_id);

    @Update("update user_discuss_table " +
            "set discuss_content = #{discuss_content}" +
            "where discuss_id = #{discuss_id}")
    int update(Discuss discuss);


}
