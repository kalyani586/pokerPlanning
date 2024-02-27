package com.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Member;
import com.entity.Session;
import com.exceptions.ResourceNotFoundException;
import com.repo.MemberRepo;
import com.repo.SessionRepo;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionRepo sessionRepo;

	@Autowired
	private MemberRepo memberRepo;

	public static final Logger logger = LoggerFactory.getLogger(SessionServiceImpl.class);

	@Override
	public Session createNewSession(Session session) {
		String staticPart = "http://www.pokerplanning.com/palne/";
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		session.setLink(staticPart.concat(generatedString));
		return sessionRepo.save(session);
	}

	@Override
	public List<Session> getListOfSessions() {
		List<Session> list = sessionRepo.findAll();
		logger.info("Getting all Sessions from the database");
		if (list.isEmpty()) {
			new ResourceNotFoundException("Session List Not Found");
		}
		return list;

	}

	@Override
	public String destroySessionById(long sessionId) throws ResourceNotFoundException {

		Session session = sessionRepo.findById(sessionId)
				.orElseThrow(() -> new ResourceNotFoundException("Requested Session Not Found"));
		sessionRepo.delete(session);
		logger.info("Destroying session By Id : " + sessionId);

		return "Session Destroyed Successfully";

	}

	@Override
	public List<String> getAllMembersNamesBySessionID(long sessionId) {

		logger.info("Fetching all Members in the session By Session id : " + sessionId);
		return sessionRepo.findById(sessionId).get().getMembers().stream().map(obj -> obj.getName())
				.collect(Collectors.toList());
	}

	@Override
	public Session joinTheSessionBySessionLink(long memberId, String sessionLink) throws Exception {
		Session s = sessionRepo.getSessionByLink(sessionLink)
				.orElseThrow(() -> new ResourceNotFoundException("Requested Session Not Found"));

		Member member = memberRepo.findById(memberId)
				.orElseThrow(() -> new ResourceNotFoundException("Requested Member is Not Found"));

		List<Member> list = s.getMembers();
		if (list.isEmpty()) {
			list.add(member);
			logger.info("Joining member by Member id and Session id...........");
		} else {
			if (list.stream().anyMatch(a -> a.getMemberId() == memberId)) {
				throw new Exception("Member : " + " Already Exists in the Session");
			} else {
				list.add(member);
				logger.info("Joining member by Member id and Session id...........");
			}
		}
		s.setMembers(list);
		return sessionRepo.save(s);
	}

	@Override
	public Member logOutMember(long memberId, long sessionId) throws Exception {
		Session s = sessionRepo.findById(sessionId)
				.orElseThrow(() -> new ResourceNotFoundException("Requested Session Not Found"));
		Member member = memberRepo.findById(memberId)
				.orElseThrow(() -> new ResourceNotFoundException("Requested Member is Not Found"));

		for (int i = 0; i < s.getMembers().size(); i++) {
			if (s.getMembers().get(i).getName().equalsIgnoreCase(member.getName())) {
				s.getMembers().remove(i);
			} else {
				logger.info("Loging Out member From the session...........");
				throw new Exception("Member : " + member.getName() + "Not Exists in the Session");
			}
		}
		sessionRepo.save(s);

		return member;
	}

	@Override
	public Session getSessionById(long sessionId) throws ResourceNotFoundException {

		return sessionRepo.findById(sessionId)
				.orElseThrow(() -> new ResourceNotFoundException("Requested Session Not Found"));
	}

}
