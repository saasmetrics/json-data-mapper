package com.saasmetrics.json.datamapper.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileUtils {

	public static String readFile(String FilePath) throws IOException{
		return Files.lines(Paths.get(FilePath)).collect(Collectors.joining());
	}
	
	public static String readFileResource(String FilePath) throws IOException{
		String path = FileUtils.class.getClassLoader().getResource(FilePath).getPath();
		return Files.lines(Paths.get(path)).collect(Collectors.joining());
	}
	
}
