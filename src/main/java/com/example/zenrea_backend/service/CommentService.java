package com.example.zenrea_backend.service;

import com.example.zenrea_backend.dto.CommentDto;
import com.example.zenrea_backend.entity.Comment;
import java.util.List;
import java.util.Optional;

public interface CommentService {
    String save(CommentDto commentDto);
    List<Comment> getAll();

    Optional<Comment> getById(Long id);

    void deleteById(Long id);
}

