package com.nav.shopcart.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {


    public JerseyConfig(){
        packages("com.nav.shopcart.rest");
    }


}
