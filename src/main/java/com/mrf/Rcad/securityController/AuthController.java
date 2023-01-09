package com.mrf.Rcad.securityController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mrf.Rcad.security.JWTAuthenticationFilter;
import com.mrf.Rcad.security.JWTGenerator;
import com.mrf.Rcad.securityDto.AuthResponseDTO;
import com.mrf.Rcad.securityDto.LoginDto;
import com.mrf.Rcad.securityDto.RegisterDto;
import com.mrf.Rcad.securityModels.Role;
import com.mrf.Rcad.securityModels.UserEntity;
//import com.mrf.Rcad.securityDto.AuthResponseDTO;
import com.mrf.Rcad.securityRepository.RoleRepository;
import com.mrf.Rcad.securityRepository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:8100")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;
    private JWTAuthenticationFilter filter;
 

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator, JWTAuthenticationFilter filter) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.filter = filter;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Map<String, String> token = jwtGenerator.generateToken(authentication);
        String access = token.get("access-token");
//        String refresh = token.get("refresh-token");
        return new ResponseEntity<>(access, HttpStatus.OK);
    }
    
    
    @GetMapping("/authenticate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void authenticate() {
    	
    }

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));

        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));
        userRepository.save(user);
        
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                registerDto.getUsername(),
                registerDto.getPassword()));
        
        Map<String, String> token = jwtGenerator.generateToken(authentication);
        String access = token.get("access-token");

        return new ResponseEntity<>(access, HttpStatus.OK);
        
    }
    
    @PostMapping("/registerClinic")
    public ResponseEntity<String> AddClinic(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        UserEntity clinic = new UserEntity();
        clinic.setUsername(registerDto.getUsername());
        clinic.setPassword(passwordEncoder.encode((registerDto.getPassword())));

        Role roles = roleRepository.findByName("CLINIC").get();
        clinic.setRoles(Collections.singletonList(roles));

        userRepository.save(clinic);

        return new ResponseEntity<>("Clinic registered success!", HttpStatus.OK);
    }
    
    @PostMapping("/registerSecretary")
    public ResponseEntity<String> AddSecretary(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        UserEntity secretary = new UserEntity();
        secretary.setUsername(registerDto.getUsername());
        secretary.setPassword(passwordEncoder.encode((registerDto.getPassword())));

        Role roles = roleRepository.findByName("SECRETARY").get();
        secretary.setRoles(Collections.singletonList(roles));

        userRepository.save(secretary);

        return new ResponseEntity<>("Secretary registered success!", HttpStatus.OK);
    }
    
    @PostMapping("/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
    	String token = filter.getJWTFromRequest(request);
    	if(StringUtils.hasText(token) && jwtGenerator.validateToken(token)) {
    		
    	}
    }
}
