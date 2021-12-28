package com.hknyildz.Spring.Security.controller;

import com.hknyildz.Spring.Security.entity.UserEntity;
import com.hknyildz.Spring.Security.model.dto.UserDto;
import com.hknyildz.Spring.Security.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping(value = "api/auth", produces = "application/json")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<UserEntity> list() {
        return authService.getAll();
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public UserEntity register(@RequestBody UserDto userDto) throws NoSuchAlgorithmException {
        return authService.create(userDto);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public UserEntity update(@RequestBody UserDto userDto) throws Exception {
        return authService.update(userDto);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable long id) {
        return authService.removeUserById(id);
    }



}
