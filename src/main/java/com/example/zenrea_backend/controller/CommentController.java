package com.example.zenrea_backend.controller;

import com.example.zenrea_backend.dto.CommentDto;
import com.example.zenrea_backend.entity.Comment;
import com.example.zenrea_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/data")
    public String getData(){
        return "data retrieved";
    }

    @PostMapping("/save")
    public String createData(@RequestBody CommentDto commentDto){
        commentService.save(commentDto);
        return "created data";
    }

    @GetMapping("/getAll")
    public List<Comment> getAllData() {
        return commentService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Comment> getById(@PathVariable("id") Long id) {
        return commentService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        commentService.deleteById(id);
    }
}

