package com.torokdan.travellog.modell;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AppUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private String password;
  @ManyToMany
  private List<Role> roles;

  public AppUser() {
    this.roles = new ArrayList<>();
  }

  public AppUser(String name, String email, String password) {
    this();
    this.name = name;
    this.email = email;
    this.password = password;
  }
}
