package com.liushihao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
@Accessors
public class User implements Serializable {

    private String id;          // id
    private String userName;    // 用户名
    private String password;    // 密码
    private Integer age;        // 年龄
    private String birthday;    // 生日
    private Double height;      // 身高
    private Double weight;      // 体重
}
