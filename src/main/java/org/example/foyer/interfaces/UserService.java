package org.example.foyer.interfaces;

import org.example.foyer.DTO.UserDTO;
import org.example.foyer.entities.User;

public interface UserService {


    UserDTO findById(Long id);
}
