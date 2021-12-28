package com.hknyildz.Spring.Security.serviceimpl;

import com.hknyildz.Spring.Security.dao.IAuthDao;
import com.hknyildz.Spring.Security.dao.IContentDao;
import com.hknyildz.Spring.Security.entity.ContentEntity;
import com.hknyildz.Spring.Security.entity.UserEntity;
import com.hknyildz.Spring.Security.model.dto.ContentDto;
import com.hknyildz.Spring.Security.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements IContentService {

    @Autowired
    private IContentDao contentDao;

    @Autowired
    private IAuthDao authDao;

    @Override
    public List<ContentEntity> getAllList() {
        return contentDao.getAllList();
    }

    @Override
    public ContentEntity createOrUpdate(ContentDto contentDto)throws NoSuchAlgorithmException {
        ContentEntity entity = null;
        if (contentDto.getId() != null) {
            entity = contentDao.getById(contentDto.getId());
        } else {
            entity = new ContentEntity();
            entity.setCreateDate(new Date());
        }
        entity.setTitle(contentDto.getTitle());
        entity.setDetails(contentDto.getDetails());
        entity.setDescription(contentDto.getDescription());

        UserEntity currentUser = authDao.getByUserId(contentDto.getUserId());
        entity.setUser(currentUser);
        return contentDao.createOrUpdate(entity);
    }

    @Override
    public String removeById(Long id) {
        int result = contentDao.removeById(id);
        return result == 1 ? ("removed successfully") : ("remove failed");
    }
}
