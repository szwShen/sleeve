package com.szw.missyou.service;

import com.szw.missyou.model.Banner;
import org.springframework.stereotype.Service;

/**
 * @Auther: szw
 * @Date: 2023/8/4 - 08 - 04 - 9:06
 * @Description: com.szw.missyou.service
 * @version: 1.0
 */

public interface BannerService {
    Banner getByName(String name);
    Banner getById(Long id);

}
