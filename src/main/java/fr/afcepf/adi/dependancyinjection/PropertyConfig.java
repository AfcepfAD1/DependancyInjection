package fr.afcepf.adi.dependancyinjection;

import fr.afcepf.adi.dependancyinjection.exemplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties"})
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${afcepf.username}")
    String user;

    @Value("${afcepf.password}")
    String password;

    @Value("${afcepf.dburl}")
    String url;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(env.getProperty("JAVA_HOME"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setDburl(url);
        return fakeDataSource;
    }
}
