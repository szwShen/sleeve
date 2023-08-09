package com.szw.missyou.exception;

/**
 * @Auther: szw
 * @Date: 2023/8/9 - 08 - 09 - 11:34
 * @Description: com.szw.missyou.exception
 * @version: 1.0
 */
public class ParamterException  extends HttpException {
    public ParamterException(int code) {
        this.code = code;
        this.httpStatusCode = 401;
    }
}
