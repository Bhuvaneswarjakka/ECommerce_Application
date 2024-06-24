package com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs;

import com.Bhuvaneswar.UserServive.as.a.OAuth2.Entity.Role;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserResponseDTO
{
    private String nameOfUser;
    private String email;
    private List<RoleResponseDTO> roles;

    //mapper
    public static UserResponseDTO from(User user)
    {
        UserResponseDTO userResponseDTO=new UserResponseDTO();
        userResponseDTO.nameOfUser=user.getNameOfUser();
        userResponseDTO.email=user.getEmailId();
        userResponseDTO.roles=new ArrayList<>();
        for(Role role: user.getRoles())
        {
            RoleResponseDTO responseDTO=new RoleResponseDTO();
            responseDTO.setNameOfRole(role.getNameOfRole());
        }
        return userResponseDTO;
    }

    public static User from(UserResponseDTO userResponseDTO)
    {
        return null;
    }
}
