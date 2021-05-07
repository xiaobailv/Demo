package com.liushihao.annotation;

import com.liushihao.main.EasyDone;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

public class TestMock {

    @Test
    public void sayHelloCH() {
        new MockUp<EasyDone>() {
            @Mock
            public String sayHello() {
                return "11111";
            }
        };
        EasyDone easyDone = new EasyDone();
        String sayHello = easyDone.sayHello();
        System.out.println("sayHello = " + sayHello);
    }
}
