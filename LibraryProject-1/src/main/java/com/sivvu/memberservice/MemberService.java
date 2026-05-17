package com.sivvu.memberservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sivvu.bookmodel.Book;
import com.sivvu.bookcontroller.*; 
import com.sivvu.bookservice.*;
import com.sivvu.membermodel.Member;
import com.sivvu.memberrepository.MemberRepository;

@Service
public class MemberService {
	private MemberRepository repo;
	
	public MemberService(MemberRepository repo) {
		this.repo=repo;
	}
	

	public Member addMembers(Member mem) {
		
		return repo.save(mem);
	}

	

	public String verifyMembers(String memberEmail, String memberPassword) {
		
		Member member=repo.findByMemberEmailAndMemberPassword(memberEmail,memberPassword);
		if(member!=null) {
			return "Verified Successfully";
		}
		else {
			return "Verification failed";
		}
	}

}
