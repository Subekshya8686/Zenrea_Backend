package com.example.zenrea_backend.service;

import com.example.zenrea_backend.dto.CardDto;
import com.example.zenrea_backend.entity.Card;
import java.util.List;
import java.util.Optional;

public interface CardService {
    String save(CardDto cardDto);
    List<Card> getAll();
    Optional<Card> getById(Long id);

    void deleteById(Long id);
}
