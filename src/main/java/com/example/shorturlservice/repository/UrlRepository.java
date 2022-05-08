package com.example.shorturlservice.repository;

import com.example.shorturlservice.entity.Url;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends KeyValueRepository<Url,String> {
}
