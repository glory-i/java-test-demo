package qucoon.mod.SpringServerless.utility;


import com.google.gson.Gson;

public class GSON {
    private static final Gson GSON = new Gson();


    public static <T> T fromJson(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }
}