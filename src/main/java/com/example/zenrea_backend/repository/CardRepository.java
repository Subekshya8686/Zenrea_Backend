package com.example.zenrea_backend.repository;

import com.example.zenrea_backend.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}

