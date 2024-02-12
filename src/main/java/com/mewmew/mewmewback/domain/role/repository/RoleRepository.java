package com.mewmew.mewmewback.domain.role.repository;

import com.mewmew.mewmewback.domain.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
