package com.liushihao;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableBatchProcessing
@MapperScan(value = "com.liushihao.dao")
public class SerilizableApplication {

    public static void main(String[] args) {
        SpringApplication.run(SerilizableApplication.class, args);
    }

}
