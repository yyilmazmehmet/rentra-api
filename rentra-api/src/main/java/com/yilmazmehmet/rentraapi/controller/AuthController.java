package com.yilmazmehmet.rentraapi.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yilmazmehmet.rentraapi.exception.NoSuchEntityFoundException;
import com.yilmazmehmet.rentraapi.model.Role;
import com.yilmazmehmet.rentraapi.model.RoleName;
import com.yilmazmehmet.rentraapi.model.SignupForm;
import com.yilmazmehmet.rentraapi.model.User;
import com.yilmazmehmet.rentraapi.repository.RoleRepository;
import com.yilmazmehmet.rentraapi.repository.UserRepository;
import com.yilmazmehmet.rentraapi.security.jwt.JwtProvider;
import com.yilmazmehmet.rentraapi.security.jwt.JwtResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody User loginRequest) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));


	}
	
	@PostMapping("/register")
	 public ResponseEntity<String> registerUser(@Valid @RequestBody SignupForm registerRequest) {
		
		if(userRepository.existsByUsername(registerRequest.getUsername())) {
            return new ResponseEntity<String>("Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
 
        if(userRepository.existsByEmail(registerRequest.getEmail())) {
            return new ResponseEntity<String>("Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }
        
        
        User user = new User(registerRequest.getName(),registerRequest.getUsername(),registerRequest.getEmail(),encoder.encode(registerRequest.getPassword()));
	
        Set<String> strRoles = registerRequest.getRole();
        Set<Role> roles = new HashSet<>();
        
        strRoles.forEach(role -> {
            switch(role) {
            case "admin":
              Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                    .orElseThrow(() ->new NoSuchEntityFoundException(" User Role not find."));
              roles.add(adminRole);
              
              break;
            case "pm":
                  Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
                    .orElseThrow(() ->new NoSuchEntityFoundException("User Role not find."));
                  roles.add(pmRole);
                  
              break;
            default:
                Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                    .orElseThrow(() ->new NoSuchEntityFoundException("User Role not find."));
                roles.add(userRole);              
            }
          });
        
        
        user.setRoles(roles);
        userRepository.save(user);
 
        return ResponseEntity.ok().body("User registered successfully!");
	}
	

}
