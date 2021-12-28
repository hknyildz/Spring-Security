package com.hknyildz.Spring.Security.dao;

import com.hknyildz.Spring.Security.entity.ContentEntity;

import java.util.List;

public interface IContentDao  {

    List<ContentEntity> getAllList();

    ContentEntity createOrUpdate(ContentEntity contentEntity);

    ContentEntity getById(Long id);

    int removeById(Long id);
}
