package com.torokdan.travellog.modell.dto;

import com.torokdan.travellog.modell.Role;

public record RoleResponseDto(String name) {

  public static RoleResponseDto from(Role role) {
    return new RoleResponseDto(role.getName());
  }
}
