package com.blueeye.coffee_shop.config;

import com.blueeye.coffee_shop.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
            configure->configure.requestMatchers("/quan-tri/**").hasRole("ADMIN")
                                .anyRequest().permitAll()
        ).formLogin(
                form->form.loginPage("/dang-nhap")
                        .loginProcessingUrl("/authenticateTheUser")
                        .defaultSuccessUrl("/trang-chu")
                        .permitAll()
        ).logout(
                logout->logout.logoutSuccessUrl("/trang-chu")
                              .permitAll()

        );
        return http.build();
    }

}
