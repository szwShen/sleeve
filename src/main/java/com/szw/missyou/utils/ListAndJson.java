package com.szw.missyou.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.szw.missyou.exception.ServerErrorException;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: szw
 * @Date: 2023/8/8 - 08 - 08 - 10:06
 * @Description: com.szw.missyou.utils
 * @version: 1.0
 */
@Convert
public class ListAndJson implements AttributeConverter<List<Object>, String> {
    private ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(List<Object> objects) {
        try {
            return objectMapper.writeValueAsString(objects);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @SuppressWarnings("unckeced")
    @Override
    public List<Object> convertToEntityAttribute(String string) {
        try {
            if (string == null) {
                return null;
            }
            ;
            System.out.println(string);
            List<Object> object = objectMapper.readValue(string, new TypeReference<List<Object>>() {
            });
            System.out.println(object);
            return null;
//            return Arrays.asList(objectMapper.readValue(string, Object.class));
        } catch (JsonProcessingException e) {
            throw new ServerErrorException(9999);
        }
    }
}
