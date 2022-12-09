package com.torokdan.travellog.repository;

import com.torokdan.travellog.modell.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

  boolean existsByName(String name);
}
