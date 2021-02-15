package com.beaconfireabc.profile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@Getter
@Setter
@Configuration
@RefreshScope
public class HibernateProperty {

    @Value("${database.hibernate.url}")
    private String url;

    @Value("${database.hibernate.driver}")
    private String driver;

    @Value("${database.hibernate.username}")
    private String username;

    @Value("${database.hibernate.password}")
    private String password;

    @Value("${database.hibernate.dialect}")
    private String dialect;

    @Value("${database.hibernate.showsql}")
    private String showsql;

}
