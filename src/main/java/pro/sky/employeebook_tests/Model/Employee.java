package pro.sky.employeebook_tests.Model;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;

public class Employee {
    private final String employeeFirstName;
    private final String employeeLastName;
    private int departmentId;
    private int salary;

    public Employee(String employeeFirstNAme, String employeeLastNAme, int department, int salary) {
        this.employeeFirstName = trim(capitalize(employeeFirstNAme.toLowerCase()));
        this.employeeLastName = trim(capitalize(employeeLastNAme.toLowerCase()));
        if (department <= 0 || department >= 6) {
            throw new IllegalArgumentException("Введен неверный отдел");
        } else {
            this.departmentId = department;
        }
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentId == employee.departmentId && salary == employee.salary && Objects.equals(employeeFirstName, employee.employeeFirstName) && Objects.equals(employeeLastName, employee.employeeLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeFirstName, employeeLastName, departmentId, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", departmentId=" + departmentId +
                ", salary=" + salary +
                '}';
    }
}
