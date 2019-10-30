package demo.csrf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
                .failureUrl("/login")

                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/transaction").hasRole("USER")

                .and()
                .logout()
                .logoutSuccessUrl("/login")

                .and()
                .exceptionHandling()
                .accessDeniedPage("/login")

                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password("{noop}password").roles("USER");
    }
}
