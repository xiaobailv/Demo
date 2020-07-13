package com.liushihao.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 刘世豪
 * @title
 * @description
 * @updateTime 2020/5/29 9:36
 */
@Target(value = ElementType.METHOD) // 当前类作用到方法上
//@Target(operationName = ElementType.TYPE)   // 当前类作用到类上
@Retention(value = RetentionPolicy.RUNTIME) // 设置运行时机
public @interface LogAspect {

    String operationName();
    String fileName();
}
