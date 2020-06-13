package com.tapd.serviceimpl;

import com.tapd.POJO.Order;
import com.tapd.POJO.OrderGoods;
import com.tapd.POJO.Refund;
import com.tapd.mapper.OrderMapper;
import com.tapd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-02  21:10
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> showAllOrder() {
        return orderMapper.showAllOrder();
    }

    @Override
    public List<Order> getOrdersByUserAccount(String account) {
        return orderMapper.findByUserAccount(account);
    }

    @Override
    public Order getOrdersByGoodsId(int id) {
        return orderMapper.findByGoodsId(id);
    }

    @Override
    public Order getOrderByOrderId(String id) {
        return orderMapper.findByOrderId(id);
    }

    @Override
    public int creatOrder(Order order) {
        return orderMapper.create(order);
    }

    @Override
    public int cancelOrderByOrderId(String id) {
        return orderMapper.setOrderCancelByOrderId(id);
    }

    @Override
    public int setRefundOrderByOrderId(String id) {
        return orderMapper.setOrderRefundByOrderId(id);
    }

    @Override
    public int addRefundOrder(Refund refund) {
        return orderMapper.addRefundOrder(refund);
    }

    @Override
    public int saveOneGoods(OrderGoods orderGoods) {
        return orderMapper.saveOneGoods(orderGoods);
    }

    @Override
    public int deleteById(String id) {
        return orderMapper.deleteById(id);
    }

    @Override
    public List<OrderGoods> findAllGoods(String id) {
        return orderMapper.findAllGoods(id);
    }
}
