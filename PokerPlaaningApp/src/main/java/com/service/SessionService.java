package com.service;

import java.util.List;

import com.entity.Member;
import com.entity.Session;
import com.exceptions.ResourceNotFoundException;

public interface SessionService {

	Session createNewSession(Session session);

	List<Session> getListOfSessions();
	
	Session getSessionById(long sessionId) throws ResourceNotFoundException;

	String destroySessionById(long sessionId) throws ResourceNotFoundException;

	List<String> getAllMembersNamesBySessionID(long sessionId);
	
	Session joinTheSessionBySessionLink(long memberId,String sessionLink) throws ResourceNotFoundException, Exception;
	
	Member logOutMember(long memberId,long sessionId) throws ResourceNotFoundException, Exception;
	
	
	

}
