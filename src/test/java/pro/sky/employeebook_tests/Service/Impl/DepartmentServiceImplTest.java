package pro.sky.employeebook_tests.Service.Impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employeebook_tests.Model.Employee;
import pro.sky.employeebook_tests.Service.EmployeeService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private final Map<String, Employee> employees = new HashMap<>() {{
        put("Ivan1Ivanov1", new Employee("Ivan1", "Ivanov1", 1, 100));
        put("Ivan2Ivanov2", new Employee("Ivan2", "Ivanov2", 1, 200));
        put("Ivan3Ivanov3", new Employee("Ivan3", "Ivanov3", 1, 300));
    }};

    private final List<Employee> employeesList = new ArrayList<>() {{
        add(new Employee("Ivan1", "Ivanov1", 1, 100));
        add(new Employee("Ivan2", "Ivanov2", 1, 200));
        add(new Employee("Ivan3", "Ivanov3", 1, 300));
        add(new Employee("Ivan4", "Ivanov4", 2, 300));
        add(new Employee("Ivan5", "Ivanov5", 2, 300));
    }};

    @Test
    public void shouldReturnEmployeesByDepartment() {
        //given
        int departmentId = 2;
        List<Employee> expectedList = new ArrayList<>();
        expectedList.add(new Employee("Ivan4", "Ivanov4", 2, 300));
        expectedList.add(new Employee("Ivan5", "Ivanov5", 2, 300));


        Mockito.when(employeeService.getAll()).thenReturn(employeesList);

        //when
        List<Employee> actualList = departmentService.getEmployeeByDepartment(2);

        //then
        assertEquals(expectedList, actualList);
    }

    @Test
    public void shouldCalculateSalarySum() {
        //given
        int departmentId = 1;
        int expectedSum = 600;

        Mockito.when(employeeService.getAll()).thenReturn(employeesList);

        //when
        Integer actualSum = departmentService.getTotalSalaryByDept(departmentId);

        //then
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturnMaxSalaryByDepartment() {
        //given
        int departmentId = 1;
        int expectedMaxSalary = 300;
        Mockito.when(employeeService.getAll()).thenReturn(employeesList);

        //when
        Employee employeeWithMaxSalary = departmentService.getMaxSalaryByDept(departmentId);
        int actualMaxSalary = employeeWithMaxSalary.getSalary();

        //then
        assertEquals(expectedMaxSalary, actualMaxSalary);
    }

    @Test
    public void shouldReturnMinSalaryByDepartment() {
        //given
        int departmentId = 1;
        int expectedMinSalary = 100;
        Mockito.when(employeeService.getAll()).thenReturn(employeesList);

        //when
        Employee employeeWithMinSalary = departmentService.getMinSalaryByDept(departmentId);
        int actualMaxSalary = employeeWithMinSalary.getSalary();

        //then
        assertEquals(expectedMinSalary, actualMaxSalary);
    }
}
