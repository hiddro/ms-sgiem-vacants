package com.sgiem.ms.vacants.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MongoConfig implements InitializingBean {

    @Autowired
    @Lazy
    private MappingMongoConverter converter;

    @Override
    public void afterPropertiesSet() throws Exception {
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
    }
}
