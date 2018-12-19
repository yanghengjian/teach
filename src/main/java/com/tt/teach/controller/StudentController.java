package com.tt.teach.controller;

import com.tt.teach.pojo.Student;
import com.tt.teach.service.StudentService;
import com.tt.teach.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController extends BaseController{

    @Resource
    private StudentService studentService;

    @RequestMapping("/login")
    //http://localhost:8080/stu/login
    public String login() {
        return "/student/login";
    }
    @RequestMapping("/index")
    //http://localhost:8080/stu/index
    public String index() {
        String studentName=(String) getSession().getAttribute(SESSION_KEY);
        if (studentName!=null){
            return "/student/index";
        }
        return REDIRECT+"/stu/login";
    }
    //http://localhost:8080/stu/student
    @RequestMapping("/student")
    public String student() {
        return "/student/student";
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin() {
        String xuehao=getRequest().getParameter("studentNo");
        String loginPwd=getRequest().getParameter("loginPwd");
        Integer studentNo=Integer.parseInt(xuehao);
        Student student=new Student();
        student.setStudentNo(studentNo);
        student.setLoginPwd(loginPwd);
        Student student1=studentService.doLogin(student);
        if(student1!=null){
            getSession().setAttribute(SESSION_KEY,student1.getStudentName());
            return FORWARD+"/stu/index";
        }
        return REDIRECT+"/stu/login";
    }

   //注销的请求
   @RequestMapping("/logout")
    public String logout(HttpSession session) {
       session.removeAttribute(SESSION_KEY);
       return REDIRECT+"/stu/login";
   }

   //查询所有学生的方法
   @RequestMapping(value = "/getStudentList",method = RequestMethod.GET)
   @ResponseBody
   public Object getStudentList() {
       List<Student> list=studentService.getStudentList();
       return list;
   }

   @RequestMapping(value = "/deleteStudent",method = RequestMethod.GET)
    public String deleteStudent(){
        return "";
   }


}
