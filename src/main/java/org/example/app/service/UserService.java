package org.example.app.service;

import org.example.app.dto.UserDTO;
import org.example.app.enums.Role;
import org.example.app.exception.NotFoundException;
import org.example.app.entity.User;
import org.example.app.mapper.UserMapper;
import org.example.app.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository repository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;


    public UserService(UserRepository repository, UserMapper userMapper, PasswordEncoder encoder) {
        this.repository = repository;
        this.userMapper = userMapper;
        this.encoder = encoder;
    }

    @Transactional
    public UserDTO register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userMapper.toDTO(repository.save(user));
    }


    public UserDTO findById(long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));

        return userMapper.toDTO(user);
    }

    public UserDTO findByUsername(String username) {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User with username " + username + " not found"));

        return userMapper.toDTO(user);

    }

    public List<UserDTO> getAll() {
        return userMapper.toDTOList(repository.findAll());
    }

    @Transactional
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void update(User user) {
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            String hashedPassword = encoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
        }
        repository.save(user);
    }


}
