package com.knowledgeCenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.knowledgeCenter.exception.DocumentNotFoundException;
import com.knowledgeCenter.model.Document;
import com.knowledgeCenter.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public void createFAQDocument(Document document) {
		// The validation throws an IllegalArgException which will be caught by DocumentExcpetionHandler
		Assert.notNull(document.getQuestion(), "An invalid faq sent in request");
		Assert.notNull(document.getAnswer(), "An invalid faq sent in request");
		documentRepository.createFAQDocument(document);
	}

	@Override
	public void createArticleDocument(Document document) {
		// The validation throws an IllegalArgException which will be caught by DocumentExcpetionHandler
		Assert.notNull(document.getContent(), "An invalid content sent in request");
		documentRepository.createArticleDocument(document);
	}

	@Override
	public void createDocument(List<Document> document) {
		documentRepository.createDocument(document);
	}

	@Override
	public List<Document> getDocumentsByCategory(int categoryId) {
		List<Document> documents = documentRepository.getDocumentsByCategory(categoryId);
		return documents;
	}

	@Override
	public List<Document> getDocumentsByKeyword(String keyword) {
		List<Document> documents = documentRepository.getDocumentsByKeyword(keyword);
		
		if(documents == null || documents.size() == 0) {
			throw new DocumentNotFoundException("No Documents found with given keyword");
		}
		return documents;
	}
}
