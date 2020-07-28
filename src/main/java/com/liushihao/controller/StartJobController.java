package com.liushihao.controller;

import com.liushihao.batch.config.Test01Config;
import com.liushihao.batch.config.Test02Config;
import com.liushihao.batch.config.Test03Config;
import com.liushihao.batch.config.Test04Config;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

@RestController
public class StartJobController {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Test01Config test01Config;
    @Autowired
    private Test02Config test02Config;
    @Autowired
    private Test03Config test03Config;
    @Autowired
    private Test04Config test04Config;

    @RequestMapping("/start")
    public ResponseEntity<Void> jobStart(){
        long start = System.currentTimeMillis();
        // AcomOverWriter.fileOver(x);
        // String jobparam = "测试job调用";
        LocalDateTime now = LocalDateTime.now();
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("jobparam",now.toString() )
                .toJobParameters();
        try {
//            jobLauncher.run(test01Config.test01Job(),jobParameters);
//            jobLauncher.run(test02Config.test02Job(),jobParameters);
//            jobLauncher.run(test03Config.jobMethod(),jobParameters);
            jobLauncher.run(test04Config.jobMethod(),jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("程序运行时间" + (end - start));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping("/property")
    public String getProperty(/*String filePath, String keyWord*/){
        Properties prop = null;
        String value = null;
        try {
            // 通过Spring中的PropertiesLoaderUtils工具类进行获取
            prop = PropertiesLoaderUtils.loadAllProperties(/*filePath*/"application.yml");
            // 根据关键字查询相应的值
            value = prop.getProperty(/*keyWord*/"test.length");
            System.out.println(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
