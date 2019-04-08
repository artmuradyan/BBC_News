package com.art.bbc_news.objects;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BBCObject {

    @SerializedName("status")
    private String status;
    @SerializedName("totalResults")
    private Integer totalResults;
    @SerializedName("articles")
    private List<Article> articles = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("status")
    public String getStatus() {
        return status;
    }

    @SerializedName("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @SerializedName("totalResults")
    public Integer getTotalResults() {
        return totalResults;
    }

    @SerializedName("totalResults")
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @SerializedName("articles")
    public List<Article> getArticles() {
        return articles;
    }

    @SerializedName("articles")
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}