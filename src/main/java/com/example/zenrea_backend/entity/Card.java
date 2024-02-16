package com.example.zenrea_backend.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id")
    private List list;

    private String name;

    private String description;

    @Column(name = "due_date")
    private Timestamp dueDate;

    private Integer position;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    // Constructors, getters, setters
}
