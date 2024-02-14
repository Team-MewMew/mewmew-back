package com.mewmew.mewmewback.domain.playlist.dto.request;

import com.mewmew.mewmewback.domain.user.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class RequestDto {

    @NotBlank(message = "제목을 입력해주세요.")
    private String playlistTitle;

    @NotBlank(message = "소개글을 입력해주세요.")
    private String playlistContent;

    @NotBlank(message = "공개여부를 선택해주세요.")
    private int playlistStatus;

    private User user;

}
