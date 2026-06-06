package com.sivvu.memberservice;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sivvu.membermodel.Member;
import com.sivvu.membermodel.MemberPrincipal;
import com.sivvu.memberrepository.MemberRepository;
@Service

public class MyUserDetailsService implements UserDetailsService {
	private MemberRepository repo;
	
	public MyUserDetailsService(MemberRepository repo) {
		this.repo=repo;
		System.out.println("constructor craested so the problem is with database");
	}

	@Override
	public UserDetails loadUserByUsername(String memberName) throws UsernameNotFoundException {
		
		Member member=repo.findMemberByMemberName(memberName);
		if(member==null) {
			System.out.println("User not found Exception");
			 throw new UsernameNotFoundException("member not found");
			 
		}
		System.out.println("member found");
		return (UserDetails) new MemberPrincipal(member);
	}

}
