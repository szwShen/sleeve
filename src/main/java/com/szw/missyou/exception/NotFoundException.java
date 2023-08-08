package com.szw.missyou.exception;

/**
 * @Auther: szw
 * @Date: 2023/8/3 - 08 - 03 - 15:10
 * @Description: com.szw.missyou.exception
 * @version: 1.0
 */
public class NotFoundException extends HttpException {
    public NotFoundException(int code) {
        this.httpStatusCode = 500;
        this.code = code;
    }
}
