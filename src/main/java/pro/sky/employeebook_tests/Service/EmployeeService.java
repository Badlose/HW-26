package pro.sky.employeebook_tests.Service;

import pro.sky.employeebook_tests.Model.Employee;
import pro.sky.employeebook_tests.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeebook_tests.Exceptions.EmployeeNotFoundException;
import pro.sky.employeebook_tests.Exceptions.EmployeeStorageIsFullException;

import java.util.List;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int department, int salary) throws
            EmployeeStorageIsFullException,
            EmployeeAlreadyAddedException;

    Employee remove(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee find(String firstName, String lastName) throws EmployeeNotFoundException;

    Iterable<Employee> printEmployees();

    List<Employee> getAll();
}
