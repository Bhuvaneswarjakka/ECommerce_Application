package com.Bhuvaneswar.UserServive.as.a.OAuth2.Repository;

import com.Bhuvaneswar.UserServive.as.a.OAuth2.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID>
{

}
