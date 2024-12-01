package pro.sky.employeebook_tests.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectEmployeeNameException extends RuntimeException{

    public IncorrectEmployeeNameException() {
        System.out.println("Введено некорректное имя или фамилия сотрудника");
    }
}
