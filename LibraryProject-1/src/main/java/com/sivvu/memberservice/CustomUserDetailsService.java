package com.sivvu.memberservice;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sivvu.membermodel.Member;
import com.sivvu.memberrepository.MemberRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService{
	private MemberRepository memberrepo;
	public CustomUserDetailsService(MemberRepository memberrepo) {
		this.memberrepo=memberrepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member user=memberrepo.findMemberByMemberName(username)
				.orElseThrow(()->new UsernameNotFoundException("user not found"));
		return org.springframework.security.core.userdetails.User
				.withUsername(user.getMemberName())
				.password(user.getMemberPassword())
				.roles("USER")
				.build();
	}
	

}
