package com.shiyanlou.calculator.serviceImpl;
import org.springframework.stereotype.Service;

import com.shiyanlou.calculator.domain.ResultObject;
import com.shiyanlou.calculator.service.CalculatorService;
/*
*author:handoking
*service实现类
*/
@Service
public class CalculatorServiceImpl implements CalculatorService {

      /**
     * 计算
     * @param operator 操作符
     * @param firstNum 第一个操作数
     * @param secondNum 第二个操作数
     * @return 响应结果
     */
    @Override
    public ResultObject compute(String operator, double firstNum, double secondNum) {
          // 结果
        double result = 0;
          // 返回码
        int code = 200;
          // 返回消息
        String msg = "";
          // 封装对象
        ResultObject resultObject;

          // 根据不同的操作符进行不同的操作
        switch (operator) {
        // 加
        case "add":
            result = firstNum + secondNum;
            break;
        // 减
        case "sub":
            result = firstNum - secondNum;
            break;
        // 除
        case "divide":
            // 除数为0，无法计算
            if (secondNum == 0) {
                msg = "被除数不能为0";
                code = -1;
                break;
            } else {
                result = firstNum / secondNum;
            }
            break;
        // 乘
        case "mul":
            result = firstNum * secondNum;
            break;

        // 未知的操作符，无法计算
        default:
            msg = "Wrong Operator";
            code = -1;
            break;
        }
        // 返回结果
        resultObject = new ResultObject(result, code, msg);
        return resultObject;
    }
}
