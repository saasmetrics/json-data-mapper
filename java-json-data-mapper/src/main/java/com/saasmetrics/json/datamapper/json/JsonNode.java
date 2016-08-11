package com.saasmetrics.json.datamapper.json;

import com.saasmetrics.json.datamapper.json.node.JsonNodeType;

public abstract class JsonNode {

	public abstract JsonNodeType getNodeType();

	public final boolean isPojo() {
		return getNodeType() == JsonNodeType.POJO;
	}

	public final boolean isNumber() {
		return getNodeType() == JsonNodeType.NUMBER;
	}
	
	public final boolean isTextual() {
        return getNodeType() == JsonNodeType.STRING;
    }
}
