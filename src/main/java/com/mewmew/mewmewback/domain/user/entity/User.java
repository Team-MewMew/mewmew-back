package com.mewmew.mewmewback.domain.user.entity;

import com.mewmew.mewmewback.global.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

@Entity
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

    @Column(name = "user_del_flag", columnDefinition = "TINYINT(1)", nullable = false)
    @ColumnDefault("0")
    @Comment("탈퇴여부 확인 0: 활성, 1: 탈퇴")
    private Boolean userDelFlag;
}
