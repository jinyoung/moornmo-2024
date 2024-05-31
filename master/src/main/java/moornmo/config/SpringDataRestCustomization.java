package moornmo.config;

import org.apache.tomcat.jni.User;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import moornmo.domain.Company;

@Configuration
public class SpringDataRestCustomization implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Company.class, Item.class, User.class);
    }
}