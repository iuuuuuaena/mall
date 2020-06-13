package com.tapd.mapper;

import com.tapd.POJO.Order;
import com.tapd.POJO.OrderGoods;
import com.tapd.POJO.Refund;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @Author jxd
 * @Date 2020-06-02  21:01
 * @Version 1.0
 */
// 订单mapper
@Mapper
public interface OrderMapper {



    @Select("select * from the_mall_order")
    List<Order> showAllOrder();
    /**
     * 通过order_id查找订单
     *
     * @param order_id
     * @return
     */
    @Select("select * from the_mall_order where order_id = #{id}")
    Order findByOrderId(String order_id);

    //
    // /**
    //  * 通过id删除订单
    //  *
    //  * @param id
    //  * @return
    //  */
    // @Delete("DELETE FROM the_mall_order WHERE order_id = #{id}")
    // int deleteByOrderId(String id);
    //

    /**
     * 通过用户账号查询订单
     *
     * @param account
     * @return
     */
    @Select("select * from the_mall_order where user_account = #{account}")
    List<Order> findByUserAccount(String account);

    /**
     * 通过商品id查询订单
     *
     * @param id
     * @return
     */
    @Select("select *  from the_order_goods where goods_id = #{id}")
    Order findByGoodsId(Integer id);


    /**
     * 新建订单
     *
     * @param order
     * @return 返回的是插入的条数，也就是插入的商品数量，一般就是一个，批量插入就是多个了
     */
    @Insert("insert into the_mall_order (order_id,user_account,order_info,order_price,order_date)" +
            "values " +
            "(#{order_id},#{user_account},#{order_info},#{order_price},#{order_date})")
    int create(Order order);

    //
    // /**
    //  * 传入要修改的goods
    //  *
    //  * @param goods
    //  * @return
    //  */
    // @Update(" UPDATE the_mall_order" +
    //         "        SET goods_name = #{goods_name}," +
    //         "            goods_account = #{goods_account}," +
    //         "            is_deal = #{is_deal}" +
    //         "        WHERE goods_id = #{goods_id}")
    // int update(Order goods);


    /**
     * 查询 所有成功的订单
     *
     * @return
     */
    @Select("select * from the_mall_table where order_status = 1")
    List<Order> findByOrderSuccess();


    /**
     * 查询所有取消的的订单
     *
     * @return
     */
    @Select("select * from the_mall_table where order_status = 0")
    List<Order> findByOrderCancel();


    /**
     * 查询所有退款的的订单
     *
     * @return
     */
    @Select("select * from the_mall_table where order_status = 2")
    List<Order> findByOrderRefund();

    /**
     * 设置为完成订单
     *
     * @return
     */
    @Update("update the_mall_table " +
            "set order_status = 1" +
            "where order_id = #{id}")
    int  setOrderSuccessByOrderId(String id);


    /**
     * 设置为取消订单
     *
     * @return
     */
    @Update("update the_mall_table " +
            "set order_status = 0" +
            "where order_id = #{id}")
    int  setOrderCancelByOrderId(String id);


    /**
     * 设置为退款订单
     *
     * @return
     */
    @Update("update the_mall_table " +
            "set order_status = 2" +
            "where order_id = #{id}")
    int  setOrderRefundByOrderId(String id);


    /**
     * 添加退款订单
     *
     * @return
     */
    @Insert("insert into the_mall_refund (order_id,order_info,refund_price,refund_reason)" +
            "values(#{order_id},#{order_info},#{refund_price},#{refund_reason})")
    int addRefundOrder(Refund refund);


    /**
     * 订单的所有商品 ，一个一个插入
     * @param orderGoods
     * @return
     */
    @Insert("insert into the_order_goods (order_id,user_account,goods_id,goods_name,goods_image,goods_number,goods_price) " +
            "values (#{order_id},#{user_account},#{goods_id},#{goods_name},#{goods_image},#{goods_number},#{goods_price})")
    int saveOneGoods(OrderGoods orderGoods);


    /**
     * 通过id删除交易订单
     * @param id
     * @return
     */
    @Delete("delete from the_mall_order order where order_id = #{id}")
    int deleteById(String id);


    /**
     * 查询 一个订单号的所有商品
     * @param order_id
     * @return
     */
    @Select("select * from the_order_goods where order_id = #{order_id}")
    List<OrderGoods> findAllGoods(String order_id);
}
