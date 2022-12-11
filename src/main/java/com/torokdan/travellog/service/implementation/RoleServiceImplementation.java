package com.torokdan.travellog.service.implementation;

import com.torokdan.travellog.exception.RoleNameAlreadyExistsException;
import com.torokdan.travellog.modell.Role;
import com.torokdan.travellog.repository.RoleRepository;
import com.torokdan.travellog.service.RoleService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplementation implements RoleService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final RoleRepository roleRepository;

  public RoleServiceImplementation(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public Role save(String name) {
    if (roleRepository.existsByName(name)) {
      throw new RoleNameAlreadyExistsException(name);
    }
    Role role = new Role(name);
    roleRepository.save(role);
    logger.info("Role saved: [{}]", role);
    return role;
  }

  @Override
  public List<Role> findAllRoles() {
    List<Role> roles = new ArrayList<>();
    roleRepository.findAll().forEach(roles::add);
    return roles;
  }
}
