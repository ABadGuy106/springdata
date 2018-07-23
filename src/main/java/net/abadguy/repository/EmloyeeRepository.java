package net.abadguy.repository;

import net.abadguy.domain.Employee;
import org.springframework.data.repository.Repository;

public interface EmloyeeRepository extends Repository<Employee,Integer> {

    public Employee findAllByName(String name);
}
