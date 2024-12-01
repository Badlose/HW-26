package pro.sky.employeebook_tests.Service;

import pro.sky.employeebook_tests.Model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    int getSalarySum();

    long getTotalEmployees();

    Employee getMaxSalary();

    Employee getMinSalary();

    List<Employee> getEmployeeByDept(int deptId);

    Employee getMinSalaryEmployeeByDept(int deptId);

    Employee getMaxSalaryEmployeeByDept(int deptId);

    Map<Integer, List<Employee>> getAllEmployeesGroupedByDeptId();

    List<Employee> getEmployeeByDepartment(Integer deptId);

    Integer getTotalSalaryByDept(Integer id);

    Employee getMaxSalaryByDept(Integer id);

    Employee getMinSalaryByDept(Integer id);
}
