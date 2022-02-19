package com.lyn.bean;

/**
 * @program: projects
 * @author: lyn
 * * @create: 2020-09-03 21:43
 **/
public class ResultInfo {
    private String msg;
    private int num;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "msg='" + msg + '\'' +
                ", num=" + num +
                '}';
    }
}
