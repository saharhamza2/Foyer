package org.example.foyer.mappers;

import org.example.foyer.entities.User;
import org.example.foyer.DTO.UserDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
}
