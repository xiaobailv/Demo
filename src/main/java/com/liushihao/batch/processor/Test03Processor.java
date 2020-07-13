package com.liushihao.batch.processor;

import com.liushihao.entity.Log;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@StepScope
public class Test03Processor implements ItemProcessor<List<Log>, List<Log>> {
    @Override
    public List<Log> process(List<Log> item) throws Exception {
        item.removeIf(next -> "1".equals(next.getId()));
        return item;
    }
}
