package com.torokdan.travellog.controller;

import com.torokdan.travellog.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @GetMapping("/list")
  public ResponseEntity listRoles() {
    return ResponseEntity.ok(roleService.findAllRoles());
  }

}
