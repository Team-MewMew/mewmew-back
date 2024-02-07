package com.mewmew.mewmewback.domain.post.entity;

import static org.assertj.core.api.Assertions.assertThat;

import com.mewmew.mewmewback.domain.music.entity.Music;
import com.mewmew.mewmewback.domain.user.entity.User;
import java.sql.Time;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PostTest {

    @Test
    @DisplayName("게시물을 볼 때 조회수가 증가하는지 확인 테스트")
    void should_IncreaseViewCount_When_ViewingPost() {
        // given
        User user = User.builder()
            .email("email123@Test.com")
            .nickname("test")
            .build();

        Music music = Music.builder()
            .musicName("TestMusic")
            .playTime(new Time(System.currentTimeMillis()))
            .build();

        Post post = Post.builder()
            .postTitle("TestTitle")
            .postContent("TestContent")
            .musicRating(5)
            .writer(user)
            .music(music)
            .build();

        // when
        post.view();

        // then
        assertThat(post.getPostHit()).isEqualTo(1);
    }
}