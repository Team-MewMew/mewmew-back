package com.mewmew.mewmewback.domain.post.entity;

import com.mewmew.mewmewback.domain.music.entity.Music;
import com.mewmew.mewmewback.domain.user.entity.User;
import com.mewmew.mewmewback.global.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.springframework.util.Assert;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long postNo;

    @Column(nullable = false)
    private String postTitle;

    @Lob
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

    @ManyToOne
    private User writer;

    @ManyToOne
    private Music music;

    @Builder
    public Post(final String postTitle, final String postContent, final Integer musicRating,
                final User writer, final Music music) {
        this.postTitle = postTitle;
        this.postContent = isBlankContent(postContent);
        this.postHit = 0;
        this.musicRating = musicRating;
        this.postDelFlag = false;
        this.writer = writer;
        this.music = music;
        Assert.notNull(postTitle, "제목은 필수입니다.");
        Assert.notNull(musicRating, "점주는 필수입니다.");
        Assert.notNull(writer, "작성자는 필수입니다.");
        Assert.notNull(music, "음악은 필수입니다.");
    }

    private static String isBlankContent(final String postContent) {
        return postContent.isBlank() ? "" : postContent.trim();
    }

    public void edit(final String postTitle, final String postContent, final Integer musicRating) {
        this.postTitle = postTitle;
        this.postContent = isBlankContent(postContent);
        this.musicRating = musicRating;
    }

    public void delete() {
        this.postDelFlag = true;
    }

    public void view() {
        this.postHit++;
    }

}
