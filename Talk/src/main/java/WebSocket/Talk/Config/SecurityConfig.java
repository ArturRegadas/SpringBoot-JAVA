package WebSocket.Talk.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeHttpRequests(auht -> auht
                        .requestMatchers("/api/getAllUsers", "/**").permitAll()
                        .anyRequest().authenticated()
                ).httpBasic();
        return http.build();
    }
}
