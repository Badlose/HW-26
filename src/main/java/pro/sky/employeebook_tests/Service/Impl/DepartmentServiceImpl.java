package pro.sky.employeebook_tests.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.employeebook_tests.Service.DepartmentService;
import pro.sky.employeebook_tests.Model.Employee;
import pro.sky.employeebook_tests.Service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public int getSalarySum() {
        return employeeService.getAll().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public long getTotalEmployees() {
        return employeeService.getAll().stream()
                .count();
    }

    @Override
    public Employee getMaxSalary() {
        return employeeService.getAll().stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getMinSalary() {
        return employeeService.getAll().stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> getEmployeeByDept(int deptId) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentId() == deptId)
                .toList();
    }

    @Override
    public Employee getMinSalaryEmployeeByDept(int deptId) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentId() == deptId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getMaxSalaryEmployeeByDept(int deptId) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentId() == deptId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDeptId() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getSalary));
    }

    @Override
    public List<Employee> getEmployeeByDepartment(Integer deptId) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentId() == deptId)
                .toList();
    }

    @Override
    public Integer getTotalSalaryByDept(Integer id) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentId() == id)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public Employee getMaxSalaryByDept(Integer id) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentId() == id)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee getMinSalaryByDept(Integer id) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartmentId() == id)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }


}