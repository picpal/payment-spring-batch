package com.bwc.pg.batch.writer;

import com.bwc.pg.batch.entity.TargetEntity;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManagerFactory;

@Configuration
public class WriterConfig {
    @Bean
    public JpaItemWriter<TargetEntity> writer(EntityManagerFactory entityManagerFactory) {
        return new JpaItemWriterBuilder<TargetEntity>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }
}

