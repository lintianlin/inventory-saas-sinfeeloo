package com.sinfeeloo.inventory.controller;

import com.sinfeeloo.inventory.entity.ComResp;
import com.sinfeeloo.inventory.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: mhj
 * @Desc:
 * @Date: 2018/5/2 17:31
 */
@RestController
@RequestMapping(value = "/param")
public class ParamController {


    @Autowired
    private ParamService paramService;

//    @PostMapping
//    public ComResp addParam(){
//
//    }
}
