package com.torokdan.travellog.exception;

public class UserAlreadyHaveThisRoleException extends RuntimeException {

  public UserAlreadyHaveThisRoleException(String userName, String roleName) {
    super(String.format("User name [{}] already have the role: {}", userName, roleName));
  }
}
