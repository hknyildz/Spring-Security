package com.hknyildz.Spring.Security.controller;

import com.hknyildz.Spring.Security.entity.ContentEntity;
import com.hknyildz.Spring.Security.model.dto.ContentDto;
import com.hknyildz.Spring.Security.service.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
@RestController
@RequestMapping(value = "/api/content", produces = "application/json")
public class ContentController {
    @Autowired
    private IContentService contentService;

    @RequestMapping(value = "createOrUpdate", method = RequestMethod.POST)
    public ContentEntity create(@RequestBody ContentDto contentDto) throws NoSuchAlgorithmException { return contentService.createOrUpdate(contentDto);
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<ContentEntity> getAllList(){
        return contentService.getAllList();
    }

    @RequestMapping(value = "{foodId}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Long foodId){
        return contentService.removeById(foodId);
    }
}
