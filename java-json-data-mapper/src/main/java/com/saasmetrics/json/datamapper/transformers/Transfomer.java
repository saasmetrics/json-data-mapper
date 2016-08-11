package com.saasmetrics.json.datamapper.transformers;

import java.util.Map.Entry;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public interface Transfomer {

	void transformObject(JSONObject objectMapper, String json, JSONObject newObject);
	
	void transform(Entry<String, Object> x, JSONObject newObject, String json);
	
	void transformArray(JSONArray arrary, String key, Object objectMapper, JSONObject newObject, String json);

}
