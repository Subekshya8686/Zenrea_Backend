package com.example.zenrea_backend.service;

import com.example.zenrea_backend.dto.ListDto;
import com.example.zenrea_backend.entity.BoardList;

import java.util.List;
import java.util.Optional;

public interface ListService {
    String save(ListDto listDto);
    List<BoardList> getAll();
    Optional<BoardList> getById(Long id);
    void deleteById(Long id);
}

