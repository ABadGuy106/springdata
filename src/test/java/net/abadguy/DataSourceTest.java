package net.abadguy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DataSourceTest {

    private ApplicationContext applicationContext=null;
    @Before
    public void setup(){
        applicationContext=new ClassPathXmlApplicationContext("beans.xml");
    }

    @After
    public  void tearDown(){
        applicationContext=null;
    }
    @Test
    public void testDataSource(){
        DataSource dataSource= (DataSource) applicationContext.getBean("dataSource");
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void testJdbcTemplate(){
        JdbcTemplate dbcTemplate= (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        Assert.assertNotNull(dbcTemplate);
    }

}
