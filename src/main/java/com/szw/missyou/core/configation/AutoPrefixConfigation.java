package com.szw.missyou.core.configation;

import com.szw.missyou.core.HackAutoPrefiexConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @Auther: szw
 * @Date: 2023/8/3 - 08 - 03 - 16:58
 * @Description: com.szw.missyou.core.configation
 * @version: 1.0
 */
@Component
public class AutoPrefixConfigation implements WebMvcRegistrations {
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new HackAutoPrefiexConfiguration();
    }
}
