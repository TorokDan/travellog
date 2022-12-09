package com.torokdan.travellog.service.implementation;

import com.torokdan.travellog.exception.EmailAlreadyExistsException;
import com.torokdan.travellog.exception.UserNameAlreadyExistsException;
import com.torokdan.travellog.modell.AppUser;
import com.torokdan.travellog.modell.Role;
import com.torokdan.travellog.modell.dto.AppUserRequestDto;
import com.torokdan.travellog.repository.AppUserRepository;
import com.torokdan.travellog.service.AppUserService;
import com.torokdan.travellog.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImplementation implements AppUserService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final AppUserRepository appUserRepository;
  private final RoleService roleService;

  public AppUserServiceImplementation(AppUserRepository appUserRepository, RoleService roleService) {
    this.appUserRepository = appUserRepository;
    this.roleService = roleService;
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
    Role role = roleService.save(user.getName());
    user.addRole(role);
    appUserRepository.save(user);
    logger.info("User saved: [{}]", user);
  }
}
