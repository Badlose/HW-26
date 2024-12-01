package pro.sky.employeebook_tests.Controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.employeebook_tests.Model.Employee;
import pro.sky.employeebook_tests.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Iterable<Employee> printEmployeeList() {
        return employeeService.printEmployees();
    }


    @GetMapping(path = "/add")
    public Employee add(@RequestParam(value = "firstName", required = false) String firstName,
                        @RequestParam(value = "lastName", required = false) String lastName,
                        @RequestParam(value = "department", required = false) int department,
                        @RequestParam(value = "salary", required = false) int salary) {

        return employeeService.add(firstName, lastName, department, salary);
    }


    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam(value = "firstName", required = false) String firstName,
                           @RequestParam(value = "lastName", required = false) String lastName) {

        return employeeService.remove(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam(value = "firstName", required = false) String firstName,
                         @RequestParam(value = "lastName", required = false) String lastName) {

        return employeeService.find(firstName, lastName);
    }
}
