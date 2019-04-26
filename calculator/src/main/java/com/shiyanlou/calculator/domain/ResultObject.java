package com.shiyanlou.calculator.domain;
/*
*用来封装后端返回的结果、错误原因、处理结果状态
*author:handoking
*/

public class ResultObject {

      // 计算结果
    private double result;
      // 返回码
    private int code;
      // 返回消息
    private String msg;

      // 构造函数
    public ResultObject() {
        super();
        // TODO Auto-generated constructor stub
    }

      // 构造函数
    public ResultObject(double result, int code, String msg) {
        super();
        this.result = result;
        this.code = code;
        this.msg = msg;
    }

      // 属性的getter、setter方法
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

      // 重写toString方法
    @Override
    public String toString() {
        return "ResultObject [result=" + result + ", code=" + code + ", msg=" + msg + "]";
    }
}
