package arduino.server.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionMessage> handleMethodArgumentNotValidException() {
        return buildResponse(ExceptionTitles.INVALID_ARGUMENT);
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ExceptionMessage> handleMethodArgumentTypeMismatchException() {
        return buildResponse(ExceptionTitles.INVALID_ARGUMENT);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<ExceptionMessage> handleHttpMessageNotReadableException() {
        return buildResponse(ExceptionTitles.INVALID_ARGUMENT);
    }

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    public ResponseEntity<ExceptionMessage> handleNoHandlerFoundException() {
        return buildResponse(ExceptionTitles.NOT_FOUND);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ExceptionMessage> handleRuntimeException() {
        return buildResponse(ExceptionTitles.INTERNAL_ERROR);
    }


    private ResponseEntity<ExceptionMessage> buildResponse(ExceptionTitles exception) {
        return new ResponseEntity<>(
                getMessage(exception),
                getStatus(exception)
        );
    }

    private ExceptionMessage getMessage(ExceptionTitles exception) {
        return switch (exception){
            case INTERNAL_ERROR -> new ExceptionMessage("Ошибка сервера.");
            case INVALID_ARGUMENT -> new ExceptionMessage("Некорректное поле запроса.");
            case NOT_FOUND -> new ExceptionMessage("Не найдено.");
        };
    }

    private HttpStatus getStatus(ExceptionTitles exception) {
        return switch (exception){
            case INTERNAL_ERROR -> HttpStatus.INTERNAL_SERVER_ERROR;
            case NOT_FOUND -> HttpStatus.NOT_FOUND;
            default -> HttpStatus.BAD_REQUEST;
        };
    }

}
