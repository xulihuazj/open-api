package com.xulihuazj.common.exception;

public class ErrorModel {
    /**
     * 错误代码
     */
    private String statusCode;

    /**
     * 错误描述
     */
    private String message;

    /**
     * 获取错误代码
     *
     * @return
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * 设置错误代码
     *
     * @param statusCode 错误代码
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * 获取错误消息
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置错误消息
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * 构造函数
     *
     * @param code    错误代码
     * @param message 错误消息
     */
    public ErrorModel(Integer code, String message) {
        if (code != null) {
            this.statusCode = code.toString();
        }
        this.message = message;
    }

    /**
     * 无参数构造函数
     */
    public ErrorModel() {

    }
}