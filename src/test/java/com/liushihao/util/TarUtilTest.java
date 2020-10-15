package com.liushihao.util;

import org.junit.Test;

import java.io.IOException;

public class TarUtilTest {

    @Test
    public void creatTar() throws IOException {
        String archive = TarUtil.archive("D:/KL-Bank/rizhong/中国银联银行卡交换系统技术规范（境内卷）/中国银联银行卡交换系统技术规范 境内卷(2017.A)");
        System.out.println("archive = " + archive);
    }
}
