package com.xiaobian.community.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**").excludePathPatterns("classpath:/static/","/index.html","/static/**");

    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
//    }

    //开启静态资源处理，不让dispatchServlet拦 截到
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//
//    }
}