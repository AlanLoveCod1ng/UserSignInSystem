package com.signin;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@ComponentScan
@EnableTransactionManagement
@PropertySource("classpath:com/signin/jdbc.properties")
public class AppConfig {
    @Value("${jdbc.url}")
    String JDBC_URL;

    @Value("${jdbc.user}")
    String JDBC_USER;

    @Value("${jdbc.password}")
    String JDBC_PASSWORD;

    @Value("${jdbc.driver_class}")
    String JDBC_DRIVER_CLASS;

    @Bean("dataSource")
    DataSource createNewDataSource(){
        HikariConfig config = new HikariConfig();
        try{
            config.setJdbcUrl(JDBC_URL);
            config.setUsername(JDBC_USER);
            config.setPassword(JDBC_PASSWORD);
            config.setDriverClassName(JDBC_DRIVER_CLASS);
            config.addDataSourceProperty("autoCommit","true");
            config.addDataSourceProperty("useSSL",false);
        } catch (Exception e){
            System.out.println("Here");
        }
        return new HikariDataSource(config);
    }

    @Bean("sessionFactory")
    LocalSessionFactoryBean createLocalSessionFactoryBean(@Autowired DataSource dataSource){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql","true");
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setHibernateProperties(properties);
        sessionFactoryBean.setPackagesToScan("com.signin.entity");
        return sessionFactoryBean;
    }

    @Bean("hibernateTemplate")
    HibernateTemplate createHibernateTemplate(@Autowired SessionFactory sessionFactory){
        return new HibernateTemplate(sessionFactory);
    }

    @Bean("transactionManager")
    PlatformTransactionManager createTxManager(@Autowired SessionFactory sessionFactory){
        return new HibernateTransactionManager(sessionFactory);
    }
}
