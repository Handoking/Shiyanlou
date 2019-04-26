package com.shiyanlou.calculator.controller;
//可以对类成员变量,方法及构造函数进行标注完成自动装配的工作,通过@Autowired来消除set,get方法
import org.springframework.beans.factory.annotation.Autowired; 
//用于将请求的URL中的模板变量映射到功能处理方法的参数上，即取出url模板中的变量作为参数
import org.springframework.web.bind.annotation.PathVariable;
//一个用来处理请求地址映射的注解,用于类或方法.用于类表示类中的所有响应请求的方法都是以地址
//作为父地址
import org.springframework.web.bind.annotation.RequestMapping;
//相当于@Controller和@responseBoby的组合效果
//@Controller标记类上,表示此类为MVC Controller对象分发处理器会扫描使用该类的方法并检测
//是否使用@RequestMapping注解
import org.springframework.web.bind.annotation.RestController;
import com.shiyanlou.calculator.domain.ResultObject;
import com.shiyanlou.calculator.service.CalculatorService;

@RestController
public class CalculatorController{
	//自动注入service
	@Autowired
	private CalculatorService sampleService;
	// 默认请求方法类型为get，URL：/compute/{operator}/{firstNum}/{secondNum}
      /**
     * 计算
     * @param operator 操作符
     * @param firstNum 第一个操作数
     * @param secondNum 第二个操作数
     * @return 响应结果
     */
	@RequestMapping("/compute/{operator}/{firstNum}/{secondNum}")
	 public ResultObject compute(@PathVariable String operator,
            @PathVariable double firstNum, @PathVariable double secondNum) {
        ResultObject resultObject = sampleService.compute(operator, firstNum, secondNum);
        return resultObject;
        //@PathVariable是用来获得请求url中的动态参数
    }
}
