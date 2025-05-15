package org.example.app.repository;

import org.example.app.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {
    void create(Role role);

    void update(Role role);

    Optional<Role> findById(long id);

    List<Role> findAll();

    boolean delete(Role role);
}
