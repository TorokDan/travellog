package com.torokdan.travellog.service;

import com.torokdan.travellog.modell.dto.AppUserRequestDto;

public interface AppUserService {
  void createUser(AppUserRequestDto requestDto);
}
