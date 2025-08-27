package org.example.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.app.enums.Role;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @Column(name = "email", columnDefinition = "citext")
    private String email;

    @Column(name = "password_hash")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
