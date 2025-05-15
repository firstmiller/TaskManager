package org.example.app.service;

import jakarta.ws.rs.NotFoundException;
import org.example.app.entity.User;
import org.example.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository repository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        repository = mock(UserRepository.class);
        userService = new UserService(repository);
    }

    @Test
    void testCreateHashesPasswordAndSavesUser() {
        User user = new User();
        user.setPassword("myPassword");

        userService.create(user);

        assertNotNull(user.getPassword());
        assertNotEquals("myPassword", user.getPassword());
        assertTrue(new BCryptPasswordEncoder().matches("myPassword", user.getPassword()));

        verify(repository).create(user);
    }

    @Test
    void testVerifyPassword() {
        String raw = "secret";
        String hash = new BCryptPasswordEncoder().encode(raw);

        assertTrue(userService.verifyPassword(raw, hash));
        assertFalse(userService.verifyPassword("wrong", hash));
    }

    @Test
    void testGetByIdFound() {
        User user = new User();
        user.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getById(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    void testGetByIdNotFound() {
        when(repository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> userService.getById(999L));
    }

    @Test
    void testGetAllReturnsList() {
        List<User> users = Arrays.asList(new User(), new User());
        when(repository.findAll()).thenReturn(users);

        List<User> result = userService.getAll();
        assertEquals(2, result.size());
        verify(repository).findAll();
    }

    @Test
    void testDeleteByIdReturnsTrue() {
        when(repository.deleteById(5L)).thenReturn(true);

        assertTrue(userService.deleteById(5L));
        verify(repository).deleteById(5L);
    }

    @Test
    void testUpdateWithPassword() {
        User user = new User();
        user.setPassword("newpass");

        userService.update(user);

        assertNotNull(user.getPassword());
        assertNotEquals("newpass", user.getPassword());
        verify(repository).update(user);
    }

    @Test
    void testUpdateWithoutPassword() {
        User user = new User();
        user.setPassword("");

        userService.update(user);

        assertEquals("", user.getPassword());
        verify(repository).update(user);
    }
}