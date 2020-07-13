package com.liushihao.main;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class T0206ReadFileTest {

    @Test
    public void t0206ReadFileList() {
        T0206ReadFile tc0008000 = new T0206ReadFile(1, "TC0008000", 39, "银联文件头 TC000");
        T0206ReadFile tc0018000 = new T0206ReadFile(2, "TC0018000", 42, "银联文件结尾TC001");
        T0206ReadFile tc300A000 = new T0206ReadFile(3, "TC300A000", 519, "TC300 段0，段2");
        T0206ReadFile tc0028000 = new T0206ReadFile(4, "TC0028000", 42, "TC002拒绝记录");
        T0206ReadFile tc0038000 = new T0206ReadFile(5, "TC0038000", 83, "TC003错误记录");
        T0206ReadFile tc301A000 = new T0206ReadFile(3, "TC301A000", 519, "TC301 段0，段2");

        /*List<T0206ReadFile> list = new ArrayList<>();
        list.add(tc0008000);
        list.add(tc0018000);
        list.add(tc300A000);
        list.add(tc0028000);
        list.add(tc0038000);
        list.add(tc301A000);*/

        Map<String, T0206ReadFile> hashMap = new HashMap<>();
        hashMap.put("TC0008000", tc0008000);
        hashMap.put("TC0018000", tc0018000);
        hashMap.put("TC300A000", tc300A000);
        hashMap.put("TC0028000", tc0028000);
        hashMap.put("TC0038000", tc0038000);
        hashMap.put("TC301A000", tc301A000);

        String str = "TC300A000";
        T0206ReadFile t0206ReadFile = hashMap.get(str);
        System.out.println(t0206ReadFile.getIndex());
        System.out.println(t0206ReadFile.getLength());
    }
}
