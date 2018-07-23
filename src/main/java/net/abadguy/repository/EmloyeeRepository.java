package net.abadguy.repository;

import net.abadguy.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmloyeeRepository extends Repository<Employee,Integer> {

    public Employee findAllByName(String name);

    @Query("select o from Employee o where id=(select max(id) from Employee )")
    public Employee getEmployeeByMaxId();
    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    public List<Employee> queryParams1(String name,Integer age);

    @Query("select o from Employee o where o.name=:name and o.age=:age")
    public List<Employee> queryParams2(@Param("name") String name,@Param("age") Integer age);
}
