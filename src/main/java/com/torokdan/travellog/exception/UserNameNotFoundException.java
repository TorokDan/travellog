package com.torokdan.travellog.exception;

public class UserNameNotFoundException extends RuntimeException {

  public UserNameNotFoundException(String username) {
    super(String.format("Username not found in the database: {}", username));
  }
}
