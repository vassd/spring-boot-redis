package com.example.redisspringboot.entity;

import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * The User entity.
 */
@Data
@RedisHash("User")
public class UserEntity {
  /**
   * ID of the User.
   */
  @Id
  private UUID id = UUID.randomUUID();

  /**
   * Firstname of the User.
   */
  private String firstname;

  /**
   * Lastname of the User.
   */
  private String lastname;

  /**
   * Email of the User.
   */
  private String email;

  /**
   * Age of the User.
   */
  private Integer age;
}
