package api.service;

import api.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAll();

    UserEntity findById(String userId);

    Integer save(UserEntity userEntity);

    Integer update(UserEntity userEntity);

    Integer delete(UserEntity userEntity);

    UserEntity findByUsername(String username);
}
