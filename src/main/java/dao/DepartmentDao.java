package dao;
import models.Department;
import models.Employee;

import java.util.List;

public interface DepartmentDao {
    //create
    void add(Department department);

    //read
    List<Department> getAll();

    //update
    //tobedone later

    //delete
    void deleteById(int id);
    void clearAll();

    List<Employee> getAllEmployeesInADept(int deptId);
}
