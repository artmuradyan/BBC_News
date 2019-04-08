package com.art.bbc_news.objects;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Source {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("id")
    public String getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("name")
    public String getName() {
        return name;
    }

    @SerializedName("name")
    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}