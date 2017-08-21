package com.mrk.controller;

import com.mrk.domain.Swagger;
import com.mrk.domain.Tag;
import com.mrk.repo.SwaggerDocRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: Mr.k
 *
 * @Comments
 * @Created Date 2017/8/21
 */
@RestController
@RequestMapping(path = "/swagger")
public class SwaggerPublish {

    @Autowired
    private SwaggerDocRepo swaggerDocRepo;

    @RequestMapping(path = "/publish", method = RequestMethod.POST, consumes = "application/json;charset=utf-8" )
    public void publish(@RequestBody Swagger swagger){
//        swagger.setHost("192.168.9.46:5666");
//        swagger.setBasePath("http://192.168.9.46:5666/swagger-ui.html");
        List<Tag> tag = swagger.getTags();
        swagger.setName(tag.get(0).getName());
        swagger.setBasePath("/v2/api-docs");
        Swagger original = swaggerDocRepo.findByBasePath(swagger.getBasePath());
        // MongoDB docs cannot contain "$" when update, so we must delete old one and save the new one.
        if(original != null && original.getId().trim()!= "" && original.getId() != null ){
            swaggerDocRepo.delete(original.getId());
        }
        swaggerDocRepo.save(swagger);
    }
}
