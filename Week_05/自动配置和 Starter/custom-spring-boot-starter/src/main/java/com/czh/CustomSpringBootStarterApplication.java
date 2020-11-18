package com.czh;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnResource(resources = "META-INF/spring.factories")
@ConditionalOnProperty(prefix = "custom", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(Student.class)
public class CustomSpringBootStarterApplication {

    @Bean
    public ISchool school() {
        return new School();
    }

    @Bean
    public Klass klass() {
        return new Klass();
    }

}
