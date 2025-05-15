package org.example.app.service;

import org.example.app.entity.Role;
import org.example.app.repository.RoleRepository;

import java.util.List;

public class RoleService {
    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public void create(Role role) {
        repository.create(role);
    }

    public Role getById(long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Role> getAll() {
        return repository.findAll();
    }

    public boolean delete(Role role) {
        return repository.delete(role);
    }

    public void update(Role role) {
        repository.update(role);
    }
}
