package com.torokdan.travellog.exception;

public class RoleNameAlreadyExistsException extends RuntimeException {

  public RoleNameAlreadyExistsException(String name) {
    super(String.format("Role name already exists: {}", name));
  }
}
