package com.wyx.esresthighlevelclientapidemo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

/**
 * @author : Just wyx
 * @Date : 2021/1/20
 */
public class JsonUtil {
	public static String toPrettyFormat(String json) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(JsonParser.parseString(json));
	}
}
