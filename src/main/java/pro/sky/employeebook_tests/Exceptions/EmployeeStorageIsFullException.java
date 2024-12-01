package pro.sky.employeebook_tests.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeStorageIsFullException extends RuntimeException {

    public EmployeeStorageIsFullException() {
        System.out.println("Список сотрудников полон");
    }
}
