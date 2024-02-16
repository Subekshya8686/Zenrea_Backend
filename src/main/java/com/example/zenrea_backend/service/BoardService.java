package com.example.zenrea_backend.service;

import com.example.zenrea_backend.dto.BoardDto;
import com.example.zenrea_backend.entity.Board;
import java.util.List;
import java.util.Optional;

public interface BoardService {
    String save(BoardDto boardDto);
    List<Board> getAll();
    Optional<Board> getById(Long id);
    void deleteById(Long id);
}

