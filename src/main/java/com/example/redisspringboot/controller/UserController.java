package com.example.redisspringboot.controller;

import com.example.redisspringboot.entity.UserEntity;
import com.example.redisspringboot.model.User;
import com.example.redisspringboot.repository.UserRepository;
import com.example.redisspringboot.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
   * constant for users endpoint.
   */
  private static final String USERS_ENDPOINT = "/users";

  /**
   * Gets all user.
   *
   * @return the all user
   */
  @GetMapping(USERS_ENDPOINT)
  public List<UserEntity> getAllUser() {
    return userRepository.findAll();
  }

  /**
   * Create user entity.
   *
   * @param user the user
   * @return the response entity
   */
  @PostMapping(USERS_ENDPOINT)
  public ResponseEntity<UserEntity> createUser(@RequestBody final User user) {
    final UserEntity userEntity = userService.createUser(user);

    return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
  }

  /**
   * Update user entity.
   *
   * @param userId the id
   * @param user the user
   * @return the response entity
   */
  @PatchMapping(USERS_ENDPOINT)
  public ResponseEntity<String> updateUser(@RequestParam final String userId, @RequestBody final User user) {
    return userService.updateUser(userId, user);
  }

  /**
   * Delete users.
   */
  @DeleteMapping(USERS_ENDPOINT)
  public void deleteUsers() {
    userRepository.deleteAll();
  }

  /**
   * Gets all user ordered by age Descending.
   *
   * @return ordered users
   */
  @GetMapping("/usersOrderByAgeDesc")
  public List<UserEntity> getSorted() {

    return userRepository.findAll(Sort.by(Sort.Direction.DESC, "age"));
  }
}
