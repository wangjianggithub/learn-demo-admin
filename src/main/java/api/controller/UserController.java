package api.controller;

import api.entity.UserEntity;
import api.service.SendService;
import api.service.UserService;
import api.util.R;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/userControl")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private SendService sendService;

    @GetMapping("/findAll")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findById")
    public R<UserEntity> findById(@RequestParam("userId") String userId) {
        for (int i = 0; i < 5; i++) {
            sendService.sendSimpleQueue(i + 1 + "我是简单队列simpleQueue");
        }
        return R.ok(userService.findById(userId));
    }

    @GetMapping("/findByUsername")
//    @Cacheable(value = "xx", key = "'username'")
    public R<UserEntity> findByUsername(@RequestParam("username") String username) {
        return R.ok(userService.findByUsername(username));
    }

    @PostMapping("/save")
    public R<Integer> save(@RequestBody UserEntity userEntity) {
        return R.ok(userService.save(userEntity));
    }

    @PostMapping("/update")
    public R<Integer> update(@RequestBody UserEntity userEntity) {
        return R.ok(userService.update(userEntity));
    }

    @PostMapping("/delete")
    public R<Integer> delete(@RequestBody UserEntity userEntity) {
        return R.ok(userService.delete(userEntity));
    }

}
