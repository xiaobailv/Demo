package com.liushihao.batch.config;

import com.liushihao.batch.processor.Test03Processor;
import com.liushihao.batch.reader.Test03Reader;
import com.liushihao.batch.writer.Test03Writer;
import com.liushihao.entity.Log;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Test03Config {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Autowired
    private Test03Reader test03Reader;
    @Autowired
    private Test03Processor test03Processor;
    @Autowired
    private Test03Writer test03Writer;

    public Job jobMethod() {
        return jobBuilderFactory.get("Test03")
                .start(stepMethod())
                .build();
    }

    public Step stepMethod() {
        return stepBuilderFactory.get("Test03Step")
                .<List<Log>, List<Log>>chunk(1000)
                .reader(test03Reader)
                .processor(test03Processor)
                .writer(test03Writer)
                .build();
    }
}
