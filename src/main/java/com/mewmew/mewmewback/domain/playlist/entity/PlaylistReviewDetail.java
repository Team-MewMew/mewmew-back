package com.mewmew.mewmewback.domain.playlist.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "playlist_review_detail")
public class PlaylistReviewDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_review_detail_no", nullable = false)
    private Long playlistReviewDetailNo;

    @Column(name = "playlist_review_detail", nullable = false, length = 100)
    private String playlistReviewDetail;
}
