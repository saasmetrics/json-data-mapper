package com.saasmetrics.json.datamapper.transformers;

import java.util.Map.Entry;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class JsonTransfomer implements Transfomer {

	@Override
	public void transformObject(JSONObject objectMapper, String json, JSONObject newObject) {
		objectMapper.entrySet().forEach(entry -> {
			if(entry.getValue().getClass().equals(JSONArray.class)){
				transformArray((JSONArray) entry.getValue(), entry.getKey(), objectMapper, newObject, json);
			}else if(entry.getValue().getClass().equals(JSONObject.class)){
				JSONObject jsonObject = new JSONObject();
				newObject.put(entry.getKey(), jsonObject);
				transformObject((JSONObject) entry.getValue(), json, jsonObject );
			}
			else{
				transform(entry, newObject, json);
			}
		});
	}

	@Override
	public void transform(Entry<String, Object> x, JSONObject newObject, String json) {
		newObject.put(x.getKey(), JsonPath.read(json, x.getValue().toString()));
	}
	
	@Override
	public void transformArray(JSONArray array, String key, Object objectMapper, JSONObject newObject, String json) {
		JSONArray newArray = new JSONArray();
		newObject.put(key,newArray);
		
		for (int i = 0; i < array.size(); i++) {
			newArray.add(array.get(0));
			transformObject((JSONObject) array.get(i) ,json,  (JSONObject) array.get(i));
		}

	}
}
