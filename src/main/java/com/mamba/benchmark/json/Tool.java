package com.mamba.benchmark.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.beust.jcommander.IStringConverter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.jsoniter.JsonIterator;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.function.Function;

public enum Tool {

    json("org.json") {
        @Override
        public int readField(String json, String field) throws IOException {
            return new JSONObject(new JSONTokener(json)).getInt(field);
        }

        @Override
        public int readField(byte[] bytes, String field) throws IOException {
            return new JSONObject(new JSONTokener(new ByteArrayInputStream(bytes))).getInt(field);
        }

        @Override
        public int readField(File file, String field) throws IOException {
            try (FileInputStream input = new FileInputStream(file)) {
                return new JSONObject(new JSONTokener(input)).getInt(field);
            }
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

        @Override
        public int readField(byte[] bytes, String field) throws IOException {
            return this.mapper.readTree(bytes).get(field).asInt();
        }

        @Override
        public int readField(File file, String field) throws IOException {
            return this.mapper.readTree(file).get(field).asInt();
        }

//        public JsonNode read(String json) throws IOException {
//            return this.mapper.readTree(json);
//        }
//
//        public <T> T get(JsonNode node, Function<JsonNode, T> mapper, String fieldName) {
//            return this.map(node.get(fieldName), mapper);
//        }
//
//        public <T> T get(JsonNode node, Function<JsonNode, T> mapper, String... fieldNames) {
//            JsonNode res = node;
//            for (String fieldName : fieldNames) {
//                res = res.get(fieldName);
//            }
//            return this.map(res, mapper);
//        }
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

        @Override
        public int readField(byte[] bytes, String field) throws IOException {
            try (InputStreamReader reader = new InputStreamReader(new ByteArrayInputStream(bytes))) {
                return JsonParser.parseReader(reader).getAsJsonObject().get(field).getAsInt();
            }
        }

        @Override
        public int readField(File file, String field) throws IOException {
            try (FileReader reader = new FileReader(file)) {
                return JsonParser.parseReader(reader).getAsJsonObject().get(field).getAsInt();
            }
        }
    },

    fastjson("com.alibaba.fastjson") {
        @Override
        public int readField(String json, String field) throws IOException {
            return JSON.parseObject(json).getInteger(field);
        }

        @Override
        public int readField(byte[] bytes, String field) throws IOException {
            Object obj = JSON.parse(bytes);
            if (obj instanceof com.alibaba.fastjson.JSONObject) {
                return ((com.alibaba.fastjson.JSONObject) obj).getInteger(field);
            } else {
                try {
                    return ((com.alibaba.fastjson.JSONObject) JSON.toJSON(obj)).getInteger(field);
                } catch (RuntimeException var3) {
                    throw new JSONException("can not cast to JSONObject.", var3);
                }
            }
        }

        @Override
        public int readField(File file, String field) throws IOException {
            String text = Files.asCharSource(file, IOUtils.UTF8).read();
            return JSON.parseObject(text).getInteger(field);
        }
    },

    jsoniter("com.jsoniter") {
        @Override
        public int readField(String json, String field) throws IOException {
            return JsonIterator.deserialize(json).toInt(field);
        }

        @Override
        public int readField(byte[] bytes, String field) throws IOException {
            return JsonIterator.deserialize(bytes).toInt(field);
        }

        @Override
        public int readField(File file, String field) throws IOException {
            byte[] bytes = Files.asByteSource(file).read();
            return JsonIterator.deserialize(bytes).toInt(field);
        }

//        public Any readField1(String json) throws IOException {
//            return JsonIterator.deserialize(json);
//        }
//
//        protected Any get(Any node, String fieldName) throws IOException {
//            return node.get(fieldName);
//        }
//
//        protected Any get(Any node, String... fieldNames) throws IOException {
//            Any res = node;
//            for (String fieldName : fieldNames) {
//                res = res.get(fieldName);
//            }
//            return res;
//        }
    };

    private final String desc;

    Tool(String desc) {
        this.desc = desc;
    }

    public String desc() {
        return this.desc;
    }

    public <F, T> T map(F from, Function<F, T> mapper) {
        if (from == null) {
            return null;
        } else {
            return mapper.apply(from);
        }
    }

    public abstract int readField(String json, String field) throws IOException;

    public abstract int readField(byte[] bytes, String field) throws IOException;

    public abstract int readField(File file, String field) throws IOException;
}
