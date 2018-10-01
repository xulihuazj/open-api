package com.xulihuazj.common.reponse;

public class ResponseDTO<T> {

    public int statusCode = 0;
    public String message = "";
    public T data;

    public static ResponseDTO onSuccess(Object data) {
        ResponseDTO resp = new ResponseDTO();
        resp.data = data;
        return resp;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
