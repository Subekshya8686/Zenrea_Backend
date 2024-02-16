package com.example.zenrea_backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListDto {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long boardId;

}
