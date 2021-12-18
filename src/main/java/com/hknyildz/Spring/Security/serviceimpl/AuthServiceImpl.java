package com.hknyildz.Spring.Security.serviceimpl;

import com.hknyildz.Spring.Security.dao.IAuthDao;
import com.hknyildz.Spring.Security.entity.UserEntity;
import com.hknyildz.Spring.Security.functions.Encryptor;
import com.hknyildz.Spring.Security.model.dto.UserDto;
import com.hknyildz.Spring.Security.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class AuthServiceImpl implements IAuthService {

    Encryptor encryptor = new Encryptor();

    @Autowired
    private IAuthDao AuthDao;

    @Override
    public UserEntity create(UserDto userDto) throws NoSuchAlgorithmException {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());

        String password = userDto.getPassword();
        String encryptedPassword = encryptor.EncryptString(password);

        userEntity.setPassword(encryptedPassword);
        return AuthDao.register(userEntity);
    }

    @Override
    public UserEntity update(UserDto userDto) throws Exception {
        UserEntity userEntity = AuthDao.getByUserId(userDto.getId());
        if (userEntity == null) {
            throw new Exception("There is no user with id: " + userDto.getId());
        }
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());

        String password = userDto.getPassword();
        String encryptedPassword = encryptor.EncryptString(password);

        userEntity.setPassword(encryptedPassword);

        return AuthDao.update(userEntity);
    }

    @Override
    public UserEntity getById(Long id) {
        return AuthDao.getByUserId(id);
    }

    @Override
    public List<UserEntity> getAll() {
        return AuthDao.getAll();
    }

    @Override
    public String removeUserById(Long id) {
        int result = AuthDao.removeUserById(id);
        return result == 1 ? ("user by id: " + id + " deleted successfully") : ("Delete operation failed");
    }
}


