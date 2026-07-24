package farcic.dev.pdv.java.config;

import farcic.dev.pdv.java.dto.exceptionDto.ResponseError;
import farcic.dev.pdv.java.exeption.CashRegisterAlreadyOpenException;
import farcic.dev.pdv.java.exeption.EmailAreadyExistException;
import farcic.dev.pdv.java.exeption.CodigoBarrasJaExisteException;
import farcic.dev.pdv.java.exeption.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExeceptionHandler {

    @ExceptionHandler(CashRegisterAlreadyOpenException.class)
    public ResponseEntity<ResponseError> handleCashRegisterAlreadyOpenException(Exception ex) {
        ResponseError error = ResponseError.builder()
                .message(ex.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .timeStamp(LocalDateTime.now())
                .build();
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }

    @ExceptionHandler(EmailAreadyExistException.class)
    public ResponseEntity<ResponseError> handleEmailAreadyExistException(Exception ex) {
        ResponseError error = ResponseError.builder()
                .message(ex.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .timeStamp(LocalDateTime.now())
                .build();
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }

    @ExceptionHandler(CodigoBarrasJaExisteException.class)
    public ResponseEntity<ResponseError> handleCodigoBarrasJaExiste(CodigoBarrasJaExisteException ex) {
        ResponseError error = ResponseError.builder()
                .message(ex.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .timeStamp(LocalDateTime.now())
                .build();
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseError> handleProductNotFoundException(ProductNotFoundException ex) {
        ResponseError error = ResponseError.builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }
}
