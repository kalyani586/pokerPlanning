package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Member;
import com.exceptions.ResourceNotFoundException;
import com.repo.MemberRepo;
import com.service.MemberServiceInt;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class MemberController {

	@Autowired
	private MemberRepo memberRepo;

	@Autowired
	private MemberServiceInt serviceInt;

	@GetMapping(path = "/getMember/{id}")
	public ResponseEntity<Optional<?>> getUser(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
		Optional<Member> u = serviceInt.getMemberById(id);
		return ResponseEntity.ok(u);
	}

	@PostMapping(path = "/addMember")
	public ResponseEntity<Member> addUser(@RequestBody Member u) throws Exception {
		Member uu = serviceInt.addMember(u);
		return ResponseEntity.ok(uu);
	}

	@PutMapping(path = "/update/{id}")
	public ResponseEntity<Member> updateUser(@PathVariable(value = "id") long id, @RequestBody Member u)
			throws ResourceNotFoundException {
		Member uu = serviceInt.updateMember(id, u);
		return ResponseEntity.ok(uu);
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> deleteMember(@PathVariable long id) throws ResourceNotFoundException {
		String s = serviceInt.deleteMember(id);
		return ResponseEntity.ok(s);
	}

	@ApiOperation(value = "Get List of Member from database")
	@GetMapping("getListOfUsers")
	public ResponseEntity<List<Member>> getListOfUsers() {
		List list = memberRepo.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("getByName/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name) throws ResourceNotFoundException {
		Member u = serviceInt.getMemberByName(name);
		return ResponseEntity.ok(u);
	}
}
