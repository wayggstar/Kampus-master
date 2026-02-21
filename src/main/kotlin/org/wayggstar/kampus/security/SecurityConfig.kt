package org.wayggstar.kampus.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import kotlin.math.log

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/", "/login", "/register", "/css/**", "/js/**").permitAll()
                    .anyRequest().authenticated()
            }
            .formLogin { login ->
                login.loginPage("/login")
                    .defaultSuccessUrl("/main")
                    .permitAll()
            }
            .oauth2Login { oauth ->
                oauth.loginPage("/login")
                    .defaultSuccessUrl( "/main", true)
            }
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}