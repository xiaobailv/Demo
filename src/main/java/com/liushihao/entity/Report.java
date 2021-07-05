package com.liushihao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 刘世豪
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    /**
     * 库表中文名
     */
    private String tableChName;

    /**
     * 库表英文名
     */
    private String tableEngName;

    /**
     * 字段中文名
     */
    private String colChName;

    /**
     * 字段英文名
     */
    private String colEngName;

    /**
     * 备注
     */
    private String comment;

    /**
     * 数据字典编号
     */
    private String dicNumber;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 是否为主键
     */
    private String isPrimaryKey;
}
