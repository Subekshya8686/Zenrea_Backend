package com.example.zenrea_backend.service.impl;

import com.example.zenrea_backend.dto.CommentDto;
import com.example.zenrea_backend.entity.Comment;
import com.example.zenrea_backend.repository.CommentRepository;
import com.example.zenrea_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepo;

    @Override
    public String save(CommentDto commentDto) {
        Comment comment = new Comment();
        if(commentDto.getId()!=null) {
            comment=commentRepo.findById((commentDto.getId())).orElseThrow(() ->new NullPointerException("data not found"));
        }

        comment.setText(commentDto.getText());
        commentRepo.save(comment);
        return "created";
    }

    @Override
    public List<Comment> getAll() {
        return commentRepo.findAll();
    }

    @Override
    public Optional<Comment> getById(Long id) {
        return commentRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        commentRepo.deleteById(id);
    }
}
