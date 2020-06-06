package com.tapd.controller;

import com.tapd.entities.Discuss;
import com.tapd.enums.ResponseStatus;
import com.tapd.serviceimpl.DiscussServiceImpl;
import com.tapd.utils.ResultUtils;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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



    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    DiscussServiceImpl discussService;


    //跳转到评论界面，并显示所有评论
    // 显示所有评论
    @GetMapping("/discusses")
    public String showAllDiscuss(Model model) {
        List<Discuss> allDiscuss = discussService.findAll();
        model.addAttribute("discusses",allDiscuss);
        System.out.println("所有评论："+allDiscuss.toString());
        return "discuss/list";
    }


    @DeleteMapping(value = "/discuss/{discuss_id}")
    public String deleteDiscuss(@PathVariable("discuss_id") Integer discuss_id){
        int result = discussService.delete(discuss_id);
        System.out.println("要删除的评论idWie"+discuss_id);
        return "redirect:/discuss";
    }


    //---------------------------前端-------------


    // 前端页面的通过discussid查
    @ResponseBody
    @GetMapping("/discussesId")
    public Discuss findByDiscussId(@RequestParam("discuss_id") Integer discuss_id) {
        Discuss discuss = discussService.findById(discuss_id);
        return discuss;

    }

    // 前端页面的通过user_acccount查
    @ResponseBody
    @GetMapping("/discussByAccount")
    public List<Discuss> findByAccount(@RequestParam("user_account") String user_account) {
        List<Discuss> discussOfGoods = discussService.findByAccount(user_account);
        return discussOfGoods;

    }

    // 前端页面的通过GoodsId查
    @ResponseBody
    @GetMapping("/discussByGoodsId")
    public List<Discuss> findByGoodsId(@RequestParam("goods_id") Integer goods_id) {
        List<Discuss> discussOfGoods = discussService.findByGoodsId(goods_id);
        return discussOfGoods;

    }

    // 前端页面的添加评论
    @ResponseBody
    @PostMapping("/discussCreate")
    public Object createDiscuss(Discuss discuss) {

        logger.info("添加评论"+discuss);
        System.out.println("发表评论："+discuss);
        if ( discuss.getGoods_id() == null || discuss.getUser_account() == null|| discuss.getUser_account()==""){
            logger.error("添加评论失败，因为评论对应的账号和商品不能为空"+discuss);
            System.out.println("发表评论失败："+discuss);
            return ResultUtils.fail(ResponseStatus.DISCUSS_COMMENTS_FAIL);
        }else{
            if (discussService.create(discuss)== 1){
                logger.error("添加评论成功"+discuss);
                System.out.println("发表评论成功：");
                return ResultUtils.ok(ResponseStatus.DISCUSS_COMMENTS_SUCCESS);
            }

        }

        return 0;
    }


    // 前端页面的删除评论
    @ResponseBody
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
    @ResponseBody
    @PostMapping("/discussUpdate")
    public int updataById(@RequestParam("goods_id")Integer goods_id){
        discussService.update(goods_id);
        return 0;
    }

}

