package pro.sky.employeebook_tests.Service.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.employeebook_tests.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeebook_tests.Exceptions.EmployeeNotFoundException;
import pro.sky.employeebook_tests.Exceptions.EmployeeStorageIsFullException;
import pro.sky.employeebook_tests.Model.Employee;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class EmployeeServiceImplTest {

    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void clear() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void shouldAddNewEmployee() {
        //given
        Employee employeeToAdd = new Employee("Ivan", "Ivanov", 1, 1000);

        //when
        Employee addedEmployee = employeeService.add(employeeToAdd.getEmployeeFirstName(), employeeToAdd.getEmployeeLastName(), employeeToAdd.getDepartmentId(), employeeToAdd.getSalary());

        //then
        assertEquals(employeeToAdd, addedEmployee);
    }

    @Test
    public void shouldThrowEmployeeStorageIsFullException() {
        //given
        Employee employeeToAdd1 = new Employee("Ivan", "Ivanov", 1, 1000);
        Employee employeeToAdd2 = new Employee("Pert", "Ivanov", 1, 1000);
        Employee employeeToAdd3 = new Employee("Sergey", "Ivanov", 1, 1000);
        Employee employeeToAdd4 = new Employee("Dmitriy", "Ivanov", 1, 1000);
        Employee employeeToAdd5 = new Employee("John", "Ivanov", 1, 1000);
        Employee employeeToAdd6 = new Employee("Vova", "Ivanov", 1, 1000);
        Employee employeeToAdd7 = new Employee("Masha", "Ivanova", 1, 1000);
        employeeService.add(employeeToAdd1.getEmployeeFirstName(), employeeToAdd1.getEmployeeLastName(), employeeToAdd1.getDepartmentId(), employeeToAdd1.getSalary());
        employeeService.add(employeeToAdd2.getEmployeeFirstName(), employeeToAdd2.getEmployeeLastName(), employeeToAdd2.getDepartmentId(), employeeToAdd2.getSalary());
        employeeService.add(employeeToAdd3.getEmployeeFirstName(), employeeToAdd3.getEmployeeLastName(), employeeToAdd3.getDepartmentId(), employeeToAdd3.getSalary());
        employeeService.add(employeeToAdd4.getEmployeeFirstName(), employeeToAdd4.getEmployeeLastName(), employeeToAdd4.getDepartmentId(), employeeToAdd4.getSalary());
        employeeService.add(employeeToAdd5.getEmployeeFirstName(), employeeToAdd5.getEmployeeLastName(), employeeToAdd5.getDepartmentId(), employeeToAdd5.getSalary());
        employeeService.add(employeeToAdd6.getEmployeeFirstName(), employeeToAdd6.getEmployeeLastName(), employeeToAdd6.getDepartmentId(), employeeToAdd6.getSalary());
        employeeService.add(employeeToAdd7.getEmployeeFirstName(), employeeToAdd7.getEmployeeLastName(), employeeToAdd7.getDepartmentId(), employeeToAdd7.getSalary());

        Employee employeeToThrowException = new Employee("Katya", "Ivanova", 1, 1000);

        //then
        assertThrows(EmployeeStorageIsFullException.class, () -> employeeService.add(
                employeeToThrowException.getEmployeeFirstName(),
                employeeToThrowException.getEmployeeLastName(),
                employeeToThrowException.getDepartmentId(),
                employeeToThrowException.getSalary()));
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedException() {
        //given
        Employee employeeToAdd = new Employee("Ivan", "Ivanov", 1, 1000);
        Employee addedEmployee = employeeService.add(employeeToAdd.getEmployeeFirstName(), employeeToAdd.getEmployeeLastName(), employeeToAdd.getDepartmentId(), employeeToAdd.getSalary());

        //then
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add(
                employeeToAdd.getEmployeeFirstName(),
                employeeToAdd.getEmployeeLastName(),
                employeeToAdd.getDepartmentId(),
                employeeToAdd.getSalary()));
    }

    @Test
    public void shouldRemoveEmployee() {
        //given
        Employee employeeToAdd = new Employee("Ivan", "Ivanov", 1, 1000);
        employeeService.add(employeeToAdd.getEmployeeFirstName(), employeeToAdd.getEmployeeLastName(), employeeToAdd.getDepartmentId(), employeeToAdd.getSalary());

        //when
        Employee removedEmployee = employeeService.remove(employeeToAdd.getEmployeeFirstName(), employeeToAdd.getEmployeeLastName());

        //then
        assertEquals(employeeToAdd, removedEmployee);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenRemove() {
        //given
        Employee employeeToAdd = new Employee("Ivan", "Ivanov", 1, 1000);
        employeeService.add(employeeToAdd.getEmployeeFirstName(), employeeToAdd.getEmployeeLastName(),
                employeeToAdd.getDepartmentId(), employeeToAdd.getSalary());

        //then
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove("employee", "thatDidNTAdded"));
    }

    @Test
    public void shouldFindEmployee() {
        //given
        Employee employeeToAdd = new Employee("Ivan", "Ivanov", 1, 1000);
        employeeService.add(employeeToAdd.getEmployeeFirstName(), employeeToAdd.getEmployeeLastName(), employeeToAdd.getDepartmentId(), employeeToAdd.getSalary());

        //when
        Employee findedEmployee = employeeService.find(employeeToAdd.getEmployeeFirstName(), employeeToAdd.getEmployeeLastName());

        //then
        assertEquals(employeeToAdd, findedEmployee);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFind() {
        //given
        Employee employeeToAdd = new Employee("Ivan", "Ivanov", 1, 1000);
        employeeService.add(employeeToAdd.getEmployeeFirstName(), employeeToAdd.getEmployeeLastName(),
                employeeToAdd.getDepartmentId(), employeeToAdd.getSalary());

        //then
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find("employee", "thatDidNTAdded"));
    }

    @Test
    public void shouldPrintAllEmployees() {
        //given
        Employee employeeToAdd1 = new Employee("Ivan", "Ivanov", 1, 1000);
        Employee employeeToAdd2 = new Employee("Sergey", "Ivanov", 1, 1000);
        List<Employee> employeesToPrint = new ArrayList<>();
        employeesToPrint.add(employeeToAdd1);
        employeesToPrint.add(employeeToAdd2);
        employeeService.add(employeeToAdd1.getEmployeeFirstName(), employeeToAdd1.getEmployeeLastName(), employeeToAdd1.getDepartmentId(), employeeToAdd1.getSalary());
        employeeService.add(employeeToAdd2.getEmployeeFirstName(), employeeToAdd2.getEmployeeLastName(), employeeToAdd2.getDepartmentId(), employeeToAdd2.getSalary());

        //when
        List<Employee> printedEmployees = employeeService.getAll();

        //then
        assertEquals(employeesToPrint, printedEmployees);
    }
}