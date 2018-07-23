package net.abadguy.dao.impl;

import net.abadguy.dao.StudentDao;
import net.abadguy.domain.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoSpringJdbcImplTest {

    private ApplicationContext applicationContext=null;
    private StudentDao studentDao=null;
    @Before
    public void setup(){
        applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        studentDao= (StudentDao) applicationContext.getBean("studentDao");
    }

    @After
    public  void tearDown(){
        applicationContext=null;
    }

    @Test
    public void queryList() {
        List<Student> list=studentDao.queryList();
        Assert.assertEquals(4,list.size());
    }

    @Test
    public void saveStudent() {
        Student student=new Student();
        student.setName("闫七");
        student.setAge(28);
        studentDao.saveStudent(student);
    }
}