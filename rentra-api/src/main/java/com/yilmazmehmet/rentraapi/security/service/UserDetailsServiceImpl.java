package com.yilmazmehmet.rentraapi.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.yilmazmehmet.rentraapi.exception.NoSuchEntityFoundException;
import com.yilmazmehmet.rentraapi.model.User;
import com.yilmazmehmet.rentraapi.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;
	
	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {
		
		// ?
		User user = userRepository.findByUsername(username)
				.orElseThrow(()-> new NoSuchEntityFoundException("User Not Found with -> username or email : " + username));
	
	return UserPrinciple.build(user);

	}

}
