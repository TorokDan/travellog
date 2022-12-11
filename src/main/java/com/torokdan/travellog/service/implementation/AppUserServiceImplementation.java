package com.torokdan.travellog.service.implementation;

import com.torokdan.travellog.exception.EmailAlreadyExistsException;
import com.torokdan.travellog.exception.UserNameAlreadyExistsException;
import com.torokdan.travellog.exception.UserNameNotFoundException;
import com.torokdan.travellog.modell.AppUser;
import com.torokdan.travellog.modell.Role;
import com.torokdan.travellog.modell.dto.AppUserRequestDto;
import com.torokdan.travellog.repository.AppUserRepository;
import com.torokdan.travellog.service.AppUserService;
import com.torokdan.travellog.service.RoleService;
import java.util.ArrayList;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImplementation implements AppUserService, UserDetailsService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final AppUserRepository appUserRepository;
  private final RoleService roleService;
  private final BCryptPasswordEncoder passwordEncoder;

  public AppUserServiceImplementation(AppUserRepository appUserRepository, RoleService roleService,
      BCryptPasswordEncoder passwordEncoder) {
    this.appUserRepository = appUserRepository;
    this.roleService = roleService;
    this.passwordEncoder = passwordEncoder;
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
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    appUserRepository.save(user);
    logger.info("User saved: [{}]", user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser appuser = appUserRepository.findByName(username)
        .orElseThrow(() -> new UserNameNotFoundException(username));
    Collection<SimpleGrantedAuthority> authorityCollection = new ArrayList<>();
    appuser.getRoles().forEach((role) -> authorityCollection.add(new SimpleGrantedAuthority(role.getName())));
    return new User(appuser.getName(), appuser.getPassword(), authorityCollection);
  }
}
