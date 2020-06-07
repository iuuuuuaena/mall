package com.tapd.mapper;

import com.tapd.entities.GoodsTransactionRecording;
import org.apache.ibatis.annotations.*;


/**
 * @Author jxd
 * @Date 2020-06-02  21:01
 * @Version 1.0
 */
public interface GoodsTransactionRecordingMapper {


// 这是goods_transaction_recording表的mapper


    /**
     * 通过Goods_id查找
     *
     * @param id
     * @return
     */
    @Select("select * from goods_transaction_recording_table where goods_id = #{id}")
    public GoodsTransactionRecording findById(Integer id);

    /**
     * 通过账号删除用户
     *
     * @param id
     * @return
     */
    @Delete("DELETE FROM goods_transaction_recording_table WHERE goods_id = #{id}")
    public int deleteById(Integer id);

    /**
     * 插入商品
     *
     * @param goods
     * @return 返回的是插入的条数，也就是插入的商品数量，一般就是一个，批量插入就是多个了
     */
    @Insert("insert into goods_transaction_recording_table (goods_id,goods_name,goods_account,is_deal)" +
            "values " +
            "(#{goods_id},#{goods_name},#{goods_account},#{is_deal})")
    public int insert(GoodsTransactionRecording goods);

    /**
     * 传入要修改的goods
     *
     * @param goods
     * @return
     */
    @Update(" UPDATE goods_transaction_recording_table" +
            "        SET goods_id = #{goods_id}," +
            "            goods_name = #{goods_name}," +
            "            goods_account = #{goods_account}," +
            "            is_deal = #{is_deal}" +
            "        WHERE goods_id = #{goods_id}")
    public int update(GoodsTransactionRecording goods);

}
