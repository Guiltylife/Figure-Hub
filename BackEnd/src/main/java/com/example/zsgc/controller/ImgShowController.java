package com.example.zsgc.controller;

import com.example.zsgc.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class ImgShowController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public ImgShowController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 显示单张图片
     * @return
     */
    @RequestMapping("/showImg")
    public ResponseEntity showImg(String imgpath){
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            System.out.println(imgpath);
            return ResponseEntity.ok(resourceLoader.getResource("file:" + imgpath));
        } catch (Exception e) {
            System.out.println("____!___!___!_____");
            return ResponseEntity.notFound().build();
        }
    }
}