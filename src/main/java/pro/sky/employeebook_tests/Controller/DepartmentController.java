package pro.sky.employeebook_tests.Controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.employeebook_tests.Service.DepartmentService;
import pro.sky.employeebook_tests.Model.Employee;

import java.util.List;

@RestController
@RequestMapping("/departments/")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{id}/employees")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable Integer id) {
        return departmentService.getEmployeeByDepartment(id);
    }

    @GetMapping("{id}/salary/sum")
    public Integer getTotalSalaryByDept(@PathVariable Integer id) {
        return departmentService.getTotalSalaryByDept(id);
    }

    @GetMapping("{id}/salary/max")
    public Employee getMaxSalaryByDept(@PathVariable Integer id) {
        return departmentService.getMaxSalaryByDept(id);
    }

    @GetMapping("{id}/salary/min")
    public Employee getMinSalaryByDept(@PathVariable Integer id) {
        return departmentService.getMinSalaryByDept(id);
    }
}
