package com.example.demo.infraestrutura;

import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomControllerAdvice {


  public List<ErrorResponse> handle(ConstraintViolationException constraintViolationException) {
    return null;
  }

  
  static class ErrorResponse {



  }

}
