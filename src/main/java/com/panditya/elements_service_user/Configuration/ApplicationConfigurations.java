package com.panditya.elements_service_user.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfigurations {
    
    static final Print print = new Print();
    
    @Bean
    public Print getPrint(){
        return print;
    }

}
