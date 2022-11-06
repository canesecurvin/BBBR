package com.example.capstone.bbbr.services;

import com.example.capstone.bbbr.configurations.security.jwt.JwtTokenUtil;
import com.example.capstone.bbbr.configurations.security.services.UserDetailsImpl;
import com.example.capstone.bbbr.entities.RoleEnum;
import com.example.capstone.bbbr.entities.User;
import com.example.capstone.bbbr.repositories.UserRepository;
import com.example.capstone.bbbr.requests.LoginUserRequest;
import com.example.capstone.bbbr.requests.RegisterUserRequest;
import com.example.capstone.bbbr.responses.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
>>>>>>> Stashed changes

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    FavoritesService favoritesService;

    @Override
    public UserResponse registerUser(RegisterUserRequest registerUserRequest){
        User user = new User(registerUserRequest);
        user.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        userRepository.saveAndFlush(user);
        return new UserResponse(user, new ArrayList<>());
    }

    @Override
    public UserResponse userLogin(LoginUserRequest loginUserRequest) throws ParseException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUserRequest.getEmail(), loginUserRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtTokenUtil.createJwtToken(authentication);
        System.out.println("--------------JWT" + jwtToken);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        UserResponse userResponse = new UserResponse(loginUserRequest);
        Optional<User> userOptional = userRepository.findByEmail(loginUserRequest.getEmail());
        if (userOptional.isPresent()) {
            if (passwordEncoder.matches(loginUserRequest.getPassword(), userOptional.get().getPassword())) {
                userResponse.setId(userOptional.get().getId());
                userResponse.setLastName(userOptional.get().getLastName());
                userResponse.setFirstName(userOptional.get().getFirstName());
                userResponse.setFavorites(favoritesService.userFavorites(userOptional.get().getId()));
            }
        }

        JwtResponse jres = new JwtResponse(jwtToken, userResponse,roles);
        System.out.println(jres);
        userResponse.setJwtResponse(jres);
        return userResponse;
    }

    @Override
    public String deleteUser(Long userId){
        userRepository.deleteById(userId);
        return "Successfully deleted";
    }

    @Override
    public UserResponse updateUser(RegisterUserRequest registerUserRequest, Long userId){
        User user = new User(registerUserRequest);
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            user.setPassword(userOptional.get().getPassword());
            user.setId(userId);
            userRepository.saveAndFlush(user);
        }
        return new UserResponse(user, favoritesService.userFavorites(userId));
    }
}
