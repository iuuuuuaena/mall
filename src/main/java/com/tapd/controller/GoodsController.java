package com.tapd.controller;

/**
 * @Author jxd
 * @Date 2020-06-03  09:03
 * @Version 1.0
 */

import com.tapd.POJO.Goods;
import com.tapd.POJO.UserLoginStatus;
import com.tapd.enums.ResponseStatus;
import com.tapd.service.UPublishGoodsService;
import com.tapd.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class GoodsController extends BaseController{


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
        if (allGoods == null) {
            return "goods/list";
        } else {
            model.addAttribute("goods", allGoods);
            return "goods/list";
        }

    }


    // 跳转到商品添加页面
    @GetMapping(value = "/good")
    public String toAddPage() {
        // // 查出员工信息
        // Collection<Department> departments = departmentDao.getDepartments();
        // // 歇会去
        // model.addAttribute("depts",departments);
        return "goods/add";
    }


    // 添加商品
    // springMVC会将我们的请求参数和对应的javabean参数一一对应起来，所以叫做自动封装！！！1
    @PostMapping(value = "/good")
    public String addGoods(Goods good, Model model) {

        System.out.println("要保存的商品数据是" + good);
        if (good.getUser_account() == null || good.getGoods_name() == "" || good.getUser_account() == null ) {
            model.addAttribute("msg", "商品所有者和商品名称不能为空");
            return "goods/add";
        } else {
            //保存 用户数据
            if (uPublishGoodsService.create(good) == 1) {
                System.out.println("保存商品:" + good);
                // c重定向
                // forward：转发到一个地址   /代表
                return "redirect:/goods";
            } else {
                model.addAttribute("msg", "商品插入失败");
                return "goods/add";
            }
        }
    }


    // 携带id去修改商品信息的页面
    @GetMapping(value = "/good/{goods_id}")
    public String toEditPage(@PathVariable("goods_id") int goods_id ,Model model) {

        // 查到id的商品
        Goods good = uPublishGoodsService.findById(goods_id);
        // 回写回去
        System.out.println("要修改的商品为" + good);
        model.addAttribute("good",good);

        // add是修改添加二合一的页面
        return "goods/add";

    }


    // 修改商品信息
    @RequestMapping(value = "/good", method = RequestMethod.PUT)
    public String updataGood(Goods good) {
        // 这里把传来的包括id和其他信息自动封装到employee里面，我们来查看是否修改完成
        System.out.println("正在修改商品");
        System.out.println("要修改的商品为：" +good);
        // 保存
        uPublishGoodsService.update(good);
        return "redirect:/goods";
    }


    // 通过id删除商品
    @DeleteMapping(value = "/good/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int index = uPublishGoodsService.deleteById(id);
        if (index == 1) {
            return "redirect:/goods";
        } else {
            logger.info("删除失败");
            return "redirect:/goods";
        }

    }


    // -------------------------- 下面是前端的接口——————————————————————————

    /**
     * 上传商品
     *
     * @param goods
     * @param model
     */
    @ResponseBody
    @RequestMapping(value = "/publishGood", method = GET)
    public Object publishGoods(Goods goods, Model model) {

        int i = uPublishGoodsService.create(goods);

        if (i == 1) {
            model.addAttribute("mag", "上传商品成功");
            logger.info("上传" + goods + "商品成功");
            return ResultUtils.ok(ResponseStatus.GOODS_PUBLISH_SUCCESS.getCode(),ResponseStatus.GOODS_PUBLISH_SUCCESS.getMsg(),ResponseStatus.GOODS_PUBLISH_SUCCESS);
        } else {
            model.addAttribute("mag", "上传失败，请重新上传");
            logger.error("上传" + goods + "商品失败");
            return ResultUtils.fail(ResponseStatus.GOODS_PUBLISH_FAIL.getCode(),ResponseStatus.GOODS_PUBLISH_FAIL.getMsg(),ResponseStatus.GOODS_PUBLISH_FAIL);
        }
    }

    // 给页面返回所有商品的json信息
    @ResponseBody
    @RequestMapping(value = "/goodsList", method = GET)
    public Object returnGoodsList(HttpServletRequest request) {

        // // 从请求中获取用户登录状态
        // UserLoginStatus userLoginStatus = getUserLoginStatus(request);
        // if (userLoginStatus == null) {
        //     // 如果用户没有登录状态的话，就返回用户没有登录的json信息
        //     return ResultUtils.fail(ResponseStatus.NO_LOGIN.getCode(),ResponseStatus.NO_LOGIN.getMsg(),ResponseStatus.NO_LOGIN);
        // }
        List<Goods> allGoods = uPublishGoodsService.findAll();
        if (allGoods == null) {
            logger.info("没有商品");
            return ResultUtils.fail(ResponseStatus.USER_DON_NO_HAVE_GOODS.getCode(),ResponseStatus.USER_DON_NO_HAVE_GOODS.getMsg(),ResponseStatus.USER_DON_NO_HAVE_GOODS);
        } else {
            logger.info("显示所有商品成功！");
            return allGoods;
        }

    }


    // 根据id查
    @RequestMapping(value = "/goodsId", method = GET)
    @ResponseBody
    public Object findByid(@RequestParam("id") Integer id,HttpServletRequest request) {
        // 从请求中获取用户登录状态
        UserLoginStatus userLoginStatus = getUserLoginStatus(request);
        if (userLoginStatus == null) {
            // 如果用户没有登录状态的话，就返回用户没有登录的json信息
            return ResultUtils.fail(ResponseStatus.NO_LOGIN.getCode(),ResponseStatus.NO_LOGIN.getMsg(),ResponseStatus.NO_LOGIN);
        }
        Goods good = uPublishGoodsService.findById(id);
        if (good == null) {
            logger.info("没有这个id的商品");
            return ResultUtils.fail(ResponseStatus.NO_IN_GOODS.getCode(),ResponseStatus.NO_IN_GOODS.getMsg(),ResponseStatus.NO_IN_GOODS);
        } else {
            logger.info("查询id为：" + id + " 的商品成功");
            return good;
        }
    }


    // 根据name模糊查
    @RequestMapping(value = "/goodsName", method = GET)
    @ResponseBody
    public Object findLikeGoods(@RequestParam("name") String name) {

        List<Goods> likeGoods = uPublishGoodsService.findLikeGoods(name);
        if (likeGoods == null) {
            logger.info("没找到这个name的商品！");
            return ResultUtils.fail(ResponseStatus.NO_GOODS.getCode(),ResponseStatus.NO_GOODS.getMsg(),ResponseStatus.NO_GOODS);
        } else {
            logger.info("根据name模糊查询的商品，查询成功！");
            return likeGoods;
        }

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


    // 根据用户账号搜索用户的商品
    @GetMapping("/goodByUserAccount")
    public Object findGoodByUseraccount(@RequestParam("user_account") String user_account) {
        List<Goods> userGoods = uPublishGoodsService.findByUserAccount(user_account);
        if ( userGoods== null) {
            logger.info("用户没有发布商品");
            return ResultUtils.fail(ResponseStatus.USER_DON_NO_HAVE_GOODS);
        }else{
            logger.info("查询这个用户的商品成功");
            return userGoods;
        }
    }
//    -----------------------------前端商城----------------------------------


    /**
     * 显示所有标签
     * @return
     */
    @ResponseBody
    @GetMapping("/showAllTag")
    public List<String> findAllTag(){
        List<String> allTag = uPublishGoodsService.findAllTag();
        if (allTag == null){
            logger.info("没有标签");
            return null;
        }else{
            logger.info("所有标签已返回");
            return allTag;
        }
    }

    @ResponseBody
    @GetMapping("/goodsByTag")
    public List<Goods> findGoodsByTag(@RequestParam("goods_tag")String goods_tag){
        List<Goods> goods = uPublishGoodsService.findGoodsByTag(goods_tag);
        if (goods == null){
            logger.info("没有这个标签的商品");
            return null;
        }else{
            logger.info("这个标签的商品已返回");
            return goods;
        }

    }

}
