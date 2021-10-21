//package com.nowcoder.community.config;
//
//import com.nowcoder.community.util.CommunityConstant;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter implements CommunityConstant {
//    //忽略对静态资源的拦截
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resource/**");
//    }
//
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //授权
//        http.authorizeRequests()
//                .antMatchers(
//                        "/user/setting",
//                        "/user/upload",
//                        "/discuss/add",
//                        "/comment/add/**",
//                        "/letter/**",
//                        "/notice/**",
//                        "/like",
//                        "follow",
//                        "/unfollow"
//                )
//                .hasAnyAuthority(
//                        AUTHORITY_ADMIN,
//                        AUTHORITY_USER,
//                        AUTHORITY_MODERATOR
//                )
//                .anyRequest().permitAll();
//        //权限不够咋整
//        http.exceptionHandling()
//                .authenticationEntryPoint(new AuthenticationEntryPoint() {/*没有登陆*/
//                    @Override
//                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
//                        String xRequestedWith = request.getHeader("x-requested-with");
//                        if("XMLHttpRequest".equals(xRequestedWith)){//异步请求
//                            response
//                        }else{//同步请求
//
//                        }
//                    }
//                })
//                .accessDeniedHandler(new AccessDeniedHandler() {/*登陆了权限不足*/
//                    @Override
//                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
//
//                    }
//                })
//    }
//}
