package com.xulihuazj.common.annotation;

import java.lang.annotation.*;

/**
 * 日志AOP注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogger {

    String value() default "";
}
