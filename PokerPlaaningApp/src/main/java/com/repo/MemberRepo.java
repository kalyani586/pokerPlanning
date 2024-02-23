package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Member;
import com.utils.Queries;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {

	
	@Query(value = Queries.FIND_MEMBER_BY_NAME)
	public Member getMemberByName(@Param("name") String name);

}
