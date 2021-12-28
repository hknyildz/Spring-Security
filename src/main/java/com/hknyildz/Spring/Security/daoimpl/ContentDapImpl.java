package com.hknyildz.Spring.Security.daoimpl;

import com.hknyildz.Spring.Security.dao.IContentDao;
import com.hknyildz.Spring.Security.entity.ContentEntity;
import com.hknyildz.Spring.Security.repository.IContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContentDapImpl implements IContentDao {

    @Autowired
    private IContentRepository contentRepository;

    @Override
    public List<ContentEntity> getAllList() {
        List<ContentEntity> list = contentRepository.findAll();
        return list;
    }

    @Override
    public ContentEntity createOrUpdate(ContentEntity contentEntity) {
        return contentRepository.save(contentEntity);
    }

    @Override
    public ContentEntity getById(Long id) {
        return contentRepository.findById(id).get();
    }

    @Override
    public int removeById(Long id) {
        contentRepository.deleteById(id);
        return 1;
    }
}
