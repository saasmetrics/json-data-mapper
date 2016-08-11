package com.saasmetrics.json.datamapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saasmetrics.json.datamapper.transformers.JsonTransfomer;
import com.saasmetrics.json.datamapper.transformers.Transfomer;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class JsonDataMapper {

	Logger log =  LoggerFactory.getLogger(JsonDataMapper.class);
	
	private Transfomer transformer;
	
	private JsonDataMapper(Transfomer transformer){
		this.transformer =  transformer;
	}

	public static JsonDataMapper getInstance() {
		return new JsonDataMapper(new JsonTransfomer());
	}

	public String transform(String json, String mapper) throws ParseException {			
		return transformJsonFields(json, mapper, new JSONObject()).toJSONString();
	}

	private JSONObject transformJsonFields(String json, String mapper, JSONObject newObject) {
		JSONObject objectMapper = transformJsonObject(mapper);
		transformer.transformObject(objectMapper, json, newObject);
		return objectMapper;
	}

	private JSONObject transformJsonObject(String jsonString) {
		try {
			return new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(jsonString, JSONObject.class);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}