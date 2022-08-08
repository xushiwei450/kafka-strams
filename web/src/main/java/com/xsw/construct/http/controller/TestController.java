package com.xsw.construct.http.controller;

import com.alibaba.fastjson.JSONObject;
import com.xsw.construct.common.vo.CommonResponse;
import com.xsw.construct.configuration.cloud.stream.Account;
import com.xsw.construct.configuration.cloud.stream.Order;
import com.xsw.construct.configuration.cloud.stream.Person;
import com.xsw.construct.configuration.cloud.stream.ProductConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/construct")
public class TestController {


    @Autowired
    private StreamBridge streamBridge;

    @Autowired
    private ProductConfiguration producersConfig;

    @GetMapping("/person")
    public CommonResponse addPerson(){
        Person person = new Person();
        person.setName("sherlock");
        person.setPhone("13817343388");
        person.setUserId("1");
        producersConfig.addPerson(person);


        return CommonResponse.ok();
    }


    @GetMapping("/account")
    public CommonResponse addAge(){
        Account account = new Account();
        account.setUserId("1");
        account.setAccount("5549dgs8sgh");
        producersConfig.addAccount(account);
//        return CommonResponse.ok(streamBridge.send("account", account));
        return CommonResponse.ok();
    }


    @GetMapping("/order")
    public CommonResponse addOrder(){
        Order order = new Order();
        order.setOrderId(""+System.currentTimeMillis());
        order.setUserId("1");
        producersConfig.addOrder(order);
        return CommonResponse.ok();
    }

    @GetMapping(value = "/test4")
    @ResponseBody
    public CommonResponse test4() {
        return CommonResponse.ok();
    }

    @GetMapping(value = "/test5")
    @ResponseBody
    public CommonResponse test5() {

        return CommonResponse.ok();
    }

    @GetMapping(value = "/test6")
    @ResponseBody
    public CommonResponse test6() {

        return CommonResponse.ok();
    }
}
