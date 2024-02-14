package com.mewmew.mewmewback.domain.playlist.entity;

import com.mewmew.mewmewback.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "playlist_review")
public class PlaylistReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_review_no", nullable = false)
    private Long playlistReviewNo;

    @ManyToOne
    @JoinColumn(name = "playlist_review_detail_no", nullable = false)
    private PlaylistReviewDetail playlistReviewDetail;

    @ManyToOne
    @JoinColumn(name = "playlist_no", nullable = false)
    private Playlist playlist;

//    @ManyToOne
//    @JoinColumn(name = "user_no", nullable = false)
//    private User user;

}
