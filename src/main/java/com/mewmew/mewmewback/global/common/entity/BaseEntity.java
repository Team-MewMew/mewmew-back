package com.mewmew.mewmewback.global.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.sql.Timestamp;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "created_at", updatable = false,  nullable = false)
    private Timestamp createdAt; // (작성일시)

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt; // (수정일시)
}
