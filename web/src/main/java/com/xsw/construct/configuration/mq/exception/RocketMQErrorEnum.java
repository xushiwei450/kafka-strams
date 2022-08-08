package com.xsw.construct.configuration.mq.exception;


import com.xsw.construct.common.exception.ErrorCode;

/**
 * @Title:
 * @Author: sherlock
 * @Date: 2022-7-14 14:41
 * @Version V1.0
 */
public enum RocketMQErrorEnum implements ErrorCode {
    /********公共********/
    PARAMM_NULL("MQ_001","参数为空"),

    SERVER_STATUS_ERROR("SERVER_STATUS_ERROR","服务连接失败,请检查配置."),

    GROUP_NAME_NOT_EXISTS("GROUP_NAME_NOT_EXISTS","当前系统groupName未注册,请联系管理员"),

    TOPIC_NOT_EXISTS("TOPIC_NOT_EXISTS","topic尚未注册,请联系管理员"),

    TOPIC_IS_NULL("TOPIC_IS_NULL","topic不能为空"),

    TAG_IS_NULL("TAG_IS_NULL","tag不能为空"),

    PAYLOAD_IS_NULL("PAYLOAD_IS_NULL","消息体不能为空"),

    /********生产者*******/








    /********消费者*******/
    MQ_HANDLE_RESULT_NULL("MQ_HANDLE_RESULT_NULL","处理结果为空"),

    MQ_CONSUME_FAIL("MQ_CONSUME_FAIL","消息处理失败"),

    MQ_PARAMS_NULL("MQ_PARAMS_NULL","参数为空"),

    MQ_NOT_FOUND_CONSUMESERVICE("NOT_FOUND_CONSUMESERVICE","未找到对应服务"),

    ;

    private String code;
    private String msg;

    private RocketMQErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    @Override
    public String getCode() {
        return this.code;
    }


    @Override
    public String getMsg() {
        return this.msg;
    }


}
