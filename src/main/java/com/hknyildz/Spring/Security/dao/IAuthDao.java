package com.hknyildz.Spring.Security.dao;

import com.hknyildz.Spring.Security.entity.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface IAuthDao {

    UserEntity register(UserEntity userEntity);

    UserEntity update (UserEntity userEntity);

    UserEntity getByUserId(Long id);

    UserEntity findByEmail(String email);

    int removeUser(UserEntity userEntity);

    int removeUserById(Long id);

    List<UserEntity> getAll();
}
