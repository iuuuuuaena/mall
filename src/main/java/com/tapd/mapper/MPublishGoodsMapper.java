package com.tapd.mapper;

import com.tapd.entities.MPublishGoods;

import org.apache.ibatis.annotations.*;

// 这是user_publish_goods表的mapper

@Mapper
public interface MPublishGoodsMapper {


    /**
     * 通过Goods_id查找
     * @param id
     * @return
     */
    @Select("select * from manager_publish_goods_table where goods_id = #{id}")
    public MPublishGoods findById(Integer id);

    /**
     *  通过账号删除用户
     * @param id
     * @return
     */
    @Delete("DELETE FROM manager_publish_goods_table WHERE goods_id = #{id}")
    public int  deleteById(Integer id);

    /**
     * 插入发布商品
     * @param goods
     * @return  返回的是插入的条数，也就是插入的商品数量，一般就是一个，批量插入就是多个了
     */
    @Insert("insert into manager_publish_goods_table (manager_id,manager_nickname,manager_account,goods_id,goods_name,goods_account,goods_image,goods_info,goods_tag,is_deal)" +
            "values " +
            "(#{manager_id},#{manager_nickname},#{manager_account},#{goods_id},#{goods_name},#{goods_account},#{goods_image},#{goods_info},#{goods_tag},#{is_deal})")
    public int insert(MPublishGoods goods);

    /**
     * 传入要修改的goods
     * @param goods
     * @return
     */
    @Update(" UPDATE manager_publish_goods_table\n" +
            "        SET manager_id = #{manager_id},\n" +
            "            manager_nickname = #{manager_nickname},\n" +
            "            manager_account = #{manager_account},\n" +
            "            goods_id = #{goods_id},\n" +
            "            goods_name = #{goods_name},\n" +
            "            goods_account = #{goods_account},\n" +
            "            goods_image = #{goods_image},\n" +
            "            goods_info = #{goods_info},\n" +
            "            goods_tag = #{goods_tag},\n" +
            "            is_deal = #{is_deal}\n" +
            "        WHERE goods_id = #{goods_id}")
    public int update(MPublishGoods goods);

}
