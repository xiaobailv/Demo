package com.liushihao.main;

/**
 * @author 刘世豪
 * @title
 * @description
 * @updateTime 2020/5/25 17:58
 */
public class Variable2 {

    public static void main(String[] args) {
        System.out.println("进入main方法...");
        int add = add();
        System.out.println(add);
        Variable1 variable1 = new Variable1();
        System.out.println(variable1.i);
    }

    public static int add(){
        Variable1 variable1 = new Variable1();
        System.out.println(variable1.i);
        int add = variable1.add();
        System.out.println(variable1.i);
        return add;
    }
}
