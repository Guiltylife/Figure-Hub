package com.example.zsgc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

@Configuration
public class WebMvcConf extends WebMvcConfigurerAdapter {

    public static final String separator = File.separator;

    @Value("${web.upload-path}")
    private String localPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //上传的图片在F盘下的ImgStore目录下，访问路径如：http://localhost:2333/ImgStore/img.jpg
        //其中ImgStore表示访问的前缀。"file:F:/ImgStore/"是文件真实的存储路径
        registry.addResourceHandler("/ImgStore/**").addResourceLocations("file:" + localPath);
    }

}