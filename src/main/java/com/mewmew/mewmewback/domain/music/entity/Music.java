package com.mewmew.mewmewback.domain.music.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Time;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicNo;

    @Column(nullable = false)
    private String musicName;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Time playTime;

    private String youtubeUrl;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    @ColumnDefault("0")
    @Comment("노래 삭제 여부 0: 존재, 1: 삭제")
    private Boolean musicDelFlag;

    @Builder
    public Music(final String musicName, final Time playTime) {
        this.musicName = musicName;
        this.playTime = playTime;
        this.musicDelFlag = false;
        this.youtubeUrl = "";
    }
}
