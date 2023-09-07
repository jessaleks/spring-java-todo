package com.aleksanderjess.springjavatodo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@SpringBootApplication
public class SpringJavaTodoApplication {


    @Configuration
    public static class DataSourceConfig {

        @Value("${SPRING_DATASOURCE_URL}")
        private String url;

        @Value("${SPRING_DATASOURCE_USERNAME}")
        private String username;

        @Value("${SPRING_DATASOURCE_PASSWORD}")
        private String password;

        @Bean
        public DataSource getDataSource() {
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.url(url);
            dataSourceBuilder.username(username);
            dataSourceBuilder.password(password);
            return dataSourceBuilder.build();
        }
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringJavaTodoApplication.class, args);
    }

}
