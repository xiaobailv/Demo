package com.liushihao.entity;

import com.alibaba.excel.annotation.ExcelProperty;
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
     * ExcelProperty("库表中文名")
     * 注解此处的参数可以使用数组的形式来展示复杂标题头
     *     例如ExcelProperty({"我是大标题", "我是二级标题"})
     */
    @ExcelProperty("库表中文名")
    private String tableChName;

    /**
     * 库表英文名
     */
    @ExcelProperty({"库表英文名"})
    private String tableEngName;

    /**
     * 字段中文名
     */
    @ExcelProperty({"字段中文名"})
    private String colChName;

    /**
     * 字段英文名
     */
    @ExcelProperty({"字段英文名"})
    private String colEngName;

    /**
     * 备注
     */
    @ExcelProperty({"备注"})
    private String comment;

    /**
     * 数据字典编号
     */
    @ExcelProperty({"数据字典编号"})
    private String dicNumber;

    /**
     * 数据类型
     */
    @ExcelProperty({"数据类型"})
    private String dataType;

    /**
     * 是否为主键
     */
    @ExcelProperty({"是否为主键"})
    private String isPrimaryKey;
}
