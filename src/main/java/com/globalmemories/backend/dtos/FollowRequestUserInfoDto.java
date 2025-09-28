package com.globalmemories.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FollowRequestUserInfoDto {
    private Long id;
    private UserDto requester;
    private Long targetId;
    private boolean accepted = false;
}