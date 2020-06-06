package com.tapd.controller;

import com.tapd.entities.UserLoginStatus;
import com.tapd.enums.ResponseStatus;
import com.tapd.service.FileService;
import com.tapd.utils.PathUtil;
import com.tapd.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * @Author jxd
 * @Date 2020-06-01  19:16
 * @Version 1.0
 */

@RestController
public class FileUploadController extends BaseController {


    // 日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    // 商城用户上传图片地址
    @Value("${file.img.path}")
    private String IMG_PATH;
    FileService fileService;


    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @ResponseBody
    @PostMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile img, HttpServletRequest request) {


        // 从请求中获取用户登录状态
        UserLoginStatus userLoginStatus = getUserLoginStatus(request);
        if (userLoginStatus == null) {
            // 如果用户没有登录状态的话，就返回用户没有登录的json信息
            return ResultUtils.fail(com.tapd.enums.ResponseStatus.NO_LOGIN);
        }
        // 如果用户登录，就保存图片
        String res = fileService.saveUploadFile(img, PathUtil.getRootPath() + IMG_PATH);
        if (res == null) {
            // 如果保存图片失败，就返回图片上传失败
            return ResultUtils.fail(com.tapd.enums.ResponseStatus.IMG_UPLOAD_FAIL);
        }
        // 否则 返回储存的路径
        Map <String, String> map = new HashMap<>(1);
        map.put("path", "/img/" + res);
        return ResultUtils.ok(map);
    }


    // 商城管理员上传图片地址
    @Value("${file.mimg.path}")
    String MIMG_PATH;


    @PostMapping("/mUpload")
    public Object mUpload(@RequestParam("file") MultipartFile img, Model model,HttpSession session) {


        // 从session中获取管理员登录的信息
        Object loginUser = session.getAttribute("loginUser");
        System.out.println("正在上传文件");
        if (loginUser == null){
            // model.addAttribute("fail","用户未登录");
            System.out.println("用户未登录");
            return ResultUtils.fail(ResponseStatus.NO_LOGIN);
        }else{
            // 如果管理员登录，就保存图片
            System.out.println("用户已经登录");
            String res = fileService.saveUploadFile(img, PathUtil.getRootPath() + MIMG_PATH);
            System.out.println("文件名为:"+res);
            if (res == null) {
                // model.addAttribute("fail","文件上传失败");
                System.out.println("文件上传失败");
                // 如果保存图片失败，就返回图片上传失败
                return ResultUtils.fail(ResponseStatus.IMG_UPLOAD_FAIL);
            }else{
                // 否则 返回储存的路径
                Map <String, String> map = new HashMap<>(1);
                map.put("path", "/img/" + res);
                System.out.println("文件上传成功");
                // model.addAttribute("success","/img/" + res);
                return map;
            }
        }
    }



}
