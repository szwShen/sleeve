package com.szw.missyou.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @Auther: szw
 * @Date: 2023/8/3 - 08 - 03 - 15:55
 * @Description: com.szw.missyou.core
 * @version: 1.0
 */

public class HackAutoPrefiexConfiguration extends RequestMappingHandlerMapping {

    @Value("${missyou.api-package}")
    private String apiPackagePath;

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mappingForMethod = super.getMappingForMethod(method, handlerType);
        if (mappingForMethod != null) {
            String prefix = this.getPrefix(handlerType);
            return RequestMappingInfo.paths(prefix).options(super.getBuilderConfiguration()).build().combine(mappingForMethod);
        }
        return mappingForMethod;
    }

    ;

    private String getPrefix(Class<?> handlerType) {
        String packageName = handlerType.getPackage().getName();

        String newPath = packageName.replaceAll(this.apiPackagePath, "");
        return newPath.replace(".", "/");


    }
}
