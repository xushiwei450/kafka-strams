package com.xsw.construct.common.exception;


/**
 * @author ShiWei.Xu
 * @className
 * @description
 * @date create in 11:43 2020/11/17
 **/
public enum CommonErrorEnum implements ErrorCode {

    SYS_ERROR("SYS_ERROR","系统错误"),
    ILLEGAL_PARAMS("ILLEGAL_PARAMS", "参数不合法"),
    DUBBO_ERROR("DUBBO_ERROR","调用dubbo错误"),
    PARAM_EMPTY("PARAM_EMPTY","{0}不能为空"),
    CONVERT_ERROR("CONVERT_ERROR","对象转换错误:{0}"),
    LOGIN_INVALID("LOGIN_INVALID", "登录失效"),
    LOGIN_FIRST("LOGIN_FIRST", "请先登录"),
    SYSTEM_BUSY("SYSTEM_BUSY", "系统繁忙"),
    ENCODE_DECODE_ERROR("ENCODE_DECODE_ERROR", "报文加解密异常:{0}"),
    FILE_INPUT_STREAM_EXCEPTION("FILE_INPUT_STREAM_EXCEPTION", "处理文件流异常"),
    PLATFORM_NOT_EXIST("PLATFORM_NOT_EXIST", "服务名platform无效"),
    INTERFACE_NAME("INTERFACE_NAME", "接口名interfaceName无效"),
    PLATFORM_AND_INTERFACE_NOT_EXIST("PLATFORM_AND_INTERFACE_NOT_EXIST", "服务名 platform 和 接口名 interfaceName 为空"),
    PROCEDURE_SERVICE_NOT_FOUND("PROCEDURE_SERVICE_NOT_FOUND", "节点服务不存在"),
    PROCEDURE_SERVICE_METHOD_NOT_FOUND("PROCEDURE_SERVICE_METHOD_NOT_FOUND", "节点服务对应的方法不存在"),
    PIPELINE_ID_NOT_FOUND("PIPELINE_ID_NOT_FOUND", "管道ID不存在"),
    PIPELINE_PROCEDURE_NOT_FOUND("PIPELINE_PROCEDURE_NOT_FOUND", "管道节点不存在-配置问题"),
    ELASTICSEARCH_BAD_REQUEST("ELASTICSEARCH_BAD_REQUEST", "链接elasticsearch server 失败 ,because of:{0}");

    private String code;
    private String msg;
    private CommonErrorEnum(String code, String msg) {
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
