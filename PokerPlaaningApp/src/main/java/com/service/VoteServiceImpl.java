package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.UserVote;
import com.repo.VoteRepo;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	VoteRepo voteRepo;
	
	

	@Override
	public UserVote addVotes(UserVote vote) throws Exception {
		// TODO Auto-generated method stub
		return voteRepo.save(vote);
		}

}
