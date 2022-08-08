package com.xsw.construct.common.exception;


/**
 * @author ShiWei.Xu
 * @className
 * @description
 * @date create in 11:44 2020/11/17
 **/


public class CommonExceptionFactory {

    public static CommonException paramEmpty(String... msg){
        return new CommonException(CommonErrorEnum.PARAM_EMPTY,msg);
    }

    public static CommonException convertError(String... msg){
        return new CommonException(CommonErrorEnum.CONVERT_ERROR,msg);
    }

    public static CommonException fileInputStreamException(String... msg){
        return new CommonException(CommonErrorEnum.FILE_INPUT_STREAM_EXCEPTION,msg);
    }

    public static CommonException encodeDecodeError(String... msg){
        return new CommonException(CommonErrorEnum.ENCODE_DECODE_ERROR,msg);
    }
    public static CommonException platformAndInterfaceNotExist(String... msg){
        return new CommonException(CommonErrorEnum.PLATFORM_AND_INTERFACE_NOT_EXIST,msg);
    }

    public static CommonException platformNotExist(String... msg){
        return new CommonException(CommonErrorEnum.PLATFORM_NOT_EXIST,msg);
    }

    public static CommonException interfaceName(String... msg){
        return new CommonException(CommonErrorEnum.INTERFACE_NAME,msg);
    }

    public static CommonException procedureServiceNotFound(String... msg){
        return new CommonException(CommonErrorEnum.PROCEDURE_SERVICE_NOT_FOUND,msg);
    }

    public static CommonException procedureServiceMethodNotFound(String... msg){
        return new CommonException(CommonErrorEnum.PROCEDURE_SERVICE_METHOD_NOT_FOUND,msg);
    }

    public static CommonException pipelineIdNotFound(String... msg){
        return new CommonException(CommonErrorEnum.PIPELINE_ID_NOT_FOUND,msg);
    }

    public static CommonException pipelineProcedureNotFound(String... msg){
        return new CommonException(CommonErrorEnum.PIPELINE_PROCEDURE_NOT_FOUND,msg);
    }

    public static CommonException elasticsearchBadRequest(String... msg){
        return new CommonException(CommonErrorEnum.ELASTICSEARCH_BAD_REQUEST,msg);
    }
}
