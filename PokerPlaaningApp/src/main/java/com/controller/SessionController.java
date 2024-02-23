package com.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Member;
import com.entity.Session;
import com.exceptions.ResourceNotFoundException;
import com.service.SessionService;
import com.utils.JoinSession;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/PokerPlanningSession")
public class SessionController {

	@Autowired
	private SessionService sessionService;

	@ApiOperation(value = "List of existing poker planning sessions")
	@GetMapping
	public ResponseEntity<List<Session>> getListOfExistingPokerPlanningSessions() {
		return new ResponseEntity<>(sessionService.getListOfSessions(), HttpStatus.OK);
	}

	@ApiOperation(value = " Creation of a new session")
	@PostMapping
	public ResponseEntity<Session> createNewSession(@RequestBody Session session) {
		return new ResponseEntity<Session>(sessionService.createNewSession(session), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Session information")
	@GetMapping("/{sessionId}")
	public ResponseEntity<Session> getSessionById(@PathVariable long sessionId) throws ResourceNotFoundException {

		return new ResponseEntity<Session>(sessionService.getSessionById(sessionId), HttpStatus.OK);
	}

	@ApiOperation(value = "Destroy session")
	@DeleteMapping("/{sessionId}")
	public ResponseEntity<String> destroySessionById(@PathVariable long sessionId) throws ResourceNotFoundException {
		return new ResponseEntity<String>(sessionService.destroySessionById(sessionId), HttpStatus.OK);
	}

	@ApiOperation("List of Members in the session")
	@GetMapping("/list/{Id}")
	public ResponseEntity<List<String>> getAllMembersInASession(@PathVariable long Id) {
		return new ResponseEntity<List<String>>(sessionService.getAllMembersNamesBySessionID(Id), HttpStatus.OK);
	}

	@ApiOperation(value = "Join in the session")
	@PostMapping("/join")
	public ResponseEntity<Session> joinTheSessionBySessionLink(@RequestBody JoinSession joinSession) throws ResourceNotFoundException, Exception {
		System.out.println(joinSession);
		return new ResponseEntity<Session>(sessionService.joinTheSessionBySessionLink(joinSession.getMemberId(), joinSession.getSessionLink()),
				HttpStatus.CREATED);
	}

	@ApiOperation(value = "Logout a Member")
	@GetMapping("/{memberId}/{sessionId}")
	public ResponseEntity<Member> logOutMember(long memberId, long sessionId)
			throws ResourceNotFoundException, Exception {
		return new ResponseEntity<Member>(sessionService.logOutMember(memberId, sessionId), HttpStatus.OK);
	}

}
