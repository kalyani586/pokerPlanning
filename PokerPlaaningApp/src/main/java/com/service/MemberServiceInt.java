package com.service;

import java.util.Optional;

import com.entity.Member;
import com.exceptions.ResourceNotFoundException;

public interface MemberServiceInt {

	public Member addMember(Member u) throws Exception;
	public Member updateMember(long i,Member u) throws ResourceNotFoundException;
	public String deleteMember(long i) throws ResourceNotFoundException;
	public Optional<Member> getMemberById(long i) throws ResourceNotFoundException;
	public Member getMemberByName(String name) throws ResourceNotFoundException;
}
