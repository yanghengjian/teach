package com.tt.teach.controller;

import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.SubjectService;
import com.tt.teach.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sub")
public class SubjectController {

    @Resource
    private SubjectService subjectService;

    @RequestMapping("/subject")
    public String subject(Model model){
        List<Grade> list=subjectService.getGrade();
        model.addAttribute("gradeList",list);
        return "/subject/subject";
    }

    //getSubjectList
    @RequestMapping("/getSubjectList")
    @ResponseBody
    public Object getSubjectList(){
        List<Subject> list=subjectService.getSubjectList();
        return list;
    }

    //deleteSub
    @RequestMapping("/deleteSub/{subjectNo}")
    @ResponseBody
    public Object deleteSub(@PathVariable Integer subjectNo){
        int result=subjectService.deleteSub(subjectNo);
        if(result>0){
            return JsonResult.ok("删除成功！",result);
        }
        return JsonResult.no("删除失败！",result);
    }

    //updateSub
    @RequestMapping(value = "/updateSub",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateSub(@RequestParam Integer subjectNo,@RequestParam Integer classHour){
        int result=subjectService.updateSub(subjectNo,classHour);
        if(result>0){
            return JsonResult.ok("保存成功！",result);
        }
        return JsonResult.no("保存失败！",result);
    }

    //addSub
    @RequestMapping(value = "/addSub",method = RequestMethod.PUT)
    @ResponseBody
    public Object addSub(@RequestParam("subjectName") String subjectName,@RequestParam("classHour") Integer classHour,@RequestParam("gradeID") Integer gradeID){
        Subject subject=new Subject();
        subject.setClassHour(classHour);
        subject.setGradeID(gradeID);
        subject.setSubjectName(subjectName);
        int result=subjectService.addSub(subject);
        if(result>0){
            return JsonResult.ok("添加成功！",result);
        }
        return JsonResult.no("添加失败！",result);
    }
}
