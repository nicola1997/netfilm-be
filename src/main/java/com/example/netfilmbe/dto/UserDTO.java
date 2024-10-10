package com.example.netfilmbe.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
   private Long id;
   private String username;
   private String email;
   private String password;
}
