/*
 * ErrorCode.java 1.0.0 2017/6/19  下午6:27 
 * Copyright © 2014-2017,52mamahome.com.All rights reserved
 * history :
 *     1. 2017/6/19  下午6:27 created by yinqiang
 */
package com.xulihuazj.common.error;

/**
 * 异常码定义
 */
public interface ErrorCode {

    /**
     * 获取异常code
     *
     * @return
     */
    Integer getCode();

    /**
     * 获取异常描述信息
     *
     * @return
     */
    String getMessage();
}
