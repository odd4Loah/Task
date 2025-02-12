package test;

import dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Student;
import service.StudentService;
import service.StudentServiceImpl;
import sun.text.resources.FormatData;
import sun.util.calendar.LocalGregorianCalendar;

import javax.xml.crypto.Data;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class StudentServiceImplTest {

//
//    @Autowired
//    StudentService studentService;
//
//    @Test
//    public void insertStudent() {
//        int i = 1;
//        while (i < 10) {
//            long time = System.currentTimeMillis();
//            Student student = new Student();
//            student.setStuName("Rose" + i);
//            student.setCourse("java");
//            student.setCreateTime(time);
//            student.setUpdateTime(time);
//
//            studentDao.insertStudent(student);
//            System.out.println(student);
//            i++;
//        }
//
//    }
//
//    @Test
//    public void deleteById() {
//        studentDao.deleteById(3);
//    }
//
//    @Test
//    public void deleteAll() {
//        studentService.deleteAll();
//    }
//
//    @Test
//    public void updateStudent() {
//
//        Student student = studentDao.findById(1);
//        student.setStuName("ddd");
//        studentDao.updateStudent(student);
//        System.out.println(student);
//    }
//
//    @Test
//    public void findById() {
//        Student student = studentService.findById(1);
//        System.out.println(student);
//    }
//
//    @Test
//    public void findLikeName() {
//        List<Student> list=studentDao.findLikeName("R");
//        System.out.println(list);
//
//
//    }
//
//    @Test
//    public void findAll() {
//        List<Student> students = studentService.findAll();
//        SimpleDateFormat aformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        System.out.println(students);
//    }
//
//    @Test
//    public void getList() {
//        List<Student> list = studentDao.queryAll(0, 1000);
//        System.out.println(list);
//
//    }


    @Test
    public void time() {
        long time = System.currentTimeMillis();
        System.out.println("time=" + time);

//        Date date = new Date(time);
        Date date= new Date();
        System.out.println("data=" + date);
        SimpleDateFormat aformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String today=aformat.format(date);
        System.out.println("aformat="+today);


    }
    @Test
    public void t(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = applicationContext.getBean(StudentDao.class);
    }


}