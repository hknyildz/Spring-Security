package com.hknyildz.Spring.Security.repository;

import com.hknyildz.Spring.Security.entity.ContentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContentRepository extends CrudRepository<ContentEntity,Long> {

    List<ContentEntity> findAll();

}
