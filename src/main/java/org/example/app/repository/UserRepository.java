package org.example.app.repository;

import org.example.app.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void create(User user);

    void update(User user);

    Optional<User> findById(long id);

    List<User> findAll();

    boolean deleteById(long id);
}