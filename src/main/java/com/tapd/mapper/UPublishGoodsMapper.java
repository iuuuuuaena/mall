package com.tapd.mapper;

import com.tapd.entities.UPublishGoods;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 这是user_publish_goods表的mapper

@Mapper
public interface UPublishGoodsMapper {


    /**
     * 通过Goods_id查找
     * @param id
     * @return
     */
    @Select("select * from user_publish_goods_table where goods_id = #{id}")
    public UPublishGoods findById(String id);

    /**
     *  通过账号删除用户
     * @param id
     * @return
     */
    @Delete("DELETE FROM user_publish_goods_table WHERE goods_id = #{id}")
    public int  deleteById(String id);

    /**
     * 插入发布商品
     * @param goods
     * @return  返回的是插入的条数，也就是插入的商品数量，一般就是一个，批量插入就是多个了
     */
    @Insert("insert into user_publish_goods_table (user_id,user_nickname,user_account,goods_id,goods_name,goods_account,goods_image,goods_info,goods_tag,is_deal)" +
            "values " +
            "(#{user_id},#{user_nickname},#{user_account},#{goods_id},#{goods_name},#{goods_account},#{goods_image},#{goods_info},#{goods_tag},#{is_deal})")
    public int insert(UPublishGoods goods);

    /**
     * 传入要修改的goods
     * @param goods
     * @return
     */
    @Update(" UPDATE user_publish_goods_table\n" +
            "        SET user_id = #{user_id},\n" +
            "            user_nickname = #{user_nickname},\n" +
            "            user_account = #{user_account},\n" +
            "            goods_id = #{goods_id},\n" +
            "            goods_name = #{goods_name},\n" +
            "            goods_account = #{goods_account},\n" +
            "            goods_image = #{goods_image},\n" +
            "            goods_info = #{goods_info},\n" +
            "            goods_tag = #{goods_tag},\n" +
            "            is_deal = #{is_deal}\n" +
            "        WHERE goods_id = #{goods_id}")
    public int update(UPublishGoods goods);

}
