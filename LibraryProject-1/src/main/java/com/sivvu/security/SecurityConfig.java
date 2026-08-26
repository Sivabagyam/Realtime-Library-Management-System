package com.sivvu.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.config.Customizer;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private JwtAuthenticationFilter jwtFilter;
	public SecurityConfig(JwtAuthenticationFilter jwtFilter) {
		this.jwtFilter=jwtFilter;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}


	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) {
		return configuration.getAuthenticationManager();
	}
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {

	    CorsConfiguration configuration = new CorsConfiguration();

	    configuration.setAllowedOrigins(
	        List.of("http://localhost:5173")
	    );

	    configuration.setAllowedMethods(
	        List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")
	    );

	    configuration.setAllowedHeaders(
	        List.of("*")
	    );

	    configuration.setAllowCredentials(false);

	    UrlBasedCorsConfigurationSource source =
	        new UrlBasedCorsConfigurationSource();

	    source.registerCorsConfiguration("/**", configuration);

	    return source;
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		  .csrf(csrf->csrf.disable())
		  .cors(Customizer.withDefaults())
		  .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		  .authorizeHttpRequests(auth -> auth
				    .requestMatchers("/auth/login").permitAll()
				    .requestMatchers("/member/addmembers").permitAll()
				    .anyRequest().authenticated()
				)
		  .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
		  
		  
		
	}
}
	
