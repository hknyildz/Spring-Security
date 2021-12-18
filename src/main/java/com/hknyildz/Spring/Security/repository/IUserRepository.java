package com.hknyildz.Spring.Security.repository;

import com.hknyildz.Spring.Security.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<UserEntity,Long> {

   public UserEntity findByEmail(String email);
}
