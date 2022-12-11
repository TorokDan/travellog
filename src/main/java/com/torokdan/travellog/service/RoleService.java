package com.torokdan.travellog.service;

import com.torokdan.travellog.modell.Role;
import java.util.List;

public interface RoleService {
  Role save(String name);

  List<Role> findAllRoles();
}
