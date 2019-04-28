package com.shiyanlou.lesson2.domain;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author :Handoking
 * @date : 2019/4/26
 */
public class Account {
    @JsonInclude
    //只有在非null的情况下才序列化
    private int id;
    // 用户名
    @JsonProperty("name")
    //将该注解添加在 java 类的某个属性上，实现属性重命名
    private String username;
    //密码
    private String passwd;
    // 账户创建创建时间，格式化时间
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss", locale="zh", timezone="GMT+8")
    //将该注解添加在 java 类的时间、日期这类属性上，实现这类字段的格式化
    private Date date;

    public Account() {
        super();
    }
    public Account(int id, String username, String passwd, Date date) {
        this.id = id;
        this.username = username;
        this.passwd = passwd;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    @JsonIgnore
    // 向前端返回响应数据的时候，忽略password，该属性不参加序列化，防止泄露密码
    public String getPasswd() {
        return passwd;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @JsonProperty
    // 将该注解添加在 java 类的某个属性上，实现属性重命名
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Account [id=" + id + ", username=" + username + ", password=" + passwd + ", date=" + date + "]";
    }
}
