package com.bwc.pg.batch.reader;

import com.bwc.pg.batch.entity.SourceEntity;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManagerFactory;

@Configuration
public class ReaderConfig {
    @Bean
    public JpaPagingItemReader<SourceEntity> reader(EntityManagerFactory entityManagerFactory) {
        return new JpaPagingItemReaderBuilder<SourceEntity>()
                .name("sourceReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT s FROM SourceEntity s")
                .pageSize(10)
                .build();
    }
}