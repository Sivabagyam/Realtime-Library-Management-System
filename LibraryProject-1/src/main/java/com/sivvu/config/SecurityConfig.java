package com.sivvu.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	
@Bean
public SecurityFilterChain SecurityFilterChain(HttpSecurity security) {
	
	security.csrf(customizer->customizer.disable());
	security.authorizeHttpRequests(request->request.anyRequest().authenticated());
	security.httpBasic(Customizer.withDefaults());
	security.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	return security.build();
}

@Bean
public AuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider provider=new DaoAuthenticationProvider(userDetailsService);
	provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	System.out.println("Authentication Provider Created");
	return provider;
}


}