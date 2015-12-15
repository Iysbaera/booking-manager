package cz.muni.fi.pa165.sampledata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
@ImportResource("classpath:application-context-service.xml")
@ComponentScan(basePackageClasses = { SampleDataLoadingFacadeImpl.class })
public class SampleDataConfiguration {

    @Autowired
    SampleDataLoadingFacadeImpl sampleDataLoadingFacade;

    @PostConstruct
    public void dataLoading() throws IOException {
        sampleDataLoadingFacade.loadData();
    }

}
