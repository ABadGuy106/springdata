package net.abadguy.dao.impl;

import net.abadguy.dao.StudentDao;
import net.abadguy.domain.Student;
import net.abadguy.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> queryList() {
        List<Student> students=new ArrayList<Student>();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="select * from student";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                Student student=new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.relese(resultSet,preparedStatement,connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return students;
    }

    @Override
    public void saveStudent(Student student) {
        List<Student> students=new ArrayList<Student>();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection=JDBCUtil.getConnection();
            String sql="insert into student(name,age) values (?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtil.relese(resultSet,preparedStatement,connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
