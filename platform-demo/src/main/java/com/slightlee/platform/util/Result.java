package com.slightlee.platform.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

@Data
public class Result<T extends Serializable> implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger ( Result.class );

    @ApiModelProperty(value = "返回Code")
    private Integer code;

    @ApiModelProperty(value = "描述信息")
    private String msg;

    @ApiModelProperty(value = "返回数据")
    private T data;


    private Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    private Result(ResultEnum resultEnum , String msg) {
        this(resultEnum,  msg,null);
    }


    private Result(ResultEnum resultEnum , String msg ,T data) {
        this(resultEnum.code, msg, data);
    }


    public static < T extends Serializable > Result<T> success ( T data ) {
        return new Result < T > ( ResultEnum.SUCCESS.getCode ( ) , ResultEnum.SUCCESS.getMsg(), data );
    }

    public static < T extends Serializable > Result<T> error ( String msg ) {
        logger.debug ( "返回错误：code={}, msg={}" , ResultEnum.INTERNAL_SERVER_ERROR.getCode ( ) , msg );
        return new Result < T > ( ResultEnum.INTERNAL_SERVER_ERROR.getCode ( ) , msg , null );
    }

    public static < T extends Serializable > Result<T> error ( ResultEnum resultEnum ) {
        logger.debug ( "返回错误：code={}, msg={}" , resultEnum.getCode ( ) , resultEnum.getMsg ( ) );
        return new Result < T > ( resultEnum.getCode ( ) , resultEnum.getMsg ( ) , null );
    }

    public static < T extends Serializable > Result<T> error ( int code , String msg ) {
        logger.debug ( "返回错误：code={}, msg={}" , code , msg );
        return new Result < T > ( code , msg , null );
    }

    /**
     * 返回Result
     *
     * @param resultCodeEnum
     * @param msg   提示信息
     * @param <T>  T 响应数据
     * @返回Result
     */
    public static <T extends Serializable> Result< T > error(ResultEnum resultCodeEnum , String msg) {
        return new Result< T >(resultCodeEnum, msg,null);
    }


}
