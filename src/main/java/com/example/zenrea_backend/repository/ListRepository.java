package com.example.zenrea_backend.repository;

import com.example.zenrea_backend.entity.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<List, Long> {
}
