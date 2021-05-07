package com.liushihao.redis.controller;

import com.liushihao.entity.Jd;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/string")
public class OpString {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/singleSet")
    public String singleSet(String key, String value) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
        return "存入成功";
    }

    @RequestMapping("/singleGet")
    public Object singleGet(String key) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object o = valueOperations.get(key);
        return o;
    }

    @RequestMapping("/code")
    public String code(String phone) {
        Boolean isHasCode = redisTemplate.hasKey(phone);
        if (isHasCode) {
            return "发送过于频繁, 请稍后再试。。。";
        }
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            code.append(ThreadLocalRandom.current().nextInt(10));
        }
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(phone, code.toString(), 60, TimeUnit.SECONDS);
        return "验证码发送成功。" + code.toString();
    }

    @RequestMapping("/validate")
    public String validate(String phone, String userCode) {
        if (StringUtils.isBlank(userCode)) {
            return "请确认验证码正确输入...";
        }
        Boolean isHasCode = redisTemplate.hasKey(phone);
        if (!isHasCode) {
            return "验证码已过期或未曾获取验证码, 请重试。";
        }
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String ourCode = (String) valueOperations.get(phone);
        if (userCode.equals(ourCode)) {
            return "验证成功";
        } else {
            return "验证失败";
        }
    }

    @RequestMapping("/counter")
    public Object counter(String key) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Long increment = valueOperations.increment(key);
        return increment;
    }

    @RequestMapping("/setObject")
    public String setObject() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date birthday = null;
        try {
            birthday = sdf.parse("19910105");
        } catch (ParseException e) {
            log.error("---setObject日期转换错误---");
        }
        Jd jd = new Jd("1", "liush", "male", "13137132561", "111111@qq.com", "111", birthday);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("Jd", jd);
        return "对象存入成功";
    }

    @RequestMapping("/getObject")
    public String getObject() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Jd jd = (Jd) valueOperations.get("Jd");
        System.out.println(jd);
        return jd.toString();
    }
}
