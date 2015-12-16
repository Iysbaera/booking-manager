package cz.muni.fi.pa165.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.inject.Singleton;


/**
 * Configuration for Spring application context.
 *
 * @author Ivo Hradek
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("cz.muni.fi.pa165.dao")
public class ApplicationContextPersistence {

    /**
     * Starts up a container that emulates behavior prescribed in JPA spec for container-managed EntityManager.
     *
     * @return Local Container Entity Manager Factory Bean
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("default");
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.afterPropertiesSet();

        return factoryBean;
    }

    /**
     * Creates bean validator.
     *
     * @return Local Validator Factory Bean
     */
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    /**
     * Creates transaction manager.
     *
     * @return transaction manager
     */
    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    /**
     * Automatic translation of exceptions to DAE.
     *
     * @return Persistence Exception Translation Processor
     */

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
