package com.example.redisspringboot.controller;

import com.example.redisspringboot.entity.UserEntity;
import com.example.redisspringboot.model.User;
import com.example.redisspringboot.repository.UserRepository;
import com.example.redisspringboot.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The User controller.
 */
@RestController
public class UserController {

  /**
   * UserService.
   */
  @Autowired
  private UserService userService;

  /**
   * UserRepository.
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * Gets all user.
   *
   * @return the all user
   */
  @GetMapping("/users")
  public List<UserEntity> getAllUser() {
    return userRepository.findAll();
  }

  /**
   * Create user entity.
   *
   * @param user the user
   * @return the response entity
   */
  @PostMapping("/users")
  public ResponseEntity<UserEntity> createUser(@RequestBody final User user) {
    final UserEntity userEntity = userService.createUser(user);

    return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
  }

  /**
   * Delete users.
   */
  @DeleteMapping("/users")
  public void deleteUsers() {
    userRepository.deleteAll();
  }
}
