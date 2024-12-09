package com.bwc.pg.batch.config;

import com.bwc.pg.batch.entity.SourceEntity;
import com.bwc.pg.batch.entity.TargetEntity;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public JobConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job simpleJob(Step simpleStep) {
        return jobBuilderFactory.get("simpleJob")
                .start(simpleStep)
                .build();
    }

    @Bean
    public Step simpleStep(ItemReader<SourceEntity> reader,
                           ItemProcessor<SourceEntity, TargetEntity> processor,
                           ItemWriter<TargetEntity> writer) {
        return stepBuilderFactory.get("simpleStep")
                .<SourceEntity, TargetEntity>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}