package com.torokdan.travellog.service.implementation;

import com.torokdan.travellog.exception.EmailAlreadyExistsException;
import com.torokdan.travellog.exception.UserNameAlreadyExistsException;
import com.torokdan.travellog.modell.AppUser;
import com.torokdan.travellog.modell.dto.AppUserRequestDto;
import com.torokdan.travellog.repository.AppUserRepository;
import com.torokdan.travellog.service.AppUserService;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImplementation implements AppUserService {

  private final AppUserRepository appUserRepository;

  public AppUserServiceImplementation(AppUserRepository appUserRepository) {
    this.appUserRepository = appUserRepository;
  }

  @Override
  public void createUser(AppUserRequestDto requestDto) {
    AppUser user = AppUser.from(requestDto);
    if (appUserRepository.existsByName(user.getName())) {
      throw new UserNameAlreadyExistsException(user.getName());
    }
    if (appUserRepository.existsByEmail(user.getEmail())) {
      throw new EmailAlreadyExistsException(user.getEmail());
    }
    appUserRepository.save(user);
  }
}
