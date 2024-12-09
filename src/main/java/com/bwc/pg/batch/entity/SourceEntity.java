package com.bwc.pg.batch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SourceEntity {
    @Id
    private Long id;
    private String name;

    // Getters and Setters
}