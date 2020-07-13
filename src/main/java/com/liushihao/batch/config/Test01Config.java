package com.liushihao.batch.config;

import com.liushihao.config.SpringVariableConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘世豪
 * @title
 * @description
 * @updateTime 2020/5/27 20:04
 */
@Configuration
//@EnableBatchProcessing
public class Test01Config {

    // 注入创建任务对象的对象
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    // 任务的执行由Step决定
    // 注入创建Step对象的对象
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private SpringVariableConfig springVariableConfig;

    // 创建任务对象
    @Bean
//    @LogAspect(operationName = "执行了Test01Config的helloWorldJob方法", fileName = "D:\\Download\\Test01Config.txt")
    public Job test01Job(){
        return jobBuilderFactory.get("Test01Job")
                .start(test01Step1())
                .next(test01Step2())
                .build();
    }

    @Bean
//    @LogAspect(operationName = "执行了Test01Config的step1方法", fileName = "D:\\Download\\Test01Config.txt")
    public Step test01Step1(){
        return stepBuilderFactory.get("Test01Step1")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("进入Test01Step1...");
                        Integer i1 = springVariableConfig.variable1;
                        System.out.println("获取到的i ===> " + i1);
                        // 将获取到的i进行操作
                        for (int i = 0; i < 10; i++) {
                            i1++;
                        }
                        System.out.println("加10后的i ===> " + i1);
                        springVariableConfig.variable1 = i1;
                        System.out.println("结束Test01Step1...");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Step test01Step2(){
        return stepBuilderFactory.get("Test01Step2")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("进入Test01Step2...");
                        Integer i1 = springVariableConfig.variable1;
                        System.out.println("获取到的i ===> " + i1);
                        // 将获取到的i进行操作
                         for (int i = 0; i < 10; i++) {
                            i1++;
                        }
                        System.out.println("加10后的i ===> " + i1);
                        System.out.println("结束Test01Step2...");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }
}
