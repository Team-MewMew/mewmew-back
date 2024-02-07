package com.mewmew.mewmewback.domain.playlist.service;

import com.mewmew.mewmewback.domain.playlist.dto.request.RequestDto;
import com.mewmew.mewmewback.domain.playlist.entity.Playlist;
import com.mewmew.mewmewback.domain.playlist.repository.PlaylistRepository;
import com.mewmew.mewmewback.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
//    private final UserRepository userRepository;

    @Transactional
    public void registerPlaylist(RequestDto requestDto) {

        Playlist playlist = new Playlist();
        playlist.setPlaylistTitle(requestDto.getPlaylistTitle());
        playlist.setPlaylistContent(requestDto.getPlaylistContent());
        playlist.setPlaylistStatus(requestDto.getPlaylistStatus());

//        User 정보 !
//        Optional<User> user = userRepository.findByUserNo(userNo);
//        playlist.setUser(user.get());

        playlistRepository.save(playlist);
    }
}
