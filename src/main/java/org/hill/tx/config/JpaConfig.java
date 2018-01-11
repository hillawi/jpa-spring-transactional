package org.hill.tx.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Import(DbConfig.class)
public class JpaConfig {
    public EntityManagerFactory entityManagerFactory(DataSource dataSource,
                                                     @Qualifier("hibernateProperties") Properties hibernateProperties) {
        return entityManagerFactoryBean(dataSource, hibernateProperties).getObject();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource,
                                                                           @Qualifier("hibernateProperties")
                                                                                   Properties hibernateProperties) {
        LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
        emfBean.setPackagesToScan("org.hill.tx.entity");
        emfBean.setJpaProperties(hibernateProperties);
        emfBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emfBean.setJpaDialect(new HibernateJpaDialect());
        emfBean.setPersistenceUnitName("kbsPU");
        emfBean.setDataSource(dataSource);
        return emfBean;
    }

    @Bean
    @Qualifier("jpaTransactionManager")
    public PlatformTransactionManager jpaTransactionManager(DataSource dataSource,
                                                            @Qualifier("hibernateProperties")
                                                                    Properties hibernateProperties) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory(dataSource, hibernateProperties));
        return jpaTransactionManager;
    }
}
