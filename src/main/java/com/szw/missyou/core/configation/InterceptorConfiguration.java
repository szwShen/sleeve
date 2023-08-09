package com.szw.missyou.core.configation;

import com.szw.missyou.core.interceptors.PermissionnInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: szw
 * @Date: 2023/8/9 - 08 - 09 - 15:09
 * @Description: com.szw.missyou.core.configation
 * @version: 1.0
 */
@Component
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionnInterceptor());
    }
}
