package com.shiyanlou.lesson2.domain;

/**
 * @author :Handoking
 * @date : 2019/4/26
 * 封装返回的结果，状态码，消息等
 */
public class ResultObject {
    //状态返回码
    private int code;
    //返回信息
    private String msg;
    //结果
    private Object result;

    public ResultObject(int code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public ResultObject(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.result = null;
    }

    public ResultObject(Object result) {
        this.result = result;
        this.code = 0;
        this.msg = "success";
    }

    public ResultObject() {
        super();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getResult() {
        return result;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(Object result) {
        this.result = result;
    }
    @Override
    public String toString(){
        return "ResultObject[code = "+ code +",msg = "+ msg +",result = "+ result +"]";
    }
}
