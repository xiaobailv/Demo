package com.liushihao.selenium;

import org.junit.Test;

public class TestBaiduSelenium {

    @Test
    public void login() throws InterruptedException {
        BaiduSelenium.commonLogin("13137132561", "lsh13137132561");
    }
}
