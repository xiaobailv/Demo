package com.liushihao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 刘世豪
 * @title
 * @description
 * @updateTime 2020/5/29 9:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    /**
     * id
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 身高
     */
    private Double height;
    /**
     * 体重
     */
    private Double weight;
}
