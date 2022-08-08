package com.xsw.construct.configuration.mq.consumer;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @Title:
 * @BelongProjecet mqtest
 * @BelongPackage com.tico.common.mq.consumer
 * @Description:
 * @Copyright 2019 xiaozhan - Powered By 研发部
 * @Author: Tico.Ji
 * @Date: 2019-11-18 14:22
 * @Version V1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Service
public @interface MQConsumeService {
    /**
     * 消息主题
     */
    String topic();

    /**
     * 消息标签,如果是该主题下所有的标签，使用“*”
     */
    String[] tags();


}