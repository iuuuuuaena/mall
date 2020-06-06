package com.tapd.mapper;

import com.tapd.entities.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 这是user_publish_goods表的mapper

@Mapper
public interface UPublishGoodsMapper {

    @Select("select * from  user_publish_goods_table")
    public List<Goods> showAllGoods();

    /**
     * 通过用户账号查询所有的他发布的商品
     * @param account
     * @return
     */
    @Select("select * from user_publish_goods_table where user_account = #{account}")
    public List<Goods> findByAccount(String account);


    /**
     * 通过商品名字模糊查询
     * @param goods_like_name
     * @return
     */
    @Select("select * from user_publish_goods_table where goods_name like %#{goods_like_name}%")
    public List<Goods> findLikeGoods(String goods_like_name);


    /**
     * 通过商品id查询
     * @param id
     * @return
     */
    @Select("select * from user_publish_goods_table where goods_id  = #{id}")
    public Goods findById(Integer id);


    // 回的是插入的条数，也就是插入的商品数量，一般就是一个，批量插入就是多个了
    @Insert("insert into user_publish_goods_table (user_nickname,user_account,goods_id,goods_name,goods_amount,goods_image,goods_info,goods_tag,is_deal)" +
            "values " +
            "(#{user_nickname},#{user_account},#{goods_id},#{goods_name},#{goods_amount},#{goods_image},#{goods_info},#{goods_tag},#{is_deal})")
    public  int insert(Goods goods);


    /**
     *  通过id删除商品
     * @param id
     * @return
     */
    @Delete("DELETE FROM user_publish_goods_table WHERE goods_id = #{id}")
    public int  deleteById(Integer id);


    /**
     * 传入要修改的goods
     * @param goods
     * @return
     */
    @Update(" UPDATE user_publish_goods_table" +
            "        SET user_nickname = #{user_nickname}," +
            "            user_account = #{user_account}," +
            "            goods_id = #{goods_id}," +
            "            goods_name = #{goods_name}," +
            "            goods_account = #{goods_account}," +
            "            goods_image = #{goods_image}," +
            "            goods_info = #{goods_info}," +
            "            goods_tag = #{goods_tag}," +
            "            is_deal = #{is_deal}" +
            "        WHERE goods_id = #{goods_id}")
    public int update(Goods goods);

}
