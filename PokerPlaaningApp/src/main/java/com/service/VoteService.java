package com.service;

import org.springframework.stereotype.Service;

import com.entity.UserVote;

@Service
public interface VoteService {
	
	public UserVote addVotes(UserVote vote) throws Exception;
}
