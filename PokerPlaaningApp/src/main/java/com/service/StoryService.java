package com.service;

import org.springframework.stereotype.Service;
import com.entity.Story;
import com.exceptions.ResourceNotFoundException;

@Service
public interface StoryService {
	
	public Story addStory(Story u) throws Exception;
	public Story updateStory(long i,Story u) throws ResourceNotFoundException;
	public String deleteStory(long i) throws ResourceNotFoundException;

}
