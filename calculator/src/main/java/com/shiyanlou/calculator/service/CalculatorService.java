package com.shiyanlou.calculator.service;
/**
*author:handoking
*定义计算器的业务接口以及计算方法
*/

import com.shiyanlou.calculator.domain.ResultObject;
// service接口
public interface CalculatorService {
    /**
     * 计算
     * @param operator 操作符
     * @param firstNum 第一个操作数
     * @param secondNum 第二个操作数
     * @return 响应结果
     */
    public ResultObject compute(String operator, double firstNum, double secondNum);
}
