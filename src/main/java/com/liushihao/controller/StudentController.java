package com.liushihao.controller;

import com.liushihao.entity.Student;
import com.liushihao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 11092
 * @date 2024-12-29 13:50
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @GetMapping("/getStudentList")
    public List<Student> getStudentList() {
        return studentService.findAll();
    }
}
