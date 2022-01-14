package com.signin;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
    @ComponentScan
    @PropertySource("classpath:com/signin/jdbc.properties")
public class AppConfig {
    @Value("${jdbc.url}")
    String JDBC_URL;

    @Value("${jdbc.user}")
    String JDBC_USER;

    @Value("${jdbc.password}")
    String JDBC_PASSWORD;

    @Bean("dataSource")
    DataSource createNewDataSource(){
        HikariConfig config = new HikariConfig();
        try{
            config.setJdbcUrl(JDBC_URL);
            config.setUsername(JDBC_USER);
            config.setPassword(JDBC_PASSWORD);
            config.addDataSourceProperty("autoCommit","true");
            config.setDriverClassName("com.mysql.jdbc.Driver");
            config.addDataSourceProperty("useSSL",false);
        } catch (Exception e){
            System.out.println("Here");
        }
        return new HikariDataSource(config);
    }

    @Bean("jdbcTemplate")
    JdbcTemplate createNewJdbcTemplate(@Autowired DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
