package com.example.demo.service;

import com.example.demo.DAO.UserDAO;
import com.example.demo.config.AuthenticationRequest;
import com.example.demo.config.AuthenticationResponce;
import com.example.demo.config.RegisterRequest;
import com.example.demo.config.JwtService;
import com.example.demo.model.Appuser;
import com.example.demo.model.Role;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
@Data
public class UserImpl {
    private final UserDAO userDAO ;
    private final PasswordEncoder passwordEncoder ;
    private final JwtService jwtservice ;
    private final AuthenticationManager authenticationManager;
    public void signup(RegisterRequest request){
     var user = Appuser.builder()
             .firstname(request.getFirstname())
             .lasttname(request.getLastname())
             .email((request.getEmail()))
             .password(passwordEncoder.encode(request.getPassword()))
             .role(Role.User)
             .build();
     userDAO.save(user);
     /*
        var jwtToken = jwtservice.generateToken(user);
    return AuthenticationResponce.builder()
            .token(jwtToken)
            .build() ;

      */
    }

    public AuthenticationResponce signin(AuthenticationRequest request){

       authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                       request.getPassword()
                )
        );
        Appuser user = userDAO.findByEmail(request.getEmail());
        var jwtToken = jwtservice.generateTokenn(user);

        return AuthenticationResponce.builder()
                .token(jwtToken)
                .build() ;
    }


}
