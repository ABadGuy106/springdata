package net.abadguy.dao;

import net.abadguy.domain.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> queryList();

    public void saveStudent(Student student);
}
