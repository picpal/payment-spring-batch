package com.bwc.pg.batch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TargetEntity {
    @Id
    private Long id;
    private String processedName;

    // Getters and Setters
}