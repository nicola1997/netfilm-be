package com.example.netfilmbe.service;

import com.example.netfilmbe.dto.UserDTO;
import com.example.netfilmbe.entity.Users;
import com.example.netfilmbe.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UsersRepository usersRepository;

    public UserService(UsersRepository userRepository) {
        this.usersRepository = userRepository;
    }

    public void saveUser(UserDTO user) {
        Users userEntity = new Users();
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        usersRepository.save(userEntity);
    }
}
