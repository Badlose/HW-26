package pro.sky.employeebook_tests.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmployeeAlreadyAddedException extends RuntimeException {

    public EmployeeAlreadyAddedException() {
        System.out.println("Такой сотрудник уже был добавлен");
    }

}
