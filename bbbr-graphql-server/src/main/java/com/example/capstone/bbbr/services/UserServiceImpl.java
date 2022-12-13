package com.example.capstone.bbbr.services;

import com.example.capstone.bbbr.configurations.security.jwt.JwtTokenUtil;
import com.example.capstone.bbbr.configurations.security.services.UserDetailsImpl;
import com.example.capstone.bbbr.entities.Role;
import com.example.capstone.bbbr.entities.RoleEnum;
import com.example.capstone.bbbr.entities.User;
import com.example.capstone.bbbr.repositories.RoleRepository;
import com.example.capstone.bbbr.repositories.UserRepository;
import com.example.capstone.bbbr.requests.LoginUserRequest;
import com.example.capstone.bbbr.requests.RegisterUserRequest;
import com.example.capstone.bbbr.responses.JwtResponse;
import com.example.capstone.bbbr.responses.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    FavoritesService favoritesService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleService roleService;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserResponse registerUser(RegisterUserRequest registerUserRequest){
        UserResponse userResponse = new UserResponse();
        Optional<User> userOptional = userRepository.findByEmail(registerUserRequest.getEmail());
        if (userOptional.isPresent()){
            userResponse.setErrorMessage("Email already exists");
        } else {
            User user = new User(registerUserRequest);
            user.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
            Set<Role> userRoles = new HashSet<>();
            userResponse = new UserResponse(user);
            Set<String> roleSet = new HashSet<>();
            registerUserRequest.getRoles().forEach(role-> {
                roleSet.add(role);
            });
            for(RoleEnum role: roleService.getUserRoleSet(roleSet)){
                userResponse.setRoles(role);
                Role r = new Role();
                r = roleRepository.findRoleByRoleName(role).get();
                userRoles.add(r);
            }
            user.setRoles(userRoles);
            userRepository.save(user);
        }
        return userResponse;
    }

    @Override
    public UserResponse userLogin(LoginUserRequest loginUserRequest) throws ParseException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUserRequest.getEmail(), loginUserRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtTokenUtil.createJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        System.out.println("--------------JWT" + userDetails.getAuthorities());
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
