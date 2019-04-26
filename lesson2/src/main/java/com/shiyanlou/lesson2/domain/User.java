package com.shiyanlou.lesson2.domain;

/**
 * @author :Handoking
 * @date : 2019/4/26
 * 封装用户的属性
 */
public class User {
    //id
    private int id;
    //年龄
    private int age;
    //性别 1:男；0：女
    private int gender;
    //姓名
    private String name;

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return "User[id = "+ id +",name = "+name+",age = "+ age +",gender = "+gender+"]";
    }
}
