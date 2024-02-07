package com.mewmew.mewmewback.domain.playlist.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "playlist_music")
public class PlaylistMusic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_music_no", nullable = false)
    private Long playlistMusicNo;

    @ManyToOne
    @JoinColumn(name = "playlist_no", nullable = false)
    private Playlist playlist;

//    @ManyToOne
//    @JoinColumn(name = "music_no", nullable = false)
//    private Music music;

    @Column(name = "play_index", nullable = false)
    private Long playIndex;

}
