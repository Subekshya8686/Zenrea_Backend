package com.example.zenrea_backend.controller;

import com.example.zenrea_backend.dto.BoardDto;
import com.example.zenrea_backend.entity.Board;
import com.example.zenrea_backend.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/data")
    public String getData(){
        return "data retrieved";
    }

    @PostMapping("/save")
    public String createData(@RequestBody BoardDto boardDto){
        boardService.save(boardDto);
        return "created data";
    }

    @GetMapping("/getAll")
    public List<Board> getAllData() {
        return boardService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Board> getById(@PathVariable("id") Long id) {
        return boardService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        boardService.deleteById(id);
    }
}

