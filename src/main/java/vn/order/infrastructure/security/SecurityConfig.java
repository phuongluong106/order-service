package vn.order.infrastructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	
	@Autowired
    private CustomAuthenticationProvider authProvider;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http
         .csrf().disable()
         .authorizeRequests()
                .antMatchers("/api/actuator/**").permitAll()
         	.antMatchers("/api/**").authenticated()
         .and()
         .httpBasic()
         .and().cors();
    }
  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    	auth.authenticationProvider(authProvider);
    }
}
