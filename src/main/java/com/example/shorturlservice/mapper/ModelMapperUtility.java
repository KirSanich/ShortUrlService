package com.example.shorturlservice.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtility {

    @Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }
}
