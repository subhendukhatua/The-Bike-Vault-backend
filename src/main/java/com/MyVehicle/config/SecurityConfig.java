package com.MyVehicle.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.MyVehicle.models.Role;
import com.MyVehicle.services.UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final JWTAuthenticationFilter jwtAuthenticationFilter;
	
	private final UserService userService;
	
	 @Bean
	  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		 httpSecurity.csrf(AbstractHttpConfigurer::disable)
		 .authorizeHttpRequests(request-> request.requestMatchers("/auth/**")
				 .permitAll()
//				 .requestMatchers("/client/**")
//				 .permitAll()
//				 .requestMatchers("/contact/**")
//				 .permitAll()
//				 .requestMatchers("/country/**")
//				 .permitAll()
//				 .requestMatchers("/employees/**")
//				 .permitAll()
//				 .requestMatchers("/employeeTypes/**")
//				 .permitAll()
//				 .requestMatchers("/invoices/**")
//				 .permitAll()
//				 .requestMatchers("/invoiceStatus/**")
//				 .permitAll()
//				 .requestMatchers("/jobTitles/**")
//				 .permitAll()
//				 .requestMatchers("/locations/**")
//				 .permitAll()
//				 .requestMatchers("/states/**")
//				 .permitAll()
//				 .requestMatchers("/suppliers/**")
//				 .permitAll()
//				 .requestMatchers("/vehicle/**")
//				 .permitAll()
//				 .requestMatchers("/vehicleHire/**")
//				 .permitAll()
//				 .requestMatchers("/vehiclemaintenances/**")
//				 .permitAll()
//				 .requestMatchers("/vehiclemake/**")
//				 .permitAll()
//				 .requestMatchers("/vehiclemodel/**")
//				 .permitAll()
//				 .requestMatchers("/Vehiclemovement/**")
//				 .permitAll()
//				 .requestMatchers("/vehicleStatus/**")
//				 .permitAll()
//				 .requestMatchers("/vehicleType/**")
//				 .permitAll()
				 .requestMatchers("/admin").hasAnyAuthority(Role.ADMIN.name())
				 .requestMatchers("/user").hasAnyAuthority(Role.USER.name())
				 .anyRequest().authenticated())
		 .sessionManagement(manager->manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		 .authenticationProvider(authenticationProvider()).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		 
		 return httpSecurity.build(); 
	 }
	 
	 
	 @Bean
	   public AuthenticationProvider authenticationProvider() {
		 DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		 authProvider.setUserDetailsService(userService.userDetailsService());
		 authProvider.setPasswordEncoder(passwordEncoder());
		 return authProvider;
		 
		 	
		 
	 }

    @Bean
    public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	 
	 @Bean
	  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		 return config.getAuthenticationManager();
	 }
	 
	 

}
