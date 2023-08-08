package com.szw.missyou.exception;

/**
 * @Auther: szw
 * @Date: 2023/8/7 - 08 - 07 - 18:25
 * @Description: com.szw.missyou.exception
 * @version: 1.0
 */
public class ServerErrorException extends HttpException {
    public ServerErrorException(int code) {
        this.code = code;
        this.httpStatusCode = 500;
    }
}
