package com.torokdan.travellog.controller;

import com.torokdan.travellog.service.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.torokdan.travellog.modell.dto.AppUserRequestDto;

@RestController
@RequestMapping("/user")
public class AppUserController {

  private final AppUserService appUserService;

  public AppUserController(AppUserService appUserService) {
    this.appUserService = appUserService;
  }

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody AppUserRequestDto user) {
    appUserService.createUser(user);
    return ResponseEntity.ok("ok");
  }
}