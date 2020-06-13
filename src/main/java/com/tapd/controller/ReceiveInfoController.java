package com.tapd.controller;

import com.tapd.POJO.ReceiveInfo;
import com.tapd.enums.ResponseStatus;
import com.tapd.service.ReceiveInfoService;
import com.tapd.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author jxd
 * @Date 2020-06-12  16:27
 * @Version 1.0
 */
@RestController
public class ReceiveInfoController {

    ReceiveInfoService receiveInfoService;

    @Autowired
    public void setReceiveInfoService(ReceiveInfoService receiveInfoService) {
        this.receiveInfoService = receiveInfoService;
    }

    /**
     * 创建收货地址
     * @param receiveInfo
     * @return
     */
    @GetMapping("/createReceive")
    public Object create(ReceiveInfo receiveInfo){

        if (receiveInfo.getUser_account() == null || receiveInfo.getUser_account().equals("undefined")){
            return ResultUtils.fail(ResponseStatus.USER_ACCOUNT_NOT_NULL.getCode(),ResponseStatus.USER_ACCOUNT_NOT_NULL.getMsg(),ResponseStatus.USER_ACCOUNT_NOT_NULL);

        }
        int insert = receiveInfoService.insert(receiveInfo);
        if (insert != 1){
            return ResultUtils.fail(ResponseStatus.CREATE_ERROR.getCode(),ResponseStatus.CREATE_ERROR.getMsg(),ResponseStatus.CREATE_ERROR);
        }else{
            return ResultUtils.fail(ResponseStatus.CREATE_SUCCESS.getCode(),ResponseStatus.CREATE_SUCCESS.getMsg(),ResponseStatus.CREATE_SUCCESS);

        }

    }

    @GetMapping("/findAllReceive")
    public Object find(){

        List<ReceiveInfo> allInfo = receiveInfoService.findAllInfo();
        if (allInfo == null){
            return ResultUtils.fail(ResponseStatus.FIND_ADDRESS_FAIL.getCode(),ResponseStatus.FIND_ADDRESS_FAIL.getMsg(),ResponseStatus.FIND_ADDRESS_FAIL);
        }else{
            return allInfo;
        }

    }


    @GetMapping("/deleteReceive")
    public Object delete(@RequestParam("id")int id){


        int index = receiveInfoService.deleteById(id);
        if (index != 1){
            return ResultUtils.fail(ResponseStatus.DELETE_ADDRESS_FAIL.getCode(),ResponseStatus.DELETE_ADDRESS_FAIL.getMsg(),ResponseStatus.DELETE_ADDRESS_SUCCESS);
        }else{
            return ResultUtils.fail(ResponseStatus.DELETE_ADDRESS_SUCCESS.getCode(),ResponseStatus.DELETE_ADDRESS_SUCCESS.getMsg(),ResponseStatus.DELETE_ADDRESS_SUCCESS);

        }

    }
}
