package cz.muni.fi.pa165.web.config;

import cz.muni.fi.pa165.sampledata.SampleDataConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Web config
 *
 * @author Ivo Hradek
 */
@EnableWebMvc
@Configuration
@Import(SampleDataConfiguration.class)
@ComponentScan("cz.muni.fi.pa165.web.controllers")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * Configure a JSP view resolver
     *
     * @return ViewResolver
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * Add resource folder.
     *
     * @param registry - resource handler
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");
    }

    /**
     *  Configure static content handling
     *
     *  @return void
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
