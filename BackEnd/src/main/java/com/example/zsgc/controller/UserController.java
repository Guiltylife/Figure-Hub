package com.example.zsgc.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.zsgc.entity.Result;
import com.example.zsgc.entity.User;
import com.example.zsgc.mapper.UserMapper;
import com.example.zsgc.utils.FileNameUtils;
import com.example.zsgc.utils.FileUtils;
import com.example.zsgc.utils.TokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController{

    private final ResourceLoader resourceLoader;

    @Autowired
    public UserController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Autowired
    private UserMapper userMapper;

    @Value("${web.upload-path}")
    private String localPath;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result<User> login(User user) {
        Result<User> result = new Result<>();
        result.setSuccess(false);
        result.setDetail(null);
        result.setToken(null);
        try {
            String username= userMapper.login(user);
            if(username == null){
                result.setMsg("用户名或密码错误");
            } else {
                user = userMapper.findUserByName(user.getUsername());
                String token = TokenUtil.sign(user);
                user.setToken(token);
                userMapper.updateToken(user);
                result.setMsg("登录成功");
                result.setSuccess(true);
                result.setDetail(user);
                result.setToken(token);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ResponseBody
    public Result<User> logout(HttpServletRequest request) {
        Result<User> result = new Result<>();
        String token = request.getHeader("token");
        String username = TokenUtil.getUsername(token);
        User user = userMapper.findUserByName(username);
        user.setToken("");
        userMapper.updateToken(user);
        result.setMsg("用户" + username + "已退出登录");
        result.setSuccess(true);
        result.setToken(token);
        result.setDetail(user);
        return result;
    }

    @RequestMapping(value = "/updateImg",method = RequestMethod.PUT)
    @ResponseBody
    public Result updateImg(@RequestParam("fileName") MultipartFile imgfile, HttpServletRequest request)
    {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        result.setToken(null);
        String token = request.getHeader("token");
        String username = TokenUtil.getUsername(token);
        User user = userMapper.findUserByName(username);
        user.setImgpath(imgfile.getOriginalFilename());
        //user.setImgpath(localPath + FileNameUtils.getFileName(imgfile.getOriginalFilename()));
        if (FileUtils.upload(imgfile, localPath, imgfile.getOriginalFilename())) {
            result.setSuccess(true);
            result.setDetail(user);
            result.setToken(token);
            result.setMsg("头像更新成功");
        }
        else result.setMsg("头像更新失败");
        userMapper.updateImgPath(user);
        return result;
    }

//    @RequestMapping("/showImg")
//    public ResponseEntity showImg(HttpServletRequest request){
//        try {
//            String token = request.getHeader("token");
//            String username = TokenUtil.getUsername(token);
//            User user = userMapper.findUserByName(username);
//            String imgpath = user.getImgpath();
//            System.out.println("file:" + imgpath);
//            // 由于是读取本机的文件，file是一定要加上的
//            return ResponseEntity.ok(resourceLoader.getResource("file:" + imgpath));
//        } catch (Exception e) {
//            System.out.println("----------------------!!!");
//            return ResponseEntity.notFound().build();
//        }
//    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Result<User> register(User user, @RequestParam("fileName") MultipartFile imgfile) {
        Result<User> result = new Result<>();
        result.setSuccess(false);
        result.setDetail(null);
        result.setToken(null);
        try {
            User existUser = userMapper.findUserByName(user.getUsername());
            if(existUser != null){
                result.setMsg("用户名已存在");
            } else{
                String token = TokenUtil.sign(user);
                user.setToken(token);
                FileUtils.upload(imgfile, localPath, imgfile.getOriginalFilename());
                user.setImgpath(imgfile.getOriginalFilename());
                userMapper.register(user);
                result.setMsg("注册成功");
                result.setSuccess(true);
                result.setDetail(user);
                result.setToken(token);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/selectByUsername",method = RequestMethod.GET)
    public User selectByUsername(String username) {
        return userMapper.findUserByName(username);
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
