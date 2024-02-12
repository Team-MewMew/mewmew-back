package com.mewmew.mewmewback.domain.user.entity;

import com.mewmew.mewmewback.domain.role.entity.Role;
import com.mewmew.mewmewback.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no", nullable = false, unique = true, updatable = false)
    private Long userNo;


    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Column(unique = true, nullable = false)
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "role_no")
    private Role role;

    @Column(name = "user_del_flag", columnDefinition = "TINYINT(1)", nullable = false)
    @ColumnDefault("0")
    @Comment("탈퇴여부 확인 0: 활성, 1: 탈퇴")
    private Boolean userDelFlag;

    @Builder
    public User(final String email, final String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}
