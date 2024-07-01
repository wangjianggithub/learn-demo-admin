package api.mapper;

import org.apache.ibatis.annotations.Mapper;
import api.entity.UserEntity;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<UserEntity> findAll();

    UserEntity findById(String userId);

    Integer save(UserEntity userEntity);

    Integer update(UserEntity userEntity);

    Integer delete(UserEntity userEntity);

    UserEntity findByUsername(String username);
}
