package com.xsw.construct.configuration.mq.exception;


import com.xsw.construct.common.exception.CommonException;
import com.xsw.construct.common.exception.ErrorCode;

/**
 * @Title:
 * @Author: sherlock
 * @Date: 2022-7-14 14:35
 * @Version V1.0
 */
public class RocketMQException extends CommonException {

    private static final long serialVersionUID = 1L;


    /**
     * 无参构造函数
     */
    public RocketMQException() {
        super();
    }

    public RocketMQException(Throwable e) {
        super(e);
    }

    public RocketMQException(ErrorCode errorType) {
        super(errorType);
    }

    public RocketMQException(ErrorCode errorCode, String... errMsg) {
        super(errorCode, errMsg);
    }

    /**
     * 封装异常
     *
     * @param errorCode
     * @param errMsg
     * @param isTransfer 是否转换异常信息，如果为false,则直接使用errMsg信息
     */
    public RocketMQException(ErrorCode errorCode, String errMsg, Boolean isTransfer) {
        super(errorCode, errMsg, isTransfer);
    }

    public RocketMQException(ErrorCode errCode, Throwable cause, String... errMsg) {
        super(errCode, cause, errMsg);
    }
}