package com.robson.back_end.model;

import com.robson.back_end.enums.RoleNames;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    @Enumerated(EnumType.STRING)
            @Column(name = "role")
    RoleNames role;
    @Override
    public String getAuthority() {
        return role.toString();
    }


}
