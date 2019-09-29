package com.knowledgeCenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowledgeCenter.model.Category;
import com.knowledgeCenter.model.KnowledgeBase;
import com.knowledgeCenter.repository.KnowledgeBaseRepository;

@Service
public class KnowledgeBaseServiceImpl implements KnowledgeBaseService {

	@Autowired
	private KnowledgeBaseRepository knowledgeBaseRepository;

	@Override
	public void createKnowledge(KnowledgeBase knowledge) {
		knowledgeBaseRepository.createKnowledge(knowledge);
	}

	@Override
	public void createCategory(Category category) {
		knowledgeBaseRepository.createCategory(category);
	}
}
