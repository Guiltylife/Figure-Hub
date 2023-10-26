package com.example.zsgc.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.zsgc.entity.User;
import com.example.zsgc.mapper.UserMapper;
import com.example.zsgc.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if(token != null){
            boolean result = TokenUtil.verify(token);
            String username = TokenUtil.getUsername(token);
//            System.out.println(username);
            User user = userMapper.findUserByName(username);
//            System.out.println("user:\t" + user);
//            System.out.println("token:\t" + token);
//            System.out.println("user token:\t" + user.getToken());
            if(result && token.equals(user.getToken())){ // token没过期 并且 用户没有主动退出
                System.out.println("通过拦截器");
                return true;
            } else if (!result) { // 说明此时token已经过期
                user.setToken("");
                userMapper.updateToken(user);
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try{
            JSONObject json = new JSONObject();
            json.put("msg","token verify fail");
            json.put("code","50000");
            response.getWriter().append(json.toJSONString());
            System.out.println("认证失败，未通过拦截器");
        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }
}