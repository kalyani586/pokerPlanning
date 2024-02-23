package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Member;
import com.exceptions.ResourceNotFoundException;
import com.repo.MemberRepo;

@Service
public class MemberServiceImpl implements MemberServiceInt {

	@Autowired
	private MemberRepo memberRepo;


	@Override
	public Member addMember(Member u) throws Exception {
		Member u1 = memberRepo.getMemberByName(u.getName());
		Member uu;
		if (u1 == null) {
			u.setMemberId(u.getMemberId());
			u.setName(u.getName());
			u.setPassword(u.getPassword());
			uu = memberRepo.save(u);
		} else {
			throw new Exception(u.getName() + " Already Exist");
		}
		return uu;
	}

	@Override
	public Member updateMember(long i, Member u) throws ResourceNotFoundException {
		Member b = memberRepo.findById(i)
				.orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + i));
		Member uu1 = null;
		if (b != null) {
			u.setMemberId(b.getMemberId());
			u.setName(u.getName());
			uu1 = memberRepo.save(u);
		}
		return uu1;
	}

	@Override
	public String deleteMember(long i) throws ResourceNotFoundException {
		Member b = memberRepo.findById(i)
				.orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + i));
		memberRepo.deleteById(i);
		return "Member Deletd ";
	}

	@Override
	public Optional<Member> getMemberById(long i) throws ResourceNotFoundException

	{
		Member b = memberRepo.findById(i)
				.orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + i));
		Optional<Member> u = memberRepo.findById(i);

		return u;
	}

	@Override
	public Member getMemberByName(String name) throws ResourceNotFoundException {
		Member b = memberRepo.getMemberByName(name);
		Member u = null;
		if (b != null) {

			u = memberRepo.getMemberByName(name);
		} else {
			throw new ResourceNotFoundException("Member is not Found int Db" + name);
		}
		return u;
	}
}
