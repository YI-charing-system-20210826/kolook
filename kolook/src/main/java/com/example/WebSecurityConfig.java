package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.kolook.customer.domain.service.CustomerService;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomerService userService;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/login","login-error").permitAll()//ログイン画面は誰でもアクセスできるよ
		.antMatchers("/top").hasRole("MANAGER")//管理者権限ないとトップ行けないよ
		/**
		 * @version 1.0
		 * 他のurlに遷移する時の権限の有無を確認出来る部分（テスト時はコメントアウト）
		 */
//		.antMatchers("/list").hasRole("MANAGER")
//		.antMatchers("/employeeDetail/**").hasRole("MANAGER")
//		.antMatchers("/edit").hasRole("ADMIN")
//		.antMatchers("/register").hasRole("ADMIN")
		.and().logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login")
		.and()
		.formLogin()
		.loginPage("/login").failureUrl("/login");//ログインに失敗した時のURL。ログイン画面で失敗だからそのままステイ？
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/**
		 * @version 1.0
		 * 権限設定　
		 */
				auth
		.userDetailsService(userService)
		.passwordEncoder(passwordEncoder());

	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
