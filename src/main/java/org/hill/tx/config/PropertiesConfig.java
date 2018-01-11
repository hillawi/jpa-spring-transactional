package org.hill.tx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Description : Load the application properties file.
 *
 * @author D-XF99NX
 * @since 10/05/2017
 */
@Configuration
@PropertySources({
        @PropertySource("app.properties")})
public class PropertiesConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
