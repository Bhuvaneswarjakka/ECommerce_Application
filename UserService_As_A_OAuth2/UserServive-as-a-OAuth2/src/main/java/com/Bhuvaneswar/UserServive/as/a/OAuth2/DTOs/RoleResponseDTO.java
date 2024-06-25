package com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs;

import com.Bhuvaneswar.UserServive.as.a.OAuth2.Entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RoleResponseDTO
{
    private String nameOfRole;
    private String description;

    public static RoleResponseDTO from(Role role)
    {
        RoleResponseDTO responseDTO=new RoleResponseDTO();
        responseDTO.nameOfRole= role.getNameOfRole();
        responseDTO.description=role.getDescription();

        return responseDTO;
    }
}
