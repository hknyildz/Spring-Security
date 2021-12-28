package com.hknyildz.Spring.Security.service;

import com.hknyildz.Spring.Security.entity.ContentEntity;
import com.hknyildz.Spring.Security.model.dto.ContentDto;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IContentService {

    List<ContentEntity> getAllList();

    ContentEntity createOrUpdate(ContentDto contentDto) throws NoSuchAlgorithmException;

    String removeById(Long id);

}
