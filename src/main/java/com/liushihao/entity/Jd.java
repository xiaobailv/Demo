package com.liushihao.entity;

import java.io.Serializable;
import java.util.Date;

public class Jd implements Serializable {

    private String id;
    private String name;
    private String sex;
    private String mobile;
    private String email;
    private String address;
    private Date birthday;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Jd{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Jd(String id, String name, String sex, String mobile, String email, String address, Date birthday) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
    }

    public Jd() {
    }
}
