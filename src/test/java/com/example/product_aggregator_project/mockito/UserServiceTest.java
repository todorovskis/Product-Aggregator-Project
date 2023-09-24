package com.example.product_aggregator_project.mockito;

import com.example.product_aggregator_project.model.User;
import com.example.product_aggregator_project.repository.RoleRepository;
import com.example.product_aggregator_project.repository.UserRepository;
import com.example.product_aggregator_project.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User("TestUser", "test", "TestUserName", "TestUserSurname", "test@example.com", "123-456-789");

        userService = spy(new UserServiceImpl(userRepository, roleRepository, passwordEncoder));
    }

    @DisplayName("Test for listUsers method")
    @Test
    public void findAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(user));
        List<User> users = userService.listUsers();
        assertEquals(1, users.size());
        verify(userRepository).findAll();
    }

    @DisplayName("Test for findById method")
    @Test
    public void findUserById() {
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        User returnedUser = userService.findById(user.getId());
        assertEquals(user.getId(), returnedUser.getId());
        verify(userRepository).findById(returnedUser.getId());
    }

    @DisplayName("Test for register method")
    @Test
    public void RegisterUserTest() {
        User registeredUser = userService.register(user.getUsername(), user.getPassword(), user.getPassword(),
                user.getName(), user.getSurname(), user.getEmail(), user.getPhoneNumber());
        verify(userService).register(user.getUsername(), user.getPassword(), user.getPassword(),
                user.getName(), user.getSurname(), user.getEmail(), user.getPhoneNumber());
        //verify(userRepository).save(registeredUser);

//        assertNotNull("User is null", registeredUser);
//        assertEquals("username does not match", user.getUsername(), registeredUser.getUsername());
//        assertEquals("password does not match",  user.getPassword(), registeredUser.getPassword());
//        assertEquals("name does not match", user.getName(), registeredUser.getName());
//        assertEquals("surname does not match",  user.getSurname(), registeredUser.getSurname());
//        assertEquals("email does not match", user.getEmail(), registeredUser.getEmail());
//        assertEquals("phone number does not match", user.getPhoneNumber(), registeredUser.getPhoneNumber());
    }

    @DisplayName("Test for edit method")
    @Test
    public void editUser() {
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        user.setPassword("user");
        userService.edit(user.getId(), user.getUsername(), user.getEmail());
        assertEquals("user", user.getPassword());
        verify(userRepository).save(user);
    }
}
