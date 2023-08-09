package com.szw.missyou.service;

import com.szw.missyou.dto.TokenGetDto;

/**
 * @Auther: szw
 * @Date: 2023/8/9 - 08 - 09 - 11:01
 * @Description: com.szw.missyou.service
 * @version: 1.0
 */
public interface AnthenticationService {
    void getTokenByEmail(TokenGetDto uderData);

    void validateByWX(TokenGetDto userData);

    void register(TokenGetDto userdata);
}
