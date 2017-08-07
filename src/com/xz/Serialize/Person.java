package com.xz.Serialize;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/7.
 */
public class Person implements Serializable {
    private Integer id;
    private String name;
    private String pwd;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public Integer getId() {

        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
