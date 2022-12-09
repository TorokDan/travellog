package com.torokdan.travellog.modell;

import com.torokdan.travellog.modell.dto.AppUserRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "appuser")
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

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public static AppUser from(AppUserRequestDto requestDto) {
    return new AppUser(requestDto.name(), requestDto.email(), requestDto.password());
  }
}
