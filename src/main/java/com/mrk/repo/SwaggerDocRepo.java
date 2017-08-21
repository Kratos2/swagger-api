package com.mrk.repo;

import com.mrk.domain.Swagger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Project: Mr.k
 *
 * @Comments
 * @Created Date 2017/8/21
 */
@Repository
public interface SwaggerDocRepo extends CrudRepository<Swagger, String> {

    Swagger findByBasePath(String basePath);

    Swagger findByName(String name);

    Swagger findByHost(String host);

    Swagger findById(String id);
}
