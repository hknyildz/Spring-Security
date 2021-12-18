package com.hknyildz.Spring.Security.daoimpl;

import com.hknyildz.Spring.Security.dao.IAuthDao;
import com.hknyildz.Spring.Security.entity.UserEntity;
import com.hknyildz.Spring.Security.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthDaoImpl implements IAuthDao {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserEntity register(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getByUserId(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public int removeUser(UserEntity userEntity) {
        userRepository.delete(userEntity);
        return 1;
    }

    @Override
    public int removeUserById(Long id) {
        userRepository.deleteById(id);
        return 1;
    }

    @Override
    public List<UserEntity> getAll() {
        List<UserEntity> list = (List<UserEntity>) userRepository.findAll();
        return list;
    }


}
