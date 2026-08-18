package com.sivvu.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sivvu.memberservice.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	private JwtService jwtService;
	private CustomUserDetailsService customUserDetailsService;
	public JwtAuthenticationFilter(JwtService jwtService,CustomUserDetailsService customUserDetailsService) {
		this.jwtService=jwtService;
		this.customUserDetailsService=customUserDetailsService;
		
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
		        filterChain.doFilter(request, response);
		        return;
		    }
		  String authHeader=request.getHeader("Authorization");
		  if(authHeader==null || !authHeader.startsWith("Bearer ")) {
			  filterChain.doFilter(request, response);
			  return ;
		  }
		  String token=authHeader.substring(7);
		  String username= jwtService.extractUsername(token);
		  if(username!=null&& SecurityContextHolder.getContext().getAuthentication()==null) {
			  UserDetails userDetails =customUserDetailsService.loadUserByUsername(username);
			  if(jwtService.isTokenValid(token,userDetails)) {
				  UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				SecurityContextHolder.getContext()
				.setAuthentication(auth);
			  }
		  }
		 filterChain.doFilter(request, response);
		
	}

}
