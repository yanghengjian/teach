package com.tt.teach.service.impl;

import com.tt.teach.dao.SubjectDao;
import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{

    @Resource
    private SubjectDao subjectDao;

    @Override
    public List<Subject> getSubjectList() {
        return subjectDao.getSubjectList();
    }

   @Transactional
    public int deleteSub(Integer subjectNo) {
        return subjectDao.deleteSub(subjectNo);
    }

    @Transactional
    public int updateSub(Integer subjectNo, Integer classHour) {
        return subjectDao.updateSub(subjectNo,classHour);
    }

    @Transactional
    public int addSub(Subject subject) {
        return subjectDao.addSub(subject);
    }

    @Override
    public List<Grade> getGrade() {
        return subjectDao.getGrade();
    }
}
