package com.bwc.pg.batch.processor;

import com.bwc.pg.batch.entity.SourceEntity;
import com.bwc.pg.batch.entity.TargetEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<SourceEntity, TargetEntity> {
    @Override
    public TargetEntity process(SourceEntity item) throws Exception {
        TargetEntity target = new TargetEntity();
        target.setId(item.getId());
        target.setProcessedName(item.getName().toUpperCase()); // 간단한 변환 예제
        return target;
    }
}
