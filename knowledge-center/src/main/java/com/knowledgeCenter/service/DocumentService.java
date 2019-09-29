package com.knowledgeCenter.service;

import java.util.List;

import com.knowledgeCenter.model.Document;

public interface DocumentService {

	void createFAQDocument(Document document);

	void createArticleDocument(Document document);

	void createDocument(List<Document> document);

	List<Document> getDocumentsByCategory(int categoryId);

	List<Document> getDocumentsByKeyword(String keyword);

}