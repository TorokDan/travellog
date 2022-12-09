package com.torokdan.travellog.exception;

public class EmailAlreadyExistsException extends RuntimeException {

  public EmailAlreadyExistsException(String email) {
    super("Email address already exists: " + email);
  }
}
