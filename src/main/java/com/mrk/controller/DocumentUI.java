package com.mrk.controller;

import com.mrk.domain.Swagger;
import com.mrk.repo.SwaggerDocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Project: Mr.k
 *
 * @Comments
 * @Created Date 2017/8/21
 */

@RestController
@RequestMapping(path = "/api")
public class DocumentUI {

    @Autowired
    private SwaggerDocRepo swaggerDocRepo;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Swagger> getSwaggers(){
        List<Swagger> swaggers = (List<Swagger>) swaggerDocRepo.findAll();
        return swaggers;
    }

    @RequestMapping(path = "/basePath", method = RequestMethod.GET)
    public Swagger getByBasePath(String host){
        // 根据basePath 获取swagger数据
        Swagger swagger = swaggerDocRepo.findByHost(host);
        return swagger;
    }

}
