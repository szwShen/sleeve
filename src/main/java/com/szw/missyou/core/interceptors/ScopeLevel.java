package com.szw.missyou.core.interceptors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: szw
 * @Date: 2023/8/9 - 08 - 09 - 14:46
 * @Description: com.szw.missyou.core.interceptors
 * @version: 1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ScopeLevel {
    int value() default 4;
}
