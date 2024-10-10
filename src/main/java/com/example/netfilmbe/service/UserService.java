package com.example.netfilmbe.service;

import com.example.netfilmbe.dto.UserDTO;
import com.example.netfilmbe.entity.Users;
import com.example.netfilmbe.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final UsersRepository usersRepository;

    public UserService(UsersRepository userRepository) {
        this.usersRepository = userRepository;
    }

    public void saveUser(UserDTO user) {
        log.info("Ricevuto utente: {}", user);

        Users userEntity = new Users();
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        usersRepository.save(userEntity);
    }
}
