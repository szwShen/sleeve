package com.szw.missyou.exception;

import lombok.Data;

/**
 * @Auther: szw
 * @Date: 2023/8/3 - 08 - 03 - 15:06
 * @Description: com.szw.missyou.exception
 * @version: 1.0
 */
@Data
public class HttpException extends  RuntimeException {
    protected Integer code ;
    protected Integer httpStatusCode=500;
}
