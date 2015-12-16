package cz.muni.fi.pa165.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Configuration of services.
 *
 * @author Ivo Hradek
 */
@Configuration
@Import(ApplicationContextPersistence.class)
@ComponentScan({"cz.muni.fi.pa165.service", "cz.muni.fi.pa165.facade"})
public class ServiceConfiguration {

    @Bean
    public Mapper dozer() {
        return new DozerBeanMapper();
    }

}

