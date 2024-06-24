package com.Bhuvaneswar.UserServive.as.a.OAuth2.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ECOM_ROLE")
@Getter
@Setter
public class Role extends BaseModel
{
    private String nameOfRole;
    private String description;
}
