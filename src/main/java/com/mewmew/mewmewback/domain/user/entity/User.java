package com.mewmew.mewmewback.domain.user.entity;

import com.mewmew.mewmewback.domain.role.entity.Role;
import com.mewmew.mewmewback.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @Column(name = "user_no")
    private Long userNo;


    @NotNull
    @Column(unique = true)
    private String email;

    private String password;

    @NotNull
    @Column(unique = true)
    private String nickname;
  
    @NotNull
    @Column(name = "user_del_flag", columnDefinition = "TINYINT(1)")
    @ColumnDefault("0")
    @Comment("탈퇴여부 확인 0: 활성, 1: 탈퇴")
    private Boolean userDelFlag;

    @ManyToOne
    @JoinColumn(name = "role_no")
    private Role role;

    @Builder
    public User(final String email, final String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}
