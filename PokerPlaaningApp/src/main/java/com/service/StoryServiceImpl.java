package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Member;
import com.entity.Story;
import com.exceptions.ResourceNotFoundException;
import com.repo.MemberRepo;
import com.repo.StoryRepo;

@Service
public class StoryServiceImpl implements StoryService {
	
	@Autowired
	private StoryRepo storyRepo;

	@Override
	public Story addStory(Story story) throws Exception {
		return storyRepo.save(story);
	}

	@Override
	public Story updateStory(long i, Story s) throws ResourceNotFoundException {
		Story storyId = storyRepo.findById(i)
				.orElseThrow(() -> new ResourceNotFoundException("Story not found for this id :: " + i));
		Story updatedStroy = null;
		if (storyId != null) {
			s.setStoryId(storyId.getStoryId());
			updatedStroy = storyRepo.save(s);
		}
		return updatedStroy;
	}

	@Override
	public String deleteStory(long i) throws ResourceNotFoundException {
		Story storyId = storyRepo.findById(i)
				.orElseThrow(() -> new ResourceNotFoundException("Story not found for this id :: " + i));
		storyRepo.deleteById(i);
		return "Story Deletd ";
	}

}
