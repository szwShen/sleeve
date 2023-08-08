package com.szw.missyou.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.szw.missyou.exception.ServerErrorException;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: szw
 * @Date: 2023/8/7 - 08 - 07 - 18:10
 * @Description: com.szw.missyou.utils
 * @version: 1.0
 */
@Convert
public class MapAndJson implements AttributeConverter<Map<String, Object>, String> {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        try {
            return mapper.writeValueAsString(stringObjectMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> convertToEntityAttribute(String s) {
        try {
            if (s == null) {
                return null;
            } else {
                return mapper.readValue(s, new TypeReference<Map<String, Object>>() {
                });

            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
