package com.Bhuvaneswar.UserServive.as.a.OAuth2.Service;

import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.RoleRequestDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.RoleResponseDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Entity.Role;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Repository.RoleRepository;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService
{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO)
    {
        Role role=new Role();
        role.setNameOfRole(roleRequestDTO.getRoleName());
        role.setDescription(roleRequestDTO.getDescription());
        roleRepository.save(role);
        return RoleResponseDTO.from(role);
    }
}
