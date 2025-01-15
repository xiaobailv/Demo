package com.liushihao.dao;

import com.liushihao.entity.Student;

import java.util.List;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
public interface StudentDao {

    List<Student> findAll();
}
