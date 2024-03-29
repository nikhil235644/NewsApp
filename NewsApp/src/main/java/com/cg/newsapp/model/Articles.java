package com.cg.newsapp.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"source",
	"author",
	"title",
	"description",
	"urlother",
	"urlToImage",
	"publishedAt",
	"content"
	})
public class Articles {

	@JsonProperty("source")
	private Source source;

	@JsonProperty("author")
	private String author;
	@Id
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("description")
	private String description;

	@JsonProperty("urlother")
	private String urlother;
	
	@JsonProperty("urlToImage")
	private String urlToImage;
	
	@JsonProperty("publishedAt")
	private String publishedAt;
	
	@JsonProperty("content")
	private String content;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}	
}