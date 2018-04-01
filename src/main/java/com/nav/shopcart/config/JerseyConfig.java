package com.nav.shopcart.config;

import com.nav.shopcart.rest.CategoryResource;
import com.nav.shopcart.rest.HomeResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        packages("com.nav.shopcart.rest");
    }
}
