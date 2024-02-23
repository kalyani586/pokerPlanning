package com.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Session;
import com.utils.Queries;

@Repository
@Transactional
public interface SessionRepo extends JpaRepository<Session, Long> {
	
	
	@Query(value = Queries.FIND_SESSION_BY_LINK)
	public Optional<Session> getSessionByLink(String link);

}
