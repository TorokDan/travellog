package com.torokdan.travellog.exception.advice;

import com.torokdan.travellog.exception.EmailAlreadyExistsException;
import com.torokdan.travellog.exception.RoleNameAlreadyExistsException;
import com.torokdan.travellog.exception.UserAlreadyHaveThisRoleException;
import com.torokdan.travellog.exception.UserNameAlreadyExistsException;
import com.torokdan.travellog.modell.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {


  @ExceptionHandler(value = {EmailAlreadyExistsException.class,
      UserNameAlreadyExistsException.class,
      RoleNameAlreadyExistsException.class,
      UserAlreadyHaveThisRoleException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponseDto handleDataDuplication(RuntimeException exception) {
    return new ErrorResponseDto(exception.getMessage());
  }
}
