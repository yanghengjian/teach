package com.tt.teach.pojo;
/**
 * @作者:YHJ
 * @时间:2018/12/19 14:31
 * @描述:科目表
 */
public class Subject {
    private Integer subjectNo;
    private String  subjectName;
    private Integer classHour;
    private Integer gradeID;
    private String gradeName;

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Integer getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(Integer subjectNo) {
        this.subjectNo = subjectNo;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getClassHour() {
        return classHour;
    }

    public void setClassHour(Integer classHour) {
        this.classHour = classHour;
    }

    public Integer getGradeID() {
        return gradeID;
    }

    public void setGradeID(Integer gradeID) {
        this.gradeID = gradeID;
    }

    public Subject(Integer subjectNo, String subjectName, Integer classHour, Integer gradeID, String gradeName) {
        this.subjectNo = subjectNo;
        this.subjectName = subjectName;
        this.classHour = classHour;
        this.gradeID = gradeID;
        this.gradeName = gradeName;
    }

    public Subject() {
    }
}
