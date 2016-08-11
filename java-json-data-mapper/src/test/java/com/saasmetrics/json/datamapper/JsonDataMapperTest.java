package com.saasmetrics.json.datamapper;

import org.junit.Assert;
import org.junit.Test;

import static com.saasmetrics.json.datamapper.util.FileUtils.readFile;


public class JsonDataMapperTest {

	@Test
	public void shouldTransformJson() throws Exception{
		String basePath = "C:/Users/pagui/Documents/git/json-data-mapper/java-json-data-mapper/bin";
		
		String mapper = readFile(basePath + "/mappers/sample-data-mapper.json");
		String json = readFile(basePath + "/jsons/sample-json.json");
		String result = readFile(basePath + "/jsons/json-file-result.json");
		
		JsonDataMapper dataMapper =  JsonDataMapper.getInstance();
		String  newJson = dataMapper.transform(json, mapper);
		System.out.println(newJson);
		Assert.assertTrue(result.equals(newJson));
	}
	
}
