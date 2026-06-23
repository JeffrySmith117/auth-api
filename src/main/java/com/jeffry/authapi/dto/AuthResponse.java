package com.jeffry.authapi.dto;

public record AuthResponse(
        String accessToken,
        String refreshToken
) {}