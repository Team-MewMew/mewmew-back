package com.mewmew.mewmewback.domain.playlist.entity;

import com.mewmew.mewmewback.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_no", nullable = false)
    private Long playlistNo;

//    @ManyToOne
//    @JoinColumn(name = "user_no", nullable = false)
//    private User user;

    @Column(name = "playlist_status", nullable = false, length = 1)
    private int playlistStatus;

    @Column(name = "playlist_title", nullable = false, length = 100)
    private String playlistTitle;

    @Column(name = "playlist_content", nullable = false, length = 1000)
    private String playlistContent;

    @Column(name = "playlist_created_at", nullable = false)
    private Timestamp playlistCreatedAt;

    @Column(name = "playlist_del_flag", nullable = false, length = 1)
    private int playlistDelFlag;

    @PrePersist
    protected void onCreate() {
        playlistCreatedAt = new Timestamp(new Date().getTime());
        playlistDelFlag = 0;
    }
}
