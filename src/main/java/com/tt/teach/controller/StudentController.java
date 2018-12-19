package com.tt.teach.controller;

import com.tt.teach.service.StudentService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;
}
