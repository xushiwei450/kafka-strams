package com.xsw.construct.common.exception;

import java.io.Serializable;

/**
 * @author ShiWei.Xu
 * @className
 * @description
 * @date create in 10:05 2020/11/17
 **/
public interface ErrorCode extends Serializable {
    String getCode();

    String getMsg();
}