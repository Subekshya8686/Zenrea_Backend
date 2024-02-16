package com.example.zenrea_backend.service.impl;

import com.example.zenrea_backend.dto.BoardDto;
import com.example.zenrea_backend.entity.Board;
import com.example.zenrea_backend.repository.BoardRepository;
import com.example.zenrea_backend.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepo;

    @Override
    public String save(BoardDto boardDto) {
        Board board = new Board();
        if(boardDto.getId()!=null) {
            board=boardRepo.findById((boardDto.getId())).orElseThrow(() ->new NullPointerException("data not found"));
        }
        board.setName(boardDto.getName());
        boardRepo.save(board);
        return "created";
    }

    @Override
    public List<Board> getAll() {
        return boardRepo.findAll();
    }

    @Override
    public Optional<Board> getById(Long id) {
        return boardRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        boardRepo.deleteById(id);
    }
}
