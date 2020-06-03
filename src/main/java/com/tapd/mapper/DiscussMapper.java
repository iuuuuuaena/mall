package com.tapd.mapper;

import com.tapd.entities.Discuss;
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
    public List<Discuss> showAllDiscuss();

    @Select("select * from user_discuss_table where user_account = #{account}")
    public List<Discuss> findByAccount(String account);


    @Select("select * from user_discuss_table where goods_id = #{id}")
    public List<Discuss> findByGoodsId(Integer id);


    @Delete("select * from  user_discuss_table where discuss_id = #{discuss_id}")
    public Discuss findById(Integer discuss_id);


    @Insert("insert into user_discuss_table (user_account,user_nickname,discuss_content) values(#{user_account},#{user_nickname},#{discuss_content})")
    public int insert(Discuss discuss);

    @Delete("delete from  user_discuss_table where discuss_id = #{discuss_id}")
    public int delete(Integer discuss_id);

    @Update("update user_discuss_table " +
                "set discuss_content = #{discuss_content}" +
            "where discuss_id = #{discuss_id}")
    public int update(Integer discuss_id);




}
