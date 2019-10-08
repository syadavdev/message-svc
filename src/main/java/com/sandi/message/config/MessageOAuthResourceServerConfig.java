package com.sandi.message.config;

import com.sandi.commonsvc.config.OAuthResourceServerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MessageOAuthResourceServerConfig extends OAuthResourceServerConfig {
}
