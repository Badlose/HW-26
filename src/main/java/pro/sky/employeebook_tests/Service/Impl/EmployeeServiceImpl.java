package pro.sky.employeebook_tests.Service.Impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import pro.sky.employeebook_tests.Exceptions.IncorrectEmployeeNameException;
import pro.sky.employeebook_tests.Model.Employee;
import pro.sky.employeebook_tests.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeebook_tests.Exceptions.EmployeeNotFoundException;
import pro.sky.employeebook_tests.Exceptions.EmployeeStorageIsFullException;
import pro.sky.employeebook_tests.Service.EmployeeService;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int DEFAULT_CAPACITY = 7;
    private final Map<String, Employee> employeesMap = new HashMap<>(DEFAULT_CAPACITY);

    @PostConstruct
    public void initEmployees() {
        add("ivan", "ivanov", 1, 1001);

    }

    @Override
    public Employee add(String firstName, String lastName, int department, int salary) throws
            EmployeeStorageIsFullException,
            EmployeeAlreadyAddedException,
            IncorrectEmployeeNameException {

        if (employeesMap.size() >= DEFAULT_CAPACITY) {
            throw new EmployeeStorageIsFullException();
        }

        checkName(firstName, lastName);

        Employee employee = new Employee(
                firstName,
                lastName,
                department,
                salary);

        if (employeesMap.containsValue(employee)) {
            throw new EmployeeAlreadyAddedException();
        }

        if (isNotBlank(firstName) && isNotBlank(lastName)) {
            employeesMap.put(getKey(employee.getEmployeeFirstName(), employee.getEmployeeLastName()), employee);
        }

        return employee;
    }

    private String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }

    private void checkName(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new IncorrectEmployeeNameException();
        }
    }

    @Override
    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException {

        Employee employee = employeesMap.get(getKey(firstName, lastName));

        if (!employeesMap.containsKey(getKey(firstName, lastName))) {
            throw new EmployeeNotFoundException();
        }
        return employeesMap.remove(getKey(firstName, lastName));
    }

    @Override
    public Employee find(String firstName, String lastName) throws EmployeeNotFoundException {
        if (!employeesMap.containsKey(getKey(firstName, lastName))) {
            throw new EmployeeNotFoundException();
        }
        return employeesMap.get(getKey(firstName, lastName));
    }

    @Override
    public Collection<Employee> printEmployees() {
        return employeesMap.values();
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<Employee>(employeesMap.values().stream().toList());
    }
}

