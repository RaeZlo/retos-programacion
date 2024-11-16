package com.Challenge.AluraGutendex.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ConvertData implements IConvertData {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> classInfo) {
        try {
            return mapper.readValue(json, classInfo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}