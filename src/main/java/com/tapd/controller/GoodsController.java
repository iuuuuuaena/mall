package com.tapd.controller;

/**
 * @Author jxd
 * @Date 2020-06-03  09:03
 * @Version 1.0
 */

import com.tapd.entities.Goods;
import com.tapd.enums.ResponseStatus;
import com.tapd.service.UPublishGoodsService;
import com.tapd.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class GoodsController {


    Logger logger = LoggerFactory.getLogger(getClass());

    // 注入商品服务
    UPublishGoodsService uPublishGoodsService;

    @Autowired
    public void setuPublishGoodsService(UPublishGoodsService uPublishGoodsService) {
        this.uPublishGoodsService = uPublishGoodsService;
    }

    /**
     * 跳转到商品列表
     *
     * @return
     */
    @RequestMapping(value = "/goods", method = RequestMethod.GET)

    public String showGoodsList(Model model) {
        List<Goods> allGoods = uPublishGoodsService.findAll();
        model.addAttribute("goods", allGoods);
        return "goods/list";
    }

    // 通过id删除商品
    @DeleteMapping(value = "/good/{id}")
    public String delete(@PathVariable("id") Integer id) {

        uPublishGoodsService.deleteById(id);
        return "redirect:/goods";

    }


    // -------------------------- 下面是前端的接口——————————————————————————

    /**
     * 上传商品
     *
     * @param goods
     * @param model
     */
    @RequestMapping(value = "/publishGood", method = GET)
    @ResponseBody
    public Object publishGoods(Goods goods, Model model) {

        int i = uPublishGoodsService.create(goods);

        if (i == 1) {
            model.addAttribute("mag", "上传商品成功");
            logger.info("上传" + goods + "商品成功");
            return ResultUtils.ok(ResponseStatus.GOODS_PUBLISH_SUCCESS);
        } else {
            model.addAttribute("mag", "上传失败，请重新上传");
            logger.error("上传" + goods + "商品失败");
            return ResultUtils.fail(ResponseStatus.GOODS_PUBLISH_FAIL);
        }
    }

    // 给页面返回所有商品的json信息
    @ResponseBody
    @RequestMapping(value = "/goodsList", method = POST)
    public List<Goods> returnGoodsList() {
        List<Goods> allGoods = uPublishGoodsService.findAll();
        logger.info("显示所有商品成功！");
        return allGoods;
    }


    // 根据id查
    @RequestMapping(value = "/goodsId", method = GET)
    @ResponseBody
    public Goods findByid(@RequestParam("id") Integer id) {
        Goods good = uPublishGoodsService.findById(id);
        logger.info("查询id为：" + id + " 的商品成功");
        return good;
    }


    // 根据name模糊查
    @RequestMapping(value = "/goodsName", method = GET)
    @ResponseBody
    public List<Goods> findLikeGoods(@RequestParam("name") String name) {
        List<Goods> likeGoods = uPublishGoodsService.findLikeGoods(name);
        logger.info("根据name模糊查询的商品，查询成功！");
        return likeGoods;
    }


    // 根据id删除商品
    @GetMapping("/goodDeleteById")
    public Object deleteById(@RequestParam("id") Integer id) {
        int result = 0;
        try {
            result = uPublishGoodsService.deleteById(id);
            if (result == 1) {
                logger.info("商品id为：" + id + " 的商品，删除成功！");
                return ResultUtils.ok(ResponseStatus.GOODS_DELETE_SUCCESS);
            } else {
                logger.error("商品id为：" + id + " 的商品，删除失败！");
                return ResultUtils.ok(ResponseStatus.GOODS_DELETE_FAIL);
            }
        } catch (Exception e) {
            e.getMessage();
            logger.info("商品id为：" + id + " 的商品，删除有问题！！！！");
            return ResultUtils.ok(ResponseStatus.ERROR);
        }
    }


//    -----------------------------前端商城----------------------------------


}
