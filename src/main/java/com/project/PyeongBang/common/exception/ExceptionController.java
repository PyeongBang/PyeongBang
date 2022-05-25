package com.project.PyeongBang.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.sasl.AuthenticationException;
import java.nio.file.AccessDeniedException;

// 모든 컨트롤러에서 발생하는 에러를 잡음
@RestControllerAdvice
@Slf4j
public class ExceptionController {

    // 400
    // 특정 에러마다 return 값을 지정
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> BadRequestException(final RuntimeException ex){
        log.warn("error", ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // 401
    @ExceptionHandler({
            AccessDeniedException.class,
            AuthenticationException.class
    })
    public ResponseEntity handleAccessDeniedException(final AccessDeniedException ex1, final AuthenticationException ex2){
        if("".equals(ex1.getMessage())){
            log.warn("error", ex2);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex2.getMessage());
        }else{
            log.warn("error", ex1);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex1.getMessage());
        }
    }


    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(final Exception ex){
        log.info(ex.getClass().getName());
        log.error("error", ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
