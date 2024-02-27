package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.entity.Story;
import com.utils.Queries;

@Repository
public interface StoryRepo extends JpaRepository<Story, Long> {

}
