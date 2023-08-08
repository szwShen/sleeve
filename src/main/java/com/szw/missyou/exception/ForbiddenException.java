package com.szw.missyou.exception;

/**
 * @Auther: szw
 * @Date: 2023/8/3 - 08 - 03 - 15:08
 * @Description: com.szw.missyou.exception
 * @version: 1.0
 */
public class ForbiddenException  extends  HttpException{
    public  ForbiddenException(int code){
        this.httpStatusCode=403;
        this.code=code;
    }
}
