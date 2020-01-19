package com.mamba.benchmark.json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.jsoniter.JsonIterator;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public enum Tools {

    json("org.json") {
        @Override
        public int readField(String json, String field) throws IOException {
            return new JSONObject(new JSONTokener(json)).getInt(field);
        }
    },

    jackson("com.fasterxml.jackson") {
        private final ObjectMapper mapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        @Override
        public int readField(String json, String field) throws IOException {
            return this.mapper.readTree(json).get(field).asInt();
        }
    },

    gson("com.google.gson") {
        private final Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, context) -> new JsonPrimitive(date.getTime())).setDateFormat(DateFormat.LONG)
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (element, type, context) -> new Date(element.getAsJsonPrimitive().getAsLong())).setDateFormat(DateFormat.LONG)
                .create();

        @Override
        public int readField(String json, String field) throws IOException {
            return JsonParser.parseString(json).getAsJsonObject().get(field).getAsInt();
        }
    },

    fastjson("com.alibaba.fastjson") {
        @Override
        public int readField(String json, String field) throws IOException {
            return JSON.parseObject(json).getInteger(field);
        }
    },

    jsoniter("com.jsoniter") {
        @Override
        public int readField(String json, String field) throws IOException {
            return JsonIterator.deserialize(json).toInt(field);
        }
    };

    private final String desc;

    Tools(String desc) {
        this.desc = desc;
    }

    public String desc() {
        return this.desc;
    }

    public abstract int readField(String json, String field) throws IOException;
}
