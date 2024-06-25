package com.Bhuvaneswar.UserServive.as.a.OAuth2.Service;

import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.RoleRequestDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.RoleResponseDTO;

public interface RoleService
{
    RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);
}
