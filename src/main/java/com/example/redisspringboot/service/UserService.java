package com.example.redisspringboot.service;

import com.example.redisspringboot.entity.UserEntity;
import com.example.redisspringboot.model.User;
import com.example.redisspringboot.repository.UserRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  /**
   * Update user response entity.
   *
   * @param userId the user id
   * @param user   the user
   * @return the response entity
   */
  public ResponseEntity<String> updateUser(final String userId, final User user) {
    final Optional<UserEntity> userEntity = userRepository.findById(UUID.fromString(userId));

    if (userEntity.isPresent()) {
      if (user.firstname() != null) {
        userEntity.get().setFirstname(user.firstname());
      }

      if (user.lastname() != null) {
        userEntity.get().setLastname(user.lastname());
      }

      if (user.email() != null) {
        userEntity.get().setEmail(user.email());
      }

      if (user.age() != null) {
        userEntity.get().setAge(user.age());
      }

      userRepository.save(userEntity.get());

      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
