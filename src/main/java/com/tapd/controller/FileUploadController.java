package com.tapd.controller;

import com.tapd.entities.UserLoginStatus;
import com.tapd.service.FileService;
import com.tapd.utils.PathUtil;
import com.tapd.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
/**
 * @Author jxd
 * @Date 2020-06-01  19:16
 * @Version 1.0
 */

@RestController
public class FileUploadController  extends BaseController {



    // 日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    // //
    // //
    // //
    // // @Value("${user.file.path}")
    // // private String filePath;
    // //
    // // @Resource
    // // private ResourceLoader resourceLoader;
    // //
    // // @RequestMapping("/fileUpload")
    // // public ModelAndView update(@RequestParam("icon") MultipartFile multipartFile) {
    // //     String fileName ="";
    // //     ModelAndView modelAndView = new ModelAndView();
    // //
    // //
    // //     try {
    // //         // 保存图片
    // //         fileName = multipartFile.getOriginalFilename();
    // //         if (fileName.isEmpty()){
    // //             modelAndView.setViewName("user/add");
    // //             modelAndView.getModel().put("filePath","没有这个文件");
    // //             return modelAndView;
    // //         }
    // //         File file = new File(filePath+fileName);
    // //         System.out.println("路径是"+filePath);
    // //         System.out.println("文件名为："+multipartFile.getOriginalFilename());
    // //         multipartFile.transferTo(file);
    // //     } catch (IOException e) {
    // //         e.printStackTrace();
    // //     }
    // //
    // //
    // //     modelAndView.setViewName("user/add");
    // //     modelAndView.getModel().put("filePath","/"+fileName);
    // //     return modelAndView;
    // // }
    // //
    // //
    // //
    // // //控制器方式实现其实就是为图片格式指定一个请求，每次加载都请求类，
    // // // /{filename:.+}是指定路径变量配货图片如xx.png格式这个请求，
    // // // resourceLoader.getResource("file:" + Paths.get(filePath + filename)));
    // // // 中的 "file:"开头的代表使用file此种类型去加载这个资源，因为HTML是不能直接访问本地资源的
    // // // 需要将本地资源放到file类型告诉HTML这个可以访问
    // //
    // // @RequestMapping(value = "/file/{filename:.+}")
    // // @ResponseBody
    // // public ResponseEntity<?> getFile(@PathVariable String filename) {
    // //     try {
    // //         return  ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(filePath + filename)));
    // //     } catch (Exception e) {
    // //         return ResponseEntity.notFound().build();
    // //     }
    // // }
    //
    //
    // /**
    //  * 员工上传图片
    //  * @param file
    //  * @return
    //  * @throws Exception
    //  */
    // @RequestMapping(value = "/mFileUpload",method = RequestMethod.POST)
    // @ResponseBody
    // public Object uploadPic(MultipartFile file) throws Exception {
    //     String oldName = file.getOriginalFilename();
    //     String newName = UUID.randomUUID().toString().replace("-", "").toUpperCase()
    //             + "_" + oldName;
    //     System.out.println("上传的图片的newName: " + newName);
    //
    //     File base = new File(filePath);
    //     if (! base.exists()) {
    //         base.mkdirs();
    //     }
    //
    //     // 保存文件
    //     file.transferTo(new File(filePath + newName));
    //
    //     // 封装返回结果
    //     Map<String, Object> map = new HashMap<>();
    //     map.put("fullPath", newName); //"http://localhost:8080/assert/image/" +
    //     map.put("relativePath", newName);
    //
    //     return map;
    // }

    @Value("${file.img.path}")
    private String IMG_PATH;
    FileService fileService;


    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile img, HttpServletRequest request){


        // 从请求中获取用户登录状态
        UserLoginStatus userLoginStatus = getUserLoginStatus(request);
        if (userLoginStatus == null) {
            // 如果用户没有登录状态的话，就返回用户没有登录的json信息
            return ResultUtils.fail(com.tapd.enums.ResponseStatus.NO_LOGIN);
        }
        // 如果用户登录，就保存图片
        String res=fileService.saveUploadFile(img, PathUtil.getRootPath()+IMG_PATH);
        if (res==null){
            // 如果保存图片失败，就返回图片上传失败
            return ResultUtils.fail(com.tapd.enums.ResponseStatus.IMG_UPLOAD_FAIL);
        }
        // 否则 返回储存的路径
        Map<String ,String > map=new HashMap<>(1);
        map.put("path","/img/"+res);
        return ResultUtils.ok(map);
    }




















    // private final String URL = "http://localhost:8080/";
    //
    // @PostMapping("/imgUpload")
    // public String fileUpload(@RequestParam(value = "icon") MultipartFile file, Model model, HttpServletRequest request) {
    // if (file.isEmpty()) {
    //     System.out.println("文件为空空");
    // }
    //
    // String fileName = file.getOriginalFilename();  // 文件名
    // System.out.println("文件名为："+fileName);
    // String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
    // System.out.println("文件后缀为："+suffixName);
    // String filePath = "resources/static/asserts/"; // 上传后的路径
    // // fileName = UUID.randomUUID() + suffixName; // 新文件名
    // File dest = new File(filePath + fileName);
    // System.out.println("文件路径为："+filePath);
    // System.out.println("desk："+dest);
    // if (!dest.getParentFile().exists()) {
    //     dest.getParentFile().mkdirs();
    // }
    // try {
    //     file.transferTo(dest);
    // } catch (IOException e) {
    //     e.printStackTrace();
    // }
    // String filename = "/asserts/img/" + fileName;
    // System.out.println("最终的文件名！！！"+filename);
    // model.addAttribute("filename", filename);
    // return "redirect:user/add";

    // //获取项目classes/static的地址
    // String path = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
    // String fileName = file.getOriginalFilename();  //获取文件名
    // //图片访问URI(即除了协议、地址和端口号的URL)
    // String url_path = "img" + File.separator + fileName;
    // // log.info("图片访问uri："+url_path);
    // String savePath = path + File.separator + url_path;  //图片保存路径
    // // log.info("图片保存地址："+savePath);
    // System.out.println("文件名为："+fileName);
    // File saveFile = new File(savePath);
    // System.out.println("文件地址为："+url_path);
    // System.out.println("文件保存地址为："+savePath);
    // if (!saveFile.exists()) {
    //     saveFile.mkdirs();
    // }
    // try {
    //     file.transferTo(saveFile);  //将临时存储的文件移动到真实存储路径下
    // } catch (IOException e) {
    //     e.printStackTrace();
    // }
    // //返回图片访问地址
    // // log.info("访问URL："+URL+url_path);
    // // return JSONResult.ok(URL+url_path);
    // model.addAttribute("file",url_path);
    // return "user/add";
    // }



}
