package com.xsw.construct.configuration.mq.consumer;

import com.aliyun.openservices.ons.api.Message;


/**
 * @Title:
 * @BelongProjecet gotone
 * @BelongPackage com.zhan.gotone.common.mq
 * @Description:
 * @Copyright 2019 xiaozhan - Powered By 研发部
 * @Author: Tico.Ji
 * @Date: 2019-10-15 15:15
 * @Version V1.0
 */
public interface MsgProcessor {

    /**
     * 消息处理<br/>
     * 如果没有return true ，consumer会重新消费该消息，直到return true<br/>
     * consumer可能重复消费该消息，请在业务端自己做是否重复调用处理，该接口设计为幂等接口
     * @param topic 消息主题
     * @param tag 消息标签
     * @param message  消息
     * @return com.zhan.gotone.common.mq.consumer.bo.MQConsumeResult
     */
     MQConsumeResult handle(String topic, String tag, Message message);
}
