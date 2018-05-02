package com.sinfeeloo.inventory.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Value("${allowedOrigin}")
    private String allowedOrigin = "*";

    @Value("${win.image.dir}")
    private String winGallery;

    @Value("${linux.image.dir}")
    private String linuxGallery;

    @Value("${remote.image.path}")
    private String remotePath;


    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin(allowedOrigin); // 1
        corsConfiguration.addAllowedHeader("token"); // 2
        corsConfiguration.addAllowedMethod("*"); // 3
        corsConfiguration.setMaxAge(86400L);//跨域缓存时间
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }


    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize("2MB");
        //设置总上传数据总大小
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //上传的图片在F盘下的/images/tmp目录下，访问路径如：http://localhost:8081/images/tmp/d3cf0281-bb7f-40e0-ab77-406db95ccf2c.jpg
        //其中OTA表示访问的前缀。"file:F:/images/tmp/"是文件真实的存储路径
        registry.addResourceHandler(remotePath+"**").addResourceLocations("file:" + getGalleryPath());
    }


    public String getGalleryPath() {
        String osname = System.getProperty("os.name");
        String galleryPath = null;
        if (osname.startsWith("Windows")) {
            // 在 Windows 操作系统上
            galleryPath = winGallery;
        } else if (osname.startsWith("Linux")) {
            // 在 Linux 操作系统上
            galleryPath = linuxGallery;
        }
        return galleryPath;
    }
}