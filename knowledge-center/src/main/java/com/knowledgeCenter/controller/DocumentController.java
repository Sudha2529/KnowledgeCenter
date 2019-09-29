package com.knowledgeCenter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.knowledgeCenter.model.Document;
import com.knowledgeCenter.service.DocumentService;

@RestController
@RequestMapping(value = "/api/v1")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	/**
	 * This API is used to create document of type FAQ.
	 * 
	 * @param document which contains the fields like question ,answer ,category.
	 * @return If the document is uploaded successfully, it returns the HttpStatus
	 *         code and Message.
	 */
	@PostMapping("/document/faq")
	public ResponseEntity<?> createFAQDocument(@RequestBody @Valid Document document) {
		documentService.createFAQDocument(document);
		Map<String, String> response = new HashMap<String, String>();
		response.put("status", "CREATED");
		response.put("message", "Your document has been uploaded successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	/**
	 * This API is used to create document of type Article.
	 * 
	 * @param document which contains the fields like title , content.
	 * @return If the document is uploaded successfully, it returns the HttpStatus
	 *         code and Message.
	 */
	@PostMapping("/document/article")
	public ResponseEntity<?> createArticleDocument(@RequestBody @Valid Document document) {
		documentService.createArticleDocument(document);
		Map<String, String> response = new HashMap<String, String>();
		response.put("status", "CREATED");
		response.put("message", "Your document has been uploaded successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	/**
	 * This API is used to create single or multiple documents of FAQ or Article.
	 * 
	 * @param document which contains a list of documents to be uploaded
	 * @return If the documents are uploaded successfully, it returns the HttpStatus
	 *         code and Message.
	 */
	@PostMapping("/document")
	public ResponseEntity<?> createDocument(@RequestBody @Valid List<Document> document) {
		documentService.createDocument(document);
		Map<String, String> response = new HashMap<String, String>();
		response.put("status", "CREATED");
		response.put("message", "Your document has been uploaded successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	/**
	 * This API retrieves the documents which belong to a specific category.
	 * 
	 * @param categoryId
	 * @return The list of documents which belong to a given category.
	 */
	@GetMapping("/documents")
	public List<Document> getDocumentsByCategory(@RequestParam int categoryId) {
		List<Document> documents = documentService.getDocumentsByCategory(categoryId);
		return documents;
	}

	/**
	 * This API retrieves the documents which contains the given keyword.
	 * 
	 * @param keyword
	 * @return The list of documents which contains the given keyword.
	 */
	@RequestMapping(value = "/documents", method = RequestMethod.GET, params = "search")
	public List<Document> getDocumentsByKeyword(@RequestParam("search") String keyword) {
		List<Document> documents = documentService.getDocumentsByKeyword(keyword);
		return documents;
	}
}
