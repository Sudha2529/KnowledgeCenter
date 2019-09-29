package com.knowledgeCenter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knowledgeCenter.model.Category;
import com.knowledgeCenter.model.KnowledgeBase;
import com.knowledgeCenter.service.KnowledgeBaseService;

@RestController
@RequestMapping(value = "/api/v1")
public class KnowledgeBaseController {
	@Autowired
	private KnowledgeBaseService knowledgeBaseService;

	/**
	 * This API is used to create a knowledgeBase.
	 * 
	 * @param knowledge which contains the knowledge name and Knowledge Description
	 * @return If the knowledgeBase is created successfully, it returns the
	 *         HttpStatus code and Message.
	 */
	@PostMapping("/knowledge")
	public ResponseEntity<?> createKnowledgeBase(@RequestBody KnowledgeBase knowledge) {
		knowledgeBaseService.createKnowledge(knowledge);
		Map<String, String> response = new HashMap<String, String>();
		response.put("status", "CREATED");
		response.put("message", "Your KnowledgeBase has been created successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	/**
	 * This API is used to create a Category.
	 * 
	 * @param category which contains the category Name and knowledgeBase to which
	 *                 it belongs to.
	 * @return If the category is created successfully, it returns the HttpStatus
	 *         code and Message.
	 */
	@PostMapping("/knowledge/category")
	public ResponseEntity<?> createCategory(@RequestBody Category category) {
		knowledgeBaseService.createCategory(category);
		Map<String, String> response = new HashMap<String, String>();
		response.put("status", "CREATED");
		response.put("message", "Your category has been uploaded successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
