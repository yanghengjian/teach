package com.tt.teach.service;

import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubjectList();

    int deleteSub(Integer subjectNo);

    int updateSub(Integer subjectNo, Integer classHour);

    int addSub(Subject subject);

    List<Grade> getGrade();
}
