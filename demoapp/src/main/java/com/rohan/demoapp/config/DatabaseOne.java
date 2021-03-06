package com.rohan.demoapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.rohan")
//@PropertySource("file:./database.properties")
@PropertySource("file:./src/main/resources/database.properties")
@EnableJpaRepositories(
        basePackages = "com.rohan",
        entityManagerFactoryRef = "schemaOneEntityManager",
        transactionManagerRef = "schemaOneTransactionManager")
public class DatabaseOne {
	
	@Value("${schema1.db.driver}")
    private String driver;
    @Value("${schema1.db.url}")
    private String url;
    @Value("${schema1.db.username}")
    private String username;
    @Value("${schema1.db.password}")
    private String password;
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${hibernate.show_sql}")
    private boolean showSQL;
    @Value("${hibernate.format_sql}")
    private boolean formatSQL;
    @Value("${entitymanager.packages.to.scan}")
    private String packageScan;
    @Value("${connection.release_mode}")
    private String releaseMode;
    
    @Bean(name = "schemaOneDataSource")
    public DataSource schemaOneDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "schemaOneEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean schemaOneEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(schemaOneDataSource());
        em.setPackagesToScan(new String[] { packageScan });
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());

        return em;
    }

    @Bean(name = "schemaOneTransactionManager")
    public PlatformTransactionManager schemaOneTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(schemaOneEntityManager().getObject());
        return transactionManager;
    }

    @Bean(name = "schemaOneSessionFactory")
    public LocalSessionFactoryBean schemaOneSessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(schemaOneDataSource());
        sessionFactoryBean.setPackagesToScan(packageScan);
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        properties.put("hibernate.show_sql",showSQL);
        properties.put("hibernate.format_sql",formatSQL);
        properties.put("entitymanager.packages.to.scan",packageScan);
        properties.put("connection.release_mode",releaseMode);
        return properties;
    }

}
