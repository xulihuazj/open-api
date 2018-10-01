package com.xulihuazj.common.error;

/**
 * 业务异常
 * <p>
 * 规定使用边界，避免push代码存在过多冲突
 * <p>
 * 规定业务码开头使用人
 */
public enum BizErrorCode implements ErrorCode {
    /**
     * 3位系统码+2位业务码+3位异常码
     * 1.api默认系统码100
     */
    REQUEST_PARAM_EMPTY_ERROR("10010000", "请求参数错误或缺失"),

    ;

    BizErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
