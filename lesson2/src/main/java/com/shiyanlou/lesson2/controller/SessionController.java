package com.shiyanlou.lesson2.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson2.domain.ResultObject;

/**
 * @author :Handoking
 * @date : 2019/4/26
 * 会话控制器
 */

@RestController
@RequestMapping("session")
// 标注为返回json数据的controller，该类下的方法的URL前缀为/session
public class SessionController {
    // 功能为创建session，设置session属性，指定请求方法类型为get、URL为/session/set
    @GetMapping("set")
    public ResultObject setSession(HttpServletRequest request){
        //获取session
        HttpSession session = request.getSession();
        //获取sessionId
        String sessionId = session.getId();
        System.out.println(sessionId);
        //设置session属性
        session.setAttribute("company","shiyanlou");
        return new ResultObject(null);
    }
    // 功能为获取session属性，指定请求方法类型为get、URL为/session/get
    @GetMapping("get")
    public ResultObject getSession(HttpServletRequest request){
        //若不存在则创建，存在的话获取session
        HttpSession session = request.getSession();
        //获取session属性
        String name = (String) request.getAttribute("company");
        //返回前端显示
        return new ResultObject(name);
    }
}
