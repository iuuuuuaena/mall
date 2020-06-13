package com.tapd.service;

import com.tapd.POJO.Order;
import com.tapd.POJO.OrderGoods;
import com.tapd.POJO.Refund;

import java.util.List;
import java.util.OptionalDouble;

/**
 * @Author jxd
 * @Date 2020-06-02  21:08
 * @Version 1.0
 */
public interface OrderService {



    List<Order> showAllOrder();

    /**
     * 通过account获取一个用户的订单
     *
     * @param account
     * @return 订单列表
     */
    List<Order> getOrdersByUserAccount(String account);

    /**
     * 通过GoodsID获取订单
     *
     * @param id 商品Id
     * @return 订单列表
     */
    Order getOrdersByGoodsId(int id);

    /**
     * 通过order_id获取订单
     *
     * @param id
     * @return
     */
    Order getOrderByOrderId(String id);


    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    int creatOrder(Order order);

    /**
     * 取消订单
     *
     * @param id
     * @return
     */
    int cancelOrderByOrderId(String id);

    /**
     * 设置为退款订单
     *
     * @param id
     * @return
     */
    int setRefundOrderByOrderId(String id);


    /**
     * 添加退款订单
     *
     * @param refund
     * @return
     */
    int addRefundOrder(Refund refund);


    /**
     * 保存订单里的一个商品
     * @param orderGoods
     * @return
     */
    int saveOneGoods(OrderGoods orderGoods);
    // int refundOrder(int id);


    /**
     * 通过id删除订单
     * @param id
     * @return
     */
    int deleteById(String id);


    /**
     * 查询一个订单的 所有商品
     * @param id
     * @return
     */
    List<OrderGoods> findAllGoods(String id);
}
