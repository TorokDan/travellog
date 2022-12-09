package com.torokdan.travellog.repository;

import com.torokdan.travellog.modell.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {

  boolean existsByName(String name);
  
  boolean existsByEmail(String email);
}
