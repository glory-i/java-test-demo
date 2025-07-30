

package qucoon.mod.SpringServerless.config;

import com.google.gson.Gson;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import qucoon.mod.SpringServerless.utility.model.response.BaseResponse;

import java.util.stream.Collectors;


@ControllerAdvice
@RestController
public class GlobalExceptionConfig {

    private static final Gson GSON = new Gson();

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<>(
                new BaseResponse("22", ex.getMessage()),
                HttpStatus.OK
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleGlobalRuntimeException(RuntimeException ex, WebRequest request) {
        ex.printStackTrace();
        return new ResponseEntity<>(
                new BaseResponse("22", ex.getMessage()),
                HttpStatus.OK
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        ex.printStackTrace();
        String errorMessages = ex.getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(","));
        return new ResponseEntity<>(
                new BaseResponse("22", errorMessages),
                HttpStatus.OK
        );
    }
}
