package com.example.zenrea_backend.repository;

import com.example.zenrea_backend.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}

