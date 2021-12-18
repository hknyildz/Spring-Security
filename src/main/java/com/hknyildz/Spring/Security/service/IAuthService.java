package com.hknyildz.Spring.Security.service;

import com.hknyildz.Spring.Security.entity.UserEntity;
import com.hknyildz.Spring.Security.model.dto.UserDto;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IAuthService {
    UserEntity create(UserDto userDto) throws NoSuchAlgorithmException;

    UserEntity update(UserDto userDto) throws Exception;

    UserEntity getById(Long id);

    List<UserEntity> getAll();

    String removeUserById(Long id);

}