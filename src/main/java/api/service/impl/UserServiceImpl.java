package api.service.impl;

import api.util.RedisService;
import api.entity.UserEntity;
import api.mapper.UserMapper;
import api.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource
    private RedisService redisService;

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserEntity> findAll() {
        return userMapper.findAll();
    }

    @Override
    public UserEntity findById(String userId) {
        redisService.del("xx::username", "xx-catch-username");
        return userMapper.findById(userId);
    }

    @Override
    public UserEntity findByUsername(String username) {
        UserEntity entity = (UserEntity) redisTemplate.opsForValue().get("xx-catch-" + username);
        if (entity != null) {
            return entity;
        }
        return userMapper.findByUsername(username);
    }

    @Override
    public Integer save(UserEntity userEntity) {
        userEntity.setUserId(UUID.randomUUID().toString());
        redisTemplate.opsForValue().set("xx-catch-" + userEntity.getUsername(), userEntity, 2000, TimeUnit.SECONDS);
//        redisTemplate.expire("xx-catch-" + userEntity.getUsername(), 50, TimeUnit.SECONDS);
        RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        return userMapper.save(userEntity);
    }

    @Override
    public Integer update(UserEntity userEntity) {
        return userMapper.update(userEntity);
    }

    @Override
    public Integer delete(UserEntity userEntity) {
        return userMapper.delete(userEntity);
    }

}
