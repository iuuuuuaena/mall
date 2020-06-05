package com.tapd.controller;

/**
 * @Author jxd
 * @Date 2020-06-03  09:03
 * @Version 1.0
 */

import com.tapd.entities.Goods;
import com.tapd.serviceimpl.UPublishGoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class GoodsController {



    @Autowired
    UPublishGoodsServiceImpl uPublishGoodsService;


    /**
     * 跳转到商品列表
     * @return
     */
    @RequestMapping(value = "/goods",method = RequestMethod.GET)

    public String showGoodsList(Model model){
        List<Goods> allGoods = uPublishGoodsService.findAll();
        model.addAttribute("goods",allGoods);
        return "goods/list";
    }

    // 通过id删除商品
    @DeleteMapping(value = "/goods/{id}")
    public String delete(@PathVariable("id")Integer id){

        uPublishGoodsService.deleteById(id);
        return "redirect:/goods";

    }


    // -------------------------- 下面是前端的接口——————————————————————————

    /**
     * 上传商品
     * @param goods
     * @param model
     */
    @RequestMapping(value = "/publishGood",method = RequestMethod.POST)
    @ResponseBody
    public void  publishGoods(Goods goods, Model model){

        int i = uPublishGoodsService.create(goods);
        if(i == 1){
            model.addAttribute("mag","上传商品成功");

        }else{
            model.addAttribute("mag","上传失败，请重新上传");
        }

    }

    // 给页面返回所有商品的json信息
    @RequestMapping(value = "/goodsList",method = GET)
    @ResponseBody
    public List<Goods>  returnGoodsList(){
        List<Goods> allGoods = uPublishGoodsService.findAll();
        return allGoods;
    }


    // 根据id查
    @RequestMapping(value = "/goodsId",method = GET)
    @ResponseBody
    public Goods findByid(@RequestParam("id") Integer id){
        Goods good = uPublishGoodsService.findById(id);
        return good;
    }





    // 根据name模糊查
    @RequestMapping(value = "/goodsName",method = GET)
    @ResponseBody
    public List<Goods>  findLikeGoods(@RequestParam("name")  String name){
        List<Goods> likeGoods = uPublishGoodsService.findLikeGoods(name);
        return likeGoods;
    }


    // 根据id删除商品
    @PostMapping("/goodDeleteById")
    public int deleteById(@RequestParam("id")Integer id){
        int result =0;
        try{
            uPublishGoodsService.deleteById(id);
        }catch (Exception e){
            e.getMessage();
        }
        return result;
    }





}
