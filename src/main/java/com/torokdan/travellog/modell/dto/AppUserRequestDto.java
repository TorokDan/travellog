package com.torokdan.travellog.modell.dto;

import com.torokdan.travellog.modell.Role;
import java.util.List;

public record AppUserRequestDto(String name, String email, String password) {

}
