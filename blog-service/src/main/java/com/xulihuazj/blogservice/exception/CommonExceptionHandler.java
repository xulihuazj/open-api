package com.xulihuazj.blogservice.exception;

import com.xulihuazj.common.exception.BusinessException;
import com.xulihuazj.common.reponse.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
@ResponseBody
public class CommonExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResponseDTO> handleException(Exception e) {
        ResponseDTO resp = new ResponseDTO();
        BusinessException exception = (BusinessException) e;
        resp.statusCode = exception.getErrorCode();
        resp.message = e.getMessage();

        return new ResponseEntity(resp, HttpStatus.OK);
    }
}
