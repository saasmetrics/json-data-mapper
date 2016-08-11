package com.saasmetrics.json.datamapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class JsonDataMapper {

	Logger log =  LoggerFactory.getLogger(this.getClass());
	
	private JsonDataMapper(){}

	public static JsonDataMapper getInstance() {
		return new JsonDataMapper();
	}

	public String transformer(String json, String mapper) throws ParseException {
		log.debug("current Json" + json);
		log.debug("current Mapper" + mapper);
		
		JSONObject item1 = new JSONObject();
		
		JSONObject objectMapper = transformJsonObject(mapper);
		objectMapper.entrySet().forEach(x -> {
			log.debug("current key:" + x.getValue().toString());
			item1.put(x.getKey(), JsonPath.read(json, x.getValue().toString()));
		});
		
		
		return item1.toJSONString();
	}
	
	
	private JSONObject transformJsonObject(String jsonString) throws ParseException{
		JSONParser parser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
		return (JSONObject) parser.parse(jsonString);
	}
}
