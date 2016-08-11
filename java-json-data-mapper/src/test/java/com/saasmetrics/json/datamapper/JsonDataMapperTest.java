package com.saasmetrics.json.datamapper;

import org.junit.Assert;
import org.junit.Test;

import com.saasmetrics.json.datamapper.util.FileUtils;


public class JsonDataMapperTest {

	@Test
	public void shouldTransformJson() throws Exception{
		String mapper = FileUtils.readFile("C:/Users/pagui/Documents/git/json-data-mapper/java-json-data-mapper/bin/mappers/sample-data-mapper.json");
		String json = FileUtils.readFile("C:/Users/pagui/Documents/git/json-data-mapper/java-json-data-mapper/bin/jsons/sample-json.json");
		JsonDataMapper dataMapper =  JsonDataMapper.getInstance();
		String  newJson = dataMapper.transformer(json, mapper);
		System.out.println(newJson);
		Assert.assertTrue("{\"GlossTerm\":\"Standard Generalized Markup Language\",\"SortAs\":\"SGML\",\"NewAcronym\":\"SGML\",\"Abbrev2\":\"ISO 8879:1986\",\"Abbrev\":\"ISO 8879:1986\"}".equals(newJson));
	}
	
}
