package com.knowledgeCenter.model;

public class KnowledgeBase {
	
	private int id;
	
	private String knowledgeDescription;
	
	private String supportedLanguage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKnowledgeDescription() {
		return knowledgeDescription;
	}

	public void setKnowledgeDescription(String knowledgeDescription) {
		this.knowledgeDescription = knowledgeDescription;
	}

	public String getSupportedLanguage() {
		return supportedLanguage;
	}

	public void setSupportedLanguage(String supportedLanguage) {
		this.supportedLanguage = supportedLanguage;
	}
}
