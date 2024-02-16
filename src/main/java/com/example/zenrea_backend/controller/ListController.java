package com.example.zenrea_backend.controller;

import com.example.zenrea_backend.dto.ListDto;
import com.example.zenrea_backend.entity.BoardList;
import com.example.zenrea_backend.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/list")
@RequiredArgsConstructor
public class ListController {

    private final ListService listService;

    @GetMapping("/data")
    public String getData(){
        return "data retrieved";
    }

    @PostMapping("/save")
    public String createData(@RequestBody ListDto listDto){
        listService.save(listDto);
        return "created data";
    }

    @GetMapping("/getAll")
    public List<BoardList> getAllData() {
        return listService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<BoardList> getById(@PathVariable("id") Long id) {
        return listService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        listService.deleteById(id);
    }
}
