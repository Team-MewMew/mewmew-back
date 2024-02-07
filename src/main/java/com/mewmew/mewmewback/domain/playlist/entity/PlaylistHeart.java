package com.mewmew.mewmewback.domain.playlist.entity;

import com.mewmew.mewmewback.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "playlist_heart")
public class PlaylistHeart {

//    @Id
//    @ManyToOne
//    @JoinColumn(name = "user_no")
//    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "playlist_no")
    private Playlist playlist;

}
