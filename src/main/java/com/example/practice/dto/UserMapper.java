package com.example.practice.dto;

import com.example.practice.model.User;

public class UserMapper {

    // turn this DTO into an entity
    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

    // turn this entity into DTO
    public static UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail());
        return dto;
    }
}
