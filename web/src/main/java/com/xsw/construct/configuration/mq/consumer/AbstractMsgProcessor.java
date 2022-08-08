package com.xsw.construct.configuration.mq.consumer;


import com.aliyun.openservices.ons.api.Message;

/**
 * @Title:
 * @BelongProjecet gotone
 * @BelongPackage com.zhan.gotone.common.mq
 * @Description:
 * @Copyright 2019 xiaozhan - Powered By 研发部
 * @Author: Tico.Ji
 * @Date: 2019-10-15 15:20
 * @Version V1.0
 */
public abstract class AbstractMsgProcessor implements MsgProcessor {

    @Override
    public MQConsumeResult handle(String topic, String tag, Message message) {
        MQConsumeResult mqConsumeResult = new MQConsumeResult();
        /**可以增加一些其他逻辑*/

            //消费具体的消息，抛出钩子供真正消费该消息的服务调用
            mqConsumeResult = this.consumeMessage(topic,tag,message);
        
        /**可以增加一些其他逻辑*/
        return mqConsumeResult;
    }
    
    /**
     * @Author Tico.Ji
     * @Description 消费某条消息
     * @Date 15:24 2019-10-15
     * @Param [tag, keys, messageExt]
     * @return com.zhan.gotone.common.mq.consumer.bo.MQConsumeResult
     */
    protected abstract MQConsumeResult consumeMessage(String topic, String tag, Message message);

}
