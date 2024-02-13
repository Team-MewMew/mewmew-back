package com.mewmew.mewmewback.domain.post.repository;

import com.mewmew.mewmewback.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
