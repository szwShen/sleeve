package com.szw.missyou.enumeration;

/**
 * @Auther: szw
 * @Date: 2023/8/9 - 08 - 09 - 10:28
 * @Description: com.szw.missyou.enumeration
 * @version: 1.0
 */
public enum LoginType {
    USER_WX(0, "微信登陆"), USER_EMAIL(1, "邮箱登陆");

    private LoginType(Integer value, String description) {

    }
}
