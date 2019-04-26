package com.shiyanlou.lesson2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shiyanlou.lesson2.domain.Account;
import com.shiyanlou.lesson2.domain.ResultObject;

/**
 * @author :Handoking
 * @date : 2019/4/26
 * 账户控制器
 */
@RestController
//RestController被标记的类默认返回 json 数据
@RequestMapping("account")
//该类下的方法的URL前缀为account
public class AccountController {
    @PostMapping("add")
    // @PostMapping等于@RequestMapping(method = RequestMethod.POST)
    // 指定请求方法类型为post、URL为/account/add，从请求消息体中获取account对象，通过Jackson完成反序列化
    public ResultObject add(@RequestBody Account account) {
        //@RequestBody 从请求体中获取参数，一般在POST方法上传数据时使用
        System.out.println(account);
        // 将前端发送的account参数直接返回，观察id是否存在、username的名称、password是否存在、date的格式
        return new ResultObject(account);
    }
}
