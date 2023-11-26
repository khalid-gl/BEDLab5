package com.gl.gradedproject.bed.employeemgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gl.gradedproject.bed.employeemgmt.entity.User;
import com.gl.gradedproject.bed.employeemgmt.repository.UserRepository;

public class SecurityUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("User details not found for the user " + userName);
		}
		return new SecurityUserDetails(user);
	}

}