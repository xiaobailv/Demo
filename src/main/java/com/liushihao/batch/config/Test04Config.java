package com.liushihao.batch.config;

import com.liushihao.batch.processor.Test04Processor;
import com.liushihao.batch.reader.Test04Reader;
import com.liushihao.batch.writer.Test04Writer;
import com.liushihao.entity.Log;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Test04Config {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Autowired
    private Test04Reader test04Reader;
    @Autowired
    private Test04Processor test04Processor;
    @Autowired
    private Test04Writer test04Writer;

    public Job jobMethod() {
        return jobBuilderFactory.get("Test04")
                .start(stepMethod())
                .build();
    }

    public Step stepMethod() {
        return stepBuilderFactory.get("Test03Step")
                .<List<Log>, List<Log>>chunk(1000)
                .reader(test04Reader)
                .processor(test04Processor)
                .writer(test04Writer)
                .build();
    }
}
