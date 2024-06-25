package com.Bhuvaneswar.UserServive.as.a.OAuth2.Service;

import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.LoginRequestDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.SignUpRequestDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.UserResponseDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Entity.Role;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Entity.User;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Exceptions.InvalidCredentialsException;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Exceptions.RoleIsNotFoundExcetion;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Exceptions.TokenInvalidException;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Repository.RoleRepository;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserResponseDTO userSignUp(SignUpRequestDTO signUpRequestDTO) throws RoleIsNotFoundExcetion
    {
        Role role=roleRepository.findById(signUpRequestDTO.getRoleId()).orElseThrow(
                ()-> new RoleIsNotFoundExcetion("Role Not Present")
        );
        //if the role is present, then i will add details to DB

        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

        User user=new User();
        user.setNameOfUser(signUpRequestDTO.getNameOfUser());
        user.setEmailId(signUpRequestDTO.getEmailId());
        user.setPassword(bCryptPasswordEncoder.encode(signUpRequestDTO.getPassword()));
        user.setRoles(List.of(role));
        userRepository.save(user);
        return UserResponseDTO.from(user);
    }

    @Override
    public UserResponseDTO userLogin(LoginRequestDTO loginRequestDTO) throws InvalidCredentialsException
    {
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        User savedUser=userRepository.findByEmailId(loginRequestDTO.getEmailId()).orElseThrow(
                ()-> new InvalidCredentialsException("Credentials provided is invalid")
        );

        //If EmailId enter is correct. bcz it is present in DB. So check password is correct or not
        if(bCryptPasswordEncoder.matches(loginRequestDTO.getPassword(), savedUser.getPassword()))
        {
            //if password also correct then send token to user (Actually BE for time being we are doiing this)
            String userData=bCryptPasswordEncoder.encode(loginRequestDTO.getPassword())+bCryptPasswordEncoder.encode(loginRequestDTO.getEmailId())+
                    LocalDateTime.now();
            String token=bCryptPasswordEncoder.encode(userData);
            savedUser.setToken(token);
        }
        else {
            throw new InvalidCredentialsException("Password is Incorrect");
        }
        userRepository.save(savedUser);
        return UserResponseDTO.from(savedUser);
    }

    @Override
    public boolean userValidate(String token) throws TokenInvalidException
    {
        User savedUser=userRepository.findByToken(token).orElseThrow(
                ()-> new TokenInvalidException("Token is Invalid")
        );
        return true;
    }

    @Override
    public boolean userLogout(String token) throws TokenInvalidException {
        User savedUser=userRepository.findByToken(token).orElseThrow(
                ()-> new TokenInvalidException("Token is Invalid")
        );
        savedUser.setToken(null);
        userRepository.save(savedUser);
        return true;
    }
}
