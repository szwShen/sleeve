package com.szw.missyou.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.szw.missyou.exception.ServerErrorException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: szw
 * @Date: 2023/8/8 - 08 - 08 - 11:19
 * @Description: com.szw.missyou.utils
 * @version: 1.0
 */
@Component
public class GenericAndJson {
    private static ObjectMapper mapper;

    @Autowired
    public void setMapper(ObjectMapper mapper) {
        GenericAndJson.mapper = mapper;
    }

    public static <T> String objectToJson(T o) {
        try {
            return GenericAndJson.mapper.writeValueAsString(o);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    public static <T> T jsonToObject(String s,  TypeReference<T> tr) {
        if (s == null) {
            return null;
        }
        try {
            T o = GenericAndJson.mapper.readValue(s, tr);
            return o;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
//
//    private static ObjectMapper mapper;
//
//    @Autowired
//    public void setMapper(ObjectMapper mapper) {
//        GenericAndJson.mapper = mapper;
//    }
//
//    public static <T> String objectToJson(T o) {
//
//        try {
//            return mapper.writeValueAsString(o);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            throw new ServerErrorException(9999);
//        }
//    }
//
//    public static <T> T jsonToObject(String s,TypeReference<T>tClass) {
//        try {
//            if (s == null) {
//                return null;
//            }
//
//            T o = GenericAndJson.mapper.readValue(s, tClass);
//
//            return o;
//        } catch (JsonProcessingException e) {
//            throw new ServerErrorException(9999);
//        }
//    };
//    public static <T> T jsonToList(String s, TypeReference<T> tr) {
//        try {
//            if (s == null) {
//                return null;
//            }
//
//            T list = GenericAndJson.mapper.readValue(s, tr);
//
//            return list;
//        } catch (JsonProcessingException e) {
//            throw new ServerErrorException(9999);
//        }
//    }
}
