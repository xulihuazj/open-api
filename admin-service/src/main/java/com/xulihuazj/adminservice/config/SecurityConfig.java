package com.xulihuazj.adminservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 允许登录页访问
        httpSecurity.formLogin().loginPage("/login.html").loginProcessingUrl("/login")
                .permitAll();
        httpSecurity.logout().logoutUrl("/logout");
        // 取消csrf安全验证
        httpSecurity.csrf().disable();
        // 允许对登录页及静态资源的访问
        httpSecurity.authorizeRequests().antMatchers("/login.html", "/**/*.css",
                "/img/**", "/third-party/**").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/**").authenticated();
        httpSecurity.httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder.inMemoryAuthentication().withUser("admin")
                .password("123456").roles(("USER"));
    }


}
