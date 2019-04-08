package com.art.bbc_news.objects;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Article implements Serializable {

    @SerializedName("source")
    private Source source;
    @SerializedName("author")
    private String author;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;
    @SerializedName("urlToImage")
    private String urlToImage;
    @SerializedName("publishedAt")
    private String publishedAt;
    @SerializedName("content")
    private String content;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @SerializedName("source")
    public Source getSource() {
        return source;
    }

    @SerializedName("source")
    public void setSource(Source source) {
        this.source = source;
    }

    @SerializedName("author")
    public String getAuthor() {
        return author;
    }

    @SerializedName("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @SerializedName("title")
    public String getTitle() {
        return title;
    }

    @SerializedName("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("description")
    public String getDescription() {
        return description;
    }

    @SerializedName("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("url")
    public String getUrl() {
        return url;
    }

    @SerializedName("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("urlToImage")
    public String getUrlToImage() {
        return urlToImage;
    }

    @SerializedName("urlToImage")
    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    @SerializedName("publishedAt")
    public String getPublishedAt() {
        return publishedAt;
    }

    @SerializedName("publishedAt")
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @SerializedName("content")
    public String getContent() {
        return content;
    }

    @SerializedName("content")
    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}