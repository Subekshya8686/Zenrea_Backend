package com.example.zenrea_backend.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "lists")
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    private String name;

    private Integer position;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    // Constructors, getters, setters
}

