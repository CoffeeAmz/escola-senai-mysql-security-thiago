package com.senai.escola.Utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity // Habilita uso do @PreAuthorize nos controllers
public class SecurityConfig {

//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//
//                        .requestMatchers("/auth/**").permitAll()
//
//                        .requestMatchers("/aluno/**").hasAnyRole("admin", "professor")
//
//                        .requestMatchers("/professores/**").hasRole("admin")
//
//                        .anyRequest().authenticated());
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder PasswordEncoder() {
//        return new BCryptPasswordEncoder();
//
//    }
}

    //Depois que testar e funcionar, VOLTE para a configuração segura
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Rotas públicas (exemplo: login, cadastro, arquivos estáticos)
                        .requestMatchers("/", "/index.html", "/static/**", "/auth/**", "/login.html").permitAll()

                        // Permissões específicas
                        .requestMatchers("/aluno/**").hasAnyRole("ADMIN", "PROFESSOR")
                        .requestMatchers("/professores/**").hasAnyRole("ADMIN")

                        // Qualquer outra rota precisa de autenticação
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login.html")
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );

        return httpSecurity.build();
    }


