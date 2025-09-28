package com.globalmemories.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.globalmemories.backend.entites.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    boolean existsByFollowerIdAndFollowedId(Long followerId, Long followedId);
    void deleteByFollowerIdAndFollowedId(Long followerId, Long followedId);
    Long countByFollowerId(Long followerId);
    Long countByFollowedId(Long followedId);
}