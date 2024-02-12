package com.mewmew.mewmewback;

import com.mewmew.mewmewback.domain.role.entity.Role;
import com.mewmew.mewmewback.domain.role.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class RoleEntityTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
//    @Rollback(false)
    public void testRoleEntityCreation() {
        Role role = Role.builder()
                .roleName("user")
                .roleExplain("일반 유저 입니다.")
                .build();

        roleRepository.save(role);

        assertNotNull(role.getRoleNo());

        Optional<Role> role2 = roleRepository.findById(role.getRoleNo());
        Role retrievedRole = role2.get();

        assertNotNull(retrievedRole);
        assertEquals("user", retrievedRole.getRoleName());
        assertEquals("일반 유저 입니다.", retrievedRole.getRoleExplain());
    }
}
