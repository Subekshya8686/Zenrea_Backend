package com.example.zenrea_backend.controller;

import com.example.zenrea_backend.dto.CardDto;
import com.example.zenrea_backend.entity.Card;
import com.example.zenrea_backend.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/data")
    public String getData(){
        return "data retrieved";
    }

    @PostMapping("/save")
    public String createData(@RequestBody CardDto cardDto){
        cardService.save(cardDto);
        return "created data";
    }

    @GetMapping("/getAll")
    public List<Card> getAllData() {
        return cardService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Card> getById(@PathVariable("id") Long id) {
        return cardService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        cardService.deleteById(id);
    }
}

