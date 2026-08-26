package com.sivvu.memberservice;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sivvu.bookmodel.Book;
import com.sivvu.bookcontroller.*; 
import com.sivvu.bookservice.*;
import com.sivvu.membermodel.Member;
import com.sivvu.memberrepository.MemberRepository;

@Service
public class MemberService {
	private MemberRepository repo;
	 private  PasswordEncoder passwordEncoder;
	
	
	public MemberService(MemberRepository repo,PasswordEncoder passwordEncoder) {
		this.repo=repo;
		this.passwordEncoder=passwordEncoder;
		
	}
	

	public Member addMembers(Member mem) {
		 String encodedPassword = passwordEncoder.encode(mem.getMemberPassword());
		 mem.setMemberPassword(encodedPassword);
		
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


	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
