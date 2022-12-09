package com.torokdan.travellog.exception;

public class UserNameAlreadyExistsException extends RuntimeException {

  public UserNameAlreadyExistsException(String name) {
    super("Username already exists: " + name);
  }
}
