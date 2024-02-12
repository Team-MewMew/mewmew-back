package com.mewmew.mewmewback.domain.role.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Setter;

@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long roleNo;

    @Size(max=50)
    @NotNull
    private String roleName;

    @Size(max=500)
    @NotNull
    private String roleExplain;

    @Builder

    public Role(String roleName, String roleExplain) {
        this.roleName = roleName;
        this.roleExplain = roleExplain;
    }
}
