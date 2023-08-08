package com.szw.missyou.utils;

import com.szw.missyou.bo.PageCounter;

/**
 * @Auther: szw
 * @Date: 2023/8/5 - 08 - 05 - 16:48
 * @Description: com.szw.missyou.utils
 * @version: 1.0
 */
public class ComonUtils {
    public static PageCounter convertToParamter(Integer start, Integer count) {
        int pagNum = start / count;
        PageCounter pageCounter = new PageCounter();
        pageCounter.setPage(pagNum);
        pageCounter.setCount(count);
        return pageCounter;


    }
}
