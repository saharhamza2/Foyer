package org.example.foyer.Services;

import org.example.foyer.DTO.UserDTO;
import org.example.foyer.entities.User;
import org.example.foyer.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.example.foyer.interfaces.UserService;
import org.example.foyer.mappers.UserMapper; // ✅ ajout pour MapStruct
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    UserMapper userMapper;

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));

        // return convertToUserDTO(user);
        return userMapper.toDto(user);
    }

    /*
    public UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
    */
}
