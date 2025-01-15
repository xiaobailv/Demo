package com.liushihao.service.impl;

import com.liushihao.dao.StudentDao;
import com.liushihao.entity.Student;
import com.liushihao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
