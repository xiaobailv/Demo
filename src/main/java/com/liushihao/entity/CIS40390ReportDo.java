package com.liushihao.entity;

/**
 * @Description
 * @Author 刘世豪
 * @Date 2021/8/23
 */
public class CIS40390ReportDo {

    public String requestReport(){
        System.out.println("*******执行CIS40390ReportDo.requestReport*******");
        return "*******CIS40390ReportDo.requestReport成功*******";
    }

    public CIS40390ReportDo() {
        System.out.println("*******CIS40390ReportDo*******");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
