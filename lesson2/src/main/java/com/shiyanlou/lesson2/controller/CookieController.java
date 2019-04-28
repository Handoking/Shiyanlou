package com.shiyanlou.lesson2.controller;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson2.domain.ResultObject;
/**
 * @author :Handoking
 * @date : 2019/4/26
 * 实现cookie创建、携带、获取等功能
 */

@RestController
@RequestMapping("cookie")
// 标注为返回json数据的controller，该类下的方法的URL前缀为cookie
public class CookieController {
    @GetMapping("set")
    // 功能为设置cookie，返回给前端，指定请求方法类型为get、URL为/cookie/set
    public ResultObject setCookie(HttpServletResponse response) {
        // 获取当前时间
        String time = String.valueOf(System.currentTimeMillis());
        // 创建cookie，用来记录用户最近一次访问时间
        Cookie cookie = new Cookie("last", time);
        // 设置cookie过期时间，单位秒，当前例子为一个星期
        cookie.setMaxAge(60 * 60 * 24 * 7);
        // 将cookie添加到响应中
        response.addCookie(cookie);
        return new ResultObject(null);
    }
    @GetMapping("get")
    // 功能为为从前端请求中获取cookie，指定请求方法类型为get、URL为/cookie/set
    public ResultObject getCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for(Cookie cookie :cookies){
                if ("last".equals(cookie.getValue())){
                    System.out.println(cookie.getValue());
                    return new ResultObject(null);
                }
            }
        }
        return new ResultObject(-1,"get cookie fail");
    }
    // 功能为通过注解从前端请求中获取指定名称的cookie，指定请求方法类型为get、URL为/cookie/getByAnnotation
    @GetMapping("getByAnnotation")
    public ResultObject getCookieByAnnotation(@CookieValue("last")String last){
        System.out.println(last);
        return new ResultObject(null);
    }
}
