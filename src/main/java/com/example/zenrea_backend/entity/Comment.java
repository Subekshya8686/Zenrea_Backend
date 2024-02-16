package com.example.zenrea_backend.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String text;

    @Column(name = "created_at")
    private Timestamp createdAt;

    // Constructors, getters, setters
}

