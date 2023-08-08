package com.szw.missyou.core;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Auther: szw
 * @Date: 2023/8/3 - 08 - 03 - 15:29
 * @Description: com.szw.missyou.core
 * @version: 1.0
 */
@Data
@AllArgsConstructor
public class UnfiyResponse {
    private int code;
    private String message;
    private String request;
}
