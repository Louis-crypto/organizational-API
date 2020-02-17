package models;

import java.util.Objects;

public class Employee {
    private String employeeName;
    private String position;
    private int deptId;
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return deptId == employee.deptId &&
                id == employee.id &&
                Objects.equals(employeeName, employee.employeeName) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeName, position, deptId, id);
    }

    public Employee(String employeeName, String position, int deptId){
        this.employeeName = employeeName;
        this.position = position;
        this.deptId = deptId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
