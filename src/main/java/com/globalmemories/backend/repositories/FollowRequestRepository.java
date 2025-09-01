package com.globalmemories.backend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.globalmemories.backend.entites.FollowRequest;

public interface FollowRequestRepository extends JpaRepository<FollowRequest, Long> {
    // Finds all pending (not yet accepted) follow requests for a specific user (the target).
    List<FollowRequest> findByTargetIdAndAcceptedFalse(Long targetId);
    // Checks if a follow request already exists from a requester to a target user.
    boolean existsByRequesterIdAndTargetId(Long requesterId, Long targetId);
}