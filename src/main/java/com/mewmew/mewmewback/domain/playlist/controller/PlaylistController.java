package com.mewmew.mewmewback.domain.playlist.controller;

import com.mewmew.mewmewback.domain.playlist.dto.request.RequestDto;
import com.mewmew.mewmewback.domain.playlist.service.PlaylistService;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/playlist")
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    @PostMapping("/register")
    public ResponseEntity registerPlaylist(@RequestBody @Validated RequestDto requestDto) {
        playlistService.registerPlaylist(requestDto);
        return ResponseEntity.ok().build();
    }
}
