package com.tt.teach.controller;

import com.tt.teach.pojo.Result;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.ResultService;
import com.tt.teach.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/res")
public class ResultController {

     @Resource
     private ResultService resultService;

     @RequestMapping("/result")
     public String result(Model model){
         List<Subject> list =resultService.getSubject();
         model.addAttribute("subjectList",list);
         return "/result/result";
     }

     //getResultList
     //查询所有学生的方法
     @RequestMapping(value = "/getResultList",method = RequestMethod.GET)
     @ResponseBody
     public Object getResultList() {
         List<Result> list=resultService.getResultList();
         return list;
     }

     //删除信息的方法deleteResult

     @RequestMapping(value = "/deleteResult/{resultNo}",method = RequestMethod.DELETE)
     @ResponseBody
     public Object deleteResult(@PathVariable Integer resultNo) {
         int result=resultService.deleteResult(resultNo);
         if(result>0){
             return JsonResult.ok("删除成功",result);
         }
         return JsonResult.no("删除失败",result);
     }
    //updateResult

    @RequestMapping(value = "/updateResult",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateResult(@RequestParam Integer resultNo, @RequestParam Integer studentResult) {
        Result result = new Result();
        result.setResultNo(resultNo);
        result.setStudentResult(studentResult);
        int result2 = resultService.updateResult(result);
        if (result2>0){
            return JsonResult.ok("修改成功！",result2);
        }
        return JsonResult.no("修改失败!",result2);
    }

    //addResult
    @RequestMapping(value = "/addResult",method = RequestMethod.PUT)
    @ResponseBody
    public Object addResult (@RequestParam Integer studentNo,@RequestParam Integer subjectNo,@RequestParam String examDate,@RequestParam Integer studentResult) throws ParseException {
        Result result = new Result();
        result.setStudentNo(studentNo);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        result.setExamDate(simpleDateFormat.parse(examDate));
        result.setSubjectNo(subjectNo);
        result.setStudentResult(studentResult);
        int result2=resultService.addResult(result);
        if(result2>0){
            return JsonResult.ok("添加成功！",result);
        }
        return JsonResult.no("添加失败！",result);
    }

    @RequestMapping("/getSubject")
    @ResponseBody
    public Object getSubject(){
         List<Subject> list =resultService.getSubject();
         return list;
    }
}
