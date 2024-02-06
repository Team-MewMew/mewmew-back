package com.mewmew.mewmewback.domain.post.entity;

import com.mewmew.mewmewback.global.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long postNo;

    @Column(nullable = false)
    private String postTitle;

    @Column(columnDefinition = "TEXT")
    private String postContent;

    @Column(nullable = false)
    private Integer postHit;

    @Column(nullable = false)
    private Integer musicRating;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    @ColumnDefault("0")
    @Comment("게시글 삭제 여부 0: 삭제되지 않음, 1: 삭제")
    private Boolean postDelFlag;

    @Builder
    public Post(final String postTitle, final Integer musicRating) {
        this.postTitle = postTitle;
        this.postContent = "";
        this.postHit = 0;
        this.musicRating = musicRating;
        this.postDelFlag = false;
    }

    @Builder
    public Post(final String postTitle, final String postContent, final Integer musicRating) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postHit = 0;
        this.musicRating = musicRating;
        this.postDelFlag = false;
    }
}
