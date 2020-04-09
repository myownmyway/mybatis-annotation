package com.wpw.mybatisannotation.config;

import java.lang.annotation.*;

/**
 * 自定义注解用于统计方法的耗时
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CountTime {
}
