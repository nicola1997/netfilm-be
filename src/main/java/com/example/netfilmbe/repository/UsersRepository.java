package com.example.netfilmbe.repository;

import com.example.netfilmbe.dto.UserDTO;
import com.example.netfilmbe.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT COUNT(u) > 0 FROM Users u WHERE u.username = ?1 AND u.email = ?2 AND u.password = ?3")
    public boolean isUser(String username, String email, String password);
}
