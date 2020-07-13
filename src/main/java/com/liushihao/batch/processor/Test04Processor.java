package com.liushihao.batch.processor;

import com.liushihao.entity.Log;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@StepScope
public class Test04Processor implements ItemProcessor<List<Log>, List<Log>> {
    /*@Override
    public void write(List<? extends List<Log>> items) throws Exception {
        System.out.println("进入Test04Writer...");
        for (List<Log> item : items) {
            for (Log log : item) {
                System.out.println(log);
            }
        }
        System.out.println("结束Test04Writer...");
    }*/

    @Override
    public List<Log> process(List<Log> item) throws Exception {
        for (Log log : item) {
            System.out.println(log + "Test04Processor");
        }
        return null;
    }
}
