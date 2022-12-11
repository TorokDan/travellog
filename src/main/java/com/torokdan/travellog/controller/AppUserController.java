package com.torokdan.travellog.controller;

import com.torokdan.travellog.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.torokdan.travellog.modell.dto.AppUserRequestDto;

@RestController
@RequestMapping("/api/v1/user")
public class AppUserController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  private final AppUserService appUserService;

  public AppUserController(AppUserService appUserService) {
    this.appUserService = appUserService;
  }

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody AppUserRequestDto user) {
    logger.info("register user");
    appUserService.createUser(user);
    return ResponseEntity.ok("ok");
  }
}