package com.example.zenrea_backend.service.impl;

import com.example.zenrea_backend.dto.CardDto;
import com.example.zenrea_backend.entity.Card;
import com.example.zenrea_backend.repository.CardRepository;
import com.example.zenrea_backend.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepo;

    @Override
    public String save(CardDto cardDto) {
        Card card = new Card();

        if(cardDto.getId()!=null) {
            card=cardRepo.findById((cardDto.getId())).orElseThrow(() ->new NullPointerException("data not found"));
        }
        card.setName(cardDto.getName());

        cardRepo.save(card);
        return "created";
    }

    @Override
    public List<Card> getAll() {
        return cardRepo.findAll();
    }

    @Override
    public Optional<Card> getById(Long id) {
        return cardRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        cardRepo.deleteById(id);
    }
}
