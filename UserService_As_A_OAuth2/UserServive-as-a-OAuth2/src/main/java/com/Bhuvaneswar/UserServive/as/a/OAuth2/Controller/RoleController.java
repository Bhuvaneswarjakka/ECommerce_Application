package com.Bhuvaneswar.UserServive.as.a.OAuth2.Controller;

import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.RoleRequestDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.RoleResponseDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController
{
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleResponseDTO> createRole(@RequestBody RoleRequestDTO roleRequestDTO)
    {
        return ResponseEntity.ok(roleService.createRole(roleRequestDTO));
    }
}
