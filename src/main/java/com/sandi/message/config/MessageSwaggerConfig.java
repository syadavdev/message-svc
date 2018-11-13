package com.sandi.message.config;

import com.sandi.commonsvc.config.SwaggerConfig;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class MessageSwaggerConfig extends SwaggerConfig {

    @Override
    protected String getControllerPackage() {
        return "com.sandi.message.controller";
    }

    @Override
    protected String getTitle() {
        return "Message Service";
    }

    @Override
    protected String getDescription() {
        return "Message Api's";
    }

}