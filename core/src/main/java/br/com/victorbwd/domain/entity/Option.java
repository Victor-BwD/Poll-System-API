package br.com.victorbwd.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Option {
    private String id;
    private String title;
}
