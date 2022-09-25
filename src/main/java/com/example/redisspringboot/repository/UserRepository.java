package com.example.redisspringboot.repository;

import com.example.redisspringboot.entity.UserEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Sort;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

/**
 * The User repository.
 */
public interface UserRepository extends KeyValueRepository<UserEntity, UUID> {

  @Override
  List<UserEntity> findAll();

  @Override
  List<UserEntity> findAll(Sort sort);
}
