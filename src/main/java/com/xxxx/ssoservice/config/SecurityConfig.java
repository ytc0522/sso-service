package com.xxxx.ssoservice.config;

import com.xxxx.ssoservice.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 登录配置
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login")   // 自定义登录接口
                .loginPage("/login.html")       // 自定义登录页面
                //.successForwardUrl("/toMain")   // 登录成功跳转,POST
                //.defaultSuccessUrl(new,true) // 这个可以跳转到第三方页面
                .successHandler(new MyAuthenticationSuccessHandler())
                .failureForwardUrl("/login.html");  // 登录失败跳转

        // 认证配置
        http.authorizeRequests()
                .antMatchers("/login.html").permitAll() // 登录页面不需要认证
                .anyRequest().authenticated();

        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


}
