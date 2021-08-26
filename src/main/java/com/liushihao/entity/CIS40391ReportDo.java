package com.liushihao.entity;

/**
 * @Description
 * @Author 刘世豪
 * @Date 2021/8/23
 */
public class CIS40391ReportDo {

    public String requestReport(){
        System.out.println("*******执行CIS40391ReportDo.requestReport*******");
        return "*******CIS40391ReportDo.requestReport成功*******";
    }

    public CIS40391ReportDo() {
        System.out.println("*******CIS40391ReportDo*******");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
