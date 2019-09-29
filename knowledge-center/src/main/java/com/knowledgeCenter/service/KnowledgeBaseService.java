package com.knowledgeCenter.service;

import com.knowledgeCenter.model.Category;
import com.knowledgeCenter.model.KnowledgeBase;

public interface KnowledgeBaseService {

	void createKnowledge(KnowledgeBase knowledge);

	void createCategory(Category category);

}