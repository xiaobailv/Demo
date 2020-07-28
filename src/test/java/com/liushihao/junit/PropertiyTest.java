package com.liushihao.junit;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertiyTest {

    public static String getProperties_1(String filePath, String keyWord){
        Properties prop = null;
        String value = null;
        try {
                // 通过Spring中的PropertiesLoaderUtils工具类进行获取
                prop = PropertiesLoaderUtils.loadAllProperties(filePath);
                // 根据关键字查询相应的值
                value = prop.getProperty(keyWord);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return value;
    }

    public static void main(String[] args) {
        String properties_1 = getProperties_1("application-txt.yml", "test.length");
        System.out.println(properties_1);
    }
}
