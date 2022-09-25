package com.example.redisspringboot.service;

import com.example.redisspringboot.entity.UserEntity;
import com.example.redisspringboot.model.User;
import com.example.redisspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The User service.
 */
@Service
public class UserService {
  /**
   * UserRepository.
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * Create user entity.
   *
   * @param user the user
   * @return the user entity
   */
  public UserEntity createUser(final User user) {
    final UserEntity userEntity = new UserEntity();

    userEntity.setFirstname(user.firstname());
    userEntity.setLastname(user.lastname());
    userEntity.setEmail(user.email());
    userEntity.setAge(user.age());

    userRepository.save(userEntity);

    return userEntity;
  }
}
