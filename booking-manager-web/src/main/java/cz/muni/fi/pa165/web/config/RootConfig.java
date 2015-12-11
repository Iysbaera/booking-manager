package cz.muni.fi.pa165.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Root config
 *
 * @author Ivo Hradek
 */
@Configuration
@ComponentScan(basePackages = { "cz.muni.fi.pa165" },
    excludeFilters = {
            @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
    })
public class RootConfig {
}
