package com.example.dcmatch_ssm_springboot.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Evan
 * @date 2019/4
 */

@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        //所有请求都允许跨域，使用这种配置方法就不能在 interceptor 中再配置 header 了
//        registry.addMapping("/**")
//                .allowCredentials(true)
//                .allowedOrigins("http://localhost:8999")
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                .allowedHeaders("*")
//                .maxAge(3600);
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //通过本地服务器访图片
        //访问地址 http://localhost:8999/api/file/student_id_card.jpg
        registry.addResourceHandler("/api/file/**")
                .addResourceLocations("file:" + "d:/workspace/img/dcmatch/");
    }

}
