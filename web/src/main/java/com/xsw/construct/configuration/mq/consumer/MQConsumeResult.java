package com.xsw.construct.configuration.mq.consumer;

import lombok.Data;

/**
 * @Title:
 * @BelongProjecet gotone
 * @BelongPackage com.zhan.gotone.common.mq.consumer.bo
 * @Description:
 * @Copyright 2019 xiaozhan - Powered By 研发部
 * @Author: Tico.Ji
 * @Date: 2019-10-15 15:14
 * @Version V1.0
 */
@Data
public class MQConsumeResult {
    /**
     * 是否处理成功
     */
    private boolean isSuccess;
    /**
     * 如果处理失败，是否允许消息队列继续调用，直到处理成功，默认true
     */
    private boolean isReconsumeLater = true;
    /**
     * 是否需要记录消费日志，默认不记录
     */
    private boolean isSaveConsumeLog = false;
    /**
     * 错误Code
     */
    private String errCode;
    /**
     * 错误消息
     */
    private String errMsg;
    /**
     * 错误堆栈
     */
    private Throwable e;
}
