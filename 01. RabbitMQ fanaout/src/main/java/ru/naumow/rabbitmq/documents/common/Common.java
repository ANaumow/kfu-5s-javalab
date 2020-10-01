package ru.naumow.rabbitmq.documents.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Common {

    public final static String EXCHANGE_NAME = "ru/naumow/rabbitmq/documents";
    public final static String EXCHANGE_TYPE = "fanout";

    public final static String HOST_NAME = "localhost";

    public final static String FIRST_NAME = "first_name";
    public final static String LAST_NAME = "last_name";
    public final static String AGE = "age";
    public final static String PASSPORT_NUMBER = "passport number";
    public final static String DATA_OF_ISSUE = "date_of_issue";

    @SuppressWarnings("unchecked")
    public static Map<String, String> parseJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, Map.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String writeJson(Map<String, String> map) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
