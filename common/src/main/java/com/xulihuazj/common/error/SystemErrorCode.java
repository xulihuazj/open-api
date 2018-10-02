/*
 * SystemErrorCode.java 1.0.0 2017/6/19  下午7:44
 * Copyright © 2014-2017,52mamahome.com.All rights reserved
 * history :
 *     1. 2017/6/19  下午7:44 created by yinqiang
 */
package com.xulihuazj.common.error;

/**
 * 系统异常码定义  系统码以500开头
 */
public enum SystemErrorCode implements ErrorCode {

    /**
     * 1.api默认系统码100 1.1 jws相关业务码位10
     */

    JWS_SIGN_ERROR(50010001, "token验证异常"),

    SYSTEM_ERROR(50010002, "系统异常"),

    TOKEN_EXPIRED(50010016, "token过期"),


    ;

    SystemErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
