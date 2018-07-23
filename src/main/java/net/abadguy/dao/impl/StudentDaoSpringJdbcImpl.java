package net.abadguy.dao.impl;

import net.abadguy.dao.StudentDao;
import net.abadguy.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoSpringJdbcImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> queryList() {
        final List<Student> students=new ArrayList<Student>();
        String sql="select * from student";

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                Student student=new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                students.add(student);
            }
        });

        return students;
    }

    @Override
    public void saveStudent(Student student) {
        String sql="insert into student(name,age) values (?,?)";
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAge()});
    }
}
