package models;

import java.util.Objects;

public class Department {
    private String Deptname;
    private String description;
    private int noOfEmployees;
    private int id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return noOfEmployees == that.noOfEmployees &&
                id == that.id &&
                Objects.equals(Deptname, that.Deptname) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Deptname, description, noOfEmployees, id);
    }

    public Department(String Deptname, String description, int noOfEmployees){
        this.Deptname = Deptname;
        this.description = description;
        this.noOfEmployees = noOfEmployees;
    }
}
