package com.sivvu.membermodel;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MemberPrincipal implements UserDetails{
	private Member member;
	public MemberPrincipal(Member member) {
		this.member=member;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
	return	Collections.singleton( new SimpleGrantedAuthority("Member"));
	}

	@Override
	public @Nullable String getPassword() {
		
		return member.getMemberPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return member.getMemberName();
	}

}
