package com.tt.teach.service.impl;

import com.tt.teach.dao.StudentDao;
import com.tt.teach.pojo.Student;
import com.tt.teach.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    private StudentDao studentDao;

    @Override
    public Student doLogin(Student student) {
        return studentDao.doLogin(student);
    }

    @Override
    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }
}
