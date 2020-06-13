package com.tapd.controller;

import com.tapd.POJO.Image;
import com.tapd.enums.ResponseStatus;
import com.tapd.service.ImageService;
import com.tapd.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-12  21:36
 * @Version 1.0
 */
@Controller
public class ImageController {


    ImageService imageService;

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/image")
    public String goImage(Model model) {

        List<Image> allImage = imageService.findAll();
        model.addAttribute("images", allImage);
        System.out.println("正在进入轮播图列表界面");
        return "image";
    }


    @RequestMapping(value = "/update1", method = RequestMethod.PUT)
    public String update1(@RequestParam("path") String path) {
        imageService.update1(path);
        return "redirect:/image";
    }
    @RequestMapping(value = "/update2", method = RequestMethod.PUT)
    public String update2(@RequestParam("path") String path) {
        imageService.update2(path);
        return "redirect:/image";
    }
    @RequestMapping(value = "/update3", method = RequestMethod.PUT)
    public String update3(@RequestParam("path") String path) {
        imageService.update3(path);
        return "redirect:/image";
    }


    @ResponseBody
    @GetMapping("/getAllImage")
    public Object getAllImage(){

        List<Image> allImage = imageService.findAll();
        if (allImage == null) {
            return ResultUtils.fail(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getMsg(), ResponseStatus.ERROR);
        }else{
            return allImage;
        }
    }


}
