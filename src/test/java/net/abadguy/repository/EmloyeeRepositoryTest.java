package net.abadguy.repository;

import net.abadguy.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class EmloyeeRepositoryTest {

    private ApplicationContext ctx=null;
    private EmloyeeRepository emloyeeRepository=null;

    @Before
    public void setup(){
        ctx= new ClassPathXmlApplicationContext("beans_springdata.xml");
        emloyeeRepository=ctx.getBean(EmloyeeRepository.class);
    }

    @After
    public void tearDown(){
        ctx=null;
    }

    @Test
    public void findAllByName() {
        Employee employee=emloyeeRepository.findAllByName("张三");
        System.out.println(employee);
    }
}