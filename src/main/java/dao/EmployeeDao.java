package dao;

import models.Employee;

import java.util.List;

public interface EmployeeDao {
    //create
    void add(Employee employee);

    //read
    List<Employee> getAll();

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
