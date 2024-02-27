package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.UserVote;
import com.utils.Queries;

@Repository
public interface VoteRepo extends JpaRepository<UserVote, Long> {

}
