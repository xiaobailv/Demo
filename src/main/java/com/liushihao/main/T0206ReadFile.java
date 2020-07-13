package com.liushihao.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 刘世豪
 * @title T0206在读取文件的时候
 * @description
 * @updateTime 2020/6/4 19:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class T0206ReadFile {

    private Integer index;      // 读取文件的游标
    private String key;         // 交易码+段位图，作为bufChg的key值 如：TC0008000
    private Integer length;     // 后续读取的数据长度
    private String describe;    // 读取文件信息描述
}
