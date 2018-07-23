package net.abadguy.dao.impl;

import net.abadguy.dao.StudentDao;
import net.abadguy.domain.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoImplTest {

    private StudentDao studentDao=new StudentDaoImpl();

    @Test
    public void queryList() {
        List<Student> list=studentDao.queryList();
        Assert.assertEquals(3,list.size());
    }

    @Test
    public void saveStudent(){
        Student student=new Student();
        student.setName("赵六");
        student.setAge(28);
        studentDao.saveStudent(student);
    }
}