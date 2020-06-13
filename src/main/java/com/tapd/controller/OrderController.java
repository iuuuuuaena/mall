package com.tapd.controller;

import com.tapd.POJO.Order;
import com.tapd.POJO.OrderGoods;
import com.tapd.config.AliPayConfig;
import com.tapd.enums.ResponseStatus;
import com.tapd.service.OrderService;
import com.tapd.utils.OrderNoUtils;
import com.tapd.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-09  10:04
 * @Version 1.0
 */
@Controller
public class OrderController {

    Logger logger = LoggerFactory.getLogger(getClass());

    OrderService orderService;

    @Autowired
    void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }


    // ------------------------------------后台管理-----------------------------------


    @RequestMapping(value = "/ready",method = RequestMethod.GET)
    public void showList(Model model) {
        List<Order> orders = orderService.showAllOrder();
        if(orders != null){
            model.addAttribute("orders", orders);
        }
    }



    /**
     * 显示所有的订单
     * @param model
     * @return
     */
    @RequestMapping("/orders")
    public String showAllOrder(Model model) {
        List<Order> orders = orderService.showAllOrder();
        if(orders == null){
            return "order/list";
        }else{
            model.addAttribute("orders", orders);
            return "order/list";
        }
    }

    /**
     * 通过 order_id 找订单
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/orderById")
    public Object findOrderById(@RequestParam("id") String id) {

        Order order = orderService.getOrderByOrderId(id);
        if (order == null){
            return ResultUtils.fail(ResponseStatus.NO_THIS_ORDER_ID);
        }
        return order;
    }


    @DeleteMapping(value = "/order/{order_id}")
    public String deleteUser(@PathVariable("order_id") String order_id) {
        System.out.println("要删除的order_id为:" + order_id);
        orderService.deleteById(order_id);
        return "redirect:/orders";
    }






//    0-----------------------------------前端商城--------------------------------------

    @ResponseBody
    @PostMapping("/createOrder")
    public Object createOrder(Order order){
        System.out.println("获取到的order为"+order);

        if (order.getUser_account() == null||order.getUser_account().equals("")||order.getUser_account().equals("undefined")){
            return ResultUtils.fail(ResponseStatus.USER_ACCOUNT_NUT_NULL.getCode(),ResponseStatus.USER_ACCOUNT_NUT_NULL.getMsg()
                    ,ResponseStatus.USER_ACCOUNT_NUT_NULL);
        }
        String order_id = OrderNoUtils.getInstance().GenerateOrder();
        order.setOrder_id(order_id);

        if(orderService.creatOrder(order) != 1){
            // 订单创建失败
            logger.error("订单创建失败");
            System.out.println("失败");
            return ResultUtils.fail(ResponseStatus.ORDER_CREATE_FAIL.getCode(),ResponseStatus.ORDER_CREATE_FAIL.getMsg()
                    ,ResponseStatus.ORDER_CREATE_FAIL);
        }else{
            //  返回订单的信息
            logger.info("订单创建成功");
            System.out.println("成功");
            return ResultUtils.ok(ResponseStatus.ORDER_CREATE_SUCCESS.getCode(),ResponseStatus.ORDER_CREATE_SUCCESS.getMsg(),order);
        }
    }


    @ResponseBody
    @GetMapping("/getOrderByAccount")
    public Object showAllUserOrderByUserAccount(@RequestParam("user_account")String user_account){

        System.out.println("account:"+user_account);
        // 用户名不能为空
        if (user_account == "" ||user_account == null|| user_account.equals("undefined")) {
            return ResultUtils.fail(ResponseStatus.USER_ACCOUNT_NUT_NULL.getCode(), ResponseStatus.USER_ACCOUNT_NUT_NULL.getMsg()
                    , ResponseStatus.USER_ACCOUNT_NUT_NULL);
        }

        List<Order> allOrder = orderService.getOrdersByUserAccount(user_account);
        if (allOrder == null){
            // 返回没有订单
            logger.error("该用户u没有订单");
            return ResultUtils.fail(ResponseStatus.NO_ORDER.getCode(),ResponseStatus.NO_ORDER.getMsg(),ResponseStatus.NO_ORDER);
        }else{
            //有的话，直接返回列表
            return allOrder;
        }

    }



//    如果一个订单以此多个商品的话，就保存在另一张表里面
    @ResponseBody
    @GetMapping("/saveOne")
    public Object saveAllGoodsOfOneOrder(OrderGoods orderGoods){

        // 订单号不能为空
        if (orderGoods.getOrder_id() == null ||orderGoods.getOrder_id().equals("undefined")){
            // 6002  订单号不能为空
            return ResultUtils.fail(ResponseStatus.BLANK_ORDER_NO.getCode(),ResponseStatus.BLANK_ORDER_NO.getMsg(),ResponseStatus.BLANK_ORDER_NO);
        }

        int result = orderService.saveOneGoods(orderGoods);
        if (result != 1) {
            // 607  商品上传失败
            return ResultUtils.fail(ResponseStatus.GOODS_PUBLISH_FAIL.getCode(),ResponseStatus.GOODS_PUBLISH_FAIL.getMsg(),ResponseStatus.GOODS_PUBLISH_FAIL);
        }else{
            // 606  商品上传成功
            return ResultUtils.fail(ResponseStatus.GOODS_PUBLISH_SUCCESS.getCode(),ResponseStatus.GOODS_PUBLISH_SUCCESS.getMsg(),ResponseStatus.GOODS_PUBLISH_SUCCESS);

        }
    }
    // 通过订单号，查询这个订单的所有商品
    @ResponseBody
    @GetMapping("/findAllGoodsOfOrder")
    public Object findTheOrdersAllGoods(@RequestParam("order_id")String order_id){

        // 订单号不能为空
        if (order_id == null |order_id.equals("undefined")||order_id.equals("")){
            // 6002  订单号不能为空
            return ResultUtils.fail(ResponseStatus.BLANK_ORDER_NO.getCode(),ResponseStatus.BLANK_ORDER_NO.getMsg(),ResponseStatus.BLANK_ORDER_NO);
        }

        List<OrderGoods> allGoods = orderService.findAllGoods(order_id);
        if (allGoods == null) {
            // 612   该订单没有商品
            return ResultUtils.fail(ResponseStatus.NO_GOODS_IN_THIS_ORDER.getCode(),ResponseStatus.NO_GOODS_IN_THIS_ORDER.getMsg(),ResponseStatus.NO_GOODS_IN_THIS_ORDER);
        }else{
            // 613  该订单商品查询成功
            return ResultUtils.fail(ResponseStatus.FIND_GOODS_IN_THIS_ORDER_SUCCESS.getCode(),ResponseStatus.FIND_GOODS_IN_THIS_ORDER_SUCCESS.getMsg(),allGoods);

        }
    }
}
