package com.hknyildz.Spring.Security.repository;

import com.hknyildz.Spring.Security.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity,Long> {

   UserEntity findByEmail(String email);
}
