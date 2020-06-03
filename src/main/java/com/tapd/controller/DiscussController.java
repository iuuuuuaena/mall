package com.tapd.controller;

import com.tapd.entities.Discuss;
import com.tapd.serviceimpl.DiscussServiceImpl;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-03  18:40
 * @Version 1.0
 */
@Controller
public class DiscussController {


    @Autowired
    DiscussServiceImpl discussService;


    //跳转到评论界面，并显示所有评论
    // 显示所有评论
    @GetMapping("/discuss")
    public String showAllDiscuss() {
         discussService.findAll();
        return "goods/list";
    }


    @PostMapping("/discuss/{goods_id}")
    public String deleteDiscuss(@PathVariable("goods_id") Integer goods_id){

        discussService.delete(goods_id);
        return "goods/list";
    }


    //---------------------------前端-------------


    // 前端页面的通过discussid查
    @GetMapping("/discussesId")
    public Discuss findByDiscussId(@RequestParam("discuss_id") Integer discuss_id) {
        Discuss discuss = discussService.findById(discuss_id);
        return discuss;

    }

    // 前端页面的通过user_acccount查
    @GetMapping("/discussByAccount")
    public List<Discuss> findByAccount(@RequestParam("user_account") String user_account) {
        List<Discuss> discussOfGoods = discussService.findByAccount(user_account);
        return discussOfGoods;

    }

    // 前端页面的通过GoodsId查
    @GetMapping("/discussByGoodsId")
    public List<Discuss> findByGoodsId(@RequestParam("goods_id") Integer goods_id) {
        List<Discuss> discussOfGoods = discussService.findByGoodsId(goods_id);
        return discussOfGoods;

    }

    // 前端页面的添加评论
    @PostMapping("/discussCreate")
    public int createDiscuss(Discuss discuss) {

        int result = discussService.create(discuss);

        return 0;
    }


    // 前端页面的删除评论
    @PostMapping("/discussDelete")
    public int Discuss(@RequestParam("goods_id") Integer goods_id){
        int result = 0;
        try{
             result= discussService.delete(goods_id);
        }catch (Exception e){
            e.getMessage();
        }
        return result;
    }

    // 前端页面的更新评论,通过id
    @PostMapping("/discussUpdata")
    public int updataById(@RequestParam("goods_id")Integer goods_id){
        discussService.update(goods_id);
        return 0;
    }

}

