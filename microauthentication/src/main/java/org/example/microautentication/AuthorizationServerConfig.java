package org.example.microautentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;

@Configuration
public class AuthorizationServerConfig {
    @Bean
    @Profile("!docker")  // default profile (when NOT docker)
    public AuthorizationServerSettings authorizationServerSettingsDefault(@Value("${jwt.issuer}") String issuer) {
        return AuthorizationServerSettings.builder()
                .issuer(issuer)
                .build();
    }

    @Bean
    @Profile("docker")  // docker profile only
    public AuthorizationServerSettings authorizationServerSettingsDocker(@Value("${jwt.issuer}") String issuer) {
        return AuthorizationServerSettings.builder()
                .issuer(issuer)
                .build();
    }
}
