package com.tt.teach.dao;

import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubjectDao {

    @Select("select * from grade,subject where subject.gradeID=grade.gradeID")
    List<Subject> getSubjectList();

    @Delete("delete from subject where subjectNo=#{subjectNo}")
    int deleteSub(Integer subjectNo);

    @Update("update subject set classHour=#{classHour} where subjectNo=#{subjectNo}")
    int updateSub(@Param("subjectNo") Integer subjectNo, @Param("classHour")Integer classHour);

    @Insert("insert into subject(subjectName,classHour,gradeID) values(#{subjectName},#{classHour},#{gradeID})")
    int addSub(Subject subject);

    @Select("select * from grade")
    List<Grade> getGrade();
}
