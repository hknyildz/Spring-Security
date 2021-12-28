package com.hknyildz.Spring.Security.serviceimpl;

import com.hknyildz.Spring.Security.Details.CustomUserDetails;
import com.hknyildz.Spring.Security.dao.IAuthDao;
import com.hknyildz.Spring.Security.entity.UserEntity;
import com.hknyildz.Spring.Security.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IAuthDao dao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        UserEntity user = dao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomUserDetails(user);
    }
}
