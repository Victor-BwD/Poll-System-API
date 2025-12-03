package br.com.victorbwd.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Poll {
    private String id;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
}
