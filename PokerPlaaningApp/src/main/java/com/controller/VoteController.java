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

import com.entity.UserVote;
import com.exceptions.ResourceNotFoundException;
import com.repo.VoteRepo;
import com.service.VoteService;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/votes")
public class VoteController {
	
	@Autowired
	private VoteRepo voteRepo;
	
	
	@Autowired
	private VoteService voteService;
	
	/*
	 * @ApiOperation(value = "list of user stories")
	 * 
	 * @GetMapping("getListOfUserStrory") public ResponseEntity<List<Member>>
	 * getListOfUsers() { List list = storyRepo.findAll(); return
	 * ResponseEntity.ok(list); }
	 */
	/*
	 * @PostMapping(path = "/addVotes") public ResponseEntity<UserVote>
	 * addStory(@RequestBody UserVote v) throws Exception { UserVote addVote =
	 * voteService.addVotes(v); return ResponseEntity.ok(addVote); }
	 */

}
