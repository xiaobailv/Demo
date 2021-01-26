package com.liushihao.junit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SpringTest {

    @Test
    public void getBean() {
        System.out.println("this = " + this);
    }
}
