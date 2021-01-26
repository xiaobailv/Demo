package com.liushihao.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    // 这里使用的是根据class类型来获取bean 当然你可以根据名称或者其他之类的方法 主要是有applicationContext你想怎么弄都可以
    public static Object getBeanByClass(Class clazz) {
        return applicationContext.getBean(clazz);
    }

    public static Object getBeanByName(String name) {
        return applicationContext.getBean(name);
    }
}
