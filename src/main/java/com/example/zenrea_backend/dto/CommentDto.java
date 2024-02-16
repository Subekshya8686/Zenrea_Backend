package com.example.zenrea_backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;

    @NotNull
    private String text;

    @NotNull
    private Long cardId;

    @NotNull
    private Long userId;

}