package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entity.Member;
import com.entity.Story;
import com.exceptions.ResourceNotFoundException;
import com.repo.StoryRepo;
import com.service.StoryService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/userStory")
public class StoryController {
	
	@Autowired
	private StoryRepo storyRepo;
	
	@Autowired
	private StoryService storyService;
	
	@ApiOperation(value = "list of user stories")
	@GetMapping("getListOfUserStrory")
	public ResponseEntity<List<Story>> getListOfUsers() {
		List list = storyRepo.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping(path = "/addStory")
	public ResponseEntity<Story> addStory(@RequestBody Story s) throws Exception {
		Story addStory = storyService.addStory(s);
		return ResponseEntity.ok(addStory);
	}

	@PutMapping(path = "/updateStory/{storyid}")
	public ResponseEntity<Story> updateStory(@PathVariable(value = "storyid") long storyid, @RequestBody Story s)
			throws ResourceNotFoundException {
		Story udatestory = storyService.updateStory(storyid, s);
		return ResponseEntity.ok(udatestory);
	}

	@DeleteMapping(path = "/deleteStory/{storyid}")
	public ResponseEntity<String> deleteStory(@PathVariable long storyid) throws ResourceNotFoundException {
		String s = storyService.deleteStory(storyid);
		return ResponseEntity.ok(s);
	}	

}
