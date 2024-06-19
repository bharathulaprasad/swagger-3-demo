package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public class JsonFilterUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectNode filterJson(ObjectNode inputJson, List<String> filterFields) {
        ObjectNode filteredJson = objectMapper.createObjectNode();

        filterFields.forEach(field -> {
            if (inputJson.has(field)) {
                filteredJson.set(field, inputJson.get(field));
            }
        });

        return filteredJson;
    }
}