package com.example.multi.db.configurations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Profile("local")
@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.multi.db.user", // for repository classes
        entityManagerFactoryRef = "derbyEntityManager",
        transactionManagerRef = "derbyTransactionManager"
)
public class DerbyConfiguration {

    @Value("${data-source.derby.scripts}")
    private String[] scripts;

    @Value("${data-source.derby.hbm2ddl-auto}")
    private String hbm2ddlAuto;

    @Value("${data-source.derby.dialect}")
    private String dialect;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean derbyEntityManager(@Qualifier("derbyDataSource") DataSource derbyDataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        properties.put("hibernate.dialect", dialect);

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(derbyDataSource);
        entityManager.setPackagesToScan("com.example.multi.db.user"); // for entity classes
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManager.setJpaPropertyMap(properties);
        return entityManager;
    }

    @Bean
    @Primary
    public DataSource derbyDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.addScripts(scripts);
        return builder.setType(EmbeddedDatabaseType.DERBY).build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager derbyTransactionManager(@Qualifier("derbyEntityManager") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
