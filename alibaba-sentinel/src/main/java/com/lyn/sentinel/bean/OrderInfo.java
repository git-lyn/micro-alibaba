package com.lyn.sentinel.bean;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2021-04-04 18:37
 **/
public class OrderInfo {
    private int id;
    private Integer pay;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
