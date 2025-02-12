package com.stu.controller;

import com.stu.model.Page;
import com.stu.model.Profession;
import com.stu.model.Student;
import com.stu.service.StudentService;
import com.stu.service.impl.ProfessionServiceImpl;
import com.stu.service.impl.StudentServiceImpl;
import com.stu.service.impl.UserServiceImpl;
import com.stu.util.RandomStudent;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import redis.clients.jedis.JedisPool;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Controller 核心控制器 页面跳转
 *
 * @Title: 控制器
 * @Description: 接收url 调用service操作数据库 返回数据 渲染视图
 * @author By.ZhangQiang(张强)
 * @date 2018-5-26
 */
@Controller
public class OptController {

    private static Logger logger = Logger.getLogger(OptController.class);
    private RandomStudent randomStudent = new RandomStudent();

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
//    StudentServiceImpl studentService = (StudentServiceImpl) applicationContext.getBean("studentService");
    ProfessionServiceImpl professionService = (ProfessionServiceImpl) applicationContext.getBean("professionService");
    StudentService studentService = (StudentService) new RmiService().getStudentService();

    private String message = "似乎遇到点问题...";

    /*
    * */
    @RequestMapping("/home")
    public String tiles(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        Page<Student> pages = studentService.findByPage(2,4);

        String name = (String) session.getAttribute("username");

        if(name!=null){
            model.addAttribute("sessionname",name);
        }

        model.addAttribute("onlineTotal",session.getAttribute("onlineT"));
        model.addAttribute("students",pages.getPages());

        return "home";
    }

    @RequestMapping("/u/profession")
    public String profession(Model model, HttpServletRequest request, HttpServletResponse response,HttpSession session){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        List<Profession> pros = professionService.findAll();
        model.addAttribute("onlineT",session.getAttribute("onlineT"));
        model.addAttribute("pros",pros);
        return "profession";
    }


    @RequestMapping(value = "/stringfilter")
    public String tofilter(){
        return "stringfilter";
    }

    @RequestMapping(value = "/a/stringfilter",method = POST)
    public String filter(@RequestParam("note") String str, Model model, HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String att = (String) request.getAttribute("note");
        model.addAttribute("fst",att);

        return "stringfilter";
    }

    @RequestMapping("/u/commend")
    public String tocommend(){
        logger.info("\ncommend");
        return "commend";
    }






}

