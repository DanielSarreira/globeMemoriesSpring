package com.globalmemories.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FollowRequestDto {
    private Long id;
    private Long requesterId;
    private Long targetId;
    private boolean accepted = false;
}