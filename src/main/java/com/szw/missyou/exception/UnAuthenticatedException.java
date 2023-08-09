package com.szw.missyou.exception;

/**
 * @Auther: szw
 * @Date: 2023/8/9 - 08 - 09 - 14:56
 * @Description: com.szw.missyou.exception
 * @version: 1.0
 */
public class UnAuthenticatedException extends HttpException {
    public UnAuthenticatedException(int code) {
        this.httpStatusCode = 403;
        this.code = code;
    }
}
