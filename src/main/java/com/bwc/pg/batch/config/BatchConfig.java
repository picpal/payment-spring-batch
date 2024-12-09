package com.bwc.pg.batch.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    // 기본적인 Batch 설정은 EnableBatchProcessing이 자동으로 제공
}
