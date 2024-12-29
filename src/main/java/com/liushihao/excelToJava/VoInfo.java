package com.liushihao.excelToJava;

public class VoInfo {

    /**
     * 字段描述
     */
    private String comment;

    /**
     * 字段名称
     */
    private String javaName;

    /**
     * 字段类型
     */
    private String javaType;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public VoInfo() {
    }

    public VoInfo(String comment, String javaName, String javaType) {
        this.comment = comment;
        this.javaName = javaName;
        this.javaType = javaType;
    }
}
