package com.xsw.construct.common.exception;

import java.text.MessageFormat;

/**
 * @author ShiWei.Xu
 * @className
 * @description
 * @date create in 11:05 2020/11/17
 **/


public class CommonException extends RuntimeException {
    private ErrorCode errorCode;
    private String errorMsg;

    public CommonException() {
    }

    public CommonException(Throwable e) {
        super(e);
    }

    public CommonException(ErrorCode errCode) {
        super(errCode.getCode());
        this.errorCode = errCode;
        this.errorMsg = errCode.getMsg();
    }

    public CommonException(ErrorCode errCode, String... errMsg) {
        super(errCode.getCode());
        this.errorCode = errCode;
        this.errorMsg = getErrMsg(errCode.getMsg(), errMsg);
    }


    public CommonException(ErrorCode errCode, Throwable cause, String... errMsg) {
        super(errCode.getCode() + getErrMsg(errCode.getMsg(), errMsg), cause);
        this.errorCode = errCode;
        this.errorMsg = getErrMsg(errCode.getMsg(), errMsg);
    }


    private static String getErrMsg(String template, Object... parameters) {
        return MessageFormat.format(template, parameters);
    }

    @Deprecated
    public CommonException(ErrorCode errCode, String errMsg, Boolean isTransfer) {
        super(errMsg);
        this.errorCode = errCode;
        this.errorMsg = getErrMsg(errCode.getMsg(),errMsg);
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorCode(final ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
    }


    @Override
    public String toString() {
        return "CommonException(errorCode=" + this.getErrorCode() + ", errorMsg=" + this.getErrorMsg() + ")";
    }
}