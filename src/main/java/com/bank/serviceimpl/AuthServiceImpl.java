package com.bank.serviceimpl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.dto.LoginRequestDTO;
import com.bank.dto.RegisterRequestDTO;
import com.bank.entity.Customer;
import com.bank.entity.Role;
import com.bank.entity.User;
import com.bank.repository.CustomerRepository;
import com.bank.repository.RoleRepository;
import com.bank.repository.UserRepository;
import com.bank.security.JwtUtil;
import com.bank.service.AuthService;
@Service
public class AuthServiceImpl implements AuthService{

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final CustomerRepository customerRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	
	public AuthServiceImpl(
	        UserRepository userRepository,
	        RoleRepository roleRepository,
	        CustomerRepository customerRepository,
	        PasswordEncoder passwordEncoder,
	        AuthenticationManager authenticationManager,
	        JwtUtil jwtUtil) {

	    this.userRepository = userRepository;
	    this.roleRepository = roleRepository;
	    this.customerRepository = customerRepository;
	    this.passwordEncoder = passwordEncoder;
	    this.authenticationManager = authenticationManager;
	    this.jwtUtil = jwtUtil;
	}
	
	
	@Override
	public String register(RegisterRequestDTO request) {
		if(userRepository.existsByUsername(request.getUsername())) 
		{ 
			throw new RuntimeException("Username already exists");
        }

        Role role =roleRepository
                        .findByRoleName(
                                "CUSTOMER")
                        .orElseThrow();

        User user = new User();

        user.setUsername(request.getUsername());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(role);

        User savedUser = userRepository.save(user);
        
        
        
        
        Customer customer =
                new Customer();

        customer.setFirstName(
                request.getFirstName());

        customer.setLastName(
                request.getLastName());

        customer.setEmail(
                request.getEmail());

        customer.setPhone(
                request.getPhone());

        customer.setAddress(
                request.getAddress());

        customer.setUser(savedUser);

        customerRepository.save(customer);

        return "Customer Registered Successfully";
	}

	
	
	@Override
	public String login(LoginRequestDTO request) {
		authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(
	                    request.getUsername(),
	                    request.getPassword()
	            )
	    );

	    return jwtUtil.generateToken(
	            request.getUsername()
	    );

	}

}
