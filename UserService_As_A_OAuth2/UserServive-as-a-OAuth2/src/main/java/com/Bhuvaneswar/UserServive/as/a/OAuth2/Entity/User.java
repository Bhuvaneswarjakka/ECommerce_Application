package com.Bhuvaneswar.UserServive.as.a.OAuth2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "ECOM_USER")
@Getter
@Setter
public class User extends BaseModel
{
    private String nameOfUser;
    private String emailId;
    private String password; // this should be encrypted
    @ManyToMany
    private List<Role> roles;
}
